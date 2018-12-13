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

    public void lookAround() {
        System.out.println((randomLookResponse[(int) ((Math.random() * 4 + 1))]));

        if (item != null) {
            if (item instanceof GranolaBar) {
                System.out.println("You find a granola bar.");
                player1.addToBag(item);

            } else if (item instanceof Ramen) {
                System.out.println("You found a package of ramen.");
                player1.addToBag(item);
            }
        }

    }

    public void enterRoom(Player x)
    {
        System.out.println("      ()___ \n" +
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

    public void leaveRoom(Player x) {
        player1 = null;
    }


    public String toString() {
        if (player1!=null) {
            return("[P]");
        } else {
            return("[ ]");
        }
    }

    private static String [] randomLookResponse = {
            "There is a lamp on the bedside drawer. When you try turning it on, it doesn't seem to work.",
            "The wallpaper is peeling in some areas.",
            "The room feels unnaturally cold.",
            "The lights above the bed flicker on and off.",
            "The room smells mildewy. You wonder how long it's been since someone stayed here."
    };

}
