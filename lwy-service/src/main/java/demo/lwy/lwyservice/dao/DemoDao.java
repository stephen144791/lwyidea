package demo.lwy.lwyservice.dao;

import demo.lwy.lwyservice.entity.DemoEntity;
import demo.lwy.lwyservice.entity.DemoRespEntity;

import java.util.List;

public interface DemoDao {
    void insertDemo(DemoEntity demoEntity);
    void insertDemoList(List<DemoEntity> demoEntityList);
    DemoRespEntity findOneDemoByName(DemoEntity demoEntity);
    List<DemoRespEntity> findDemoList(DemoEntity demoEntity);
    int updateDemo(DemoEntity demoEntity);
    long findCount();
}
