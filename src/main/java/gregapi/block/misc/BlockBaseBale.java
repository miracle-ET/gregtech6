package gregapi.block.misc;

import static gregapi.data.CS.*;

import gregapi.block.BlockBaseMeta;
import gregapi.render.IIconContainer;
import gregapi.util.ST;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author Gregorius Techneticies
 */
public abstract class BlockBaseBale extends BlockBaseMeta {
	public BlockBaseBale(Class<? extends ItemBlock> aItemClass, String aNameInternal, Material aMaterial, SoundType aSoundType, long aMaxMeta, IIconContainer[] aIcons) {
		super(aItemClass, aNameInternal, aMaterial, aSoundType, Math.min(4, aMaxMeta), aIcons);
		
	}
	
    @Override public String getHarvestTool(int aMeta) {return TOOL_sword;}
	@Override public int damageDropped(int aMeta) {return aMeta & PILLAR_DATA;}
	@Override public int getDamageValue(World aWorld, int aX, int aY, int aZ) {return aWorld.getBlockMetadata(aX, aY, aZ) & PILLAR_DATA;}
	@Override public float getBlockHardness(World aWorld, int aX, int aY, int aZ) {return Blocks.hay_block.getBlockHardness(aWorld, aX, aY, aZ);}
	@Override public float getExplosionResistance(int aMeta) {return Blocks.hay_block.getExplosionResistance(null);}
	@Override public int getItemStackLimit(ItemStack aStack) {return ST.make(Blocks.hay_block, 1, 0).getMaxStackSize();}
	@Override public int getRenderType() {return PILLAR_RENDER;}
	@Override public boolean isSealable(int aMeta, byte aSide) {return F;}
	@Override public boolean isFireSource(World aWorld, int aX, int aY, int aZ, ForgeDirection aSide) {return F;}
	@Override public boolean isFlammable(IBlockAccess aWorld, int aX, int aY, int aZ, ForgeDirection aSide) {return T;}
	@Override public int getFlammability(IBlockAccess aWorld, int aX, int aY, int aZ, ForgeDirection aSide) {return 150;}
	@Override public int getFireSpreadSpeed(IBlockAccess aWorld, int aX, int aY, int aZ, ForgeDirection aSide) {return 150;}
	@Override public int onBlockPlaced(World aWorld, int aX, int aY, int aZ, int aSide, float aHitX, float aHitY, float aHitZ, int aMeta) {return PILLAR_DATA_SIDE[aMeta][aSide];}
	@Override public IIcon getIcon(int aSide, int aMeta) {return mIcons[2*(aMeta&PILLAR_DATA)+(PILLAR_TO_AXIS[aMeta][aSide]?0:1)].getIcon(0);}
}