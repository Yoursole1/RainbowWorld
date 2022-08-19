package me.yoursole.miniplugin;

import me.yoursole.miniplugin.event.ChunkLoad;
import org.bukkit.plugin.java.JavaPlugin;

public final class MiniPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ChunkLoad(), this);
    }

    @Override
    public void onDisable() {

    }
}
