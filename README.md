# WGPortals
Simple Bukkit transportation plugin that listens for WorldGuard enterRegionEvent and sends player to another server.

## Dependencies
- [WorldGuard](https://dev.bukkit.org/projects/worldguard)
- [WorldGuard Events](https://www.spigotmc.org/resources/worldguard-events.65176/)

## Getting Started
1. Download the latest release.
2. Copy the .jar to your server `plugins` folder alongside with the dependency plugins.
3. Restart/Reload your server.
4. Configure every region you want to link to a server inside `plugins/WGPortals/config.yml`.
5. Restart/Reload your server.
6. Jump in a region and enjoy! :tada:

## Configuration example
```
# Thank you for using this plugin.
# You can easily connect a WorldGuard region to a BungeeCord server using the following format.
#
# regions:
#   region_name: Servername
regions:
  survival_portal: Survival
  skyblock_portal: Skyblock
```

## Authors:
- [Tjeu Foolen](https://github.com/tjeufoolen)
