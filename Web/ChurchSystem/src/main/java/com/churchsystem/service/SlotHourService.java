package com.churchsystem.service;

import com.churchsystem.entity.SlothourEntity;
import com.churchsystem.model.interfaces.SlotHourModelInterface;
import com.churchsystem.service.interfaces.SlotHourServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */

@Service
@Transactional
public class SlotHourService implements SlotHourServiceInterface{
    @Autowired
    SlotHourModelInterface slotHourModelInterface;

    public List<SlothourEntity> getAllSlotHour(){
        List<SlothourEntity> result = slotHourModelInterface.getAllSlotHour();
        return result;
    }
}
