public class institution {
    private String name;
    private String city;
    private int launch_year;

    /* *A constructor that is used to create objects
       *Initialize the values of all the class attributes
    */
    
    public institution(String name, String city, int launch_year) {
        this.name = name;
        this.city = city;
        this.launch_year = launch_year;
    }

    public void showDetails() {
        System.out.println("Institution Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Launch Year: " + launch_year);
    }
}
