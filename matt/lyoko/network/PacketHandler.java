package matt.lyoko.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import matt.lyoko.entities.*;
import matt.lyoko.entities.tileentity.TileEntityTowerConsole;

public class PacketHandler implements IPacketHandler
{
    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
    {
        DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
        EntityPlayer sender = (EntityPlayer) player;
        
        if(packet.channel.equals("Code_Lyoko"))
        {
        	handlePacket(data, sender.worldObj);
        }
    }
    
    private void handlePacket(DataInputStream data, World world)
    {
        String code;
        int x;
        int y;
        int z;
        
        try
        {
        	code = data.readUTF();
        	x = data.readInt();
        	y = data.readInt();
        	z = data.readInt();
        }
        catch (IOException e)
        {
        	e.printStackTrace();
        	return;
        }
        
        if(world.getBlockTileEntity(x, y, z) != null && world.getBlockTileEntity(x, y, z) instanceof TileEntityTowerConsole)
        {
        	TileEntityTowerConsole tetc = (TileEntityTowerConsole) world.getBlockTileEntity(x, y, z);
        	tetc.owner = code;
        	world.markBlockForUpdate(x, y, z);
        }
    }
}