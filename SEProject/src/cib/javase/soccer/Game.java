package cib.javase.soccer;
import java.util.ArrayList;
public class Game {
    
    int id;
    Team homeTeam;
    Team awayTeam;
    ArrayList<Goal> goals = new ArrayList<Goal>();

    public Game(int id, Team homeTeam, Team awayTeam, ArrayList goals) {
        super();
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.goals = goals;
    }
    
    public String toString() {
        
        int homeGoals = 0;
        int awayGoals = 0;
        
        String homeT = this.getHomeTeam().getName();
        String awayT = this.getAwayTeam().getName();
            
        // Players        
        String res = "This game is between "+homeT+ " and "+awayT+"\n";
        res += " Home Team ("+homeT+") contains: \n";
        for (int i=0; i<this.homeTeam.getPlayers().size(); i++) {
            res+= this.homeTeam.getPlayers().get(i).toString() + "\n";
        }
        res += " Away Team ("+awayT+") contains: \n";
        for (int i=0; i<this.awayTeam.getPlayers().size(); i++) {
            res+= this.awayTeam.getPlayers().get(i).toString() + "\n";
        }
        
        // Loop on goals
        for (int i=0; i<this.getGoals().size(); i++) {
            Goal g = (Goal) this.getGoals().get(i);
            if(g.getTeam().equals(this.homeTeam))
                homeGoals++;
            if(g.getTeam().equals(this.awayTeam))
                awayGoals++;
        }
        
        // Result
        res += "The game ended with home team ("+homeT+") with score "+homeGoals+" ,And Away team (";
        res += awayT+") with score "+awayGoals+"\n";
        
        res+= "The players who scored are : \n";
        for (int i=0; i<this.getGoals().size(); i++) {
            Goal g = (Goal) this.getGoals().get(i);
            res+= " "+g.toString() + "\n";
        }
        
        return res;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setGoals(ArrayList goals) {
        this.goals = goals;
    }

    public ArrayList getGoals() {
        return goals;
    }
}
