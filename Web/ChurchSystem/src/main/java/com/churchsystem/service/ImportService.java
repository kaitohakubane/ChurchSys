package com.sneakergo.service;

import com.sneakergo.entity.ImportDisplayEntity;
import com.sneakergo.entity.ImportEntity;
import com.sneakergo.model.interfaces.ImportModelInterface;
import com.sneakergo.service.interfaces.ImportServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * Created by Hung on 11/21/2016.
 */

@Service
@Transactional
public class ImportService implements ImportServiceInterface {
    @Autowired
    private ImportModelInterface importModelInterface;

    public void importProduct(ImportEntity importEntity) {
        importModelInterface.importProduct(importEntity);
    }

    public List<ImportEntity> getImportByStockId(int stockID) {
        return importModelInterface.getImportByStockId(stockID);
    }

    public List<ImportEntity> getImportFromTimeToTime(Date fromTime, Date toTime) {
        return importModelInterface.getImportFromTimeToTime(fromTime, toTime);
    }

    public List<ImportDisplayEntity> getImportByTime(Date fromTime, Date toTime){
        return importModelInterface.getImportByTime(fromTime,toTime);
    }

}
