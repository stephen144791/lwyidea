package com.example.demo.mapper;

import com.example.demo.entity.Person;
import com.example.demo.entity.PersonParam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {

    Person findPerson(String id);

    int savePerson(PersonParam person);

    int deletePerson(String id);
}
