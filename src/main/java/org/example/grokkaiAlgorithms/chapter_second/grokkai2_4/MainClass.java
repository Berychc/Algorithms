package org.example.grokkaiAlgorithms.chapter_second.grokkai2_4;

public class MainClass {

    private User[] users;
    private int size;

    public MainClass(int capacity) {
        users = new User[capacity];
        size = 0;
    }

    public void addUser(User user) {
        if (size == users.length) {
            // Resize the array
            User[] newArray = new User[users.length * 2];
            System.arraycopy(users, 0, newArray, 0, users.length);
            users = newArray;
        }
        users[size++] = user;
    }

    public User findUser(String username) {
        for (int i = 0; i < size; i++) {
            if (users[i].getUsername().equals(username)) {
                return users[i];
            }
        }
        return null;
    }
}
