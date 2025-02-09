package OOPS.Interfaces;

class Car implements Engine, Transmission {
    private int currentGear;

    @Override
    public void start() {
        System.out.println("Car engine started.");
    }

    @Override
    public void stop() {
        System.out.println("Car engine stopped.");
    }

    @Override
    public void changeGear(int gear) {
        this.currentGear = gear;
        System.out.println("Gear changed to: " + currentGear);
    }

    @Override
    public void showGear() {
        System.out.println("Current gear: " + currentGear);
    }
}
