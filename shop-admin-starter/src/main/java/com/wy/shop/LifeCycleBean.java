package com.wy.shop;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : WangYB
 * @time: 2020/11/20  15:57
 */
@Component
public class LifeCycleBean implements InitializingBean, DisposableBean {

    @SuppressWarnings("unused")
    private String    lifeCycleBeanName;

    @Value("lifeCycleBeanName")
    public void setLifeCycleBeanName(String lifeCycleBeanName)
    {
        System.out.println("Enter LifecycleBean.setLifeCycleBeanName(), lifeCycleBeanName = " + lifeCycleBeanName);
        this.lifeCycleBeanName = lifeCycleBeanName;
    }

    public void destroy() throws Exception
    {
        System.out.println("Enter LifecycleBean.destroy()");
    }

    public void afterPropertiesSet() throws Exception
    {
        System.out.println("Enter LifecycleBean.afterPropertiesSet()" + lifeCycleBeanName);
    }

    public void beanStart()
    {
        System.out.println("Enter LifecycleBean.beanStart()");
    }

    public void beanEnd()
    {
        System.out.println("Enter LifecycleBean.beanEnd()");
    }

}
