package com.churchsystem.service;

import com.churchsystem.entity.GraveDisplayEntity;
import com.churchsystem.entity.GraveEntity;
import com.churchsystem.entity.GraveyardEntity;
import com.churchsystem.model.interfaces.GraveModelInterface;
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
public class GraveServiceTest {
    @InjectMocks
    GraveService graveService = new GraveService();

    @Mock
    GraveModelInterface graveModelInterface;


    @Test
    public void getGraveYardById() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setGraveYardId(1);
        Mockito.when(graveModelInterface.getGraveYardById(1)).thenReturn(graveyardEntity);
        assertEquals(graveService.getGraveYardById(1), graveyardEntity);
    }

    @Test
    public void getGravebyId() throws Exception {
        GraveDisplayEntity graveDisplayEntity = new GraveDisplayEntity();
        graveDisplayEntity.setGraveYardId(1);
        Mockito.when(graveModelInterface.getGravebyId(1)).thenReturn(graveDisplayEntity);
        assertEquals(graveService.getGravebyId(1), graveDisplayEntity);
    }

    @Test
    public void getCreatingGrave() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setGraveYardId(1);
        graveEntity.setStatus(1);
        Mockito.when(graveModelInterface.getCreatingGrave(1, 1)).thenReturn(graveEntity);
        assertEquals(graveService.getCreatingGrave(1, 1), graveEntity);
    }


    @Test
    public void getGrave() throws Exception {
        GraveEntity graveEntity = new GraveEntity();
        graveEntity.setGraveId(1);
        Mockito.when(graveModelInterface.getGrave(1)).thenReturn(graveEntity);
        assertEquals(graveService.getGrave(1), graveEntity);
    }

    @Test
    public void getCreatingGraveYard() throws Exception {
        GraveyardEntity graveyardEntity = new GraveyardEntity();
        graveyardEntity.setChurchId(1);
        Mockito.when(graveModelInterface.getCreatingGraveYard(1)).thenReturn(graveyardEntity);
        assertEquals(graveService.getCreatingGraveYard(1), graveyardEntity);
    }

    @Test
    public void getGraveYardOfChurch() throws Exception {
    }

    @Test
    public void getChurchGrave() throws Exception {

    }

    @Test
    public void getGraveOfGraveYard() throws Exception {
    }
}