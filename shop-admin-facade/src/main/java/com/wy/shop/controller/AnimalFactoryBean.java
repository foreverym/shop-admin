package com.wy.shop.controller;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : WangYB
 * @time: 2020/11/20  17:10
 */
@Component
public class AnimalFactoryBean implements FactoryBean<Animal>
{
    private String    animal;

    public Animal getObject() throws Exception
    {
        if ("Monkey".equals(animal))
        {
            return new Monkey();
        }
        else if ("Tiger".equals(animal))
        {
            return new Tiger();
        }
        else
        {
            return null;
        }
    }

    public Class<?> getObjectType()
    {
        return Animal.class;
    }

    public boolean isSingleton()
    {
        return true;
    }

    @Value("Tiger")
    public void setAnimal(String animal)
    {
        this.animal = animal;
    }

}