package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.utils.StringUtils;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.EventDataEntity;
import com.churchsystem.entity.IncomingEventEntity;
import com.churchsystem.entity.UserEntity;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.churchsystem.service.interfaces.EventServiceInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by hungmcse61561-admin on 8/7/2017.
 */
@Controller
public class MobileController {
    @Autowired
    ChurchServiceInterface churchServiceInterface;
    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    EventServiceInterface eventServiceInterface;

    @ResponseBody
    @RequestMapping(value = PageConstant.MOBILE_LOGIN_URL, method = RequestMethod.POST)
    public UserEntity addNewPriest(@RequestParam(value = ParamConstant.ACCOUNT_ID) String accountId,
                                   @RequestParam(value = ParamConstant.PASSWORD) String password) {
        try {
            UserEntity result = userServiceInterface.getUserByAccountId(accountId);
            boolean compare = StringUtils.matchPassword(password, result.getPassword());
            if (compare) {
                return result;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @ResponseBody
    @RequestMapping(value = PageConstant.MOBILE_GET_FOLLOWING_CHURCH, method = RequestMethod.POST)
    public List<ChurchEntity> getFollowingChurch(@RequestParam(value = ParamConstant.USER_ID) String userIdStr) {
        try {
            int userId = Integer.parseInt(userIdStr);
            List<ChurchEntity> result = userServiceInterface.getFollowingChurch(userId);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.MOBILE_GET_USER_EVENT, method = RequestMethod.POST)
    public List<IncomingEventEntity> getIncomingEvent(@RequestParam(value = ParamConstant.USER_ID) String userIdStr) {
        try {
            int userId = Integer.parseInt(userIdStr);
            List<IncomingEventEntity> result = churchServiceInterface.getIncomingEvent(userId);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.MOBILE_GET_CHURCH_EVENT, method = RequestMethod.POST)
    public List<EventDataEntity> getChurchIncomingEvent(@RequestParam(value = ParamConstant.CHURCH_ID) String churchIdStr) {
        try {
            int churchId=Integer.parseInt(churchIdStr);
            List<EventDataEntity> result = eventServiceInterface.getListOfEventData(churchId);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
