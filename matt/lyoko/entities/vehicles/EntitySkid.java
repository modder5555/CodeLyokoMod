package matt.lyoko.entities.vehicles;

import matt.lyoko.CodeLyoko;
import matt.lyoko.entities.mobs.*;
import matt.lyoko.items.ModItems;
import net.minecraft.src.*;
import net.minecraft.world.World;

public class EntitySkid extends EntityVehicle
{
	/**
	 * the nav skids are ordered like this: Front, Back, Left, Right
	 */
	private boolean[] navSkid = {true, true, true, true};
	
    public EntitySkid(World world)
    {
        super(world);
        texture = "/mods/lyoko/textures/models/skid.png";
        this.setSize(2.0F, 6.9375F);
        this.setDroppedItem(ModItems.Skid);
    }
    
    public EntitySkid(World world, double x, double y, double z)
    {
        super(world, x, y, z);
        texture = "/mods/lyoko/textures/models/skid.png";
        this.setSize(2.0F, 6.9375F);
        this.setDroppedItem(ModItems.Skid);
    }
    
    public String getTexture()
	{
		return this.texture;
	}
    
    public int getMaxHealth()
    {
        return 1000;
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return null;
    }
    
    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return null;
    }
    
    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return null;
    }
    
    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return false;
    }
    
    /**
     * 
     * @param skidFront
     * @param skidBack
     * @param skidLeft
     * @param skidRight
     */
    public void setNavSkid(boolean skidFront, boolean skidBack, boolean skidLeft, boolean skidRight)
    {
    	navSkid[0] = skidFront;
    	navSkid[1] = skidBack;
    	navSkid[2] = skidLeft;
    	navSkid[3] = skidRight;
    }
    
    /**
     * 
     * @param skid
     * @param arraySlot
     */
    public void setNavSkid(boolean skid, int arraySlot)
    {
    	navSkid[arraySlot] = skid;
    }
    
    public boolean[] getNavSkids()
    {
    	return navSkid;
    }
    
    /**
     * 
     * @param arraySlot
     * @return
     */
    public boolean getNavSkid(int arraySlot)
    {
    	return navSkid[arraySlot];
    }
}
