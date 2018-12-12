package Game;

import Person.Player;
import Rooms.Exit;
import Rooms.KeyRoom;
import Rooms.Room;
import Board.Board;

import java.util.Scanner;

public class Runner {


    private static boolean gameOn = true;

    public static void main(String[] args)
    {
        Room[][] building = new Room[5][5];

        //Fill the building with normal rooms
        for (int x = 0; x < building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }

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
        System.out.println("Welcome to the SS Anne, a luxury cruise famed for its \n" +
                           "labyrinthine rooms. You managed to find your way to   \n" +
                           "last floor, but where could the exit possibly be?     \n" +
                           "\n");

        //Create a random winning room.
        int x = (int)(Math.random()*building.length);
        int y = (int)(Math.random()*building.length);
        building[x][y] = new KeyRoom(x, y);

        Board map = new Board(building);

        //Setup player 1 and the input scanner
        Player player1 = new Player("FirstName", "FamilyName", 0,0);
        building[0][0].enterRoom(player1);
        Scanner in = new Scanner(System.in);

        while(gameOn)
        {
            map.print();
            System.out.println("What would you like to do? Type 'help' for more information.");
            String statement = in.nextLine();

            if (statement.toLowerCase().equals("help") ) {
                System.out.println("In each room, you can move, look around, and get items. \n" +
                                   "You can move by choosing a direction (N, S, E, W). \n" +
                                   "You can look at your surroundings by typing 'look'. \n" +
                                   "You can get items by typing 'get' and the name of the item.");
            } else if (validMove(statement, player1, building)) {
                System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
            } else if (statement.toLowerCase().equals("look")) {
                System.out.println("Add method for look in Room class");
            } else {
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
                break;

        }
        return true;
    }

    public static void gameOff()
    {
        gameOn = false;
    }


}