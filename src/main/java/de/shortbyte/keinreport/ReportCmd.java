package de.shortbyte.keinreport;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 *
 * @author _T1mo_
 */
public class ReportCmd extends Command {

    public ReportCmd() {
        super("report");
    }
    
    

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            if(args.length <= 1) {
                sender.sendMessage(new TextComponent("§c§l[§e§lKeinLeben§c§l] §7/report <player> <reason>"));
            }
            if(args.length >= 2) {
                ProxiedPlayer player = (ProxiedPlayer)sender;
                ProxiedPlayer target = BungeeCord.getInstance().getPlayer(args[0]);
                String reason = "";
                for(int i = 1; i < args.length; i++) {
                    reason += args[i] + " ";
                }
                if(target == null) {
                    player.sendMessage(new TextComponent("§c§l[§e§lKeinLeben§c§l] §7Player not found."));
                }
                for(ProxiedPlayer team : BungeeCord.getInstance().getPlayers()) {
                    if(team.hasPermission("KeinLeben.Report.Receive")) {
                        team.sendMessage(new TextComponent("§c§l[§e§lReport§c§l] §7" + player.getServer().getInfo().getName() + ": §e"
                            + player.getName() + " §7hat §7den §7Spieler §c" + target.getName()
                            + " §7reported! §7Grund: §e" + reason));
                    }
                    
                }
                
                player.sendMessage(new TextComponent("§c§l[§e§lKeinLeben§c§l] §7Dein §7Report §7wurde §7verschickt§7! §7Es §7wird §7sich §7in §7Kürze §7ein §7Teammitglied §7darum §7kümmern§7!"));
                
            }
            
        }
    }
    
}
