package com.churchsystem.model.interfaces;

import com.churchsystem.entity.UserEntity;

/**
 * Created by hungmcse61561-admin on 6/13/2017.
 */
public interface UserModelInterface {
    UserEntity getUserByAccountId(String accountId);
    int getChurchIdByUserId(int userId);
}
