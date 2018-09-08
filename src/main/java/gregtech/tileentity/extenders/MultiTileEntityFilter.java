package gregtech.tileentity.extenders;

import static gregapi.data.CS.*;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregapi.data.IL;
import gregapi.gui.ContainerClient;
import gregapi.gui.ContainerCommon;
import gregapi.gui.Slot_Holo;
import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;

/**
 * @author Gregorius Techneticies
 * 
 * An example implementation of a Miniature Nether Portal with my MultiTileEntity System.
 */
public class MultiTileEntityFilter extends MultiTileEntityExtender {
	public ItemStack[] mFilter = new ItemStack[54];
	
	@Override
	public void readFromNBT2(NBTTagCompound aNBT) {
		super.readFromNBT2(aNBT);
		for (int i = 0; i < mFilter.length; i++) mFilter[i] = ST.load(aNBT, NBT_INV_FILTER+"."+i);
	}
	
	@Override
	public void writeToNBT2(NBTTagCompound aNBT) {
		super.writeToNBT2(aNBT);
		for (int i = 0; i < mFilter.length; i++) ST.save(aNBT, NBT_INV_FILTER+"."+i, mFilter[i]);
	}
	
	@Override
	public NBTTagCompound writeItemNBT2(NBTTagCompound aNBT) {
		for (int i = 0; i < mFilter.length; i++) ST.save(aNBT, NBT_INV_FILTER+"."+i, mFilter[i]);
		return super.writeItemNBT2(aNBT);
	}
	
	@Override public Object getGUIClient2(int aGUIID, EntityPlayer aPlayer) {return new MultiTileEntityGUIClientFilter(aPlayer.inventory, this);}
	@Override public Object getGUIServer2(int aGUIID, EntityPlayer aPlayer) {return new MultiTileEntityGUICommonFilter(aPlayer.inventory, this);}
	@Override public int getSizeInventoryGUI() {return mFilter==null?0:mFilter.length;}
	@Override public ItemStack getStackInSlotGUI(int aSlot) {return mFilter[aSlot];}
	@Override public ItemStack decrStackSizeGUI(int aSlot, int aDecrement) {mInventoryChanged = T; if (mFilter[aSlot] != null) {if (mFilter[aSlot].stackSize <= aDecrement) {ItemStack tStack = mFilter[aSlot]; mFilter[aSlot] = null; return tStack;} ItemStack rStack = mFilter[aSlot].splitStack(aDecrement); if (mFilter[aSlot].stackSize <= 0) mFilter[aSlot] = null; return rStack;} return null;}
	@Override public ItemStack getStackInSlotOnClosingGUI(int aSlot) {ItemStack rStack = mFilter[aSlot]; mFilter[aSlot] = null; return rStack;}
	@Override public void setInventorySlotContentsGUI(int aSlot, ItemStack aStack) {mInventoryChanged = T; mFilter[aSlot] = OM.get(aStack);}
	@Override public int getInventoryStackLimitGUI(int aSlot) {return 1;}
	
	@Override public String getTileEntityName() {return "gt.multitileentity.filter";}
	
	public boolean allowInput(ItemStack aStack) {
		for (ItemStack tStack : mFilter) if (ST.valid(tStack) && ST.equal_(tStack, aStack, !tStack.hasTagCompound())) return T;
		return F;
	}
	public boolean allowInput(FluidStack aFluid) {
		return aFluid != null && allowInput(aFluid.getFluid());
	}
	public boolean allowInput(Fluid aFluid) {
		if (aFluid != null) for (ItemStack tStack : mFilter) if (IL.Display_Fluid.equal(tStack, T, T) && UT.Fluids.id(aFluid) == ST.meta(tStack)) return T;
		return F;
	}
	
	@Override
	public boolean onBlockActivated3(EntityPlayer aPlayer, byte aSide, float aHitX, float aHitY, float aHitZ) {
		if (isServerSide() && isUseableByPlayerGUI(aPlayer)) openGUI(aPlayer);
		return T;
	}
	
	@Override
	public boolean isItemValidForSlot(int aSlot, ItemStack aStack) {
		if ((mModes & MODE_INV) != 0 && ST.valid(aStack) && (mLastSide == mFacing || allowInput(aStack))) {
			DelegatorTileEntity<TileEntity> tTileEntity = getAdjacentTileEntity(getExtenderTargetSide(mLastSide), F, T);
			if (tTileEntity.mTileEntity instanceof IInventory) return ((IInventory)tTileEntity.mTileEntity).isItemValidForSlot(aSlot, aStack);
		}
		return F;
	}
	
