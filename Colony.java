import sofia.micro.*;

//-------------------------------------------------------------------------
/**
 *  represents the whole world.
 *  queen's chamber and hive placed in the constructor.
 *  starts off with 10 food units.
 *  only gains food when it is provided by harvester ants.
 *  
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.10.15
 */
public class Colony extends HomeBase
{
    //~ Fields ................................................................
    /**
     * @param food refers to the food
     */
    private int food;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Colony object.
     */
    public Colony()
    {
        super();

        // Add the queen's chamber and hive to the world here
        QueensChamber chamber = new QueensChamber();
        this.add(chamber, 0, 3);
        Hive hive = new Hive();
        this.add(hive, 9, 3);
        food = 10;

        // Lay out the ant choices the player can click on in the
        // method call commented out below.  As you add ants, you
        // can add them to this list, so you have a playable
        // version of your game to try out, no matter how much
        // you have left to finish.

        setActorChoices(
            HarvesterAnt.class,
            ThrowerAnt.class,
            WallAnt.class,
            FireAnt.class,
            HungryAnt.class);

    }

    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Add an ant to the screen when a specific location is clicked.
     * This method is automatically called while the simulation is
     * running, whenever the user clicks on (or taps on) a location
     * in the colony (one that isn't covered by an actor already).
     * 
     * @param x The x-coordinate of the click
     * @param y The y-coordinate of the click
     */
    public void onTouchDown(int x, int y)
    {
        // Complete this method yourself.

        // Only allow ants to be added between (1, 1) - (8, 5),
        // which makes up the playable area of the colony.   You
        // should ignore clicks/taps in locations outside of that
        // range.

        if ((x >= 1) && (x <= 8) 
            && (y >= 1) && (y <= 5))
        {
            this.newActorOfSelectedType();
            Ant selectedAnt = ((Ant) newActorOfSelectedType());
            int neededFood = selectedAnt.getFoodCost();
            if (food - neededFood >= 0)
            {
                this.add(selectedAnt, x, y);
                this.consumeFood(neededFood);
            }
        }

        // call newActorOfSelectedType() to create a new ant of the
        // type that the user selected from the choices shown at
        // the top of the screen, then add it at the location of
        // the screen "touch".

        // Don't forget that adding an ant costs food!
    }

    /**
     * @return returns the number of food units in the colony
     */
    public int getFood()
    {
        return food;
    }

    /**
     * @param n used by harvesters to add food to the colony
     */
    public void addFood(int n)
    {
        food = food + n;
    }

    /**
     * used to reduce the amount of food in the colony when creating new ants.
     * @param amount is how much food is taken
     */
    public void consumeFood(int amount)
    {
        food -= amount;
    }

    /**
     * automatically called on each turn. 
     * homebase class uses it to update the food display
     * and determine whether the game is over
     */
    public void act()
    {
        super.act();
        this.getFood();
        if (this.getOneObjectAt(9, 3, Hive.class).getBees() == 0 
            && this.getObjects(Bee.class).size() == 0)
        {
            this.win();
        }
    }
}
