package com.churchsystem.service;

import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.AbilityEntity;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.InteractionEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.model.interfaces.UserModelInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

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
    public UserEntity getUserByUserId(int userId) {
        UserEntity userEntity = userModelInterface.getUserByUserId(userId);
        return userEntity;
    }

    @Override
    public int getChurchIdByUserId(int userId) {
        int result = userModelInterface.getChurchIdByUserId(userId);
        return result;
    }

    @Override
    public Integer getSuitableConductorForSlot(int slotHourId, Date slotDate, int churchId, int subId) {
        return userModelInterface.getSuitableConductorForSlot(slotHourId, slotDate, churchId, subId);
    }

    @Override
    public List<UserEntity> getListSuitableConductorForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId, int subId) {
        List<UserEntity> userEntities = (List<UserEntity>) userModelInterface
                .getListSuitableConductorForSlot(newStartTime, newEndTime, slotDate, churchId, subId);
        return userEntities;
    }

    @Override
    public Integer checkConductorForSlot(int slotHourId, Date slotDate, int churchId, int conductorId, int subId) {
        return userModelInterface.checkConductorForSlot(slotHourId, slotDate, churchId, conductorId, subId);
    }

    @Override
    public List<Integer> getIdListSuitableConductorForSlot(Time newStartTime, Time newEndTime, Date slotDate, int churchId, int subId) {
        return userModelInterface.getIdListSuitableConductorForSlot(newStartTime, newEndTime, slotDate, churchId, subId);
    }

    @Override
    public List<String> getListOfChurchFollower(int churchId) {
        return userModelInterface.getListOfChurchFollower(churchId);
    }

    @Override
    public String getChurchManagerAccount(int churchId) {
        return userModelInterface.getChurchManagerAccount(churchId);
    }

    @Override
    public List<UserEntity> getAllPriest(int churchId) {
        return userModelInterface.getAllPriest(churchId);
    }

    @Override
    public List<String> getEventRegisteredUserAccount(int eventId) {
        return userModelInterface.getEventRegisteredUserAccount(eventId);

    }

    @Override
    public void insertPriest(UserEntity userEntity) {
        userModelInterface.insertPriest(userEntity);
    }

    @Override
    public UserEntity getPriestByAccountId(String accountId) {
        return userModelInterface.getPriestByAccountId(accountId);
    }

    @Override
    public void mapUserToChurch(int userId, int churchId) {
        InteractionEntity interactionEntity = new InteractionEntity();
        interactionEntity.setUserId(userId);
        interactionEntity.setChurchId(churchId);
        interactionEntity.setEnabled(ParamConstant.DEFAULT_ENABLE);
        userModelInterface.mapUserToChurch(interactionEntity);
    }

    @Override
    public void mapPriestWithSubject(int userId, int subId) {
        AbilityEntity abilityEntity = new AbilityEntity();
        abilityEntity.setConductorId(userId);
        abilityEntity.setSubId(subId);
        userModelInterface.mapPriestWithSubject(abilityEntity);
    }

    @Override
    public List<InteractionEntity> getUserInteraction(int userId){
        return userModelInterface.getUserInteraction(userId);
    }

    @Override
    public List<ChurchEntity> getFollowingChurch(int userId){
        return userModelInterface.getFollowingChurch(userId);
    }
}
