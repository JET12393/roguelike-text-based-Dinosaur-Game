package game.ground;

import edu.monash.fit2099.engine.*;
import game.action.PurchaseItemAction;
import game.item.EcoPoints;
import game.item.*;

import java.util.ArrayList;
import java.util.Scanner;


public class VendingMachine extends Ground {

    /**
     * Constructor.
     *
     * character to display for Vending machine
     */
    public VendingMachine() {
        super('V');
    }


    /**
     * this method is so that player cannot enter the vending machine
     * @param actor the Actor to check
     * @return
     */
    @Override
    public boolean canActorEnter(Actor actor){
        return false;
    }

    /**
     * Returns an empty Action list.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public Actions allowableActions(Actor actor,Location location,String direction){
        GameMap map= location.map();
        ArrayList <Purchaseable> vendingItem = new ArrayList<>();
        vendingItem.add(new Fruit(map));
        vendingItem.add(new VegetarianMealKit());
        vendingItem.add(new CarnivoreMealKit());
        vendingItem.add(new StegosaurEgg(map));
        vendingItem.add(new BrachiosaurEgg(map));
        vendingItem.add(new AllosaurEgg(map));
        vendingItem.add(new PterodactylsEgg(map));
        vendingItem.add(new Lasergun());

        Actions ret=new Actions();
        Scanner scanner = new Scanner(System.in);
        System.out.println("current eco points: " + EcoPoints.getEcoPoints());
        System.out.println("1. Fruit");
        System.out.println("2. Vegetarian Meal Kit");
        System.out.println("3. Carnivore Meal Kit");
        System.out.println("4. Stegosaur Egg");
        System.out.println("5. Brachiosaur Egg");
        System.out.println("6. Allosaur Egg");
        System.out.println("7. Pterodactyls Egg");
        System.out.println("8. Laser gun");
        System.out.println("Enter item to buy: ");
        int itemBought = scanner.nextInt();

        if (itemBought>=1 && itemBought<=7) {
            int cost = vendingItem.get(itemBought-1).getEcoPointsValue();
            if (EcoPoints.isSufficient(cost)) {
                ret.add(new PurchaseItemAction(vendingItem.get(itemBought-1)));
            }
        }
        return ret;
    }
}
