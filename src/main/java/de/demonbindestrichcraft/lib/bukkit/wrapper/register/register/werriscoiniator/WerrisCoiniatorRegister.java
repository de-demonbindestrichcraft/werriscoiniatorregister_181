package de.demonbindestrichcraft.lib.bukkit.wrapper.register.register.werriscoiniator;

import de.demonbindestrichcraft.lib.bukkit.wbukkitlib.pluginhooks.register.wrapper.register.myregister.werriscoiniator.WCR_MyRegister;
import de.demonbindestrichcraft.register.payment.werriscoiniator.WCR_Methods;
import de.fireearth.werri.werriscoiniator.WerrisCoiniator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class WerrisCoiniatorRegister extends JavaPlugin {

    PluginManager pluginManager;
    PluginDescriptionFile pdFile;
    WCR_MyRegister register = null;
    Logger logger = Logger.getLogger("Minecraft.Werri");

    @Override
    public void onEnable() {
        this.pluginManager = Bukkit.getServer().getPluginManager();
        pdFile = this.getDescription();
        if (!(pdFile instanceof PluginDescriptionFile)) {
            logger.log(Level.SEVERE, "PluginDescriptionFile can not read. Register disabled.");
            this.pluginManager.disablePlugin(this);
        }

        Plugin werrisCoiniator = null;
        try {
            werrisCoiniator = this.pluginManager.getPlugin("WerrisCoiniator");
            if (!(werrisCoiniator instanceof WerrisCoiniator)) {
                throw new Exception("WerrisCoiniator is not installed!");
            }
            if (!this.pluginManager.isPluginEnabled(werrisCoiniator)) {
                this.pluginManager.enablePlugin(werrisCoiniator);
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "WerrisCoiniator is not installed!");
            logger.log(Level.SEVERE, "", ex);
            this.pluginManager.disablePlugin(this);
        }

        try {
            if (!WCR_Methods.hasMethod()) {
                WCR_Methods.init(this.getServer(), werrisCoiniator);
            }
            register = WCR_Methods.getMethod().getRegister();
        } catch (NullPointerException ex) {
            logger.log(Level.SEVERE, "Register can not hooked Vault correctly!");
            logger.log(Level.SEVERE, "", ex);
            this.pluginManager.disablePlugin(this);
        }

        getCommand("wcregister").setExecutor(new WerrisCoiniatorRegisterCommand(this));

        System.out.println(pdFile.getName() + " " + pdFile.getVersion() + " " + "enabled");
    }

    public WCR_MyRegister getRegister() {
        return register;
    }

    @Override
    public void onDisable() {
        System.out.println(pdFile.getName() + " " + pdFile.getVersion() + " " + "disabled");
    }
    
}
