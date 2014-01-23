package com.github.ar7ific1al.resourceful;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class HashMaps {
	public static Resourceful plugin;
	
	//Hashmaps
	//Test Map
	public final static HashMap<String, Integer> testMap = new HashMap<String, Integer>();
	//Admin Map
	public final static HashMap<String, String> resAdmin = new HashMap<String, String>();
	//Ores
	public final static HashMap<Block, Integer> ores = new HashMap<Block, Integer>();
	//Coal
	public final static HashMap<Block, Integer> coalOres = new HashMap<Block, Integer>();
	
	//Iron
	public final static HashMap<Block, Integer> ironOres = new HashMap<Block, Integer>();

	//Gold
	public final static HashMap<Block, Integer> goldOres = new HashMap<Block, Integer>();

	//Diamond
	public final static HashMap<Block, Integer> diamondOres = new HashMap<Block, Integer>();

	
	//Emerald
	public final static HashMap<Block, Integer> emeraldOres = new HashMap<Block, Integer>();

	//Lapis Lazuli
	
	
	//Redstone
	
	//Vegetation
	public final static HashMap<Block, Integer> vegetation = new HashMap<Block, Integer>();
	
	
	public static <T extends Object> void save(T obj,String path) throws Exception
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}
	public static <T extends Object> T load(String path) throws Exception
	{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		T result = (T)ois.readObject();
		ois.close();
		return result;
	}
	
	
}
