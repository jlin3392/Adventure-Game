package Rooms;

import Game.Runner;
import Person.Player;

public class Room {

    Player player1;
    int xLoc, yLoc;


    public Room (int x, int y) {
        xLoc = x;
        yLoc = y;
    }

    public void enterRoom(Player x)
    {
        System.out.println("      ()___ \n" +
                "    ()//__/)_________________()\n" +
                "    ||(___)//#/_/#/_/#/_/#()/||\n" +
                "    ||----|#| |#|_|#|_|#|_|| ||\n" +
                "    ||____|_|#|_|#|_|#|_|#||/||\n" +
                "    ||    |#|_|#|_|#|_|#|_||");
        System.out.println("You enter a plain suite.");
        player1 = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    public void leaveRoom(Player x) {
        player1 = null;
    }

    public String toString() {
        if (player1!=null) {
            return("[P]");
        } else {
            return("[ ]");
        }
    }

}
