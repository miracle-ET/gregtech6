package gregapi.recipes.maps;

import static gregapi.data.CS.*;

import java.util.Collection;

import gregapi.data.FL;
import gregapi.data.OP;
import gregapi.data.TD;
import gregapi.oredict.OreDictMaterial;
import gregapi.random.IHasWorldAndCoords;
import gregapi.recipes.Recipe;
import gregapi.recipes.Recipe.RecipeMap;
import gregapi.tileentity.computer.ITileEntityUSBPort;
import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

/**
 * @author Gregorius Techneticies
 */
public class RecipeMapReplicator extends RecipeMap {
	public RecipeMapReplicator(Collection<Recipe> aRecipeList, String aUnlocalizedName, String aNameLocal, String aNameNEI, long aProgressBarDirection, long aProgressBarAmount, String aNEIGUIPath, long aInputItemsCount, long aOutputItemsCount, long aMinimalInputItems, long aInputFluidCount, long aOutputFluidCount, long aMinimalInputFluids, long aMinimalInputs, long aPower, String aNEISpecialValuePre, long aNEISpecialValueMultiplier, String aNEISpecialValuePost, boolean aShowVoltageAmperageInNEI, boolean aNEIAllowed, boolean aConfigAllowed, boolean aNeedsOutputs) {
		super(aRecipeList, aUnlocalizedName, aNameLocal, aNameNEI, aProgressBarDirection, aProgressBarAmount, aNEIGUIPath, aInputItemsCount, aOutputItemsCount, aMinimalInputItems, aInputFluidCount, aOutputFluidCount, aMinimalInputFluids, aMinimalInputs, aPower, aNEISpecialValuePre, aNEISpecialValueMultiplier, aNEISpecialValuePost, aShowVoltageAmperageInNEI, aNEIAllowed, aConfigAllowed, aNeedsOutputs);
		mMaxFluidInputSize = 2000;
	}
	
	@Override
	public Recipe findRecipe(IHasWorldAndCoords aTileEntity, Recipe aRecipe, boolean aNotUnificated, long aSize, ItemStack aSpecialSlot, FluidStack[] aFluids, ItemStack... aInputs) {
		Recipe rRecipe = super.findRecipe(aTileEntity, aRecipe, aNotUnificated, aSize, aSpecialSlot, aFluids, aInputs);
		
		if (rRecipe != null || aInputs == null || aFluids == null || GAPI_POST.mFinishedServerStarted <= 0) return rRecipe;
		
		ItemStack tUSB = null;
		NBTTagCompound tData = null;
		for (ItemStack aInput : aInputs) if (aInput != null) {
			if (tData == null) {
				if (OM.is_(OD_USB_STICKS[3], aInput)) {
					if (!aInput.hasTagCompound()) return rRecipe;
					tUSB = aInput;
					tData = tUSB.getTagCompound().getCompoundTag(NBT_USB_DATA);
				} else if (OM.is_(OD_USB_CABLES[3], aInput)) {
					if (aTileEntity == null) return rRecipe;
					tUSB = aInput;
					for (byte tSide : ALL_SIDES_VALID_ONLY[tUSB.hasTagCompound() && tUSB.getTagCompound().hasKey(NBT_USB_DIRECTION) ? tUSB.getTagCompound().getByte(NBT_USB_DIRECTION) : SIDE_ANY]) {
						DelegatorTileEntity<TileEntity> tDelegator = aTileEntity.getAdjacentTileEntity(tSide);
						if (tDelegator.mTileEntity instanceof ITileEntityUSBPort) {
							tData = ((ITileEntityUSBPort)tDelegator.mTileEntity).getUSBData(tDelegator.mSideOfTileEntity, 3);
							if (tData != null) if (tData.hasNoTags()) tData = null; else break;
						}
					}
				}
			}
		}
		if (tData == null || tData.hasNoTags()) return rRecipe;
		if (tUSB != null && tData.hasKey(NBT_REPLICATOR_DATA)) {
			short tID = tData.getShort(NBT_REPLICATOR_DATA);
			if (tID > 0 && UT.Code.exists(tID, OreDictMaterial.MATERIAL_ARRAY)) return getReplicatorRecipe(OreDictMaterial.MATERIAL_ARRAY[tID], tUSB);
		}
		return rRecipe;
	}
	
