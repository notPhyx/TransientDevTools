package gg.kpjm.transientDevTools.inventory;

public class InventorySize {
    private static InventorySize build;

    public InventorySize(){
        build = this;
    }

    public static InventorySize CHEST(){
        return build;
    }
    public static InventorySize DOUBLE_CHEST(){
        return build;
    }
    public static InventorySize BARREL(){
        return build;
    }
}
