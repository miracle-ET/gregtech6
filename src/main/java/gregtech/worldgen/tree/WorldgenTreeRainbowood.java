package gregtech.worldgen.tree;

import static gregapi.data.CS.*;

import java.util.List;
import java.util.Random;
import java.util.Set;

import gregapi.block.tree.BlockBaseSapling;
import gregapi.data.CS.BlocksGT;
import gregapi.worldgen.WorldgenObject;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

/**
 * @author Gregorius Techneticies
 */
public class WorldgenTreeRainbowood extends WorldgenObject {
	public WorldgenTreeRainbowood(String aName, boolean aDefault, List... aLists) {
		super(aName, aDefault, aLists);
	}
	
	@Override
	public boolean generate(World aWorld, Chunk aChunk, int aDimType, int aMinX, int aMinZ, int aMaxX, int aMaxZ, Random aRandom, BiomeGenBase[][] aBiomes, Set<String> aBiomeNames) {
		if (!(aBiomeNames.contains("Enchanted Forest") || aRandom.nextInt(32768) == 0) || checkForMajorWorldgen(aWorld, aMinX, aMinZ, aMaxX, aMaxZ)) return F;
		int tX = aRandom.nextInt(16), tZ = aRandom.nextInt(16);
		for (int tY = aWorld.provider.hasNoSky ? 80 : aWorld.getHeight()-50; tY > 0; tY--) if (aChunk.getBlock(tX, tY, tZ) == Blocks.grass) return ((BlockBaseSapling)BlocksGT.Sapling).grow(aWorld, aMinX + tX, tY+1, aMinZ + tZ, (byte)7, aRandom);
		return F;
	}
}