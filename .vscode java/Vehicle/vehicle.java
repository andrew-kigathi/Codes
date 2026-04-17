abstract class Vehicle {
    protected String brand;
    protected int speed;

    public Vehicle(String brand) {
        this.brand = brand;
        this.speed = 0;
    }

    public abstract void accelerate();
    public abstract void stop();
    public abstract void gas();

    public void accelerate(int increment) {
        speed += increment;
        System.out.println(brand + " accelerated by " + increment + " km/h. Speed: " + speed);
    }
}