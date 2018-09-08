package gregtech.tileentity.energy;

import static gregapi.data.CS.*;

import gregapi.data.LH;
import gregapi.old.Textures;
import gregapi.render.BlockTextureDefault;
import gregapi.render.BlockTextureMulti;
import gregapi.render.IIconContainer;
import gregapi.render.ITexture;
import gregapi.tileentity.energy.ITileEntityEnergyElectricityAcceptor;
import gregapi.tileentity.energy.TileEntityBase10EnergyConverter;
import gregapi.tileentity.machines.ITileEntityAdjacentOnOff;
import net.minecraft.block.Block;

public class MultiTileEntityQuantumEnergizerLaser extends TileEntityBase10EnergyConverter implements ITileEntityEnergyElectricityAcceptor, ITileEntityAdjacentOnOff {
	@Override public boolean isInput (byte aSide) {return mFacing == OPPOSITES[aSide];}
	@Override public boolean isOutput(byte aSide) {return mFacing == aSide;}
	@Override public String getLocalisedInputSide () {return LH.get(LH.FACE_BACK);}
	@Override public String getLocalisedOutputSide() {return LH.get(LH.FACE_FRONT);}
	
	@Override
	public ITexture getTexture2(Block aBlock, int aRenderPass, byte aSide, boolean[] aShouldSideBeRendered) {
		if (!aShouldSideBeRendered[aSide]) return null;
		int aIndex = aSide==mFacing?0:aSide==OPPOSITES[mFacing]?1:2;
		return BlockTextureMulti.get(BlockTextureDefault.get(sColoreds[aIndex], mRGBa), BlockTextureDefault.get((mActivity.mState>0?sOverlaysActive:sOverlays)[aIndex]));
	}
	
	// Icons
	public static IIconContainer sColoreds[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/quantumenergizer/quantum_laser/colored/front"),
		new Textures.BlockIcons.CustomIcon("machines/quantumenergizer/quantum_laser/colored/back"),
		new Textures.BlockIcons.CustomIcon("machines/quantumenergizer/quantum_laser/colored/side"),
	}, sOverlays[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/quantumenergizer/quantum_laser/overlay/front"),
		new Textures.BlockIcons.CustomIcon("machines/quantumenergizer/quantum_laser/overlay/back"),
		new Textures.BlockIcons.CustomIcon("machines/quantumenergizer/quantum_laser/overlay/side"),
	}, sOverlaysActive[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/quantumenergizer/quantum_laser/overlay_active/front"),
		new Textures.BlockIcons.CustomIcon("machines/quantumenergizer/quantum_laser/overlay_active/back"),
		new Textures.BlockIcons.CustomIcon("machines/quantumenergizer/quantum_laser/overlay_active/side"),
	};
	
	@Override public String getTileEntityName() {return "gt.multitileentity.quantumenergizer.quantum_laser";}
}