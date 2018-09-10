package com.invitation.card.controller;
import com.invitation.card.entity.Student;
import com.invitation.card.service.StudentService;
import com.invitation.card.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "student",method = RequestMethod.POST)
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/register")
    public ResultBean Register(@RequestBody Student student){
        studentService.insert(student);
        return new ResultBean(ResultBean.SUCCESS_CODE,"保存成功");
    }

    @RequestMapping("/findAllStudent")
    public ResultBean<List<Student>> test1(){
        ResultBean<List<Student>> result = new ResultBean<>();
        List<Student> student = studentService.findAllStudent();
        result.setData(student);
        return result;
    }
}
