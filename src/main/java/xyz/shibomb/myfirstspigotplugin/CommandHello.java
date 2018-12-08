package xyz.shibomb.myfirstspigotplugin;

import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

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
            ItemStack items = player.getInventory().getItemInMainHand();
            int currentAmount = items.getAmount();
            if (currentAmount > 0) {
                items.setAmount(currentAmount);
            }


            if (label.compareToIgnoreCase("hello") == 0) {
                sender.sendMessage("Hello!! " + player.getDisplayName());
            }
            else if (label.compareToIgnoreCase("givemediamond") == 0) {
                PlayerInventory inventory = player.getInventory(); // プレイヤーのインベントリ
                ItemStack diamondstack = new ItemStack(Material.DIAMOND, 64); // 山積みのダイヤモンド！

                if (inventory.contains(diamondstack)) {
                    inventory.addItem(diamondstack); // プレイヤーインベントリに山積みのダイヤモンドを加える
                    player.sendMessage(ChatColor.GOLD + "よく来たな!もっとダイヤモンドをくれてやろう、このとんでもない成金め!!");
                }

                Location loc = player.getLocation();
                PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.CLOUD, true, 0, 0, 0, 1, 0, 0, 1, 10);
            }
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }

}
