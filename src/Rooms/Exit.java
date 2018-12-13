package Rooms;

import Person.Player;

public class Exit extends Room implements lockedRoom {

    public Exit (int x, int y) {
        super(x, y);
    }

    public boolean checkKey() {
        //if player1's inventory containes key, return true
        return false;

    }

    @Override
    public void enterRoom (Player player1)
    {
        //if player has key, print "You managed to find your way out."
        //else print "The door is locked. You can't escape just yet!"
        System.out.println("You reached what appears to be the exit.");
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
