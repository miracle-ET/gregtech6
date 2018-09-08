package gregapi.item.multiitem.food;

import static gregapi.data.CS.*;

import java.util.List;

import gregapi.data.CS.DrinksGT;
import gregapi.data.MD;
import gregapi.util.UT;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class FoodStatFluid implements IFoodStat {
	public static final FoodStatFluid INSTANCE = new FoodStatFluid();
	
	@Override
	public int getFoodLevel(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getFoodLevel(aItem, aStack, aPlayer);
	}
	
	@Override
	public float getSaturation(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getSaturation(aItem, aStack, aPlayer);
	}
	
	@Override
	public float getHydration(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getHydration(aItem, aStack, aPlayer);
	}
	
	@Override
	public float getTemperature(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return DEF_ENV_TEMP;
		return rStats.getTemperature(aItem, aStack, aPlayer);
	}
	
	@Override
	public float getTemperatureEffect(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return 0;
		return rStats.getTemperatureEffect(aItem, aStack, aPlayer);
	}
	
	@Override
	public boolean alwaysEdible(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return DRINKS_ALWAYS_DRINKABLE || MD.ENVM.mLoaded;
		return rStats.alwaysEdible(aItem, aStack, aPlayer);
	}
	
	@Override
	public boolean isRotten(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return F;
		return rStats.isRotten(aItem, aStack, aPlayer);
	}
	
	@Override
	public EnumAction getFoodAction(Item aItem, ItemStack aStack) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return EnumAction.drink;
		return rStats.getFoodAction(aItem, aStack);
	}
	
	@Override
	public boolean useAppleCoreFunctionality(Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return F;
		return rStats.useAppleCoreFunctionality(aItem, aStack, aPlayer);
	}
	
	@Override
	public void onEaten(Item aItem, ItemStack aStack, EntityPlayer aPlayer, boolean aConsumeItem) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return;
		rStats.onEaten(aItem, aStack, aPlayer, aConsumeItem);
	}
	
	@Override
	public void addAdditionalToolTips(Item aItem, List aList, ItemStack aStack, boolean aF3_H) {
		IFoodStat rStats = null;
		FluidStack tFluid = UT.Fluids.getFluidForFilledItem(aStack, T);
		if (tFluid != null) rStats = DrinksGT.REGISTER.get(tFluid.getFluid().getName());
		if (rStats == null) return;
		rStats.addAdditionalToolTips(aItem, aList, aStack, aF3_H);
	}
}