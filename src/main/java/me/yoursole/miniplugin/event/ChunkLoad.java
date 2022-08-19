package me.yoursole.miniplugin.event;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;

import java.util.ArrayList;
import java.util.List;

public class ChunkLoad implements Listener {

    private static final List<Material> rainbow = new ArrayList<>(){{
        add(Material.RED_CONCRETE);
        add(Material.ORANGE_CONCRETE);
        add(Material.YELLOW_CONCRETE);
        add(Material.GREEN_CONCRETE);
        add(Material.BLUE_CONCRETE);
        add(Material.PINK_CONCRETE);
        add(Material.PURPLE_CONCRETE);
    }};

    @EventHandler
    public void onChunkLoad(ChunkPopulateEvent e){
        Chunk chunk = e.getChunk();

        for (int x = 0; x < 16; x++) {
            for (int y = 0; y <= chunk.getWorld().getMaxHeight(); y++) {
                for (int z = 0; z < 16; z++) {
                    if(chunk.getBlock(x,y,z).getType() == Material.GRASS_BLOCK){
                        chunk.getBlock(x,y,z).setType(rainbow.get(Math.abs(((x+chunk.getX())+(z+chunk.getZ()))%7)));
                    }
                }
            }
        }
    }
}
