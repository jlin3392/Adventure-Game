package Items;
import Person.Player;

public interface Consumable {

    //Classifier for all consumables.
    void eat(Player x);

    String toString();

}
