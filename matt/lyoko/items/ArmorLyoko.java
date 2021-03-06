package matt.lyoko.items;

import matt.lyoko.CodeLyoko;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ArmorLyoko extends ItemArmor
{

        public ArmorLyoko(int i, EnumArmorMaterial enumarmormaterial, int j, int k, String str)
        {
                super(i, enumarmormaterial, j, k);
                this.setCreativeTab(CodeLyoko.LyokoTabs);
                this.armorOwner = str;
                this.setContainerItem(this);
        }
        
        private static double defaultReachDistance = 5;
        private static double newReachDistance = 10;
        private String armorOwner;
        
        @Override
    	public void registerIcons(IconRegister iconRegister)
        {
    		if(this.itemID == ModItems.AelitaHelmet.itemID || this.itemID == ModItems.OddHelmet.itemID
    				|| this.itemID == ModItems.UlrichHelmet.itemID || this.itemID == ModItems.YumiHelmet.itemID
    				|| this.itemID == ModItems.WilliamHelmet.itemID)
    	         itemIcon = iconRegister.registerIcon("lyoko:" + armorOwner + "helmet");
    		if(this.itemID == ModItems.AelitaChest.itemID || this.itemID == ModItems.OddChest.itemID
    				|| this.itemID == ModItems.UlrichChest.itemID || this.itemID == ModItems.YumiChest.itemID
    				|| this.itemID == ModItems.WilliamChest.itemID)
    			itemIcon = iconRegister.registerIcon("lyoko:" + armorOwner + "chest");
    		if(this.itemID == ModItems.AelitaLegs.itemID || this.itemID == ModItems.OddLegs.itemID
    				|| this.itemID == ModItems.UlrichLegs.itemID || this.itemID == ModItems.YumiLegs.itemID
    				|| this.itemID == ModItems.WilliamLegs.itemID)
    			itemIcon = iconRegister.registerIcon("lyoko:" + armorOwner + "legs");
    		if(this.itemID == ModItems.AelitaBoots.itemID || this.itemID == ModItems.OddBoots.itemID
    				|| this.itemID == ModItems.UlrichBoots.itemID || this.itemID == ModItems.YumiBoots.itemID
    				|| this.itemID == ModItems.WilliamBoots.itemID)
    			itemIcon = iconRegister.registerIcon("lyoko:" + armorOwner + "boots");
    	}
        
        @Override
        public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
        {
        	if (player.getCurrentItemOrArmor(4) != null && player.getCurrentItemOrArmor(3) != null
    				&& player.getCurrentItemOrArmor(2) != null && player.getCurrentItemOrArmor(1) != null)
    		{
        		if(this.armorType == 0)
        		{
        			ItemStack helmet = player.getCurrentItemOrArmor(4);
        			ItemStack chest = player.getCurrentItemOrArmor(3);
        			ItemStack legs = player.getCurrentItemOrArmor(2);
        			ItemStack boots = player.getCurrentItemOrArmor(1);
        			if (helmet.getItem() == ModItems.AelitaHelmet && chest.getItem() == ModItems.AelitaChest
        					&& legs.getItem() == ModItems.AelitaLegs && boots.getItem() == ModItems.AelitaBoots)
        			{
        				player.capabilities.allowFlying = true;
        				player.fallDistance = 0;
        				for(int x = 0; x < 9; x++)
        				{
        					ItemStack stack2 = player.inventory.getStackInSlot(x);
        					if((stack2 == null || stack2 == new ItemStack(CodeLyoko.VirtualBlock, stack2.stackSize)) && !player.inventory.hasItem(CodeLyoko.VirtualBlock.blockID))
        					{
        						player.inventory.setInventorySlotContents(x, new ItemStack(CodeLyoko.VirtualBlock, 1));
        					}
        					if((stack2 == null || stack2 == new ItemStack(ModItems.EnergyField, stack2.stackSize)) && !player.inventory.hasItem(ModItems.EnergyField.itemID))
        					{
        						player.inventory.setInventorySlotContents(x, new ItemStack(ModItems.EnergyField, 1));
        					}
        				}
        			}
        			else if (helmet.getItem() == ModItems.OddHelmet && chest.getItem() == ModItems.OddChest
        					&& legs.getItem() == ModItems.OddLegs && boots.getItem() == ModItems.OddBoots)
        			{
        				player.addPotionEffect((new PotionEffect(Potion.jump.getId(), 20, 3)));
        				player.fallDistance = 0;
        				for(int x = 0; x < 9; x++)
        				{
        					ItemStack stack2 = player.inventory.getStackInSlot(x);
        					if((stack2 == null || stack2 == new ItemStack(ModItems.Glove, stack2.stackSize)) && !player.inventory.hasItem(ModItems.Glove.itemID))
        					{
        						player.inventory.setInventorySlotContents(x, new ItemStack(ModItems.Glove, 1));
        					}
        				}
        			}
        			else if (helmet.getItem() == ModItems.UlrichHelmet && chest.getItem() == ModItems.UlrichChest
        					&& legs.getItem() == ModItems.UlrichLegs && boots.getItem() == ModItems.UlrichBoots)
        			{
        				if(player.isSprinting())
        				{
        					player.addPotionEffect((new PotionEffect(Potion.moveSpeed.getId(), 20, 2)));
        				}
        				player.fallDistance = 0;
        				for(int x = 0; x < 9; x++)
        				{
        					ItemStack stack2 = player.inventory.getStackInSlot(x);
        					if((stack2 == null || stack2 == new ItemStack(ModItems.Katana, stack2.stackSize)) && !player.inventory.hasItem(ModItems.Katana.itemID))
        					{
        						player.inventory.setInventorySlotContents(x, new ItemStack(ModItems.Katana, 1));
        					}
        				}
        			}
        			else if (helmet.getItem() == ModItems.YumiHelmet && chest.getItem() == ModItems.YumiChest
        					&& legs.getItem() == ModItems.YumiLegs && boots.getItem() == ModItems.YumiBoots)
        			{
        				player.getFoodStats().setFoodSaturationLevel(40.0F);
        				player.getFoodStats().setFoodLevel(20);
        				player.fallDistance = 0;
        				if(player instanceof EntityPlayerMP)
        				{
        					ItemInWorldManager iiwm = ((EntityPlayerMP)player).theItemInWorldManager;
        					if(newReachDistance != iiwm.getBlockReachDistance())
        					{
        						iiwm.setBlockReachDistance(newReachDistance);
        					}
        				}
        				for(int x = 0; x < 9; x++)
        				{
        					ItemStack stack2 = player.inventory.getStackInSlot(x);
        					if((stack2 == null || stack2 == new ItemStack(ModItems.Fan, stack2.stackSize)) && !player.inventory.hasItem(ModItems.Fan.itemID))
        					{
        						player.inventory.setInventorySlotContents(x, new ItemStack(ModItems.Fan, 1));
        					}
        				}
        			}
        			else if (helmet.getItem() == ModItems.WilliamHelmet && chest.getItem() == ModItems.WilliamChest
        					&& legs.getItem() == ModItems.WilliamLegs && boots.getItem() == ModItems.WilliamBoots)
        			{
        				if(player.isSprinting())
        				{
        					player.addPotionEffect((new PotionEffect(Potion.moveSpeed.getId(), 20, 2)));
        					player.addPotionEffect((new PotionEffect(Potion.invisibility.getId(), 20, 2)));
        				}
        				player.fallDistance = 0;
        				for(int x = 0; x < 9; x++)
        				{
        					ItemStack stack2 = player.inventory.getStackInSlot(x);
        					if((stack2 == null || stack2 == new ItemStack(ModItems.Zweihander, stack2.stackSize)) && !player.inventory.hasItem(ModItems.Zweihander.itemID))
        					{
        						player.inventory.setInventorySlotContents(x, new ItemStack(ModItems.Zweihander, 1));
        					}
        				}
        			}
        		}
    		}
        	else if ((player.getCurrentItemOrArmor(4) == null || player.getCurrentItemOrArmor(3) == null
    				|| player.getCurrentItemOrArmor(2) == null || player.getCurrentItemOrArmor(1) == null)
    				&& player.capabilities.isCreativeMode == false)
			{
				player.capabilities.allowFlying = false;
				if(player instanceof EntityPlayerMP)
				{
					ItemInWorldManager iiwm = ((EntityPlayerMP)player).theItemInWorldManager;
					if(iiwm.getBlockReachDistance() != defaultReachDistance)
					{
						iiwm.setBlockReachDistance(defaultReachDistance);
					}
				}
			}
        }
        
        @Override
        public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer)
        {
        	if(itemstack.itemID == ModItems.AelitaHelmet.itemID || itemstack.itemID == ModItems.AelitaChest.itemID || itemstack.itemID == ModItems.AelitaBoots.itemID
        			|| itemstack.itemID == ModItems.OddHelmet.itemID || itemstack.itemID == ModItems.OddChest.itemID || itemstack.itemID == ModItems.OddBoots.itemID
        			|| itemstack.itemID == ModItems.UlrichHelmet.itemID || itemstack.itemID == ModItems.UlrichChest.itemID || itemstack.itemID == ModItems.UlrichBoots.itemID
        			|| itemstack.itemID == ModItems.YumiHelmet.itemID || itemstack.itemID == ModItems.YumiChest.itemID || itemstack.itemID == ModItems.YumiBoots.itemID
        			|| itemstack.itemID == ModItems.WilliamHelmet.itemID || itemstack.itemID == ModItems.WilliamChest.itemID || itemstack.itemID == ModItems.WilliamBoots.itemID)
            {
            	return "/mods/lyoko/textures/armor/" + this.armorOwner + "_1.png";
            }
            if(itemstack.itemID == ModItems.AelitaLegs.itemID || itemstack.itemID == ModItems.OddLegs.itemID
            		|| itemstack.itemID == ModItems.UlrichLegs.itemID || itemstack.itemID == ModItems.YumiLegs.itemID
            		|| itemstack.itemID == ModItems.WilliamLegs.itemID)
            {
            	return "/mods/lyoko/textures/armor/" + this.armorOwner + "_2.png";
            }
            return "/mods/lyoko/textures/armor/" + this.armorOwner + "_1.png";
        }
}