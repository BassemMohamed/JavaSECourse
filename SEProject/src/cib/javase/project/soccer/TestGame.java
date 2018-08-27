package cib.javase.project.soccer;

import java.util.ArrayList;

public class TestGame {
    public static void main(String[] args) {

        ArrayList<Player> p1 = new ArrayList<Player>();
        Player p11 = new Player(101, 1, "Ahmed", 21);
        p1.add(new Player(102, 2, "Anwar", 21));
        p1.add(new Player(103, 3, "Aktham", 21));
        p1.add(p11);

        Team t1 = new Team(201, "Ismaily", p1);

        ArrayList<Player> p2 = new ArrayList<Player>();
        Player p22 = new Player(101, 1, "Mostafa", 21);
        p2.add(p22);
        p2.add(new Player(102, 2, "Mohamed", 21));
        p2.add(new Player(103, 3, "Mamdoh", 21));

        Team t2 = new Team(201, "Ahly", p2);

        ArrayList<Goal> g = new ArrayList<Goal>();
        g.add(new Goal(901, t1, p11, 10.55));
        g.add(new Goal(901, t2, p22, 15.87));
        g.add(new Goal(901, t1, p11, 20.65));

        System.out.println(new Game(501, t1, t2, g));

    }
}
