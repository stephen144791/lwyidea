package demo.lwy.lwyservice.controller;

import demo.lwy.lwyservice.common.Response;
import demo.lwy.lwyservice.common.RetResult;
import demo.lwy.lwyservice.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/person")
public class PersonController {

    @Autowired
    PersonDao personDao;



    @GetMapping("/findCount")
    public RetResult findCount(){
        Long count = personDao.findCountToMysql();
        return new Response().setData(count);
    }


}
