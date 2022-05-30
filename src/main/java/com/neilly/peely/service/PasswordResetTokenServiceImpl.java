/**
 * 
 */
package com.neilly.peely.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.neilly.peely.exception.PasswordResetTokenInvalidException;
import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.PasswordResetToken;
import com.neilly.peely.repository.AccountHolderRepository;
import com.neilly.peely.repository.PasswordResetTokenRepository;

/**
 * @author mcalv
 *
 */
@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService{

	public static final String PASSWORD_RESET_EMAIL_SUBJECT = "Password Reset Token";
	public static final int PASSWORD_RESET_TIMEOUT_HOURS = 1;

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Autowired
	private AccountHolderRepository accountHolderRepository;

	@Autowired
	private EmailService emailService;

	public void sendEmailWithPasswordResetToken(String email) {
		AccountHolder persistentAccountHolder = accountHolderRepository.findByEmail(email);
		if (null != persistentAccountHolder) {
			PasswordResetToken passwordResetToken = createPasswordResetToken(persistentAccountHolder);
			emailService.sendSimpleMessage(email, PASSWORD_RESET_EMAIL_SUBJECT, passwordResetToken.getToken());
		}
	}

	public PasswordResetToken createPasswordResetToken(AccountHolder persistentAccountHolder) {
		String token = UUID.randomUUID().toString();
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, PASSWORD_RESET_TIMEOUT_HOURS);
		PasswordResetToken passwordResetToken = new PasswordResetToken(token, persistentAccountHolder,
				calendar.getTime());

		passwordResetTokenRepository.save(passwordResetToken);

		return passwordResetToken;
	}

	public boolean validateResetToken(String token) {
		return null != passwordResetTokenRepository.findByToken(token);
	}

	public void updatePassword(String email, String username, String token, String passwordToUpdate) {
		if (!StringUtils.hasText(token)) {
			PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);

			if (Objects.nonNull(passwordResetToken)) {
				AccountHolder accountHolder = passwordResetToken.getAccountHolder();
				if (validateAccountHolderEmailAndUsername(accountHolder, email, username) && validatePasswordResetTokenIsValid(passwordResetToken)) {
					accountHolder.setPassword(passwordToUpdate);
					accountHolderRepository.save(accountHolder);;
				} else {
					throw new PasswordResetTokenInvalidException("Password Reset Token Invalid");
				}
			}

		}
	}

	public boolean validateAccountHolderEmailAndUsername(AccountHolder accountHolder, String email, String username) {

		return (accountHolder.getUsername().equals(username) && accountHolder.getEmail().equalsIgnoreCase(email));
	}

	public boolean validatePasswordResetTokenIsValid(PasswordResetToken passwordResetToken) {
		Date currentDate = new Date();

		return (passwordResetToken.getExpiryDate().after(currentDate));
	}

}
