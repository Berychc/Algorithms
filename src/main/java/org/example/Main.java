package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static class ServerResult {
        String teamName;
        int hackedCount;
        int penaltyTime;

        ServerResult(String teamName) {
            this.teamName = teamName;
            this.hackedCount = 0;
            this.penaltyTime = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime startTime = LocalTime.parse(scanner.nextLine(), timeFormatter);
        int numRequests = Integer.parseInt(scanner.nextLine());

        Map<String, ServerResult> results = new HashMap<>();
        Map<String, Map<Character, Integer>> failedAttempts = new HashMap<>();

        for (int i = 0; i < numRequests; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String teamName = parts[0].replace("\"", "");
            LocalTime requestTime = LocalTime.parse(parts[1], timeFormatter);
            char serverId = parts[2].charAt(0);
            String result = parts[3];

            results.putIfAbsent(teamName, new ServerResult(teamName));
            ServerResult teamResult = results.get(teamName);
            failedAttempts.putIfAbsent(teamName, new HashMap<>());
            int timePassed = (int) (java.time.Duration.between(startTime, requestTime).toMinutes());

            if ("ACCESSED".equals(result)) {
                teamResult.hackedCount++;
                teamResult.penaltyTime += timePassed;

                if (failedAttempts.get(teamName).containsKey(serverId)) {
                    int failedCount = failedAttempts.get(teamName).get(serverId);
                    teamResult.penaltyTime += 20 * failedCount;
                }
                failedAttempts.get(teamName).remove(serverId);
            } else if ("DENIED".equals(result) || "FORBIDEN".equals(result)) {
                failedAttempts.get(teamName).put(serverId, failedAttempts.get(teamName).getOrDefault(serverId, 0) + 1);
            }
        }

        List<ServerResult> resultList = new ArrayList<>(results.values());

        resultList.sort((a, b) -> {
            if (b.hackedCount != a.hackedCount) {
                return Integer.compare(b.hackedCount, a.hackedCount);
            } else if (a.penaltyTime != b.penaltyTime) {
                return Integer.compare(a.penaltyTime, b.penaltyTime);
            } else {
                return a.teamName.compareTo(b.teamName);
            }
        });

        int currentPosition = 1;
        for (int i = 0; i < resultList.size(); i++) {
            ServerResult result = resultList.get(i);
            if (i > 0 && (result.hackedCount != resultList.get(i - 1).hackedCount || result.penaltyTime != resultList.get(i - 1).penaltyTime)) {
                currentPosition = i + 1;
            }
            System.out.printf("%d \"%s\" %d %d%n", currentPosition, result.teamName, result.hackedCount, result.penaltyTime);
        }
        scanner.close();
    }
}