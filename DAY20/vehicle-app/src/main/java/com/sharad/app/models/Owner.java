package com.sharad.app.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Owner
{
    private String name;
    private String address;
    private String age;
    private final Logger log = LoggerFactory.getLogger(Owner.class);

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAge()
    {
        return age;
    }
    public void setAge(String age)
    {
        this.age = age;
    }
    public Owner()
    {
        log.trace("TRACE Level Log - Owner constructor");
        log.debug("DEBUG Level Log - Owner constructor");
        log.info("INFO Level Log - Owner constructor");
        log.warn("WARN Level Log - Owner constructor");
        log.error("ERROR Level Log - Owner constructor");
    }
    @Override
    public String toString()
    {
        return "Owner{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}