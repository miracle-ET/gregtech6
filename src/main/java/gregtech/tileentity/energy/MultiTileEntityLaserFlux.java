package gregtech.tileentity.energy;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.old.Textures;
import gregapi.render.BlockTextureDefault;
import gregapi.render.BlockTextureMulti;
import gregapi.render.IIconContainer;
import gregapi.render.ITexture;
import gregapi.tileentity.energy.ITileEntityEnergyFluxHandler;
import gregapi.tileentity.energy.TileEntityBase10EnergyConverter;
import gregapi.tileentity.machines.ITileEntityAdjacentOnOff;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MultiTileEntityLaserFlux extends TileEntityBase10EnergyConverter implements ITileEntityEnergyFluxHandler, ITileEntityAdjacentOnOff {
	@Override
	public void addToolTips(List aList, ItemStack aStack, boolean aF3_H) {
		super.addToolTips(aList, aStack, aF3_H);
//		aList.add(Chat.DRED		+ LH.get(LH.HAZARD_CONTACT) + " (" + LH.get(LH.FACE_FRONT) + ")");
	}
	
	@Override
	public ITexture getTexture2(Block aBlock, int aRenderPass, byte aSide, boolean[] aShouldSideBeRendered) {
		if (!aShouldSideBeRendered[aSide]) return null;
		int aIndex = aSide==mFacing?0:aSide==OPPOSITES[mFacing]?1:2;
		return BlockTextureMulti.get(BlockTextureDefault.get(sColoreds[aIndex], mRGBa), BlockTextureDefault.get((mActivity.mState>0?sOverlaysActive:sOverlays)[aIndex]));
	}
	
	// Icons
	public static IIconContainer sColoreds[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/lasers/laser_flux/colored/front"),
		new Textures.BlockIcons.CustomIcon("machines/lasers/laser_flux/colored/back"),
		new Textures.BlockIcons.CustomIcon("machines/lasers/laser_flux/colored/side"),
	}, sOverlays[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/lasers/laser_flux/overlay/front"),
		new Textures.BlockIcons.CustomIcon("machines/lasers/laser_flux/overlay/back"),
		new Textures.BlockIcons.CustomIcon("machines/lasers/laser_flux/overlay/side"),
	}, sOverlaysActive[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/lasers/laser_flux/overlay_active/front"),
		new Textures.BlockIcons.CustomIcon("machines/lasers/laser_flux/overlay_active/back"),
		new Textures.BlockIcons.CustomIcon("machines/lasers/laser_flux/overlay_active/side"),
	};
	
	@Override public String getTileEntityName() {return "gt.multitileentity.laser.laser_flux";}
}