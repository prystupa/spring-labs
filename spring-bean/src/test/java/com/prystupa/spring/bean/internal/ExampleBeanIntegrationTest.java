package com.prystupa.spring.bean.internal;

import com.prystupa.spring.bean.ExampleBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/bundle-context.xml")
public class ExampleBeanIntegrationTest
{
    @Autowired
    private ExampleBean myBean;

    @Test
    public void beanIsABean()
    {
        Assert.assertTrue(this.myBean.isABean());
    }
}
