package me.bukkit.mkservices.staffmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import me.bukkit.mkservices.staffmode.Main;
import me.bukkit.mkservices.staffmode.Utils.U;

public class mod implements CommandExecutor, Listener{
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
    	
        for (Player p : Main.vanished) {
        	p.sendMessage("" + Main.vanished);
            e.getPlayer().hidePlayer(Main.getPlugin(), p);
        }
    }
	
	@EventHandler
    public void onPLayerLeave(PlayerQuitEvent e) {
        Main.vanished.remove(e.getPlayer());
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		Player p = (Player) sender;
		
		ItemStack cage = new ItemStack(Material.IRON_BARS); cage.setItemMeta(U.cage());
		ItemStack kb = new ItemStack(Material.STICK); kb.setItemMeta(U.kb());
		ItemStack freeze = new ItemStack(Material.ICE); freeze.setItemMeta(U.freeze());
		ItemStack randomtp = new ItemStack(Material.MAGMA_CREAM); randomtp.setItemMeta(U.randomtp());
		ItemStack invsee = new ItemStack(Material.ENDER_EYE); invsee.setItemMeta(U.invsee());
		
		if (cmd.getName().equalsIgnoreCase("mod") && sender instanceof Player && p.hasPermission("mkstaff.mod")) {
			
			if (args.length == 1) {
				String nick = args[0];
				Player tp = Bukkit.getServer().getPlayer(nick); 
				
				if (tp == null) {
					p.sendMessage(U.color("&6[MK-Staff] &9The player '&e" + args[0] + "&9' ins't avaible at this moment!"));
				} else {
					Location tpl = tp.getLocation();
					p.teleport(tpl);
				}
			}
			
				if (!Main.vanished.contains(p)) {
					for (Player online: Bukkit.getOnlinePlayers()) {
						online.hidePlayer(Main.getPlugin(), p);
					}
					
					p.getInventory().clear();
					p.sendMessage(U.color("&6[MK-Staff] &9You &aentered &9moderator mode!"));
					p.setGameMode(GameMode.CREATIVE);
					
					p.getInventory().addItem(kb);
					p.getInventory().addItem(cage);
					p.getInventory().addItem(freeze);
					p.getInventory().addItem(randomtp);
					p.getInventory().addItem(invsee);
					
					Main.vanished.add(p);
					return true;
				} else {
					for (Player online: Bukkit.getOnlinePlayers()) {
						online.showPlayer(Main.getPlugin(), p);
					}
					
					p.getInventory().clear();
					p.sendMessage(U.color("&6[MK-Staff] &9You &cexited &9moderator mode!"));
					
					Main.vanished.remove(p);
					return true;
				}
			}
		return true;
	}
	
}
