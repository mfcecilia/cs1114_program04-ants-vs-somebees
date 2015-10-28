import sofia.micro.*;
import java.util.*;

//-------------------------------------------------------------------------
/**
 *  an offensive unit with a huge appetite that can eat a bee.
 *  any bee that reaches hungry ant will be eaten.
 *  but the catch is that it will take the hungry ant 240 turns 
to digest the bee.
 *  while digesting it is vulnerable to any other bee.
 *  costs 5 food units.
 *  begins with a health of 1.
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.10.22
 */
public class HungryAnt extends Ant
{
    //~ Fields ................................................................
    /**
     * @param chewing equals chewing
     * @param i is a counter
     */
    private boolean chewing;
    private int i = 0;



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new HungryAnt object.
     */
    public HungryAnt()
    {
        super();
        health = 1;
        cost = 5;
        chewing = false;
    }


    //~ Methods ...............................................................
   
    

    /**
     * executes methods which
     * give this actor it's unique behavior
     */
       /**
     * executes methods which
     * give this actor it's unique behavior
     */
    public void act()
    { 
        Bee buzz = this.getOneIntersectingObject(Bee.class);
        if (chewing)
        {
            i++;
            if (i >= 240)
            {
                chewing = false;
            }
        }
        if ((buzz != null) && (!chewing))
        {
            buzz.injure(3);
            chewing = true;
            i = 0;
        }
    }
}
;

