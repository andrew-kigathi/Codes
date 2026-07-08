// Name: Andrew Kigathi
// Student Number: 220277
// Date: 22 May 2026

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class miniprojimpl extends UnicastRemoteObject implements miniproj {

    // Constructor
    public miniprojimpl() throws RemoteException {

        super();
    }

    // Remote method implementation
    @Override
    public String message() throws RemoteException {

        return "Remmy, how are you doing today?";
    }
}
