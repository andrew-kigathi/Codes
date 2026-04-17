class Sedan extends Vehicle implements Automobile {

    public Sedan(String brand) {
        super(brand);
    }

    @Override
    public void accelerate() {
        speed += 15;
        System.out.println("Sedan accelerating. Speed: " + speed);
    }

    @Override
    public void stop() {
        speed = 0;
        System.out.println("Sedan stopped.");
    }

    @Override
    public void gas() {
        System.out.println("Sedan gas filled.");
    }

    @Override
    public void openTrunk() {
        System.out.println("Sedan trunk opened.");
    }

    @Override
    public void playRadio() {
        System.out.println("Sedan radio playing.");
    }
}