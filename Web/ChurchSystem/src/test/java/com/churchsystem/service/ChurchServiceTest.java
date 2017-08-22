package com.churchsystem.service;

import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.ChurchInfoEntity;
import com.churchsystem.entity.ChurchMapEntity;
import com.churchsystem.model.interfaces.ChurchModelInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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
    public ChurchEntity setTestChurchEntity(int churchId, String name){
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
        setTestChurchEntity(1,"abc");
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

    }

    @Test
    public void getSettingOfChurch() throws Exception {
    }

    @Test
    public void editSetting() throws Exception {
    }

    @Test
    public void getIncomingEventByChurchId() throws Exception {
    }

    @Test
    public void getIncomingClassByChurchId() throws Exception {
    }

    @Test
    public void createChurch() throws Exception {
    }

}