package com.example.greendao_example;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class User {


    /**
     * 自动增长
     */
    @Id(autoincrement = true)
    private Long id;

    private String name;

    private int age;

    private String sex;

    private String city;

    @Generated(hash = 1028872473)
    public User(Long id, String name, int age, String sex, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.city = city;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}