/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.demonbindestrichcraft.register.payment.werriscoiniator;
import de.demonbindestrichcraft.lib.bukkit.wbukkitlib.pluginhooks.register.wrapper.register.myregister.werriscoiniator.WCR_MyMethods;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author ABC
 */
public abstract class WCR_Methods {
    public static void init(Server bukkitServer, Plugin werrisCoininator)
    {
        WCR_MyMethods.init(bukkitServer, werrisCoininator);
    }
    
    public static WCR_Method getMethod()
    {
        try {
            return new WCR_Method(WCR_MyMethods.getMethod().getRegister());
        } catch (Exception ex) {
            Logger.getLogger(WCR_Methods.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void setMethod(WCR_Method method)
    {
        WCR_MyMethods.setMethod(method);
    }
    
    public static boolean hasMethod()
    {
        return WCR_MyMethods.hasMethod();
    }
}
