package com.github.ar7ific1al.resourceful;

import jline.internal.Log.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLogoutListener implements Listener	{
	public Resourceful plugin;

	public PlayerLogoutListener(Resourceful instance)	{
		//Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
		plugin = instance;
	}
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
	
	
	
}
