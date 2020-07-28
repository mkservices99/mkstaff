package me.bukkit.mkservices.staffmode;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.bukkit.mkservices.staffmode.Utils.tabComplete;
import me.bukkit.mkservices.staffmode.commands.mod;
import me.bukkit.mkservices.staffmode.listeners.RightClicks;

public class Main  extends JavaPlugin {
	
	public static Plugin plugin;
	public static Plugin getPlugin(){return plugin;}
	
	public static ArrayList<Player> vanished = new ArrayList<Player>();
	
	public void onEnable() {
		plugin = this;
		ligarComandos();
		ligarListeners();
	}
	
	public void ligarComandos() {
		getCommand("mod").setTabCompleter(new tabComplete());
		getCommand("mod").setExecutor(new mod());
	}
	
	public void ligarListeners() {
		getServer().getPluginManager().registerEvents(new RightClicks(), this);
		getServer().getPluginManager().registerEvents(new mod(), this);
	}
	
	
}
