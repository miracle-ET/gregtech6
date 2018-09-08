package gregtech.tileentity.inventories;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.block.multitileentity.IMultiTileEntity.IMTE_GetSubItems;
import gregapi.block.multitileentity.MultiTileEntityBlockInternal;
import gregapi.block.multitileentity.MultiTileEntityContainer;
import gregapi.data.LH;
import gregapi.data.LH.Chat;
import gregapi.data.TD;
import gregapi.gui.ContainerClientDefault;
import gregapi.gui.ContainerCommonDefault;
import gregapi.old.Textures;
import gregapi.render.BlockTextureDefault;
import gregapi.render.BlockTextureMulti;
import gregapi.render.IIconContainer;
import gregapi.render.ITexture;
import gregapi.tileentity.ITileEntityAdjacentInventoryUpdatable;
import gregapi.tileentity.base.TileEntityBase09FacingSingle;
import gregapi.tileentity.connectors.ITileEntityConnector;
import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.util.UT;
import gregapi.util.WD;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.command.IEntitySelector;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author Gregorius Techneticies
 */
public class MultiTileEntityQueueHopper extends TileEntityBase09FacingSingle implements ITileEntityAdjacentInventoryUpdatable, IMTE_GetSubItems {
	public boolean mCheckNextTick = T, mMovedLastTick = T;
	public byte mMode = 64;
	
	@Override
	public void readFromNBT2(NBTTagCompound aNBT) {
		super.readFromNBT2(aNBT);
		mMode = aNBT.getByte(NBT_MODE);
		if (mMode <= 0) mMode = 64;
	}
	
	@Override
	public void writeToNBT2(NBTTagCompound aNBT) {
		super.writeToNBT2(aNBT);
		if (mMode != 64) aNBT.setByte(NBT_MODE, mMode);
	}
	
	@Override
	public NBTTagCompound writeItemNBT2(NBTTagCompound aNBT) {
		aNBT = super.writeItemNBT2(aNBT);
		if (mMode != 64) aNBT.setByte(NBT_MODE, mMode);
		return aNBT;
	}
	
	static {
		LH.add("gt.multitileentity.hopper.tooltip.1", "Slot Count: ");
		LH.add("gt.multitileentity.hopper.tooltip.2", "Slot Size: ");
	}
	
	@Override
	public void addToolTips(List aList, ItemStack aStack, boolean aF3_H) {
		aList.add(Chat.CYAN		+ LH.get("gt.multitileentity.hopper.tooltip.1") + getSizeInventory());
		aList.add(Chat.CYAN		+ LH.get("gt.multitileentity.hopper.tooltip.2") + mMode);
		aList.add(Chat.DGRAY	+ LH.get(LH.TOOL_TO_TOGGLE_SCREWDRIVER));
		aList.add(Chat.DGRAY	+ LH.get(LH.TOOL_TO_DETAIL_MAGNIFYINGGLASS));
		aList.add(Chat.DGRAY	+ LH.get(LH.TOOL_TO_RESET_SOFT_HAMMER));
		super.addToolTips(aList, aStack, aF3_H);
	}
	
	@Override
	public boolean onBlockActivated3(EntityPlayer aPlayer, byte aSide, float aHitX, float aHitY, float aHitZ) {
		if (isServerSide() && isUseableByPlayerGUI(aPlayer)) openGUI(aPlayer);
		return T;
	}
	
