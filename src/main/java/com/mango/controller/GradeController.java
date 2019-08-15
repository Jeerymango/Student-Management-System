package com.mango.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mango.domain.Grade;
import com.mango.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:年级信息管理
 * @param:
 * @Auther: mango
 * @Date: 2019-08-02 14:11
 */
@Controller
@RequestMapping("/grade")
public class GradeController {

    // 注入业务对象
    @Autowired
    private GradeService gradeService;

    // 存储预返回页面的结果对象
    private Map<String, Object> result = new HashMap<>();

    @GetMapping("/goGradeListView")
    public String goGradeListView(){
        return "grade/gradeList";
    }

    @PostMapping("/getGradeList")
    @ResponseBody
    public Map<String, Object> getGradeList(Integer page, Integer rows, String gradename) {
        /**
         *
         * 功能描述: 显示已添加的年级/按班级名搜索结果
         *
         * @param: [page, rows, gradename]
         * @return: java.util.Map<java.lang.String,java.lang.Object>
         * @auther: mango
         * @date: 2019-08-02 14:38
         */
        Grade grade = new Grade();
        grade.setName(gradename);
        //设置每页的记录数
        PageHelper.startPage(page, rows);
        //根据年级名称获取指定或全部年级信息列表
        List<Grade> list = gradeService.selectList(grade);
        //封装信息列表
        PageInfo<Grade> pageInfo = new PageInfo<>(list);
        //获取总记录数
        long total = pageInfo.getTotal();
        //获取当前页数据列表
        List<Grade> gradeList = pageInfo.getList();
        //存储数据对象
        result.put("total", total);
        result.put("rows", gradeList);

        return result;
    }


    @PostMapping("/addGrade")
    @ResponseBody
    public Map<String,Object> addGrade(Grade grade){
        /**
         *
         * 功能描述: 添加年级
         *
         * @param: [grade]
         * @return: java.util.Map<java.lang.String,java.lang.Object>
         * @auther: mango
         * @date: 2019-08-02 14:25
         */
        Grade gradeinfo = gradeService.findByName(grade.getName());
        if (gradeinfo == null){
            if(gradeService.insert(grade) > 0){
                result.put("success",true);
            }else{
                result.put("success",false);
                result.put("msg","添加失败! (ಥ_ಥ)服务器端发生异常!");
            }
        }else {
            result.put("success",false);
            result.put("msg","年级已经存在");
        }
        return result;
    }

    @PostMapping("/editGrade")
    @ResponseBody
    public Map<String,Object> editGrade(Grade grade){
        Grade gradeinfo = gradeService.findByName(grade.getName());
        if (gradeinfo != null){
            if(!(grade.getId().equals(gradeinfo.getId()))){
                result.put("success",false);
                result.put("msg","年级已经存在");
                return result;
            }
        }
        if (gradeService.update(grade) > 0){
            result.put("success",true);
        }else {
            result.put("success",false);
            result.put("msg","修改失败! (ಥ_ಥ)服务器端发生异常!");
        }
        return result;
    }

    @PostMapping("/deleteGrade")
    @ResponseBody
    public Map<String,Object> deleteGrade(@RequestParam(value = "ids[]",required = true) Integer[] ids){
        if (gradeService.deleteById(ids)>0){
            result.put("success",true);
        }else {
            result.put("success",false);
            result.put("msg","删除失败! ");
        }
        return result;
    }
}
