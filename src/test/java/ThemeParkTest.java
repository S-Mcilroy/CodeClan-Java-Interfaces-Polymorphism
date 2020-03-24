import attractions.*;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;
    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;
    Visitor visitorAdult;
    Visitor visitorChild;
    Visitor visitorTall;


    @Before
    public void before() {
        themePark = new ThemePark("Alton Towers");
        candyflossStall = new CandyflossStall("Sweet Sensations","J.Smith", ParkingSpot.A1, 5);
        iceCreamStall = new IceCreamStall("Cold Touch", "M.Freeze", ParkingSpot.A2, 5);
        tobaccoStall = new TobaccoStall("Death Sticks", "C.Cough", ParkingSpot.B4, 2);
        dodgems = new Dodgems("Head Bangers", 5);
        park = new Park("Quite Place", 5);
        playground = new Playground("Running Wild", 4);
        rollerCoaster = new RollerCoaster("Crazy Heights", 5);
        visitorAdult = new Visitor(26, 135, 400);
        visitorChild = new Visitor(10, 90, 200);
        visitorTall = new Visitor(50, 230, 600);
    }

    @Test
    public void hasName(){
        assertEquals("Alton Towers", themePark.getName());
    }

    @Test
    public void canAddAttraction(){
        themePark.addAttraction(rollerCoaster);
        assertEquals(1, themePark.getAttractions());
    }

    @Test
    public void canAddStall(){
        themePark.addStall(candyflossStall);
        assertEquals(1, themePark.getStalls());
    }

    @Test
    public void canGetArrayOfBothAttractionAndStall(){
        themePark.addAttraction(rollerCoaster);
        themePark.addStall(candyflossStall);
        assertEquals(2, themePark.getAllReviewed().size());
    }

    @Test
    public void canMakeVisitorVisitAttraction(){
        themePark.visit(visitorAdult, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(1, visitorAdult.getVisitedAttractions());
    }

    @Test
    public void canGetHashMapOfReviews() {
        themePark.addStall(candyflossStall);
        assertEquals(true, themePark.reviews().containsKey("Sweet Sensations"));
        assertEquals(true, themePark.reviews().containsValue(5));
    }

    @Test
    public void canGetArrayOfAllowForVisitor(){
        themePark.addStall(candyflossStall);
        themePark.addStall(iceCreamStall);
        themePark.addStall(tobaccoStall);
        themePark.addAttraction(dodgems);
        themePark.addAttraction(park);
        themePark.addAttraction(playground);
        themePark.addAttraction(rollerCoaster);
        assertEquals(5, themePark.getAllAllowedFor(visitorChild).size());
        assertEquals(5, themePark.getAllAllowedFor(visitorAdult).size());
        assertEquals(6, themePark.getAllAllowedFor(visitorTall).size());
    }

}
