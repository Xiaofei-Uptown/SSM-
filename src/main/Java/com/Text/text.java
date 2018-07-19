package com.Text;

import com.Dao.Employeedao;
import com.entity.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
        Employeedao employeedao = ioc.getBean(Employeedao.class);
        //System.out.print(employeedao);
       // employeedao.insert(new Employee( "单雪燕","女","153817160@qq.com"));
    }
}
