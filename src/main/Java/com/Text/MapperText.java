package com.Text;
import com.Dao.Employeedao;
import com.entity.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MapperText {
    @Autowired
    Employeedao employeedao;
    @Autowired
    SqlSession sqlSession;
    @Test
    public void  textCRUD(){
        //1 创建SpringIOC容器
        //ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
        //2 从容器中获取Mapper
        //ioc.getBean(Employeedao.class);
        //System.out.println(employeedao);
//        for(){
//            employeedao.insert(new Employee(,,,,));
//        }

        Employeedao employeedao = sqlSession.getMapper(Employeedao.class);
        for(int i = 0;i<1000;i++){
            String uid = UUID.randomUUID().toString().substring(0,5)+i;
           // employeedao.insert(new Employee(uid,"",uid+"@163.com"));
        }

    }
}
