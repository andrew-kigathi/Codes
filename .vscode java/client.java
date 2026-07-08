// Name: Andrew Kigathi
// Student Number: 220277
// Date: 22 May 2026

import java.rmi.Naming;

public class client {

    public static void main(String[] args) {

        try {

            // Locate remote object
            miniproj obj = (miniproj) Naming.lookup(
                    "rmi://localhost/HelloService");

            // Invoke remote method
            String response = obj.message();

            // Display response
            System.out.println(response);
        }

        catch (Exception e) {

            System.out.println(e);
        }
    }
}
