package ru.job4j.tree;

import java.util.*;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> previousNew = new HashMap();
        for (User user : previous) {
            previousNew.put(user.id, user.name);
        }
        Map<Integer, String> currentNew = new HashMap();
        for (User user : current) {
            currentNew.put(user.id, user.name);
        }
        for (int key : previousNew.keySet()) {
            if (currentNew.containsKey(key) && !currentNew.get(key).contains(previousNew.get(key))) {
                info.changed++;
            } else if (!currentNew.containsKey(key)) {
                info.deleted++;
            }
        }
        info.added = currentNew.size() - (previousNew.size() - info.deleted);
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
