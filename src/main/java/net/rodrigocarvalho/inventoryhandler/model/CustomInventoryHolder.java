package net.rodrigocarvalho.inventoryhandler.model;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class CustomInventoryHolder implements InventoryHolder {

    private String name;
    private int rows;
    private ClickAction clickAction;

    public CustomInventoryHolder(String name, int rows, ClickAction action) {
        this.name = name;
        this.rows = rows;
        this.clickAction = action;
    }

    public ClickAction getClickAction() {
        return clickAction;
    }

    @Override
    public Inventory getInventory() {
        return Bukkit.createInventory(this, 9*rows, name);
    }
}