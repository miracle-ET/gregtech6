package gregapi.block.multitileentity.example;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.code.ArrayListNoNulls;
import gregapi.data.IL;
import gregapi.data.LH;
import gregapi.data.LH.Chat;
import gregapi.data.MD;
import gregapi.render.BlockTextureCopied;
import gregapi.render.ITexture;
import gregapi.util.ST;
import gregapi.util.UT;
import gregapi.util.WD;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * @author Gregorius Techneticies
 * 
 * An example implementation of a Miniature Erebus Portal with my MultiTileEntity System.
 */
public class MultiTileEntityMiniPortalErebus extends MultiTileEntityMiniPortal {
	public static List<MultiTileEntityMiniPortalErebus>
	sListErebusSide = new ArrayListNoNulls(),
	sListWorldSide  = new ArrayListNoNulls();
	
	static {
		LH.add("gt.tileentity.portal.erebus.tooltip.1", "Only works between the Erebus and the Overworld!");
		LH.add("gt.tileentity.portal.erebus.tooltip.2", "Margin of Error to still work: 128 Meters.");
		LH.add("gt.tileentity.portal.erebus.tooltip.3", "Requires Staff of Gaea or a Gaean Gem for activation");
	}
	
	@Override
	public void addToolTips2(List aList, ItemStack aStack, boolean aF3_H) {
		aList.add(Chat.CYAN		+ LH.get("gt.tileentity.portal.erebus.tooltip.1"));
		aList.add(Chat.CYAN		+ LH.get("gt.tileentity.portal.erebus.tooltip.2"));
		aList.add(Chat.ORANGE	+ LH.get("gt.tileentity.portal.erebus.tooltip.3"));
	}
	
	@Override
	public void findTargetPortal() {
		mTarget = null;
		if (MD.ERE.mLoaded && worldObj != null && isServerSide()) {
			if (worldObj.provider.dimensionId == DIM_OVERWORLD) {
				long tShortestDistance = 128*128;
				for (MultiTileEntityMiniPortalErebus tTarget : sListErebusSide) if (tTarget != this) {
					long tXDifference = xCoord-tTarget.xCoord, tZDifference = zCoord-tTarget.zCoord;
					long tTempDist = tXDifference * tXDifference + tZDifference * tZDifference;
					if (tTempDist < tShortestDistance) {
						tShortestDistance = tTempDist;
						mTarget = tTarget;
					} else if (tTempDist == tShortestDistance && (mTarget == null || Math.abs(tTarget.yCoord-yCoord) < Math.abs(mTarget.yCoord-yCoord))) {
						mTarget = tTarget;
					}
				}
			} else if (WD.dimERE(worldObj)) {
				long tShortestDistance = 128*128;
				for (MultiTileEntityMiniPortalErebus tTarget : sListWorldSide) if (tTarget != this) {
					long tXDifference = tTarget.xCoord-xCoord, tZDifference = tTarget.zCoord-zCoord;
					long tTempDist = tXDifference * tXDifference + tZDifference * tZDifference;
					if (tTempDist < tShortestDistance) {
						tShortestDistance = tTempDist;
						mTarget = tTarget;
					} else if (tTempDist == tShortestDistance && (mTarget == null || Math.abs(tTarget.yCoord-yCoord) < Math.abs(mTarget.yCoord-yCoord))) {
						mTarget = tTarget;
					}
				}
			}
		}
	}
	
	@Override
	public void addThisPortalToLists() {
		if (MD.ERE.mLoaded && worldObj != null && isServerSide()) {
			if (worldObj.provider.dimensionId == DIM_OVERWORLD) {
				if (!sListWorldSide.contains(this)) sListWorldSide.add(this);
				for (MultiTileEntityMiniPortalErebus tPortal : sListErebusSide) tPortal.findTargetPortal();
				findTargetPortal();
			} else if (WD.dimERE(worldObj)) {
				if (!sListErebusSide.contains(this)) sListErebusSide.add(this);
				for (MultiTileEntityMiniPortalErebus tPortal : sListWorldSide) tPortal.findTargetPortal();
				findTargetPortal();
			} else {
				setPortalInactive();
			}
		}
	}
	
	@Override
	public void removeThisPortalFromLists() {
		if (sListWorldSide.remove(this)) for (MultiTileEntityMiniPortal tPortal : sListErebusSide) if (tPortal.mTarget == this) tPortal.findTargetPortal();
		if (sListErebusSide.remove(this)) for (MultiTileEntityMiniPortal tPortal : sListWorldSide) if (tPortal.mTarget == this) tPortal.findTargetPortal();
		mTarget = null;
	}
	
	@Override
	public boolean onBlockActivated2(EntityPlayer aPlayer, byte aSide, float aHitX, float aHitY, float aHitZ) {
		if (isServerSide()) {
			ItemStack aStack = aPlayer.inventory.getCurrentItem();
			if (ST.valid(aStack) && aStack.stackSize > 0 && (IL.ERE_Gaean_Gem.equal(aStack, F, T) || IL.ERE_Gaean_Staff.equal(aStack, F, T))) {
				setPortalActive();
				if (mTarget != null) UT.Entities.sendchat(aPlayer, "X: " + mTarget.xCoord + "   Y: " + mTarget.yCoord + "   Z: " + mTarget.zCoord);
				if (!UT.Entities.hasInfiniteItems(aPlayer)) aStack.stackSize--;
				
			}
		}
		return T;
	}
	
	@Override public float getBlockHardness() {return Blocks.stone.getBlockHardness(worldObj, xCoord, yCoord, zCoord);}
	@Override public float getExplosionResistance() {return Blocks.stone.getExplosionResistance(null);}
	
	public ITexture sErebusPortal = BlockTextureCopied.get(ST.block(MD.ERE, "portal", Blocks.portal), SIDE_ANY, 0, UNCOLOURED, F, T, T), sErebusPortalFrame = BlockTextureCopied.get(ST.block(MD.ERE, "umberstone", Blocks.stone), SIDE_ANY, 0, UNCOLOURED, F, F, F), sErebusPortalInactive = BlockTextureCopied.get(Blocks.leaves, SIDE_ANY, 0, DYE_Green, F, F, F);
	@Override public ITexture getPortalTexture() {return sErebusPortal;}
	@Override public ITexture getFrameTexture() {return sErebusPortalFrame;}
	@Override public ITexture getInactiveTexture() {return sErebusPortalInactive;}
	
	@Override public String getTileEntityName() {return "gt.multitileentity.portal.erebus";}
}