package dev.foolen.wgportals.listeners;

import dev.foolen.wgportals.WGPortals;
import org.bukkit.plugin.PluginManager;

public class ListenersModules {
    public ListenersModules() {
        WGPortals plugin = WGPortals.getInstance();
        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new OnRegionEnterListener(), plugin);
    }
}
