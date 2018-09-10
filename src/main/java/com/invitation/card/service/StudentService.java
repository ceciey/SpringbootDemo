package com.invitation.card.service;

import com.baomidou.mybatisplus.service.IService;
import com.invitation.card.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> findAllStudent();
}
