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
public abstract class WCR_MyMethods {
    private static WCR_MyMethod method = null;
    public static void init(Server bukkitServer, Plugin werrisCoininator)
    {
        if(!hasMethod()) 
            setMethod(new WCR_MyMethod(bukkitServer, werrisCoininator));
    }
    
    public static WCR_MyMethod getMethod() throws Exception
    {
        if(!hasMethod())
            throw new Exception("Register ist not initialisiert!");
        return method;
    }
    
    public static void setMethod(WCR_MyMethod method)
    {
        WCR_MyMethods.method = method;
    }
    
    public static boolean hasMethod()
    {
        return method != null;
    }
}
