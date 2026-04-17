public class Main {
    public static void main(String[] args){

    /*
    * In the main method, we create instances of the institution, highschool, and university classes.
    * We then call the showDetails method on each instance to display their respective details.
    */

        institution obj1 = new institution("Madaraka Pri. School", "Nairobi", 2000);
        highschool obj2 = new highschool("Kiambu High School", "Kiambu", 2005 );
        university obj3 = new university("Strathmore University", "Nairobi", 2010);

        System.out.println("Institution Details:");
        obj1.showDetails();

        System.out.println("\nHigh School Details:");
        obj2.showDetails();
        
        System.out.println("\nUniversity Details:");
        obj3.showDetails();
    }
}
