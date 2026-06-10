// Name: Andrew Kigathi
// Student ID: 220277
// Date: 22/05/2026

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface miniproj extends Remote {
    String message(String text) throws RemoteException;

    List<Student> getStudents() throws RemoteException;
}
