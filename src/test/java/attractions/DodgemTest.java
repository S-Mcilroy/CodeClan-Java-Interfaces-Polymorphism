package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitorAdult;
    Visitor visitorChild;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        visitorAdult = new Visitor(26, 135, 400);
        visitorChild = new Visitor(10, 90, 200);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void canChargeDefaultAmount(){
        assertEquals(4.50, dodgems.priceFor(visitorAdult), 0.01);
    }

    @Test
    public void canChargeHalfForChild(){
        assertEquals(2.25, dodgems.priceFor(visitorChild), 0.01);
    }
}
