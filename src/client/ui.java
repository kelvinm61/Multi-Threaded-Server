package client;

public class ui 
{
	boolean run = true;
	public ui() 
	{		
	}	
	public void printMenu() 
	{
		System.out.println("Connect to the Server");
		System.out.println("Print the file list");
		System.out.println("Quit");		
		System.out.print("Type which option you would like, 1,2 or 3");
	}
	public boolean isRunning()
	{
		return run;
	}
	
	public void quit()
	{
		this.run= false;
	}
}