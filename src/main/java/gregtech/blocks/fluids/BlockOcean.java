package gregtech.blocks.fluids;

import static gregapi.data.CS.*;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregapi.code.ArrayListNoNulls;
import gregapi.util.WD;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fluids.Fluid;

/**
 * @author Gregorius Techneticies
 */
public class BlockOcean extends BlockWaterlike {
	public static boolean PLACEMENT_ALLOWED = F, SPREAD_TO_AIR = T;
	
	public BlockOcean(String aName, Fluid aFluid) {
		super(aName, aFluid);
		tickRate = 20;
	}
	
	@Override
	public void onBlockAdded(World aWorld, int aX, int aY, int aZ) {
		if (PLACEMENT_ALLOWED) {
			aWorld.scheduleBlockUpdate(aX, aY, aZ, this, tickRate);
		} else {
			aWorld.setBlockToAir(aX, aY, aZ);
		}
	}
	
	@Override
	public void updateTick(World aWorld, int aX, int aY, int aZ, Random aRandom) {
		PLACEMENT_ALLOWED = T;
		
		if (aWorld.doChunksNearChunkExist(aX, aY, aZ, 33)) {
			aWorld.func_147451_t(aX, aY, aZ);
			aWorld.markBlockForUpdate(aX, aY, aZ);
			if (aY > 0) {
				if (aWorld.getBlock(aX, aY-1, aZ) == this) {
					aWorld.scheduleBlockUpdate(aX, aY-1, aZ, this, tickRate);
				} else {
					aWorld.func_147451_t(aX, aY-1, aZ);
					aWorld.markBlockForUpdate(aX, aY-1, aZ);
				}
			}
		} else {
			aWorld.scheduleBlockUpdate(aX, aY, aZ, this, Math.max(600, tickRate));
			PLACEMENT_ALLOWED = F;
			return;
		}
		
		if (aY <= 0) {
			updateFlow(aWorld, aX, aY, aZ, aRandom);
			PLACEMENT_ALLOWED = F;
			return;
		}
		
		Block tBlock;
		
		BiomeGenBase tBiome = aWorld.getBiomeGenForCoords(aX, aZ);
		
		byte tOceanCounter = 0;
		ArrayListNoNulls<ChunkCoordinates> tList = new ArrayListNoNulls();
		for (byte tSide : ALL_SIDES_BUT_TOP) if (aWorld.blockExists(aX+OFFSETS_X[tSide], aY+OFFSETS_Y[tSide], aZ+OFFSETS_Z[tSide])) {
			tBlock = aWorld.getBlock(aX+OFFSETS_X[tSide], aY+OFFSETS_Y[tSide], aZ+OFFSETS_Z[tSide]);
			byte tMeta = (byte)aWorld.getBlockMetadata(aX+OFFSETS_X[tSide], aY+OFFSETS_Y[tSide], aZ+OFFSETS_Z[tSide]);
			if (tBlock == this) {
				if (tMeta == 0) tOceanCounter++;
			} else if (tBlock instanceof BlockWaterlike || tBlock == Blocks.water || tBlock == Blocks.flowing_water) {
				if (!(tBlock instanceof BlockWaterlike) || BIOMES_OCEAN_BEACH.contains(tBiome.biomeName)) tList.add(new ChunkCoordinates(aX+OFFSETS_X[tSide], aY+OFFSETS_Y[tSide], aZ+OFFSETS_Z[tSide]));
				if (tMeta == 0) tOceanCounter++;
			}
		}
		
		if (aWorld.getBlockMetadata(aX, aY, aZ) == 0) {
			if (tOceanCounter <= 0 && !(aWorld.getBlock(aX, aY+1, aZ) instanceof BlockOcean)) {
				aWorld.setBlockToAir(aX, aY, aZ);
				PLACEMENT_ALLOWED = F;
				return;
			}
		} else {
			if (tOceanCounter >= 2 || (SPREAD_TO_AIR && (BIOMES_OCEAN_BEACH.contains(tBiome.biomeName) || (aWorld.getBlock(aX, aY+1, aZ) instanceof BlockOcean && aWorld.getBlockMetadata(aX, aY+1, aZ) == 0)))) {
				aWorld.setBlock(aX, aY, aZ, this, 0, 2);
			}
		}
		
		if (BIOMES_RIVER_LAKE.contains(tBiome.biomeName)) {
			tOceanCounter = 0;
			for (int i = -1; i < 2; i++) for (int j = -1; j < 2; j++) if (i != 0 && j != 0) {
				if (aWorld.getBlock(aX+i, aY, aZ+j) instanceof BlockOcean && aWorld.getBlockMetadata(aX+i, aY, aZ+j) == 0) {
					tOceanCounter++;
				}
			}
			if (tOceanCounter < 3) {
				updateFlow(aWorld, aX, aY, aZ, aRandom);
				PLACEMENT_ALLOWED = F;
				return;
			}
		}
		
		for (ChunkCoordinates tCoords : tList) {
			if (aWorld.setBlock(tCoords.posX, tCoords.posY, tCoords.posZ, this, 0, 2)) for (int i = -1; i < 2; i++) for (int j = -1; j < 2; j++) {
				if (aWorld.blockExists(tCoords.posX+i, tCoords.posY, tCoords.posZ+j)) {
					tBlock = aWorld.getBlock(tCoords.posX+i, tCoords.posY, tCoords.posZ+j);
					if (tBlock instanceof BlockOcean) aWorld.scheduleBlockUpdate(tCoords.posX+i, tCoords.posY, tCoords.posZ+j, this, tickRate);
				}
			}
		}
		
		updateFlow(aWorld, aX, aY, aZ, aRandom);
		PLACEMENT_ALLOWED = F;
		return;
	}
	
	@Override public int getLightOpacity(IBlockAccess aWorld, int aX, int aY, int aZ) {Block tBlock = aWorld.getBlock(aX, aY+1, aZ); return !tBlock.getMaterial().isLiquid() && tBlock.getLightOpacity(aWorld, aX, aY+1, aZ) <= 0 && !WD.visOpq(tBlock) ? 16 : LIGHT_OPACITY_NONE;}
	@Override public IIcon getIcon(int aSide, int aMeta) {return Blocks.water.getIcon(aSide, aMeta);}
	@Override @SideOnly(Side.CLIENT) public int getRenderColor(int aMeta) {return 0x00c0c0c0;}
	@Override @SideOnly(Side.CLIENT) public int colorMultiplier(IBlockAccess aWorld, int aX, int aY, int aZ) {return 0x00c0c0c0;}
}