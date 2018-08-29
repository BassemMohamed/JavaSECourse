package cib.se.project.soccer;

public class Goal {

    int id;
    Team team;
    Player player;
    double time;


    public Goal(int id, Team team, Player player, double time) {
        super();
        this.id = id;
        this.team = team;
        this.player = player;
        this.time = time;
    }


    public String toString() {
        return "Goal scored by " + this.player.getName() + " at " + this.time + " for " + this.team.getName();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }
}
