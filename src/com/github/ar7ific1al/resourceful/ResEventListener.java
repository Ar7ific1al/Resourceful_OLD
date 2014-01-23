package com.github.ar7ific1al.resourceful;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class ResEventListener implements Listener	{
	public Resourceful plugin;
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
		ChatColor RESET = ChatColor.RESET;
		
		
		
		public ResEventListener(Resourceful instance)	{
			//Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
			plugin = instance;
		}
		
		@EventHandler
		public void breakBlocks(BlockBreakEvent event)	{
			final Player player = event.getPlayer();
			final String pName = event.getPlayer().getName();
			final Block block = (Block) event.getBlock();
			final Material mat = event.getBlock().getType();
			final int dValue = block.getData();
			//Ores
			Material coalOre = Material.COAL_ORE;
			Material ironOre = Material.IRON_ORE;
			Material goldOre = Material.GOLD_ORE;
			Material diamondOre = Material.DIAMOND_ORE;
			Material emeraldOre = Material.EMERALD_ORE;
			Material lapisOre = Material.LAPIS_ORE;
			Material rStoneOre = Material.REDSTONE_ORE;
			//Vegetation
			Material tallGrass = Material.LONG_GRASS;
			Material deadBush = Material.DEAD_BUSH;
			Material rose = Material.RED_ROSE;
			Material flower = Material.YELLOW_FLOWER;
			Material tool = player.getItemInHand().getType();
			//Pickaxes
			Material wPick = Material.WOOD_PICKAXE;
			Material sPick = Material.STONE_PICKAXE;
			Material iPick = Material.IRON_PICKAXE;
			Material gPick = Material.GOLD_PICKAXE;
			Material dPick = Material.DIAMOND_PICKAXE;
			//Hoes
			Material wHoe = Material.WOOD_HOE;
			Material sHoe = Material.STONE_HOE;
			Material iHoe = Material.IRON_HOE;
			Material gHoe = Material.GOLD_HOE;
			Material dHoe = Material.DIAMOND_HOE;
			
			Random rNum = new Random();
			int chance = rNum.nextInt(100) + 1;
			
			if (Resourceful.config.getBoolean("Ores.Enable Harvest Mode") == true)	{
				if (player.getGameMode().equals(GameMode.SURVIVAL))	{
					//COAL ORE
					if (block.getType() == coalOre)	{
						if (tool.equals(wPick) || tool.equals(sPick) || tool.equals(iPick)
								|| tool.equals(gPick) || tool.equals(dPick))	{
						Random rand = new Random();
						int randNum = rand.nextInt(100) + 1;
						event.setCancelled(true);
						if (player.getItemInHand().getDurability() >=
								player.getItemInHand().getType().getMaxDurability())	{
							player.getInventory().setItemInHand(new ItemStack(Material.AIR));
						}
						else	{
							player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
						}
						//Handle breaking
						if (!HashMaps.coalOres.containsKey(block) || HashMaps.coalOres.get(block) < 1)	{
							HashMaps.coalOres.put(block, 1);
							if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
								Bukkit.getServer().getLogger().info("[Resourceful] " + block.getType().toString() + " at X="
										+ block.getLocation().getBlockX() + ", Z="
										+ block.getLocation().getBlockZ() + ", Y="
										+ block.getLocation().getBlockY() + " broken, stage = 1");
								if (randNum <= Resourceful.config.getInt("Ores.Coal Ore.Drop 1.Chance"))	{
									String drop = Resourceful.config.getString("Ores.Coal Ore.Drop 1.Type");
									block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Coal Ore.Drop 1.Count")));
									if (Resourceful.config.getBoolean("Ores.Coal Ore.Drop 1.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Coal Ore.Drop 1.Alert Message"));
									}
								}
								else if (randNum > Resourceful.config.getInt("Ores.Coal Ore.Drop 1.Chance")
										&& randNum <= Resourceful.config.getInt("Ores.Coal Ore.Drop 2.Chance"))	{
									//String drop = Resourceful.config.getString("Ores.Coal Ore.Drop 2.Type");
									//block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Coal Ore.Drop 2.Count")));
			
									if (Resourceful.config.getBoolean("Ores.Coal Ore.Drop 2.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Coal Ore.Drop 2.Alert Message"));
									}
								}
								else if (randNum > Resourceful.config.getInt("Ores.Coal Ore.Drop 2.Chance")
										&& randNum <= Resourceful.config.getInt("Ores.Coal Ore.Drop 3.Chance"))	{
									String drop = Resourceful.config.getString("Ores.Coal Ore.Drop 3.Type");
									block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Coal Ore.Drop 3.Count")));
									if (Resourceful.config.getBoolean("Ores.Coal Ore.Drop 3.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Coal Ore.Drop 3.Alert Message"));
									}
								}
							}
							
						}
						else if (HashMaps.coalOres.containsKey(block))	{
							int value = HashMaps.coalOres.get(block);
							if (HashMaps.coalOres.get(block) < Resourceful.config.getInt("Ores.Coal Ore.Harvest Count") - 1)	{
								HashMaps.coalOres.put(block, value + 1);
								if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
									Bukkit.getServer().getLogger().info("[Resourceful] " + block.getType().toString() + " at X="
											+ block.getLocation().getBlockX() + ", Z="
											+ block.getLocation().getBlockZ() + ", Y="
											+ block.getLocation().getBlockY() + " broken, stage = " + (value + 1));
									if (randNum <= Resourceful.config.getInt("Ores.Coal Ore.Drop 1.Chance"))	{
										String drop = Resourceful.config.getString("Ores.Coal Ore.Drop 1.Type");
										block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Coal Ore.Drop 1.Count")));
										if (Resourceful.config.getBoolean("Ores.Coal Ore.Drop 1.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Coal Ore.Drop 1.Alert Message"));
										}
									}
									else if (randNum > Resourceful.config.getInt("Ores.Coal Ore.Drop 1.Chance")
											&& randNum <= Resourceful.config.getInt("Ores.Coal Ore.Drop 2.Chance"))	{
										//String drop = Resourceful.config.getString("Ores.Coal Ore.Drop 2.Type");
										//block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Coal Ore.Drop 2.Count")));
				
										if (Resourceful.config.getBoolean("Ores.Coal Ore.Drop 2.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Coal Ore.Drop 2.Alert Message"));
										}
									}
									else if (randNum > Resourceful.config.getInt("Ores.Coal Ore.Drop 2.Chance")
											&& randNum <= Resourceful.config.getInt("Ores.Coal Ore.Drop 3.Chance"))	{
										String drop = Resourceful.config.getString("Ores.Coal Ore.Drop 3.Type");
										block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Coal Ore.Drop 3.Count")));
										if (Resourceful.config.getBoolean("Ores.Coal Ore.Drop 3.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Coal Ore.Drop 3.Alert Message"));
										}
									}
								}
								
							}
							else if (HashMaps.coalOres.get(block) >= Resourceful.config.getInt("Ores.Coal Ore.Harvest Count") - 1)	{
								block.setType(Material.AIR);
								if (Resourceful.config.getBoolean("Ores.Coal Ore.Alert Deplete") == true)	{
									player.sendMessage(LGREEN + "This " + YELLOW + "Coal Ore " + LGREEN + "has been depleted. Come back later.");
								}
								if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
									Bukkit.getServer().getLogger().info("[Resourceful] COAL_ORE at X=" + block.getLocation().getBlockX()
											+ ", Z=" + block.getLocation().getBlockZ()
											+ ", Y=" + block.getLocation().getBlockY()
											+ " refreshes in " + Resourceful.config.getLong("Ores.Coal Ore.Seconds to Respawn") + " seconds.");
								}
								Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()	{
									public void run()	{
										
										HashMaps.coalOres.remove(block);
										block.setType(Material.COAL_ORE);
										if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
											Bukkit.getServer().getLogger().info("[Resourceful] COAL_ORE at location X=" + block.getLocation().getBlockX()
										
												+ " Z=" + block.getLocation().getBlockZ()
												+ " Y=" + block.getLocation().getBlockY()
												+ " refreshed.");
										}
									}
								}, Resourceful.config.getLong("Ores.Coal Ore.Seconds to Respawn") * 20);
							}
						}
						
	
							}
						else	{
							event.setCancelled(true);
							player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + "You cannot harvest " + event.getBlock().getType() + " with " + tool + ".");
						}
					}
					
					//IRON ORE
					if (block.getType() == ironOre)	{
						if (tool.equals(wPick) || tool.equals(sPick) || tool.equals(iPick)
								|| tool.equals(gPick) || tool.equals(dPick))	{
						Random rand = new Random();
						int randNum = rand.nextInt(100) + 1;
						event.setCancelled(true);
						if (player.getItemInHand().getDurability() >=
								player.getItemInHand().getType().getMaxDurability())	{
							player.getInventory().setItemInHand(new ItemStack(Material.AIR));
						}
						else	{
							player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
						}
						//Handle breaking
						if (!HashMaps.ironOres.containsKey(block) || HashMaps.ironOres.get(block) < 1)	{
							HashMaps.ironOres.put(block, 1);
							if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
								Bukkit.getServer().getLogger().info("[Resourceful] " + block.getType().toString() + " at X="
										+ block.getLocation().getBlockX() + ", Z="
										+ block.getLocation().getBlockZ() + ", Y="
										+ block.getLocation().getBlockY() + " broken, stage = 1");
								if (randNum <= Resourceful.config.getInt("Ores.Iron Ore.Drop 1.Chance"))	{
									String drop = Resourceful.config.getString("Ores.Iron Ore.Drop 1.Type");
									block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Iron Ore.Drop 1.Count")));
									if (Resourceful.config.getBoolean("Ores.Iron Ore.Drop 1.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Iron Ore.Drop 1.Alert Message"));
									}
								}
								else if (randNum > Resourceful.config.getInt("Ores.Iron Ore.Drop 1.Chance")
										&& randNum <= Resourceful.config.getInt("Ores.Iron Ore.Drop 2.Chance"))	{
									//String drop = Resourceful.config.getString("Ores.Iron Ore.Drop 2.Type");
									//block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Iron Ore.Drop 2.Count")));
			
									if (Resourceful.config.getBoolean("Ores.Iron Ore.Drop 2.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Iron Ore.Drop 2.Alert Message"));
									}
								}
								else if (randNum > Resourceful.config.getInt("Ores.Iron Ore.Drop 2.Chance")
										&& randNum <= Resourceful.config.getInt("Ores.Iron Ore.Drop 3.Chance"))	{
									String drop = Resourceful.config.getString("Ores.Iron Ore.Drop 3.Type");
									block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Iron Ore.Drop 3.Count")));
									if (Resourceful.config.getBoolean("Ores.Iron Ore.Drop 3.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Iron Ore.Drop 3.Alert Message"));
									}
								}
							}
							
						}
						else if (HashMaps.ironOres.containsKey(block))	{
							int value = HashMaps.ironOres.get(block);
							if (HashMaps.ironOres.get(block) < Resourceful.config.getInt("Ores.Iron Ore.Harvest Count") - 1)	{
								HashMaps.ironOres.put(block, value + 1);
								if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
									Bukkit.getServer().getLogger().info("[Resourceful] " + block.getType().toString() + " at X="
											+ block.getLocation().getBlockX() + ", Z="
											+ block.getLocation().getBlockZ() + ", Y="
											+ block.getLocation().getBlockY() + " broken, stage = " + (value + 1));
									if (randNum <= Resourceful.config.getInt("Ores.Iron Ore.Drop 1.Chance"))	{
										String drop = Resourceful.config.getString("Ores.Iron Ore.Drop 1.Type");
										block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Iron Ore.Drop 1.Count")));
										if (Resourceful.config.getBoolean("Ores.Iron Ore.Drop 1.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Iron Ore.Drop 1.Alert Message"));
										}
									}
									else if (randNum > Resourceful.config.getInt("Ores.Iron Ore.Drop 1.Chance")
											&& randNum <= Resourceful.config.getInt("Ores.Iron Ore.Drop 2.Chance"))	{
										//String drop = Resourceful.config.getString("Ores.Iron Ore.Drop 2.Type");
										//block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Iron Ore.Drop 2.Count")));
				
										if (Resourceful.config.getBoolean("Ores.Iron Ore.Drop 2.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Iron Ore.Drop 2.Alert Message"));
										}
									}
									else if (randNum > Resourceful.config.getInt("Ores.Iron Ore.Drop 2.Chance")
											&& randNum <= Resourceful.config.getInt("Ores.Iron Ore.Drop 3.Chance"))	{
										String drop = Resourceful.config.getString("Ores.Iron Ore.Drop 3.Type");
										block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Iron Ore.Drop 3.Count")));
										if (Resourceful.config.getBoolean("Ores.Iron Ore.Drop 3.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Iron Ore.Drop 3.Alert Message"));
										}
									}
								}
								
							}
							else if (HashMaps.ironOres.get(block) >= Resourceful.config.getInt("Ores.Iron Ore.Harvest Count") - 1)	{
								block.setType(Material.AIR);
								if (Resourceful.config.getBoolean("Ores.Iron Ore.Alert Deplete") == true)	{
									player.sendMessage(LGREEN + "This " + YELLOW + "Iron Ore " + LGREEN + "has been depleted. Come back later.");
								}
								if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
									Bukkit.getServer().getLogger().info("[Resourceful] IRON_ORE at X=" + block.getLocation().getBlockX()
											+ ", Z=" + block.getLocation().getBlockZ()
											+ ", Y=" + block.getLocation().getBlockY()
											+ " refreshes in " + Resourceful.config.getLong("Ores.Iron Ore.Seconds to Respawn") + " seconds.");
								}
								Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()	{
									public void run()	{
										
										HashMaps.ironOres.remove(block);
										block.setType(Material.IRON_ORE);
										if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
											Bukkit.getServer().getLogger().info("[Resourceful] IRON_ORE at location X=" + block.getLocation().getBlockX()
										
												+ " Z=" + block.getLocation().getBlockZ()
												+ " Y=" + block.getLocation().getBlockY()
												+ " refreshed.");
										}
									}
								}, Resourceful.config.getLong("Ores.Iron Ore.Seconds to Respawn") * 20);
							}
						}
						
	
							}
						else	{
							event.setCancelled(true);
							player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + "You cannot harvest " + event.getBlock().getType() + " with " + tool + ".");
						}
						}
				
					//GOLD ORE
					if (block.getType() == goldOre)	{
						if (tool.equals(wPick) || tool.equals(sPick) || tool.equals(iPick)
								|| tool.equals(gPick) || tool.equals(dPick))	{
						Random rand = new Random();
						int randNum = rand.nextInt(100) + 1;
						event.setCancelled(true);
						if (player.getItemInHand().getDurability() >=
								player.getItemInHand().getType().getMaxDurability())	{
							player.getInventory().setItemInHand(new ItemStack(Material.AIR));
						}
						else	{
							player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
						}
						//Handle breaking
						if (!HashMaps.goldOres.containsKey(block) || HashMaps.goldOres.get(block) < 1)	{
							HashMaps.goldOres.put(block, 1);
							if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
								Bukkit.getServer().getLogger().info("[Resourceful] " + block.getType().toString() + " at X="
										+ block.getLocation().getBlockX() + ", Z="
										+ block.getLocation().getBlockZ() + ", Y="
										+ block.getLocation().getBlockY() + " broken, stage = 1");
								if (randNum <= Resourceful.config.getInt("Ores.Gold Ore.Drop 1.Chance"))	{
									String drop = Resourceful.config.getString("Ores.Gold Ore.Drop 1.Type");
									block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Gold Ore.Drop 1.Count")));
									if (Resourceful.config.getBoolean("Ores.Gold Ore.Drop 1.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Gold Ore.Drop 1.Alert Message"));
									}
								}
								else if (randNum > Resourceful.config.getInt("Ores.Gold Ore.Drop 1.Chance")
										&& randNum <= Resourceful.config.getInt("Ores.Gold Ore.Drop 2.Chance"))	{
									//String drop = Resourceful.config.getString("Ores.Gold Ore.Drop 2.Type");
									//block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Gold Ore.Drop 2.Count")));
			
									if (Resourceful.config.getBoolean("Ores.Gold Ore.Drop 2.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Gold Ore.Drop 2.Alert Message"));
									}
								}
								else if (randNum > Resourceful.config.getInt("Ores.Gold Ore.Drop 2.Chance")
										&& randNum <= Resourceful.config.getInt("Ores.Gold Ore.Drop 3.Chance"))	{
									String drop = Resourceful.config.getString("Ores.Gold Ore.Drop 3.Type");
									block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Gold Ore.Drop 3.Count")));
									if (Resourceful.config.getBoolean("Ores.Gold Ore.Drop 3.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Gold Ore.Drop 3.Alert Message"));
									}
								}
							}
							
						}
						else if (HashMaps.goldOres.containsKey(block))	{
							int value = HashMaps.goldOres.get(block);
							if (HashMaps.goldOres.get(block) < Resourceful.config.getInt("Ores.Gold Ore.Harvest Count") - 1)	{
								HashMaps.goldOres.put(block, value + 1);
								if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
									Bukkit.getServer().getLogger().info("[Resourceful] " + block.getType().toString() + " at X="
											+ block.getLocation().getBlockX() + ", Z="
											+ block.getLocation().getBlockZ() + ", Y="
											+ block.getLocation().getBlockY() + " broken, stage = " + (value + 1));
									if (randNum <= Resourceful.config.getInt("Ores.Gold Ore.Drop 1.Chance"))	{
										String drop = Resourceful.config.getString("Ores.Gold Ore.Drop 1.Type");
										block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Gold Ore.Drop 1.Count")));
										if (Resourceful.config.getBoolean("Ores.Gold Ore.Drop 1.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Gold Ore.Drop 1.Alert Message"));
										}
									}
									else if (randNum > Resourceful.config.getInt("Ores.Gold Ore.Drop 1.Chance")
											&& randNum <= Resourceful.config.getInt("Ores.Gold Ore.Drop 2.Chance"))	{
										//String drop = Resourceful.config.getString("Ores.Gold Ore.Drop 2.Type");
										//block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Gold Ore.Drop 2.Count")));
				
										if (Resourceful.config.getBoolean("Ores.Gold Ore.Drop 2.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Gold Ore.Drop 2.Alert Message"));
										}
									}
									else if (randNum > Resourceful.config.getInt("Ores.Gold Ore.Drop 2.Chance")
											&& randNum <= Resourceful.config.getInt("Ores.Gold Ore.Drop 3.Chance"))	{
										String drop = Resourceful.config.getString("Ores.Gold Ore.Drop 3.Type");
										block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Gold Ore.Drop 3.Count")));
										if (Resourceful.config.getBoolean("Ores.Gold Ore.Drop 3.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Gold Ore.Drop 3.Alert Message"));
										}
									}
								}
								
							}
							else if (HashMaps.goldOres.get(block) >= Resourceful.config.getInt("Ores.Gold Ore.Harvest Count") - 1)	{
								block.setType(Material.AIR);
								if (Resourceful.config.getBoolean("Ores.Gold Ore.Alert Deplete") == true)	{
									player.sendMessage(LGREEN + "This " + YELLOW + "Gold Ore " + LGREEN + "has been depleted. Come back later.");
								}
								if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
									Bukkit.getServer().getLogger().info("[Resourceful] GOLD_ORE at X=" + block.getLocation().getBlockX()
											+ ", Z=" + block.getLocation().getBlockZ()
											+ ", Y=" + block.getLocation().getBlockY()
											+ " refreshes in " + Resourceful.config.getLong("Ores.Gold Ore.Seconds to Respawn") + " seconds.");
								}
								Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()	{
									public void run()	{
										
										HashMaps.goldOres.remove(block);
										block.setType(Material.GOLD_ORE);
										if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
											Bukkit.getServer().getLogger().info("[Resourceful] GOLD_ORE at location X=" + block.getLocation().getBlockX()
										
												+ " Z=" + block.getLocation().getBlockZ()
												+ " Y=" + block.getLocation().getBlockY()
												+ " refreshed.");
										}
									}
								}, Resourceful.config.getLong("Ores.Gold Ore.Seconds to Respawn") * 20);
							}
						}
						
	
							}
						else	{
							event.setCancelled(true);
							player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + "You cannot harvest " + event.getBlock().getType() + " with " + tool + ".");
						}
						}
						
					//DIAMOND ORE
					if (block.getType() == diamondOre)	{
						if (tool.equals(wPick) || tool.equals(sPick) || tool.equals(iPick)
								|| tool.equals(gPick) || tool.equals(dPick))	{
						Random rand = new Random();
						int randNum = rand.nextInt(100) + 1;
						event.setCancelled(true);
						if (player.getItemInHand().getDurability() >=
								player.getItemInHand().getType().getMaxDurability())	{
							player.getInventory().setItemInHand(new ItemStack(Material.AIR));
						}
						else	{
							player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
						}
						//Handle breaking
						if (!HashMaps.diamondOres.containsKey(block) || HashMaps.diamondOres.get(block) < 1)	{
							HashMaps.diamondOres.put(block, 1);
							if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
								Bukkit.getServer().getLogger().info("[Resourceful] " + block.getType().toString() + " at X="
										+ block.getLocation().getBlockX() + ", Z="
										+ block.getLocation().getBlockZ() + ", Y="
										+ block.getLocation().getBlockY() + " broken, stage = 1");
								if (randNum <= Resourceful.config.getInt("Ores.Diamond Ore.Drop 1.Chance"))	{
									String drop = Resourceful.config.getString("Ores.Diamond Ore.Drop 1.Type");
									block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Diamond Ore.Drop 1.Count")));
									if (Resourceful.config.getBoolean("Ores.Diamond Ore.Drop 1.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Diamond Ore.Drop 1.Alert Message"));
									}
								}
								else if (randNum > Resourceful.config.getInt("Ores.Diamond Ore.Drop 1.Chance")
										&& randNum <= Resourceful.config.getInt("Ores.Diamond Ore.Drop 2.Chance"))	{
									//String drop = Resourceful.config.getString("Ores.Diamond Ore.Drop 2.Type");
									//block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Diamond Ore.Drop 2.Count")));
			
									if (Resourceful.config.getBoolean("Ores.Diamond Ore.Drop 2.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Diamond Ore.Drop 2.Alert Message"));
									}
								}
								else if (randNum > Resourceful.config.getInt("Ores.Diamond Ore.Drop 2.Chance")
										&& randNum <= Resourceful.config.getInt("Ores.Diamond Ore.Drop 3.Chance"))	{
									String drop = Resourceful.config.getString("Ores.Diamond Ore.Drop 3.Type");
									block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Diamond Ore.Drop 3.Count")));
									if (Resourceful.config.getBoolean("Ores.Diamond Ore.Drop 3.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Diamond Ore.Drop 3.Alert Message"));
									}
								}
							}
							
						}
						else if (HashMaps.diamondOres.containsKey(block))	{
							int value = HashMaps.diamondOres.get(block);
							if (HashMaps.diamondOres.get(block) < Resourceful.config.getInt("Ores.Diamond Ore.Harvest Count") - 1)	{
								HashMaps.diamondOres.put(block, value + 1);
								if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
									Bukkit.getServer().getLogger().info("[Resourceful] " + block.getType().toString() + " at X="
											+ block.getLocation().getBlockX() + ", Z="
											+ block.getLocation().getBlockZ() + ", Y="
											+ block.getLocation().getBlockY() + " broken, stage = " + (value + 1));
									if (randNum <= Resourceful.config.getInt("Ores.Diamond Ore.Drop 1.Chance"))	{
										String drop = Resourceful.config.getString("Ores.Diamond Ore.Drop 1.Type");
										block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Diamond Ore.Drop 1.Count")));
										if (Resourceful.config.getBoolean("Ores.Diamond Ore.Drop 1.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Diamond Ore.Drop 1.Alert Message"));
										}
									}
									else if (randNum > Resourceful.config.getInt("Ores.Diamond Ore.Drop 1.Chance")
											&& randNum <= Resourceful.config.getInt("Ores.Diamond Ore.Drop 2.Chance"))	{
										//String drop = Resourceful.config.getString("Ores.Diamond Ore.Drop 2.Type");
										//block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Diamond Ore.Drop 2.Count")));
				
										if (Resourceful.config.getBoolean("Ores.Diamond Ore.Drop 2.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Diamond Ore.Drop 2.Alert Message"));
										}
									}
									else if (randNum > Resourceful.config.getInt("Ores.Diamond Ore.Drop 2.Chance")
											&& randNum <= Resourceful.config.getInt("Ores.Diamond Ore.Drop 3.Chance"))	{
										String drop = Resourceful.config.getString("Ores.Diamond Ore.Drop 3.Type");
										block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Diamond Ore.Drop 3.Count")));
										if (Resourceful.config.getBoolean("Ores.Diamond Ore.Drop 3.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Diamond Ore.Drop 3.Alert Message"));
										}
									}
								}
								
							}
							else if (HashMaps.diamondOres.get(block) >= Resourceful.config.getInt("Ores.Diamond Ore.Harvest Count") - 1)	{
								block.setType(Material.AIR);
								if (Resourceful.config.getBoolean("Ores.Diamond Ore.Alert Deplete") == true)	{
									player.sendMessage(LGREEN + "This " + YELLOW + "Diamond Ore " + LGREEN + "has been depleted. Come back later.");
								}
								if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
									Bukkit.getServer().getLogger().info("[Resourceful] DIAMOND_ORE at X=" + block.getLocation().getBlockX()
											+ ", Z=" + block.getLocation().getBlockZ()
											+ ", Y=" + block.getLocation().getBlockY()
											+ " refreshes in " + Resourceful.config.getLong("Ores.Diamond Ore.Seconds to Respawn") + " seconds.");
								}
								Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()	{
									public void run()	{
										
										HashMaps.diamondOres.remove(block);
										block.setType(Material.DIAMOND_ORE);
										if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
											Bukkit.getServer().getLogger().info("[Resourceful] DIAMOND_ORE at location X=" + block.getLocation().getBlockX()
										
												+ " Z=" + block.getLocation().getBlockZ()
												+ " Y=" + block.getLocation().getBlockY()
												+ " refreshed.");
										}
									}
								}, Resourceful.config.getLong("Ores.Diamond Ore.Seconds to Respawn") * 20);
							}
						}
						
	
							}
						else	{
							event.setCancelled(true);
							player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + "You cannot harvest " + event.getBlock().getType() + " with " + tool + ".");
						}
						}
						
					//EMERALD ORE
					if (block.getType().equals(emeraldOre))	{
						if (tool.equals(wPick) || tool.equals(sPick) || tool.equals(iPick)
								|| tool.equals(gPick) || tool.equals(dPick))	{
						Random rand = new Random();
						int randNum = rand.nextInt(100) + 1;
						event.setCancelled(true);
						if (player.getItemInHand().getDurability() >=
								player.getItemInHand().getType().getMaxDurability())	{
							player.getInventory().setItemInHand(new ItemStack(Material.AIR));
						}
						else	{
							player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
						}
						//Handle breaking
						if (!HashMaps.emeraldOres.containsKey(block) || HashMaps.emeraldOres.get(block) < 1)	{
							HashMaps.emeraldOres.put(block, 1);
							if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
								Bukkit.getServer().getLogger().info("[Resourceful] " + block.getType().toString() + " at X="
										+ block.getLocation().getBlockX() + ", Z="
										+ block.getLocation().getBlockZ() + ", Y="
										+ block.getLocation().getBlockY() + " broken, stage = 1");
								if (randNum <= Resourceful.config.getInt("Ores.Emerald Ore.Drop 1.Chance"))	{
									String drop = Resourceful.config.getString("Ores.Emerald Ore.Drop 1.Type");
									block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Emerald Ore.Drop 1.Count")));
									if (Resourceful.config.getBoolean("Ores.Emerald Ore.Drop 1.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Emerald Ore.Drop 1.Alert Message"));
									}
								}
								else if (randNum > Resourceful.config.getInt("Ores.Emerald Ore.Drop 1.Chance")
										&& randNum <= Resourceful.config.getInt("Ores.Emerald Ore.Drop 2.Chance"))	{
									//String drop = Resourceful.config.getString("Ores.Emerald Ore.Drop 2.Type");
									//block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Emerald Ore.Drop 2.Count")));
			
									if (Resourceful.config.getBoolean("Ores.Emerald Ore.Drop 2.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Emerald Ore.Drop 2.Alert Message"));
									}
								}
								else if (randNum > Resourceful.config.getInt("Ores.Emerald Ore.Drop 2.Chance")
										&& randNum <= Resourceful.config.getInt("Ores.Emerald Ore.Drop 3.Chance"))	{
									String drop = Resourceful.config.getString("Ores.Emerald Ore.Drop 3.Type");
									block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Emerald Ore.Drop 3.Count")));
									if (Resourceful.config.getBoolean("Ores.Emerald Ore.Drop 3.Alert Finds") == true)	{
										player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Emerald Ore.Drop 3.Alert Message"));
									}
								}
							}
							
						}
						else if (HashMaps.emeraldOres.containsKey(block))	{
							int value = HashMaps.emeraldOres.get(block);
							if (HashMaps.emeraldOres.get(block) < Resourceful.config.getInt("Ores.Emerald Ore.Harvest Count") - 1)	{
								HashMaps.emeraldOres.put(block, value + 1);
								if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
									Bukkit.getServer().getLogger().info("[Resourceful] " + block.getType().toString() + " at X="
											+ block.getLocation().getBlockX() + ", Z="
											+ block.getLocation().getBlockZ() + ", Y="
											+ block.getLocation().getBlockY() + " broken, stage = " + (value + 1));
									if (randNum <= Resourceful.config.getInt("Ores.Emerald Ore.Drop 1.Chance"))	{
										String drop = Resourceful.config.getString("Ores.Emerald Ore.Drop 1.Type");
										block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Emerald Ore.Drop 1.Count")));
										if (Resourceful.config.getBoolean("Ores.Emerald Ore.Drop 1.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Emerald Ore.Drop 1.Alert Message"));
										}
									}
									else if (randNum > Resourceful.config.getInt("Ores.Emerald Ore.Drop 1.Chance")
											&& randNum <= Resourceful.config.getInt("Ores.Emerald Ore.Drop 2.Chance"))	{
										//String drop = Resourceful.config.getString("Ores.Emerald Ore.Drop 2.Type");
										//block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Emerald Ore.Drop 2.Count")));
				
										if (Resourceful.config.getBoolean("Ores.Emerald Ore.Drop 2.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Emerald Ore.Drop 2.Alert Message"));
										}
									}
									else if (randNum > Resourceful.config.getInt("Ores.Emerald Ore.Drop 2.Chance")
											&& randNum <= Resourceful.config.getInt("Ores.Emerald Ore.Drop 3.Chance"))	{
										String drop = Resourceful.config.getString("Ores.Emerald Ore.Drop 3.Type");
										block.getLocation().getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Ores.Emerald Ore.Drop 3.Count")));
										if (Resourceful.config.getBoolean("Ores.Emerald Ore.Drop 3.Alert Finds") == true)	{
											player.sendMessage(LGREEN + Resourceful.config.getString("Ores.Emerald Ore.Drop 3.Alert Message"));
										}
									}
								}
								
							}
							else if (HashMaps.emeraldOres.get(block) >= Resourceful.config.getInt("Ores.Emerald Ore.Harvest Count") - 1)	{
								block.setType(Material.AIR);
								if (Resourceful.config.getBoolean("Ores.Emerald Ore.Alert Deplete") == true)	{
									player.sendMessage(LGREEN + "This " + YELLOW + "Emerald Ore " + LGREEN + "has been depleted. Come back later.");
								}
								if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
									Bukkit.getServer().getLogger().info("[Resourceful] EMERALD_ORE at X=" + block.getLocation().getBlockX()
											+ ", Z=" + block.getLocation().getBlockZ()
											+ ", Y=" + block.getLocation().getBlockY()
											+ " refreshes in " + Resourceful.config.getLong("Ores.Emerald Ore.Seconds to Respawn") + " seconds.");
								}
								Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()	{
									public void run()	{
										
										HashMaps.emeraldOres.remove(block);
										block.setType(Material.EMERALD_ORE);
										if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
											Bukkit.getServer().getLogger().info("[Resourceful] EMERALD_ORE at location X=" + block.getLocation().getBlockX()
										
												+ " Z=" + block.getLocation().getBlockZ()
												+ " Y=" + block.getLocation().getBlockY()
												+ " refreshed.");
										}
									}
								}, Resourceful.config.getLong("Ores.Emerald Ore.Seconds to Respawn") * 20);
							}
						}
						
	
							}
						else	{
							event.setCancelled(true);
							player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + "You cannot harvest " + event.getBlock().getType() + " with " + tool + ".");
						}
						}
					}
				}

			//Vegetation
			/*if (Resourceful.config.getBoolean("Vegetation.Enable Harvest Mode") == true)	{
				if (b.getTypeId() == tallGrass || b.getTypeId() == deadBush || b.getTypeId() == rose
						|| b.getTypeId() == flower)	{
					tool = player.getItemInHand().getType();
					if (tool == wHoe || tool == sHoe || tool == iHoe || tool == gHoe || tool == dHoe)	{
						int bID = b.getTypeId();
						
						if (!HashMaps.vegetation.containsKey(b))	{
							HashMaps.vegetation.put(b, 1);
							event.setCancelled(true);
							Bukkit.getServer().broadcastMessage(b.getType().toString() + ": " + HashMaps.vegetation.get(b));
							if (bID == tallGrass)	{
								
								if (chance <= Resourceful.config.getInt("Vegetation.Long Grass.Drop 1.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Long Grass.Drop 1.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Long Grass.Drop 1.Count")));
								}
								else if (chance > Resourceful.config.getInt("Vegetation.Long Grass.Drop 1.Chance")
										&& chance <= Resourceful.config.getInt("Vegetation.Long Grass.Drop 2.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Long Grass.Drop 2.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Long Grass.Drop 2.Count")));
								}
								else if (chance > Resourceful.config.getInt("Vegetation.Long Grass.Drop 2.Chance")
										&& chance <= Resourceful.config.getInt("Vegetation.Long Grass.Drop 3.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Long Grass.Drop 3.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Long Grass.Drop 3.Count")));
								}
								
							}
							else if (bID == deadBush)	{
								
								if (chance <= Resourceful.config.getInt("Vegetation.Dead Bush.Drop 1.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Dead Bush.Drop 1.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Dead Bush.Drop 1.Count")));
								}
								else if (chance > Resourceful.config.getInt("Vegetation.Dead Bush.Drop 1.Chance")
										&& chance <= Resourceful.config.getInt("Vegetation.Dead Bush.Drop 2.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Dead Bush.Drop 2.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Dead Bush.Drop 2.Count")));
								}
								else if (chance > Resourceful.config.getInt("Vegetation.Dead Bush.Drop 2.Chance")
										&& chance <= Resourceful.config.getInt("Vegetation.Dead Bush.Drop 3.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Dead Bush.Drop 3.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Dead Bush.Drop 3.Count")));
								}
							}
							else if (bID == rose)	{
								
								if (chance <= Resourceful.config.getInt("Vegetation.Rose.Drop 1.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Rose.Drop 1.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Rose.Drop 1.Count")));
								}
								else if (chance > Resourceful.config.getInt("Vegetation.Rose.Drop 1.Chance")
										&& chance <= Resourceful.config.getInt("Vegetation.Rose.Drop 2.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Rose.Drop 2.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Rose.Drop 2.Count")));
								}
								else if (chance > Resourceful.config.getInt("Vegetation.Rose.Drop 2.Chance")
										&& chance <= Resourceful.config.getInt("Vegetation.Rose.Drop 3.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Rose.Drop 3.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Rose.Drop 3.Count")));
								}
							}
							else if (bID == flower)	{
								
								if (chance <= Resourceful.config.getInt("Vegetation.Flower.Drop 1.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Flower.Drop 1.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Flower.Drop 1.Count")));
								}
								else if (chance > Resourceful.config.getInt("Vegetation.Flower.Drop 1.Chance")
										&& chance <= Resourceful.config.getInt("Vegetation.Flower.Drop 2.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Flower.Drop 2.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Flower.Drop 2.Count")));
								}
								else if (chance > Resourceful.config.getInt("Vegetation.Flower.Drop 2.Chance")
										&& chance <= Resourceful.config.getInt("Vegetation.Flower.Drop 3.Chance"))	{
									String drop = Resourceful.config.getString("Vegetation.Flower.Drop 3.Type");
									b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Flower.Drop 3.Count")));
								}
							}
						}
						else if (HashMaps.vegetation.containsKey(b))	{
							int value = HashMaps.vegetation.get(b);
							HashMaps.vegetation.put(b, value + 1);
							Bukkit.getServer().broadcastMessage(b.getType().toString() + ": " + HashMaps.vegetation.get(b));
							if (bID == tallGrass)	{
								if (HashMaps.vegetation.get(b) < Resourceful.config.getInt("Vegetation.Long Grass.Harvest Count"))	{
									if (chance <= Resourceful.config.getInt("Vegetation.Long Grass.Drop 1.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Long Grass.Drop 1.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Long Grass.Drop 1.Count")));
									}
									else if (chance > Resourceful.config.getInt("Vegetation.Long Grass.Drop 1.Chance")
											&& chance <= Resourceful.config.getInt("Vegetation.Long Grass.Drop 2.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Long Grass.Drop 2.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Long Grass.Drop 2.Count")));
									}
									else if (chance > Resourceful.config.getInt("Vegetation.Long Grass.Drop 2.Chance")
											&& chance <= Resourceful.config.getInt("Vegetation.Long Grass.Drop 3.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Long Grass.Drop 3.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Long Grass.Drop 3.Count")));
									}
								}
								else if (HashMaps.vegetation.get(b) >= Resourceful.config.getInt("Vegetation.Tall Grass.Harvest Count") - 1)	{
									b.setType(Material.AIR);
									if (Resourceful.config.getBoolean("Vegetation.Tall Grass.Alert Deplete") == true)	{
										player.sendMessage(LGREEN + "This " + YELLOW + "Tall Grass " + LGREEN + "has been depleted. Come back later.");
									}
									if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
										Bukkit.getServer().getLogger().info("[Resourceful] LONG_GRASS at X=" + b.getLocation().getBlockX()
												+ ", Z=" + b.getLocation().getBlockZ()
												+ ", Y=" + b.getLocation().getBlockY()
												+ " refreshes in " + Resourceful.config.getLong("Vegetation.Tall Grass.Seconds to Respawn") + " seconds.");
									}
									Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()	{
										public void run()	{
											
											HashMaps.vegetation.remove(b);
											b.setType(Material.LONG_GRASS);
											if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
												Bukkit.getServer().getLogger().info("[Resourceful] LONG_GRASS at location X=" + b.getLocation().getBlockX()
											
													+ " Z=" + b.getLocation().getBlockZ()
													+ " Y=" + b.getLocation().getBlockY()
													+ " refreshed.");
											}
										}
									}, Resourceful.config.getLong("Vegetation.Tall Grass.Seconds to Respawn") * 20);
								}
								
							}
							else if (bID == deadBush)	{
								if (HashMaps.vegetation.get(b) < Resourceful.config.getInt("Vegetation.Dead Bush.Harvest Count"))	{
									if (chance <= Resourceful.config.getInt("Vegetation.Dead Bush.Drop 1.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Dead Bush.Drop 1.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Dead Bush.Drop 1.Count")));
									}
									else if (chance > Resourceful.config.getInt("Vegetation.Dead Bush.Drop 1.Chance")
											&& chance <= Resourceful.config.getInt("Vegetation.Dead Bush.Drop 2.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Dead Bush.Drop 2.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Dead Bush.Drop 2.Count")));
									}
									else if (chance > Resourceful.config.getInt("Vegetation.Dead Bush.Drop 2.Chance")
											&& chance <= Resourceful.config.getInt("Vegetation.Dead Bush.Drop 3.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Dead Bush.Drop 3.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Dead Bush.Drop 3.Count")));
									}
								}
								else if (HashMaps.vegetation.get(b) >= Resourceful.config.getInt("Vegetation.Dead Bush.Harvest Count") - 1)	{
									b.setType(Material.AIR);
									if (Resourceful.config.getBoolean("Vegetation.Dead Bush.Alert Deplete") == true)	{
										player.sendMessage(LGREEN + "This " + YELLOW + "Dead Bush " + LGREEN + "has been depleted. Come back later.");
									}
									if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
										Bukkit.getServer().getLogger().info("[Resourceful] DEAD_BUSH at X=" + b.getLocation().getBlockX()
												+ ", Z=" + b.getLocation().getBlockZ()
												+ ", Y=" + b.getLocation().getBlockY()
												+ " refreshes in " + Resourceful.config.getLong("Vegetation.Dead Bush.Seconds to Respawn") + " seconds.");
									}
									Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()	{
										public void run()	{
											
											HashMaps.vegetation.remove(b);
											b.setType(Material.DEAD_BUSH);
											if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
												Bukkit.getServer().getLogger().info("[Resourceful] DEAD_BUSH at location X=" + b.getLocation().getBlockX()
											
													+ " Z=" + b.getLocation().getBlockZ()
													+ " Y=" + b.getLocation().getBlockY()
													+ " refreshed.");
											}
										}
									}, Resourceful.config.getLong("Vegetation.Dead Bush.Seconds to Respawn") * 20);
								}
							}
							else if (bID == rose)	{
								if (HashMaps.vegetation.get(b) < Resourceful.config.getInt("Vegetation.Rose.Harvest Count"))	{
									if (chance <= Resourceful.config.getInt("Vegetation.Rose.Drop 1.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Rose.Drop 1.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Rose.Drop 1.Count")));
									}
									else if (chance > Resourceful.config.getInt("Vegetation.Rose.Drop 1.Chance")
											&& chance <= Resourceful.config.getInt("Vegetation.Rose.Drop 2.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Rose.Drop 2.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Rose.Drop 2.Count")));
									}
									else if (chance > Resourceful.config.getInt("Vegetation.Rose.Drop 2.Chance")
											&& chance <= Resourceful.config.getInt("Vegetation.Rose.Drop 3.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Rose.Drop 3.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Rose.Drop 3.Count")));
									}
								}
								else if (HashMaps.vegetation.get(b) >= Resourceful.config.getInt("Vegetation.Rose.Harvest Count") - 1)	{
									b.setType(Material.AIR);
									if (Resourceful.config.getBoolean("Vegetation.Rose.Alert Deplete") == true)	{
										player.sendMessage(LGREEN + "This " + YELLOW + "Rose " + LGREEN + "has been depleted. Come back later.");
									}
									if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
										Bukkit.getServer().getLogger().info("[Resourceful] RED_ROSE at X=" + b.getLocation().getBlockX()
												+ ", Z=" + b.getLocation().getBlockZ()
												+ ", Y=" + b.getLocation().getBlockY()
												+ " refreshes in " + Resourceful.config.getLong("Vegetation.Rose.Seconds to Respawn") + " seconds.");
									}
									Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()	{
										public void run()	{
											
											HashMaps.vegetation.remove(b);
											b.setType(Material.RED_ROSE);
											if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
												Bukkit.getServer().getLogger().info("[Resourceful] RED_ROSE at location X=" + b.getLocation().getBlockX()
											
													+ " Z=" + b.getLocation().getBlockZ()
													+ " Y=" + b.getLocation().getBlockY()
													+ " refreshed.");
											}
										}
									}, Resourceful.config.getLong("Vegetation.Rose.Seconds to Respawn") * 20);
								}
							}
							else if (bID == flower)	{
								if (HashMaps.vegetation.get(b) < Resourceful.config.getInt("Vegetation.Flower.Harvest Count"))	{
									if (chance <= Resourceful.config.getInt("Vegetation.Flower.Drop 1.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Flower.Drop 1.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Flower.Drop 1.Count")));
									}
									else if (chance > Resourceful.config.getInt("Vegetation.Flower.Drop 1.Chance")
											&& chance <= Resourceful.config.getInt("Vegetation.Flower.Drop 2.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Flower.Drop 2.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Flower.Drop 2.Count")));
									}
									else if (chance > Resourceful.config.getInt("Vegetation.Flower.Drop 2.Chance")
											&& chance <= Resourceful.config.getInt("Vegetation.Flower.Drop 3.Chance"))	{
										String drop = Resourceful.config.getString("Vegetation.Flower.Drop 3.Type");
										b.getLocation().getWorld().dropItemNaturally(b.getLocation(), new ItemStack(Material.getMaterial(drop), Resourceful.config.getInt("Vegetation.Flower.Drop 3.Count")));
									}
								}
								else if (HashMaps.vegetation.get(b) >= Resourceful.config.getInt("Vegetation.Flower.Harvest Count") - 1)	{
									b.setType(Material.AIR);
									if (Resourceful.config.getBoolean("Vegetation.Flower.Alert Deplete") == true)	{
										player.sendMessage(LGREEN + "This " + YELLOW + "Flower " + LGREEN + "has been depleted. Come back later.");
									}
									if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
										Bukkit.getServer().getLogger().info("[Resourceful] YELLOW_FLOWER at X=" + b.getLocation().getBlockX()
												+ ", Z=" + b.getLocation().getBlockZ()
												+ ", Y=" + b.getLocation().getBlockY()
												+ " refreshes in " + Resourceful.config.getLong("Vegetation.Flower.Seconds to Respawn") + " seconds.");
									}
									Bukkit.getScheduler().scheduleAsyncDelayedTask(plugin, new Runnable()	{
										public void run()	{
											
											HashMaps.vegetation.remove(b);
											b.setType(Material.YELLOW_FLOWER);
											if (Resourceful.config.getBoolean("Log Debug to Console") == true)	{
												Bukkit.getServer().getLogger().info("[Resourceful] YELLOW_FLOWER at location X=" + b.getLocation().getBlockX()
											
													+ " Z=" + b.getLocation().getBlockZ()
													+ " Y=" + b.getLocation().getBlockY()
													+ " refreshed.");
											}
										}
									}, Resourceful.config.getLong("Vegetation.Flower.Seconds to Respawn") * 20);
								}
							}
							
						}
					}
					else	{
						event.setCancelled(true);
						player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + "You cannot harvest " + event.getBlock().getType() + " with " + tool + ".");
					}
				}
			}*/
		}
		//End EventListener Stuff
		
		//Logout Listener
		@EventHandler
		public void logoutListener(PlayerQuitEvent event)	{
			String player = event.getPlayer().getName();
			if (HashMaps.resAdmin.containsKey(player))	{
				HashMaps.resAdmin.remove(player);
				Bukkit.getLogger().info(player + " logged out, removing from resAdmin.");
			}
		}
		
		//Interact Listener
		@EventHandler
		public void adminInteract(PlayerInteractEvent event)	{
			//Bukkit.getServer().broadcastMessage("Player: " + event.getPlayer().getName());
			Player player = event.getPlayer();
			//String playerName = player.getName();
			Block cb = (Block) event.getClickedBlock();
			Material coalOre = Material.COAL_ORE;
			Material ironOre = Material.IRON_ORE;
			Material goldOre = Material.GOLD_ORE;
			Material diamondOre = Material.DIAMOND_ORE;
			Material emeraldOre = Material.EMERALD_ORE;
			Material AIR = Material.AIR;
			if (HashMaps.resAdmin.containsKey(player.getName()))	{
				if (event.getAction() == Action.RIGHT_CLICK_BLOCK)	{
					if (cb.getType().equals(coalOre) ||
							cb.getType().equals(ironOre) ||
							cb.getType().equals(goldOre) ||
							cb.getType().equals(diamondOre) ||
							cb.getType().equals(emeraldOre))	{
						if (player.getItemInHand().getType().equals(AIR))	{
							cb.setType(AIR);
						}
						else if(!player.getItemInHand().equals(AIR))	{
							player.sendMessage(DGREEN + "[Resourceful] " + LGREEN + " You must use an empty hand for this.");
						}
						
					}
				}
				else if (event.getAction() == Action.LEFT_CLICK_BLOCK)	{
					if (player.getItemInHand().getType().equals(coalOre))	{
						cb.setType(coalOre);
					}
					else if (player.getItemInHand().getType().equals(ironOre))	{
						cb.setType(ironOre);
					}
					else if (player.getItemInHand().getType().equals(goldOre))	{
						cb.setType(goldOre);
					}
					else if (player.getItemInHand().getType().equals(diamondOre))	{
						cb.setType(diamondOre);
					}
					else if (player.getItemInHand().getType().equals(emeraldOre))	{
						cb.setType(emeraldOre);
					}

						
				}
					
			}
		}
		

	}
