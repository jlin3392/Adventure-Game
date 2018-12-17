package Rooms;

import Items.Key;
import Person.Player;

public class Exit extends Room implements lockedRoom {

    public Exit (int x, int y) {
        super(x, y);
    }

//FIX EXIT CODE
    public void checkKey() {
        if (player1.hasKey() == true) {
            System.out.println("You unlocked the exit and managed to escape!");
            Game.Runner.gameOff();
        } else {
            System.out.println("It doesn't seem like you have a key. The exit remains locked.");
        }
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
