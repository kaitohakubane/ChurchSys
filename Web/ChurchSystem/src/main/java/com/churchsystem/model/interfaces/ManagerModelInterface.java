package com.churchsystem.model.interfaces;

import com.churchsystem.entity.ManagerRefEntity;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
public interface ManagerModelInterface {
    List<ManagerRefEntity> getManagerBySub(int subId);
}
