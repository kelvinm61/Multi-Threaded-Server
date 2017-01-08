package requester;
import java.io.*;
public class list extends Request 
{	
	private static final long serialVersionUID = 1L;	
	private static final String command = "List";
	private String path;
	public list (String ip)
	{
		super(ip);
	}

	@Override
	public void run() 
	{
		try {
			File folder = new File(path);
			File[] file = folder.listFiles();
		
			ObjectOutput out = new ObjectOutput(super.getSocket().getOutputStream());
			out.writeObject(file);
			out.close();
			
		} catch (IOException exception) 
		{
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
		
	}
	
	public String getFilePath() 
	{
		return path;
	}

	public void setFilePath(String filePath) 
	{
		this.path = filePath;
	}

	@Override
	public String toString()
	{
		return command + " requested by " + super.getCom() + " at " + super.getCom().toString();
	}

}