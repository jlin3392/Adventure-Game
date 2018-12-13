package Items;

public class Bag {

    private Item[] inventory = new Item[10];
    String totalInventory;

    public void addToBag(Item item) {
        for (int i = 0; i <= 10; i++) {
            if (inventory[i] != null) {
                inventory[i] = item;
            }
        }
    }

    public void checkBag() {

        for (int i = 0; i <= 10; i++) {
            if (inventory[i] != null) {
                totalInventory = totalInventory + inventory[i].toString() + " ";
            }
        }

        if (totalInventory.length() < 1) {
            System.out.println("Your bag is empty.");
        } else {
            System.out.println("Your bag currently has: " + totalInventory);
        }
    }
}
