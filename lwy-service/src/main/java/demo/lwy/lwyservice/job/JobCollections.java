package demo.lwy.lwyservice.job;

import demo.lwy.lwyservice.dao.PersonDao;
import demo.lwy.lwyservice.entity.Person;
import demo.lwy.lwyservice.service.PersonService;
import demo.lwy.lwyservice.utils.CreatedInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobCollections {

    @Autowired
    PersonDao personDao;

    @Autowired
    PersonService personService;

    @Scheduled(cron = "0 * * 1 5 ?")
    public void Tast01(){

        for(int i = 0 ;i<1000; i++){
            Person person = new Person();
            String[] nameAndGender = CreatedInfo.getChineseName();
            person.setName(nameAndGender[0]);
            person.setGender(nameAndGender[1]);
            person.setAge(CreatedInfo.getAge(18,28));
            person.setMobile(CreatedInfo.getTel());
            person.setEmail(CreatedInfo.getEmail(6,9));

            personDao.insertOne(person);
        }
    }

    @Scheduled(cron = "* * * 1 5 ?")
    public void Tast02(){
        System.out.println("***********start*************");
        personService.findPersonToMysql();
        System.out.println("************end**************");
    }
}
