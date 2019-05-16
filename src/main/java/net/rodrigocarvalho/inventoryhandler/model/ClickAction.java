package net.rodrigocarvalho.inventoryhandler.model;

import net.rodrigocarvalho.inventoryhandler.model.actions.ClickActionEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class ClickAction {

    private Inventory inventory;
    private final Map<Integer, Consumer<Player>> ITEMS = new HashMap<>();

    public ClickAction(String name, int slot) {
        CustomInventoryHolder holder = new CustomInventoryHolder(name, slot, this);
        this.inventory = holder.getInventory();
    }

    public void setItem(int slot, ItemStack item, Consumer<Player> function) {
        if (function != null) {
            ITEMS.put(slot, function);
        }
        inventory.setItem(slot, item);
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

    public void itemClick(int slot, Player player) {
        if (ITEMS.containsKey(slot)) {
            ITEMS.get(slot).accept(player);
        }
    }

    public abstract void call(ClickActionEvent event);
    public abstract void close(ActionEvent event);

}