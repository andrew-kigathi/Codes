
// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
    String greetMe() throws RemoteException;
}