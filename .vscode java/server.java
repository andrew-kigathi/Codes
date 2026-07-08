// Name: Andrew Kigathi
// Student Number: 220277
// Date: 22 May 2026

import java.rmi.Naming;

public class server {

    public static void main(String[] args) {

        try {

            // Create remote object
            miniprojimpl obj = new miniprojimpl();

            // Register object with RMI registry
            Naming.rebind("rmi://localhost/HelloService", obj);

            System.out.println("Server is running...");
        }

        catch (Exception e) {

            System.out.println(e);
        }
    }
}
