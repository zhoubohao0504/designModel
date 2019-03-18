package com.zbh.prototype.simple;

import java.util.List;

public class ConcretePrototypeA implements Prototype{

    private String name;
    private List hobbies;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



   public List getHobbies() {
       return hobbies;
   }

    public void setHobbies(List hobbies) {
        this.hobbies = hobbies;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Prototype clone() {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setAge(this.age);
        concretePrototypeA.setHobbies(this.hobbies);
        concretePrototypeA.setName(this.name);
        return concretePrototypeA;
    }
}
