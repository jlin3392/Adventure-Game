package Rooms;

import Person.Player;

public class Exit extends Room {

    public Exit (int x, int y) {
        super(x, y);
    }

    @Override
    public void enterRoom (Player x)
    {
        //if player has key, print "You managed to find your way out."
        //else print "The door is locked. You can't escape just yet!"
        System.out.println("You reached what appears to be the exit.");
        player1 = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

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
