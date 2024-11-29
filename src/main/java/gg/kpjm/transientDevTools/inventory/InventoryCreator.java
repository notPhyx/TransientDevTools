package gg.kpjm.transientDevTools.inventory;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import javax.swing.text.html.parser.Entity;

public class InventoryCreator {

    public Inventory createInventory(InventorySize size, String title){
        return Bukkit.createInventory(null, getSize(size), title);
    }

    private int getSize(InventorySize inventorySize){
        if (inventorySize == InventorySize.CHEST()){
            return 9*3;
        } else if (inventorySize == InventorySize.DOUBLE_CHEST()) {
            return 9*6;
        } else if (inventorySize == InventorySize.BARREL()) {
            return 3*3;
        }
        return 5;
    }

}
