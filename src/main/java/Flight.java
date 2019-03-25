import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;


public class Flight {

    private PlaneType planeType;
    private String number;
    private String destiantion;
    private String departure;
    private LocalDateTime departureTime;
    private ArrayList<Passanger> passangers;


    public Flight(PlaneType planeType, String number, String destiantion, String departure, String departureTime) {
        this.planeType = planeType;
        this.number = number;
        this.destiantion = destiantion;
        this.departure = departure;
        this.departureTime = LocalDateTime.parse(departureTime);
        this.passangers = new ArrayList<Passanger>();
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDestiantion() {
        return destiantion;
    }

    public void setDestiantion(String destiantion) {
        this.destiantion = destiantion;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDepartureTime() {
        return departureTime.toString();
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = LocalDateTime.parse(departureTime);
    }

    public ArrayList<Passanger> getPassangers() {
        return passangers;
    }

//    public Passanger findSpecificPassanger(Passanger passanger){
//        Passanger foundPassanger = null;
//        if(passangers.contains(passanger)){
//           foundPassanger = passanger;
//        }
//        return foundPassanger;
//    }

    public int getAvailabeSeats() {
        if (this.planeType.getPassangerCapacity() >= this.passangers.size()){
            return this.planeType.getPassangerCapacity() - this.passangers.size();
        } else {
            return 0;
        }
    }

    public void bookPassangers(Passanger passanger, FlightManager flightManager) {
        if ((this.getAvailabeSeats() > 0)  && (flightManager.availableBaggageWeightLeft(this)>= (passanger.getBags() * flightManager.baggageWeightPerPassanger(this)))){
            this.passangers.add(passanger);
            flightManager.addFlight(this, passanger);
//            passanger.setFlight(this);
            flightManager.generateSeatNumber(passanger,this);

        }
    }

//    public double baggageWeightPerPassanger() {
//        return (this.planeType.getTotalWeight()/2.0)/this.planeType.getPassangerCapacity();
//    }
//
//    public double weightOfBaggageBookedOnFlight() {
//        double weightOfBags = 0.00;
//        for (Passanger passanger : this.passangers){
//            weightOfBags += this.baggageWeightPerPassanger() * passanger.getBags();}
//        return weightOfBags;
//    }
//
//    public double availabeBaggageCapacity() {
//        return this.baggageWeightPerPassanger() * this.planeType.getPassangerCapacity();
//    }
//
//    public double availableBaggageWeightLeft() {
//        return this.availabeBaggageCapacity() - this.weightOfBaggageBookedOnFlight();
//    }

//    public void generateSeatNumber(Passanger passanger) {
//        Random random = new Random();
//        int seatNumber = random.nextInt(this.planeType.getPassangerCapacity()) +1;
//        System.out.println(seatNumber);
//        passanger.setSeatNumber(seatNumber);
//    }

}

