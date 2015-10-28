import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  flies in a straight line due west towards ant queen.
 *  starts with health value of 3.
 *  when it touches an ant, it becomes blocked.
 *  stuck on top of any until ant is dead.
 *  waits 40 turns before stinging. stings every 40 turns.
 *  when it touches queen's chamber, it wins the game.
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.10.22
 */
public class Bee extends Timer
{
    //~ Fields ................................................................
    /**
     * @param health equals health
     */
    public int health;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Bee object.
     */
    public Bee()
    {
        super();
        this.turn(180);
        health = 3;
    }
    //~ Methods ...............................................................
    /**
     * returns the ant's current health
     * @return the health
     */
    public int getHealth()
    {
        return health;
    }
    /**
     * reduces the ant's health by the provided amount.
     * when the ant's health reaches zero, 
     * it should remove itself from the colony
     * @param n equals the amount it gets hurt
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
     * moves if it's not in contact with an ant.
     */
    public void fly()
    {
        if (this.getIntersectingObjects(Ant.class).size() == 0)
        {
            this.move(0.0125);
        }
    }
    /**
     * if a leaf hits it, it gets injured
     */
    public void hit()
    {
        if (this.getIntersectingObjects(Leaf.class).size() > 0)
        {
            this.injure(1);
        }
    }
    /**
     * executes methods which
     * give this actor it's unique behavior
     */
    public void act()
    {
        this.fly();
        this.hit();
        this.getHealth();
        if (this.getGridX() == 0)
        {
            Colony colony = (Colony)this.getWorld();
            colony.lose();
            this.getWorld().stop();
        }
    }
}
