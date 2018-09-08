package gregapi.block.behaviors;

import static gregapi.data.CS.*;

import java.util.ArrayList;

import gregapi.block.prefixblock.PrefixBlock;
import gregapi.block.prefixblock.PrefixBlockTileEntity;
import gregapi.code.ArrayListNoNulls;
import gregapi.util.ST;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author Gregorius Techneticies
 */
public class Drops {
	private final Item mDropNormal, mDropSilkTouch;
	
	public Drops(Item  aDropNormal) {this(aDropNormal, aDropNormal);}
	public Drops(Block aDropNormal) {this(Item.getItemFromBlock(aDropNormal));}
	public Drops(Block aDropNormal, Block aDropSilkTouch) {this(Item.getItemFromBlock(aDropNormal), Item.getItemFromBlock(aDropSilkTouch));}
	public Drops(Item  aDropNormal, Block aDropSilkTouch) {this(aDropNormal, Item.getItemFromBlock(aDropSilkTouch));}
	public Drops(Block aDropNormal, Item  aDropSilkTouch) {this(Item.getItemFromBlock(aDropNormal), aDropSilkTouch);}
	
	public Drops(Item aDropNormal, Item aDropSilkTouch) {
		mDropNormal = aDropNormal;
		mDropSilkTouch = aDropSilkTouch;
	}
	
	public ArrayList<ItemStack> getDrops(PrefixBlock aBlock, World aWorld, int aX, int aY, int aZ, int aFortune, boolean aSilkTouch) {
	    TileEntity aTileEntity = aWorld.getTileEntity(aX, aY, aZ);
		if (aTileEntity == null) {
			aTileEntity = PrefixBlock.TEMP_TILEENTITY.get();
    		if (aTileEntity == null || aTileEntity.xCoord != aX || aTileEntity.yCoord != aY || aTileEntity.zCoord != aZ) {
    	        return getDrops(aBlock, aWorld, aX, aY, aZ, (short)0, null, 0, F);
    		}
		}
        return getDrops(aBlock, aWorld, aX, aY, aZ, aBlock.getMetaDataValue(aTileEntity), aTileEntity, aFortune, aSilkTouch);
    }
	
	public ArrayList<ItemStack> getDrops(PrefixBlock aBlock, World aWorld, int aX, int aY, int aZ, short aMetaData, TileEntity aTileEntity, int aFortune, boolean aSilkTouch) {
	    ArrayListNoNulls<ItemStack> rList = new ArrayListNoNulls();
	    rList.add(ST.make(aSilkTouch?mDropSilkTouch:mDropNormal, 1, aMetaData, aTileEntity instanceof PrefixBlockTileEntity?((PrefixBlockTileEntity)aTileEntity).mItemNBT:null));
        return rList;
    }
}