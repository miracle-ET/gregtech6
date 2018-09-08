package gregapi.cover.covers;

import static gregapi.data.CS.*;

import gregapi.code.TagData;
import gregapi.cover.CoverData;
import gregapi.render.BlockTextureDefault;
import gregapi.render.BlockTextureMulti;
import gregapi.render.ITexture;
import gregapi.tileentity.energy.ITileEntityEnergyDataCapacitor;
import gregapi.util.UT;
import net.minecraft.entity.Entity;

/**
 * @author Gregorius Techneticies
 */
public class CoverDisplayEnergy extends AbstractCoverAttachmentDisplay {
	@Override public boolean interceptCoverPlacement(byte aCoverSide, CoverData aData, Entity aPlayer) {return !(aData.mTileEntity.canTick() && aData.mTileEntity instanceof ITileEntityEnergyDataCapacitor);}
	
	@Override
	public void onTickPost(byte aSide, CoverData aData, long aTimer, boolean aIsServerSide, boolean aReceivedBlockUpdate, boolean aReceivedInventoryUpdate) {
		if (aIsServerSide && aData.mTileEntity instanceof ITileEntityEnergyDataCapacitor && !((ITileEntityEnergyDataCapacitor)aData.mTileEntity).getEnergyCapacitorTypes(aSide).isEmpty()) {
			TagData tEnergyType = ((ITileEntityEnergyDataCapacitor)aData.mTileEntity).getEnergyCapacitorTypes(aSide).iterator().next();
			long tStored = ((ITileEntityEnergyDataCapacitor)aData.mTileEntity).getEnergyStored(tEnergyType, aSide), tCapacity = ((ITileEntityEnergyDataCapacitor)aData.mTileEntity).getEnergyCapacity(tEnergyType, aSide);
			aData.visual(aSide, (short)(tStored <= 0 || tCapacity <= 0 ? 0 : tStored >= tCapacity ? 10 : 9-(int)Math.max(0, Math.min(8, ((tCapacity-tStored)*9L) / tCapacity))));
		}
	}
	
	@Override public ITexture getCoverTextureSurface(byte aSide, CoverData aData) {return BlockTextureMulti.get(sTexturesBase, sTextures[(int)UT.Code.bind_(0, 10, aData.mVisuals[aSide])]);}
	@Override public ITexture getCoverTextureAttachment(byte aSide, CoverData aData, byte aTextureSide) {return aSide != aTextureSide ? sTextureBackground : BlockTextureMulti.get(sTextureBackground, getCoverTextureSurface(aSide, aData));}
	@Override public ITexture getCoverTextureHolder(byte aSide, CoverData aData, byte aTextureSide) {return sTextureBackground;}
	@Override public boolean showsConnectorFront(byte aCoverSide, CoverData aData) {return F;}
	
	public static final ITexture[] sTextures = new ITexture[] {
		  BlockTextureDefault.get("machines/covers/energydisplay/0", T)
		, BlockTextureDefault.get("machines/covers/energydisplay/1", T)
		, BlockTextureDefault.get("machines/covers/energydisplay/2", T)
		, BlockTextureDefault.get("machines/covers/energydisplay/3", T)
		, BlockTextureDefault.get("machines/covers/energydisplay/4", T)
		, BlockTextureDefault.get("machines/covers/energydisplay/5", T)
		, BlockTextureDefault.get("machines/covers/energydisplay/6", T)
		, BlockTextureDefault.get("machines/covers/energydisplay/7", T)
		, BlockTextureDefault.get("machines/covers/energydisplay/8", T)
		, BlockTextureDefault.get("machines/covers/energydisplay/9", T)
		, BlockTextureDefault.get("machines/covers/energydisplay/10", T)
	};
	
	public static final ITexture sTexturesBase = BlockTextureDefault.get("machines/covers/energydisplay/underlay");
	public static final ITexture sTextureBackground = BlockTextureDefault.get("machines/covers/energydisplay/base");
}