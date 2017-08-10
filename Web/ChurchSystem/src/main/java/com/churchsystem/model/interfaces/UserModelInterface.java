package com.churchsystem.model.interfaces;

import com.churchsystem.entity.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/13/2017.
 */
public interface UserModelInterface {
    UserEntity getUserByAccountId(String accountId);

    UserEntity getUserByUserId(int userId);

    int getChurchIdByUserId(int userId);

    Integer getSuitableConductorForSlot(int slotHourId, Date slotDate, int churchId, int subId);

    Integer getLastSuitableConductorForSlot(int slotHourId, Date slotDate, int churchId, int subId);

    List<UserEntity> getListSuitableConductorForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId, int subId);

    Integer checkConductorForSlot(int slotHourId, Date slotDate, int churchId, int conductorId, int subId);

    List<Integer> getIdListSuitableConductorForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId, int subId);

    List<UserEntity> getAllPriest(int churchId);

    List<Integer> getListOfChurchFollower(int churchId);

    Integer getChurchManager(int churchId);

    List<String> getEventRegisteredUserAccount(int eventId);

    void insertPriest(UserEntity userEntity);

    UserEntity getPriestByAccountId(String accountId);

    void mapUserToChurch(InteractionEntity InteractionEntity);

    void mapPriestWithSubject(AbilityEntity abilityEntity);

    List<InteractionEntity> getUserInteraction(int userId);

    List<ChurchEntity> getFollowingChurch(int userId);

    List getListSuitableConductorForSlotHour(int slotHourId, Date slotDate, int churchId, int subId);


    InteractionEntity getInteraction(int userId, int churchId);

    void updateInteraction(InteractionEntity interactionEntity);

    UserEntity getUserByAccountIdAndPassword(String accountId, String password);

    List<RegistrationEntity> getAllRegistrationByUserId(int userId);
}
