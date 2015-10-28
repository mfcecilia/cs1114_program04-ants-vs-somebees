import sofia.micro.*;
import sofia.util.Random;

//-------------------------------------------------------------------------
/**
 *  represents the bee hive.
 *  placed at (9,3).
 *  
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.10.27
 */
public class Hive extends Timer
{
    //~ Fields ................................................................
    /**
     * @param bee equals bee
     * @param release equals 400
     */
    private int bee;
    private int release = 400;




    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Hive object.
     * 
     */
    public Hive()
    {
        super();
        bee = 30;        
    }


    //~ Methods ...............................................................
    /**
     * sets timer
     * sends bee at appropriate time
     */
    public void sendBee()
    {
        int y = Random.generator().nextInt(1, 5);
        if (release == 0)
        {
            release = Random.generator().nextInt(80, 400);
            this.getWorld().add(new Bee(), 9, y);
            bee = bee - 1; 
        }
        else
        {
            release = release - 1;
        }
    }
    /**
     * @return is the number of bees in the hive.
     */
    public int getBees()
    {
        return bee;
    }
    /**
     * executes methods which
     * give this actor it's unique behavior
     */
    public void act()
    {
        this.sendBee();
        this.getBees();
    }
}
