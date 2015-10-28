import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  an offensive unit that throws a continuous stream of leaves straight ahead.
 *  leaves annoy flying bees, causing them to fly away.
 *  every 120 turns, a thrower throws one leaf.
 *  adding a thrower ant costs 4 food units.
 *  a thrower ant begins with a health of 1.
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.10.22
 */
public class ThrowerAnt extends Ant
{
    //~ Fields ................................................................
    /**
     * @param i equals a counter
     */
    private int i = 0;



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ThrowerAnt object.
     */
    public ThrowerAnt()
    {
        super();
        health = 1;
        cost = 4;
    }


    //~ Methods ...............................................................
    /**
     * throws the leaf every 120 turns
     */
    public void throwing()
    {
        i++;
        if (i % 120 == 0)
        {
            this.getWorld().add(new Leaf(), getGridX(), getGridY());
        }
    }
    /**
     * runs the specific behavior
     */
    public void act()
    {
        this.throwing();
        this.beeSting();
    }


}