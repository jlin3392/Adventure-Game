package Rooms;

import Person.Player;

public class Exit extends Room {

    public Exit (int x, int y) {
        super(x, y);
    }

    @Override
    public void enterRoom (Player x)
    {
        System.out.println("You have reached the exit.");
        player1 = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

    }

    @Override
    public String toString() {

        return ("h");

    }
}
