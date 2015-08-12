/*
 * This file is part of MCME-Events.
 * 
 * MCME-Events is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MCME-Events is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MCME-Events.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 */
package com.mcmiddleearth.mcme.events.PVP.Gamemode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mcmiddleearth.mcme.events.PVP.Map;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 *
 * @author Donovan <dallen@dallen.xyz>
 */
public class TeamDeathmatch implements Gamemode{//Handled by redstone
    
    @Getter @JsonIgnore
    ArrayList<Player> players = new ArrayList<>();
    
    @Getter
    private final ArrayList<String> NeededPoints = new ArrayList<String>(Arrays.asList(new String[] {
        "RedBlock"
    }));
    
    @Getter @JsonIgnore
    boolean Running = false;

    @Override
    public void Start(Map m) {
        Running = true;
        if(m.getImportantPoints().containsKey("RedBlock")){
            m.getImportantPoints().get("RedBlock").toBukkitLoc().getBlock().setType(Material.REDSTONE_BLOCK);
        }else{
            for(Player p : players){
                p.sendMessage("Game not ready to start, no RedBlock location set");
            }
            End(m);
        }
    }
    
    @Override
    public void End(Map m){
        Running = false;
        m.playerLeaveAll();
    }
}
