package game.item;

import edu.monash.fit2099.engine.WeaponItem;

/**
 * Class for lasergun
 */
public class Lasergun extends WeaponItem implements Purchaseable{
    public static final int LASER_GUN_DAMAGE=80;
    private final int EcoPointValue=500;

    /**
     * Constructor.
     *
     */
    public Lasergun() {
        super("Laser gun",'L',LASER_GUN_DAMAGE,"shoots!!!!!!!");
        this.asWeapon();
    }

    @Override
    public int getEcoPointsValue() {
        return EcoPointValue;
    }
}
