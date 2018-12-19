package Monsters;

import Person.Player;
import Game.Runner;
import Items.Key;

public class Griffin {

    int scenario = 0;
    int griffinHealthPoints = 10;

    Key key = new Key();

    public void fightGriffin(Player player1) {

        scenario = (int)(Math.random() * 5 + 1);

        if (scenario == 1) {
            System.out.println("The griffin attacks you! You lose 4 health points.");
            player1.loseHealth(4);

            if (player1.getHealthPoints() <= 0) {
                System.out.println("The griffin killed you. Game over!");
                System.exit(0);
            }

            System.out.println("Your HP: "+ player1.getHealthPoints());
        } else if (scenario == 2) {
            System.out.println("You attack the griffin. It screeches in pain when you hit a critical spot.");
            griffinHealthPoints = griffinHealthPoints - 5;
        } else if (scenario == 3) {
            System.out.println("The griffin flies into a rage and kills you.");
            System.out.println("Game over!");
            System.exit(0);
        } else if (scenario == 4) {
            System.out.println("You befriend the griffin. It gives you a golden key.");
            player1.addToBag(key);
        } else if (scenario == 5) {
            System.out.println("The griffin seems uninterested in fighting you.");
        }

        if (griffinHealthPoints == 0) {
            System.out.println("The griffin dies. You feel a strange hollowness in your chest at its death.");
        }
    }

    public int getHealthPoints() {
        return griffinHealthPoints;
    }

    public boolean befriended() {
        if (scenario == 4) {
            return true;
        }

        return false;
    }
}
