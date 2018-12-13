package Rooms;

import Game.Runner;
import Items.Key;
import Items.Item;
import Person.Player;

public class KeyRoom extends Room {

    public KeyRoom (int x, int y) {
        super (x, y);
    }

    @Override
    public void enterRoom (Player x)
    {
        System.out.println("                         ____\n" +
                "                        /    \\\n" +
                "                       /______\\\n" +
                "                          ||\n" +
                "           /~~~~~~~~\\     ||    /~~~~~~~~~~~~~~~~\\\n" +
                "          /~ () ()  ~\\    ||   /~ ()  ()  () ()  ~\\\n" +
                "         (_)========(_)   ||  (_)==== ===========(_)\n" +
                "          I|_________|I  _||_  |___________________|\n" +
                ".////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        System.out.println("You enter a luxury suite.");
        player1 = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

    }

    @Override
    public String toString() {

        if (player1!=null) {
            return("[P]");
        } else {
            return("[R]");
        }
    }

}
