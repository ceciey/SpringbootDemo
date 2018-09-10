package com.invitation.card.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.invitation.card.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Student 表数据层控制接口
 */

@Repository
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> findAllStudent();
}
