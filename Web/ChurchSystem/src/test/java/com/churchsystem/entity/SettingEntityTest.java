package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung on 8/19/2017.
 */
public class SettingEntityTest {
    @Test
    public void getSettingId() throws Exception {
        SettingEntity settingEntity = new SettingEntity();
        settingEntity.setSettingId(1);
        assertEquals(1,settingEntity.getSettingId());
    }

    @Test
    public void getChurchId() throws Exception {
        SettingEntity settingEntity = new SettingEntity();
        settingEntity.setChurchId(1);
        assertEquals((Integer)1,settingEntity.getChurchId());
    }

    @Test
    public void getIsSync() throws Exception {
        SettingEntity settingEntity = new SettingEntity();
        settingEntity.setIsSync(1);
        assertEquals((Integer)1,settingEntity.getIsSync());
    }

    @Test
    public void getTheme() throws Exception {
        SettingEntity settingEntity = new SettingEntity();
        settingEntity.setTheme(1);
        assertEquals((Integer)1,settingEntity.getTheme());
    }

}