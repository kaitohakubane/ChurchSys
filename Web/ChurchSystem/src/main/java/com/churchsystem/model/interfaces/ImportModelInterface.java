package com.sneakergo.model.interfaces;

import com.sneakergo.entity.ImportDisplayEntity;
import com.sneakergo.entity.ImportEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by Hung on 11/21/2016.
 */
public interface ImportModelInterface {

    void importProduct(ImportEntity importEntity);

    List<ImportEntity> getImportByStockId(int stockID);

    List<ImportEntity> getImportFromTimeToTime(Date fromTime, Date toTime);

    List<ImportDisplayEntity> getImportByTime(Date fromTime, Date toTime);
}
