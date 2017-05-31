package com.sneakergo.model.interfaces;

import com.sneakergo.entity.AccountEntity;

/**
 * Created by Hung on 11/21/2016.
 */
public interface AccountModelInterface {

    AccountEntity getAccountByID(String accountID);

    boolean updateAccount(AccountEntity accountEntity);

    boolean createAccount(AccountEntity accountEntity);
}
