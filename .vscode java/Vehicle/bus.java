class Bus extends Vehicle {

    public Bus(String brand) {
        super(brand);
    }

    @Override
    public void accelerate() {
        speed += 20;
        System.out.println("Bus accelerating. Speed: " + speed);
    }

    @Override
    public void stop() {
        speed = 0;
        System.out.println("Bus stopped.");
    }

    @Override
    public void gas() {
        System.out.println("Bus tank filled.");
    }
}