	public static Recipe getReplicatorRecipe(OreDictMaterial aMaterial, ItemStack aUSB) {
		if (aMaterial.contains(TD.Processing.UUM) && !aMaterial.contains(TD.Atomic.ANTIMATTER)) {
			FluidStack[] tMatters = new FluidStack[] {aMaterial.mNeutrons<=0?NF:UT.Fluids.make("neutralmatter", aMaterial.mNeutrons), aMaterial.mProtons<=0?NF:UT.Fluids.make("chargedmatter", aMaterial.mProtons)};
			long tPower = (aMaterial.mProtons+aMaterial.mNeutrons) * 65536;
			if (aMaterial.mMeltingPoint <= DEF_ENV_TEMP) {
				FluidStack tFluidOutput = aMaterial.fluid(DEF_ENV_TEMP, U, F);
				if (!FL.Error.is(tFluidOutput)) return new Recipe(F, F, T, new ItemStack[] {ST.amount(0, aUSB)}, ZL_IS, null, null, tMatters, new FluidStack[] {tFluidOutput}, tPower, 1, 0).setNoBuffering();
			}
			ItemStack tOutput = NI;
			if (aMaterial.mPriorityPrefix != null) tOutput = aMaterial.mPriorityPrefix.mat(aMaterial, 1);
			if (ST.invalid(tOutput)) {
				if (ST.invalid(tOutput = OP.gem			.mat(aMaterial, 1)) && ST.invalid(tOutput = OP.plateGem	.mat(aMaterial, 1))
				&&  ST.invalid(tOutput = OP.ingot		.mat(aMaterial, 1)) && ST.invalid(tOutput = OP.plate	.mat(aMaterial, 1))
				&&  ST.invalid(tOutput = OP.nugget		.mat(aMaterial, 9)) && ST.invalid(tOutput = OP.chunkGt	.mat(aMaterial, 4))
				&&  ST.invalid(tOutput = OP.dust		.mat(aMaterial, 1)) && ST.invalid(tOutput = OP.dustTiny	.mat(aMaterial, 9))
				&&  ST.invalid(tOutput = OP.dustSmall	.mat(aMaterial, 4)) && ST.invalid(tOutput = OP.stick	.mat(aMaterial, 2))) {
					FluidStack tFluidOutput = aMaterial.liquid(U, F);
					if (FL.Error.is(tFluidOutput)) tFluidOutput = aMaterial.gas(U, F);
					if (FL.Error.is(tFluidOutput)) tFluidOutput = aMaterial.plasma(U, F);
					if (FL.Error.is(tFluidOutput)) return null;
					return new Recipe(F, F, T, new ItemStack[] {ST.amount(0, aUSB)}, ZL_IS, null, null, tMatters, new FluidStack[] {tFluidOutput}, tPower, 1, 0).setNoBuffering();
				}
			}
			return new Recipe(F, F, T, new ItemStack[] {ST.amount(0, aUSB)}, new ItemStack[] {tOutput}, null, null, tMatters, null, tPower, 1, 0).setNoBuffering();
		}
		return null;
	}
	
	@Override public boolean containsInput(FluidStack aFluid, IHasWorldAndCoords aTileEntity, ItemStack aSpecialSlot) {return super.containsInput(aFluid, aTileEntity, aSpecialSlot) || UT.Fluids.is(aFluid, "neutralmatter", "chargedmatter");}
	@Override public boolean containsInput(Fluid aFluid, IHasWorldAndCoords aTileEntity, ItemStack aSpecialSlot) {return super.containsInput(aFluid, aTileEntity, aSpecialSlot) || UT.Fluids.is(aFluid, "neutralmatter", "chargedmatter");}
}