import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            StudentService service = new StudentServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("StudentService", service);
            System.out.println("StudentService is running on port 1099.");
        } catch (Exception e) {
            System.err.println("Could not start StudentService: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
