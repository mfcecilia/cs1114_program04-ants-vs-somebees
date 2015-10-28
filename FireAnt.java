import sofia.micro.*;
import java.util.List;

//-------------------------------------------------------------------------
/**
 *  an offensive unit that explodes when its health reaches 
zero. 
 *  as it leaves the colony, it reduces the health of any 
 *  bee in any neighboring cell by 3 health units.
 *  adding a fire ant costs 4 food units.
 *  begins with a health of 1.
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.10.22
 */
public class FireAnt extends Ant
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new FireAnt object.
     */
    public FireAnt()
    {
        super();
        health = 1;
        cost = 4;
    }
    
    //~ Methods ...............................................................
    /**
     * handles the explosion
     * @param n equals injure amount
     */
    public void injure(int n)
    {
        health = this.getHealth() - n;
        List<Bee> aroundBees = this.getObjectsInRange(1, Bee.class);
        if (health == 0)
        {
            for (Actor bee : aroundBees)
            {
                bee.remove();
            }
            this.remove();
        }
    }
}


