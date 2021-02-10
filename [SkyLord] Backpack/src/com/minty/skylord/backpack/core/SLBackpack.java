package com.minty.skylord.backpack.core;

import org.bukkit.plugin.java.JavaPlugin;

import com.minty.skylord.backpack.cmd.BackpackCommand;
import com.minty.skylord.backpack.handlers.BackpackHandler;
import com.minty.skylord.backpack.listeners.BackpackListeners;
import com.minty.skylord.backpack.nbt.VersionHookImpl;

public class SLBackpack extends JavaPlugin {

	private static SLBackpack instance;
	
	private BackpackHandler backpackHandler;
	private VersionHookImpl versionImplementation;
	
	@Override
	public void onEnable()
	{
		System.out.println("[SLBackpack] Plugin actif !");
		
		saveDefaultConfig();
		instance = this;
		
		registerReferences();
		registerCommands();
		registerListeners();
	}

	private void registerListeners()
	{
		getServer().getPluginManager().registerEvents(new BackpackListeners(), this);
	}
	
	private void registerReferences()
	{
		backpackHandler = new BackpackHandler();
		versionImplementation = new VersionHookImpl();
	}
	
	private void registerCommands() 
	{
		getCommand("backpack").setExecutor(new BackpackCommand());
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("[SLBackpack] Plugin inactif !");
	}

	public BackpackHandler getBackpackHandler() {
		return backpackHandler;
	}

	public VersionHookImpl getVersionImplementation() {
		return versionImplementation;
	}
	
	public static SLBackpack getInstance() {
		return instance;
	}
	
}
