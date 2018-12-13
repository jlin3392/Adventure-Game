package Items;
import Person.Player;

public class Ramen extends Item implements Consumable {
    public void eat(Player player1) {
        player1.restoreHealth(7);
        player1.gainStrength(5);
    }

    public String toString() {
        return "Ramen";
    }
}
