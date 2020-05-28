package dev.foolen.wgportals;

import dev.foolen.wgportals.listeners.ListenersModules;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WGPortals extends JavaPlugin implements Listener {

    private static WGPortals instance;
    public Map<String, String> regions;

    @Override
    public void onEnable() {
        setInstance(this);

        // Load config
        this.createConfig();
        this.loadConfig();

        // Setup BungeeCord messaging channel
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        // Register listeners
        new ListenersModules();
    }

    public static WGPortals getInstance() {
        return instance;
    }

    public static void setInstance(WGPortals plugin) {
        instance = plugin;
    }

    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadConfig() {
        regions = new HashMap<>();

        ConfigurationSection cs = getConfig().getConfigurationSection("regions");
        if (cs == null) {
            System.out.println("[Warning] It seems like the config is missing the regions section.");
            return;
        }

        for (String region : cs.getKeys(false)) {
            String server = getConfig().getString("regions." + region);
            regions.put(region, server);
        }
    }
}
