package Rooms;
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
        System.out.println("You enter a plain suite.");
        player1 = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

}
