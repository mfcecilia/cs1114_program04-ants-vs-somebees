import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  collects food, adds it to the colony's food supply.
 *  every 40 turns, produces one unit of food to add to the colony.
 *  adding a harvester costs 2 units.
 *  begins with a health of 1
 *  has an act method with a specific behavior
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.10.22
 */
public class HarvesterAnt extends Ant
{
    //~ Fields ...............................................................
    /**
     * @param i equals a counter
     */
    private int i = 1;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HarvesterAnt object.
     */
    public HarvesterAnt()
    {
        super();
        health = 1;
        cost = 2;
    }
    //~ Methods ...............................................................
    
    /**
     * adds a new unit of food
     */
    public void act()
    {
        i++;
        if (i % 40 == 0)
        {
            Colony colony = ((Colony) getWorld());
            colony.addFood(1);
        } 
        this.getHealth();
    }
}