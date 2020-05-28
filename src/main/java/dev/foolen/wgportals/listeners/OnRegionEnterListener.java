package dev.foolen.wgportals.listeners;

import dev.foolen.wgportals.WGPortals;
import net.raidstone.wgevents.events.RegionEnteredEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class OnRegionEnterListener implements Listener {

    @EventHandler
    public void onRegionEntered(RegionEnteredEvent e) {
        Player player = Bukkit.getPlayer(e.getUUID());
        if (player == null) return;

        String regionName = e.getRegionName();

        player.sendMessage("ENTERED REGION"); //REMOVE
        if (WGPortals.getInstance().regions.containsKey(regionName)) {
            player.sendMessage("GOT IN IF"); //REMOVE
            sendToServer(player, WGPortals.getInstance().regions.get(regionName));
        }
        player.sendMessage("END"); //REMOVE
    }

    private void sendToServer(Player player, String server) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("Connect");
            dataOutputStream.writeUTF(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(WGPortals.getInstance(), "BungeeCord", byteArrayOutputStream.toByteArray());
        player.sendMessage(ChatColor.GREEN + "Connecting to server...");
    }
}
