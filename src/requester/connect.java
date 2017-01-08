package requester;
import java.io.*;

public class connect extends Request {
	
	private static final long serialVersionUID = 1L;
	private static final String command = "Connection";
	
	public connect (String ip)
	{
		super(ip);
	}
	
	@Override
	public void run() 
	{		
		try 
		{
			String text = "Connection has been successful";
			ObjectOutput out = new ObjectOutput(super.getSocket().getOutput());
			out.writeObject(text);
			out.close();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}		
	}
	@Override
	public String toString() 
	{
		return command + " request by " + super.getD() + " at " + super.getD().toString();
	}
}