package net.rodrigocarvalho.inventoryhandler.listener;

import net.rodrigocarvalho.inventoryhandler.model.ActionEvent;
import net.rodrigocarvalho.inventoryhandler.model.ClickAction;
import net.rodrigocarvalho.inventoryhandler.model.CustomInventoryHolder;
import net.rodrigocarvalho.inventoryhandler.model.actions.ClickActionEvent;
import net.rodrigocarvalho.inventoryhandler.model.actions.CloseActionEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {

    @EventHandler (ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = player.getOpenInventory().getTopInventory();
        if (inventory != null && inventory.getHolder() instanceof CustomInventoryHolder) {
            int slot = event.getRawSlot();
            ItemStack item = event.getCurrentItem();
            CustomInventoryHolder cih = (CustomInventoryHolder) inventory.getHolder();
            ClickAction clickAction = cih.getClickAction();
            ClickActionEvent actionEvent = new ClickActionEvent(inventory, player, event);
            if (item != null && item.getType() != Material.AIR) {
                clickAction.itemClick(slot, player);
            }
            clickAction.call(actionEvent);
        }
    }
}