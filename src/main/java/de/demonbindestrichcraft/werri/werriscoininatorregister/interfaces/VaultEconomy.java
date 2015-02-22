/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.demonbindestrichcraft.werri.werriscoininatorregister.interfaces;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Server;

/**
 *
 * @author ABC
 */
public class VaultEconomy implements WCR_EconomyInterface {

    Economy economy = null;
    Server server = null;
    public VaultEconomy(Server server, Economy economy)
    {
        this.economy = economy;
        this.server = server;
    }
    
    @Override
    public double getBalance(String accountName) {
        return economy.getBalance(accountName);
    }

    @Override
    public EconomyResponse depositPlayer(String accountName, double amount) {
        return economy.depositPlayer(accountName, amount);
    }

    @Override
    public EconomyResponse withdrawPlayer(String accountName, double amount) {
        return economy.withdrawPlayer(accountName, amount);
    }

    @Override
    public boolean has(String accountName, double balance) {
        return economy.has(accountName, balance);
    }

    @Override
    public String format(double price) {
        return economy.format(price);
    }

    @Override
    public boolean hasAccount(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public WCR_EconomyInterface getEconomy()
    {
        return (WCR_EconomyInterface) this;
    }
    
    public Server getServer()
    {
        return server;
    }
}
