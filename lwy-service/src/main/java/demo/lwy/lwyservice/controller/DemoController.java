package demo.lwy.lwyservice.controller;

import demo.lwy.lwyservice.common.Response;
import demo.lwy.lwyservice.common.RetResult;
import demo.lwy.lwyservice.dao.DemoDao;
import demo.lwy.lwyservice.entity.DemoEntity;
import demo.lwy.lwyservice.entity.DemoRespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    DemoDao demoDao;

    @PostMapping(value = "/find/one")
    @ResponseBody
    public RetResult findOne(@RequestBody DemoEntity demoEntity){
        try {
            DemoRespEntity demoRespEntity = demoDao.findOneDemoByName(demoEntity);
            return new Response().setData(demoRespEntity);

        }catch (Exception e){
            return new Response().setError("发生异常：" + e.getMessage());
        }
    }

    @PostMapping(value = "/find/many")
    @ResponseBody
    public RetResult findMany(@RequestBody DemoEntity demoEntity){
        try {
            List<DemoRespEntity> demoDaoDemoList = demoDao.findDemoList(demoEntity);
            return new Response().setData(demoDaoDemoList);

        }catch (Exception e){
            return new Response().setError("发生异常：" + e.getMessage());
        }
    }

    @GetMapping(value = "/find/test")
    @ResponseBody
    public String test(){
        System.out.println("[demoEntity]");

        Long count = demoDao.findCount();
        System.out.println("[count]" + count);
            return "demoEntity" + count;

    }


    @PostMapping(value = "/insert/one")
    @ResponseBody
    public String insertDemo(@RequestBody DemoEntity demoEntity){
        System.out.println("[demoEntity]" + demoEntity);

        demoDao.insertDemo(demoEntity);
        return "ok";

    }
}
