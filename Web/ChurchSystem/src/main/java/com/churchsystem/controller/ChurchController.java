package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.StringUtils;
import com.churchsystem.entity.*;
import com.churchsystem.service.common.ChurchMailSender;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Mr Kiet on 06/14/17.
 */
@Controller
public class ChurchController {
    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    private JavaMailSenderImpl mailSenderService;

    @RequestMapping(value = PageConstant.CHURCH_HOME_URL, method = RequestMethod.GET)
    public ModelAndView loadPublicEventRegister(@RequestParam(value = ParamConstant.CHURCH_ID) String id) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchId);
            List<IncomingEventEntity> list = churchServiceInterface.getIncomingEventByChurchId(churchId);
            List<IncomingClassEntity> incomingClassEntities = churchServiceInterface.getIncomingClassByChurchId(churchId);
            if (churchEntity != null) {
                modelAndView = new ModelAndView(PageConstant.CHURCH_HOME_PAGE).addObject(ParamConstant.CHURCH_OBJECT, churchEntity)
                        .addObject(ParamConstant.INCOMING_EVENT, list).addObject(ParamConstant.INCOMING_CLASS, incomingClassEntities)
                        .addObject(ParamConstant.CHURCH_SETTING, settingEntity);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = PageConstant.CHURCH_SCHEDULE_URL, method = RequestMethod.GET)
    public ModelAndView loadSchedule(@RequestParam(value = ParamConstant.CHURCH_ID) String id) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            if (churchEntity != null) {
                SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchId);
                modelAndView = new ModelAndView(PageConstant.CHURCH_SCHEDULE_PAGE)
                        .addObject(ParamConstant.CHURCH_OBJECT, churchEntity).addObject(ParamConstant.CHURCH_SETTING, settingEntity);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.CHURCH_SEARCH_URL, method = RequestMethod.POST)
    public List<ChurchMapEntity> getNearbyChurch(@RequestParam(value = ParamConstant.INPUT_LATITUDE) String strLatitude,
                                                 @RequestParam(value = ParamConstant.INPUT_LONGITUDE) String strLongitude) {
        List<ChurchMapEntity> result = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());
        try {
            Double Latitude = Double.parseDouble(strLatitude);
            Double Longitude = Double.parseDouble(strLongitude);

            int radius = ParamConstant.DEFAULT_RADIUS;
            while (result == null && radius < ParamConstant.MAXIMUM_DISTANCE) {
                result = churchServiceInterface.getNearbyChurch(Latitude, Longitude, radius);
                if (result == null) {
                    radius = radius + ParamConstant.ADDITIONAL_DISTANCE;
                } else if (userEntity != null) {
                    List<InteractionEntity> followChurch = userServiceInterface.getUserInteraction(userEntity.getUserId());
                    if (followChurch.size() > 0) {
                        for (int i = 0; i < result.size(); i++) {
                            for (int k = 0; k < followChurch.size(); k++) {
                                if (result.get(i).getChurchId() == followChurch.get(k).getChurchId() &&
                                        followChurch.get(k).getEnabled()) {
                                    result.get(i).setIsFollowed(ParamConstant.IS_FOLLOWING);
                                }
                            }
                        }
                    }
                }
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
        return result;
    }

    @RequestMapping(value = PageConstant.CHURCH_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllChurch() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.CHURCH_MANAGEMENT_PAGE);
        List<ChurchDisplayEntity> churchDisplayEntities = churchServiceInterface.getAllChurch();
        modelAndView.addObject(ParamConstant.CHURCH_LIST, churchDisplayEntities);
        return modelAndView;
    }

    @RequestMapping(value = PageConstant.CHURCH_INFO_URL, method = RequestMethod.GET)
    public ModelAndView getIntroducePage(@RequestParam(value = ParamConstant.CHURCH_ID) String id) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            int churchId = Integer.parseInt(id);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            if (churchEntity != null) {
                SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchEntity.getChurchId());
                modelAndView = new ModelAndView(PageConstant.INTRODUCTION_PAGE)
                        .addObject(ParamConstant.CHURCH_INFORMATION, churchServiceInterface.getChurchInfo(churchId))
                        .addObject(ParamConstant.CHURCH_OBJECT, churchEntity).addObject(ParamConstant.CHURCH_SETTING, settingEntity);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }


    @RequestMapping(value = PageConstant.CHURCH_SETTING_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView getSettingPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchId);
            if (churchEntity != null) {
                modelAndView = new ModelAndView(PageConstant.CHURCH_SETTING_PAGE)
                        .addObject(ParamConstant.CHURCH_OBJECT, churchEntity);
            }
            if (settingEntity != null) {
                modelAndView.addObject(ParamConstant.CHURCH_SETTING, settingEntity);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.UPDATE_CHURCH_URL, method = RequestMethod.POST)
    public void updateChurch(@RequestParam(value = ParamConstant.CHURCH_NAME) String name,
                             @RequestParam(value = ParamConstant.CHURCH_ADDRESS) String address,
                             @RequestParam(value = ParamConstant.CHURCH_TEL) String tel,
                             @RequestParam(value = ParamConstant.CHURCH_MAIL) String mail,
                             @RequestParam(value = ParamConstant.CHURCH_DESCRIPTION) String des,
                             @RequestParam(value = ParamConstant.CHURCH_IS_SYNC) String sync,
                             @RequestParam(value = ParamConstant.CHURCH_THEME) String theme
            , HttpServletRequest request) {
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        try {
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            churchEntity.setChurchName(name);
            churchEntity.setAddress(address);
            churchEntity.setTel(tel);
            churchEntity.setDescription(des);
            churchEntity.setMail(mail);
            churchServiceInterface.updateChurch(churchEntity);
            int isSync = Integer.parseInt(sync);
            int themeInt = Integer.parseInt(theme);
            churchServiceInterface.editSetting(churchId, isSync, themeInt);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping(value = PageConstant.ADD_CHURCH_URL, method = RequestMethod.GET)
    public ModelAndView addChurch() {
        ModelAndView modelAndView = new ModelAndView(PageConstant.ADD_CHURCH_PAGE);
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.CREATE_CHURCH_URL, method = RequestMethod.POST)
    public void createChurch(@RequestParam(value = ParamConstant.CHURCH_NAME) String name,
                             @RequestParam(value = ParamConstant.CHURCH_ADDRESS) String address,
                             @RequestParam(value = ParamConstant.CHURCH_TEL) String tel,
                             @RequestParam(value = ParamConstant.CHURCH_MAIL) String mail,
                             @RequestParam(value = ParamConstant.CHURCH_DESCRIPTION) String des,
                             @RequestParam(value = ParamConstant.CHURCH_LONGITUDE) String lon,
                             @RequestParam(value = ParamConstant.CHURCH_LATITUDE) String lat) {
        try {
            Double longitude = Double.parseDouble(lon);
            Double latitude = Double.parseDouble(lat);

            ChurchEntity churchEntity = new ChurchEntity();

            churchEntity.setChurchName(name);
            churchEntity.setAddress(address);
            churchEntity.setTel(tel);
            churchEntity.setMail(mail);
            churchEntity.setDescription(des);
            churchEntity.setLongitude(longitude);
            churchEntity.setLatitude(latitude);
            churchEntity.setStartTime(ParamConstant.DEFAULT_START_TIME);
            churchEntity.setEndTime(ParamConstant.DEFAULT_END_TIME);
            churchEntity.setStreamLink(ParamConstant.DEFAULT_STREAM_LINK);
            churchEntity.setStreamName(ParamConstant.DEFAULT_STREAM_NAME);

            churchServiceInterface.createChurch(churchEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @ResponseBody
    @RequestMapping(value = PageConstant.ASSIGN_MANAGER_URL, method = RequestMethod.POST)
    public void assignManager(@RequestParam(value = ParamConstant.CHURCH_ID) String churchIdStr,
                              @RequestParam(value = ParamConstant.USER_NAME) String userName,
                              @RequestParam(value = ParamConstant.ACCOUNT_ID) String accountId,
                              @RequestParam(value = ParamConstant.MANAGER_MAIL) String mail,
                              @RequestParam(value = ParamConstant.MANAGER_PHONE) String phone,
                              @RequestParam(value = ParamConstant.MANAGER_CERT) String cert) {
        try {
            Integer churchId = Integer.parseInt(churchIdStr);
            ChurchEntity churchEntity = churchServiceInterface.getChurchById(churchId);
            UserEntity userEntity = new UserEntity();
            userEntity.setAccountId(accountId);
            userEntity.setPassword(StringUtils.generateEncodePassword(ParamConstant.DEFAULT_PASSWORD));
            userEntity.setUserName(userName);
            userEntity.setRole(ParamConstant.MANAGER_ROLE);
            userEntity.setTel(phone);
            userEntity.setCertificate(cert);
            userEntity.setEmail(mail);
            userEntity.setEnabled(ParamConstant.DEFAULT_ENABLE);
            userEntity.setAccountNum("");
//
            //insert new user
            userServiceInterface.insertPriest(userEntity);

            //get inserted user
            UserEntity newPriest = userServiceInterface.getPriestByAccountId(accountId);

            ChurchMailSender mailSender = new ChurchMailSender();
            mailSender.setMailSender(mailSenderService);
            mailSender.sendMail(UtilsConstant.DEFAULT_ADMIN_MAIL, UtilsConstant.DEFAULT_CC_MAIL, mail, UtilsConstant.ASSIGN_CHURCH_SUBJECT + churchEntity.getChurchName(), UtilsConstant.MAIL_HEADER + userName + "\n" + UtilsConstant.ASSIGN_CHURCH_MAIL_BODY_ACCOUNT + accountId + "\n" + UtilsConstant.ASSIGN_CHURCH_MAIL_BODY_PASSWORD + ParamConstant.DEFAULT_PASSWORD + "\n" + UtilsConstant.MAIL_FOOTER);
            //map inserted user to church
            userServiceInterface.mapUserToChurch(newPriest.getUserId(), churchId);

            //map inserted user with subjects
            for (int i = 0; i < UtilsConstant.LIST_SUBJECT_ID_OF_MANAGER.length; i++) {
                userServiceInterface.mapPriestWithSubject(newPriest.getUserId(), UtilsConstant.LIST_SUBJECT_ID_OF_MANAGER[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
