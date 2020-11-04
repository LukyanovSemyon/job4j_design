package ru.job4j.map;

import java.util.*;

public class User {
    String name;
    int children;
    Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        User user1 = new User("Ivan", 2, new GregorianCalendar(1990, Calendar.FEBRUARY, 5));
        User user2 = new User("Ivan", 2, new GregorianCalendar(1990, Calendar.FEBRUARY, 5));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, user2.getName());
        map.put(user2, user2.getName());
        System.out.println(map);
    }
}
