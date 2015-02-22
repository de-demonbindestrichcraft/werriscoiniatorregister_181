/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.demonbindestrichcraft.werri.werriscoininatorregister.interfaces;

import com.nitinsurana.bitcoinlitecoin.rpcconnector.RPCApp;
import de.fireearth.werri.werriscoiniator.WerrisCoiniator;
import de.fireearth.werri.werriscoiniator.WerrisRPCAppInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author ABC
 */
public final class WCR_MyEconomy implements WCR_EconomyInterface {
    private Server bukkitServer;
    private VaultEconomy vaultEconomy;
    private WerrisCoiniatorEconomy werrisCoiniatorEconomy;
    private WCR_EconomyInterface currentInterface = null;
    private boolean useEconomy;
    public WCR_MyEconomy(Server bukkitServer,Economy economy, Plugin werrisCoiniator)
    {
        this.setUseEconomy(false);
        this.vaultEconomy = new VaultEconomy(bukkitServer,economy);
        this.werrisCoiniatorEconomy = new WerrisCoiniatorEconomy(bukkitServer,werrisCoiniator);
        this.bukkitServer = bukkitServer;
    }

    public void setUseEconomy(boolean set)
    {
       useEconomy = set;
       if(useEconomy)
       {
           this.currentInterface = vaultEconomy;
       } else {
           this.currentInterface = werrisCoiniatorEconomy;
       }
    }
    
    public boolean useEconomy()
    {
        return useEconomy;
    }
    
    public boolean useWerrisCoiniator()
    {
        return !useEconomy;
    }
    
    @Override
    public double getBalance(String accountName) {
        return currentInterface.getBalance(accountName);
    }

    @Override
    public EconomyResponse depositPlayer(String accountName, double amount) {
        return currentInterface.depositPlayer(accountName, amount);
    }

    @Override
    public EconomyResponse withdrawPlayer(String accountName, double amount) {
        return currentInterface.withdrawPlayer(accountName, amount);
    }

    @Override
    public boolean has(String accountName, double balance) {
        return currentInterface.has(accountName, balance);
    }
    
    @Override
    public String format(double price)
    {
        return currentInterface.format(price);
    }
    
    @Override
    public boolean hasAccount(String name)
    {
        return currentInterface.hasAccount(name);
    }
    
    public VaultEconomy getVaultEconomy()
    {
        return vaultEconomy;
    }
    
    public WerrisCoiniatorEconomy getWerrisCoiniatorEconomy()
    {
        return werrisCoiniatorEconomy;
    }
    
    public Server getServer()
    {
        return bukkitServer;
    }
}
