package net.rodrigocarvalho.inventoryhandler.model.actions;

import net.rodrigocarvalho.inventoryhandler.model.ActionEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ClickActionEvent implements ActionEvent {

    private Inventory inventory;
    private Player player;
    private InventoryClickEvent clickEvent;

    public ClickActionEvent(Inventory inventory, Player player, InventoryClickEvent clickEvent) {
        this.inventory = inventory;
        this.player = player;
        this.clickEvent = clickEvent;
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
        return clickEvent.getCurrentItem() ;
    }

    public ClickType getClickType() {
        return clickEvent.getClick();
    }

    public InventoryAction getInventoryAction() {
        return clickEvent.getAction();
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