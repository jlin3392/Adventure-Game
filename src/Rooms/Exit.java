package Rooms;

import Person.Player;

public class Exit extends Room implements lockedRoom {

    public Exit (int x, int y) {
        super(x, y);
    }

    public void checkKey() {
        //if player1's inventory contains key, end game
        //else print "The door is locked. You can't escape just yet!"


    }

    @Override
    public void enterRoom (Player player1)
    {
        System.out.println("You reached what appears to be the exit. A heavy padlock is on the door.");
        player1.setxLoc(this.xLoc);
        player1.setyLoc(this.yLoc);

    }

    @Override
    public String toString() {
        if (player1!=null) {
            return("[P]");
        } else {
            return("[E]");
        }

    }
}
