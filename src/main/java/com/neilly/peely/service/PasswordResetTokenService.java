package com.neilly.peely.service;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.PasswordResetToken;

public interface PasswordResetTokenService {

    void sendEmailWithPasswordResetToken(String email);
    PasswordResetToken createPasswordResetToken(AccountHolder persistentAccountHolder);
    boolean validateResetToken(String token);
    void updatePassword(String email, String username, String token, String passwordToUpdate);
}
