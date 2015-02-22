/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.demonbindestrichcraft.werri.werriscoininatorregister.interfaces;

import net.milkbowl.vault.economy.EconomyResponse;

/**
 *
 * @author ABC
 */
public interface WCR_EconomyInterface {
    public double getBalance(String accountName);
    public EconomyResponse depositPlayer(String accountName, double amount);
    public EconomyResponse withdrawPlayer(String accountName, double amount);
    public boolean has(String accountName, double balance);
    public String format(double price);   
    public boolean hasAccount(String name);
}
