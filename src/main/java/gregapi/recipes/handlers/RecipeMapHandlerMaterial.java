package gregapi.recipes.handlers;

import static gregapi.data.CS.*;

import gregapi.code.ICondition;
import gregapi.oredict.OreDictItemData;
import gregapi.oredict.OreDictMaterial;
import gregapi.oredict.OreDictPrefix;
import gregapi.recipes.IRecipeMapHandler;
import gregapi.recipes.Recipe.RecipeMap;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

/**
 * @author Gregorius Techneticies
 */
public class RecipeMapHandlerMaterial implements IRecipeMapHandler {
	private ICondition mCondition;
	private final OreDictMaterial mInputMaterial, mOutputMaterial;
	private final ItemStack mAdditionalInput;
	private final FluidStack mFluidInputPerUnit, mFluidOutputPerUnit;
	private final long mEUt, mDuration;
	private final boolean mAllowToGenerateAllRecipesAtOnce;
	
	private boolean mAlreadyAddedAllRecipes = F;
	
	public RecipeMapHandlerMaterial(OreDictMaterial aInputMaterial, FluidStack aFluidInputPerUnit, long aEUt, long aDuration, FluidStack aFluidOutputPerUnit, OreDictMaterial aOutputMaterial, ItemStack aAdditionalInput, boolean aAllowToGenerateAllRecipesAtOnce, ICondition aCondition) {
		mAllowToGenerateAllRecipesAtOnce = aAllowToGenerateAllRecipesAtOnce;
		mFluidInputPerUnit	= aFluidInputPerUnit;
		mFluidOutputPerUnit	= aFluidOutputPerUnit;
		mCondition			= (aCondition == null ? ICondition.TRUE : aCondition);
		mInputMaterial		= aInputMaterial;
		mOutputMaterial		= aOutputMaterial;
		mAdditionalInput	= aAdditionalInput;
		mDuration 			= aDuration;
		mEUt				= aEUt;
	}
	
	@Override
	public boolean addRecipesUsing(RecipeMap aMap, ItemStack aStack, OreDictItemData aData) {
		if (isDone()) return F;
		if (ST.equal(aStack, mAdditionalInput)) return mAllowToGenerateAllRecipesAtOnce && addAllRecipesInternal(aMap);
		return aData != null && aData.hasValidPrefixMaterialData() && aData.mMaterial.mMaterial == mInputMaterial && addRecipeForPrefix(aMap, aData.mPrefix);
	}
	
	@Override
	public boolean addRecipesProducing(RecipeMap aMap, ItemStack aStack, OreDictItemData aData) {
		if (isDone()) return F;
		return aData != null && aData.hasValidPrefixMaterialData() && aData.mMaterial.mMaterial == mOutputMaterial && addRecipeForPrefix(aMap, aData.mPrefix);
	}
	
	@Override
	public boolean containsInput(RecipeMap aMap, ItemStack aStack, OreDictItemData aData) {
		if (isDone()) return F;
		return addRecipesUsing(aMap, aStack, aData);
	}
	
	@Override
	public boolean addRecipesUsing(RecipeMap aMap, Fluid aFluid) {
		if (isDone()) return F;
		return mFluidInputPerUnit != null && mFluidInputPerUnit.getFluid() == aFluid && mAllowToGenerateAllRecipesAtOnce && addAllRecipesInternal(aMap);
	}
	
	@Override
	public boolean addRecipesProducing(RecipeMap aMap, Fluid aFluid) {
		if (isDone()) return F;
		return mFluidOutputPerUnit != null && mFluidOutputPerUnit.getFluid() == aFluid && mAllowToGenerateAllRecipesAtOnce && addAllRecipesInternal(aMap);
	}
	
	@Override
	public boolean containsInput(RecipeMap aMap, Fluid aFluid) {
		return mFluidInputPerUnit != null && mFluidInputPerUnit.getFluid() == aFluid;
	}
	
	@Override
	public boolean addAllRecipes(RecipeMap aMap) {
		return mAllowToGenerateAllRecipesAtOnce && addAllRecipesInternal(aMap);
	}
	
	public boolean addAllRecipesInternal(RecipeMap aMap) {
		if (isDone()) return F;
		for (OreDictPrefix tPrefix : OreDictPrefix.VALUES) addRecipeForPrefix(aMap, tPrefix);
		mAlreadyAddedAllRecipes = T;
		return T;
	}
	
	@Override
	public boolean isDone() {
		return mAlreadyAddedAllRecipes;
	}
	
	@Override
	public boolean onAddedToMap(RecipeMap aMap) {
		if (mFluidInputPerUnit != null) aMap.mMaxFluidInputSize = Math.max(mFluidInputPerUnit.amount * 16, aMap.mMaxFluidInputSize);
		return T;
	}
	
	public boolean addRecipeForPrefix(RecipeMap aMap, OreDictPrefix aPrefix) {
		if (!mCondition.isTrue(aPrefix)) return F;
		
		ItemStack[] tInputs = new ItemStack[mAdditionalInput==null?1:2];
		if (mAdditionalInput != null) tInputs[tInputs.length-1] = mAdditionalInput;
		tInputs[0] = aPrefix.mat(mInputMaterial, 1);
		for (ItemStack tInput : tInputs) if (ST.invalid(tInput)) return F;
		
		ItemStack tOutput = aPrefix.mat(mOutputMaterial, 1);
		if (ST.invalid(tOutput)) return F;
		
		return aMap.addRecipeX(F,T,F,F,T, mEUt, Math.max(1, getCosts(aPrefix)), tInputs, UT.Fluids.mul(mFluidInputPerUnit, aPrefix.mAmount, U, T), UT.Fluids.mul(mFluidOutputPerUnit, aPrefix.mAmount, U, F), tOutput) != null;
	}
	
	public long getCosts(OreDictPrefix aPrefix) {
		return UT.Code.units(aPrefix.mAmount, U, mDuration, T);
	}
}