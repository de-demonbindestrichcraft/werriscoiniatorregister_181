/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.demonbindestrichcraft.lib.bukkit.wbukkitlib.pluginhooks.register.wrapper.register.myregister.werriscoiniator;

import net.milkbowl.vault.economy.EconomyResponse;

/**
 *
 * @author ABC
 */
public class WCR_MyMethodAccount {
    private String accountName;
    private WCR_MyRegister register;
    public WCR_MyMethodAccount(WCR_MyRegister register, String name)
    {
     this.accountName = name;
     this.register = register;
     if(!register.getEconomy().hasAccount(name))
     {
            throw new NullPointerException("Cannot get Account!");
     }
    }
    
    public String getName()
    {
        return accountName;
    }
    
    public WCR_MyRegister getRegister()
    {
        return register;
    }

    public double balance()
    {
        return register.getEconomy().getBalance(accountName);
    }
    
    public void add(double balance)
    {
        register.getEconomy().depositPlayer(accountName, balance);
    }
    
    public void subtract(double balance)
    {
        register.getEconomy().withdrawPlayer(accountName, balance);
    }
    
    public boolean has(double balance) {
        return register.getEconomy().has(accountName, balance);
    }
}
