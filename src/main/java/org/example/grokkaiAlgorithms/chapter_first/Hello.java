package org.example.grokkaiAlgorithms.chapter_first;

public class Hello {

    public static int binarySearch(String[] names, String target) {
        int low = 0;
        int high = names.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            count++;

            if (names[mid].equals(target)) {
                System.out.println(mid);
                break;
            } else if (names[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];

            if (guess == item) {
                return mid;
            } else if (guess < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Известна фамилия, нужно найти номер в телефонной книге
     * @param phoneBook
     * @param name
     */
    public static int binarySearch3(String[] phoneBook, String name) {
        int low = 0;
        int high = phoneBook.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String guess = phoneBook[mid].split(" ")[0];

            if (guess.equals(name)) {
                return mid;
            } else if (guess.compareTo(name) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    /**
     * Известен номер нужно найти фамилию в телефонной книге.
     * (Нужно провести поиск по всех книге)
     */
    public static String findSurname(String[] phoneBook, String phoneNumber) {
        for (String entry : phoneBook) {
            String[] parts = entry.split(" ");
            if (parts[1].equals(phoneNumber)) {
                return parts[0];
            }
        }
        return null;
    }

    /**
     * Нужно прочитать телефоны всех людей в телефонной книге
     */
    public static void readPhoneNumbers(String[] phoneBook) {
        for (String entry : phoneBook) {
            String[] parts = entry.split(" ");
            System.out.println("Phone number: " + parts[1]);
        }
    }

    /**
     * Нужно прочитать телефоны всех людей фамилии которых начинаются с буквы "A"
     * Вопрос с подвохом! В нем задействованы концепции.
     */
    public static void readPhoneNumbersStartingWithA(String[] phoneBook) {
        for (String entry : phoneBook) {
            String[] parts = entry.split(" ");
            if (parts[0].startsWith("A")) {
                System.out.println("Phone number: " + parts[1]);
            }
        }
    }
}
