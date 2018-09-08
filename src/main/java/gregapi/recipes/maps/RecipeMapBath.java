package gregapi.recipes.maps;

import static gregapi.data.CS.*;

import java.util.Collection;

import gregapi.data.CS.FluidsGT;
import gregapi.data.FL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.item.IItemColorableRGB;
import gregapi.random.IHasWorldAndCoords;
import gregapi.recipes.Recipe;
import gregapi.recipes.Recipe.RecipeMap;
import gregapi.util.CR;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

/**
 * @author Gregorius Techneticies
 */
public class RecipeMapBath extends RecipeMap {
	public RecipeMapBath(Collection<Recipe> aRecipeList, String aUnlocalizedName, String aNameLocal, String aNameNEI, long aProgressBarDirection, long aProgressBarAmount, String aNEIGUIPath, long aInputItemsCount, long aOutputItemsCount, long aMinimalInputItems, long aInputFluidCount, long aOutputFluidCount, long aMinimalInputFluids, long aMinimalInputs, long aPower, String aNEISpecialValuePre, long aNEISpecialValueMultiplier, String aNEISpecialValuePost, boolean aShowVoltageAmperageInNEI, boolean aNEIAllowed, boolean aConfigAllowed, boolean aNeedsOutputs) {
		super(aRecipeList, aUnlocalizedName, aNameLocal, aNameNEI, aProgressBarDirection, aProgressBarAmount, aNEIGUIPath, aInputItemsCount, aOutputItemsCount, aMinimalInputItems, aInputFluidCount, aOutputFluidCount, aMinimalInputFluids, aMinimalInputs, aPower, aNEISpecialValuePre, aNEISpecialValueMultiplier, aNEISpecialValuePost, aShowVoltageAmperageInNEI, aNEIAllowed, aConfigAllowed, aNeedsOutputs);
	}
	
