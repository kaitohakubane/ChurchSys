package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.common.constants.UtilsConstant;
import com.churchsystem.common.utils.StringUtils;
import com.churchsystem.entity.*;
import com.churchsystem.service.interfaces.CategoryServiceInterface;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.churchsystem.service.interfaces.SubjectServiceInterface;
import com.churchsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hungmcse61561-admin on 7/1/2017.
 */
@Controller
public class UserController {
    @Autowired
    UserServiceInterface userServiceInterface;
    @Autowired
    CategoryServiceInterface categoryServiceInterface;
    @Autowired
    SubjectServiceInterface subjectServiceInterface;
    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @RequestMapping(value = PageConstant.PRIEST_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllChurch(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.PRIEST_MANAGEMENT_PAGE);
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        List<UserEntity> userEntities = userServiceInterface.getAllPriest(churchId);
        modelAndView.addObject(ParamConstant.PRIEST_LIST, userEntities)
                .addObject(ParamConstant.SUBJECT_LIST, subjectServiceInterface.getDisplayedSubject())
                .addObject(ParamConstant.CATEGORY_LIST, categoryServiceInterface.getEventCategoryList());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.ADD_NEW_PRIEST_URL, method = RequestMethod.POST)
    public void addNewPriest(HttpServletRequest request, @RequestBody ManagementJsonEntity managementJsonEntity) {
        try {
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            String userName = managementJsonEntity.getUserName();
            String accountId = managementJsonEntity.getAccountId();
            String email = managementJsonEntity.getEmail();
            String phone = managementJsonEntity.getPhone();
            String cert = managementJsonEntity.getCert();
            Integer[] selectedSubject = managementJsonEntity.getSelectedSubjectList();

            UserEntity userEntity = new UserEntity();
            userEntity.setAccountId(accountId);
            userEntity.setPassword(StringUtils.generateEncodePassword(ParamConstant.DEFAULT_PASSWORD));
            userEntity.setUserName(userName);
            userEntity.setRole(ParamConstant.PRIEST_ROLE);
            userEntity.setTel(phone);
            userEntity.setCertificate(cert);
            userEntity.setEmail(email);
            userEntity.setEnabled(ParamConstant.DEFAULT_ENABLE);
            userEntity.setAccountNum("");
//
            //insert new user
            userServiceInterface.insertPriest(userEntity);

            //get inserted user
            UserEntity newPriest = userServiceInterface.getPriestByAccountId(accountId);


            //map inserted user to church
            userServiceInterface.mapUserToChurch(newPriest.getUserId(), churchId);

            //map inserted user with subjects
            for (int i = 0; i < selectedSubject.length; i++) {
                userServiceInterface.mapPriestWithSubject(newPriest.getUserId(), selectedSubject[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = PageConstant.USER_DASHBOARD_URL, method = RequestMethod.GET)
    public ModelAndView userDashBoard(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.USER_DASHBOARD_PAGE);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userServiceInterface.getUserByAccountId(auth.getName());
        List<ChurchEntity> followChurch = userServiceInterface.getFollowingChurch(userEntity.getUserId());
        List<IncomingEventEntity> list = churchServiceInterface.getIncomingEvent(userEntity.getUserId());
        modelAndView.addObject(ParamConstant.CHURCH_LIST, followChurch)
                .addObject(ParamConstant.CATEGORY_LIST, categoryServiceInterface.getEventCategoryList())
                .addObject(ParamConstant.INCOMING_EVENT, list);
        return modelAndView;
    }

}
