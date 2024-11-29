package gg.kpjm.transientDevTools.inventory.item;

import gg.kpjm.transientDevTools.TransientDevTools;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ItemBuilder {
    private ItemMeta itemMeta;
    private ItemStack itemStack;

    public ItemBuilder(Material mat) {
        this.itemStack = new ItemStack(mat);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    public ItemBuilder setDisplayname(String s) {
        Component component = Component.text(s);

        this.itemMeta.displayName(component);
        return this;
    }

    public ItemBuilder setDisplayname(Component s) {
        this.itemMeta.displayName(s);
        return this;
    }

    @Deprecated
    public ItemBuilder setLocalizedName(String s) {
//        this.itemMeta.setLocalizedName(s);
        return this;
    }

    public ItemBuilder setCustomNBT(String nbtName, String v){
        itemStack.addItemFlags();
        return this;
    }

    public ItemBuilder setLore(String... s) {
        this.itemMeta.setLore(Arrays.asList(s));
        return this;
    }

    public ItemBuilder setUnbreakable(boolean s) {
        this.itemMeta.setUnbreakable(s);
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... s) {
        this.itemMeta.addItemFlags(s);
        return this;
    }

    public ItemBuilder setCustomModelData(int data) {
        this.itemMeta.setCustomModelData(data);
        return this;
    }

    public ItemBuilder setMenuID(String id){
        NamespacedKey key = new NamespacedKey("transient", "menuID");

        PersistentDataContainer dataContainer = itemMeta.getPersistentDataContainer();

        dataContainer.set(key, PersistentDataType.STRING, id);

        if (id.contains("back") && itemStack.getType().equals(Material.NAME_TAG)){
            setCustomModelData(10031);
        }

        return this;
    }

    public ItemBuilder setCustomComponent(String content, String key){
        NamespacedKey namespacedKey = new NamespacedKey("transient", key);

        PersistentDataContainer dataContainer = itemMeta.getPersistentDataContainer();

        dataContainer.set(namespacedKey, PersistentDataType.STRING, content);

        return this;
    }

    public ItemBuilder setItemMeta(ItemMeta meta){
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        this.itemMeta.addEnchant(enchantment, level, true);
        return this;
    }

    public String toString() {
        return "ItemBuilder{itemMeta=" + this.itemMeta + ", itemStack=" + this.itemStack + '}';
    }

    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }
}