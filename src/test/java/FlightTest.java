import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.assertEquals;

public class FlightTest {

    public Flight flight;
    public Passanger passanger1;
    public Passanger passanger2;
    public Passanger passanger3;
    public Passanger passanger4;
    public Passanger passanger5;
    public Passanger passanger6;
    public Passanger passanger7;
    public Passanger passanger8;
    public Passanger passanger9;
    public Passanger passanger10;
    public FlightManager flightManager;



    @Before
    public void setup(){
        flight = new Flight(PlaneType.BOEING_727,"FR756","LTN","EDI","2018-05-02T11:50");
        passanger1 = new Passanger("Ian",1);
        passanger2 = new Passanger("Sam",1);
        passanger3 = new Passanger("Sarha",3);
        passanger4 = new Passanger("Julia",1);
        passanger5 = new Passanger("Carme",1);
        passanger6 = new Passanger("Sibosiso",2);
        passanger7 = new Passanger("Serly",2);
        passanger8 = new Passanger("Brian",3);
        passanger9 = new Passanger("Louise",2);
        passanger10 = new Passanger("Robert",1);
        flightManager = new FlightManager();

    }

    @Test
    public void hasPlaneType() {
        assertEquals(PlaneType.BOEING_727, flight.getPlaneType());
    }

    @Test
    public void canChangePlaneType() {
        flight.setPlaneType(PlaneType.AIRBUS_A310);
        assertEquals(PlaneType.AIRBUS_A310, flight.getPlaneType());
    }

    @Test
    public void hasNumber() {
        assertEquals("FR756", flight.getNumber());
    }

    @Test
    public void canChangeNumber() {
        flight.setNumber("FT5757");
        assertEquals("FT5757", flight.getNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals("LTN", flight.getDestiantion());
    }

    @Test
    public void canChangeDestination() {
        flight.setDestiantion("DBL");
        assertEquals("DBL", flight.getDestiantion());
    }

    @Test
    public void hasDeparture() {
        assertEquals("EDI", flight.getDeparture());
    }

    @Test
    public void canChangeDeparture() {
        flight.setDeparture("GLA");
        assertEquals("GLA", flight.getDeparture());
    }

    @Test
    public void hasDepartureTime() {

        assertEquals("2018-05-02T11:50", flight.getDepartureTime());
    }

    @Test
    public void canChangeDepartureTime() {
        flight.setDepartureTime("2018-06-02T10:50");
        assertEquals("2018-06-02T10:50", flight.getDepartureTime());
    }

    @Test
    public void canIdentifyNumberOfAvailableSeatsNoPassanger() {
        assertEquals(4, flight.getAvailabeSeats());
    }

    @Test
    public void canBookPassagners() {
        flight.bookPassangers(passanger1, flightManager);
        assertEquals(3,flight.getAvailabeSeats());
    }

    @Test
    public void canIdentifyNumberOfAvailableSeatsWithPassanger() {
        flight.bookPassangers(passanger1, flightManager);
        flight.bookPassangers(passanger2, flightManager);
        flight.bookPassangers(passanger4, flightManager);
        assertEquals(1,flight.getAvailabeSeats());
    }

    @Test
    public void canStopPassangersFromOverBooking() {
        flight.bookPassangers(passanger1, flightManager);
        flight.bookPassangers(passanger2, flightManager);
        flight.bookPassangers(passanger4, flightManager);
        flight.bookPassangers(passanger5, flightManager);
        flight.bookPassangers(passanger10, flightManager);
        assertEquals(0,flight.getAvailabeSeats());
    }



    //
//    @Test
//    public void canfindSpecificPassanger() {
//        flight.bookPassangers(passanger1, flightManager);
//        flight.bookPassangers(passanger2, flightManager);
//        flight.bookPassangers(passanger3, flightManager);
//        flight.bookPassangers(passanger4, flightManager);
//        flight.bookPassangers(passanger5, flightManager);
//        assertEquals(passanger3,flight.findSpecificPassanger(passanger3));
//    }

    //    @Test
//    public void reservedBaggageWeightPerPassanger() {
//        assertEquals(5.75, flight.baggageWeightPerPassanger(), 0.01);
//    }
//
//    @Test
//    public void weightOfBookedPassangersBags() {
//        flight.bookPassangers(passanger1);
//        flight.bookPassangers(passanger6);
//        assertEquals(17.25, flight.weightOfBaggageBookedOnFlight(),0.01);
//    }
//
//    @Test
//    public void getTotalAvailabeBaggageCapacity() {
//        assertEquals(23, flight.availabeBaggageCapacity(),0.01);
//    }
//
//    @Test
//    public void canListAvailableBaggageWeightLeft() {
//        flight.bookPassangers(passanger1);
//        flight.bookPassangers(passanger6);
//        assertEquals(5.75, flight.availableBaggageWeightLeft(),0.01);
//    }

//    @Test
//    public void doesAssignPassangerAFlight() {
//        flight.bookPassangers(passanger1);
//        assertEquals(flight,passanger1.getFlight());
//    }
}
