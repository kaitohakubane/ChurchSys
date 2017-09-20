package com.churchsystem.controller;

import com.churchsystem.common.constants.PageConstant;
import com.churchsystem.common.constants.ParamConstant;
import com.churchsystem.entity.LectureEntity;
import com.churchsystem.entity.SettingEntity;
import com.churchsystem.model.interfaces.LectureModelInterface;
import com.churchsystem.service.interfaces.ChurchServiceInterface;
import com.churchsystem.service.interfaces.LectureServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Vongnlh on 9/16/2017.
 */
@Controller
public class LectureController {
    @Autowired
    LectureServiceInterface lectureServiceInterface;
    @Autowired
    ChurchServiceInterface churchServiceInterface;

    @RequestMapping(value = PageConstant.LECTURE_MANAGEMENT_URL, method = RequestMethod.GET)
    public ModelAndView getAllLecture(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            modelAndView = new ModelAndView(PageConstant.MANGER_LECTURE_MANAGEMENT_PAGE);
            int churchId = (Integer) request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            List<LectureEntity> lectureEntities = lectureServiceInterface.getAllLecture(churchId);
            modelAndView.addObject(ParamConstant.LECTURE_LIST, lectureEntities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = PageConstant.VIEW_LECTURE_URL, method = RequestMethod.GET)
    public ModelAndView loadLesson(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView(PageConstant.NOT_FOUND_PAGE);
        try {
            int churchId = Integer.parseInt(request.getParameter(ParamConstant.CHURCH_ID));

            SettingEntity settingEntity = churchServiceInterface.getSettingOfChurch(churchId);
            List<LectureEntity> lectureEntities = lectureServiceInterface.getAllLecture(churchId);
            modelAndView = new ModelAndView(PageConstant.LECTURE_PAGE)
                    .addObject(ParamConstant.CHURCH_SETTING, settingEntity)
                    .addObject(ParamConstant.LECTURE_LIST,lectureEntities );

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.ADD_LECTURE_URL,method = RequestMethod.POST)
    public int insertLecture(HttpServletRequest request, @RequestParam(value = ParamConstant.LESSON_TITLE) String title,
                             @RequestParam(value = ParamConstant.LESSON_DESCRIPTION) String description,
                             @RequestParam(value = ParamConstant.LECTURE_LINK) String link){
        try {
            int churchId = (Integer)request.getSession().getAttribute(ParamConstant.CHURCH_ID);
            LectureEntity lectureEntity = new LectureEntity();
            lectureEntity.setTitle(title);
            lectureEntity.setDescription(description);
            lectureEntity.setLinkvideo(link);
            lectureEntity.setChurchId(churchId);
            lectureServiceInterface.insertLecture(lectureEntity);
            return  ParamConstant.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ParamConstant.FAILURE;
    }
}
