package com.neilly.peely.controller;

import com.neilly.peely.model.AccountHolderDTO;

import java.security.Principal;

public interface AccountHolderController {
    void addAccount(AccountHolderDTO accountHolder);
    void deleteAccountById(Long id);
    void sendResetPasswordToken(String userEmail);
    void resetPassword(String email, String username, String passwordResetToken, String newPassword);
    boolean user(Principal user);
}
