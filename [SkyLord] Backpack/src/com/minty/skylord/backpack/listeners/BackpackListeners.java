package com.minty.skylord.backpack.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.minty.skylord.backpack.core.SLBackpack;
import com.minty.skylord.backpack.handlers.ConfigurationHandler;
import com.minty.skylord.backpack.nbt.ItemNBTCompound;
import com.minty.skylord.backpack.nbt.ItemSerializer;
import com.minty.skylord.backpack.nbt.NBTCompound;
import com.minty.skylord.backpack.nbt.NBTList;

public class BackpackListeners implements Listener {

	private Map<Player, List<Integer>> backpackSlots = new HashMap<>();
	
	@EventHandler
	public void onClick(InventoryClickEvent e)
	{
		Inventory inv = e.getInventory();
		ItemStack it = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();

		if(inv == null) return;
		
		if(inv.getName().equalsIgnoreCase(ConfigurationHandler.getBPName()))
		{
			if(e.getAction() == InventoryAction.HOTBAR_SWAP && backpackSlots.get(player).contains(e.getHotbarButton()))
			{
				e.setCancelled(true);
			}
			if(it != null && it.getType() == ConfigurationHandler.getBPMaterial() && it.hasItemMeta() && it.getItemMeta().hasLore() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ConfigurationHandler.getBPName()))
			{
				e.setCancelled(true);
			}
		}

	}
	
    @EventHandler
    public void onClose(InventoryCloseEvent e)
    {
    	Player player = (Player) e.getPlayer();
    	Inventory inv = e.getInventory();
    	
    	if(inv.getTitle().equalsIgnoreCase(ConfigurationHandler.getBPName()))
    	{
    		if(backpackSlots.containsKey(player))
    		{
    			backpackSlots.remove(player);
    			backpackSlots.put(player, new ArrayList<>());
    		}
    		
			if(player.getInventory().getItemInMainHand() == null) return;
			
		    ItemStack itemStack = player.getInventory().getItemInMainHand();
		    NBTCompound compound = SLBackpack.getInstance().getVersionImplementation().getNBTCompound(itemStack);
		    NBTList nbtList = SLBackpack.getInstance().getVersionImplementation().newNBTList();
		    for (int i = 0; i < inv.getSize(); i++) {
		        ItemStack inventoryStack = inv.getItem(i);
		        if (inventoryStack != null && inventoryStack.getType() != Material.AIR) {
		        NBTCompound entryCompound = SLBackpack.getInstance().getVersionImplementation().newNBTCompound();
		        entryCompound.setInt("slot", i);
		        NBTCompound itemCompound = SLBackpack.getInstance().getVersionImplementation().serializeItemNBTCompound(inventoryStack);
		        itemCompound.setString("data", ItemSerializer.serialize(inventoryStack));
		        entryCompound.setCompound("item", itemCompound);
		        nbtList.add(entryCompound);
		      }
		    } 
		  
		    if (nbtList.size() == 0) {
		      compound.remove("items");
		    } else {
		      compound.setList("items", nbtList);
		    } 
		    
		    ItemStack changed = ((ItemNBTCompound)compound).applyChanges();
		    player.getInventory().setItemInMainHand(changed);
    	}
    }
    
	@EventHandler
	public void onInteract(PlayerInteractEvent e)
	{
		Player player = e.getPlayer();
		ItemStack it = e.getItem();
		if(it == null) return;
		if(e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		
		if(it.getType() == ConfigurationHandler.getBPMaterial() && it.hasItemMeta() && it.getItemMeta().hasLore() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ConfigurationHandler.getBPName()))
		{
			if(it.getAmount() > 1) {
				player.sendMessage("§cVous devez destacker les sac à dos pour les ouvrir !");
				return;
			}
			
			if(backpackSlots.containsKey(player)) {
				backpackSlots.remove(player);
			}
			
			List<Integer> bplist = new ArrayList<>();
			for(int i = 0; i < player.getInventory().getContents().length; i++)
			{
				ItemStack itemStack = player.getInventory().getContents()[i];
				if(itemStack == null || itemStack.getType() == Material.AIR) continue;
				if(itemStack.getType() == ConfigurationHandler.getBPMaterial() && it.hasItemMeta() && it.getItemMeta().hasLore() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ConfigurationHandler.getBPName()))
				{
					bplist.add(i);
				}
			}
			backpackSlots.put(player, bplist);
			
			NBTCompound compound = SLBackpack.getInstance().getVersionImplementation().getNBTCompound(it);
			
			final int lines = compound.getInt("lines");

			Inventory inv = Bukkit.createInventory(null, lines * 9, ConfigurationHandler.getBPName());
			player.openInventory(inv);
			
			NBTCompound bpcompound = SLBackpack.getInstance().getVersionImplementation().getNBTCompound(it);
			
			NBTList list = bpcompound.getList("items");
			for(int i = 0; i < list.size(); i++)
			{
				NBTCompound itemCompound = list.get(i);
				int slot = itemCompound.getInt("slot");
				NBTCompound rawItem = itemCompound.getCompound("item");
				ItemNBTCompound itemNBTCompound = SLBackpack.getInstance().getVersionImplementation().newItemNBTCompound(rawItem);
				ItemStack newStack = itemNBTCompound.applyChanges();
				inv.setItem(slot, newStack);
			}
		}
	}
	
}
