package org.example.tbank;

import org.example.Main;

import java.util.*;

public class TBank {

    private void firstTask() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<Integer> numbers = new TreeSet<>();  // Используем TreeSet для автоматической сортировки

        // Разделяем строку на интервалы
        String[] intervals = input.split(",");

        for (String interval : intervals) {
            String[] bounds = interval.split("-");
            if (bounds.length == 1) {
                // Если это просто одно число
                numbers.add(Integer.parseInt(bounds[0]));
            } else if (bounds.length == 2) {
                // Если это интервал
                int start = Integer.parseInt(bounds[0]);
                int end = Integer.parseInt(bounds[1]);
                for (int i = start; i <= end; i++) {
                    numbers.add(i);
                }
            }
        }

        // Конвертируем множество в строку и выводим
        StringBuilder result = new StringBuilder();
        for (int number : numbers) {
            result.append(number).append(" ");
        }

        System.out.println(result.toString().trim());  // Убираем лишний пробел в конце
    }


    private void secondTask() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Количество дней
        int[] measurements = new int[n];

        for (int i = 0; i < n; i++) {
            measurements[i] = scanner.nextInt(); // Заполняем массив измерений
        }

        if (isValidMeasurement(measurements, n)) {
            int[] dailySnowfall = calculateDailySnowfall(measurements, n);
            System.out.println("YES");
            for (int snowfall : dailySnowfall) {
                System.out.print(snowfall + " ");
            }
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isValidMeasurement(int[] measurements, int n) {
        int lastValidMeasurement = 0; // Начальное значение снега

        for (int i = 0; i < n; i++) {
            if (measurements[i] != -1) {
                // Проверка текущего значения на последовательность
                if (measurements[i] <= lastValidMeasurement) {
                    return false; // Значение должно быть больше предыдущего
                }
                lastValidMeasurement = measurements[i];
            }
        }
        return true;
    }

    private static int[] calculateDailySnowfall(int[] measurements, int n) {
        int[] dailySnowfall = new int[n];
        int lastValidMeasurement = 0; // Для расчета

        for (int i = 0; i < n; i++) {
            if (measurements[i] != -1) {
                // Если измерение есть, вычисляем количество снега
                dailySnowfall[i] = measurements[i] - lastValidMeasurement;
                lastValidMeasurement = measurements[i]; // фиксируем последнее измерение
            } else {
                // Если измерение неразличимо, ставим минимально возможное значение
                dailySnowfall[i] = 1; // начнем с 1, увеличив в дальнейшем, чтобы сохранить строгость
                lastValidMeasurement += dailySnowfall[i]; // увеличиваем lastValidMeasurement
            }
        }

        return dailySnowfall;
    }

    private void thirdTask() {
        Scanner scanner = new Scanner(System.in);

        String sequence = scanner.nextLine(), requiredChars = scanner.nextLine();
        int maxLength = scanner.nextInt();

        Map<Character, Integer> requiredMap = new HashMap<>();
        for (char c : requiredChars.toCharArray()) {
            requiredMap.put(c, requiredMap.getOrDefault(c, 0) + 1);
        }

        int requiredCount = requiredMap.size(), formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();

        int left = 0, right = 0;
        String bestPassword = "";

        while (right < sequence.length()) {
            char currentChar = sequence.charAt(right);
            windowCounts.put(currentChar, windowCounts.getOrDefault(currentChar, 0) + 1);

            if (requiredMap.containsKey(currentChar) && windowCounts.get(currentChar).intValue() == requiredMap.get(currentChar).intValue()) {
                formed++;
            }

            while (formed == requiredCount && left <= right) {
                int windowLength = right - left + 1;

                if (windowLength <= maxLength) {
                    String candidate = sequence.substring(left, right + 1);
                    if (candidate.length() > bestPassword.length() ||
                            (candidate.length() == bestPassword.length() && sequence.lastIndexOf(candidate) > sequence.lastIndexOf(bestPassword))) {
                        bestPassword = candidate;
                    }
                }

                char charToRemove = sequence.charAt(left);
                windowCounts.put(charToRemove, windowCounts.get(charToRemove) - 1);
                if (requiredMap.containsKey(charToRemove) && windowCounts.get(charToRemove).intValue() < requiredMap.get(charToRemove).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        if (!bestPassword.isEmpty()) {
            System.out.println(bestPassword);
        } else {
            System.out.println("");
        }

        scanner.close();
    }

    private void fourthTask() {

    }

    private void fiveTask() {
                Scanner scanner = new Scanner(System.in);

                String sequence = scanner.nextLine(), requiredChars = scanner.nextLine();
                int maxLength = scanner.nextInt();

                Map<Character, Integer> requiredMap = new HashMap<>();
                for (char c : requiredChars.toCharArray()) {
                    requiredMap.put(c, requiredMap.getOrDefault(c, 0) + 1);
                }

                int requiredCount = requiredMap.size();
                Map<Character, Integer> windowCounts = new HashMap<>();

                int left = 0, right = 0;
                String bestPassword = "";

                while (right < sequence.length()) {
                    char currentChar = sequence.charAt(right);
                    windowCounts.put(currentChar, windowCounts.getOrDefault(currentChar, 0) + 1);

                    while (containsAllRequired(windowCounts, requiredMap)) {
                        int windowLength = right - left + 1;

                        if (windowLength <= maxLength) {
                            String candidate = sequence.substring(left, right + 1);
                            if (candidate.length() > bestPassword.length() ||
                                    (candidate.length() == bestPassword.length() && sequence.lastIndexOf(candidate) > sequence.lastIndexOf(bestPassword))) {
                                bestPassword = candidate;
                            }
                        }

                        char charToRemove = sequence.charAt(left);
                        windowCounts.put(charToRemove, windowCounts.get(charToRemove) - 1);
                        if (windowCounts.get(charToRemove) == 1) {
                            windowCounts.remove(charToRemove);
                        }
                        left++;
                    }
                    right++;
                }
                System.out.println(bestPassword.isEmpty() ? "" : bestPassword);
                scanner.close();
            }

            private static boolean containsAllRequired(Map<Character, Integer> windowCounts, Map<Character, Integer> requiredMap) {
                for (char reqChar : requiredMap.keySet()) {
                    if (windowCounts.getOrDefault(reqChar, 0) < requiredMap.get(reqChar)) {
                        return false;
                    }
                }
                return true;
            }
        }

//    }
//
//    static class Process {
//        int duration;
//        List<Integer> dependencies;
//
//        Process(int duration) {
//            this.duration = duration;
//            this.dependencies = new ArrayList<>();
//        }
//    }
//
//    private void sixthTask() {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        Main.Process[] processes = new Main.Process[n + 1];
//        int[] inDegree = new int[n + 1];
//        List<Integer>[] graph = new ArrayList[n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for (int i = 1; i <= n; i++) {
//            String[] line = scanner.nextLine().split(" ");
//            int duration = Integer.parseInt(line[0]);
//            processes[i] = new Main.Process(duration);
//            for (int j = 1; j < line.length; j++) {
//                int dependency = Integer.parseInt(line[j]);
//                processes[i].dependencies.add(dependency);
//                graph[dependency].add(i);
//                inDegree[i]++;
//            }
//        }
//
//        int[] completionTimes = new int[n + 1];
//        Queue<Integer> queue = new LinkedList<>();
//
//        for (int i = 1; i <= n; i++) {
//            if (inDegree[i] == 0) {
//                queue.add(i);
//                completionTimes[i] = processes[i].duration;
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int curr = queue.poll();
//            for (int neighbor : graph[curr]) {
//                inDegree[neighbor]--;
//                completionTimes[neighbor] = Math.max(completionTimes[neighbor], completionTimes[curr] + processes[neighbor].duration);
//                if (inDegree[neighbor] == 0) {
//                    queue.add(neighbor);
//                }
//            }
//        }
//
//        int result = 0;
//        for (int i = 1; i <= n; i++) {
//            result = Math.max(result, completionTimes[i]);
//        }
//
//        System.out.println(result);
//        scanner.close();
//    }
//}