	@Override
	public boolean onPlaced(ItemStack aStack, EntityPlayer aPlayer, MultiTileEntityContainer aMTEContainer, World aWorld, int aX, int aY, int aZ, byte aSide, float aHitX, float aHitY, float aHitZ) {
		super.onPlaced(aStack, aPlayer, aMTEContainer, aWorld, aX, aY, aZ, aSide, aHitX, aHitY, aHitZ);
		if (isServerSide() && SIDES_BOTTOM_HORIZONTAL[mFacing]) {
			DelegatorTileEntity<TileEntity> tDelegator = getAdjacentTileEntity(mFacing);
			if (tDelegator.mTileEntity instanceof ITileEntityConnector && SIDES_VALID[tDelegator.mSideOfTileEntity] && ((ITileEntityConnector)tDelegator.mTileEntity).allowInteraction(aPlayer) && UT.Code.haveOneCommonElement(((ITileEntityConnector)tDelegator.mTileEntity).getConnectorTypes(tDelegator.mSideOfTileEntity), TD.Connectors.ALL_ITEM_TRANSPORT)) {
				((ITileEntityConnector)tDelegator.mTileEntity).connect(tDelegator.mSideOfTileEntity, T);
			}
		}
		return T;
	}
	
	@Override
	public long onToolClick2(String aTool, long aRemainingDurability, long aQuality, Entity aPlayer, List<String> aChatReturn, IInventory aPlayerInventory, boolean aSneaking, ItemStack aStack, byte aSide, float aHitX, float aHitY, float aHitZ) {
		if (isClientSide()) return super.onToolClick2(aTool, aRemainingDurability, aQuality, aPlayer, aChatReturn, aPlayerInventory, aSneaking, aStack, aSide, aHitX, aHitY, aHitZ);
		if (aTool.equals(TOOL_screwdriver)) {
			if (aPlayer != null && aPlayer.isSneaking()) {
				if (--mMode <  1) mMode = 64;
			} else {
				if (++mMode > 64) mMode =  1;
			}
			if (aChatReturn != null) aChatReturn.add("Max Stacksize: " + mMode);
			return 200;
		}
		if (aTool.equals(TOOL_softhammer)) {
			mMode = 64;
			if (aChatReturn != null) aChatReturn.add("Max Stacksize: " + mMode);
			return 10000;
		}
		if (aTool.equals(TOOL_magnifyingglass)) {
			if (aChatReturn != null) aChatReturn.add("Max Stacksize: " + mMode);
			return 1;
		}
		return super.onToolClick2(aTool, aRemainingDurability, aQuality, aPlayer, aChatReturn, aPlayerInventory, aSneaking, aStack, aSide, aHitX, aHitY, aHitZ);
	}
	