	@Override
	public Recipe findRecipe(IHasWorldAndCoords aTileEntity, Recipe aRecipe, boolean aNotUnificated, long aSize, ItemStack aSpecialSlot, FluidStack[] aFluids, ItemStack... aInputs) {
		Recipe rRecipe = super.findRecipe(aTileEntity, aRecipe, aNotUnificated, aSize, aSpecialSlot, aFluids, aInputs);
		if (aInputs == null || aInputs.length < 1 || aInputs[0] == null || aFluids.length < 1 || aFluids[0] == null || GAPI_POST.mFinishedServerStarted <= 0) return rRecipe;
		if (rRecipe == null) for (ItemStack aInput : aInputs) if (aInput != null) {
			if (MD.ATUM.mLoaded) {
				Item tItem = ST.item(MD.ATUM, "item.loot");
				if (aInput.getItem() == tItem) {
					short tMeta = ST.meta(aInput);
					if ((tMeta & 31) == 1) return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {ST.make(tItem, 1, (tMeta & ~31) + 2 + 2 * RNGSUS.nextInt(6))}, null, null, new FluidStack[] {UT.Fluids.water(aFluids[0])?UT.Fluids.amount(aFluids[0], 100):FL.Water.make(100)}, ZL_FS, 512, 0, 0).setNeedEmptyOut();
					return null;
				}
			}
			if (aInput.getItem() instanceof ItemArmor) for (byte tColor = 0; tColor < 16; tColor++) for (FluidStack aDye : DYE_FLUIDS[tColor]) if (UT.Fluids.equal(aDye, aFluids[0])) {
				ItemStack tOutput = CR.getany(aTileEntity==null?DW:aTileEntity.getWorld(), new ItemStack[] {aInput, NI, NI, NI, NI, NI, NI, NI, ST.make(Items.dye, 1, tColor)});
				if (ST.invalid(tOutput)) return null;
				return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {aDye}, ZL_FS, 512, 0, 0);
			}
			if (aInput.getItem() instanceof IItemColorableRGB) {
				if (((IItemColorableRGB)aInput.getItem()).canDecolorItem(aInput)) if (UT.Fluids.equal(MT.Cl.fluid(U, T), aFluids[0])) {
					ItemStack tOutput = ST.amount(1, aInput);
					if (!((IItemColorableRGB)tOutput.getItem()).decolorItem(tOutput) || ST.invalid(tOutput)) return null;
					return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {MT.Cl.fluid(U/8, T)}, ZL_FS, 512, 0, 0);
				}
				if (((IItemColorableRGB)aInput.getItem()).canRecolorItem(aInput)) for (byte tColor = 0; tColor < 16; tColor++) for (FluidStack aDye : DYE_FLUIDS[tColor]) if (UT.Fluids.equal(aDye, aFluids[0])) {
					ItemStack tOutput = ST.amount(1, aInput);
					if (!((IItemColorableRGB)tOutput.getItem()).recolorItem(tOutput, DYES_INT[tColor]) || ST.invalid(tOutput)) return null;
					return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.mul(aDye, 1, 8, T)}, ZL_FS, 512, 0, 0);
				}
			}
			if (ST.food(aInput) > 0 && UT.Fluids.getFluidForFilledItem(aInput, T) == null) {
				ItemStack tOutput = ST.amount(1, aInput);
				NBTTagCompound tNBT = UT.NBT.getNBT(tOutput);
				tOutput.setTagCompound(tNBT);
				if (!tNBT.hasKey(NBT_EFFECTS)) {
					if (FL.Med_Heal					.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.regeneration		.id, "time",  120, "lvl", 4, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Med_Laxative				.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.hunger			.id, "time",  300, "lvl",10, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Harm_1			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.harm				.id, "time",    0, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Harm_2			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.harm				.id, "time",    0, "lvl", 1, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Heal_1			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.heal				.id, "time",    0, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Heal_2			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.heal				.id, "time",    0, "lvl", 1, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Jump_1			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.jump				.id, "time", 3600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Jump_2			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.jump				.id, "time", 1800, "lvl", 1, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Speed_1			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.moveSpeed			.id, "time", 3600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Speed_2			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.moveSpeed			.id, "time", 1800, "lvl", 1, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Speed_1L			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.moveSpeed			.id, "time", 9600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Strength_1		.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.damageBoost		.id, "time", 3600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Strength_2		.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.damageBoost		.id, "time", 1800, "lvl", 1, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Strength_1L		.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.damageBoost		.id, "time", 9600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Regen_1			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.regeneration		.id, "time",  900, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Regen_2			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.regeneration		.id, "time",  450, "lvl", 1, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Regen_1L			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.regeneration		.id, "time", 2400, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Poison_1			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.poison			.id, "time",  900, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Poison_2			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.poison			.id, "time",  450, "lvl", 1, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Poison_1L			.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.poison			.id, "time", 2400, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_FireResistance_1	.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.fireResistance	.id, "time", 3600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_FireResistance_1L	.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.fireResistance	.id, "time", 9600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_NightVision_1		.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.nightVision		.id, "time", 3600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_NightVision_1L	.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.nightVision		.id, "time", 9600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Weakness_1		.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.weakness			.id, "time", 1800, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Weakness_1L		.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.weakness			.id, "time", 4800, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Slowness_1		.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.moveSlowdown		.id, "time", 1800, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Slowness_1L		.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.moveSlowdown		.id, "time", 4800, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_WaterBreathing_1	.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.waterBreathing	.id, "time", 3600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_WaterBreathing_1L	.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.waterBreathing	.id, "time", 9600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Invisibility_1	.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.invisibility		.id, "time", 3600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
					if (FL.Potion_Invisibility_1L	.is(aFluids[0])) {tNBT.setTag(NBT_EFFECTS, UT.NBT.make(null, "id", Potion.invisibility		.id, "time", 9600, "lvl", 0, "chance",  90)); return new Recipe(F, F, F, new ItemStack[] {ST.amount(1, aInput)}, new ItemStack[] {tOutput}, null, null, new FluidStack[] {UT.Fluids.amount(aFluids[0], 250)}, ZL_FS, 512, 0, 0);}
				}
			}
		}
		return rRecipe;
	}
	
	@Override public boolean containsInput(ItemStack aStack, IHasWorldAndCoords aTileEntity, ItemStack aSpecialSlot) {return (aStack != null && (aStack.getItem() instanceof ItemArmor || (aStack.getItem() instanceof IItemColorableRGB && (((IItemColorableRGB)aStack.getItem()).canRecolorItem(aStack) || ((IItemColorableRGB)aStack.getItem()).canDecolorItem(aStack))))) || (ST.food(aStack) > 0 && UT.Fluids.getFluidForFilledItem(aStack, T) == null) || super.containsInput(aStack, aTileEntity, aSpecialSlot);}
	@Override public boolean containsInput(FluidStack aFluid, IHasWorldAndCoords aTileEntity, ItemStack aSpecialSlot) {return aFluid != null && aFluid.getFluid() != null && (super.containsInput(aFluid, aTileEntity, aSpecialSlot) || FluidsGT.BATH.contains(aFluid.getFluid().getName()));}
	@Override public boolean containsInput(Fluid aFluid, IHasWorldAndCoords aTileEntity, ItemStack aSpecialSlot) {return aFluid != null && (super.containsInput(aFluid, aTileEntity, aSpecialSlot) || FluidsGT.BATH.contains(aFluid.getName()));}
}