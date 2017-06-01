package com.churchsystem.service.interfaces;

import com.churchsystem.entity.ManagerRefEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
public interface ManagerServiceInterface {
    List<ManagerRefEntity> getManagerBySub(int subId);
}
