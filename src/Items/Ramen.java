package Items;
import Person.Player;

public class Ramen extends Item implements Consumable {
    public void eat(Player player1) {
        player1.restoreHealth(4);
        System.out.println("You sat down and enjoyed a nice warm cup of ramen. You're \n" +
                "not quite sure where the hot water came from, but you won't \n" +
                "complain.");
        System.out.println("Your health is now " + player1.getHealthPoints());
    }

    public String toString() {
        return "Ramen";
    }
}
