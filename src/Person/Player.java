package Person;

import Items.Consumable;
import Items.GranolaBar;
import Items.Ramen;
import Items.Item;
import Items.Key;

/**
 * Person represents the player as they move through the game.
 */
public class Player {
    String firstName;
    int xLoc, yLoc;

    int healthPoints = 10;
    int itemPlace = 0;

    private Item[] inventory = new Item[10];
    String totalInventory = "";


    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public Player (String firstName, int xLoc, int yLoc)
    {
        this.firstName = firstName;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    /**
     * Restores HP by amount.
     * @param amount
     */
    public void restoreHealth(int amount) {
        healthPoints = healthPoints + amount;
    }

    /**
     * Loses HP by amount.
     * @param amount
     */
    public void loseHealth(int amount) {
        healthPoints = healthPoints - amount;
    }

    /**
     * Adds item to bag and sets limit on number of items allowed
     * @param item
     */
    public void addToBag(Item item) {

        if (bagSpace() == 11) {
            System.out.println("Your bag is full!");
        } else {
            inventory[bagSpace()] = item;
        }

    }

    public int bagSpace() {
        for (int i = 0; i < 10; i++) {
            if (inventory[i] == null) {
                return i;
            }
        }
        return 11;
    }

    /**
     * Allows user to check bag contents and prints them
     */
    public void checkBag() {

        totalInventory = "";

        for (int i = 0; i < inventory.length; i++) {
           if (inventory[i] != null) {
                totalInventory = totalInventory + " " + inventory[i].toString() + " ";
            }
        }


        if (bagEmpty() == true) {
            System.out.println("Your bag is empty.");
        } else {
            System.out.println("Your bag currently has: " + totalInventory);
        }
    }

    /**
     * Checks if bag is empty
     * @returns true if bag is empty and false if it isn't
     */
    public boolean bagEmpty() {

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if bag has a consumable
     * @returns true if bag has consumable and false if it doesn't
     */
    public boolean hasConsumable() {
        for (int i = 0; i < inventory.length; i++)  {
            if (inventory[i] instanceof Consumable) {
                itemPlace = i;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes item from bag
     */
    public void removeItem() {
            inventory[itemPlace] = null;
    }

    /**
     * Eats edible items
     */
    public void eatConsumable() {

        if (!hasConsumable()) {
            System.out.println("There's nothing edible in your bag!");
        }

        if (hasConsumable()) {

            //Creates new GranolaBar that is eaten and deletes the GranolaBar inside the bag
            if (inventory[itemPlace] instanceof GranolaBar) {
                GranolaBar g1 = new GranolaBar();
                g1.eat(this);
                removeItem();

            //Creates new Ramen that is eaten and deletes the Ramen inside the bag
            } else if (inventory[itemPlace] instanceof Ramen) {
                Ramen r1 = new Ramen();
                r1.eat(this);
                removeItem();
            }
        }
    }


    /**
     * Checks if player's inventory has Key.
     * @returns true if it does and false if it does not
     */
    public boolean hasKey() {

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] instanceof Key) {
                return true;
            }
        }
        return false;
    }

}