class SportsCar extends Vehicle implements Automobile {

    public SportsCar(String brand) {
        super(brand);
    }

    @Override
    public void accelerate() {
        speed += 80;
        System.out.println("SportsCar accelerating fast! Speed: " + speed);
    }

    @Override
    public void stop() {
        speed = 0;
        System.out.println("SportsCar stopped.");
    }

    @Override
    public void gas() {
        System.out.println("SportsCar premium fuel filled.");
    }

    @Override
    public void openBoot() {
        System.out.println("SportsCar trunk opened.");
    }

    @Override
    public void playRadio() {
        System.out.println("SportsCar radio playing.");
    }
}