package gregapi.tileentity.misc;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.block.multitileentity.IMultiTileEntity.IMTE_GetSubItems;
import gregapi.block.multitileentity.IMultiTileEntity.IMTE_IsWood;
import gregapi.block.multitileentity.MultiTileEntityBlockInternal;
import gregapi.data.CS.BlocksGT;
import gregapi.network.INetworkHandler;
import gregapi.network.IPacket;
import gregapi.tileentity.ITileEntityTreeHole;
import gregapi.tileentity.base.TileEntityBase09FacingSingle;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * @author Gregorius Techneticies
 */
public abstract class MultiTileEntityTreeHole extends TileEntityBase09FacingSingle implements ITileEntityTreeHole, IMTE_GetSubItems, IMTE_IsWood {
	public boolean mHasResin = F;
	
	@Override
	public void readFromNBT2(NBTTagCompound aNBT) {
		super.readFromNBT2(aNBT);
		if (aNBT.hasKey(NBT_ACTIVE)) mHasResin = aNBT.getBoolean(NBT_ACTIVE);
	}
	
	@Override
	public void writeToNBT2(NBTTagCompound aNBT) {
		super.writeToNBT2(aNBT);
		UT.NBT.setBoolean(aNBT, NBT_ACTIVE, mHasResin);
	}
	
	@Override
	public NBTTagCompound writeItemNBT2(NBTTagCompound aNBT) {
		super.writeItemNBT2(aNBT);
		UT.NBT.setBoolean(aNBT, NBT_ACTIVE, mHasResin);
		return aNBT;
	}
	
	@Override
	public void addToolTips(List aList, ItemStack aStack, boolean aF3_H) {
		// No Tooltips for this
	}
	
	@Override
	public long onToolClick2(String aTool, long aRemainingDurability, long aQuality, Entity aPlayer, List<String> aChatReturn, IInventory aPlayerInventory, boolean aSneaking, ItemStack aStack, byte aSide, float aHitX, float aHitY, float aHitZ) {
		return 0;
	}
	
	@Override
	public boolean onBlockActivated3(EntityPlayer aPlayer, byte aSide, float aHitX, float aHitY, float aHitZ) {
		if (aSide != mFacing) return F;
		ItemStack aStack = aPlayer.getCurrentEquippedItem();
		if (aStack != null && aStack.getItem() instanceof ItemBlock) return F;
		if (isServerSide() && hasResin(aSide)) {
			ItemStack tResin = getResinItem(aSide), tStack = UT.Fluids.fillFluidContainer(getResinFluid(aSide), ST.amount(1, aStack), T, T, T, T);
			if ((tStack != null || tResin != null) && extractResin(aSide)) {
				if (tResin != null) {
					UT.Inventories.addStackToPlayerInventoryOrDrop(aPlayer, tResin, T);
				}
				assert aStack != null;
				if (tStack != null) {
					aStack.stackSize--;
					UT.Inventories.addStackToPlayerInventoryOrDrop(aPlayer, tStack, T);
				}
			}
			return T;
		}
		return T;
	}
	
	@Override
	public IPacket getClientDataPacket(boolean aSendAll) {
		return getClientDataPacketByte(aSendAll, (byte)((mFacing&7) | (mHasResin?8:0)));
	}
	
	@Override
	public boolean receiveDataByte(byte aData, INetworkHandler aNetworkHandler) {
		mHasResin = ((aData&8)!=0);
		mFacing = (byte)(aData&7);
		return T;
	}
	
	@Override public boolean unpaint() {return F;}
	@Override public boolean isPainted() {return F;}
	@Override public boolean paint(int aRGB) {return F;}
	@Override public int getPaint() {return UNCOLORED;}
	@Override public boolean canRecolorItem(ItemStack aStack) {return F;}
	@Override public boolean canDecolorItem(ItemStack aStack) {return F;}
	@Override public boolean recolorItem(ItemStack aStack, int aRGB) {return F;}
	@Override public boolean decolorItem(ItemStack aStack) {return F;}
	@Override public String getFacingTool() {return null;}
	@Override public boolean isWood() {return T;}
	@Override public boolean hasResin(byte aSide) {return aSide == mFacing && mHasResin;}
	@Override public boolean extractResin(byte aSide) {if (!hasResin(aSide)) return F; mHasResin = F; updateClientData(); return T;}
	@Override public float getExplosionResistance() {return BlocksGT.LogA.getExplosionResistance(0);}
	@Override public int getFireSpreadSpeed(byte aSide, boolean aDefault) {return 300;}
	@Override public int getFlammability(byte aSide, boolean aDefault) {return 300;}
	@Override public boolean allowCovers(byte aSide) {return F;}
	@Override public byte getDefaultSide() {return SIDE_BACK;}
	@Override public boolean[] getValidSides() {return SIDES_HORIZONTAL;}
	@Override public boolean getSubItems(MultiTileEntityBlockInternal aBlock, Item aItem, CreativeTabs aTab, List aList, short aID) {return F;}
	@Override public boolean canDrop(int aInventorySlot) {return F;}
}