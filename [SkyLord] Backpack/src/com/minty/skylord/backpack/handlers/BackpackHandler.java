package com.minty.skylord.backpack.handlers;

import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.minty.skylord.backpack.core.SLBackpack;

import net.minecraft.server.v1_12_R1.NBTTagCompound;

public class BackpackHandler {

	private SLBackpack main = SLBackpack.getInstance();
	
	public void giveBackpack(Player player, int lines)
	{
		ItemStack it = new ItemStack(ConfigurationHandler.getBPMaterial(), 1);
		ItemMeta meta = it.getItemMeta();
		
		meta.setDisplayName(ConfigurationHandler.getBPName());
		meta.setLore(ConfigurationHandler.getBPLore());
		
		it.setItemMeta(meta);
		
		net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(it);
		
		NBTTagCompound itemCompound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
		itemCompound.setInt("lines", lines);
		
		nmsItem.setTag(itemCompound);
		it = CraftItemStack.asBukkitCopy(nmsItem);
		player.getInventory().addItem(it); // Give le backpack au joueur
	}
	
}
