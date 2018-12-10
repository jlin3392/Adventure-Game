package Board;

import Game.Runner;
import Rooms.Room;

public class Board {

    private Room[][] map;

    public Board() {
        this.map = map;
    }

    public void print() {
        String row = " ";
        for (int i = 0; i < map.length; i++) {
            row = " ";
            for (int j = 0; j < map[i].length; j++) {
                row += map[i][j].toString() + "\n";
            }
            System.out.println(row);
        }
    }
}
