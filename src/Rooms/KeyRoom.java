package Rooms;
import Person.Player;

public class KeyRoom extends Room {

    public KeyRoom (int x, int y) {
        super (x, y);
    }

    @Override
    public void enterRoom (Player x)
    {
        System.out.println("You enter a luxury suite.");
        player1 = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

    }

    @Override
    public String toString() {

        return ("h");

    }

}
