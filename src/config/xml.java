package config;
import Config;
import javax.xml.parsers.*;
import org.w3c.dom.*;


public class xml implements parse 
{
	private Config config;	
	public xml(Config config)
	{
		super();
		this.config = config;
	}
	
	@Override
	public void parse() throws Throwable {
		
		DocumentBuilderFactory doc = DocumentBuilderFactory.newInstance();
		DocumentBuilder build = doc.newDocumentBuilder();
		Document document = build.parse(Config.CONFIG_FILE);
		
		Element root = document.getDocumentElement(); 
		NodeList children = root.getChildNodes(); 		
		
		config.setUsername(root.getAttribute("username"));
		
		for(int i = 0; i < children.getLength(); i++)
		{  
			Node next = children.item(i); 
			
			if (next instanceof Element) 
			{
				Element e = (Element) next; 
				
				if (e.getNodeName().equals("server-host")) 
				{ 
					config.setServerhost(e.getFirstChild().getNodeValue());
					
				} else if (e.getNodeName().equals("server-port")) 
				{ 
					config.setServerport(Integer.parseInt(e.getFirstChild().getNodeValue()));				
				} 
			} 
		} 
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

}