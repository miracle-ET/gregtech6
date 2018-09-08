package gregtech.items.tools.early;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.block.tree.BlockBaseBeam;
import gregapi.code.ItemStackContainer;
import gregapi.data.CS.SFX;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.item.multiitem.MultiItemTool;
import gregapi.item.multiitem.behaviors.Behavior_Tool;
import gregapi.item.multiitem.tools.ToolStats;
import gregapi.render.IIconContainer;
import gregapi.util.ST;
import gregapi.util.UT;
import gregapi.wooddict.WoodDictionary;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

public class GT_Tool_Axe extends ToolStats {
	@Override
	public int getToolDamagePerBlockBreak() {
		return 50;
	}
	
	@Override
	public int getToolDamagePerDropConversion() {
		return 5;
	}
	
	@Override
	public int getToolDamagePerContainerCraft() {
		return 100;
	}
	
	@Override
	public int getToolDamagePerEntityAttack() {
		return 200;
	}
	
	@Override
	public int getBaseQuality() {
		return 0;
	}
	
	@Override
	public float getBaseDamage() {
		return 3.0F;
	}
	
	@Override
	public float getSpeedMultiplier() {
		return 1.0F;
	}
	
	@Override
	public float getMaxDurabilityMultiplier() {
		return 1.0F;
	}
	
	@Override
	public boolean isWeapon() {
		return T;
	}
	
	@Override
	public boolean isMinableBlock(Block aBlock, byte aMetaData) {
		String tTool = aBlock.getHarvestTool(aMetaData);
		return (tTool != null && tTool.equalsIgnoreCase(TOOL_axe)) || aBlock.getMaterial() == Material.wood || aBlock.getMaterial() == Material.cactus || aBlock.getMaterial() == Material.leaves || aBlock.getMaterial() == Material.vine || aBlock.getMaterial() == Material.plants || aBlock.getMaterial() == Material.gourd;
	}
	
	private static boolean LOCK = T;
	
	@Override
	public int convertBlockDrops(List<ItemStack> aDrops, ItemStack aStack, EntityPlayer aPlayer, Block aBlock, long aAvailableDurability, int aX, int aY, int aZ, byte aMetaData, int aFortune, boolean aSilkTouch, BlockEvent.HarvestDropsEvent aEvent) {
		int rAmount = 0;
		if (LOCK && !aPlayer.worldObj.isRemote && !aPlayer.isSneaking() && (aBlock.isWood(aPlayer.worldObj, aX, aY, aZ) || OP.log.contains(ST.make(aBlock, 1, aMetaData)) || WoodDictionary.WOODS.containsKey(new ItemStackContainer(aBlock, 1, aMetaData)) || WoodDictionary.WOODS.containsKey(new ItemStackContainer(aBlock, 1, W)))) {
			try {
				int tIncrement = (int)Math.max(1, (aBlock.getBlockHardness(aPlayer.worldObj, aX, aY, aZ) * getToolDamagePerBlockBreak()) / 10);
				LOCK = F;
				for (int tY = aY+1, tH = aPlayer.worldObj.getHeight(); tY < tH && rAmount <= aAvailableDurability; tY++) if (aPlayer.worldObj.getBlock(aX, tY, aZ) == aBlock && aPlayer.worldObj.func_147480_a(aX, tY, aZ, T)) {tIncrement++; rAmount+=tIncrement;} else break;
			} catch(Throwable e) {/**/}
			LOCK = T;
		}
		return rAmount;
	}
	
	@Override
	public float getMiningSpeed(Block aBlock, byte aMetaData, float aDefault, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ) {
		if (aBlock instanceof BlockBaseBeam) return 2 * aDefault;
		if (aBlock.isWood(aPlayer.worldObj, aX, aY, aZ) || OP.log.contains(ST.make(aBlock, 1, aMetaData)) || WoodDictionary.WOODS.containsKey(new ItemStackContainer(aBlock, 1, aMetaData)) || WoodDictionary.WOODS.containsKey(new ItemStackContainer(aBlock, 1, W))) {
			float rAmount = 1.0F, tIncrement = 1.0F;
			if (!aPlayer.isSneaking()) for (int tY = aY+1, tH = aPlayer.worldObj.getHeight(); tY < tH; tY++) if (aPlayer.worldObj.getBlock(aX, tY, aZ) == aBlock) {tIncrement+=0.1F; rAmount+=tIncrement;} else break;
			return 2 * aDefault / rAmount;
		}
		return aBlock.getMaterial() == Material.leaves || aBlock.getMaterial() == Material.vine || aBlock.getMaterial() == Material.plants || aBlock.getMaterial() == Material.gourd ? aDefault / 4 : aDefault;
	}
	
	@Override
	public void afterDealingDamage(float aNormalDamage, float aMagicDamage, int aFireAspect, boolean aCriticalHit, Entity aEntity, ItemStack aStack, EntityPlayer aPlayer) {
		super.afterDealingDamage(aNormalDamage, aMagicDamage, aFireAspect, aCriticalHit, aEntity, aStack, aPlayer);
		if (aEntity.worldObj.isRemote || aNormalDamage < 2) return;
		if ("EntityEnt".equalsIgnoreCase(UT.Reflection.getLowercaseClass(aEntity))) ST.drop(aEntity, Blocks.log, UT.Code.bindStack((int)(aNormalDamage / 2)), 0);
	}
	
	@Override
	public IIconContainer getIcon(boolean aIsToolHead, ItemStack aStack) {
		return aIsToolHead ? MultiItemTool.getPrimaryMaterial(aStack, MT.Steel).mTextureSetsItems.get(OP.toolHeadAxe.mIconIndexItem) : MultiItemTool.getSecondaryMaterial(aStack, MT.Wood).mTextureSetsItems.get(OP.stick.mIconIndexItem);
	}
	
	@Override
	public short[] getRGBa(boolean aIsToolHead, ItemStack aStack) {
		return aIsToolHead ? MultiItemTool.getPrimaryMaterial(aStack, MT.Steel).mRGBaSolid : MultiItemTool.getSecondaryMaterial(aStack, MT.Wood).mRGBaSolid;
	}
	
	@Override
	public void onStatsAddedToTool(MultiItemTool aItem, int aID) {
		aItem.addItemBehavior(aID, new Behavior_Tool(TOOL_axe, SFX.MC_DIG_WOOD, getToolDamagePerContainerCraft(), T));
	}
	
	@Override
	public String getDeathMessage() {
		return "[VICTIM] has been chopped by [KILLER]";
	}
}