	@Override
	public boolean canInsertItem2(int aSlot, ItemStack aStack, byte aSide) {
		mLastSide = aSide;
		if ((mModes & MODE_INV) != 0 && ST.valid(aStack) && (mLastSide == mFacing || allowInput(aStack))) {
			DelegatorTileEntity<TileEntity> tTileEntity = getAdjacentTileEntity(getExtenderTargetSide(mLastSide), F, T);
			if (tTileEntity.mTileEntity instanceof ISidedInventory) return ((ISidedInventory)tTileEntity.mTileEntity).canInsertItem(aSlot, aStack, tTileEntity.mSideOfTileEntity);
			if (tTileEntity.mTileEntity instanceof IInventory) return T;
		}
		return F;
	}
	
	@Override
	public boolean canExtractItem2(int aSlot, ItemStack aStack, byte aSide) {
		mLastSide = aSide;
		if ((mModes & MODE_INV) != 0 && ST.valid(aStack) && (mLastSide != mFacing || allowInput(aStack))) {
			DelegatorTileEntity<TileEntity> tTileEntity = getAdjacentTileEntity(getExtenderTargetSide(mLastSide), F, T);
			if (tTileEntity.mTileEntity instanceof ISidedInventory) return ((ISidedInventory)tTileEntity.mTileEntity).canExtractItem(aSlot, aStack, tTileEntity.mSideOfTileEntity);
			if (tTileEntity.mTileEntity instanceof IInventory) return T;
		}
		return F;
	}
	
	@Override
	public int fill(ForgeDirection aDirection, FluidStack aFluid, boolean aDoFill) {
		byte aSide = UT.Code.side(aDirection);
		if ((mModes & MODE_TANK) != 0 && (aSide == mFacing || allowInput(aFluid))) {
			if (hasCovers() && SIDES_VALID[aSide] && mCovers.mBehaviours[aSide] != null && mCovers.mBehaviours[aSide].interceptFluidFill(aSide, mCovers, aSide, aFluid)) return 0;
			DelegatorTileEntity<IFluidHandler> tTileEntity = getAdjacentTank(getExtenderTargetSide(aSide), F, T);
			if (tTileEntity.mTileEntity != null) return tTileEntity.mTileEntity.fill(tTileEntity.getForgeSideOfTileEntity(), aFluid, aDoFill);
		}
		return 0;
	}
	@Override
	public FluidStack drain(ForgeDirection aDirection, FluidStack aFluid, boolean aDoDrain) {
		byte aSide = UT.Code.side(aDirection);
		if ((mModes & MODE_TANK) != 0 && (aSide != mFacing || allowInput(aFluid))) {
			if (hasCovers() && SIDES_VALID[aSide] && mCovers.mBehaviours[aSide] != null && mCovers.mBehaviours[aSide].interceptFluidDrain(aSide, mCovers, aSide, aFluid)) return null;
			DelegatorTileEntity<IFluidHandler> tTileEntity = getAdjacentTank(getExtenderTargetSide(aSide), F, T);
			if (tTileEntity.mTileEntity != null) return tTileEntity.mTileEntity.drain(tTileEntity.getForgeSideOfTileEntity(), aFluid, aDoDrain);
		}
		return null;
	}
	@Override
	public FluidStack drain(ForgeDirection aDirection, int aToDrain, boolean aDoDrain) {
		if ((mModes & MODE_TANK) != 0) {
			byte aSide = UT.Code.side(aDirection);
			if (hasCovers() && SIDES_VALID[aSide] && mCovers.mBehaviours[aSide] != null && mCovers.mBehaviours[aSide].interceptFluidDrain(aSide, mCovers, aSide, null)) return null;
			DelegatorTileEntity<IFluidHandler> tTileEntity = getAdjacentTank(getExtenderTargetSide(aSide), F, T);
			if (tTileEntity.mTileEntity != null) return (aSide != mFacing || allowInput(tTileEntity.mTileEntity.drain(tTileEntity.getForgeSideOfTileEntity(), aToDrain, F))) ? tTileEntity.mTileEntity.drain(tTileEntity.getForgeSideOfTileEntity(), aToDrain, aDoDrain) : null;
		}
		return null;
	}
	
