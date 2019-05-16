package net.rodrigocarvalho.inventoryhandler;

import net.rodrigocarvalho.inventoryhandler.listener.InventoryClickListener;
import net.rodrigocarvalho.inventoryhandler.listener.InventoryCloseListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class InventoryHandler {

    public InventoryHandler(Plugin plugin) {
        init(plugin);
    }

    private void init(Plugin plugin) {
        InventoryClickListener inventoryClickListener = new InventoryClickListener();
        InventoryCloseListener inventoryCloseListener = new InventoryCloseListener();
        HandlerList.unregisterAll(inventoryClickListener);
        HandlerList.unregisterAll(inventoryCloseListener);
        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(inventoryClickListener, plugin);
        pm.registerEvents(inventoryCloseListener, plugin);
    }
}
