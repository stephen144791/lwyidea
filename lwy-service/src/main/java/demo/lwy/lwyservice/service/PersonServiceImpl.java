package demo.lwy.lwyservice.service;

import demo.lwy.lwyservice.dao.PersonDao;
import demo.lwy.lwyservice.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    MysqlService mysqlService;

    @Autowired
    PersonDao personDao;

    @Override
    public int findPersonToMysql() {
        int successCount = 0;
        long countToMysql = personDao.findCountToMysql();

        int pageSize = 100;
        int pages = (int)countToMysql/pageSize;
        int mod = (int)countToMysql%pageSize;
        if (mod>0){
            pages++;
        }
        for(int i = 0;i<pages;i++){
            int skip = pageSize * i;
            int limit = pageSize;
            if(i==pages-1&&mod>0){
                limit = mod;
            }
            List<Person> personListToMysql = personDao.findPersonListToMysql(skip, limit);
            for (Person p : personListToMysql
                 ) {
                System.out.println("[savePerson]"+ p);
               int count = mysqlService.savePerson(p);
               if(count>0){

                   int updateCount = personDao.update(p);
                    if(updateCount<1){
                        System.out.println("更新状态失败！！！" + p.getPersonId());

                    }
               }
                successCount += count;
            }

            System.out.println("[successCount]["+ i + "]" + successCount);
        }

        return successCount;
    }
}
