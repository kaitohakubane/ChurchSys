package com.churchsystem.service.interfaces;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 6/1/2017.
 */
public interface RoomServiceInterface {
    List<RoomEntity> getRoomBySub(Integer subId);
}
