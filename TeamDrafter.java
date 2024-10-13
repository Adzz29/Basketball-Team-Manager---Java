import java.util.Arrays;
import java.util.Random;

public class TeamDrafter {
    private Team solution;
    private Node head;

   // Linked list node class
private static class Node {
    private SuggestedTeam suggestedTeam;
    private Node next;

    // Constructor
    public Node(SuggestedTeam suggestedTeam, Node next) {
        this.suggestedTeam = suggestedTeam;
        this.next = next;
    }

    // toString method to represent the entire linked list as a string
    public String toString() {
        String result = "";
        Node current = this;

        while (current != null) {
            result += current.suggestedTeam.toString() + "\n";
            current = current.next;
        }

        return result;
    }
}

    public TeamDrafter(Team solution) {
        this.solution = solution;
        this.head = null;
    }

     public TeamDrafter() {
        this.solution = generateRandomSolution();
        this.head = null;
    }

    private Team generateRandomSolution() {
        int[] randomSolution = new int[5];
        Random rand = new Random();

        for (int i = 0; i < randomSolution.length; i++) {
            int randomPlayer;
            do {
                randomPlayer = rand.nextInt(9) + 1; // Generate a random player between 1 and 9
            } while (containsPlayer(randomSolution, randomPlayer));

            randomSolution[i] = randomPlayer;
        }

        return new Team(randomSolution);
    }

    private boolean containsPlayer(int[] array, int player) {
        for (int value : array) {
            if (value == player) {
                return true;
            }
        }
        return false;
    }
    public boolean checkSuggestedTeam(Team team) {
        SuggestedTeam suggestedTeam = new SuggestedTeam(team, solution);
        head = new Node(suggestedTeam, head);
        return suggestedTeam.isCorrect();
    }

    public Node getPreviousSuggestions() {
        return head;
    }

    public Team getSolution() {
        return solution;
    }
    public static void main(String[] args) {

    }
}
