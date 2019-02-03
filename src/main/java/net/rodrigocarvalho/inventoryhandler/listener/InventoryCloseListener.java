package net.rodrigocarvalho.inventoryhandler.listener;

import net.rodrigocarvalho.inventoryhandler.model.ClickActionEvent;
import net.rodrigocarvalho.inventoryhandler.model.CustomInventoryHolder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class InventoryCloseListener implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Inventory inventory = event.getInventory();
        if (inventory != null && inventory.getHolder() instanceof CustomInventoryHolder) {
            CustomInventoryHolder cih = (CustomInventoryHolder) inventory.getHolder();
            ClickActionEvent clickActionEvent = new ClickActionEvent(inventory, player, event);
            cih.getClickAction().close(clickActionEvent);
        }
    }
}
