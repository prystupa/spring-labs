package com.prystupa.spring.bean.internal;

import junit.framework.TestCase;
import com.prystupa.spring.bean.ExampleBean;

public class ExampleBeanImplTest extends TestCase
{
    public void testBeanIsABean()
    {
        ExampleBean aBean = new ExampleBeanImpl();
        assertTrue( aBean.isABean() );
    }
}
