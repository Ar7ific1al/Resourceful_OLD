package com.github.ar7ific1al.resourceful;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
	public static Resourceful plugin;

	//Config Stuffs
	
		static File resConfig;
		static FileConfiguration config;
		
		public static void loadConfig()	{
			//Set Defaults Here
			//Global
			plugin.getConfig().addDefault("Log Debug to Console", true);
			//Coal Ore
			plugin.getConfig().addDefault("Ores.Coal Ore.Seconds to Respawn", 5);
			plugin.getConfig().addDefault("Ores.Coal Ore.Alert Deplete", true);
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 1.Chance", 25);
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 1.Type", "COAL");
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 1.Count", 2);
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 1.Alert Finds", true);		
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 1.Alert Message", "Your efforts in mining were rewarded with Coal!");
			
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 2.Chance", 55);
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 2.Type", "AIR");
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 2.Count", 1);
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 2.Alert Finds", false);
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 2.Alert Message", "Tough break, your efforts in mining were fruitless.");
			
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 3.Chance", 100);
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 3.Type", "COBBLESTONE");
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 3.Count", 1);
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 3.Alert Finds", false);
			plugin.getConfig().addDefault("Ores.Coal Ore.Drop 3.Alert Message", "Your efforts in mining were rewarded with Cobblestone!");
			
			
			//Iron Ore
			plugin.getConfig().addDefault("Ores.Iron Ore.Seconds to Respawn", 5);
			plugin.getConfig().addDefault("Ores.Iron Ore.Alert Deplete", true);
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 1.Chance", 15);
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 1.Type", "IRON_ORE");
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 1.Count", 2);
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 1.Alert Finds", true);		
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 1.Alert Message", "Your efforts in mining were rewarded with Iron Ore!");
			
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 2.Chance", 45);
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 2.Type", "AIR");
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 2.Count", 1);
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 2.Alert Finds", false);
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 2.Alert Message", "Tough break, your efforts in mining were fruitless.");
			
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 3.Chance", 100);
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 3.Type", "COBBLESTONE");
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 3.Count", 1);
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 3.Alert Finds", false);
			plugin.getConfig().addDefault("Ores.Iron Ore.Drop 3.Alert Message", "Your efforts in mining were rewarded with Cobblestone!");
			
			//Gold Ore
			plugin.getConfig().addDefault("Ores.Gold Ore.Seconds to Respawn", 5);
			plugin.getConfig().addDefault("Ores.Gold Ore.Alert Deplete", true);
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 1.Chance", 8);
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 1.Type", "GOLD_ORE");
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 1.Count", 1);
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 1.Alert Finds", true);		
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 1.Alert Message", "Your efforts in mining were rewarded with Gold Ore!");
			
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 2.Chance", 45);
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 2.Type", "AIR");
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 2.Count", 1);
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 2.Alert Finds", false);
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 2.Alert Message", "Tough break, your efforts in mining were fruitless.");
			
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 3.Chance", 100);
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 3.Type", "COBBLESTONE");
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 3.Count", 1);
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 3.Alert Finds", false);
			plugin.getConfig().addDefault("Ores.Gold Ore.Drop 3.Alert Message", "Your efforts in mining were rewarded with Cobblestone!");
			
			//Diamond Ore
			plugin.getConfig().addDefault("Ores.Diamond Ore.Seconds to Respawn", 5);
			plugin.getConfig().addDefault("Ores.Diamond Ore.Alert Deplete", true);
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 1.Chance", 5);
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 1.Type", "DIAMOND");
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 1.Count", 1);
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 1.Alert Finds", true);		
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 1.Alert Message", "Your efforts in mining were rewarded with Diamond!");
			
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 2.Chance", 35);
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 2.Type", "AIR");
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 2.Count", 1);
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 2.Alert Finds", false);
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 2.Alert Message", "Tough break, your efforts in mining were fruitless.");
			
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 3.Chance", 100);
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 3.Type", "COBBLESTONE");
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 3.Count", 1);
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 3.Alert Finds", false);
			plugin.getConfig().addDefault("Ores.Diamond Ore.Drop 3.Alert Message", "Your efforts in mining were rewarded with Cobblestone!");
			
			//Emerald Ore
			
			
			//Lapis Lazuli Ore
			
			
			//Redstone Ore
			
			plugin.getConfig().options().copyDefaults(true);
			plugin.saveConfig();
		}
		
		public void saveYamls()	{
			try	{
				config.save(resConfig);
			}	catch (IOException e)	{
				e.printStackTrace();
			}
		}
		//End of Config Stuffs
	
}
