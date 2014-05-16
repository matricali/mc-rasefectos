package ras.minecraft.plugin.efectos;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import ras.minecraft.plugin.particulasapi.ParticlesAPI;
import ras.minecraft.plugin.particulasapi.ParticlesType;

/**
 *
 * @author Jorge Matricali <jorge.matricali@gmail.com>
 */
public class Efectos extends JavaPlugin implements Listener {
    public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void onRegainLife(EntityRegainHealthEvent e){
        ParticlesAPI.createEffect(e.getEntity().getLocation().clone().add(0.0, 1.0, 0.1), ParticlesType.HEART, 0.0f, 0.3f, 1);
    }
    
    @EventHandler
    public void onLevelUp(PlayerLevelChangeEvent e){
        if(e.getOldLevel()<e.getNewLevel())
            ParticlesAPI.createEffect(e.getPlayer().getLocation(), ParticlesType.BUBBLE, 0.2f, 0.3f, e.getNewLevel());
            e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
    }
}
