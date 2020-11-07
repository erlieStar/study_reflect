package com.javashitang.transfer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "studentName"),
            @Mapping(source = "age", target = "studentAge")
    })
    StudentVO po2Vo(StudentPO studentPO);

    List<StudentVO> poList2VoList(List<StudentPO> studentPO);

    @Mappings({
            @Mapping(source = "schoolPO.name", target = "schoolName"),
            @Mapping(source = "studentPO.name", target = "studentName")
    })
    SchoolStudentVO mergeVo(SchoolPO schoolPO, StudentPO studentPO);

    @Mappings({
            @Mapping(source = "gender", target = "gender", qualifiedByName = "convertGender"),
    })
    PersonPO vo2Po(PersonVO personVO);

    @Named("convertGender")
    default Integer convertTargetType(GenderEnum genderEnum) {
        return genderEnum.getValue();
    }

}
