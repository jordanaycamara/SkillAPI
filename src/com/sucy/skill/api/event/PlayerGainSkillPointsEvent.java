package com.sucy.skill.api.event;

import com.sucy.skill.api.enums.PointSource;
import com.sucy.skill.api.player.PlayerClass;
import com.sucy.skill.api.player.PlayerData;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event called when a player gains class experience
 */
public class PlayerGainSkillPointsEvent extends Event implements Cancellable
{
    private static final HandlerList handlers = new HandlerList();
    private PlayerClass playerClass;
    private boolean     cancelled;
    private PointSource source;
    private double      amount;

    /**
     * Constructor
     *
     * @param playerClass class of the player gaining skill points
     * @param amount      amount of skill points being gained
     * @param source      source of the points
     */
    public PlayerGainSkillPointsEvent(PlayerClass playerClass, double amount, PointSource source)
    {
        this.playerClass = playerClass;
        this.amount = amount;
        this.source = source;
        cancelled = false;
    }

    /**
     * @return data of the player gaining experience
     */
    public PlayerData getPlayerData()
    {
        return playerClass.getPlayerData();
    }

    /**
     * @return player's class that is receiving the experience
     */
    public PlayerClass getPlayerClass()
    {
        return playerClass;
    }

    /**
     * @return amount of experience being gained
     */
    public double getAmount()
    {
        return amount;
    }

    /**
     * @return where the experience came from
     */
    public PointSource getSource()
    {
        return source;
    }

    /**
     * Sets the amount of experience being gained
     *
     * @param amount new amount of experience
     *
     * @throws IllegalArgumentException if experience is less than 0
     */
    public void setAmount(int amount)
    {
        if (amount < 0)
        {
            throw new IllegalArgumentException("Points cannot be negative");
        }

        this.amount = amount;
    }

    /**
     * @return whether or not the gain in experience is cancelled
     */
    @Override
    public boolean isCancelled()
    {
        return cancelled;
    }

    /**
     * Sets whether or not the gain in experience is cancelled
     *
     * @param cancelled true/false
     */
    @Override
    public void setCancelled(boolean cancelled)
    {
        this.cancelled = cancelled;
    }

    /**
     * @return gets the handlers for the event
     */
    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }

    /**
     * @return gets the handlers for the event
     */
    public static HandlerList getHandlerList()
    {
        return handlers;
    }
}
