package gregapi.worldgen;

import static gregapi.data.CS.*;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import gregapi.block.IBlockExtendedMetaData;
import gregapi.block.IBlockPlacable;
import gregapi.code.ItemStackContainer;
import gregapi.data.CS.BlocksGT;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/**
 * @author Gregorius Techneticies
 */
public class WorldgenStone extends WorldgenBlob {
	public WorldgenStone(String aName, boolean aDefault, Block aBlock, int aBlockMeta, int aAmount, int aSize, int aProbability, int aMinY, int aMaxY, Collection<String> aBiomeList, boolean aAllowToGenerateinVoid, List... aLists) {
		super(aName, aDefault, aBlock, aBlockMeta, aAmount, aSize, aProbability, aMinY, aMaxY, aBiomeList, aAllowToGenerateinVoid, aLists);
	}
	
	@Override
	public boolean tryPlaceStuff(World aWorld, int aX, int aY, int aZ, Random aRandom) {
		Block tTargetedBlock = aWorld.getBlock(aX, aY, aZ);
		if (tTargetedBlock == NB || tTargetedBlock.isAir(aWorld, aX, aY, aZ)) {
			return mAllowToGenerateinVoid && aWorld.setBlock(aX, aY, aZ, mBlock, mBlockMeta, 0);
		}
		if (tTargetedBlock instanceof IBlockExtendedMetaData) {
			return overrideBlock((IBlockExtendedMetaData)tTargetedBlock, aWorld, aX, aY, aZ);
		}
		return (tTargetedBlock.isReplaceableOreGen(aWorld, aX, aY, aZ, Blocks.stone) || tTargetedBlock.isReplaceableOreGen(aWorld, aX, aY, aZ, Blocks.end_stone) || tTargetedBlock.isReplaceableOreGen(aWorld, aX, aY, aZ, Blocks.netherrack)) && aWorld.setBlock(aX, aY, aZ, mBlock, mBlockMeta, 0);
	}
	
	private boolean overrideBlock(IBlockExtendedMetaData aBlock, World aWorld, int aX, int aY, int aZ) {
		if (!BlocksGT.stoneOverridable.contains(aBlock)) return F;
		short aID = aBlock.getExtendedMetaData(aWorld, aX, aY, aZ);
		IBlockPlacable tBlock = null;
		if (BlocksGT.stoneToNormalOres.values().contains(aBlock)) {
			tBlock = BlocksGT.stoneToNormalOres.get(new ItemStackContainer(mBlock, 1, mBlockMeta));
		} else if (BlocksGT.stoneToSmallOres.values().contains(aBlock)) {
			tBlock = BlocksGT.stoneToSmallOres.get(new ItemStackContainer(mBlock, 1, mBlockMeta));
		} else if (BlocksGT.stoneToBrokenOres.values().contains(aBlock)) {
			tBlock = BlocksGT.stoneToBrokenOres.get(new ItemStackContainer(mBlock, 1, mBlockMeta));
		}
		return tBlock != null && tBlock.placeBlock(aWorld, aX, aY, aZ, SIDE_ANY, aID, null, F, T);
	}
}