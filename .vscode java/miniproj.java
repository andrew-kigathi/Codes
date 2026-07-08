// Name: Andrew Kigathi
// Student Number: 220277
// Date: 22 May 2026

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface miniproj extends Remote {

    String message() throws RemoteException;
}