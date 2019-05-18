package demo.lwy.lwyservice.dao;

import demo.lwy.lwyservice.entity.Person;

import java.util.List;

public interface PersonDao {
    void insertOne(Person person);
    void insertList(List<Person> personList);
    Person findOneByName(Person person);
    List<Person> findPersonList(Person person);
    List<Person> findPersonListToMysql(int skip, int limit);
    int update(Person person);
    long findCountToMysql();
}
