/*
    *The highschool class inherits from the institution class,
        which means that it can use the attributes and methods defined in the institution class.
*/

public class highschool extends institution  {

private String curriculum;

    public highschool(String name, String city, int launch_year) {
        
        /*
            * The constructor of the highschool class calls the constructor
                of the institution class using the SUPER keyword to initialize the inherited attributes (name, city, launch_year).
            * The SUPER keyword is used to refer to the parent class (institution)
                and allows the highschool class to reuse the constructor of the institution class,
                ensuring that the inherited attributes are properly initialized when a highschool object is created.
        */

        super(name, city, launch_year);
        this.curriculum = curriculum;
    }

    @Override // The @Override annotation indicates that the showDetails method in the highschool class is intended to override a method with the same name in the parent institution class.
    public void showDetails() {
        /*
            * Polymorphism allows the highschool class to provide its own implementation of the showDetails method,
                which can include additional information specific to high schools (like curriculum)
                while still retaining the ability to call the original showDetails method from the institution class using SUPER.showDetails().
        */
        super.showDetails();
        System.out.println("Curriculum: " + curriculum);
    }
}
