import sofia.micro.*;

// -------------------------------------------------------------------------
/**
 *  tests all the methods in the program
 *
 *  @author Mykayla Fernandes (mkaykay1)
 *  @version 2015.10.27
 */
public class ColonyTest extends TestCase
{
    //~ Fields ................................................................
    /**
     * @param colony refers to the colony
     */
    private Colony colony;

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new TestColony test object.
     */
    public ColonyTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }
    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        colony = new Colony();
    }
    // ----------------------------------------------------------
    /**
     * tests if a harvester is created
     */
    public void testCreatingHarvestingAnt()
    {
        colony.setSelectedActor(HarvesterAnt.class);
        colony.onTouchDown(1, 3);
        HarvesterAnt harvester = 
        colony.getOneObjectAt(1, 3, HarvesterAnt.class);
        assertEquals(3, harvester.getGridY());
        assertEquals(1, harvester.getGridX());
    }
    /**
     * tests if fire ant is created
     */
    public void testCreatingFireAnt()
    {
        colony.setSelectedActor(FireAnt.class);
        colony.onTouchDown(2, 3);
        colony.add(new Bee(), 3, 3);
        colony.consumeFood(4);
        run(colony, 140);
        assertEquals(0, colony.getObjects(FireAnt.class).size());
        assertEquals(0, colony.getObjects(Bee.class).size());
    }
    /**
     * tests if thrower ant is created
     */
    public void testCreatingThrowerAnt()
    {
        colony.setSelectedActor(ThrowerAnt.class);
        colony.onTouchDown(3, 3);
        Hive hive = new Hive();
        colony.add(hive, 9, 3);
        hive.getBees();
        run(colony, 130);
        assertEquals(1, colony.getObjects(Leaf.class).size());
    }
    /**
     * tests the wall ant
     */
    public void testWallAnt()
    {
        colony.setSelectedActor(WallAnt.class);
        colony.onTouchDown(8, 1);
        colony.add(new Bee(), 9, 1);
        Bee be = colony.getOneObjectAt(9, 1, Bee.class);
        run(colony, 130);
        assertTrue((be.getGridX() == 8));
    }
    /**
     * test hungry ant
     */
    public void testHungryAnt()
    {
        colony.add(new Bee(), 4, 1);
        colony.setSelectedActor(HungryAnt.class);
        colony.onTouchDown(3, 1);
        run(colony, 370);
        assertEquals(0, colony.getObjects(Bee.class).size());
    }
    /**
     * test removing ant
     */
    public void testRemove()
    {
        colony.setSelectedActor(HarvesterAnt.class);
        colony.onTouchDown(5, 2);
        colony.setSelectedActor(HungryAnt.class);
        colony.onTouchDown(4, 2);
        colony.add(new Bee(), 5, 2);
        run(colony, 370);
        assertEquals(2, colony.getObjects(Ant.class).size());
    }
    /**
     * leaf test
     */
    public void testLeaf()
    {
        run(colony, 130);
        colony.add(new Leaf(), 7, 3);
        colony.add(new Leaf(), 4, 3);
        run(colony, 130);
        colony.add(new Bee(), 1, 3);
        colony.add(new Bee(), 2, 3);
        assertEquals(1, colony.getObjects(Leaf.class).size());
    }
    /**
     * removing 2 bees
     */
    public void testHungryAntC()
    {
        colony.setSelectedActor(HungryAnt.class);
        colony.onTouchDown(3, 3);
        colony.add(new Bee(), 4, 3);
        colony.add(new Bee(), 5, 3);
        run(colony, 610);
        assertTrue((colony.getObjects(HungryAnt.class).size())
            < (colony.getObjects(Bee.class).size()));
    }
    /**
     * remove inside ant class
     */
    public void testRemoveB()
    {
        colony.setSelectedActor(HarvesterAnt.class);
        colony.onTouchDown(3, 3);
        colony.add(new Bee(), 4, 3);
        run(colony, 130);
        assertEquals(1, colony.getObjects(Bee.class).size());
    }
    /**
     * lose test
     */
    public void testLose()
    {
        colony.add(new Bee(), 1, 4);
        run(colony, 130);
        assertEquals(1, colony.getObjects(Bee.class).size());
    }
    /**
     * win test
     * includes wall ants for exta precaution
     */
    public void testWin()
    {
        colony.addFood(800);
        colony.setSelectedActor(WallAnt.class);
        colony.onTouchDown(6, 1);
        colony.onTouchDown(6, 2);
        colony.onTouchDown(6, 3);
        colony.onTouchDown(6, 4);
        colony.onTouchDown(6, 5);       
        colony.setSelectedActor(ThrowerAnt.class);
        colony.onTouchDown(3, 1);
        colony.onTouchDown(3, 2);
        colony.onTouchDown(3, 3);
        colony.onTouchDown(3, 4);
        colony.onTouchDown(3, 5);
        colony.setSelectedActor(ThrowerAnt.class);
        colony.onTouchDown(1, 1);
        colony.onTouchDown(1, 2);
        colony.onTouchDown(1, 3);
        colony.onTouchDown(1, 4);
        colony.onTouchDown(1, 5);
        colony.setSelectedActor(ThrowerAnt.class);
        colony.onTouchDown(2, 1);
        colony.onTouchDown(2, 2);
        colony.onTouchDown(2, 3);
        colony.onTouchDown(2, 4);
        colony.onTouchDown(2, 5);
        
        run(colony, 10000);
        assertTrue(colony.getObjects(Bee.class).size()
            < colony.getObjects(Ant.class).size());
    }
}
