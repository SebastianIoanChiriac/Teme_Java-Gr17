package org.TEMA5;

import java.util.Objects;

class Person {
    private String name;
    private int age;
    public Person(String name , int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Person other = (Person) obj;
        return age == other.age && Objects.equals(name, other.name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }
}
