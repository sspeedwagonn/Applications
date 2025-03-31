package net.civicraft.applications;

import org.bukkit.plugin.java.JavaPlugin;

public final class Applications extends JavaPlugin {
    public static Applications instance;
    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic

    }

    public static Applications getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        instance = null;
        // Plugin shutdown logic
    }
}
