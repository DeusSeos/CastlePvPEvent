package seoss.castlepvpevent;

import net.minecraft.server.v1_15_R1.EntityTypes;
import net.minecraft.server.v1_15_R1.EntityZombie;
import net.minecraft.server.v1_15_R1.World;

public class CustomEntity extends EntityZombie{
    public CustomEntity(World world, EntityTypes<? extends EntityZombie> entityType) {
        this(world);
    }

    public CustomEntity(World world)
    {
        super(world);
    }


}
