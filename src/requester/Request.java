package requester;
import java.util.Date;
import java.net.*;

public abstract class Request implements Runnable
{	
	private Date date;
	private String ip;
	private Socket socket;
	private String host;
	private int port;
	private String com;
	private String username;
	
	public Request(String ip) 
	{
		date = new Date();
		this.ip = ip;
	}

	public Date getDate()
	{
		return date;
	}

	public void setD(Date date)
	{
		this.date = date;
	}

	public String getip() 
	{
		return ip;
	}

	public void setClientIp(String ip)
	{
		this.ip = ip;
	}

	public Socket getSocket() 
	{
		return socket;
	}

	public void setSocket(Socket socket) 
	{
		this.socket = socket;
	}

	public String gethost() 
	{
		return host;
	}

	public void sethost(String host) 
	{
		this.host = host;
	}

	public int getport() 
	{
		return port;
	}

	public void setport(int port) 
	{
		this.port = port;
	}

	public String getCom() 
	{
		return com;
	}

	public void setCom(String com) 
	{
		this.com = com;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
}