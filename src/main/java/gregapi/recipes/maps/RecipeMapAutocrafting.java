package gregapi.recipes.maps;

import static gregapi.data.CS.*;

import java.util.Collection;
import java.util.List;

import gregapi.code.ArrayListNoNulls;
import gregapi.data.IL;
import gregapi.data.LH;
import gregapi.gui.Slot_Normal;
import gregapi.gui.Slot_Whitelist;
import gregapi.item.IItemGTHandTool;
import gregapi.oredict.OreDictManager;
import gregapi.random.IHasWorldAndCoords;
import gregapi.recipes.ICraftingRecipeGT;
import gregapi.recipes.Recipe;
import gregapi.recipes.Recipe.RecipeMap;
import gregapi.tileentity.ITileEntityInventoryGUI;
import gregapi.tileentity.computer.ITileEntityUSBPort;
import gregapi.tileentity.delegate.DelegatorTileEntity;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidStack;

/**
 * @author Gregorius Techneticies
 */
public class RecipeMapAutocrafting extends RecipeMap {
	public RecipeMapAutocrafting(Collection<Recipe> aRecipeList, String aUnlocalizedName, String aNameLocal, String aNameNEI, long aProgressBarDirection, long aProgressBarAmount, String aNEIGUIPath, long aInputItemsCount, long aOutputItemsCount, long aMinimalInputItems, long aInputFluidCount, long aOutputFluidCount, long aMinimalInputFluids, long aMinimalInputs, long aPower, String aNEISpecialValuePre, long aNEISpecialValueMultiplier, String aNEISpecialValuePost, boolean aShowVoltageAmperageInNEI, boolean aNEIAllowed, boolean aConfigAllowed, boolean aNeedsOutputs) {
		super(aRecipeList, aUnlocalizedName, aNameLocal, aNameNEI, aProgressBarDirection, aProgressBarAmount, aNEIGUIPath, aInputItemsCount, aOutputItemsCount, aMinimalInputItems, aInputFluidCount, aOutputFluidCount, aMinimalInputFluids, aMinimalInputs, aPower, aNEISpecialValuePre, aNEISpecialValueMultiplier, aNEISpecialValuePost, aShowVoltageAmperageInNEI, aNEIAllowed, aConfigAllowed, aNeedsOutputs);
	}
	
	public static final List<IRecipe> ALLOWED_RECIPES = new ArrayListNoNulls();
	public static final List<IRecipe> RECENT_RECIPES = new ArrayListNoNulls();
	
	@Override
	public Recipe findRecipe(IHasWorldAndCoords aTileEntity, Recipe aRecipe, boolean aNotUnificated, long aSize, ItemStack aSpecialSlot, FluidStack[] aFluids, ItemStack... aInputs) {
		Recipe rRecipe = super.findRecipe(aTileEntity, aRecipe, aNotUnificated, aSize, aSpecialSlot, aFluids, aInputs);
		if (rRecipe != null || aSpecialSlot == null || aInputs == null || aInputs.length < 1 || GAPI_POST.mFinishedServerStarted <= 0) return rRecipe;
		
		ItemStack[] tBlueprint = getBlueprint(aTileEntity, aSpecialSlot);
		
		if (tBlueprint.length <= 0) return null;
		
		for (ItemStack tPlan : tBlueprint) if (tPlan != null && tPlan.getItem() instanceof IItemGTHandTool) return null;
		
		if (ALLOWED_RECIPES.isEmpty()) {
			for (Object tCraftingRecipe : CraftingManager.getInstance().getRecipeList()) if (tCraftingRecipe instanceof IRecipe) {
				if (!(tCraftingRecipe instanceof ICraftingRecipeGT) || ((ICraftingRecipeGT)tCraftingRecipe).isAutocraftableByGT()) {
					ALLOWED_RECIPES.add((IRecipe)tCraftingRecipe);
				}
			}
		}
		
		InventoryCrafting tCraftInv = new InventoryCrafting(new Container() {@Override public boolean canInteractWith(EntityPlayer var1) {return F;}}, 3, 3);
		for (int i = 0; i < 9; i++) tCraftInv.setInventorySlotContents(i, tBlueprint[i]);
		
		IRecipe tIRecipe = null;
		
		for (int i = 0, j = RECENT_RECIPES.size(); i < j; i++) {
			if (RECENT_RECIPES.get(i).matches(tCraftInv, aTileEntity == null ? DW : aTileEntity.getWorld())) {
				tIRecipe = RECENT_RECIPES.get(i);
				break;
			}
		}
		
		if (tIRecipe == null) for (int i = 0, j = ALLOWED_RECIPES.size(); i < j; i++) {
			if (ALLOWED_RECIPES.get(i).matches(tCraftInv, aTileEntity == null ? DW : aTileEntity.getWorld())) {
				tIRecipe = ALLOWED_RECIPES.get(i);
				ALLOWED_RECIPES.remove(i);
				RECENT_RECIPES.add(tIRecipe);
				break;
			}
		}
		
		if (tIRecipe == null) return null;
		
		ItemStack tOutput = tIRecipe.getCraftingResult(tCraftInv);
		
		if (ST.invalid(tOutput)) return null; 
		
		ArrayListNoNulls<ItemStack> tInputs = new ArrayListNoNulls();
		ArrayListNoNulls<ItemStack> tOutputs = new ArrayListNoNulls(F, tOutput);
		
		for (ItemStack tPlan : tBlueprint) if (tPlan != null) {
			boolean temp = T;
			for (ItemStack tInput : tInputs) if (ST.equal(tInput, tPlan, F)) {
				tInput.stackSize++;
				tOutputs.add(ST.container(tPlan, F));
				temp = F;
			}
			if (temp) {
				tInputs.add(ST.amount(1, tPlan));
				tOutputs.add(ST.container(tPlan, F));
			}
		}
		
		for (ItemStack tInput : tInputs) if (OM.is_("gt:autocrafterinfinite", tInput)) tInput.stackSize = 0;
		
		return new Recipe(T, F, T, tInputs.toArray(new ItemStack[tInputs.size()]), tOutputs.toArray(new ItemStack[tOutputs.size()]), null, null, null, null, 1024, 16, 0);
	}
	
