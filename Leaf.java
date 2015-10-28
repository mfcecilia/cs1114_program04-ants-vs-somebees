import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  thrown by a thrower ant at incoming bees.
 *  travels due east at a rate of 0.025 grid units per turn.
 *  when it hits a bee, it injures the bee by 1 health unit each.
 *  it is then removed from the world.
 *  if it reaches the end of the world without hitting a bee,
 *  it is removed from the world.
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.10.22
 */
public class Leaf extends Actor
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Leaf object.
     */
    public Leaf()
    {
        super();
    }


    //~ Methods ...............................................................
    /**
     * carries the leaf across the world until it hits a bee
     */
    public void travel()
    {
        if (this.getGridX() == 9)
        {
            this.remove();
        }
        else if (this.getIntersectingObjects(Bee.class).size() == 0)
        {
            this.move(0.025);
        }
        else
        {
            this.remove();
        }
    }
    /**
     * executes methods which
     * give this actor it's unique behavior
     */
    public void act()
    {
        this.travel();
    }
    

}
