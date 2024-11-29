package gg.kpjm.transientDevTools;

import gg.kpjm.transientDevTools.inventory.InventorySize;
import org.bukkit.plugin.java.JavaPlugin;

public final class TransientDevTools extends JavaPlugin {

    private static JavaPlugin instance;

    @Override
    public void onEnable() {
        getLogger().info("TransientDevTools by Kolja Menzel");
        InventorySize inventorySize = new InventorySize();

        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JavaPlugin getInstance(){
        return instance;
    }
}
