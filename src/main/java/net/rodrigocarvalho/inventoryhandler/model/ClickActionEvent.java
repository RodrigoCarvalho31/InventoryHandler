/*
 * Copyright (c) Duck
 */

package net.rodrigocarvalho.inventoryhandler.model;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ClickActionEvent {

    private Inventory inventory;
    private Player player;
    private InventoryClickEvent clickEvent;
    private InventoryCloseEvent closeEvent;

    public ClickActionEvent(Inventory inventory, Player player, InventoryClickEvent clickEvent) {
        this.inventory = inventory;
        this.player = player;
        this.clickEvent = clickEvent;
    }

    public ClickActionEvent(Inventory inventory, Player player, InventoryCloseEvent closeEvent) {
        this.inventory = inventory;
        this.player = player;
        this.closeEvent = closeEvent;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public int getClickedSlot() {
        return clickEvent.getRawSlot();
    }

    public void setCancelled(boolean cancelled) {
        clickEvent.setCancelled(cancelled);
    }

    public boolean isCancelled() {
        return clickEvent.isCancelled();
    }

    public ItemStack getClickedItem() {
        return clickEvent.getCurrentItem();
    }

    public ClickType getClickType() {
        return clickEvent.getClick();
    }

    public InventoryAction getInventoryAction() {
        return clickEvent.getAction();
    }

    public InventoryClickEvent getInventoryEvent() {
        return clickEvent;
    }
}