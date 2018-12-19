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

        //Setup player 1 and input scanner
        Scanner in = new Scanner(System.in);
        System.out.println("Hello, what is your name?");
        String firstName = in.nextLine();
        Player player1 = new Player(firstName, 0, 0);



        System.out.println("Hello, " + firstName +". Would you like to play the default map\n" +
                           "or a custom map? Type 'D' for default and 'C' for custom.");
        String statement = in.nextLine();

        Room[][] building = new Room[1][1];
        Board map = new Board(building);


        if (statement.toLowerCase().equals("d")) {

            building = new Room[5][5];
            map = new Board(building);
            building[0][0].enterRoom(player1);

        } else if (statement.toLowerCase().equals("c")) {

            System.out.println("Enter the width of your custom map.");
            int width = Integer.parseInt(in.nextLine());
            System.out.println("Enter the height of your custom map.");
            int height = Integer.parseInt(in.nextLine());


            map = new Board(width, height);
            building[0][0].enterRoom(player1);

        } else {
            System.out.println("Please enter a valid response.");
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
        System.out.println("Welcome aboard the Black Whale, " + firstName + ".\n" +
                            "This cruise ship used to be famous for its extravagance, \n" +
                            "but in recent years it has become known for its maze-like \n" +
                            "rooms. You managed to find your way to the last floor, but \n" +
                            "will you be able to escape?");


        //Setup player 1 and the input scanner

        map.print();

        while(gameOn) {

            if (player1.getHealthPoints() <= 0) {
                System.out.println("You died! Game over.");
                gameOff();
            }

            System.out.println("What would you like to do? Type 'help' for more information.");
            statement = in.nextLine();


             //Help function offers options to the user.
             if(statement.toLowerCase().equals("help")) {
                System.out.println("In each room, you can move, look around, and get items. \n" +
                        "You can move by choosing a direction (N, S, E, W). \n" +
                        "You can look at your surroundings by typing 'look'. \n" +
                        "You can look at your inventory by typing 'bag'. \n" +
                        "You can eat a consumable in your bag if you have one by typing 'eat'.");
            } else if (validMove(statement, player1, building)) {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
                map.print();
            } else if (statement.toLowerCase().equals("look")) {
                building[player1.getxLoc()][player1.getyLoc()].lookAround();
            } else if (statement.toLowerCase().equals("bag")) {
                player1.checkBag();
            } else if (statement.toLowerCase().equals("eat")) {
                player1.eatConsumable();
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