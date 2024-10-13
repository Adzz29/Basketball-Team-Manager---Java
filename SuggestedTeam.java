public class SuggestedTeam {
    private Team suggestion;
    private Team solution;

    // Public constructor that takes two Team arguments
    public SuggestedTeam(Team suggestion, Team solution) {
        this.suggestion = suggestion;
        this.solution = solution;
    }

    // Public getter method to return the suggested Team
    public Team getTeam() {
        return suggestion;
    }

    // Public getter method to return the number of correctly positioned players
    public int getNumGood() {
        int numGood = 0;
        for (int i = 0; i < suggestion.getLength(); i++) {
            if (suggestion.getPlayer(i) == solution.getPlayer(i)) {
                numGood++;
            }
        }
        return numGood;
    }

    // Public getter method to return the number of players suitable for the team but not in the right position
    public int getNumWrongSpot() {
         int numWrongspot = 0;
        for (int i = 0; i < suggestion.getLength(); i++) {
            if (suggestion.getPlayer(i) != solution.getPlayer(i) && suggestion.containsPlayer(solution.getPlayer(i))) {
                numWrongspot++;
            }
        }
        return numWrongspot;

    }

    public boolean isCorrect() {
        return getNumGood() == suggestion.getLength() && getNumWrongSpot() == 0;
    }

    // Public toString method to represent the player team followed by the number of good and badly placed players
    public String toString() {
        return suggestion.toString() + " (Good " + getNumGood() + ", Wrong spot " + getNumWrongSpot() + ")";
    }
}
