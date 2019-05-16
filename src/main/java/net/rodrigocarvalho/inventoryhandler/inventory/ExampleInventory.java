package net.rodrigocarvalho.inventoryhandler.inventory;

import net.rodrigocarvalho.inventoryhandler.model.ActionEvent;
import net.rodrigocarvalho.inventoryhandler.model.ClickAction;
import net.rodrigocarvalho.inventoryhandler.model.actions.ClickActionEvent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ExampleInventory extends ClickAction {

    public ExampleInventory() {
        super("Exemplo", 3);
        setItem(1, new ItemStack(Material.STONE), player -> player.sendMessage("§aExemplo de item!"));
    }

    @Override
    public void call(ClickActionEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void close(ActionEvent event) {
        event.getPlayer().sendMessage("§cVocê fechou o inventário!");
    }
}
