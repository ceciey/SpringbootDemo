package com.invitation.card.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.invitation.card.entity.Student;
import com.invitation.card.mapper.StudentMapper;
import com.invitation.card.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

//    @Test
//    public void testSql(String str){
//        EntityWrapper<Student> wrapper = new EntityWrapper<>();
//        wrapper.eq("stu_name", str)
//                .or()
//                .eq("par_name", str)
//                .orderBy("create_time", false)   // 时间的倒叙排列
//                .limit(0, 1);                    // 取一条
//        Student stu = baseMapper.selectOne(wrapper);
//    }

    @Override
    public List<Student> findAllStudent() {
        return baseMapper.findAllStudent();
    }
}
