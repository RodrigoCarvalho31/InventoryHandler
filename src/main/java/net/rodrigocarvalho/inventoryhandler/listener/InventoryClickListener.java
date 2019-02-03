package net.rodrigocarvalho.inventoryhandler.listener;

import net.rodrigocarvalho.inventoryhandler.model.ClickActionEvent;
import net.rodrigocarvalho.inventoryhandler.model.CustomInventoryHolder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = player.getOpenInventory().getTopInventory();
        if (inventory != null && inventory.getHolder() instanceof CustomInventoryHolder) {
            CustomInventoryHolder cih = (CustomInventoryHolder) inventory.getHolder();
            ClickActionEvent clickActionEvent = new ClickActionEvent(inventory, player, event);
            cih.getClickAction().call(clickActionEvent);
        }
    }
}
