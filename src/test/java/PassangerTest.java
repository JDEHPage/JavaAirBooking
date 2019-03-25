import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassangerTest {

    public Passanger passanger;
    public Flight flight1;
    public Flight flight2;
    public FlightManager flightManager;

    @Before
    public void setup(){
        passanger = new Passanger("Ian", 2);
        flight1 = new Flight(PlaneType.BOEING_727,"FR756","LTN","EDI","2018-05-02T11:50");
        flight1 = new Flight(PlaneType.AIRBUS_A310,"FW349","GWA","GLA","2018-05-02T10:30");
        flightManager = new FlightManager();

    }

    @Test
    public void hasName() {
        assertEquals("Ian", passanger.getName());
    }

    @Test
    public void canChangeName() {
        passanger.setName("Brian");
        assertEquals("Brian", passanger.getName());
    }

    @Test
    public void hasBags() {
        assertEquals(2, passanger.getBags());
    }

    @Test
    public void canChangeBags() {
        passanger.setBags(1);
        assertEquals(1, passanger.getBags());
    }

    @Test
    public void hasFlight() {
        flightManager.addFlight(flight1, passanger);
        assertEquals(flight1, passanger.getFlight());
    }

    @Test
    public void canSetFLight() {
        passanger.setFlight(flight2);
        assertEquals(flight2,passanger.getFlight());
    }

    @Test
    public void hasSeatNumber() {
        passanger.setSeatNumber(3);
        assertEquals(3,passanger.getSeatNumber());
    }

}
