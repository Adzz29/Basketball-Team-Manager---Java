import java.util.Scanner;

public class TeamDrafterCLI {

    public static void main(String[] args) {
        TeamDrafter teamDrafter = new TeamDrafter();
        playGame(teamDrafter);
    }

    public static void playGame(TeamDrafter teamDrafter) {
        Scanner scanner = new Scanner(System.in);

          while (true) {
            // Display previous attempts
            System.out.println("Previous attempts:");
            TeamDrafter.Node previousSuggestions = teamDrafter.getPreviousSuggestions();
            if (previousSuggestions == null) {
                System.out.println("No previous attempts");
            } else {
                System.out.println(previousSuggestions.toString());
            }

            // Ask the user to enter a new team
            System.out.print("Enter new team: ");
            int[] userTeamArray = new int[5];

            // Validate and read user input
            boolean isValidInput = false;
            while (!isValidInput) {
                String[] inputTokens = scanner.nextLine().split(" ");
                if (inputTokens.length == 5) {
                    isValidInput = true;
                    for (int i = 0; i < 5; i++) {
                        try {
                            userTeamArray[i] = Integer.parseInt(inputTokens[i]);
                            // Validate if the number corresponds to a player from Sandford
                            if (userTeamArray[i] < 1 || userTeamArray[i] > 9) {
                                isValidInput = false;
                                System.out.println("Invalid team! Please enter valid player numbers.");
                                break;
                            }
                        } catch (NumberFormatException e) {
                            isValidInput = false;
                            System.out.println("Invalid team! Please enter valid integers.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid input! Please enter 5 integers separated by spaces.");
                }
            }

            // Create a Team object from user input
            Team userTeam = new Team(userTeamArray);

            // Check if the suggested team is correct
            if (teamDrafter.checkSuggestedTeam(userTeam)) {
                System.out.println("The final team is:");
                printTeamNames(userTeam);
                break;
            } else {
                System.out.println("Sorry, that's not the correct team. Try again!");
            }
        }
    }

    private static void printTeamNames(Team team) {
        // Implement logic to print the names corresponding to jersey numbers
        // You may use a predefined array or switch statements to map jersey numbers to names
        // For simplicity, let's assume there's a method getPlayerName in the Team class
        for (int i = 0; i < 5; i++) {
            System.out.println("Player " + team.getPlayer(i) + ": " + getFakePlayerName(team.getPlayer(i)));
        }
    }

    // A placeholder method to simulate fetching player names based on jersey numbers
    private static String getFakePlayerName(int jerseyNumber) {
        switch (jerseyNumber) {
            case 1: return "John Doe";
            case 2: return "Jane Smith";
            // Add more cases as needed
            default: return "Unknown Player";
        }
    }
}
