package matt.lyoko.slots;

import matt.lyoko.container.ContainerSuperCalc;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotSuperCalc extends Slot
{
    /** The beacon this slot belongs to. */
    final ContainerSuperCalc supercalc;

    public SlotSuperCalc(ContainerSuperCalc par1ContainerSuperCalc, IInventory par2IInventory, int par3, int par4, int par5)
    {
        super(par2IInventory, par3, par4, par5);
        this.supercalc = par1ContainerSuperCalc;
    }
}