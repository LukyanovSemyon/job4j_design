package ru.job4j.kiss;

public class User {
    @Override
    public String toString() {
        return "User{" + "age=" + age
                + ", name='" + name + '\'' + '}';
    }

    private final int age;
    private final String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }
}
