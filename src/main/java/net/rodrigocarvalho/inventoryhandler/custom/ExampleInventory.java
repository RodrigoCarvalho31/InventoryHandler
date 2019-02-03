package net.rodrigocarvalho.inventoryhandler.custom;

import net.rodrigocarvalho.inventoryhandler.model.ClickAction;
import net.rodrigocarvalho.inventoryhandler.model.ClickActionEvent;
import net.rodrigocarvalho.inventoryhandler.model.CustomInventoryHolder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ExampleInventory implements ClickAction {

    private Inventory inventory;

    public ExampleInventory() {
        CustomInventoryHolder holder = new CustomInventoryHolder("§aExample Inventory", 3, this);
        this.inventory = holder.getInventory();
    }

    @Override
    public void setItem(int slot, ItemStack item) {
        inventory.setItem(slot, item);
    }

    @Override
    public void call(ClickActionEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("§aFuck bro");
    }

    @Override
    public void close(ClickActionEvent event) {
        Player player = event.getPlayer();
        player.playSound(player.getLocation(), Sound.CHEST_CLOSE, 1.0F, 1.0F);
    }

    @Override
    public void open(Player player) {
        setItem(0, new ItemStack(Material.STONE));
        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1.0F, 1.0F);
    }
}
