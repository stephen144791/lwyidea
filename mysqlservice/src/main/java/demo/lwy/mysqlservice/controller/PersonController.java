package demo.lwy.mysqlservice.controller;

import demo.lwy.mysqlservice.common.Response;
import demo.lwy.mysqlservice.common.RetResult;
import demo.lwy.mysqlservice.entity.Person;
import demo.lwy.mysqlservice.entity.PersonParam;
import demo.lwy.mysqlservice.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/person")
public class PersonController {

    @Autowired
    PersonMapper personMapper;

    @GetMapping(value = "/findPerson/{id}")
    @ResponseBody
    public RetResult findPerson(@PathVariable(value = "id") String id){
        System.out.println("[findPerson]" + id);
        Person person = personMapper.findPerson(id);
        return new Response().setData(person);

    }

    @PostMapping(value = "/savePerson")
    @ResponseBody
    public RetResult savePerson(@RequestBody PersonParam person){
        System.out.println("[savePerson]" + person);
        int count = personMapper.savePerson(person);
        return new Response().setData(count);

    }


}
