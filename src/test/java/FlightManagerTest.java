import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    public FlightManager flightManager;
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

    @Before
    public void setup(){
        flightManager = new FlightManager();
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
    }

    @Test
    public void reservedBaggageWeightPerPassanger() {
        assertEquals(5.75, flightManager.baggageWeightPerPassanger(flight), 0.01);
    }

    @Test
    public void weightOfBookedPassangersBags() {
        flight.bookPassangers(passanger1, flightManager);
        flight.bookPassangers(passanger6, flightManager);
        assertEquals(17.25, flightManager.weightOfBaggageBookedOnFlight(flight),0.01);
    }

    @Test
    public void getTotalAvailabeBaggageCapacity() {
        assertEquals(23, flightManager.availabeBaggageCapacity(flight),0.01);
    }

    @Test
    public void canListAvailableBaggageWeightLeft() {
        flight.bookPassangers(passanger1, flightManager);
        flight.bookPassangers(passanger6, flightManager);
        assertEquals(5.75, flightManager.availableBaggageWeightLeft(flight),0.01);
    }

    @Test
    public void doesAssignPassangerAFlight() {
        flight.bookPassangers(passanger1, flightManager);
        assertEquals(flight,passanger1.getFlight());
    }

    @Test
    public void canStopPassangersFromOverLoadingLuggage() {
        flight.bookPassangers(passanger1, flightManager);
        flight.bookPassangers(passanger2, flightManager);
        flight.bookPassangers(passanger7, flightManager);
        flight.bookPassangers(passanger4, flightManager);
        assertEquals(0.00, flightManager.availableBaggageWeightLeft(flight),0.01);
    }


}
