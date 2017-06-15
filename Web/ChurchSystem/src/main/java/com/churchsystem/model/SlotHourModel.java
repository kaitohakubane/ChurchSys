package com.churchsystem.model;

import com.churchsystem.entity.SlothourEntity;
import com.churchsystem.model.common.CommonDAO;
import com.churchsystem.model.interfaces.SlotHourModelInterface;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mr Kiet on 06/15/17.
 */

@Repository
public class SlotHourModel extends CommonDAO implements SlotHourModelInterface {
    @Override
    public List<SlothourEntity> getAllSlotHour() {
        List<SlothourEntity> result = getSession().createCriteria(SlothourEntity.class).list();

        return result;
    }
}
