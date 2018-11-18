package xyz.shibomb.myfirstspigotplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class CommandHello implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        System.out.println(sender);
        System.out.println(cmd);
        System.out.println(label);
        System.out.println(Arrays.deepToString(args));

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (label.compareToIgnoreCase("hello") == 0) {
                sender.sendMessage("Hello!! " + player.getDisplayName());
            }
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }

}
