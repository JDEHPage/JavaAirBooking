public enum PlaneType {

    AIRBUS_A380(10, 277),
    BOEING_707(7, 328),
    BOEING_767(9, 395),
    BOEING_727(4, 46),
    AIRBUS_A340(7, 275),
    AIRBUS_A310(5, 164);


    private final int passangerCapacity;
    private final int totalWeight;

    PlaneType(int passangerCapacity, int totalWeight){
        this.passangerCapacity = passangerCapacity;
        this.totalWeight = totalWeight;
    }

    public int getPassangerCapacity() {
        return passangerCapacity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}
