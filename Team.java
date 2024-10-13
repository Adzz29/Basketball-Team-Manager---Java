public class Team {
    private int[] players;

    // Public constructor to initialize the team
    public Team(int[] players) {
        this.players = players;
    }

    // Public method to get the player at position i
    public int getPlayer(int i) {
        return players[i];
    }

    public int getLength() {
        return players.length;
    }

    // Public method to check if the team contains a specific player
    public boolean containsPlayer(int player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == player) {
                return true;
            }
        }
        return false;
    }

    // Public method to convert the team to a string
    public String toString() {
        String playerSequence = "";
        for (int i = 0; i < players.length; i++) {
            playerSequence += players[i];
            if (i < players.length - 1) {
                playerSequence += " ";
            }
        }
        return playerSequence;
    }

    public static void main(String[] args) {

    }
}
