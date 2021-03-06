package com.pauldavdesign.mineauz.minigames.commands.set;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.pauldavdesign.mineauz.minigames.Minigame;
import com.pauldavdesign.mineauz.minigames.commands.ICommand;

public class SetMaxRadiusCommand implements ICommand{

	@Override
	public String getName() {
		return "maxradius";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public boolean canBeConsole() {
		return true;
	}

	@Override
	public String getDescription() {
		return "Sets the maximum spawn radius for a treasure hunt Minigame in metres. (Default: 1000)";
	}

	@Override
	public String[] getParameters() {
		return null;
	}

	@Override
	public String[] getUsage() {
		return new String[] {"/minigame set <Minigame> maxradius <Number>"};
	}

	@Override
	public String getPermissionMessage() {
		return "You do not have permission to set the maximum spawn radius!";
	}

	@Override
	public String getPermission() {
		return "minigame.set.maxradius";
	}

	@Override
	public boolean onCommand(CommandSender sender, Minigame minigame,
			String label, String[] args) {
		if(args != null){
			if(args[0].matches("[0-9]+")){
				int max = Integer.parseInt(args[0]);
				minigame.setMaxRadius(max);
				sender.sendMessage(ChatColor.GRAY + "Maximum treasure spawn radius has been set to " + max + " for " + minigame.getName());
				return true;
			}
		}
		return false;
	}

}
