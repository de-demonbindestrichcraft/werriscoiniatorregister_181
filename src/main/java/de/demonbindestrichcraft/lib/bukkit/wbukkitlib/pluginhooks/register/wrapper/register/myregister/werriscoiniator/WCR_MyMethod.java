/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.demonbindestrichcraft.lib.bukkit.wbukkitlib.pluginhooks.register.wrapper.register.myregister.werriscoiniator;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author ABC
 */
public class WCR_MyMethod {
    private WCR_MyRegister register;
    public WCR_MyMethod(Server bukkitServer, Plugin werrisCoininator)
    {
        register = new WCR_MyRegister(bukkitServer,werrisCoininator);
    }
    
    public WCR_MyMethod(WCR_MyRegister register)
    {
        this.register = register;
    }
    
    public WCR_MyMethodAccount getAccount(String name)
    {
        return new WCR_MyMethodAccount(register, name);
    }
    
    public String format(double price)
    {
        return register.getEconomy().format(price);
    }
    
    public boolean hasAccount(String name)
    {
        return register.getEconomy().hasAccount(name);
    }
    
    public WCR_MyRegister getRegister()
    {
        return register;
    }
}
