package com.soft1851.spring.ioc.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Student
 * @Description TODO
 * @date 2020-03-17 12:55
 **/
public class Student {
    private Integer id;
    private String name;
    private List<Phone> phones;
    private Set<String> hobbiesSet;
    private Map<String,Phone> devices;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                ", hobbiesSet=" + hobbiesSet +
                ", devices=" + devices +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Set<String> getHobbiesSet() {
        return hobbiesSet;
    }

    public void setHobbiesSet(Set<String> hobbiesSet) {
        this.hobbiesSet = hobbiesSet;
    }

    public Map<String, Phone> getDevices() {
        return devices;
    }

    public void setDevices(Map<String, Phone> devices) {
        this.devices = devices;
    }

    public Student() {
    }

    public Student(Integer id, String name, List<Phone> phones, Set<String> hobbiesSet, Map<String, Phone> devices) {
        this.id = id;
        this.name = name;
        this.phones = phones;
        this.hobbiesSet = hobbiesSet;
        this.devices = devices;
    }
}
