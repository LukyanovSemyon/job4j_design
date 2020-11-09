package ru.job4j.tree;

import java.util.*;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Set<User> previousNew = new HashSet<>(previous);
        Set<User> currentNew = new HashSet<>(current);
        previousNew.removeAll(current);
        currentNew.removeAll(previous);
        for (User user : previousNew) {
            for (User user1 : currentNew) {
                if (user.getId() == user1.getId()) {
                    info.changed++;
                }
            }
        }
        info.deleted = previousNew.size() - info.changed;
        info.added = currentNew.size() - info.changed;
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        public int getId() {
            return id;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}
