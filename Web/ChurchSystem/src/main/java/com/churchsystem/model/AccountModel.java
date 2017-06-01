//package com.churchsystem.model;
//
//import com.churchsystem.entity.AccountEntity;
//import com.churchsystem.model.common.CommonDAO;
//import com.churchsystem.model.interfaces.AccountModelInterface;
//import org.springframework.stereotype.Repository;
//
///**
// * Created by Hung on 11/17/2016.
// */
//@Repository
//public class AccountModel extends CommonDAO implements AccountModelInterface {
//
//    @Override
//    public AccountEntity getAccountByID(String accountID) {
//        AccountEntity accountEntity = getSession().get(AccountEntity.class, accountID);
//        return accountEntity;
//    }
//
//    @Override
//    public boolean updateAccount(AccountEntity accountEntity) {
//        if (getAccountByID(accountEntity.getAccountId()) != null) {
//            getSession().merge(accountEntity);
//            getSession().saveOrUpdate(accountEntity);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean createAccount(AccountEntity accountEntity) {
//        if (getAccountByID(accountEntity.getAccountId()) == null) {
//            getSession().persist(accountEntity);
//            return true;
//        }
//        return false;
//    }
//}