	@Override
	public void onTick2(long aTimer, boolean aIsServerSide) {
		super.onTick2(aTimer, aIsServerSide);
		if (aIsServerSide) {
			int tMovedItems = 0;
			if (mMovedLastTick) {
				mMovedLastTick = F;
			} else if ((mInventoryChanged || mCheckNextTick || mBlockUpdated || aTimer % 64 == 32) && !hasRedstoneIncoming()) {
				mCheckNextTick = F;
				if (!SIDES_TOP[mFacing] && !invempty()) {
					DelegatorTileEntity<IInventory> tDelegator = getAdjacentInventory(mFacing);
					if (tDelegator.getBlock() instanceof BlockRailBase) {
						List tList = worldObj.getEntitiesWithinAABBExcludingEntity(null, tDelegator.box(0, 0, 0, 1, 1, 1), IEntitySelector.selectInventories);
						if (tList != null && !tList.isEmpty()) tDelegator = new DelegatorTileEntity(tList.get(0), tDelegator);
					}
					while (tMovedItems < mMode) {
						int tMoved = UT.Inventories.moveOneItemStack(this, tDelegator, mFacing, tDelegator.mSideOfTileEntity, null, F, mMode, 1, mMode-tMovedItems, 1);
						if (tMoved <= 0) break;
						tMovedItems += tMoved;
					}
				}
				DelegatorTileEntity<IInventory> tDelegator = getAdjacentInventory(SIDE_TOP);
				if (tDelegator.getBlock() instanceof BlockRailBase) {
					List tList = worldObj.getEntitiesWithinAABBExcludingEntity(null, tDelegator.box(0, 0, 0, 1, 1, 1), IEntitySelector.selectInventories);
					if (tList != null && !tList.isEmpty()) tDelegator = new DelegatorTileEntity(tList.get(0), tDelegator);
				}
				if (tDelegator.mTileEntity != null) {
					tMovedItems += UT.Inventories.moveOneItemStack(tDelegator.mTileEntity, this, tDelegator.mSideOfTileEntity, SIDE_TOP);
				} else {
					if (!WD.visOpq(tDelegator.getWorld(), tDelegator.getX(), tDelegator.getY(), tDelegator.getZ(), F, T)) {
						if (!slotHas(0)) {
							slot(0, WD.suck(tDelegator.getWorld(), tDelegator.getX(), tDelegator.getY(), tDelegator.getZ()));
							if (slotHas(0)) {
								tMovedItems += slot(0).stackSize;
								updateInventory();
							}
						}
					}
				}
				if (tMovedItems > 0) {
					mMovedLastTick = T;
				}
			}
			
			if (mInventoryChanged) {
				int oMovedItems = -1;
				while (oMovedItems != tMovedItems) {
					oMovedItems = tMovedItems;
					for (int i = 1, j = getSizeInventory(); i < j; i++) {
						tMovedItems += UT.Inventories.moveStackFromSlotAToSlotB(this, this, i-1, i, mMode, 1, mMode, 1);
					}
				}
			}
			if (tMovedItems > 0) {
				mCheckNextTick = T;
				for (byte tSide : ALL_SIDES_BUT_TOP) if (tSide != mFacing) {
					DelegatorTileEntity<TileEntity> tDelegatorUpdate = getAdjacentTileEntity(tSide);
					if (tDelegatorUpdate.mTileEntity instanceof ITileEntityAdjacentInventoryUpdatable) {
						((ITileEntityAdjacentInventoryUpdatable)tDelegatorUpdate.mTileEntity).adjacentInventoryUpdated(tDelegatorUpdate.mSideOfTileEntity, this);
					}
				}
			}
		}
	}
	
	@Override
	public boolean getSubItems(MultiTileEntityBlockInternal aBlock, Item aItem, CreativeTabs aTab, List aList, short aID) {
		return SHOW_HIDDEN_MATERIALS || !mMaterial.mHidden;
	}
	
	@Override public float getSurfaceDistance		(byte aSide) {return 0.0F;}
	@Override public float getSurfaceSize			(byte aSide) {return SIDES_TOP[aSide]?PX_N[0]:PX_N[8];}
	@Override public float getSurfaceSizeAttachable	(byte aSide) {return SIDES_TOP[aSide]?PX_N[2]:PX_N[8];}
	@Override public boolean isSurfaceSolid  		(byte aSide) {return SIDES_TOP[aSide];}
	@Override public boolean isSurfaceOpaque2 		(byte aSide) {return SIDES_TOP[aSide];}
	@Override public boolean isSideSolid2			(byte aSide) {return SIDES_TOP[aSide];}
	@Override public boolean allowCovers			(byte aSide) {return F;}
	
	@Override public int[] getAccessibleSlotsFromSide2(byte aSide) {return new int[] {0, getSizeInventory() - 1};}
	@Override public boolean canInsertItem2(int aSlot, ItemStack aStack, byte aSide) {return aSlot == 0;}
	@Override public boolean canExtractItem2(int aSlot, ItemStack aStack, byte aSide) {return aSlot == getSizeInventory() - 1;}
	@Override public int getInventoryStackLimit() {return mMode;}
	@Override public int getInventoryStackLimitGUI(int aSlot) {return mMode;}
	@Override public boolean canDrop(int aInventorySlot) {return T;}
	
	@Override public void adjacentInventoryUpdated(byte aSide, IInventory aTileEntity) {if (SIDES_TOP[aSide] || aSide == mFacing) mCheckNextTick = T;}
	
