package net.rodrigocarvalho.inventoryhandler.model;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface ActionEvent {

    Inventory getInventory();
    Player getPlayer();

}