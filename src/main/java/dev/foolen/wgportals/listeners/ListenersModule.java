package dev.foolen.wgportals.listeners;

import dev.foolen.wgportals.WGPortals;
import dev.foolen.wgportals.listeners.executors.OnRegionEnterListener;
import org.bukkit.plugin.PluginManager;

public class ListenersModule {
    public ListenersModule() {
        WGPortals plugin = WGPortals.getInstance();
        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new OnRegionEnterListener(), plugin);
    }
}