	@Override
	public boolean canFill(ForgeDirection aDirection, Fluid aFluid) {
		byte aSide = UT.Code.side(aDirection);
		if ((mModes & MODE_TANK) != 0 && (aSide == mFacing || allowInput(aFluid))) {
			if (hasCovers() && SIDES_VALID[aSide] && mCovers.mBehaviours[aSide] != null && mCovers.mBehaviours[aSide].interceptFluidFill(aSide, mCovers, aSide, UT.Fluids.make(aFluid, 1))) return F;
			DelegatorTileEntity<IFluidHandler> tTileEntity = getAdjacentTank(getExtenderTargetSide(aSide), F, T);
			if (tTileEntity.mTileEntity != null) return tTileEntity.mTileEntity.canFill(tTileEntity.getForgeSideOfTileEntity(), aFluid);
		}
		return F;
	}
	@Override
	public boolean canDrain(ForgeDirection aDirection, Fluid aFluid) {
		byte aSide = UT.Code.side(aDirection);
		if ((mModes & MODE_TANK) != 0 && (aSide != mFacing || allowInput(aFluid))) {
			if (hasCovers() && SIDES_VALID[aSide] && mCovers.mBehaviours[aSide] != null && mCovers.mBehaviours[aSide].interceptFluidDrain(aSide, mCovers, aSide, UT.Fluids.make(aFluid, 1))) return F;
			DelegatorTileEntity<IFluidHandler> tTileEntity = getAdjacentTank(getExtenderTargetSide(aSide), F, T);
			if (tTileEntity.mTileEntity != null) return tTileEntity.mTileEntity.canDrain(tTileEntity.getForgeSideOfTileEntity(), aFluid);
		}
		return F;
	}
	
	public class MultiTileEntityGUICommonFilter extends ContainerCommon {
		public MultiTileEntityGUICommonFilter(InventoryPlayer aInventoryPlayer, MultiTileEntityFilter aTileEntity) {
			super(aInventoryPlayer, aTileEntity);
		}
		
		@Override
		public int addSlots(InventoryPlayer aInventoryPlayer) {
			int tSize = mTileEntity.getSizeInventoryGUI(), tRows = tSize/9 + (tSize%9==0?0:1);
			for (int y = 0, i = 0; y < tRows; y++) for (int x = 0; x < 9 && i < tSize; x++) addSlotToContainer(new Slot_Holo(mTileEntity, i++, 8 + x * 18, 18 + y * 18, T, F, 1));
			return 103+(tRows-4)*18;
		}
		
		@Override public int getSlotCount() {return 0;}
		@Override public int getShiftClickSlotCount() {return 0;}
		
		@Override
		public ItemStack slotClick(int aSlotIndex, int aMouseclick, int aShifthold, EntityPlayer aPlayer) {
			if (aSlotIndex < 0 || aSlotIndex >= mTileEntity.getSizeInventoryGUI()) return super.slotClick(aSlotIndex, aMouseclick, aShifthold, aPlayer);
			
			Slot tSlot = (Slot)inventorySlots.get(aSlotIndex);
			if (tSlot != null) {
				ItemStack tStack = aPlayer.inventory.getItemStack();
				if (tStack == null) {
					tStack = tSlot.getStack();
					if (aMouseclick == 0) {
						tSlot.putStack(null);
					} else {
						if (tStack != null) {
							FluidStack tFluid = UT.Fluids.getFluidForFilledItem(tStack, T);
							if (tFluid != null && (((MultiTileEntityFilter)mTileEntity).mModes & MODE_TANK) != 0) {
								tSlot.putStack(UT.Fluids.display(tFluid.getFluid()));
							} else {
								if (tStack.hasTagCompound()) {
									tStack.setTagCompound(null);
								} else if (!tStack.getItem().getHasSubtypes()) {
									tStack.setItemDamage(W);
								}
							}
						}
					}
				} else {
					FluidStack tFluid = UT.Fluids.getFluidForFilledItem(tStack, T);
					if (tFluid != null && (((MultiTileEntityFilter)mTileEntity).mModes & MODE_INV) == 0) {
						tSlot.putStack(UT.Fluids.display(tFluid.getFluid()));
					} else {
						tSlot.putStack(ST.amount(1, tStack));
					}
				}
			}
			return null;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public class MultiTileEntityGUIClientFilter extends ContainerClient {
		private int mRows;
		
		public MultiTileEntityGUIClientFilter(InventoryPlayer aInventoryPlayer, MultiTileEntityFilter aTileEntity) {
			super(new MultiTileEntityGUICommonFilter(aInventoryPlayer, aTileEntity), RES_PATH_GUI + "machines/Filter.png");
			mRows = mContainer.mTileEntity.getSizeInventoryGUI() / 9 + (mContainer.mTileEntity.getSizeInventoryGUI() % 9 == 0 ? 0 : 1);
			ySize = 114 + mRows * 18;
		}
		
		@Override
		protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
			fontRendererObj.drawString(mContainer.mTileEntity.getInventoryNameGUI(), 8, 6, 4210752);
			fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 94, 4210752);
		}
		
		@Override
		protected void drawGuiContainerBackgroundLayer2(float par1, int par2, int par3) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			int k = (width - xSize) / 2;
			int l = (height - ySize) / 2;
			drawTexturedModalRect(k, l, 0, 0, xSize, mRows * 18 + 17);
			drawTexturedModalRect(k, l + mRows * 18 + 17, 0, 126, xSize, 96);
		}
	}
}