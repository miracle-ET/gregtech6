package gregapi.cover.covers;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.cover.CoverData;
import gregapi.data.LH;
import gregapi.render.BlockTextureDefault;
import gregapi.render.BlockTextureMulti;
import gregapi.render.ITexture;
import gregapi.tileentity.connectors.ITileEntityConnector;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

/**
 * @author Gregorius Techneticies
 */
public class CoverShutter extends AbstractCoverAttachment {
	public CoverShutter() {}
	
	@Override
	public void addToolTips(List aList, ItemStack aStack, boolean aF3_H) {
		super.addToolTips(aList, aStack, aF3_H);
		aList.add(LH.Chat.DGRAY + LH.get(LH.TOOL_TO_TOGGLE_SCREWDRIVER));
	}
	
	@Override
	public long onToolClick(byte aCoverSide, CoverData aData, String aTool, long aRemainingDurability, long aQuality, Entity aPlayer, List<String> aChatReturn, IInventory aPlayerInventory, boolean aSneaking, ItemStack aStack, byte aSideClicked, float aHitX, float aHitY, float aHitZ) {
		if (aTool.equals(TOOL_screwdriver)) {
			aData.visual(aCoverSide, (short)(aData.mVisuals[aCoverSide] == 0 ? 1 : 0));
			if (aChatReturn != null) aChatReturn.add(aData.mVisuals[aCoverSide] == 0 ? "Normal Shutter" : "Inverted Shutter");
			if (aData.mTileEntity instanceof ITileEntityConnector) {
				if ((aData.mVisuals[aCoverSide] == 0) == aData.mStopped) {
					((ITileEntityConnector)aData.mTileEntity).disconnect(aCoverSide, T);
				} else {
					((ITileEntityConnector)aData.mTileEntity).connect(aCoverSide, T);
				}
			}
			return 1000;
		}
		if (aTool.equals(TOOL_magnifyingglass)) {
			if (aChatReturn != null) aChatReturn.add(aData.mVisuals[aCoverSide] == 0 ? "Normal Shutter" : "Inverted Shutter");
			return 1;
		}
		return 0;
	}
	
	@Override
	public void onStoppedUpdate(byte aCoverSide, CoverData aData, boolean aStopped) {
		if (aData.mTileEntity instanceof ITileEntityConnector) {
			if ((aData.mVisuals[aCoverSide] == 0) == aStopped) {
				((ITileEntityConnector)aData.mTileEntity).disconnect(aCoverSide, T);
			} else {
				((ITileEntityConnector)aData.mTileEntity).connect(aCoverSide, T);
			}
		}
	}
	
	@Override public boolean interceptItemInsert(byte aCoverSide, CoverData aData, int aSlot, ItemStack aStack, byte aSide) {return (aData.mVisuals[aCoverSide] == 0) == aData.mStopped;}
	@Override public boolean interceptItemExtract(byte aCoverSide, CoverData aData, int aSlot, ItemStack aStack, byte aSide) {return (aData.mVisuals[aCoverSide] == 0) == aData.mStopped;}
	@Override public boolean interceptFluidFill(byte aCoverSide, CoverData aData, byte aSide, FluidStack aFluidToFill) {return (aData.mVisuals[aCoverSide] == 0) == aData.mStopped;}
	@Override public boolean interceptFluidDrain(byte aCoverSide, CoverData aData, byte aSide, FluidStack aFluidToDrain) {return (aData.mVisuals[aCoverSide] == 0) == aData.mStopped;}
	
	@Override public ITexture getCoverTextureSurface(byte aCoverSide, CoverData aData) {return aData.mVisuals[aCoverSide]==0?sTextureNormal:sTextureInverted;}
	@Override public ITexture getCoverTextureAttachment(byte aCoverSide, CoverData aData, byte aTextureSide) {return ALONG_AXIS[aCoverSide][aTextureSide] ? BlockTextureMulti.get(sTextureBase, aData.mVisuals[aCoverSide]==0?sTextureNormal:sTextureInverted) : sTextureBase;}
	@Override public ITexture getCoverTextureHolder(byte aCoverSide, CoverData aData, byte aTextureSide) {return sTextureBase;}
	@Override public boolean needsVisualsSaved(byte aCoverSide, CoverData aData) {return T;}
	@Override public boolean showsConnectorFront(byte aCoverSide, CoverData aData) {return F;}
	
	public static final ITexture
	sTextureBase = BlockTextureDefault.get("machines/covers/shutter/base"),
	sTextureInverted = BlockTextureDefault.get("machines/covers/shutter/inverted"),
	sTextureNormal = BlockTextureDefault.get("machines/covers/shutter/normal");
}