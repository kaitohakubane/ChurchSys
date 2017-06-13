package com.churchsystem.service.interfaces;

import com.churchsystem.entity.UserEntity;

/**
 * Created by hungmcse61561-admin on 6/13/2017.
 */
public interface UserServiceInterface {
    UserEntity getUserByAccountId(String accountId);
}