	@Override public byte getDefaultSide() {return SIDE_BOTTOM;}
	@Override public boolean[] getValidSides() {return SIDES_VALID;}
	@Override public boolean useSidePlacementRotation		() {return T;}
	@Override public boolean useInversePlacementRotation	() {return T;}
	
	@Override public int getRenderPasses2(Block aBlock, boolean[] aShouldSideBeRendered) {return SIDES_TOP[mFacing] ? 2 : 3;}
	@Override public boolean usesRenderPass2(int aRenderPass, boolean[] aShouldSideBeRendered) {return T;}
	
	@Override
	public boolean setBlockBounds2(Block aBlock, int aRenderPass, boolean[] aShouldSideBeRendered) {
		switch(aRenderPass) {
		case 0: box(aBlock, PX_P[ 0], PX_P[10], PX_P[ 0], PX_N[ 0], PX_N[ 0], PX_N[ 0]); return T;
		case 1: box(aBlock, PX_P[ 4], PX_P[ 4], PX_P[ 4], PX_N[ 4], PX_N[ 6], PX_N[ 4]); return T;
		case 2:
			switch(mFacing) {
			case SIDE_Y_NEG: box(aBlock, PX_P[ 6], PX_P[ 0], PX_P[ 6], PX_N[ 6], PX_N[12], PX_N[ 6]); return T;
			case SIDE_Z_NEG: box(aBlock, PX_P[ 6], PX_P[ 4], PX_P[ 0], PX_N[ 6], PX_N[ 8], PX_N[12]); return T;
			case SIDE_Z_POS: box(aBlock, PX_P[ 6], PX_P[ 4], PX_P[12], PX_N[ 6], PX_N[ 8], PX_N[ 0]); return T;
			case SIDE_X_NEG: box(aBlock, PX_P[ 0], PX_P[ 4], PX_P[ 6], PX_N[12], PX_N[ 8], PX_N[ 6]); return T;
			case SIDE_X_POS: box(aBlock, PX_P[12], PX_P[ 4], PX_P[ 6], PX_N[ 0], PX_N[ 8], PX_N[ 6]); return T;
			}
		}
		return T;
	}
	
	@Override
	public ITexture getTexture2(Block aBlock, int aRenderPass, byte aSide, boolean[] aShouldSideBeRendered) {
		return (aRenderPass == 1 ? !SIDES_TOP[aSide] : aShouldSideBeRendered[aSide] || (aRenderPass == 0 && SIDES_BOTTOM[aSide]) || (aRenderPass == 2 && aSide != mFacing)) ? BlockTextureMulti.get(BlockTextureDefault.get(sColoreds[FACES_TBS[aSide]], mRGBa), BlockTextureDefault.get(sOverlays[FACES_TBS[aSide]])) : null;
	}
	
	// Icons
	public static IIconContainer sColoreds[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/automation/queuehopper/colored/bottom"),
		new Textures.BlockIcons.CustomIcon("machines/automation/queuehopper/colored/top"),
		new Textures.BlockIcons.CustomIcon("machines/automation/queuehopper/colored/side"),
	}, sOverlays[] = new IIconContainer[] {
		new Textures.BlockIcons.CustomIcon("machines/automation/queuehopper/overlay/bottom"),
		new Textures.BlockIcons.CustomIcon("machines/automation/queuehopper/overlay/top"),
		new Textures.BlockIcons.CustomIcon("machines/automation/queuehopper/overlay/side"),
	};
	
	@Override public String getTileEntityName() {return "gt.multitileentity.queuehopper";}
	
	@Override public int getLightOpacity() {return LIGHT_OPACITY_WATER;}
	
	@Override public Object getGUIClient2(int aGUIID, EntityPlayer aPlayer) {return new ContainerClientDefault(aPlayer.inventory, this);}
	@Override public Object getGUIServer2(int aGUIID, EntityPlayer aPlayer) {return new ContainerCommonDefault(aPlayer.inventory, this);}
}