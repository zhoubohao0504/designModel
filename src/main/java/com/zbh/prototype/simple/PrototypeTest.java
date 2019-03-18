package com.zbh.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {

    public static void main(String[] args) {
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        concretePrototypeA.setName("zbh");
        concretePrototypeA.setAge(25);
        List hobbies = new ArrayList<String>();
        concretePrototypeA.setHobbies(hobbies);
        Client client = new Client();
        ConcretePrototypeA copy = (ConcretePrototypeA) client.startClone(concretePrototypeA);
        System.out.println(concretePrototypeA==copy);
    }
}
