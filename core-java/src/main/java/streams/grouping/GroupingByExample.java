package streams.grouping;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class GroupingByExample {
    public static void main(String[] args) throws IOException {
        List<Player> players = loadPlayers();

        groupByYear(players);
        groupByYearAndTeam(players);
    }

    private static void groupByYearAndTeam(List<Player> players) {
        Map<List<String>, List<Player>> grouped = players.stream()
                .collect(Collectors.groupingBy(x ->
                        new ArrayList<>(asList(Integer.toString(x.getYear()), x.getTeamID()))));

        grouped
                .entrySet()
                .stream()
                .forEach(x -> {
                    System.out.println(x.getKey());
                    x.getValue().stream()
                            .forEach(p -> System.out.printf(" ( %2s %-10s %-10d )%n", p.getLgID(), p.getPlayerID(), p.getSalary()));
                });
    }

    private static void groupByYear(List<Player> players) {
        Map<Integer, List<Player>> grouped = players.stream()
                .collect(Collectors.groupingBy(Player::getYear));

        System.out.println("Group By Year:");
        grouped.entrySet().forEach(System.out::println);
    }

    public static List<Player> loadPlayers() throws IOException {
        List<Player> players;
        Pattern pattern = Pattern.compile(",");
        Path path = Paths.get("src", "main", "resources");

        try (BufferedReader in = Files.newBufferedReader(path.resolve("grouping.txt"))) {
            players = in
                    .lines().skip(1)
                    .map(line -> {
                        String[] arr = pattern.split(line);
                        return new Player(Integer.parseInt(arr[0]),
                                arr[1],
                                arr[2],
                                arr[3],
                                Integer.parseInt(arr[4]));
                    })
                    .collect(Collectors.toList());

        }
        return players;
    }

    static class Player {
        private int year;
        private String teamID;
        private String lgID;
        private String playerID;
        private int salary;

        public Player(int year, String teamID, String lgID, String playerID, int salary) {
            this.year = year;
            this.teamID = teamID;
            this.lgID = lgID;
            this.playerID = playerID;
            this.salary = salary;
        }

        public int getYear() {
            return this.year;
        }

        public String getTeamID() {
            return this.teamID;
        }

        public String getLgID() {
            return lgID;
        }

        public String getPlayerID() {
            return playerID;
        }

        public int getSalary() {
            return salary;
        }
    }
}
