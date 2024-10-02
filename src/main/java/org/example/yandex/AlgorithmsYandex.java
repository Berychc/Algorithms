package org.example.yandex;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class AlgorithmsYandex {

    public static void Crossword() {
        Scanner scanner = new Scanner(System.in);

        // Считываем размеры кроссворда
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        scanner.nextLine();  // Переход на следующую строку

        String[] grid = new String[R];
        for (int i = 0; i < R; i++) {
            grid[i] = scanner.nextLine();
        }

        // Используем множество для хранения найденных слов
        TreeSet<String> words = new TreeSet<>();

        // Поиск слов горизонтально
        for (int i = 0; i < R; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < C; j++) {
                if (grid[i].charAt(j) != '#') {
                    word.append(grid[i].charAt(j));
                } else {
                    if (word.length() >= 2) {
                        words.add(word.toString());
                    }
                    word.setLength(0); // Сбрасываем слово
                }
            }
            if (word.length() >= 2) {
                words.add(word.toString()); // Добавляем последнее слово, если оно длинное
            }
        }

        // Поиск слов вертикально
        for (int j = 0; j < C; j++) {
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < R; i++) {
                if (grid[i].charAt(j) != '#') {
                    word.append(grid[i].charAt(j));
                } else {
                    if (word.length() >= 2) {
                        words.add(word.toString());
                    }
                    word.setLength(0); // Сбрасываем слово
                }
            }
            if (word.length() >= 2) {
                words.add(word.toString()); // Добавляем последнее слово, если оно длинное
            }
        }

        // Выводим лексикографически минимальное слово
        System.out.println(words.first());
    }

    //------------------------------------------------------------------------------------------------------------------------

    public static void median() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int B = scanner.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        long count = 0;

        // Позиции всех вхождений B
        for (int i = 0; i < N; i++) {
            if (A[i] == B) {
                // Для каждого A[i] == B, считаем подотрезки
                int left = 0, right = 0;

                // Считаем количество элементов меньше B и больше B
                for (int j = i; j >= 0; j--) {
                    if (A[j] < B) left++;
                    if (A[j] > B) right++;
                    // если мы достигли B, мы проверяем количество элементов
                    if (A[j] == B) {
                        int k = left - right; // разница
                        if (k >= 0) { // Условие для нахождения нечетного подотрезка
                            if ((i - j + 1) % 2 == 1) { // Проверяем нечетность длины
                                count++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    //------------------------------------------------------------------------------------------------------------------------

    public static void anotherStory() {
        Scanner scanner = new Scanner(System.in);

        // Считываем количество событий
        int N = scanner.nextInt();

        // Считываем события в цивилизациях A, B и C
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            C[i] = scanner.nextInt();
        }

        // Преобразуем массив A в множество для быстрого поиска
        HashSet<Integer> setA = new HashSet<>();
        for (int a : A) {
            setA.add(a);
        }

        // Подсчет вычеркнутых событий
        int toRemove = 0;

        // Проверяем события в B
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for (int b : B) {
            mapB.put(b, mapB.getOrDefault(b, 0) + 1);
        }

        for (int b : B) {
            if (!setA.contains(b)) {
                toRemove++;
            }
        }

        // Проверяем события в C
        HashMap<Integer, Integer> mapC = new HashMap<>();
        for (int c : C) {
            mapC.put(c, mapC.getOrDefault(c, 0) + 1);
        }

        for (int c : C) {
            if (!setA.contains(c)) {
                toRemove++;
            }
        }

        // Выводим результат
        System.out.println(toRemove);

        scanner.close();
    }

    //------------------------------------------------------------------------------------------------------------------------
    private static final int MOD = 1000000007;

    public static void trueSub() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String sequence = scanner.next();

        if (n % 2 != 0) {
            System.out.println(0);
            return;
        }

        long[][][] dp = new long[n + 1][n + 1][n + 1];
        dp[0][0][0] = 1; // Базовый случай

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if (dp[i][j][k] == 0) continue;

                    char ch = sequence.charAt(i);

                    if (ch == '(' || ch == '{' || ch == '[') {
                        // Если это открывающая скобка
                        int newJ = j + 1;
                        dp[i + 1][newJ][k] = (dp[i + 1][newJ][k] + dp[i][j][k]) % MOD;
                    } else if (ch == ')' || ch == '}' || ch == ']') {
                        // Если это закрывающая скобка
                        if (j > 0) {
                            dp[i + 1][j - 1][k] = (dp[i + 1][j - 1][k] + dp[i][j][k]) % MOD;
                        }
                    } else if (ch == '?') {
                        // Если это '?', можно заменить на любую
                        // Открывающая скобка
                        dp[i + 1][j + 1][k] = (dp[i + 1][j + 1][k] + 3 * dp[i][j][k]) % MOD;
                        // Закрывающая скобка
                        if (j > 0) {
                            dp[i + 1][j - 1][k] = (dp[i + 1][j - 1][k] + 3 * dp[i][j][k]) % MOD;
                        }
                    }
                }
            }
        }

        // Подсчет всех способов, которые могут завершиться с 0 незакрытых скобок
        long result = 0;
        for (int k = 0; k <= n; k++) {
            result = (result + dp[n][0][k]) % MOD;
        }

        System.out.println(result);
        scanner.close();
    }

    //------------------------------------------------------------------------------------------------------------------------

    // Метод для вычисления длины наибольшего общего префикса
    private static int commonPrefixLength(String word1, String word2) {
        int length = 0;
        int minLength = Math.min(word1.length(), word2.length());

        while (length < minLength && word1.charAt(length) == word2.charAt(length)) {
            length++;
        }
        return length;
    }

    public static void nonEffectSearch() {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества слов в базе данных
        int n = scanner.nextInt();
        scanner.nextLine(); // Переход к следующей строке

        String[] dictionary = new String[n];

        // Чтение слов в базе данных
        for (int i = 0; i < n; i++) {
            dictionary[i] = scanner.nextLine();
        }

        // Чтение количества запросов
        int q = scanner.nextInt();
        scanner.nextLine(); // Переход к следующей строке

        // Обработка запросов
        for (int i = 0; i < q; i++) {
            String query = scanner.nextLine();
            int totalActions = 0; // Счетчик действий
            boolean found = false;

            for (String word : dictionary) {
                totalActions++; // Сравнение с текущим словом
                int prefixLength = commonPrefixLength(query, word);
                totalActions += prefixLength; // Добавляем длину общего префикса

                if (query.equals(word)) {
                    found = true; // Совпадение найдено
                    break; // Прекращаем дальнейшие сравнения
                }
            }
            System.out.println(totalActions);
        }

        scanner.close();
    }

}
