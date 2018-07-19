package com.Text;

import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:springmvc.xml"})

public class MvcTest {
    //springmvc的ioc
    WebApplicationContext context;
    //虚拟mvc
    MockMvc mockMvc;

    @Before
    public void initMokMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testPage() throws Exception {
        //得到请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn","1"))
                .andReturn();
        //请求成功后，请求域会有pageInfo，可以取出pageInfo进行验证
        MockHttpServletRequest request= result.getRequest();
        PageInfo pi =  (PageInfo)request.getAttribute("pageInfo");
        System.out.print("当前页码"+pi.getPages());
        System.out.print("总记录数"+pi.getTotal());
    }
}
