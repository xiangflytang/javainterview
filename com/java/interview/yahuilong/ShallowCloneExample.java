package com.java.interview.yahuilong;

class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}

class Person implements Cloneable {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void setAddress(String city) {
        address = new Address(city);
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address.getCity());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ShallowCloneExample {
    public static void main(String[] args) {
        Address address = new Address("New York");
        Person original = new Person("Alice", address);

        try {
            Person cloned = (Person) original.clone();

            // 修改克隆对象的地址，会影响原始对象
            cloned.setAddress("Los Angeles");

            System.out.println("Original Person:");
            original.display();

            System.out.println("Cloned Person:");
            cloned.display();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
