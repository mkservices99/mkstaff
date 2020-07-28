package me.bukkit.mkservices.staffmode.Utils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;

public class tabComplete implements TabCompleter{
    
	 public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	        if (cmd.getName().equalsIgnoreCase("spawner")) {
	            if (args.length == 1) {
	                ArrayList<String> entityTypes = new ArrayList<String>();
	 
	                if (!args[0].equals("")) {
	                    for (EntityType type : EntityType.values()) {
	                        if (type.isAlive() && type.name().toLowerCase().startsWith(args[0].toLowerCase())) {
	                            entityTypes.add(type.name());
	                        }
	                    }
	                    
	                } else {
	                	
	                    for (EntityType type : EntityType.values()) {
	                        if (type.isAlive()) {
	                            entityTypes.add(type.name());
	                        }
	                    }
	                }
	 
	                Collections.sort(entityTypes);
	 
	                return entityTypes;
	            }
	        }
	        
	        
	 
	        return null;
	    }

	
	
	
}
