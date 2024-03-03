package game.item;

/**
 * class for ecopoints
 */
public class EcoPoints {
    private static int ecoPoints;

    /**
     * getter
     * @return ecoPoints
     */
    public static int getEcoPoints(){
        return ecoPoints;
    }

    /**
     * setter
     * @param newEcoPoints the ecoPoints to be set for the player
     */
    public static void setEcoPoints(int newEcoPoints){
        ecoPoints=newEcoPoints;
    }

    /**
     * this method checks if the ecoPoints is sufficient to buy the item from vending machine
     * @param ecoPointsValue the cost of item from vending machine
     * @return true if sufficient ecoPoints, else false
     */
    public static boolean isSufficient(int ecoPointsValue){
        return ecoPointsValue<=ecoPoints;
    }

    /**
     * this method adds the ecopoints by the value given
     * @param newEcoPointsGained the amount of ecopoints to be added
     */
    public static void addEcoPoints(int newEcoPointsGained){
        ecoPoints+=newEcoPointsGained;
    }

    /**
     *
     * @param ecoPointsValue
     */
    public static void subtractEcoPoints(int ecoPointsValue){
        if (isSufficient(ecoPointsValue)){
            ecoPoints-=ecoPointsValue;
        }
    }

}
