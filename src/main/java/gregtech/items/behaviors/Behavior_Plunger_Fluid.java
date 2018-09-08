package gregtech.items.behaviors;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.data.CS.SFX;
import gregapi.data.LH;
import gregapi.item.multiitem.MultiItem;
import gregapi.item.multiitem.MultiItemTool;
import gregapi.item.multiitem.behaviors.IBehavior.AbstractBehaviorDefault;
import gregapi.util.UT;
import gregapi.util.WD;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.IFluidHandler;

public class Behavior_Plunger_Fluid extends AbstractBehaviorDefault {
	private final int mCosts;
	
	public Behavior_Plunger_Fluid(int aCosts) {
		mCosts = aCosts;
	}
	
	@Override
	public boolean onItemUseFirst(MultiItem aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, byte aSide, float hitX, float hitY, float hitZ) {
		if (aWorld.isRemote) return F;
		TileEntity aTileEntity = WD.te(aWorld, aX, aY, aZ, T);
		if (aTileEntity instanceof IFluidHandler) {
			for (ForgeDirection tDirection : ForgeDirection.VALID_DIRECTIONS) if (((IFluidHandler)aTileEntity).drain(tDirection, 1000, F) != null) {
				if (UT.Entities.hasInfiniteItems(aPlayer) || ((MultiItemTool)aItem).doDamage(aStack, mCosts, aPlayer)) {
					((IFluidHandler)aTileEntity).drain(tDirection, 1000, T);
					UT.Sounds.send(aWorld, SFX.IC_TRAMPOLINE, 1.0F, -1, aX, aY, aZ);
					return T;
				}
			}
		}
		return F;
	}
	
	static {
		LH.add("gt.behaviour.plunger.fluid", "Clears 1000 Liters of Fluid from Tanks");
	}
	
	@Override
	public List<String> getAdditionalToolTips(MultiItem aItem, List<String> aList, ItemStack aStack) {
		aList.add(LH.get("gt.behaviour.plunger.fluid"));
		return aList;
	}
}