	public ItemStack[] getBlueprint(IHasWorldAndCoords aTileEntity, ItemStack aSpecialSlot) {
		ItemStack[] rBlueprint = ZL_IS;
		
		if (IL.Paper_Blueprint_Used.equal(aSpecialSlot, F, T)) {
			rBlueprint = UT.NBT.getBlueprintCrafting(aSpecialSlot);
		} else if (OM.is_(OD_USB_STICKS[1], aSpecialSlot)) {
			if (!aSpecialSlot.hasTagCompound()) return rBlueprint;
			NBTTagCompound tData = aSpecialSlot.getTagCompound().getCompoundTag(NBT_USB_DATA);
			if (tData == null) return rBlueprint;
			rBlueprint = UT.NBT.getBlueprintCrafting(tData);
		} else if (OM.is_(OD_USB_CABLES[1], aSpecialSlot)) {
			if (aTileEntity == null) return rBlueprint;
			for (byte tSide : ALL_SIDES_VALID_ONLY[aSpecialSlot.hasTagCompound() && aSpecialSlot.getTagCompound().hasKey(NBT_USB_DIRECTION) ? aSpecialSlot.getTagCompound().getByte(NBT_USB_DIRECTION) : SIDE_ANY]) {
				DelegatorTileEntity<TileEntity> tDelegator = aTileEntity.getAdjacentTileEntity(tSide);
				if (tDelegator.mTileEntity instanceof ITileEntityUSBPort) {
					NBTTagCompound tData = ((ITileEntityUSBPort)tDelegator.mTileEntity).getUSBData(tDelegator.mSideOfTileEntity, 1);
					if (tData == null) continue;
					rBlueprint = UT.NBT.getBlueprintCrafting(tData);
					if (rBlueprint.length > 0) return rBlueprint;
				}
			}
		}
		
		return rBlueprint;
	}
	
	@Override
	public boolean containsInput(ItemStack aStack, IHasWorldAndCoords aTileEntity, ItemStack aSpecialSlot) {
		ItemStack[] tRecipe = getBlueprint(aTileEntity, aSpecialSlot);
		for (ItemStack tStack : tRecipe) if (ST.equal(tStack, aStack, F)) return T;
		return super.containsInput(aStack, aTileEntity, aSpecialSlot);
	}
	
	@Override
	public Slot_Normal getSpecialSlot(ITileEntityInventoryGUI aInventory, int aIndex, int aX, int aY) {
		return new Slot_Whitelist(aInventory, aIndex, aX, aY, OreDictManager.getOres("gt:autocrafterblueprintitem", F).toArray(ZL_IS)).setTooltip(LH.AUTOCRAFTING_INSERT_BLUEPRINT, LH.Chat.WHITE);
	}
}