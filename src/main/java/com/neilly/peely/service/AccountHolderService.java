package com.neilly.peely.service;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.AccountHolderDetails;

import java.util.List;
import java.util.Optional;

public interface AccountHolderService {
    List<AccountHolder> getAllAccounts();
    void createAccountHolder(AccountHolder accountHolder);
    void deleteAccountHolderById(Long id);
    Optional<AccountHolder> getByUsername(String username);
    AccountHolder getByEmail(String email);
    Optional<AccountHolder> getById(Long id);
    AccountHolderDetails loadUserByUsername(String username);



}
