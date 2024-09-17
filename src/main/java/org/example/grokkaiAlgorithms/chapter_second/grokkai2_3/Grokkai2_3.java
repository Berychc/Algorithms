package org.example.grokkaiAlgorithms.chapter_second.grokkai2_3;

public class Grokkai2_3 {
    public static void main(String[] args) {
        FacebookUserList facebookUserList = new FacebookUserList(100);

        facebookUserList.addUser("Berychc");
        facebookUserList.addUser("Vesel");
        facebookUserList.addUser("Egor");

        String userName = "Berychc";
        if (facebookUserList.authenticate(userName)) {
            System.out.println("User " + userName + " is authenticated");
        } else {
            System.out.println("User " + userName + " is not authenticated");
        }
    }

}
