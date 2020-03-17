package seoss.castlepvpevent;

import net.minecraft.server.v1_15_R1.*;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;


public class CustomSheep extends EntitySheep {


    // private CastlePvPEvent plugin = CastlePvPEvent.getPlugin(CastlePvPEvent.class);


    public CustomSheep(World world) {
        super(EntityTypes.SHEEP, world);
        this.collides = false;
        this.setAge(-32767, true);
        this.setColor(EnumColor.RED);
        //this.setCustomName(IChatBaseComponent);
    }



    public CustomSheep(EntityTypes<? extends EntitySheep> customSheepEntityTypes, World world) {
        this(world);
        this.collides = false;
        this.setColor(EnumColor.RED);
        this.setAge(-32767, true);
    }

    @Override
    public boolean a(EntityHuman entity, EnumHand enumhand) {
        ((Player) CraftPlayer.getEntity(entity.getWorld().getServer(), (EntityPlayer)entity)).sendMessage(String.valueOf(this.isBaby()));
        return super.a(entity, enumhand);
    }

    @Override
    protected void initAttributes() {
        // Calling the super method for the rest of the attributes.
        super.initAttributes();
        this.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(810.0);
        this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.0);
        this.getAttributeInstance(GenericAttributes.ARMOR).setValue(20.0);
        //this.getAttributeInstance(GenericAttributes.KNOCKBACK_RESISTANCE).setValue();
    }

//    @Override
//    public void collide(Entity entity){
//
//    }




}
