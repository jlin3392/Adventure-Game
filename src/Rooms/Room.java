package Rooms;

import Items.GranolaBar;
import Items.Ramen;
import Person.Player;
import Items.Item;

public class Room {

    Player player1;
    int xLoc, yLoc;
    Item item;


    public Room (int x, int y) {
        xLoc = x;
        yLoc = y;
        item = Room.createItem();
    }


    /**
     * Creates items and places them randomly into the rooms
     * 50% chance of item
     * @returns Item to be placed in that room
     */
    public static Item createItem() {
        int random = (int)(Math.random() * 4 + 1);

        if (random == 1) {
            return new GranolaBar();
        } else if (random == 2) {
            return new Ramen();
        } else {
            return null;
        }
    }

    /**
     * Random responses to look
     * Special text for finding granola bar or ramen
     */
    public void lookAround() {
        System.out.println((randomLookResponse[(int) ((Math.random() * 4 + 1))]));

        if (item != null) {
            if (item instanceof GranolaBar) {
                System.out.println("You found a granola bar.");
                player1.addToBag(item);

            } else if (item instanceof Ramen) {
                System.out.println("You found a package of ramen.");
                player1.addToBag(item);
            }
        }

    }

    public void enterRoom(Player x)
    {
        System.out.println(
                //ASCII ART CREDIT: https://www.asciiart.eu/buildings-and-places/furniture/beds
                "      ()___ \n" +
                "    ()//__/)_________________()\n" +
                "    ||(___)//#/_/#/_/#/_/#()/||\n" +
                "    ||----|#| |#|_|#|_|#|_|| ||\n" +
                "    ||____|_|#|_|#|_|#|_|#||/||\n" +
                "    ||    |#|_|#|_|#|_|#|_||");
        System.out.println("You enter a plain suite.");
        player1 = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }

    /**
     * Allows player to leave rooms
     * @param x
     */
    public void leaveRoom(Player x) {
        player1 = null;
    }


    /**
     * For regular rooms, prints [P] if player is in the room, [ ] if they are not
     * @return
     */
    public String toString() {
        if (player1!=null) {
            return("[P]");
        } else {
            return("[ ]");
        }
    }

    /**
     * Potential random responses
     */
    private static String [] randomLookResponse = {
            "There is a lamp on the bedside drawer. When you try turning it on, it doesn't seem to work.",
            "The wallpaper is peeling in some areas.",
            "The room feels unnaturally cold.",
            "The lights above the bed flicker on and off.",
            "The room smells mildewy. You wonder how long it's been since someone stayed here."
    };

}
