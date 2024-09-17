package org.example.grokkaiAlgorithms.chapter_second.grokkai2_4;

public class Grokkai2_4 {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass(10);

        mainClass.addUser(new User("user1", "pass1"));
        mainClass.addUser(new User("user2", "pass2"));
        mainClass.addUser(new User("user3", "pass3"));
        mainClass.addUser(new User("user4", "pass4"));

        User user = mainClass.findUser("user2");
        if (user != null) {
            System.out.println(user.getUsername());
        } else {
            System.out.println("User not found");
        }
    }
}
