package net.rodrigocarvalho.inventoryhandler.model.actions;

import net.rodrigocarvalho.inventoryhandler.model.ActionEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CloseActionEvent implements ActionEvent {

    private Inventory inventory;
    private Player player;

    public CloseActionEvent(Inventory inventory, Player player) {
        this.inventory = inventory;
        this.player = player;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}