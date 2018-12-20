package Rooms;

import Items.Key;
import Items.Item;
import Person.Player;
import Monsters.Griffin;
import java.util.Scanner;

public class BossRoom extends Room {

    public BossRoom(int x, int y) {
        super(x, y);
    }

    @Override
    public void enterRoom (Player x) {
        //ASCII ART CREDIT: https://www.asciiart.eu/mythology/gryphon
        System.out.println("                        ______\n" +
                "             ______,---'__,---'\n" +
                "         _,-'---_---__,---'\n" +
                "  /_    (,  ---____',\n" +
                " /  ',,   `, ,-'\n" +
                ";/)   ,',,_/,'\n" +
                "| /\\   ,.'//\\\n" +
                "`-` \\ ,,'    `.\n" +
                "     `',   ,-- `.\n" +
                "     '/ / |      `,         _\n" +
                "     //'',.\\_    .\\\\      ,{==>-\n" +
                "  __//   __;_`-  \\ `;.__,;'\n" +
                "((,--,) (((,------;  `--' jv\n" +
                "```  '   ```");
        System.out.println("You encounter a griffin! How did it even get in here?");
        System.out.println("Do you want to fight the griffin? [Y/N]");

        player1 = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

        Scanner in = new Scanner(System.in);
        String statement = in.nextLine();

        Griffin g1 = new Griffin();

        /*
        While griffin is alive, griffin is not befriended, and player chooese Y, fights griffin
         */
        while (statement.toLowerCase().equals("y") && !g1.isGriffinDead() && !g1.befriended()) {
            g1.fightGriffin(player1);

            if (g1.befriended()) {
                System.out.println("You can't fight the griffin!");
            } else if (g1.isGriffinDead()) {
                System.out.println("The griffin is dead.");
            } else {
                System.out.println("Do you still want to fight the griffin? [Y/N]");
                statement = in.nextLine();
            }

        }

        /*
        If player chooses N, allows them to avoid fighting
         */
        if (statement.toLowerCase().equals("n")) {
            System.out.println("Smart choice. You manage to sneak away quietly.");
        } else if (!statement.toLowerCase().equals("n") && !statement.toLowerCase().equals("y")) {
            System.out.println("Please choose a valid statement.");
            statement = in.nextLine();
        }
    }

    /**
     * Special look text option for this room
     */
    @Override
    public void lookAround() {
        System.out.println("You spot a large griffin in the room. It seems to be the only thing there.");

    }

    /**
     * Indicates which room is the boss room
     * @returns [P] if player is in the room and [B] if they are not
     */
    @Override
    public String toString() {

        if (player1!=null) {
            return("[P]");
        } else {
            return("[B]");
        }
    }


}
