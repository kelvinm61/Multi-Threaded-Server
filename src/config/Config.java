package config;
public class Config {
	public static final String CONFIG_FILE = "config.xml";
	private String username;
	private String host;
	private int port;
	
	public Config() 
	{
		super();
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getServerhost() 
	{
		return host;
	}

	public void setServerhost(String serverhost) 
	{
		this.host = serverhost;
	}

	public int getServerport() 
	{
		return port;
	}

	public void setServerport(int serverport) 
	{
		this.port = serverport;
	}


	@Override
	public String toString() 
	{
		return "Context [username=" + username + ", serverhost=" + host + ", serverport=" + port+ "]";
	}
	
}