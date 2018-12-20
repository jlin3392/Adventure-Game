package Monsters;

import Person.Player;
import Game.Runner;
import Items.Key;

public class Griffin {

    int scenario = 0;
    int griffinHealthPoints = 10;
    boolean griffinDead = false;

    //Creates new Key that is added to bag if player befriends griffin.
    Key key = new Key();

    /**
     * Randomly selects one of 5 scenarios that the player can encounter
     * while fighting the griffin.
     * @param player1
     */
    public void fightGriffin(Player player1) {

        scenario = (int) (Math.random() * 5 + 1);

        if (!befriended()) {

            //Griffin attacks player
            if (scenario == 1) {
                System.out.println("The griffin attacks you! You lose 4 health points.");
                player1.loseHealth(4);

                //Griffin kills player
                if (player1.getHealthPoints() <= 0) {
                    System.out.println("The griffin killed you. Game over!");
                    System.exit(0);
                }

                System.out.println("Your HP: " + player1.getHealthPoints());

            //Player attacks griffin.
            } else if (scenario == 2) {
                System.out.println("You attack the griffin. It screeches in pain when you hit a critical spot.");
                griffinHealthPoints = griffinHealthPoints - 5;

            //Griffin kills player instantly. Game ends.
            } else if (scenario == 3) {
                System.out.println("The griffin flies into a rage and kills you.");
                System.out.println("Game over!");
                System.exit(0);

            //Griffin befriends player and gives them a key.
            } else if (scenario == 4) {
                System.out.println("You befriend the griffin. It gives you a golden key.");
                player1.addToBag(key);

            //Griffin remains neutral
            } else if (scenario == 5) {
                System.out.println("The griffin seems uninterested in fighting you.");
            }

            //Griffin dies
            if (griffinHealthPoints == 0) {
                System.out.println("The griffin dies. You feel a strange hollowness in your chest at its death.");
                griffinDead = true;
            }
        } else if (befriended()) {
            System.out.println("You can't fight the griffin!");
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

    public boolean isGriffinDead() {
        if (griffinHealthPoints == 0) {
            return true;
        }
        return false;
    }
}
