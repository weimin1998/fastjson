package org.example.pojo;

import lombok.Data;

@Data
public class NiceCard implements Cloneable {

    public Person person;

    public void award() {
        System.out.println(person.getName());
    }

    @Override
    public NiceCard clone() throws CloneNotSupportedException {
        return (NiceCard) super.clone();
    }

}
