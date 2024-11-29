package gg.kpjm.transientDevTools.inventory.item;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ComponentGetter {

    public String getMenuID(ItemStack itemStack) {
        NamespacedKey key = new NamespacedKey("transient", "menuID");

        PersistentDataContainer dataContainer = itemStack.getItemMeta().getPersistentDataContainer();

        if (dataContainer.has(key, PersistentDataType.STRING)) {
            return dataContainer.get(key, PersistentDataType.STRING);
        }

        return "null";
    }
    public String getCustomComponent(ItemStack itemStack, String key) {
        NamespacedKey namespacedKey = new NamespacedKey("transient", key);

        PersistentDataContainer dataContainer = itemStack.getItemMeta().getPersistentDataContainer();

        if (dataContainer.has(namespacedKey, PersistentDataType.STRING)) {
            return dataContainer.get(namespacedKey, PersistentDataType.STRING);
        }

        return "null";
    }
}
