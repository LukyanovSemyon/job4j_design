package ru.job4j.serialization.json;

import org.json.JSONPropertyIgnore;

public class Author {
    private final String name;
    private final String sex;
    private final String language;
    private final int age;

    public Author(String name, String sex, String language, int age) {
        this.name = name;
        this.sex = sex;
        this.language = language;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getLanguage() {
        return language;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Author{"
                + "name='" + name + '\''
                + ", sex='" + sex + '\''
                + ", language='" + language + '\''
                + ", age=" + age
                + '}';
    }
}
