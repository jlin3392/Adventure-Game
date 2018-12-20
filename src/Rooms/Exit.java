package Rooms;

import Person.Player;

public class Exit extends Room {

    public Exit (int x, int y) {
        super(x, y);
    }


    /**
     * Special look option for this room.
     */
    @Override
    public void lookAround() {
        System.out.println( "A heavy padlock is on the door. When you try pulling the handle,\n" +
                            "the door barely budges.");
    }

    @Override
    public void enterRoom (Player x)
    {
        System.out.println(
                //ASCII ART CREDIT: https://www.asciiart.eu/buildings-and-places/castles
                "                ooooo                        ooooo               \n" +
                "               [     ]                      [     ]              \n" +
                "              [_______]                    [_______]             \n" +
                "               |     |  ,----------------,  |     |              \n" +
                "               |     |/'    ____..____    ',|     |              \n" +
                "               |     |    /'    ||    ',    |     |             \n" +
                "               |     |   |o     ||     o|   |     |            \n" +
                "               |  _  |   |     _||_     |   |  _  |            \n" +
                "               | (_) |   |    (_||_)    |   | (_) |            \n" +
                "               |     |   |     (||)     |   |     |            \n" +
                "               |     |   |      ||      |   |     |            \n" +
                "               |     |   |o     ||     o|   |     |            \n" +
                "              [_______]--'------''------'--[_______]             ");
        System.out.println("You reached what appears to be the exit. Would you like to try unlocking it? [Y/N]");
        player1 = x;
        player1.setxLoc(this.xLoc);
        player1.setyLoc(this.yLoc);

    }

    /**
     * Indicates which room is the exit
     * @returns [P] if player is in the room, [E] if they are not
     */
    @Override
    public String toString() {
        if (player1!=null) {
            return("[P]");
        } else {
            return("[E]");
        }
    }
}
