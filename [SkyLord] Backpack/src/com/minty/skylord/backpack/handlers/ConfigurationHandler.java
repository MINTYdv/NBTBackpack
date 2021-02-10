package com.minty.skylord.backpack.handlers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

import com.minty.skylord.backpack.core.SLBackpack;

public class ConfigurationHandler {

	private static SLBackpack main = SLBackpack.getInstance();
	
	public static Material getBPMaterial()
	{
		return Material.valueOf(main.getConfig().getString("item.material"));
	}
	
	public static String getBPName()
	{
		return main.getConfig().getString("item.name").replace("&", "§");
	}
	
	public static List<String> getBPLore()
	{
		List<String> lore = main.getConfig().getStringList("item.lore");
		List<String> result = new ArrayList<>();
		for(String string : lore) {
			result.add(string.replace("&", "§"));
		}
		return result;
	}
	
}
