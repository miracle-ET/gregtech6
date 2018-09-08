package gregtech.blocks;

import static gregapi.data.CS.*;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregapi.block.metatype.BlockColored;
import gregapi.block.metatype.BlockMetaType;
import gregapi.block.metatype.ItemBlockMetaType;
import gregapi.code.ArrayListNoNulls;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.old.Textures;
import gregapi.oredict.OreDictMaterial;
import gregapi.render.IIconContainer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlassClear extends BlockColored {
	public BlockGlassClear(String aUnlocalised) {
		super(ItemBlockMetaType.class, Material.glass, soundTypeGlass, aUnlocalised, "Glass", MT.Glass, 0.5F, 0.5F, 0, Textures.BlockIcons.GLASSES_CLEAR);
	}
	
	@Override
	protected BlockMetaType makeSlab(Class<? extends ItemBlock> aItemClass, Material aVanillaMaterial, SoundType aVanillaSoundType, String aName, String aDefaultLocalised, OreDictMaterial aMaterial, float aResistanceMultiplier, float aHardnessMultiplier, int aHarvestLevel, int aCount, IIconContainer[] aIcons, byte aSlabType, BlockMetaType aBlock) {
		return new BlockGlassClear(aItemClass, aVanillaMaterial, aVanillaSoundType, aName, aDefaultLocalised, aMaterial, aResistanceMultiplier, aHardnessMultiplier, aHarvestLevel, aCount, aIcons, aSlabType, aBlock);
	}
	
	protected BlockGlassClear(Class<? extends ItemBlock> aItemClass, Material aVanillaMaterial, SoundType aVanillaSoundType, String aName, String aDefaultLocalised, OreDictMaterial aMaterial, float aResistanceMultiplier, float aHardnessMultiplier, int aHarvestLevel, int aCount, IIconContainer[] aIcons, byte aSlabType, BlockMetaType aBlock) {
		super(aItemClass, aVanillaMaterial, aVanillaSoundType, aName, aDefaultLocalised, aMaterial, aResistanceMultiplier, aHardnessMultiplier, aHarvestLevel, aCount, aIcons, aSlabType, aBlock);
	}
	
	@Override public int getLightOpacity() {return LIGHT_OPACITY_NONE;}
	@Override public int getRenderBlockPass() {return 1;}
	@Override public boolean isOpaqueCube() {return F;}
	@Override public boolean renderAsNormalBlock() {return F;}
	@Override public boolean isSealable(int aMeta, byte aSide) {return mBlock == this || mSide == aSide;}
	@Override public boolean isBlockSolid(IBlockAccess aWorld, int aX, int aY, int aZ, int aSide) {return F;}
	@Override public ArrayList<ItemStack> getDrops(World aWorld, int aX, int aY, int aZ, int aMeta, int aFortune) {return new ArrayListNoNulls(F, OP.scrapGt.mat(MT.Glass, mBlock == this ? 9 : 4));}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess aWorld, int aX, int aY, int aZ, int aSide) {
		if (aSide == OPPOSITES[mSide]) return T;
		Block aBlock = aWorld.getBlock(aX, aY, aZ);
		return aBlock instanceof BlockMetaType && ((BlockMetaType)aBlock).mBlock == mBlock ? aWorld.getBlockMetadata(aX, aY, aZ) != aWorld.getBlockMetadata(aX - OFFSETS_X[aSide], aY - OFFSETS_Y[aSide], aZ - OFFSETS_Z[aSide]) || ((((BlockMetaType)aBlock).mSide != mSide || aSide == mSide) && ((BlockMetaType)aBlock).mSide != OPPOSITES[aSide] && ((BlockMetaType)aBlock).mSide != SIDE_ANY) : super.shouldSideBeRendered(aWorld, aX, aY, aZ, aSide);
	}
}