package com.sneakergo.model;

import com.sneakergo.entity.AccountEntity;
import com.sneakergo.model.common.CommonDAO;
import com.sneakergo.model.interfaces.AccountModelInterface;
import org.springframework.stereotype.Repository;

/**
 * Created by Hung on 11/17/2016.
 */
@Repository
public class AccountModel extends CommonDAO implements AccountModelInterface {

    @Override
    public AccountEntity getAccountByID(String accountID) {
        AccountEntity accountEntity = getSession().get(AccountEntity.class, accountID);
        return accountEntity;
    }

    @Override
    public boolean updateAccount(AccountEntity accountEntity) {
        if (getAccountByID(accountEntity.getAccountId()) != null) {
            getSession().merge(accountEntity);
            getSession().saveOrUpdate(accountEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean createAccount(AccountEntity accountEntity) {
        if (getAccountByID(accountEntity.getAccountId()) == null) {
            getSession().persist(accountEntity);
            return true;
        }
        return false;
    }
}
