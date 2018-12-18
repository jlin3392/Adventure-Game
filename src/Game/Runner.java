package Game;

import Person.Player;
import Rooms.BossRoom;
import Rooms.Exit;
import Rooms.KeyRoom;
import Rooms.Room;
import Board.Board;

import java.util.Scanner;

public class Runner {

    private static boolean gameOn = true;

    public static void main(String[] args)
    {
/**
        //Setup player 1 and input scanner
        Scanner in = new Scanner(System.in);
        System.out.println("Hello, what is your name?");
        String firstName = in.nextLine();
        Player player1 = new Player(firstName, 0, 0);
 **/

        /**
        System.out.println("Hello, " + firstName +". Would you like to play the default map" +
                           "or a custom map? Type 'D' for default and 'C' for custom.");
        String statement = in.nextLine();



        if (statement.toLowerCase().equals("D")) {
            width = 5;
            height = 5;
        } else if (statement.toLowerCase().equals("C")) {
            System.out.println("Enter the width of your custom map.");
            width = Integer.parseInt(in.nextLine());
            System.out.println("Enter the height of your custom map.");
            height = Integer.parseInt(in.nextLine());

        } else {
            System.out.println("Please enter a valid response.");
        }
        **/

        Room[][] building = new Room[5][5];



        //Fill the building with normal rooms
        for (int x = 0; x < building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }

        /*
            Introduction to the game with the opening scene.
         */
        System.out.println("                                               .   . .\n" +
                "                                            .  . .  ' \n" +
                "                                       . '. '\n" +
                "                                      :'\n" +
                "                                     .;      o t         o\n" +
                "                                     ..    p     p     p\n" +
                "                                  .--++-.          o t\n" +
                "                               .__|]_[]_'-...... \n" +
                "                                \\ o o o '=-=-=-!\n" +
                "\"'\"''\"\"'\"\"\"''''\"'\"''\"\"'''~~~~~~~~\\_____________|~~~~MC~~~~");
        System.out.println("Welcome aboard the Black Whale, " + " " + ".\n" +
                            "This cruise ship used to be famous for its extravagance, \n" +
                            "but in recent years it has become known for its maze-like \n" +
                            "rooms. You managed to find your way to the last floor, but \n" +
                            "will you be able to escape?");

        //Create a random key room.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new KeyRoom(x, y);

        //Create a random exit.
        int a = (int)(Math.random()*building.length);
        int b = (int)(Math.random()*building.length);
        while (building[a][b] instanceof KeyRoom) {
            a = (int)(Math.random()*building.length);
            b = (int)(Math.random()*building.length);
        }
        building[a][b] = new Exit(a, b);

        //Create a random boss room.
        int n = (int)(Math.random()*building.length);
        int m = (int)(Math.random()*building.length);
        while (building[n][m] instanceof KeyRoom || building[n][m] instanceof Exit) {
            n = (int)(Math.random()*building.length);
            m = (int)(Math.random()*building.length);
        }
        building[n][m] = new BossRoom(n, m);

        Board map = new Board(building);

        //Setup player 1 and the input scanner
        Player player1 = new Player("FirstName", 0,0);
        building[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);
        map.print();

        while(gameOn) {

            if (player1.getHealthPoints() <= 0) {
                System.out.println("You died! Game over.");
                gameOff();
            }

            System.out.println("What would you like to do? Type 'help' for more information.");
            String statement = in.nextLine();


             //Help function offers options to the user.
             if(statement.toLowerCase().equals("help")) {
                System.out.println("In each room, you can move, look around, and get items. \n" +
                        "You can move by choosing a direction (N, S, E, W). \n" +
                        "You can look at your surroundings by typing 'look'. \n" +
                        "You can look at your inventory by typing 'bag'.");
            } else if (validMove(statement, player1, building)) {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                map.print();
            } else if (statement.toLowerCase().equals("look")) {
                building[player1.getxLoc()][player1.getyLoc()].lookAround();
            } else if (statement.toLowerCase().equals("bag")) {
                player1.checkBag();
            } else if (building[player1.getxLoc()][player1.getyLoc()] instanceof Exit && statement.toLowerCase().equals("y")) {
                if (player1.hasKey()) {
                    System.out.println("The door opens with a satisfying click. You're free!");
                    gameOff();
                } else {
                    System.out.println("You don't seem to have the key on you. The door remains locked.");
                }
            } else if (building[player1.getxLoc()][player1.getyLoc()] instanceof Exit && statement.toLowerCase().equals("n")) {
                    System.out.println("You decide not to unlock the door.");
            }else{
                System.out.println("Please choose a valid move.");
            }
        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of rooms
     * @return
     */
    public static boolean validMove(String move, Player p, Room[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                return false;

        }
    }

    public static void gameOff()
    {
        gameOn = false;
    }

}