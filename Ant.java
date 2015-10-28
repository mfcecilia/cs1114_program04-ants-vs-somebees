import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  this class houses all the subclasses of ants
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.10.22
 */
public class Ant extends Timer
{
    //~ Fields ................................................................
    /**
     * @param health equals health
     */
    public int health;
    /**
     * @param cost equals cost to add ant to world
     */
    public int cost;
    /**
     * @param sting equals 40
     * turns passed before bee stings
     */
    public int sting = 40;



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Ant object.
     */
    public Ant()
    {
        super();
    }


    //~ Methods ...............................................................
    /**
     * @return equals the ant's current health
     */
    public int getHealth()
    {
        return health;
    }
    /**
     * reduces the ant's health by the provided amount.
     * when the ant's health reaches zero, 
     * it should remove itself from the colony
     * @param n equals amount it gets injured
     */
    public void injure(int n)
    {
        if (health == 0)
        {
            this.remove();
        }
        else
        {
            health = health - n;
        }
    }
    /**
     * gets injured when a bee makes contact with it
     * waits 40 turns before stinging begins
     */
    public void beeSting()
    {
        if (this.getIntersectingObjects(Bee.class).size() > 0)
        {
            if (sting == 0)
            {
                this.injure(1);
            }
            else
            {
                sting = sting - 1;
            }
        }
    }
    /**
     * indicates how many food units are necessary to 
     * be added to the colony
     * @return the food cost
     */
    public int getFoodCost()
    {
        return cost;
    }
    /**
     * executes methods which
     * give this actor it's unique behavior
     */
    public void act()
    {
        this.beeSting();
        this.getFoodCost();
        this.getHealth();
    }
}
