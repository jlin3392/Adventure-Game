package Board;

import Game.Runner;
import Rooms.BossRoom;
import Rooms.Exit;
import Rooms.KeyRoom;
import Rooms.Room;
import Person.Player;

public class Board {

    int width = 0;
    int height = 0;
    private Room[][] board;

    /**
     * Constructor for default board.
     * Creates KeyRoom, Exit, and BossRoom
     * @param board
     */
    public Board(Room[][] board) {
        this.board = board;

        Room[][]building = board;

        //Fill the building with normal rooms
        for (int x = 0; x < building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }

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

    }

    /**
     * Constructor for specialized board.
     * Sets height and width to create a square board and creates necessary rooms.
     * @param width
     * @param height
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        Room[][] building = new Room[width][height];
        board = building;

        //Fill the building with normal rooms
        for (int x = 0; x < building.length; x++)
        {
            for (int y = 0; y < building[x].length; y++)
            {
                building[x][y] = new Room(x,y);
            }
        }

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
    }


    /**
     * Allows player to enter a room at that location.
     * @param player1
     * @param x
     * @param y
     */
    public void enterRoom(Player player1, int x, int y) {
        this.board[x][y].enterRoom(player1);
    }

    public Room[][] getBuilding() {
        return board;
    }

    /**
     * Prints board to console.
     */
    public void print() {
        String row = "";
        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[i].length; j++) {
                row += board[i][j].toString();
            }
            System.out.println(row);
        }
    }
}
