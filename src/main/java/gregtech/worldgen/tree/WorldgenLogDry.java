package gregtech.worldgen.tree;

import static gregapi.data.CS.*;

import java.util.List;
import java.util.Random;
import java.util.Set;

import gregapi.data.CS.BlocksGT;
import gregapi.util.WD;
import gregapi.worldgen.WorldgenObject;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

/**
 * @author Gregorius Techneticies
 */
public class WorldgenLogDry extends WorldgenObject {
	public WorldgenLogDry(String aName, boolean aDefault, List... aLists) {
		super(aName, aDefault, aLists);
	}
	
	@Override
	public boolean generate(World aWorld, Chunk aChunk, int aDimType, int aMinX, int aMinZ, int aMaxX, int aMaxZ, Random aRandom, BiomeGenBase[][] aBiomes, Set<String> aBiomeNames) {
		if (aRandom.nextInt(8) != 0 || checkForMajorWorldgen(aWorld, aMinX, aMinZ, aMaxX, aMaxZ)) return F;
		boolean temp = T;
		for (String tName : aBiomeNames) if (BIOMES_PLAINS.contains(tName) || BIOMES_WOODS.contains(tName) || BIOMES_SAVANNA.contains(tName) || BIOMES_DESERT.contains(tName) || BIOMES_MESA.contains(tName)) {temp = F; break;}
		if (temp) return F;
		int tX = aMinX + aRandom.nextInt(16), tZ = aMinZ + aRandom.nextInt(16);
		for (int tY = aWorld.provider.hasNoSky ? 80 : aWorld.getHeight()-50; tY > 0; tY--) {
			Block tContact = aChunk.getBlock(tX&15, tY, tZ&15);
			if (tContact == NB || tContact.isAir(aWorld, tX, tY, tZ)) continue;
			if (tContact != Blocks.grass && tContact != Blocks.dirt && tContact != Blocks.sand) continue;
			if (!aChunk.getBlock(tX&15, tY+1, tZ&15).isAir(aWorld, tX, tY+1, tZ)) return F;
			switch(aRandom.nextInt(3)) {
			case 0:
				if (aRandom.nextBoolean())	WD.set(aWorld, tX  , tY-1, tZ  , BlocksGT.Log1, PILLARS_Y[0], 2);
											WD.set(aWorld, tX  , tY  , tZ  , BlocksGT.Log1, PILLARS_Y[0], 2);
											WD.set(aWorld, tX  , tY+1, tZ  , BlocksGT.Log1, PILLARS_Y[0], 2);
											WD.set(aWorld, tX  , tY+2, tZ  , BlocksGT.Log1, PILLARS_Y[0], 2);
				if (aRandom.nextBoolean())	WD.set(aWorld, tX  , tY+3, tZ  , BlocksGT.Log1, PILLARS_Y[0], 2);
				return T;
			case 1:
				if (aRandom.nextBoolean())	WD.set(aWorld, tX-2, tY+1, tZ  , BlocksGT.Log1, PILLARS_X[0], 2);
											WD.set(aWorld, tX-1, tY+1, tZ  , BlocksGT.Log1, PILLARS_X[0], 2);
											WD.set(aWorld, tX  , tY+1, tZ  , BlocksGT.Log1, PILLARS_X[0], 2);
											WD.set(aWorld, tX+1, tY+1, tZ  , BlocksGT.Log1, PILLARS_X[0], 2);
				if (aRandom.nextBoolean())	WD.set(aWorld, tX+2, tY+1, tZ  , BlocksGT.Log1, PILLARS_X[0], 2);
				return T;
			case 2:
				if (aRandom.nextBoolean())	WD.set(aWorld, tX  , tY+1, tZ-2, BlocksGT.Log1, PILLARS_Z[0], 2);
											WD.set(aWorld, tX  , tY+1, tZ-1, BlocksGT.Log1, PILLARS_Z[0], 2);
											WD.set(aWorld, tX  , tY+1, tZ  , BlocksGT.Log1, PILLARS_Z[0], 2);
											WD.set(aWorld, tX  , tY+1, tZ+1, BlocksGT.Log1, PILLARS_Z[0], 2);
				if (aRandom.nextBoolean())	WD.set(aWorld, tX  , tY+1, tZ+2, BlocksGT.Log1, PILLARS_Z[0], 2);
				return T;
			}
		}
		return T;
	}
}