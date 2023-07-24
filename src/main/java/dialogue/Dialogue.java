package dialogue;

import javafx.scene.control.Label;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Dialogue extends Remote {
	
	boolean connect(String pseudo/*, Label connectionError*/) throws RemoteException;
	void disconnect(String pseudo) throws RemoteException;
	String[] getClients() throws RemoteException;
	boolean sendMessage(String from, String to, String message) throws RemoteException;
	String[] getMessages(String pseudo) throws RemoteException;

}
