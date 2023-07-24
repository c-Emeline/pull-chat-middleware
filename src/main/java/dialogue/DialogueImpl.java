package dialogue;

import javafx.scene.control.Label;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;

public class DialogueImpl extends UnicastRemoteObject implements Dialogue {

	private ArrayList<String> clientsName = new ArrayList<>();
	private ArrayList<ArrayList<String>> messages = new ArrayList<>();

	protected DialogueImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean connect(String pseudo) throws RemoteException {
		if(clientsName != null){ if(clientsName.contains(pseudo)) { System.out.println("User already connected !"); return false;} }
		clientsName.add(pseudo);
		System.out.println(pseudo + " connected !");
		return true;
	}

	@Override
	public void disconnect(String pseudo) throws RemoteException {
		if(clientsName.contains(pseudo)){
			clientsName.remove(pseudo);
			System.out.println(pseudo + " disconnected !");
		}
	}

	@Override
	public String[] getClients() throws RemoteException {
		return this.clientsName.toArray(new String[clientsName.size()]);
	}

	@Override
	public boolean sendMessage(String from, String to, String message) throws RemoteException {
		this.messages.add(new ArrayList<String>(Arrays.asList(from, to, message)));
		if (clientsName.contains(to)){
			return true;
		}
		return false;
	}

	@Override
	public String[] getMessages(String pseudo) throws RemoteException {
		ArrayList<String> msgReceived = new ArrayList<>();
		for (ArrayList<String> m : messages){
			if (m.get(1).equals(pseudo)){
				msgReceived.add(m.get(0)+" : "+m.get(2));
			}
		}
		return msgReceived.toArray(new String[msgReceived.size()]);
	}
}
