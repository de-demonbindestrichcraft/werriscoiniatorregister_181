/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.demonbindestrichcraft.register.payment.werriscoiniator;
import de.demonbindestrichcraft.lib.bukkit.wbukkitlib.pluginhooks.register.wrapper.register.myregister.werriscoiniator.WCR_MyMethod;
import de.demonbindestrichcraft.lib.bukkit.wbukkitlib.pluginhooks.register.wrapper.register.myregister.werriscoiniator.WCR_MyRegister;
import de.demonbindestrichcraft.register.payment.werriscoiniator.method.WCR_MethodAccount;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;



/**
 *
 * @author ABC
 */
public class WCR_Method extends WCR_MyMethod { 
    public WCR_Method(Server bukkitServer, Plugin werrisCoininator)
    {
        super(bukkitServer, werrisCoininator);
    }
    
    public WCR_Method(WCR_MyRegister register)
    {
        super(register);
    }
    
    @Override
    public WCR_MethodAccount getAccount(String name)
    {
        return new WCR_MethodAccount(super.getRegister(), name);
    } 
}
