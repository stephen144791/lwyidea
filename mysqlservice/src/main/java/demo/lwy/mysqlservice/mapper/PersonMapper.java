package demo.lwy.mysqlservice.mapper;

import demo.lwy.mysqlservice.entity.Person;
import demo.lwy.mysqlservice.entity.PersonParam;

//@Mapper
public interface PersonMapper {

    Person findPerson(String id);

    int savePerson(PersonParam person);

    int deletePerson(String id);
}
