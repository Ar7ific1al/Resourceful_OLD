package com.github.ar7ific1al.resourceful;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Resourceful extends JavaPlugin implements Listener	{
	
	public static Resourceful plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	String pluginVersion;
	String noPerms = "You do not have permission to execute that command.";
	
	//Chat Colors
	ChatColor BLACK = ChatColor.BLACK;
	ChatColor DBLUE = ChatColor.DARK_BLUE;
	ChatColor DGREEN = ChatColor.DARK_GREEN;
	ChatColor DAQUA = ChatColor.DARK_AQUA;
	ChatColor DRED = ChatColor.DARK_RED;
	ChatColor PURPLE = ChatColor.DARK_PURPLE;
	ChatColor GOLD = ChatColor.GOLD;
	ChatColor GRAY = ChatColor.GRAY;
	ChatColor DGRAY = ChatColor.DARK_GRAY;
	ChatColor BLUE = ChatColor.BLUE;
	ChatColor LGREEN = ChatColor.GREEN;
	ChatColor LAQUA = ChatColor.AQUA;
	ChatColor LRED = ChatColor.RED;
	ChatColor PINK = ChatColor.LIGHT_PURPLE;
	ChatColor YELLOW = ChatColor.YELLOW;
	ChatColor WHITE = ChatColor.WHITE;
	ChatColor ITALIC = ChatColor.ITALIC;
	ChatColor MAGIC = ChatColor.MAGIC;
	ChatColor STRIKE = ChatColor.STRIKETHROUGH;
	ChatColor ULINE = ChatColor.UNDERLINE;
	ChatColor ResColor = ChatColor.RESET;
	
	
	
	//Config Stuffs
	
	File resConfig;
	static FileConfiguration config;
	
	public void loadConfig()	{
		//Set Defaults Here
		//Global
		this.getConfig().addDefault("Log Debug to Console", true);
		this.getConfig().addDefault("Ores.Enable Harvest Mode", true);
		//COAL_ORE
		this.getConfig().addDefault("Ores.COAL_ORE.Seconds to Respawn", 900);
		this.getConfig().addDefault("Ores.COAL_ORE.Harvest Count", 3);
		this.getConfig().addDefault("Ores.COAL_ORE.Alert Deplete", true);
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 1.Chance", 25);
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 1.Type", "COAL");
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 1.Count", 2);
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 1.Alert Finds", true);		
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 1.Alert Message", "Your efforts in mining were rewarded with Coal!");
		
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 2.Chance", 55);
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 2.Type", "AIR");
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 2.Count", 1);
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 2.Alert Finds", false);
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 2.Alert Message", "Tough break, your efforts in mining were fruitless.");
		
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 3.Chance", 100);
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 3.Type", "COBBLESTONE");
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 3.Count", 1);
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 3.Alert Finds", false);
		this.getConfig().addDefault("Ores.COAL_ORE.Drop 3.Alert Message", "Your efforts in mining were rewarded with Cobblestone!");
		
		
		//IRON_ORE
		this.getConfig().addDefault("Ores.IRON_ORE.Seconds to Respawn", 900);
		this.getConfig().addDefault("Ores.IRON_ORE.Harvest Count", 3);
		this.getConfig().addDefault("Ores.IRON_ORE.Alert Deplete", true);
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 1.Chance", 15);
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 1.Type", "IRON_ORE");
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 1.Count", 2);
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 1.Alert Finds", true);		
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 1.Alert Message", "Your efforts in mining were rewarded with IRON_ORE!");
		
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 2.Chance", 45);
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 2.Type", "AIR");
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 2.Count", 1);
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 2.Alert Finds", false);
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 2.Alert Message", "Tough break, your efforts in mining were fruitless.");
		
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 3.Chance", 100);
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 3.Type", "COBBLESTONE");
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 3.Count", 1);
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 3.Alert Finds", false);
		this.getConfig().addDefault("Ores.IRON_ORE.Drop 3.Alert Message", "Your efforts in mining were rewarded with Cobblestone!");
		
		//GOLD_ORE
		this.getConfig().addDefault("Ores.GOLD_ORE.Seconds to Respawn", 900);
		this.getConfig().addDefault("Ores.GOLD_ORE.Harvest Count", 3);
		this.getConfig().addDefault("Ores.GOLD_ORE.Alert Deplete", true);
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 1.Chance", 8);
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 1.Type", "GOLD_ORE");
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 1.Count", 1);
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 1.Alert Finds", true);		
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 1.Alert Message", "Your efforts in mining were rewarded with GOLD_ORE!");
		
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 2.Chance", 45);
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 2.Type", "AIR");
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 2.Count", 1);
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 2.Alert Finds", false);
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 2.Alert Message", "Tough break, your efforts in mining were fruitless.");
		
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 3.Chance", 100);
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 3.Type", "COBBLESTONE");
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 3.Count", 1);
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 3.Alert Finds", false);
		this.getConfig().addDefault("Ores.GOLD_ORE.Drop 3.Alert Message", "Your efforts in mining were rewarded with Cobblestone!");
		
		//DIAMOND_ORE
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Seconds to Respawn", 900);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Harvest Count", 3);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Alert Deplete", true);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 1.Chance", 5);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 1.Type", "DIAMOND");
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 1.Count", 1);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 1.Alert Finds", true);		
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 1.Alert Message", "Your efforts in mining were rewarded with Diamond!");
		
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 2.Chance", 35);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 2.Type", "AIR");
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 2.Count", 1);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 2.Alert Finds", false);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 2.Alert Message", "Tough break, your efforts in mining were fruitless.");
		
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 3.Chance", 100);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 3.Type", "COBBLESTONE");
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 3.Count", 1);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 3.Alert Finds", false);
		this.getConfig().addDefault("Ores.DIAMOND_ORE.Drop 3.Alert Message", "Your efforts in mining were rewarded with Cobblestone!");
		
		//EMERALD_ORE
		this.getConfig().addDefault("Ores.EMERALD_ORE.Seconds to Respawn", 900);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Harvest Count", 3);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Alert Deplete", true);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 1.Chance", 3);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 1.Type", "EMERALD");
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 1.Count", 1);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 1.Alert Finds", true);		
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 1.Alert Message", "Your efforts in mining were rewarded with Emerald!");
		
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 2.Chance", 35);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 2.Type", "AIR");
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 2.Count", 1);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 2.Alert Finds", false);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 2.Alert Message", "Tough break, your efforts in mining were fruitless.");
		
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 3.Chance", 100);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 3.Type", "COBBLESTONE");
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 3.Count", 1);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 3.Alert Finds", false);
		this.getConfig().addDefault("Ores.EMERALD_ORE.Drop 3.Alert Message", "Your efforts in mining were rewarded with Cobblestone!");
		
		//Lapis Lazuli Ore
		
		
		//Redstone Ore
		
		//Vegetation
		this.getConfig().addDefault("Vegetation.Enable Harvest Mode", true);
		//LONG_GRASS
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Seconds to Respawn", 5);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Harvest Count", 2);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Alert Deplete", true);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 1.Chance", 65);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 1.Type", "YELLOW_FLOWER");
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 1.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 1.Count.Maximum", 5);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 1.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 1.Alert Message.Success", "Your efforts in forraging were rewarded with YELLOW_FLOWERs!");
		
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 2.Chance", 20);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 2.Type", "LONG_GRASS");
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 2.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 2.Count.Maximum", 3);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 2.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 2.Alert Message.Success", "Your efforts in forraging were rewarded with Grass!");
		
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 3.Chance", 15);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 3.Type", "SEEDS");
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 3.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 3.Count.Maximum", 9);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 3.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.LONG_GRASS.Drop 3.Alert Message.Success", "Your efforts in forraging were rewarded with Seeds!");
		
		//DEAD_BUSH
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Seconds to Respawn", 5);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Harvest Count", 2);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Alert Deplete", true);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 1.Chance", 65);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 1.Type", "YELLOW_FLOWER");
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 1.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 1.Count.Maximum", 5);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 1.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 1.Alert Message.Success", "Your efforts in forraging were rewarded with YELLOW_FLOWERs!");
		
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 2.Chance", 20);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 2.Type", "LONG_GRASS");
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 2.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 2.Count.Maximum", 3);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 2.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 2.Alert Message.Success", "Your efforts in forraging were rewarded with Grass!");
		
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 3.Chance", 15);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 3.Type", "SEEDS");
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 3.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 3.Count.Maximum", 9);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 3.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.DEAD_BUSH.Drop 3.Alert Message.Success", "Your efforts in forraging were rewarded with Seeds!");
		
		//RED_ROSE
		this.getConfig().addDefault("Vegetation.RED_ROSE.Seconds to Respawn", 5);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Harvest Count", 2);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Alert Deplete", true);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 1.Chance", 65);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 1.Type", "YELLOW_FLOWER");
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 1.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 1.Count.Maximum", 5);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 1.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 1.Alert Message.Success", "Your efforts in forraging were rewarded with YELLOW_FLOWERs!");
		
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 2.Chance", 20);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 2.Type", "LONG_GRASS");
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 2.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 2.Count.Maximum", 3);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 2.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 2.Alert Message.Success", "Your efforts in forraging were rewarded with Grass!");
		
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 3.Chance", 15);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 3.Type", "SEEDS");
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 3.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 3.Count.Maximum", 9);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 3.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.RED_ROSE.Drop 3.Alert Message.Success", "Your efforts in forraging were rewarded with Seeds!");
		
		//YELLOW_FLOWER
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Seconds to Respawn", 5);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Harvest Count", 2);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Alert Deplete", true);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 1.Chance", 65);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 1.Type", "YELLOW_FLOWER");
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 1.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 1.Count.Maximum", 5);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 1.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 1.Alert Message.Success", "Your efforts in forraging were rewarded with YELLOW_FLOWERs!");
		
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 2.Chance", 20);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 2.Type", "LONG_GRASS");
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 2.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 2.Count.Maximum", 3);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 2.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 2.Alert Message.Success", "Your efforts in forraging were rewarded with Grass!");
		
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 3.Chance", 15);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 3.Type", "SEEDS");
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 3.Count.Minimum", 0);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 3.Count.Maximum", 9);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 3.Alert Finds", false);
		this.getConfig().addDefault("Vegetation.YELLOW_FLOWER.Drop 3.Alert Message.Success", "Your efforts in forraging were rewarded with Seeds!");
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
	
	public void saveYamls()	{
		try	{
			config.save(resConfig);
		}	catch (IOException e)	{
			e.printStackTrace();
		}
	}
	//End of Config Stuffs
	
	
	public ResEventListener ResEventListener = new ResEventListener(this);
	//public PlayerLogoutListener LogoutListener = new PlayerLogoutListener(this);
	//public PlayerInteractListener InteractListener = new PlayerInteractListener(this);
	@Override
	public void onEnable()	{
		//Config stuff
		PluginManager pm = Bukkit.getServer().getPluginManager();
		resConfig = new File(getDataFolder(), "config.yml");
		config = getConfig();
		loadConfig();
		
		PluginDescriptionFile pdFile = this.getDescription();
		pluginVersion = pdFile.getVersion();
		this.logger.info("[Resourceful] Version " + pluginVersion +
				" Now providing resource gathering functionality.");
		//getServer().getPluginManager().registerEvents(this, this);
		//new BlockBreakListener(this);
		pm.registerEvents(this, this);
		pm.registerEvents(ResEventListener, this);
		//pm.registerEvents(LogoutListener, this);
		//pm.registerEvents(InteractListener, this);
	}
	
	@Override
	public void onDisable()	{
		PluginDescriptionFile pdFile = this.getDescription();
		pluginVersion = pdFile.getVersion();
		this.logger.info("[Resourceful] Version " + pluginVersion +
				" No longer providing resource gathering functionality.");
	}
	
	//Command Stuff! Finally...
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args)	{
		if (sender instanceof Player)	{
			final Player player = (Player) sender;
		
			if (cmdLabel.equalsIgnoreCase("res"))	{
				try	{
					//res help
					if (args[0].equalsIgnoreCase("help"))	{
						if (player.hasPermission("resourceful.help"))	{
							player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + "Commands:");
							player.sendMessage(LGREEN + "- /res help: where you are now, displays help");
							//player.sendMessage(LGREEN + "- /res");
							//Admin Only Commands
							if (player.hasPermission("resourceful.admin"))	{
								player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + "As an admin, you may use these commands.");
								player.sendMessage(LGREEN + "  -/res admin toggle: Toggle Admin Mode on yourself.\n  -Alias: /res a t");
							}
						}
						else	{
							player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + noPerms);
						}
					}
					
					//res ver|version
					else if (args[0].equalsIgnoreCase("ver") || args[0].equalsIgnoreCase("version"))	{
						player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + " Version: " + pluginVersion);
						player.sendMessage(LGREEN + "  \"/res help\" for commands.");
					}
					//res admin
					//Res Admin command and functionality
					else if (args[0].equalsIgnoreCase("admin") || args[0].equalsIgnoreCase("a")
							&& args[1].equalsIgnoreCase("toggle") || args[1].equalsIgnoreCase("t"))	{
						if (player.hasPermission("resourceful.admin"))	{
							if (player.hasPermission("resourceful.admin"))	{
								if (!HashMaps.resAdmin.containsKey(player.getName()))	{
									player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + 
											"Admin Mode enabled.");
									player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + 
											"Right-click ores with your hand to remove them.");
									player.sendMessage(LGREEN + "  -Left-click blocks while holding an ore to transform it into that ore.");
									HashMaps.resAdmin.put(player.getName(), player.getName());
									if (config.getBoolean("Log Debug to Console") == true)	{
										Bukkit.getServer().getLogger().info("[Resourceful] " + HashMaps.resAdmin.get(player.getName()) +
												" enabled Admin Mode.");
									}
									//Bukkit.getServer().getLogger().info("" + HashMaps.resAdmin.get(name));
								}
								else if (HashMaps.resAdmin.containsKey(player.getName()))	{
									player.sendMessage(DGREEN + "[Resourceful] " + LGREEN +
											"Admin mode disabled.");
									HashMaps.resAdmin.remove(player.getName());
									if (config.getBoolean("Log Debug to Console"))	{
										Bukkit.getServer().getLogger().info("[Resourceful] " + player.getName() +
												" disabled Admin Mode.");
									}
								}
							}
						}
					}
					//Res Admin help/information
					else if (args[0].equalsIgnoreCase("admin") && args[1].equalsIgnoreCase("?")
							|| args[1].equalsIgnoreCase("info"))	{
						if (player.hasPermission("resourceful.admin"))	{
							player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + "Admin Mode allows you to place and break ores.");
							player.sendMessage(LGREEN + "  -Right-click ores with an empty hand to remove them.");
							player.sendMessage(LGREEN + "  -Left-click blocks while holding an ore to transform it into that ore.");
						}
					}
					else if (args[0].equalsIgnoreCase("testmap"))	{
						if (!HashMaps.testMap.containsKey(player.getName()))	{
							HashMaps.testMap.put(player.getName(), 1);
						}
						else if (HashMaps.testMap.containsKey(player.getName()))	{
							HashMaps.testMap.put(player.getName(), HashMaps.testMap.get(player.getName()) + 1);
						}
						Bukkit.getServer().broadcastMessage(player.getName() + ": " + HashMaps.testMap.get(player.getName()));
					}
				}
				catch (ArrayIndexOutOfBoundsException ex)	{
					return false;
				}
			}
		}
		
		//
		
		return true;
	}

}
