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
public class WerrisCoiniatorEconomy implements WCR_EconomyInterface {

    private RPCApp rpcApp = null;
    private WerrisRPCAppInterface werrisRPCAppInterface = null;
    private WerrisCoiniator werrisCoiniator = null;
    private Server server = null;
    
    public WerrisCoiniatorEconomy(Server server, Plugin werrisCoiniator) {
        this.werrisCoiniator = (WerrisCoiniator) werrisCoiniator;
        rpcApp = this.werrisCoiniator.getRPCApp();
        this.werrisRPCAppInterface = this.werrisCoiniator.getWerrisRPCAppInterface();
        this.server = server;
    }

    @Override
    public double getBalance(String accountName) {
        return werrisRPCAppInterface.getBalance(accountName);
    }
    
    public EconomyResponse depositPlayer(String fromAccountName, String accountName, double amount) {
        werrisRPCAppInterface.depositPlayer(fromAccountName, accountName, amount);
        return new EconomyResponse(amount, werrisRPCAppInterface.getBalance(accountName), EconomyResponse.ResponseType.SUCCESS, "");
    }

    public EconomyResponse withdrawPlayer(String fromAccountName, String accountName, double amount) {
        werrisRPCAppInterface.withdrawPlayer(fromAccountName, accountName, amount);
        return new EconomyResponse(amount, werrisRPCAppInterface.getBalance(accountName), EconomyResponse.ResponseType.SUCCESS, "");
    }


    @Override
    public EconomyResponse depositPlayer(String accountName, double amount) {
        werrisRPCAppInterface.depositPlayer("default", accountName, amount);
        return new EconomyResponse(amount, werrisRPCAppInterface.getBalance(accountName), EconomyResponse.ResponseType.SUCCESS, "");
    }

    @Override
    public EconomyResponse withdrawPlayer(String accountName, double amount) {
        werrisRPCAppInterface.withdrawPlayer(accountName, "default", amount);
        return new EconomyResponse(amount, werrisRPCAppInterface.getBalance(accountName), EconomyResponse.ResponseType.SUCCESS, "");
    }

    @Override
    public boolean has(String accountName, double balance) {
        return werrisRPCAppInterface.hasEnoughBalanceForTransferOf(accountName, balance);
    }

    @Override
    public String format(double price) {
        String format;
        double myprice = (price + 0.005d) * 100;
        myprice = ((myprice - (myprice % 1)) / 100);
        format = "" + myprice;
        return format;
    }

    @Override
    public boolean hasAccount(String name) {

        try {
            return werrisRPCAppInterface.getPlugin().getRPCApp().isAccountInList(name);
        } catch (Exception ex) {
            return false;
        }
    }
    
    public WCR_EconomyInterface getEconomy()
    {
        return (WCR_EconomyInterface) this;
    }
    
    public WerrisCoiniator getPlugin()
    {
        return werrisCoiniator;
    }
    
    public RPCApp getRPCApp()
    {
        return rpcApp;
    }
    
    public WerrisRPCAppInterface getWerrisRPCAppInterface()
    {
        return werrisRPCAppInterface;
    }
    
    public Server getServer()
    {
        return server;
    }
}
