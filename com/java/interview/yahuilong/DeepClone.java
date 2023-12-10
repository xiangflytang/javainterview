package com.java.interview.yahuilong;

import java.io.*;

//采用序列化来实现。
//class Address implements Serializable {
//    private String city;
//
//    public Address(String city) {
//        this.city = city;
//    }
//
//    public String getCity() {
//        return city;
//    }
//}
//
//class Person implements Serializable {
//    private String name;
//    private Address address;
//
//    public Person(String name, Address address) {
//        this.name = name;
//        this.address = address;
//    }
//
//    public void setAddress(String city) {
//        address = new Address(city);
//    }
//
//    public void display() {
//        System.out.println("Name: " + name);
//        System.out.println("Address: " + address.getCity());
//    }
//
//    public Person deepCopy() throws IOException, ClassNotFoundException {
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream(bos);
//        oos.writeObject(this);
//
//        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
//        ObjectInputStream ois = new ObjectInputStream(bis);
//        return (Person) ois.readObject();
//    }
//}
//
//public class DeepClone {
//    public static void main(String[] args) {
//        Address address = new Address("New York");
//        Person original = new Person("Alice", address);
//
//        try {
//            Person cloned = original.deepCopy();
//
//            // 修改克隆对象的地址，不会影响原始对象
//            cloned.setAddress("Los Angeles");
//
//            System.out.println("Original Person:");
//            original.display();
//
//            System.out.println("Cloned Person:");
//            cloned.display();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
