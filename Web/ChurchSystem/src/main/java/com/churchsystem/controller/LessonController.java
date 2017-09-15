package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.ChurchEntity;
import com.churchsystem.entity.LessonDisplayEntity;
import com.churchsystem.entity.LessonEntity;
import com.churchsystem.entity.SettingEntity;
import com.churchsystem.service.interfaces.CategoryServiceInterface;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.churchsystem.service.interfaces.LessonServiceInterface;
import com.churchsystem.service.interfaces.SubjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Vongnlh on 9/9/2017.
 */
@Controller
public class LessonController {
    @Autowired
    LessonServiceInterface lessonServiceInterface;
    @Autowired
    SubjectServiceInterface subjectServiceInterface;
    @Autowired
    CategoryServiceInterface categoryServiceInterface;
    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @RequestMapping(value = PageConstant.LESSON_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllLesson(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.MANAGER_LESSON_MANAGEMENT_PAGE);
        int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
        //int subId =(Integer) request.getSession().getAttribute(ParamConstant.SUBJECT_ID);
        List<LessonEntity> lessonEntities = lessonServiceInterface.getAllLessonOfChurch(churchId);
        modelAndView.addObject(ParamConstant.LESSON_LIST, lessonEntities)
                .addObject(ParamConstant.SUBJECT_LIST, subjectServiceInterface.getSubjectforLesson())
                .addObject(ParamConstant.CATEGORY_LIST, categoryServiceInterface.getClassCategoryList());
        return modelAndView;


    }

    @RequestMapping(value = PageConstant.VIEW_LESSON_URL, method = RequestMethod.GET)
    public ModelAndView loadLesson(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int churchId = Integer.parseInt(request.getParameter(ParamConstant.CHURCH_ID));


            SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchId);
            List<LessonDisplayEntity> list = lessonServiceInterface.getAllLesson(churchId);

            modelAndView = new ModelAndView(PageConstant.LESSON_PAGE)
                    .addObject(ParamConstant.CATEGORY_LIST, categoryServiceInterface.getClassCategoryList())
                    .addObject(ParamConstant.CHURCH_LESSON, list)
                    .addObject(ParamConstant.CHURCH_SETTING, settingEntity);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return modelAndView;
    }




    @ResponseBody
    @RequestMapping(value = PageConstant.ADD_LESSON_URL, method = RequestMethod.POST)
    public int insertLesson(HttpServletRequest request, @RequestParam(value = ParamConstant.LESSON_TITLE) String title,
                            @RequestParam(value = ParamConstant.LESSON_DESCRIPTION) String des,
                            @RequestParam(value = ParamConstant.SUBJECT_ID) String subIdStr) {
        try {
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            int subId = Integer.parseInt(subIdStr);

            LessonEntity lessonEntity = new LessonEntity();
            lessonEntity.setTitle(title);
            lessonEntity.setDescription(des);
            lessonEntity.setSubId(subId);
            lessonEntity.setChurchId(churchId);
            lessonServiceInterface.insertLesson(lessonEntity);

            return ParamConstant.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ParamConstant.FAILURE;
    }

}
