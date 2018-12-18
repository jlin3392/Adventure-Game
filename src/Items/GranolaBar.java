package Items;
import Person.Player;

public class GranolaBar extends Item implements Consumable {

    public void eat(Player player1) {
        player1.restoreHealth(2);
        System.out.println("You munched into a delicious granola bar.");
        System.out.println("Your health is now " + player1.getHealthPoints());
    }



    public String toString() {
        return "Granola Bar";
    }
}
