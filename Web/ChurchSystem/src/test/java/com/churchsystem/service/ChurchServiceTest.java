package com.churchsystem.service;

import com.churchsystem.entity.*;
import com.churchsystem.model.interfaces.ChurchModelInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/21/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class ChurchServiceTest {
    @InjectMocks
    ChurchService churchService = new ChurchService();

    @Mock
    ChurchModelInterface churchModelInterface;

    public ChurchEntity testChurchEntity = new ChurchEntity();

    public ChurchEntity setTestChurchEntity(int churchId, String name) {
        testChurchEntity.setChurchId(churchId);
        testChurchEntity.setChurchName(name);
        return testChurchEntity;
    }

    @Test
    public void getChurchById() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setChurchId(1);
        Mockito.when(churchModelInterface.getChurchById(1)).thenReturn(churchEntity);
        assertEquals(churchService.getChurchById(1), churchEntity);
    }

    @Test
    public void updateChurch() throws Exception {
        ChurchEntity churchEntity = new ChurchEntity();
        churchEntity.setChurchId(1);
        Mockito.when(churchModelInterface.getChurchById(1)).thenReturn(churchEntity);
        setTestChurchEntity(1, "abc");
        churchEntity.setChurchName("abc");
        churchEntity.setStreamName("123");
        churchEntity.setStreamLink("www.youtube.com");
        churchEntity.setDescription("abc");
        //Mockito.when(churchModelInterface.updateChurch(churchEntity)).thenReturn(churchEntity);
        churchModelInterface.updateChurch(churchEntity);
        assertNotEquals(testChurchEntity, churchEntity);
    }

    @Test
    public void getChurchInfo() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setChurchId(1);
        Mockito.when(churchModelInterface.getChurchInfo(1)).thenReturn(churchInfoEntity);
        assertEquals(churchService.getChurchInfo(1), churchInfoEntity);
    }

    @Test
    public void getNearbyChurch() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setChurchId(1);
        Mockito.when(churchModelInterface.getChurchInfo(1)).thenReturn(churchInfoEntity);
        assertEquals(churchService.getChurchInfo(1), churchInfoEntity);
    }

    @Test
    public void getAllChurch() throws Exception {
        ChurchInfoEntity churchInfoEntity = new ChurchInfoEntity();
        churchInfoEntity.setChurchId(1);
        Mockito.when(churchModelInterface.getChurchInfo(1)).thenReturn(churchInfoEntity);
        assertEquals(churchService.getChurchInfo(1), churchInfoEntity);
    }


    @Test
    public void getIncomingEvent() throws Exception {
        List<IncomingEventEntity> test = new ArrayList<IncomingEventEntity>();
        Mockito.when(churchModelInterface.getIncomingEvent(1)).thenReturn(test);
        assertNotNull(test);
    }

    @Test
    public void getSettingOfChurch() throws Exception {
        SettingEntity settingEntity = new SettingEntity();
        Mockito.when(churchModelInterface.getSettingOfChurch(1)).thenReturn(settingEntity);
        assertNotNull(settingEntity);
    }


    @Test
    public void getIncomingEventByChurchId() throws Exception {
        List<IncomingEventEntity> test = new ArrayList<IncomingEventEntity>();
        Mockito.when(churchModelInterface.getIncomingEvent(1)).thenReturn(test);
        assertNotNull(test);
    }

    @Test
    public void getIncomingClassByChurchId() throws Exception {
        List<IncomingClassEntity> test = new ArrayList<IncomingClassEntity>();
        Mockito.when(churchModelInterface.getIncomingClassByChurchId(1)).thenReturn(test);
        assertNotNull(test);
    }

    @Test
    public void editSetting() throws Exception {
    }

    @Test
    public void createChurch() throws Exception {
    }

}