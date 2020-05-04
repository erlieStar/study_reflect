package com.javashitang.transfer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentMapperTest {

    @Test
    public void studentPo2Vo() {
        StudentPO studentPO = StudentPO.builder().id(10).name("test")
                .age(24).className("教室名").build();
        StudentVO studentVO = StudentMapper.INSTANCE.po2Vo(studentPO);
        // StudentVO(id=10, studentName=test, studentAge=24, schoolName=null)
        System.out.println(studentVO);
    }


    @Test
    public void poList2VoList() {
        List<StudentPO> studentPOList = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            StudentPO studentPO = StudentPO.builder().id(i).name(String.valueOf(i)).age(i).build();
            studentPOList.add(studentPO);
        }
        List<StudentVO> studentVOList = StudentMapper.INSTANCE.poList2VoList(studentPOList);
        // [StudentVO(id=1, studentName=1, studentAge=1, schoolName=null),
        // StudentVO(id=2, studentName=2, studentAge=2, schoolName=null)]
        System.out.println(studentVOList);
    }

    @Test
    public void mergeVo() {
        SchoolPO schoolPO = SchoolPO.builder().name("学校名字").build();
        StudentPO studentPO = StudentPO.builder().name("学生名字").build();
        SchoolStudentVO schoolStudentVO = StudentMapper.INSTANCE.mergeVo(schoolPO, studentPO);
        // SchoolStudentVO(schoolName=学校名字, studentName=学生名字)
        System.out.println(schoolStudentVO);
    }
}