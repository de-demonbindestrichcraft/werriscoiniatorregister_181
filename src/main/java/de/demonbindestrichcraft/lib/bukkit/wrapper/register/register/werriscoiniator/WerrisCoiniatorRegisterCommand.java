package de.demonbindestrichcraft.lib.bukkit.wrapper.register.register.werriscoiniator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WerrisCoiniatorRegisterCommand
        implements CommandExecutor {

    private final WerrisCoiniatorRegister plugin;
    public WerrisCoiniatorRegisterCommand(WerrisCoiniatorRegister plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {
        if (!(sender instanceof Player)) {
            return false;
        }
        
        Player player =  (Player) sender;
        
        player.sendMessage("WerrisCoiniatorRegister Wrapper created by Werri @demon-craft.de to Hook Vault and WerrisCoiniator!");
        
        return true;
    }
}
