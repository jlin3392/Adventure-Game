package Rooms;

import Person.Player;

public class Exit extends Room {

    public Exit (int x, int y) {
        super(x, y);
    }


    @Override
    public void lookAround() {
        System.out.println( "A heavy padlock is on the door. When you try pulling the handle," +
                            "the door barely budges.");
    }

    @Override
    public void enterRoom (Player player1)
    {
        System.out.println(
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
