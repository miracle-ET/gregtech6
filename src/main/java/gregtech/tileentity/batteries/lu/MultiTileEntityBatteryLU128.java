package gregtech.tileentity.batteries.lu;

import static gregapi.data.CS.*;

import gregapi.old.Textures;
import gregapi.render.BlockTextureDefault;
import gregapi.render.IIconContainer;
import gregapi.render.ITexture;
import gregapi.tileentity.energy.TileEntityBase08Battery;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;

/**
 * @author Gregorius Techneticies
 */
public class MultiTileEntityBatteryLU128 extends TileEntityBase08Battery {
	@Override
	public int getRenderPasses2(Block aBlock, boolean[] aShouldSideBeRendered) {
		return 1;
	}
	@Override
	public ITexture getTexture2(Block aBlock, int aRenderPass, byte aSide, boolean[] aShouldSideBeRendered) {
		return BlockTextureDefault.get(sTextures[FACES_TBS[aSide]], mRGBa, 113+mDisplayedEnergy);
	}
	public static IIconContainer sTextures[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/batteries/lu/128/bottom"),
		new Textures.BlockIcons.CustomIcon("machines/batteries/lu/128/top"),
		new Textures.BlockIcons.CustomIcon("machines/batteries/lu/128/sides"),
	};
	
	@Override public boolean setBlockBounds2(Block aBlock, int aRenderPass, boolean[] aShouldSideBeRendered) {box(aBlock	, PX_P[ 4], PX_P[ 0], PX_P[ 4], PX_N[ 4], PX_N[ 8], PX_N[ 4]); return T;}
	@Override public AxisAlignedBB getCollisionBoundingBoxFromPool() {return box											( PX_P[ 4], PX_P[ 0], PX_P[ 4], PX_N[ 4], PX_N[ 8], PX_N[ 4]);}
	@Override public AxisAlignedBB getSelectedBoundingBoxFromPool () {return box											( PX_P[ 4], PX_P[ 0], PX_P[ 4], PX_N[ 4], PX_N[ 8], PX_N[ 4]);}
	@Override public void setBlockBoundsBasedOnState(Block aBlock) {box(aBlock												, PX_P[ 4], PX_P[ 0], PX_P[ 4], PX_N[ 4], PX_N[ 8], PX_N[ 4]);}
	
	@Override public byte getDisplayScaleMax() {return 127;}
	
	@Override public String getTileEntityName() {return "gt.multitileentity.battery.lu.128";}
}