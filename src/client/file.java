package client;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import config.Config;
import requester.connect;
import requester.list;
public class file implements server 
{

	private Socket socket;
	private File[] files;
	private String host;
	private int port;
	private String ip;
	
	public <getServerHost> file(Config conf)
	{
		this.host = conf.getServerhost();
		this.port = conf.getServerport();
	}
	
	@Override
	public void connect() 
	{	
		try {
			socket = new Socket(host, port);
			
			
	        ip = socket.getLocalAddress().getHostAddress();
			
	        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
	        
	        out.writeObject(new connect(ip)); 
	        out.flush(); 
	        
	        Thread.yield(); 
	        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
	        String response = (String) in.readObject(); 
	        System.out.println(response);
	        
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			 exception.printStackTrace();
		}
	}

	@Override
	public void list() 
	{
		try 
		{
			socket = new Socket(host, port);
			ip = socket.getLocalAddress().getHostAddress();
			
	        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
	        
	        out.writeObject(new list(ip));
	        out.flush();

	        Thread.yield(); //hold up the thread
	        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
	        files = (File[]) in.readObject(); 
	        
	        for(int i = 0; i < files.length; i++)
	        {
	        	System.out.println(files[i].getName());
	        }
		} catch (Exception  exception) {
			System.out.println("Connection doesnt exist");
			 exception.printStackTrace();
		}        
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void logginf() {
		// TODO Auto-generated method stub
		
	}

}