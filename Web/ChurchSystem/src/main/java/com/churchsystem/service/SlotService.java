package com.churchsystem.service;

import com.churchsystem.entity.SlothourEntity;
import com.churchsystem.model.interfaces.SlotModelInterface;
import com.churchsystem.service.interfaces.SlotServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/19/2017.
 */
@Service
@Transactional
public class SlotService implements SlotServiceInterface {
    @Autowired
    SlotModelInterface slotModelInterface;

    public List<SlothourEntity> getListOfSlotHour(){
        return slotModelInterface.getListOfSlotHour();
    }
}
