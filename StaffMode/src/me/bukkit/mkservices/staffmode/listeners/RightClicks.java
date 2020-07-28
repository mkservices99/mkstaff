package me.bukkit.mkservices.staffmode.listeners;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.scheduler.BukkitRunnable;
import me.bukkit.mkservices.staffmode.Main;
import me.bukkit.mkservices.staffmode.Utils.U;

public class RightClicks implements Listener{

	boolean freezed = false;
	
	
	@EventHandler
	public void onRightClickEntity (PlayerInteractEntityEvent e) {
		
		Player p = e.getPlayer();
		World w = p.getWorld();
		Entity target = e.getRightClicked();
		
		if (target instanceof Player && e.getHand().equals(EquipmentSlot.HAND)) {
			Player t = (Player) e.getRightClicked();
			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(U.color("&9Cage a player"))) {
				double x = t.getLocation().getBlockX();
				double y = t.getLocation().getBlockY();
				double z = t.getLocation().getBlockZ();
				Location loc  = new Location(w, x+0.5, y+15, z+0.5);
				Location locp  = new Location(w, x+3, y+15, z);
				Location loc1 = new Location(w, x, y+14, z);
				Location loc2 = new Location(w, x, y+15, z-1);
				Location loc3 = new Location(w, x+1, y+15, z);
				Location loc4 = new Location(w, x, y+15, z+1);
				Location loc5 = new Location(w, x-1, y+15, z);
				Location loc6 = new Location(w, x, y+17, z);
				
				loc1.getBlock().setType(Material.BEDROCK);
				loc2.getBlock().setType(Material.BEDROCK);
				loc3.getBlock().setType(Material.BEDROCK);
				loc4.getBlock().setType(Material.BEDROCK);
				loc5.getBlock().setType(Material.BEDROCK);
				loc6.getBlock().setType(Material.BEDROCK);
				
				t.teleport(loc);
				p.teleport(locp);
				p.sendMessage(U.color("&6[MK-Staff] &9You &asuceffuly &9jailed &6" + t.getName() + "&9!"));
				t.sendMessage(U.color("&6[&c!&6] &9You have been jailed by the staff &6" + p.getName() + "&9!"));
				t.sendMessage(U.color("&9You have 2 minutes to tell this staff your discord!"));
				
				new BukkitRunnable()
				{
					int timer = 0;	
				    @Override
				    public void run()
				    {
				    	timer++;
				    	if (timer == 300) {
				    		loc1.getBlock().setType(Material.AIR);
							loc2.getBlock().setType(Material.AIR);
							loc3.getBlock().setType(Material.AIR);
							loc4.getBlock().setType(Material.AIR);
							loc5.getBlock().setType(Material.AIR);
							loc6.getBlock().setType(Material.AIR);
		                    this.cancel();
		            	}
				    }
				}.runTaskTimer(Main.getPlugin(), 0, 20);
			}
			
			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(U.color("&3Freeze Player"))) {
				
				if (freezed == false) {
					p.sendMessage(U.color("&6[MK-Staff] &9You have &asuceffully &9frozen &6" + t.getName()));
					t.sendMessage(U.color("&6[&c!&6] &9You were frozen by &6" + p.getName()));
					freezed = true;
					
					new BukkitRunnable()
					{
					    @Override
					    public void run()
					    {
					    	if (freezed == true) {
					    		Location tl = t.getLocation();
					    		t.teleport(tl);
					    	} else {
					    		this.cancel();
					    	}
					    	
					    }
					}.runTaskTimer(Main.getPlugin(), 0, 1);
				} else {
					p.sendMessage(U.color("&6[MK-Staff] &9You have &asuceffully &9unfroze &6" + t.getName()));
					t.sendMessage(U.color("&6[&c!&6] &9You were unfrozen by &6" + p.getName()));
					freezed = false;
				}
			}
			
			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(U.color("&cOpen Inventory"))) {
				e.setCancelled(true);
				p.openInventory(t.getInventory());
				p.sendMessage(U.color("&6[MK-Staff] &9You are now spying &6" + t.getName() + " &9inventory!"));
			}
			
			if (p.getInventory().getItemInMainHand().getType().equals(Material.ENDER_EYE)) {
	        	e.setCancelled(true);
	        }
		}
		
		
	}
	 
	@EventHandler
	public void onRightClick (PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			
			if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(U.color("&5Random Teleport"))) {
				ArrayList<Player> players = new ArrayList<Player>();
				
				for (Player o : Bukkit.getOnlinePlayers()) {
					if (o == p) {
						
					} else {
						players.add(o);
					}
				}
				Player randomPlayer = players.get(new Random().nextInt(players.size()));
				p.teleport(randomPlayer.getLocation());
				p.sendMessage(U.color("&6[MK-Staff] &9Random teleporting to player &e" + randomPlayer.getName()));
			}
		}
		
		if (p.getInventory().getItemInMainHand().getType().equals(Material.ENDER_EYE)) {
        	e.setCancelled(true);
        }
		
	}
	

}
