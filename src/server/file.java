package server;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

import requester.*;

public class file {
	private ServerSocket serversocket;	
	private int portNo;
	private String Path;
	private boolean keepRunning = true;
	private static final int MAX_SIZE = 5;
	
	BlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(MAX_SIZE);	
	public void FileServer(int portNo, String Path)
	{
		try
		{ 
			this.portNo = portNo;
			this.Path = Path;
			serversocket = new ServerSocket(portNo); 
			Thread server = new Thread(new listen(), "server is listening"); 
			server.setPriority(Thread.MAX_PRIORITY); 
			server.start(); 
			
			
			new Thread(new logging(queue), "RequestLogger").start();
			System.out.println("Server is listening on port " + portNo);
			}
		catch (IOException exception) 
		{
			System.out.println("Error" + exception.getMessage());
		}
	}
