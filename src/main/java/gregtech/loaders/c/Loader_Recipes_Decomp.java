package gregtech.loaders.c;

import static gregapi.data.CS.*;

import gregapi.code.ArrayListNoNulls;
import gregapi.data.ANY;
import gregapi.data.FL;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.data.TD;
import gregapi.oredict.IOreDictConfigurationComponent;
import gregapi.oredict.OreDictMaterial;
import gregapi.oredict.OreDictMaterialStack;
import gregapi.recipes.Recipe.RecipeMap;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class Loader_Recipes_Decomp implements Runnable {
	@Override public void run() {OUT.println("GT_Mod: Doing Decomposition Recipes for Electrolyzer, Centrifuge and alike"); try {
		for (OreDictMaterial aMaterial : OreDictMaterial.MATERIAL_MAP.values()) if (aMaterial.mTargetRegistration == aMaterial) {
			IOreDictConfigurationComponent tComponents = aMaterial.mComponents;
			if (tComponents != null && tComponents.getCommonDivider() <= 64 && aMaterial.contains(TD.Compounds.DECOMPOSABLE)) {
				ArrayListNoNulls<RecipeMap> tRecipeMaps = new ArrayListNoNulls();
				if (aMaterial.contains(TD.Processing.CENTRIFUGE)) tRecipeMaps.add(RM.Centrifuge);
				if (aMaterial.contains(TD.Processing.ELECTROLYSER)) tRecipeMaps.add(RM.Electrolyzer);
				if (!tRecipeMaps.isEmpty()) {
					ArrayListNoNulls<ItemStack> tStackOutputs = new ArrayListNoNulls();
					ArrayListNoNulls<FluidStack> tFluidOutputs = new ArrayListNoNulls();
					long tAmount = 0;
					
					for (OreDictMaterialStack tMaterial : tComponents.getUndividedComponents()) {
						tAmount += tMaterial.mAmount;
						if (tMaterial.mMaterial.mMeltingPoint <= DEF_ENV_TEMP && tFluidOutputs.add(tMaterial.mMaterial.fluid(tMaterial.mAmount, F))) continue;
						if (tStackOutputs.add(OM.dust(tMaterial.mMaterial.mTargetPulver.mMaterial, UT.Code.units(tMaterial.mAmount, U, tMaterial.mMaterial.mTargetPulver.mAmount, F)))) continue;
					}
					
					if (tStackOutputs.size() > 0 || tFluidOutputs.size() > 0) for (RecipeMap tRecipeMap : tRecipeMaps) {
						boolean temp = T;
						
						if (temp && tRecipeMap.mInputFluidCount > 0) {
							FluidStack
							aFluid = aMaterial.liquid(tComponents.getCommonDivider() * U, T);
							if (!FL.Error.is(aFluid)) {
								temp = F;
								if (tRecipeMap == RM.Electrolyzer) {
									tRecipeMap.addRecipe1(T, T, F, F, F, Math.max(16, (tAmount * 14) / U), UT.Code.units(tAmount, U, 292, T), ST.tag(0), new FluidStack[] {aFluid}, UT.Code.makeArray(new FluidStack[tRecipeMap.mOutputFluidCount], tFluidOutputs.toArray(ZL_FS)), UT.Code.makeArray(new ItemStack[tRecipeMap.mOutputItemsCount], tStackOutputs.toArray(ZL_IS)));
								} else {
									tRecipeMap.addRecipe0(T, T, F, F, F, Math.max(16, (tAmount * 14) / U), UT.Code.units(tAmount, U, 292, T), new FluidStack[] {aFluid}, UT.Code.makeArray(new FluidStack[tRecipeMap.mOutputFluidCount], tFluidOutputs.toArray(ZL_FS)), UT.Code.makeArray(new ItemStack[tRecipeMap.mOutputItemsCount], tStackOutputs.toArray(ZL_IS)));
								}
							}
							
							aFluid = aMaterial.gas(tComponents.getCommonDivider() * U, T);
							if (!FL.Error.is(aFluid)) {
								temp = F;
								if (tRecipeMap == RM.Electrolyzer) {
									tRecipeMap.addRecipe1(T, T, F, F, F, Math.max(16, (tAmount * 14) / U), UT.Code.units(tAmount, U, 292, T), ST.tag(0), new FluidStack[] {aFluid}, UT.Code.makeArray(new FluidStack[tRecipeMap.mOutputFluidCount], tFluidOutputs.toArray(ZL_FS)), UT.Code.makeArray(new ItemStack[tRecipeMap.mOutputItemsCount], tStackOutputs.toArray(ZL_IS)));
								} else {
									tRecipeMap.addRecipe0(T, T, F, F, F, Math.max(16, (tAmount * 14) / U), UT.Code.units(tAmount, U, 292, T), new FluidStack[] {aFluid}, UT.Code.makeArray(new FluidStack[tRecipeMap.mOutputFluidCount], tFluidOutputs.toArray(ZL_FS)), UT.Code.makeArray(new ItemStack[tRecipeMap.mOutputItemsCount], tStackOutputs.toArray(ZL_IS)));
								}
							}
						}
						if ((temp || aMaterial.mReRegistrations.contains(ANY.Glowstone)) && tRecipeMap.mInputItemsCount > 0) {
							ItemStack
							aStack = OP.dust.mat(aMaterial, tComponents.getCommonDivider());
							if (aStack != null) {
								temp = F;
								if (tRecipeMap == RM.Electrolyzer) {
									tRecipeMap.addRecipe2(T, T, F, F, F, Math.max(16, (tAmount * 14) / U), UT.Code.units(tAmount, U, 292, T), ST.tag(0), aStack, ZL_FS, UT.Code.makeArray(new FluidStack[tRecipeMap.mOutputFluidCount], tFluidOutputs.toArray(ZL_FS)), UT.Code.makeArray(new ItemStack[tRecipeMap.mOutputItemsCount], tStackOutputs.toArray(ZL_IS)));
								} else {
									tRecipeMap.addRecipe1(T, T, F, F, F, Math.max(16, (tAmount * 14) / U), UT.Code.units(tAmount, U, 292, T), aStack, ZL_FS, UT.Code.makeArray(new FluidStack[tRecipeMap.mOutputFluidCount], tFluidOutputs.toArray(ZL_FS)), UT.Code.makeArray(new ItemStack[tRecipeMap.mOutputItemsCount], tStackOutputs.toArray(ZL_IS)));
								}
							}
						}
					}
				}
			}
		}} catch(Throwable e) {e.printStackTrace(ERR);}
	}
}