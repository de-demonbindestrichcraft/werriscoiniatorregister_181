package de.demonbindestrichcraft.lib.bukkit.wbukkitlib.pluginhooks.register.wrapper.register.myregister.werriscoiniator;

import de.demonbindestrichcraft.werri.werriscoininatorregister.interfaces.WCR_EconomyInterface;
import de.demonbindestrichcraft.werri.werriscoininatorregister.interfaces.WCR_MyEconomy;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

/**
 * Hello world!
 *
 */
public class WCR_MyRegister 
{
    private Economy economy = null;
    private Server bukkitServer = null;
    private WCR_MyEconomy myEconomy = null;
    public WCR_MyRegister(Server bukkitServer,Plugin werrisCoiniator)
    {
        this.bukkitServer = bukkitServer;
        if(!setupEconomy())
        {
            throw new NullPointerException("economy cannot be null!");
        }
        this.myEconomy = new WCR_MyEconomy(bukkitServer, economy, werrisCoiniator);
    }
    
    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = bukkitServer.getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
    
    public WCR_EconomyInterface getEconomy()
    {
        return myEconomy;
    }
    
    public WCR_MyEconomy getWCR_MyEconomy()
    {
        return myEconomy;
    }
    
    public Server getServer()
    {
        return bukkitServer;
    }
}
