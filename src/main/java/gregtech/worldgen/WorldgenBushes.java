package gregtech.worldgen;

import static gregapi.data.CS.*;

import java.util.List;
import java.util.Random;
import java.util.Set;

import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.code.ItemStackContainer;
import gregapi.data.CS.BushesGT;
import gregapi.data.IL;
import gregapi.util.ST;
import gregapi.util.UT;
import gregapi.util.WD;
import gregapi.worldgen.WorldgenObject;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

/**
 * @author Gregorius Techneticies
 */
public class WorldgenBushes extends WorldgenObject {
	public WorldgenBushes(String aName, boolean aDefault, List... aLists) {
		super(aName, aDefault, aLists);
	}
	
	@Override
	public boolean generate(World aWorld, Chunk aChunk, int aDimType, int aMinX, int aMinZ, int aMaxX, int aMaxZ, Random aRandom, BiomeGenBase[][] aBiomes, Set<String> aBiomeNames) {
		if (aRandom.nextInt(4) != 0 || checkForMajorWorldgen(aWorld, aMinX, aMinZ, aMaxX, aMaxZ)) return F;
		boolean temp = T;
		for (String tName : aBiomeNames) if (BIOMES_PLAINS.contains(tName) || BIOMES_WOODS.contains(tName)) {temp = F; break;}
		if (temp) return F;
		MultiTileEntityRegistry tRegistry = MultiTileEntityRegistry.getRegistry("gt.multitileentity");
		if (tRegistry == null) return F;
		int tX = aMinX + aRandom.nextInt(16), tZ = aMinZ + aRandom.nextInt(16);
		for (int tY = aWorld.provider.hasNoSky ? 80 : aWorld.getHeight()-50; tY > 0; tY--) {
			Block tContact = aChunk.getBlock(tX&15, tY, tZ&15);
			if (tContact == NB || tContact.isAir(aWorld, tX, tY, tZ)) {temp = T; continue;}
			if (tContact != Blocks.grass && tContact != Blocks.dirt) {temp = F; continue;}
			if (!temp || !WD.easyRep(aWorld, tX, tY+1, tZ)) return F;
			if (tContact == Blocks.grass) WD.set(aChunk, tX-aMinX, tY, tZ-aMinZ, Blocks.dirt, 0);
			
			int tStage = aRandom.nextInt(4);
			ItemStack tBerry = UT.Code.select(new ItemStackContainer(IL.Food_Candleberry.get(1)), BushesGT.MAP.keySet().toArray(ZL_ISC)).toStack();
			
			tRegistry.mBlock.placeBlock(aWorld, tX  , tY+1, tZ  , SIDE_UNKNOWN, (short)32759, ST.save(UT.NBT.make(null, NBT_FACING, SIDE_UNDEFINED, NBT_STATE, tStage), NBT_VALUE, tBerry), T, T);
			
			if (WD.easyRep(aWorld, tX+1, tY+1, tZ  )) tRegistry.mBlock.placeBlock(aWorld, tX+1, tY+1, tZ  , SIDE_UNKNOWN, (short)32759, ST.save(UT.NBT.make(null, NBT_FACING, SIDE_X_NEG, NBT_STATE, tStage), NBT_VALUE, tBerry), T, T);
			if (WD.easyRep(aWorld, tX-1, tY+1, tZ  )) tRegistry.mBlock.placeBlock(aWorld, tX-1, tY+1, tZ  , SIDE_UNKNOWN, (short)32759, ST.save(UT.NBT.make(null, NBT_FACING, SIDE_X_POS, NBT_STATE, tStage), NBT_VALUE, tBerry), T, T);
			if (WD.easyRep(aWorld, tX  , tY+1, tZ+1)) tRegistry.mBlock.placeBlock(aWorld, tX  , tY+1, tZ+1, SIDE_UNKNOWN, (short)32759, ST.save(UT.NBT.make(null, NBT_FACING, SIDE_Z_NEG, NBT_STATE, tStage), NBT_VALUE, tBerry), T, T);
			if (WD.easyRep(aWorld, tX  , tY+1, tZ-1)) tRegistry.mBlock.placeBlock(aWorld, tX  , tY+1, tZ-1, SIDE_UNKNOWN, (short)32759, ST.save(UT.NBT.make(null, NBT_FACING, SIDE_Z_POS, NBT_STATE, tStage), NBT_VALUE, tBerry), T, T);
			if (WD.easyRep(aWorld, tX  , tY+2, tZ  )) tRegistry.mBlock.placeBlock(aWorld, tX  , tY+2, tZ  , SIDE_UNKNOWN, (short)32759, ST.save(UT.NBT.make(null, NBT_FACING, SIDE_Y_NEG, NBT_STATE, tStage), NBT_VALUE, tBerry), T, T);
			return T;
		}
		return T;
	}
}