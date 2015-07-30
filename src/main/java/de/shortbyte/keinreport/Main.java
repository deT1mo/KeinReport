package de.shortbyte.keinreport;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;


/**
 * 
 * @author _T1mo_
 */

public class Main extends Plugin {

    public Main() {
        
    }
    
    @Override
    public void onEnable() {
        BungeeCord.getInstance().getConsole().sendMessage(new TextComponent("§aKeinReport >> Plugin enabled!"));
        
        BungeeCord.getInstance().getPluginManager().registerCommand(this, new ReportCmd());
    }
    @Override
    public void onDisable() {
        BungeeCord.getInstance().getConsole().sendMessage(new TextComponent("§cKeinReport >> Plugin disabled!"));
    }
    
}
