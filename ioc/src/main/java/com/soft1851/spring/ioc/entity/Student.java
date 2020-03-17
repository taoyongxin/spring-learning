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
    private List<String> hobbies;
    private Set<String> hobbiesSet;
    private Map<String,String> hobbiesMap;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                ", hobbiesSet=" + hobbiesSet +
                ", hobbiesMap=" + hobbiesMap +
                '}';
    }

    public Student() {
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

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Set<String> getHobbiesSet() {
        return hobbiesSet;
    }

    public void setHobbiesSet(Set<String> hobbiesSet) {
        this.hobbiesSet = hobbiesSet;
    }

    public Map<String, String> getHobbiesMap() {
        return hobbiesMap;
    }

    public void setHobbiesMap(Map<String, String> hobbiesMap) {
        this.hobbiesMap = hobbiesMap;
    }

    public Student(Integer id, String name, List<String> hobbies, Set<String> hobbiesSet, Map<String, String> hobbiesMap) {
        this.id = id;
        this.name = name;
        this.hobbies = hobbies;
        this.hobbiesSet = hobbiesSet;
        this.hobbiesMap = hobbiesMap;
    }
}
