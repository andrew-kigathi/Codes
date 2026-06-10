import java.rmi.RemoteException;

public class ImplObj implements MyInterface {
    @Override
    public String greetMe() throws RemoteException {
        return "Hello World!";
    }
}