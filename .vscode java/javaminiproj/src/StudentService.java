import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface StudentService extends Remote {
    List<Student> getAllStudents() throws RemoteException;
}
