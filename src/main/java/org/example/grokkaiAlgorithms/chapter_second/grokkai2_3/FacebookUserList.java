package org.example.grokkaiAlgorithms.chapter_second.grokkai2_3;


/**
 * Допустим фэйсбук хранит список имен пользователей.
 * Когда кто-то пытается зайти на сайт Фэйсбук система пытается найти имя пользователя
 * если имя входит в список именно зарегистрированных пользователей то вход разрешается
 * Потзлватеди приходят на фэйсбук достаточно часто поэтому список имен пользователей
 * будет выполняться часто  будем считать что фэйсбук исползлует бинарный поиск для поиска
 * в списке бинарному поиску необходим произвольный доступ - алгоритм должен мгновенно обратиться
 * к среднему элементу текущей части списка зная обстоятельства как бы вы реализовали список
 * пользователей в виде массива или в виде связанного списка
 */
public class FacebookUserList {
    private String[] users;
    private int size;

    public FacebookUserList(int initialCapacity) {
        users = new String[initialCapacity];
        size = 0;
    }

    public void addUser(String userName) {
        users[size++] = userName;
    }

    public boolean authenticate(String userName) {
        int low = 0;
        int high = userName.length() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midUserName = users[mid];

            if (midUserName.equals(userName)) {
                return true;
            } else if (midUserName.compareTo(userName) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
