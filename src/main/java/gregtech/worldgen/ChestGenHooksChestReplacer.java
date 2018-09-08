package gregtech.worldgen;

import static gregapi.data.CS.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.util.UT;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

/**
 * @author Gregorius Techneticies
 */
public class ChestGenHooksChestReplacer extends ChestGenHooks {
	public final ChestGenHooks mHookToReplaceChestsOf;
	public final String mCategory;
	
	public ChestGenHooksChestReplacer(String aCategory) {
		super(aCategory);
		mCategory = aCategory;
		mHookToReplaceChestsOf = ChestGenHooks.getInfo(aCategory);
		try {
			Field tField = ChestGenHooks.class.getDeclaredField("chestInfo");
			tField.setAccessible(T);
			((HashMap)tField.get(null)).put(aCategory, this);
		} catch(Throwable e) {
			e.printStackTrace(ERR);
		}
	}
	
	@Override
	public WeightedRandomChestContent[] getItems(Random aRandom) {
		WeightedRandomChestContent[] rReturn = mHookToReplaceChestsOf.getItems(aRandom);
		if (GAPI.mStartedServerStarted < 1 || aRandom == RNGSUS) return rReturn;
		for (int i = 0; i < rReturn.length; i++) rReturn[i] = new WeightedRandomChestContentChestReplacer(rReturn[i], mCategory);
		return rReturn;
	}
	
	@Override public void addItem(WeightedRandomChestContent aItem) {mHookToReplaceChestsOf.addItem(aItem);}
	@Override public void removeItem(ItemStack aStack) {mHookToReplaceChestsOf.removeItem(aStack);}
	@Override public int getCount(Random aRandom) {return mHookToReplaceChestsOf.getCount(aRandom);}
	@Override public ItemStack getOneItem(Random aRandom) {return mHookToReplaceChestsOf.getOneItem(aRandom);}
	@Override public int getMin() {return mHookToReplaceChestsOf.getMin();}
	@Override public int getMax() {return mHookToReplaceChestsOf.getMax();}
	@Override public void setMin(int aValue) {mHookToReplaceChestsOf.setMin(aValue);}
	@Override public void setMax(int aValue) {mHookToReplaceChestsOf.setMax(aValue);}
	
	public static class WeightedRandomChestContentChestReplacer extends WeightedRandomChestContent {
		public final WeightedRandomChestContent mContent;
		public final String mCategory;
		
		public WeightedRandomChestContentChestReplacer(WeightedRandomChestContent aContent, String aCategory) {
			super(aContent.theItemId, aContent.theMinimumChanceToGenerateItem, aContent.theMaximumChanceToGenerateItem, aContent.itemWeight);
			mCategory = aCategory;
			mContent = aContent;
		}
		
		@Override
		protected ItemStack[] generateChestContent(Random aRandom, IInventory aInventory) {
			if (aInventory.getClass() != TileEntityChest.class || ((TileEntityChest)aInventory).getWorldObj() == null || Blocks.chest != ((TileEntityChest)aInventory).getWorldObj().getBlock(((TileEntityChest)aInventory).xCoord, ((TileEntityChest)aInventory).yCoord, ((TileEntityChest)aInventory).zCoord)) return generateChestContent2(aRandom, aInventory);
			MultiTileEntityRegistry tRegistry = MultiTileEntityRegistry.getRegistry("gt.multitileentity");
			if (tRegistry == null) return generateChestContent2(aRandom, aInventory);
			tRegistry.mBlock.placeBlock(((TileEntityChest)aInventory).getWorldObj(), ((TileEntityChest)aInventory).xCoord, ((TileEntityChest)aInventory).yCoord, ((TileEntityChest)aInventory).zCoord, SIDE_UNKNOWN, (short)32745, UT.NBT.make(null, NBT_FACING, VALIDATE_HORIZONTAL[((TileEntityChest)aInventory).getWorldObj().getBlockMetadata(((TileEntityChest)aInventory).xCoord, ((TileEntityChest)aInventory).yCoord, ((TileEntityChest)aInventory).zCoord)], "gt.dungeonloot", mCategory), T, T);
			return ZL_IS;
		}
		
		protected ItemStack[] generateChestContent2(Random aRandom, IInventory aInventory) {
			try {
				Method tMethod = mContent.getClass().getDeclaredMethod("generateChestContent", Random.class, IInventory.class);
				tMethod.setAccessible(T);
				return (ItemStack[])tMethod.invoke(mContent, aRandom, aInventory);
			} catch(Throwable e) {
				e.printStackTrace(ERR);
			}
			return super.generateChestContent(aRandom, aInventory);
		}
	}
}