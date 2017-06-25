package com.churchsystem.service;

import com.churchsystem.entity.InteractionEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.model.interfaces.UserModelInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

/**
 * Created by hungmcse61561-admin on 6/13/2017.
 */
@Service
@Transactional
public class UserService implements UserServiceInterface {
    @Autowired
    UserModelInterface userModelInterface;

    @Override
    public UserEntity getUserByAccountId(String accountId) {
        UserEntity userEntity = userModelInterface.getUserByAccountId(accountId);
        return userEntity;
    }

    @Override
    public int getChurchIdByUserId(int userId) {
        int result = userModelInterface.getChurchIdByUserId(userId);
        return result;
    }

    @Override
    public Integer getSuitableConductorForSlot(int slotHourId, Date slotDate, int churchId) {
        return userModelInterface.getSuitableConductorForSlot(slotHourId, slotDate, churchId);
    }

    @Override
    public Integer checkConductorForSlot(int slotHourId, Date slotDate, int churchId, int conductorId) {
        return userModelInterface.checkConductorForSlot(slotHourId, slotDate, churchId, conductorId);
    }
}
