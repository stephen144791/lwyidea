package com.example.demo.controller;

import com.example.demo.common.Response;
import com.example.demo.common.RetResult;
import com.example.demo.entity.Person;
import com.example.demo.entity.PersonParam;
import com.example.demo.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.JedisCluster;

@RestController(value = "/person")
public class PersonController {

    @Autowired
    PersonMapper personMapper;

    @Autowired
    JedisCluster jedisCluster;

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

    @GetMapping(value = "/testJedis")
    @ResponseBody
    public RetResult testJedis(){
        System.out.println("[testJedis]");
        String age = jedisCluster.get("age");
        return new Response().setData(age);

    }


}
