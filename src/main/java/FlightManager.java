import java.util.ArrayList;
import java.util.Random;

public class FlightManager {

    public FlightManager(){ }


    public double baggageWeightPerPassanger(Flight flight) {
        return (flight.getPlaneType().getTotalWeight()/2.0)/flight.getPlaneType().getPassangerCapacity();
    }

    public double weightOfBaggageBookedOnFlight(Flight flight) {
        double weightOfBags = 0.00;
        for (Passanger passanger : flight.getPassangers()){
            weightOfBags += this.baggageWeightPerPassanger(flight) * passanger.getBags();}
        return weightOfBags;
    }

    public double availabeBaggageCapacity(Flight flight) {
        return this.baggageWeightPerPassanger(flight) * flight.getPlaneType().getPassangerCapacity();
    }

    public double availableBaggageWeightLeft(Flight flight) {
        return this.availabeBaggageCapacity(flight) - this.weightOfBaggageBookedOnFlight(flight);
    }

    public void addFlight(Flight flight, Passanger passanger) {
        passanger.setFlight(flight);
    }


    public void generateSeatNumber(Passanger passanger, Flight flight) {
        Random random = new Random();

//      Checking if passanger array has at least on passanger.
        if (flight.getPassangers().size() > 0){
            int newSeatNumber = random.nextInt(flight.getPlaneType().getPassangerCapacity()) +1;

//      If the passanger array DOES then build an array of existing seat numbers.
            ArrayList<Integer> seatNos = new ArrayList<Integer>();
            for(Passanger passangerNo : flight.getPassangers()){
                seatNos.add(passangerNo.getSeatNumber());
            }

//      Then whilst the array of seat numbers contains the newly generated number create a new one and re-test.
            while (seatNos.contains(newSeatNumber)){
                newSeatNumber = random.nextInt(flight.getPlaneType().getPassangerCapacity()) +1;
            }

//      Once the generated number does not match any of the array list numbers its added to the passanger as their seat number.
            System.out.println(newSeatNumber);
            passanger.setSeatNumber(newSeatNumber);
        } else {

//      If the passanger array DOES NOT then add the generated number to the passanger as their seat number.
            int seatNumber = random.nextInt(flight.getPlaneType().getPassangerCapacity()) +1;
            System.out.println(seatNumber);
            passanger.setSeatNumber(seatNumber);
        }
    }


}
