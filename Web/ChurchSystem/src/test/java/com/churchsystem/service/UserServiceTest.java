package com.churchsystem.service;

import com.churchsystem.entity.InteractionEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.model.interfaces.UserModelInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/22/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @InjectMocks
    UserService userService = new UserService();

    @Mock
    UserModelInterface userModelInterface;

    @Test
    public void getUserByAccountId() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setAccountId("hungmc_user");
        Mockito.when(userModelInterface.getUserByAccountId("hungmc_user")).thenReturn(userEntity);
        assertEquals(userService.getUserByAccountId("hungmc_user"), userEntity);
    }

    @Test
    public void getUserByUserId() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(1);
        Mockito.when(userModelInterface.getUserByUserId(1)).thenReturn(userEntity);
        assertEquals(userService.getUserByUserId(1), userEntity);
    }

    @Test
    public void getUserByAccountIdAndPassword() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setAccountId("hungmc_user");
        userEntity.setPassword("Abcd1234");
        Mockito.when(userModelInterface.getUserByAccountIdAndPassword("hungmc_user", "Abcd1234")).thenReturn(userEntity);
        assertEquals(userService.getUserByAccountIdAndPassword("hungmc_user", "Abcd1234"), userEntity);
    }


    @Test
    public void getUserInteraction() throws Exception {
        InteractionEntity interactionEntity = new InteractionEntity();
        interactionEntity.setUserId(1);
        interactionEntity.setChurchId(1);
        Mockito.when(userModelInterface.getInteraction(1, 1)).thenReturn(interactionEntity);
        assertEquals(userService.getInteraction(1, 1), interactionEntity);

    }

    @Test
    public void getChurchIdByUserId() throws Exception {
    }

    @Test
    public void getSuitableConductorForSlot() throws Exception {

    }

    @Test
    public void getLastSuitableConductorForSlot() throws Exception {

    }

    @Test
    public void getListSuitableConductorForSlot() throws Exception {
    }

    @Test
    public void getIdListSuitableConductorForSlot() throws Exception {
    }

    @Test
    public void getListOfChurchFollower() throws Exception {
    }

    @Test
    public void getChurchManager() throws Exception {
    }

    @Test
    public void getAllPriest() throws Exception {
    }

    @Test
    public void getEventRegisteredUserAccount() throws Exception {
    }

    @Test
    public void getPriestByAccountId() throws Exception {
    }

    @Test
    public void getFollowingChurch() throws Exception {
    }

    @Test
    public void getInteraction() throws Exception {
    }

    @Test
    public void getAllRegistrationByUserId() throws Exception {
    }

}