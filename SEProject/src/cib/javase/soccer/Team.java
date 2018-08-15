package cib.javase.soccer;

import java.util.ArrayList;

public class Team {
    
    int id;
    String name;
    ArrayList<Player> players = new ArrayList<Player>();

    public Team(int id, String name, ArrayList<Player> players) {
        super();
        this.id = id;
        this.name = name;
        this.players = players;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

}
