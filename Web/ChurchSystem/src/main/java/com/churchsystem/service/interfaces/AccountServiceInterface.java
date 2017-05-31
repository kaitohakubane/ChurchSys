package com.sneakergo.service.interfaces;

import com.sneakergo.entity.AccountEntity;

/**
 * Created by Hung on 11/21/2016.
 */
public interface AccountServiceInterface {

    AccountEntity getAccountByID(String accountID);

    boolean updateAccount(AccountEntity accountEntity);

    boolean createAccount(AccountEntity accountEntity);

    AccountEntity checkLogin(String accountID, String password);
}
