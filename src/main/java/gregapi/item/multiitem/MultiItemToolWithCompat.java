package gregapi.item.multiitem;

import static gregapi.data.CS.*;

import buildcraft.api.tools.IToolWrench;
import cpw.mods.fml.common.Optional;
import forestry.api.arboriculture.IToolGrafter;
import gregapi.data.CS.ModIDs;
import gregapi.item.multiitem.tools.IToolStats;
import gregapi.util.UT;
import ic2.api.item.IBoxable;
import ic2.api.item.IElectricItemManager;
import ic2.api.item.ISpecialElectricItem;
import micdoodle8.mods.galacticraft.api.item.IItemElectric;
import mods.railcraft.api.core.items.IToolCrowbar;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author Gregorius Techneticies
 * 
 * This is an example on how you can create a Tool ItemStack, in this case a Bismuth Wrench:
 * gregapi.data.CS.ToolsGT.sMetaTool.getToolWithStats(CS.ToolIDs.WRENCH, 1, MT.Bismuth, MT.Bismuth, null);
 */
@Optional.InterfaceList(value = {
  @Optional.Interface(iface = "forestry.api.arboriculture.IToolGrafter", modid = ModIDs.FR)
, @Optional.Interface(iface = "mods.railcraft.api.core.items.IToolCrowbar", modid = ModIDs.RC)
, @Optional.Interface(iface = "buildcraft.api.tools.IToolWrench", modid = ModIDs.BC)
, @Optional.Interface(iface = "ic2.api.item.IBoxable", modid = ModIDs.IC2)
, @Optional.Interface(iface = "ic2.api.item.ISpecialElectricItem", modid = ModIDs.IC2)
, @Optional.Interface(iface = "ic2.api.item.IElectricItemManager", modid = ModIDs.IC2)
, @Optional.Interface(iface = "micdoodle8.mods.galacticraft.api.item.IItemElectric", modid = ModIDs.GC)
})
public class MultiItemToolWithCompat extends MultiItemTool implements IToolGrafter, IToolCrowbar, IToolWrench, IBoxable, ISpecialElectricItem, IElectricItemManager, IItemElectric {
	/**
	 * Creates the Item using these Parameters.
	 * @param aUnlocalized The unlocalised Name of this Item. DO NOT START YOUR UNLOCALISED NAME WITH "gt."!!!
	 */
	public MultiItemToolWithCompat(String aModID, String aUnlocalized) {super(aModID, aUnlocalized);}
	
	@Override
	public float getSaplingModifier(ItemStack aStack, World aWorld, EntityPlayer aPlayer, int aX, int aY, int aZ) {
		IToolStats tStats = getToolStats(aStack);
		return tStats != null && tStats.isGrafter() ? Math.min(100.0F, (1+getHarvestLevel(aStack, "")) * 20.0F) : 0.0F;
	}
	
	@Override
	public boolean canWrench(EntityPlayer aPlayer, int aX, int aY, int aZ) {
		ItemStack aStack = aPlayer.getCurrentEquippedItem();
		if (!isItemStackUsable(aStack)) return F;
		IToolStats tStats = getToolStats(aStack);
		return tStats != null && tStats.isWrench();
	}
	
	@Override
	public void wrenchUsed(EntityPlayer aPlayer, int aX, int aY, int aZ) {
		ItemStack aStack = aPlayer.getCurrentEquippedItem();
		IToolStats tStats = getToolStats(aStack);
		if (tStats != null && !UT.Entities.hasInfiniteItems(aPlayer)) doDamage(aStack, 100, aPlayer);
	}
	
	@Override
	public boolean canWhack(EntityPlayer aPlayer, ItemStack aStack, int aX, int aY, int aZ) {
		if (!isItemStackUsable(aStack)) return F;
		IToolStats tStats = getToolStats(aStack);
		return tStats != null && tStats.isCrowbar();
	}
	
	@Override
	public void onWhack(EntityPlayer aPlayer, ItemStack aStack, int aX, int aY, int aZ) {
		IToolStats tStats = getToolStats(aStack);
		if (tStats != null && !UT.Entities.hasInfiniteItems(aPlayer)) doDamage(aStack, 100, aPlayer);
	}
	
	@Override
	public boolean canLink(EntityPlayer aPlayer, ItemStack aStack, EntityMinecart cart) {
		if (!isItemStackUsable(aStack)) return F;
		IToolStats tStats = getToolStats(aStack);
		return tStats != null && tStats.isCrowbar();
	}
	
	@Override
	public void onLink(EntityPlayer aPlayer, ItemStack aStack, EntityMinecart cart) {
		IToolStats tStats = getToolStats(aStack);
		if (tStats != null && !UT.Entities.hasInfiniteItems(aPlayer)) doDamage(aStack, tStats.getToolDamagePerEntityAttack(), aPlayer);
	}
	
	@Override
	public boolean canBoost(EntityPlayer aPlayer, ItemStack aStack, EntityMinecart cart) {
		if (!isItemStackUsable(aStack)) return F;
		IToolStats tStats = getToolStats(aStack);
		return tStats != null && tStats.isCrowbar();
	}
	
	@Override
	public void onBoost(EntityPlayer aPlayer, ItemStack aStack, EntityMinecart cart) {
		IToolStats tStats = getToolStats(aStack);
		if (tStats != null && !UT.Entities.hasInfiniteItems(aPlayer)) doDamage(aStack, tStats.getToolDamagePerEntityAttack(), aPlayer);
	}
	
	@Override
	public boolean canBeStoredInToolbox(ItemStack itemstack) {
		return T;
	}
	
	@Override @Optional.Method(modid = ModIDs.IC2)
	public IElectricItemManager getManager(ItemStack aStack) {return this;}
}