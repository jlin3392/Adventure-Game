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
    public void enterRoom (Player x)
    {
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

        Scanner in = new Scanner(System.in);
        String statement = in.nextLine();

        Griffin g1 = new Griffin();

        while (statement.toLowerCase().equals("y")) {
            g1.fightGriffin(player1);

            if (g1.getHealthPoints() == 0) {
                System.out.println("There is nothing else to do in this room.");
            } else if (g1.befriended()) {
                System.out.println("You can't fight the griffin!");
            } else {
                System.out.println("Do you still want to fight the griffin? [Y/N]");
                statement = in.nextLine();
            }
        }

        if (statement.toLowerCase().equals("n")) {
            System.out.println("Smart choice. You manage to sneak away quietly.");
        } else {
            System.out.println("Please choose a valid statement.");
        }

        player1 = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

    }

    @Override
    public void lookAround() {
        System.out.println("You spot a large griffin in the room. It seems to be the only thing there.");

    }

    @Override
    public String toString() {

        if (player1!=null) {
            return("[P]");
        } else {
            return("[B]");
        }
    }


}
