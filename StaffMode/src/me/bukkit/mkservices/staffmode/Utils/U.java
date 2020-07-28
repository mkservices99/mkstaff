package me.bukkit.mkservices.staffmode.Utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class U {
	
	public static String color(String s) {
		
		return s.replaceAll("&", "§");
	}
	
	public static ItemMeta cage() {
		ItemStack cage = new ItemStack(Material.IRON_BARS);
		ItemMeta cagem = cage.getItemMeta();
		cagem.setDisplayName(U.color("&9Cage a player"));
		cagem.addEnchant(Enchantment.KNOCKBACK, 1, true);
		ArrayList<String> cagel = new ArrayList<>();
		cagel.add(U.color("&7Right click in a player to cage him!"));
		cagem.setLore(cagel);
		
		return cagem;
	}
	
	public static ItemMeta kb() {
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(U.color("&6Anti-KB Stick"));
		itemm.addEnchant(Enchantment.KNOCKBACK, 10, true);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(U.color("&7Use this stick to test a player anti-kb!"));
		itemm.setLore(lore);
		
		return itemm;
	}
	
	public static ItemMeta freeze() {
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(U.color("&3Freeze Player"));
		itemm.addEnchant(Enchantment.KNOCKBACK, 1, true);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(U.color("&7Right click to freeze a player!"));
		itemm.setLore(lore);
		
		return itemm;
	}
	
	public static ItemMeta randomtp() {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(U.color("&5Random Teleport"));
		itemm.addEnchant(Enchantment.KNOCKBACK, 1, true);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(U.color("&7Right click to random teleport to a player that is not staff!"));
		itemm.setLore(lore);
		
		return itemm;
	}
	
	public static ItemMeta invsee() {
		ItemStack item = new ItemStack(Material.ENDER_EYE);
		ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName(U.color("&cOpen Inventory"));
		itemm.addEnchant(Enchantment.KNOCKBACK, 1, true);
		ArrayList<String> lore = new ArrayList<>();
		lore.add(U.color("&7Right click a player to watch is inventory!"));
		itemm.setLore(lore);
		
		return itemm;
	}
	
	public static ItemStack getItem(Player player) {
	    return player.getInventory().getItemInMainHand();
	}
}
