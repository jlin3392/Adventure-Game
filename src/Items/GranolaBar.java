package Items;
import Person.Player;

public class GranolaBar extends Item implements Consumable {

    public void eat(Player player1) {
        player1.restoreHealth(3);
        player1.gainStrength(2);
    }

    public String toString() {
        return "Granola Bar";
    }
}
