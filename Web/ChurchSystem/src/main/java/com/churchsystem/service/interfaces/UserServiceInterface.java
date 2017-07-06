package com.churchsystem.service.interfaces;

import com.churchsystem.entity.UserEntity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/13/2017.
 */
public interface UserServiceInterface {
    UserEntity getUserByAccountId(String accountId);

    UserEntity getUserByUserId(int userId);

    int getChurchIdByUserId(int userId);

    Integer getSuitableConductorForSlot(int slotHourId, Date slotDate, int churchId);

    List<UserEntity> getListSuitableConductorForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId);

    Integer checkConductorForSlot(int slotHourId, Date slotDate, int churchId, int conductorId);
}
