package net.rodrigocarvalho.inventoryhandler;


import net.rodrigocarvalho.inventoryhandler.listener.InventoryClickListener;
import net.rodrigocarvalho.inventoryhandler.listener.InventoryCloseListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryHandler {

    private final Logger LOGGER = Bukkit.getLogger();

    public InventoryHandler(Plugin plugin) {
        register(plugin);
        LOGGER.log(Level.INFO, "Listering InventoryHandler on " + plugin.getName());
    }

    private void register(Plugin plugin) {
        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(new InventoryClickListener(), plugin);
        pm.registerEvents(new InventoryCloseListener(), plugin);
    }
}
