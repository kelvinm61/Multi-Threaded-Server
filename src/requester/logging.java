package requester;
import java.io.*;
import java.util.concurrent.BlockingQueue;

public class logging implements Runnable
{
	private BlockingQueue<Request> queue;
	private FileWriter fileWriter;
	private boolean keepRunning = true;
	
	public logging(BlockingQueue<Request> queue) throws IOException
	{
		this.queue = queue;
		fileWriter = new FileWriter(new File("logging.txt"));
	}
	
	@Override
	public void run() 
	{
		while(keepRunning) 
		{
			try
			{
				Request request = queue.take();
				System.out.println(request.toString());
				fileWriter.write(request.toString());		
				fileWriter.close();
				
				new Thread(request);
			} 
			catch (InterruptedException exception)
			{
				exception.printStackTrace();
			} 
			catch (IOException exception) {
				exception.printStackTrace();
			}	
		}
	}

}