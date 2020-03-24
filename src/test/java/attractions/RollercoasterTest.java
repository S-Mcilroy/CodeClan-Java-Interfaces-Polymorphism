package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitorAdult;
    Visitor tallAdult;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitorAdult = new Visitor(26, 145, 400);
        tallAdult = new Visitor(26, 210, 400);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canChargeDefaultAmount(){
        assertEquals(8.40, rollerCoaster.priceFor(visitorAdult), 0.01);
    }

    @Test
    public void canChargeDoubleForTall(){
        assertEquals(16.80, rollerCoaster.priceFor(tallAdult), 0.01);
    }
}
