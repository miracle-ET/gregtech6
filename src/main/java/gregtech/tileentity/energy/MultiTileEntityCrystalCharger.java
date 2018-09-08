package gregtech.tileentity.energy;

import gregapi.old.Textures;
import gregapi.render.BlockTextureDefault;
import gregapi.render.BlockTextureMulti;
import gregapi.render.IIconContainer;
import gregapi.render.ITexture;
import gregapi.tileentity.energy.ITileEntityEnergyElectricityAcceptor;
import gregapi.tileentity.energy.TileEntityBase10EnergyBatBox;
import net.minecraft.block.Block;

public class MultiTileEntityCrystalCharger extends TileEntityBase10EnergyBatBox implements ITileEntityEnergyElectricityAcceptor {
	@Override
	public ITexture getTexture2(Block aBlock, int aRenderPass, byte aSide, boolean[] aShouldSideBeRendered) {
		if (!aShouldSideBeRendered[aSide]) return null;
		return BlockTextureMulti.get(BlockTextureDefault.get(sColoreds[aSide==mFacing?0:1], mRGBa), BlockTextureDefault.get(sOverlays[mActiveState][aSide==mFacing?0:1]));
	}
	
	// Icons
	private static IIconContainer sColoreds[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/energystorages/crystal_laser/colored/front"),
		new Textures.BlockIcons.CustomIcon("machines/energystorages/crystal_laser/colored/side"),
	}, sOverlays[][] = new IIconContainer[][] {{
		new Textures.BlockIcons.CustomIcon("machines/energystorages/crystal_laser/overlay/front"),
		new Textures.BlockIcons.CustomIcon("machines/energystorages/crystal_laser/overlay/side"),
	}, {
		new Textures.BlockIcons.CustomIcon("machines/energystorages/crystal_laser/overlay_active/front"),
		new Textures.BlockIcons.CustomIcon("machines/energystorages/crystal_laser/overlay_active/side"),
	}, {
		new Textures.BlockIcons.CustomIcon("machines/energystorages/crystal_laser/overlay_blinking/front"),
		new Textures.BlockIcons.CustomIcon("machines/energystorages/crystal_laser/overlay_blinking/side"),
	}};
	
	@Override public String getTileEntityName() {return "gt.multitileentity.energystorages.crystal_laser";}
}