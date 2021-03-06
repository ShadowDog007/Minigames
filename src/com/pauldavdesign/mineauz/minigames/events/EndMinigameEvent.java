package com.pauldavdesign.mineauz.minigames.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.pauldavdesign.mineauz.minigames.Minigame;

public class EndMinigameEvent extends Event{
	private static final HandlerList handlers = new HandlerList();
	private Player player = null;
	private Minigame mgm = null;
	private boolean cancelled = false;
	
	public EndMinigameEvent(Player player, Minigame minigame){
		this.player = player;
		mgm = minigame;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public Player getPlayer() {
		return player;
	}

	public Minigame getMinigame() {
		return mgm;
	}

	public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
