package com.sneakergo.service;

import com.sneakergo.common.utils.StringUtils;
import com.sneakergo.entity.AccountEntity;
import com.sneakergo.model.interfaces.AccountModelInterface;
import com.sneakergo.service.interfaces.AccountServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hung on 11/21/2016.
 */
@Service
@Transactional
public class AccountService implements AccountServiceInterface {
    @Autowired
    AccountModelInterface accountModelInterface;

    @Override
    public AccountEntity getAccountByID(String accountID) {
        return accountModelInterface.getAccountByID(accountID);
    }

    @Override
    public boolean updateAccount(AccountEntity accountEntity) {
        return accountModelInterface.updateAccount(accountEntity);
    }

    @Override
    public boolean createAccount(AccountEntity accountEntity) {
        return accountModelInterface.createAccount(accountEntity);
    }

    @Override
    public AccountEntity checkLogin(String accountID,String password){
        AccountEntity accountEntity=accountModelInterface.getAccountByID(accountID);
        if(accountEntity!=null){
            if(StringUtils.matchPassword(password,accountEntity.getPassword())){
                return accountEntity;
            }
        }
        return null;
    }
}
