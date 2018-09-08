package gregtech.loaders.c.mod;

import static gregapi.data.CS.*;

import gregapi.config.ConfigCategories;
import gregapi.data.CS.ConfigsGT;
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

public class Loader_Recipes_IndustrialCraft_Scrap implements Runnable {
	@Override
	public void run() {if (MD.IC2.mLoaded) {
		if (!MD.IC2C.mLoaded && COMPAT_IC2 != null) {OUT.println("GT_Mod: (re-)adding Scrapbox Drops.");
			COMPAT_IC2.scrapbox(9.50F, ST.make(Items.wooden_hoe, 1, 0));
			COMPAT_IC2.scrapbox(2.00F, ST.make(Items.wooden_axe, 1, 0));
			COMPAT_IC2.scrapbox(2.00F, ST.make(Items.wooden_sword, 1, 0));
			COMPAT_IC2.scrapbox(2.00F, ST.make(Items.wooden_shovel, 1, 0));
			COMPAT_IC2.scrapbox(2.00F, ST.make(Items.wooden_pickaxe, 1, 0));
			COMPAT_IC2.scrapbox(2.00F, ST.make(Items.sign, 1, 0));
			COMPAT_IC2.scrapbox(9.50F, ST.make(Items.stick, 1, 0));
			COMPAT_IC2.scrapbox(5.00F, ST.make(Blocks.dirt, 1, 0));
			COMPAT_IC2.scrapbox(3.00F, ST.make(Blocks.grass, 1, 0));
			COMPAT_IC2.scrapbox(3.00F, ST.make(Blocks.gravel, 1, 0));
			COMPAT_IC2.scrapbox(0.50F, ST.make(Blocks.pumpkin, 1, 0));
			COMPAT_IC2.scrapbox(1.00F, ST.make(Blocks.soul_sand, 1, 0));
			COMPAT_IC2.scrapbox(2.00F, ST.make(Blocks.netherrack, 1, 0));
			COMPAT_IC2.scrapbox(1.00F, ST.make(Items.bone, 1, 0));
			COMPAT_IC2.scrapbox(9.00F, ST.make(Items.rotten_flesh, 1, 0));
			COMPAT_IC2.scrapbox(0.40F, ST.make(Items.cooked_porkchop, 1, 0));
			COMPAT_IC2.scrapbox(0.40F, ST.make(Items.cooked_beef, 1, 0));
			COMPAT_IC2.scrapbox(0.40F, ST.make(Items.cooked_chicken, 1, 0));
			COMPAT_IC2.scrapbox(0.50F, IL.Food_Apple_Red.get(1));
			COMPAT_IC2.scrapbox(0.50F, IL.Food_Bread.get(1));
			COMPAT_IC2.scrapbox(0.10F, ST.make(Items.cake, 1, 0));
			COMPAT_IC2.scrapbox(1.00F, IL.IC2_Food_Can_Filled.get(1));
			COMPAT_IC2.scrapbox(2.00F, IL.IC2_Food_Can_Spoiled.get(1));
			COMPAT_IC2.scrapbox(1.00F, IL.Cell_Water.get(1));
			COMPAT_IC2.scrapbox(2.00F, IL.Cell_Empty.get(1));
			COMPAT_IC2.scrapbox(5.00F, OP.plate.mat(MT.Paper, 1));
			COMPAT_IC2.scrapbox(1.00F, ST.make(Items.leather, 1, 0));
			COMPAT_IC2.scrapbox(1.00F, ST.make(Items.feather, 1, 0));
			COMPAT_IC2.scrapbox(0.70F, IL.IC2_Plantball.get(1));
			COMPAT_IC2.scrapbox(3.80F, OP.dust.mat(MT.Wood, 1));
			COMPAT_IC2.scrapbox(0.60F, ST.make(Items.slime_ball, 1, 0));
			COMPAT_IC2.scrapbox(0.80F, OP.dust.mat(MT.Rubber, 1));
			COMPAT_IC2.scrapbox(2.70F, ST.mkic("suBattery", 1));
			COMPAT_IC2.scrapbox(3.20F, IL.Circuit_Plate_Empty.get(1));
			COMPAT_IC2.scrapbox(1.60F, IL.Circuit_Plate_Copper.get(1));
			COMPAT_IC2.scrapbox(0.40F, IL.Circuit_Plate_Gold.get(1));
			COMPAT_IC2.scrapbox(0.10F, IL.Circuit_Plate_Platinum.get(1));
			COMPAT_IC2.scrapbox(4.80F, IL.Circuit_Part_Basic.get(1));
			COMPAT_IC2.scrapbox(1.60F, IL.Circuit_Part_Good.get(1));
			COMPAT_IC2.scrapbox(1.20F, IL.Circuit_Part_Advanced.get(1));
			COMPAT_IC2.scrapbox(0.40F, IL.Circuit_Part_Elite.get(1));
			COMPAT_IC2.scrapbox(0.36F, IL.Circuit_Part_Master.get(1));
			COMPAT_IC2.scrapbox(0.04F, IL.Circuit_Part_Ultimate.get(1));
			COMPAT_IC2.scrapbox(2.00F, ST.mkic("insulatedCopperCableItem", 1));
			COMPAT_IC2.scrapbox(0.40F, ST.mkic("insulatedGoldCableItem", 1));
			COMPAT_IC2.scrapbox(0.20F, OP.scrapGt.mat(MT.SiO2				, 1));
			COMPAT_IC2.scrapbox(0.90F, OP.scrapGt.mat(MT.Redstone			, 1));
			COMPAT_IC2.scrapbox(0.80F, OP.scrapGt.mat(MT.Glowstone			, 1));
			COMPAT_IC2.scrapbox(0.80F, OP.scrapGt.mat(MT.Coal				, 1));
			COMPAT_IC2.scrapbox(2.50F, OP.scrapGt.mat(MT.Charcoal			, 1));
			COMPAT_IC2.scrapbox(1.00F, OP.scrapGt.mat(MT.Fe					, 1));
			COMPAT_IC2.scrapbox(1.00F, OP.scrapGt.mat(MT.Au					, 1));
			COMPAT_IC2.scrapbox(0.50F, OP.scrapGt.mat(MT.Ag					, 1));
			COMPAT_IC2.scrapbox(0.50F, OP.scrapGt.mat(MT.Electrum			, 1));
			COMPAT_IC2.scrapbox(1.20F, OP.scrapGt.mat(MT.Sn					, 1));
			COMPAT_IC2.scrapbox(1.20F, OP.scrapGt.mat(MT.Cu					, 1));
			COMPAT_IC2.scrapbox(0.50F, OP.scrapGt.mat(MT.Al2O3				, 1));
			COMPAT_IC2.scrapbox(0.50F, OP.scrapGt.mat(MT.Pb					, 1));
			COMPAT_IC2.scrapbox(0.50F, OP.scrapGt.mat(MT.Ni					, 1));
			COMPAT_IC2.scrapbox(0.50F, OP.scrapGt.mat(MT.Zn					, 1));
			COMPAT_IC2.scrapbox(0.50F, OP.scrapGt.mat(MT.Brass				, 1));
			COMPAT_IC2.scrapbox(0.50F, OP.scrapGt.mat(MT.Steel				, 1));
			COMPAT_IC2.scrapbox(1.50F, OP.scrapGt.mat(MT.Obsidian			, 1));
			COMPAT_IC2.scrapbox(1.50F, OP.scrapGt.mat(MT.S					, 1));
			COMPAT_IC2.scrapbox(2.00F, OP.scrapGt.mat(MT.KNO3				, 1));
			COMPAT_IC2.scrapbox(2.00F, OP.scrapGt.mat(MT.NaNO3				, 1));
			COMPAT_IC2.scrapbox(2.00F, OP.scrapGt.mat(MT.Lazurite			, 1));
			COMPAT_IC2.scrapbox(2.00F, OP.scrapGt.mat(MT.Pyrite				, 1));
			COMPAT_IC2.scrapbox(2.00F, OP.scrapGt.mat(MT.CaCO3				, 1));
			COMPAT_IC2.scrapbox(2.00F, OP.scrapGt.mat(MT.Sodalite			, 1));
			COMPAT_IC2.scrapbox(4.00F, OP.scrapGt.mat(MT.Netherrack			, 1));
			COMPAT_IC2.scrapbox(4.00F, OP.scrapGt.mat(MT.Flint				, 1));
			COMPAT_IC2.scrapbox(0.03F, OP.scrapGt.mat(MT.Pt					, 1));
			COMPAT_IC2.scrapbox(0.10F, OP.scrapGt.mat(MT.WO3				, 1));
			COMPAT_IC2.scrapbox(0.03F, OP.scrapGt.mat(MT.Cr					, 1));
			COMPAT_IC2.scrapbox(0.03F, OP.scrapGt.mat(MT.TiO2				, 1));
			COMPAT_IC2.scrapbox(0.03F, OP.scrapGt.mat(MT.Mg					, 1));
			COMPAT_IC2.scrapbox(0.03F, OP.scrapGt.mat(MT.Endstone			, 1));
			COMPAT_IC2.scrapbox(0.15F, OP.scrapGt.mat(MT.Pyrope				, 1));
			COMPAT_IC2.scrapbox(0.20F, OP.scrapGt.mat(MT.Almandine			, 1));
			COMPAT_IC2.scrapbox(0.20F, OP.scrapGt.mat(MT.Spessartine		, 1));
			COMPAT_IC2.scrapbox(0.20F, OP.scrapGt.mat(MT.Andradite			, 1));
			COMPAT_IC2.scrapbox(0.15F, OP.scrapGt.mat(MT.Grossular			, 1));
			COMPAT_IC2.scrapbox(0.10F, OP.scrapGt.mat(MT.Uvarovite			, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.Olivine			, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.Ruby				, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.BlueSapphire		, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.PurpleSapphire		, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.GreenSapphire		, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.YellowSapphire		, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.OrangeSapphire		, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.Emerald			, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.Aquamarine			, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.Morganite			, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.Heliodor			, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.Goshenite			, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.Bixbite			, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.Maxixe				, 1));
			COMPAT_IC2.scrapbox(0.05F, OP.scrapGt.mat(MT.Diamond			, 1));
		}
		
		if (ConfigsGT.RECIPES.get(ConfigCategories.Recipes.disabledrecipes, "easymobgrinderrecycling", T)) {OUT.println("GT_Mod: Adding certain Mob Drops to the Recycler Blacklist.");
			// Skeletons
			COMPAT_IC2.blacklist(ST.make(Items.arrow, 1, 0));
			COMPAT_IC2.blacklist(ST.make(Items.bone, 1, 0));
			COMPAT_IC2.blacklist(IL.Dye_Bonemeal.get(1));
			
			// Zombies
			COMPAT_IC2.blacklist(ST.make(Items.rotten_flesh, 1, 0));
			
			// Spiders
			COMPAT_IC2.blacklist(ST.make(Items.string, 1, 0));
			
			// Chicken Eggs
			COMPAT_IC2.blacklist(ST.make(Items.egg, 1, 0));
		}
		if (ConfigsGT.RECIPES.get(ConfigCategories.Recipes.disabledrecipes, "easystonerecycling", T)) {OUT.println("GT_Mod: Adding Stone Generator related Stuff to the Recycler Blacklist.");
			ItemStack tStack = ST.make(Blocks.cobblestone, 1, 0);
			while (tStack != null) {
				COMPAT_IC2.blacklist(tStack);
				tStack = CR.get(tStack, tStack, tStack, tStack, tStack, tStack, tStack, tStack, tStack);
			}
			COMPAT_IC2.blacklist(ST.make(Blocks.cobblestone_wall		, 1, W));
			COMPAT_IC2.blacklist(ST.make(Blocks.sandstone_stairs		, 1, W));
			COMPAT_IC2.blacklist(ST.make(Blocks.stone_stairs			, 1, W));
			COMPAT_IC2.blacklist(ST.make(Blocks.stone_brick_stairs	, 1, W));
			COMPAT_IC2.blacklist(RM.get_smelting(ST.make(Blocks.stone, 1, 0), F, null));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.glass, 1, 0), null, null, ST.make(Blocks.glass, 1, 0)));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.stone, 1, 0), null, null, ST.make(Blocks.stone, 1, 0)));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.cobblestone, 1, 0), null, null, ST.make(Blocks.cobblestone, 1, 0)));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.stone, 1, 0), null, ST.make(Blocks.stone, 1, 0), null, ST.make(Blocks.stone, 1, 0)));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.stone, 1, 0), ST.make(Blocks.glass, 1, 0), ST.make(Blocks.stone, 1, 0)));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.cobblestone, 1, 0), ST.make(Blocks.glass, 1, 0), ST.make(Blocks.cobblestone, 1, 0)));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.sandstone, 1, 0), ST.make(Blocks.glass, 1, 0), ST.make(Blocks.sandstone, 1, 0)));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.sand, 1, 0), ST.make(Blocks.glass, 1, 0), ST.make(Blocks.sand, 1, 0)));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.sandstone, 1, 0), ST.make(Blocks.sandstone, 1, 0), ST.make(Blocks.sandstone, 1, 0), ST.make(Blocks.sandstone, 1, 0), ST.make(Blocks.sandstone, 1, 0), ST.make(Blocks.sandstone, 1, 0)));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.glass, 1, 0)));
			COMPAT_IC2.blacklist(CR.get(ST.make(Blocks.glass, 1, 0), ST.make(Blocks.glass, 1, 0)));
		}
	}}
}