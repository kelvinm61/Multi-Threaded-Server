package client;

import java.util.Scanner;
import config.Config;
import config.xml;

public class runner
{

	public static void main(String[] args) throws Throwable
	{
		Scanner console = new Scanner(System.in);
		
		int variable;
		
		Config config = new Config();
		xml x = new xml(config);
		x.parse();
		System.out.println(config);
		
		
		ui ui = new ui();
		file  newfile= new file(config);
		
		while (ui.isRunning()) 
		{
		
			ui.printMenu();
			variable = console.nextInt();
		
			switch (variable) 
			{
				case 1:
					newfile.connect();
					break;
				case 2:
					newfile.list();
					break;
				case 3:
					ui.quit();
					break;
				default:
			}
		} 
		console.close();
	} 
} 