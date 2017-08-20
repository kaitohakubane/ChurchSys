package com.churchsystem.entity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vongnlh on 8/19/2017.
 */
public class DashboardClassEntityTest {
    @Test
    public void getEventName() throws Exception {
        DashboardClassEntity dashboardClassEntity = new DashboardClassEntity();
        dashboardClassEntity.setEventName("ABCD");
        assertEquals("ABCD",dashboardClassEntity.getEventName());
    }

    @Test
    public void getChurchName() throws Exception {
        DashboardClassEntity dashboardClassEntity = new DashboardClassEntity();
        dashboardClassEntity.setChurchName("HoaKhanh");
        assertEquals("HoaKhanh", dashboardClassEntity.getChurchName());
    }

    @Test
    public void getStatus() throws Exception {
        DashboardClassEntity dashboardClassEntity = new DashboardClassEntity();
        dashboardClassEntity.setStatus(1);
        assertEquals(1,dashboardClassEntity.getStatus());
    }

    @Test
    public void getClassStatus() throws Exception {
        DashboardClassEntity dashboardClassEntity = new DashboardClassEntity();
        dashboardClassEntity.setStatus(4);
        assertEquals("Đã hoàn thành",dashboardClassEntity.getClassStatus());
    }

}