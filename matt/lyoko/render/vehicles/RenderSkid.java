package matt.lyoko.render.vehicles;

import org.lwjgl.opengl.GL11;

import matt.lyoko.entities.vehicles.EntitySkid;
import matt.lyoko.model.vehicles.ModelSkid;

public class RenderSkid extends RenderVehicle
{
	public RenderSkid()
	{
		super(new ModelSkid(), 0.5F);
	}
	
	public void renderNavSkids(EntitySkid entSkid)
	{
		if(entSkid.getNavSkid(0))
		{
			//TODO render front navSkid
		}
		if(entSkid.getNavSkid(1))
		{
			//TODO render back navSkid
		}
		if(entSkid.getNavSkid(2))
		{
			//TODO render left navSkid
		}
		if(entSkid.getNavSkid(3))
		{
			//TODO render right navSkid
		}
	}
}
