package gregtech.loaders.c.mod;

import static gregapi.data.CS.*;

import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.util.CR;
import gregapi.util.ST;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Loader_Recipes_Ganys implements Runnable {
	@Override
	public void run() {
		if (MD.EtFu.mLoaded) {OUT.println("GT_Mod: Doing Recipes of the Future.");
			ItemStack tEtFuturumPurpur = ST.make(MD.EtFu, "purpur_block", 1, 0), tEtFuturumPurpurPillar = ST.make(MD.EtFu, "purpur_pillar", 1, 0);
			CR.shapeless(							tEtFuturumPurpur, CR.DEF, new Object[] {tEtFuturumPurpurPillar});
			CR.shaped(								ST.make(MD.EtFu, "slime", 1, 0), CR.DEF | CR.DEL_OTHER_SHAPED_RECIPES | CR.DEL_OTHER_NATIVE_RECIPES, "XXX", "XXX", "XXX", 'X', ST.make(Items.slime_ball, 1, W));
			RM.ic2_compressor(						ST.make(Items.slime_ball, 9, 0), ST.make(MD.EtFu, "slime", 1, 0));
			RM.Compressor.addRecipe1(T, 16, 16,		ST.make(Items.slime_ball, 9, W), ST.make(MD.EtFu, "slime", 1, 0));
			RM.Boxinator.addRecipe2(T, 16, 16,		ST.make(Items.slime_ball, 9, W), ST.tag(9), ST.make(MD.EtFu, "slime", 1, 0));
			RM.Unboxinator.addRecipe1(T, 16, 16,	ST.make(MD.EtFu, "slime", 1, 0), ST.make(Items.slime_ball, 9, 0));
			RM.ic2_extractor(						ST.make(MD.EtFu, "slime", 1, 0), ST.make(Items.slime_ball, 9, 0));
			RM.Squeezer.addRecipe1(T, 16, 16,		ST.make(MD.EtFu, "rose", 1, 0), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Red], ZL_IS);
			RM.Juicer.addRecipe1(T, 16, 16,			ST.make(MD.EtFu, "rose", 1, 0), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Red], ZL_IS);
		    RM.ic2_extractor(						ST.make(MD.EtFu, "rose", 1, 0), ST.make(Items.dye, 2, DYE_INDEX_Red));
		    RM.Squeezer.addRecipe1(T, 16, 16,		ST.make(MD.EtFu, "sponge", 1, 1), ST.make(MD.EtFu, "sponge", 1, 0));
		    RM.Drying.addRecipe1(T, 16, 16,			ST.make(MD.EtFu, "sponge", 1, 1), ST.make(MD.EtFu, "sponge", 1, 0));
			RM.Hammer.addRecipe1(T, 16, 16,			ST.make(MD.EtFu, "red_sandstone", 1, W), ST.make(Blocks.sand, 1, 1));
			RM.Crusher.addRecipe1(T, 16, 16,		ST.make(MD.EtFu, "red_sandstone", 1, W), ST.make(Blocks.sand, 1, 1));
			RM.sawing(16, 16, F, 100,				ST.make(MD.EtFu, "red_sandstone", 1, W), ST.make(MD.EtFu, "red_sandstone_slab", 1, 0));
			RM.Compressor.addRecipe1(T, 16, 32,		ST.make(Blocks.sand, 4, 1), ST.make(MD.EtFu, "red_sandstone", 1, 0));
			RM.generify(							ST.make(Blocks.sponge, 1, W), ST.make(MD.EtFu, "sponge", 1, 0));
			RM.generify(							ST.make(MD.EtFu, "sponge", 1, 0), ST.make(Blocks.sponge, 1, 0));
			RM.generify(							ST.make(Blocks.double_plant, 1, 4), ST.make(MD.EtFu, "rose", 6, 0));
			RM.generify(							ST.make(MD.EtFu, "rose", 6, 0), ST.make(Blocks.double_plant, 1, 4));
			RM.generify(							tEtFuturumPurpurPillar, tEtFuturumPurpur);
			
			CR.remout(IL.EtFu_Granite.get(1));
			CR.remout(IL.EtFu_Diorite.get(1));
			CR.remout(IL.EtFu_Andesite.get(1));
			CR.remout(IL.EtFu_Granite_Smooth.get(1));
			CR.remout(IL.EtFu_Diorite_Smooth.get(1));
			CR.remout(IL.EtFu_Andesite_Smooth.get(1));
			
			if (MD.CHSL.mLoaded) {
				ItemStack tChiselPurpur = ST.make(MD.CHSL, "purpur", 1, 0);
				CR.remout(tChiselPurpur);
				RM.generify(tChiselPurpur, tEtFuturumPurpur);
				RM.generify(tEtFuturumPurpur, tChiselPurpur);
				CR.shapeless(tChiselPurpur, CR.DEF, new Object[] {tEtFuturumPurpur});
				CR.shapeless(tEtFuturumPurpur, CR.DEF, new Object[] {tChiselPurpur});
				CR.shaped(ST.make(MD.EtFu, "purpur_stairs", 4, 0), CR.DEF_MIR, new Object[] {"P  ", "PP ", "PPP", 'P', ST.make(MD.CHSL, "purpur", 1, W)});
				CR.shaped(ST.make(MD.EtFu, "purpur_slab", 6, 0), CR.DEF_MIR, new Object[] {"PPP", 'P', ST.make(MD.CHSL, "purpur", 1, W)});
			}
		}
		if (MD.GaSu.mLoaded) {OUT.println("GT_Mod: Doing Recipes for Ganys Surface.");
			if (MD.EtFu.mLoaded) {
				CR.remout(MD.GaSu, "slimeBlock");
			} else {
				CR.shaped(							ST.make(MD.GaSu, "slimeBlock", 1, 0), CR.DEF | CR.DEL_OTHER_SHAPED_RECIPES | CR.DEL_OTHER_NATIVE_RECIPES, "XXX", "XXX", "XXX", 'X', ST.make(Items.slime_ball, 1, W));
				RM.ic2_compressor(					ST.make(Items.slime_ball, 9, 0), ST.make(MD.GaSu, "slimeBlock", 1, 0));
				RM.Compressor.addRecipe1(T, 16, 16,	ST.make(Items.slime_ball, 9, W), ST.make(MD.GaSu, "slimeBlock", 1, 0));
				RM.Boxinator.addRecipe2(T, 16, 16,	ST.make(Items.slime_ball, 9, W), ST.tag(9), ST.make(MD.GaSu, "slimeBlock", 1, 0));
			}
			RM.Unboxinator.addRecipe1(T, 16, 16,	ST.make(MD.GaSu, "slimeBlock", 1, 0), ST.make(Items.slime_ball, 9, 0));
			RM.ic2_extractor(						ST.make(MD.GaSu, "slimeBlock", 1, 0), ST.make(Items.slime_ball, 9, 0));
			CR.shapeless(							ST.make(Items.slime_ball, 9, 0), CR.DEF, new Object[] {ST.make(MD.GaSu, "slimeBlock", 1, 0)});
			
			RM.Boxinator.addRecipe2(T, 16, 16,		ST.make(Items.flint, 9, W), ST.tag(9), ST.make(MD.GaSu, "storage", 1, 0));
			RM.Unboxinator.addRecipe1(T, 16, 16,	ST.make(MD.GaSu, "storage", 1, 0), ST.make(Items.flint, 9, 0));
			RM.ic2_extractor(						ST.make(MD.GaSu, "storage", 1, 0), ST.make(Items.flint, 9, 0));
			
			RM.Boxinator.addRecipe2(T, 16, 16,		ST.make(Items.carrot, 9, W), ST.tag(9), ST.make(MD.GaSu, "storage", 1, 1));
			RM.Unboxinator.addRecipe1(T, 16, 16,	ST.make(MD.GaSu, "storage", 1, 1), ST.make(Items.carrot, 9, 0));
			RM.ic2_extractor(						ST.make(MD.GaSu, "storage", 1, 1), ST.make(Items.carrot, 9, 0));
			
			CR.remout(IL.GaSu_Granite.get(1));
			CR.remout(IL.GaSu_Diorite.get(1));
			CR.remout(IL.GaSu_Andesite.get(1));
			CR.remout(IL.GaSu_Granite_Smooth.get(1));
			CR.remout(IL.GaSu_Diorite_Smooth.get(1));
			CR.remout(IL.GaSu_Andesite_Smooth.get(1));
		}
		if (MD.GaNe.mLoaded) {OUT.println("GT_Mod: Doing Recipes for Ganys Nether.");
			RM.pulverizing(ST.make(MD.GaNe, "spectreWheatItem", 1, 0), ST.make(MD.GaNe, "spookyFlour", 1, 0));
			
			CR.remove(OP.nugget.mat(MT.Blaze, 1), NI, NI, OP.nugget.mat(MT.Blaze, 1), NI, NI, OP.nugget.mat(MT.Blaze, 1));
			
			RM.Mixer.addRecipe2(T, 16, 32, ST.make(MD.GaNe, "spookyFlour", 2, 0), ST.make(Blocks.sand, 1, W), ST.make(Blocks.soul_sand, 2, 0));
		}
		if (MD.GaEn.mLoaded) {OUT.println("GT_Mod: Doing Recipes for Ganys End.");
			//
		}
	}
}