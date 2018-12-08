package xyz.shibomb.myfirstspigotplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class MyFirstSpigotPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info(this.getName() + "#onEnable()");

        // Plugin startup logic

        this.getCommand("hello").setExecutor(new CommandHello());
        this.getCommand("givemediamond").setExecutor(new CommandHello());
        this.getCommand("seeyou").setExecutor(new CommandSeeyou());
    }

    @Override
    public void onDisable() {
        getLogger().info(this.getName() + "#onDisable()");
        // Plugin shutdown logic
    }
}
