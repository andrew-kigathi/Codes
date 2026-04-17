public class MainVehicle {
    public static void main(String[] args) {

        Sedan sedan = new Sedan("Toyota");

        sedan.accelerate();
        sedan.stop();
        sedan.gas();

        sedan.openBoot();
        sedan.playRadio();

        sedan.accelerate(25);

        System.out.println();

        Vehicle v1 = new Motorcycle("Yamaha");
        Vehicle v2 = new Bus("Mercedes");
        Vehicle v3 = new SportsCar("Ferrari");

        v1.accelerate();
        v2.accelerate();
        v3.accelerate();
    }
}