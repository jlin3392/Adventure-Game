package Board;

import Game.Runner;
import Rooms.BossRoom;
import Rooms.Exit;
import Rooms.KeyRoom;
import Rooms.Room;

public class Board {

    int width = 0;
    int height = 0;

    private Room[][] board;

    public Board(Room[][] board) {
        this.board = board;

        Room[][]building = board;

        System.out.println(board.length);
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


    public Board(int width, int height) {
        width = this.width;
        height = this.height;

        Room[][] building = new Room[width][height];

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
