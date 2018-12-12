package Items;

public class Bag {

    private String[] inventory = new String[10];
    String totalInventory;

    public void checkBag() {

        for (int i = 0; i <= 10; i++) {
            if (inventory[i] != null) {
                totalInventory = totalInventory + inventory[i] + " ";
            }
        }

        if (totalInventory.length() < 1) {
            System.out.println("Your bag is empty.");
        } else {
            System.out.println("Your bag currently has: " + totalInventory);
        }
    }
}
