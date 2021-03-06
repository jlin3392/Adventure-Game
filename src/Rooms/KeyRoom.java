package Rooms;

import Items.Key;
import Items.Item;
import Person.Player;

public class KeyRoom extends Room {

    Item key = new Key();

    public KeyRoom (int x, int y) {
        super (x, y);
    }


    @Override
    public void enterRoom (Player x)
    {

        System.out.println(
                //ASCII ART CREDIT: https://www.asciiart.eu/buildings-and-places/furniture/sofas
                "                         ____\n" +
                "                        /    \\\n" +
                "                       /______\\\n" +
                "                          ||\n" +
                "           /~~~~~~~~\\     ||    /~~~~~~~~~~~~~~~~\\\n" +
                "          /~ () ()  ~\\    ||   /~ ()  ()  () ()  ~\\\n" +
                "         (_)========(_)   ||  (_)==== ===========(_)\n" +
                "          I|_________|I  _||_  |___________________|\n" +
                ".//////////////////////////////////////////////////////");
        System.out.println("You enter a luxury suite.");
        player1 = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

    }

    /**
     * Special look option for this room
     * Allows user to pick up key from room if they "look"
     */
    @Override
    public void lookAround() {
        System.out.println((randomLookResponse[(int) ((Math.random() * 4 + 1))]));
        System.out.println("You find a golden key next to the lamp.");
        player1.addToBag(key);

    }

    /**
     * Indicates which room is the key room
     * @returns [P] if player is in the room, [K] if they are not
     */
    @Override
    public String toString() {

        if (player1!=null) {
            return("[P]");
        } else {
            return("[K]");
        }
    }

    /**
     * Potential random responses
     */
    private static String [] randomLookResponse = {
            "This room looks much newer than the others.",
            "You try the door to the bathroom in the suite, but it is tightly locked.",
            "You can hear a strange humming noise, but it's hard to tell where it is coming from.",
            "You try sitting on the couch, but it is uncomfortably stiff."
    };
}
