package com.minty.skylord.backpack.cmd;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Player;

import com.minty.skylord.backpack.core.SLBackpack;

public class BackpackCommand implements CommandExecutor {

	private final SLBackpack main = SLBackpack.getInstance();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
	{
		if(!sender.hasPermission("backpack.command.use"))
		{
			sender.sendMessage("§cErreur: Permissions insuffisantes !");
			return false;
		}
		
		if(args.length < 1)
		{
			sendHelp(sender);
			return false;
		}
		
		if(args[0].equalsIgnoreCase("create"))
		{
			if(args.length < 3) {
				sender.sendMessage("§cUtilisation : /backpack create <joueur> <lignes>");
				return false;
			}
			
			if(Bukkit.getPlayer(args[1]) == null)
			{
				sender.sendMessage("§cErreur: Impossible de trouver un joueur avec ce nom !");
				return false;
			}
			
			if(!NumberUtils.isNumber(args[2])) {
				sender.sendMessage("§cErreur: Ceci n'est pas un nombre correct !");
				return false;
			}
			
			Player target = Bukkit.getPlayer(args[1]);
			int lines = NumberUtils.toInt(args[2]);
			
			if(lines > 6) {
				sender.sendMessage("§cErreur: Lignes maximales : 6");
				return false;
			}
			
			main.getBackpackHandler().giveBackpack(target, lines);
			sender.sendMessage("§aVous avez bien donné un backpack de " + lines + " lignes à " + target.getName() + " !");
			return false;
		}
		
		sendHelp(sender);
		return false;
	}
	
	
	private void sendHelp(CommandSender sender)
	{
		sender.sendMessage("§6Utilisation des commandes :");
		sender.sendMessage("");
		sender.sendMessage("§8- §6/backpack create §e<joueur> <lignes> §7§oDonne un backpack à un joueur avec un certain nombre de lignes");
	}
	
}
