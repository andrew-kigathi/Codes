class Sedan extends Vehicle implements Automobile {

    public Sedan(String brand) {
        super(brand);
    }

    @Override
    public void accelerate() {
        speed += 50;
        System.out.println(brand + " Sedan accelerating. Speed: " + speed);
    }

    @Override
    public void stop() {
        speed = 0;
        System.out.println(brand + " Sedan stopped.");
    }

    @Override
    public void gas() {
        System.out.println(brand + " Sedan gas filled.");
    }

    @Override
    public void openBoot() {
        System.out.println(brand + " Sedan trunk opened.");
    }

    @Override
    public void playRadio() {
        System.out.println(brand + " Sedan radio playing.");
    }
}