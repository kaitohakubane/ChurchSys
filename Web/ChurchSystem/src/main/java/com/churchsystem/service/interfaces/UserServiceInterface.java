package com.churchsystem.service.interfaces;

import com.churchsystem.entity.UserEntity;

import java.sql.Date;

/**
 * Created by hungmcse61561-admin on 6/13/2017.
 */
public interface UserServiceInterface {
    UserEntity getUserByAccountId(String accountId);

    int getChurchIdByUserId(int userId);

    Integer getSuitableConductorForSlot(int slotHourId, Date slotDate, int churchId);

    Integer checkConductorForSlot(int slotHourId, Date slotDate, int churchId, int conductorId);
}
