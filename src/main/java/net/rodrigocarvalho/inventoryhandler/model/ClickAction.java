/*
 * Copyright (c) Duck
 */

package net.rodrigocarvalho.inventoryhandler.model;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface ClickAction {

    void setItem(int slot, ItemStack item);
    void call(ClickActionEvent event);
    void close(ClickActionEvent event);
    void open(Player player);

}