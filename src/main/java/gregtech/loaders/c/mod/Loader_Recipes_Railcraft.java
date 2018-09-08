package gregtech.loaders.c.mod;

import static gregapi.data.CS.*;
import static gregapi.util.CR.*;

import gregapi.config.ConfigCategories;
import gregapi.data.ANY;
import gregapi.data.CS.ConfigsGT;
import gregapi.data.CS.ItemsGT;
import gregapi.data.FL;
import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.data.OD;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.oredict.IOreDictListenerEvent;
import gregapi.oredict.OreDictListenerEvent_Names;
import gregapi.oredict.OreDictPrefix;
import gregapi.util.CR;
import gregapi.util.OM;
import gregapi.util.ST;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class Loader_Recipes_Railcraft implements Runnable {
	@Override
	public void run() {
		if (MD.RC.mLoaded) {
			OUT.println("GT_Mod: Doing RC Recipes.");
			long tBits = DEF_REV | DEL_OTHER_SHAPED_RECIPES | DEL_OTHER_NATIVE_RECIPES | ONLY_IF_HAS_OTHER_RECIPES;
			char tHammer = ' ', tFile = ' ', tWrench = ' ';
			OreDictPrefix tIngot = OP.ingot;
			
			if (ConfigsGT.RECIPES.get(ConfigCategories.Recipes.harderrecipes, "railcraft_stuff_use_tools", T))		{tHammer = 'h'; tFile = 'f'; tWrench = 'w';}
			if (ConfigsGT.RECIPES.get(ConfigCategories.Recipes.harderrecipes, "railcraft_stuff_use_plates", T))		{tIngot = OP.plate;}
			
			CR.shaped(ST.make(MD.RC, "part.gear"				, 2,  3), tBits | MIR												, tHammer+""+tFile	, "XX"					, "XX"					, 'X', tIngot.dat(MT.Sn));
			
			CR.shaped(ST.make(MD.RC, "part.gear"				, 1,  0), tBits														, tHammer+"X "		, "XGX"					, " X"+tFile			, 'X', OP.nugget.dat(MT.Au)								, 'G', ST.make(MD.RC, "part.gear", 1, 3));
			CR.shaped(ST.make(MD.RC, "part.gear"				, 1,  1), tBits														, tHammer+"X "		, "XGX"					, " X"+tFile			, 'X', tIngot.dat(ANY.Fe)								, 'G', ST.make(MD.RC, "part.gear", 1, 3));
			CR.shaped(ST.make(MD.RC, "part.gear"				, 1,  2), tBits														, tHammer+"X "		, "XGX"					, " X"+tFile			, 'X', tIngot.dat(ANY.Steel)							, 'G', ST.make(MD.RC, "part.gear", 1, 3));
			
			CR.shapeless(ST.make(MD.RC, "part.gear"				, 1,  1), CR.DEF_NCC, new Object[] {OP.gearGt.dat(ANY.Fe), ST.make(MD.RC, "part.gear", 1, 3)});
			CR.shapeless(ST.make(MD.RC, "part.gear"				, 1,  2), CR.DEF_NCC, new Object[] {OP.gearGt.dat(ANY.Steel), ST.make(MD.RC, "part.gear", 1, 3)});
			CR.shapeless(IL.RC_Tie_Wood.get(4), CR.DEF_NCC, new Object[] {IL.RC_Bed_Wood});
			CR.shapeless(IL.RC_Tie_Stone.get(4), CR.DEF_NCC, new Object[] {IL.RC_Bed_Stone});
			
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 8,  0), tBits | DEL_IF_NO_DYES									, tWrench+"PP"		, tHammer+"PP"									, 'P', OP.plate.dat(ANY.Fe)								);
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 8,  1), tBits | DEL_IF_NO_DYES									, "GPG"				, "PGP"					, "GPG"					, 'P', OP.plate.dat(ANY.Fe)								, 'G', ST.make(Blocks.glass_pane, 1, W));
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 8,  2), tBits | DEL_IF_NO_DYES									, "BPB"				, "PLP"					, "BPB"					, 'P', OP.plate.dat(ANY.Fe)								, 'B', ST.make(Blocks.iron_bars, 1, W), 'L', ST.make(Blocks.lever, 1, W));
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 1,  3), tBits | DEL_IF_NO_DYES									, tWrench+"P"		, tHammer+"P"									, 'P', OP.plate.dat(ANY.Fe)								);
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 1,  4), tBits | DEL_IF_NO_DYES									, tWrench+"P"		, tHammer+"P"									, 'P', OP.plate.dat(ANY.Steel)							);
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 1,  5), tBits														, "BBB"				, "BFB"					, "BOB"					, 'B', OP.ingot.dat(MT.TECH.Brick)						, 'F', ST.make(Items.fire_charge, 1, W), 'O', OD.craftingFurnace);
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 1,  6), tBits														, "PUP"				, "BFB"					, "POP"					, 'P', OP.plate.dat(ANY.Steel)							, 'B', ST.make(Blocks.iron_bars, 1, W), 'F', ST.make(Items.fire_charge, 1, W), 'U', ST.make(Items.bucket, 1, W), 'O', OD.craftingFurnace);
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 1,  7), tBits | MIR												, "PPP"				, tHammer+"G"+tWrench	, "OTO"					, 'P', OP.nugget.dat(MT.Au)								, 'O', ST.make(MD.RC, "part.gear", 1, 0), 'G', ST.make(Blocks.glass, 1, W), 'T', OD.craftingPiston);
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 1,  8), tBits | MIR												, "PPP"				, tHammer+"G"+tWrench	, "OTO"					, 'P', OP.plate.dat(ANY.Fe)								, 'O', ST.make(MD.RC, "part.gear", 1, 1), 'G', ST.make(Blocks.glass, 1, W), 'T', OD.craftingPiston);
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 1,  9), tBits | MIR												, "PPP"				, tHammer+"G"+tWrench	, "OTO"					, 'P', OP.plate.dat(ANY.Steel)							, 'O', ST.make(MD.RC, "part.gear", 1, 2), 'G', ST.make(Blocks.glass, 1, W), 'T', OD.craftingPiston);
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 1, 10), tBits														, " E "				, " O "					, "OIO"					, 'I', tIngot.dat(MT.Au)								, 'E', OP.gem.dat(MT.EnderPearl), 'O', OP.blockSolid.dat(MT.Obsidian));
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 1, 11), tBits														, "OOO"				, "OEO"					, "OOO"					, 'E', OP.gem.dat(MT.EnderPearl)						, 'O', OP.blockSolid.dat(MT.Obsidian));
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 1, 12), tBits														, "GPG"				, "PAP"					, "GPG"					, 'P', OD.craftingPiston								, 'A', OD.craftingAnvil, 'G', ST.make(MD.RC, "part.gear", 1, 2));
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 8, 13), tBits | DEL_IF_NO_DYES									, tWrench+"PP"		, tHammer+"PP"									, 'P', OP.plate.dat(ANY.Steel)							);
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 8, 14), tBits | DEL_IF_NO_DYES									, "GPG"				, "PGP"					, "GPG"					, 'P', OP.plate.dat(ANY.Steel)							, 'G', ST.make(Blocks.glass_pane, 1, W));
			CR.shaped(ST.make(MD.RC, "machine.beta"				, 8, 15), tBits | DEL_IF_NO_DYES									, "BPB"				, "PLP"					, "BPB"					, 'P', OP.plate.dat(ANY.Steel)							, 'B', ST.make(Blocks.iron_bars, 1, W), 'L', ST.make(Blocks.lever, 1, W));
			
			CR.shaped(IL.RC_ShuntingWireFrame.get(6)					, tBits														, "PPP"				, "R"+tWrench+"R"		, "RRR"					, 'P', OP.plate.dat(ANY.Fe)								, 'R', IL.RC_Rebar.get(1));
			
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 1,  0), tBits														, "IOI"				, "GEG"					, "IOI"					, 'I', tIngot.dat(MT.Au)								, 'G', OP.gem.dat(MT.Diamond), 'E', OP.gem.dat(MT.EnderPearl), 'O', OP.blockSolid.dat(MT.Obsidian));
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 3,  1), tBits														, "BPB"				, "P"+tWrench+"P"		, "BPB"					, 'P', OP.plate.dat(ANY.Steel)							, 'B', OP.blockSolid.dat(ANY.Steel));
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 1,  2), tBits														, "IOI"				, "GEG"					, "IOI"					, 'I', tIngot.dat(MT.Au)								, 'G', OP.gem.dat(ANY.Emerald), 'E', OP.gem.dat(MT.EnderPearl), 'O', OP.blockSolid.dat(MT.Obsidian));
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 4,  3), tBits														, "PPP"				, "PFP"					, "PPP"					, 'P', OP.plate.dat(ANY.Steel)							, 'F', OD.craftingFurnace);
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 1,  5), tBits														, " N "				, "RCR"											, 'R', OD.itemRedstone									, 'N', OP.stone.dat(MT.Netherrack), 'C', ST.make(Items.cauldron, 1, 0));
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 1,  6), tBits														, "PGP"				, "EDE"					, "PGP"					, 'E', OP.gem.dat(ANY.Emerald)							, 'P', OP.plate.dat(ANY.Steel), 'G', ST.make(Blocks.glass_pane, 1, W), 'D', ST.make(Blocks.dispenser, 1, W));
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 1,  8), tBits														, "IPI"				, "PCP"					, "IPI"					, 'P', OD.craftingPiston								, 'I', tIngot.dat(ANY.Fe), 'C', ST.make(Blocks.crafting_table, 1, W));
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 1,  9), tBits														, " I "				, " T "					, " D "					, 'I', ST.make(Blocks.iron_bars, 1, W)					, 'T', ST.make(MD.RC, "machine.beta", 1, 4), 'D', ST.make(Blocks.dispenser, 1, W));
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 1, 10), tBits														, " I "				, "RTR"					, " D "					, 'I', ST.make(Blocks.iron_bars, 1, W)					, 'T', ST.make(MD.RC, "machine.beta", 1, 4), 'D', ST.make(Blocks.dispenser, 1, W), 'R', OD.itemRedstone);
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 1, 10), DEF			 											, "RTR"																, 'R', OD.itemRedstone									, 'T', ST.make(MD.RC, "machine.alpha", 1, 9));
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 1, 11), tBits														, "PCP"				, "CSC"					, "PCP"					, 'P', OD.plankAnyWood									, 'S', OP.plate.dat(ANY.Steel), 'C', ST.make(Items.golden_carrot, 1, 0));
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 1, 13), tBits														, "IOI"				, "GEG"					, "IOI"					, 'I', tIngot.dat(MT.Au)								, 'G', DYE_OREDICTS[DYE_INDEX_Cyan], 'E', OP.gem.dat(MT.EnderPearl), 'O', OP.blockSolid.dat(MT.Obsidian));
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 6, 14), tBits														, "PPP"				, "ISI"					, "PPP"					, 'P', OD.plankAnyWood									, 'I', tIngot.dat(ANY.Fe), 'S', "slimeball");
			CR.shaped(ST.make(MD.RC, "machine.alpha"			, 4, 15), tBits														, "PDP"				, "DBD"					, "PDP"					, 'P', OD.craftingPiston								, 'B', OP.blockSolid.dat(ANY.Steel), 'D', OP.gem.dat(MT.Diamond));
			
			CR.shaped(ST.make(MD.RC, "machine.epsilon"			, 1,  0), tBits														, "PWP"				, "WWW"					, "PWP"					, 'P', OP.plate.dat(ANY.Fe)								, 'W', OP.wireGt02.dat(ANY.Cu));
			CR.shaped(ST.make(MD.RC, "machine.epsilon"			, 1,  5), tBits														, "TSB"				, "SCS"					, "PSP"					, 'P', OD.craftingPiston								, 'S', OP.plate.dat(ANY.Steel), 'B', OD.craftingBook, 'C', ST.make(Blocks.crafting_table, 1, W), 'T', ST.make(Items.diamond_pickaxe, 1, 0));
			
			CR.shaped(ST.make(MD.RC, "tool.crowbar"				, 1,  0), tBits														, tHammer+"DS"		, "DSD"					, "SD"+tFile			, 'S', OP.ingot.dat(ANY.Fe)								, 'D', DYE_OREDICTS[DYE_INDEX_Red]);
			CR.shaped(ST.make(MD.RC, "tool.crowbar.reinforced"	, 1,  0), tBits														, tHammer+"DS"		, "DSD"					, "SD"+tFile			, 'S', OP.ingot.dat(ANY.Steel)							, 'D', DYE_OREDICTS[DYE_INDEX_Red]);
			CR.shaped(ST.make(MD.RC, "tool.whistle.tuner"		, 1,  0), tBits | MIR												, "S"+tHammer+"S"	, "SSS"					, " S"+tFile			, 'S', OP.nugget.dat(ANY.Fe)							);
			CR.shaped(ST.make(MD.RC, "part.turbine.blade"		, 1,  0), tBits														, "S"+tFile			, "S "					, "S"+tHammer			, 'S', tIngot.dat(ANY.Steel)							);
			CR.shaped(ST.make(MD.RC, "part.turbine.disk"		, 1,  0), tBits														, "SSS"				, "SBS"					, "SSS"					, 'B', OP.blockSolid.dat(ANY.Steel)						, 'S', ST.make(MD.RC, "part.turbine.blade", 1, 0));
			CR.shaped(ST.make(MD.RC, "part.turbine.rotor"		, 1,  0), tBits														, "SSS"				, " "+tWrench+" "								, 'S', ST.make(MD.RC, "part.turbine.disk", 1, 0)		);
			CR.shaped(ST.make(MD.RC, "borehead.iron"			, 1,  0), tBits														, "SSS"				, "SBS"					, "SSS"					, 'B', OP.blockSolid.dat(ANY.Fe)						, 'S', tIngot.dat(ANY.Steel));
			CR.shaped(ST.make(MD.RC, "borehead.steel"			, 1,  0), tBits														, "SSS"				, "SBS"					, "SSS"					, 'B', OP.blockSolid.dat(ANY.Steel)						, 'S', tIngot.dat(ANY.Steel));
			CR.shaped(ST.make(MD.RC, "borehead.diamond"			, 1,  0), tBits														, "SSS"				, "SBS"					, "SSS"					, 'B', OP.blockGem.dat(MT.Diamond)						, 'S', tIngot.dat(ANY.Steel));
			
			CR.shaped(ST.make(MD.RC, "cart.loco.steam.solid"	, 1,  0), tBits | DEL_IF_NO_DYES | DEL_OTHER_RECIPES_IF_SAME_NBT	, "TTF"				, "TTF"					, "BCC"					, 'C', ST.make(Items.minecart, 1, 0)					, 'T', ST.make(MD.RC, "machine.beta", 1, 4), 'F', ST.make(MD.RC, "machine.beta", 1, 5), 'B', ST.make(Blocks.iron_bars, 1, W));
			CR.shaped(ST.make(MD.RC, "cart.loco.electric"		, 1,  0), tBits | DEL_IF_NO_DYES | DEL_OTHER_RECIPES_IF_SAME_NBT	, "LP"+tWrench		, "PEP"					, "GCG"					, 'C', ST.make(Items.minecart, 1, 0)					, 'E', ST.make(MD.RC, "machine.epsilon", 1, 0), 'G', ST.make(MD.RC, "part.gear", 1, 2), 'L', ST.make(Blocks.redstone_lamp, 1, W), 'P', OP.plate.dat(ANY.Steel));
			CR.shaped(ST.make(MD.RC, "cart.bore"				, 1,  0), tBits | DEL_IF_NO_DYES | DEL_OTHER_RECIPES_IF_SAME_NBT	, "BCB"				, "FCF"					, tHammer+"A"+tWrench	, 'C', ST.make(Items.minecart, 1, 0)					, 'A', ST.make(Items.chest_minecart, 1, 0), 'F', OD.craftingFurnace, 'B', OP.blockSolid.dat(ANY.Steel));
			
			if (ConfigsGT.RECIPES.get(ConfigCategories.Recipes.harderrecipes, "railcraft_admin_anchor_recipe", F)) {
				CR.shaped(ST.make(MD.RC, "machine.alpha", 1, 4), tBits, "IOI", "GEG", "IOI", 'I', tIngot.dat(MT.Au), 'G', OP.gem.dat(MT.NetherStar), 'E', OP.gem.dat(MT.EnderPearl), 'O', OP.blockSolid.dat(MT.Obsidian));
			} else {
				ItemsGT.DEBUG_ITEMS.add(ST.make(MD.RC, "machine.alpha", 1, 4));
				ItemsGT.ILLEGAL_DROPS.add(ST.make(MD.RC, "machine.alpha", 1, 4));
			}
			
			RM.pulverizing(ST.make(MD.RC, "cube.crushed.obsidian", 1), OP.dust.mat(MT.Obsidian, 7), OP.dust.mat(MT.Obsidian, 1), 25, T);
			
			CR.remout(MD.RC, "part.bleached.clay");
			CR.remout(IL.RC_Concrete.get(1));
			
			RM.Drying.addRecipe1(T, 16,  16, IL.RC_Rebar.get(1), FL.Concrete.make(L), FL.DistW.make(8), IL.RC_Concrete.get(2));
			
			
			new OreDictListenerEvent_Names() {@Override public void addAllListeners() {
			addListener(OD.itemClay, new IOreDictListenerEvent() {@Override public void onOreRegistration(OreDictRegistrationContainer aEvent) {
			RM.Mixer.addRecipe2(T, 16, 16, aEvent.mStack, OM.dust(MT.Bone, U*3), ST.make(MD.RC, "part.bleached.clay", 1, 0));
			}});
			addListener(OD.logWood, new IOreDictListenerEvent() {@Override public void onOreRegistration(OreDictRegistrationContainer aEvent) {
			RM.Bath.addRecipe1(T, 0, 16, aEvent.mStack, MT.Creosote.liquid(U, T), NF, IL.RC_Creosote_Wood.get(1));
			}});
			addListener(OD.slabWood, new IOreDictListenerEvent() {@Override public void onOreRegistration(OreDictRegistrationContainer aEvent) {
			RM.Bath.addRecipe1(T, 0, 16, ST.amount(3, aEvent.mStack), MT.Creosote.liquid(3*U4, T), NF, IL.RC_Tie_Wood.get(1));
			}});
			}};
			
			
			RM.RollFormer.addRecipe1(T, 16,  16, OP.railGt.mat(MT.Al				,  6), IL.RC_Rail_Standard.get( 1));
			RM.RollFormer.addRecipe1(T, 16,  16, OP.railGt.mat(MT.Fe				,  3), IL.RC_Rail_Standard.get( 1));
			RM.RollFormer.addRecipe1(T, 16,  16, OP.railGt.mat(MT.WroughtIron		,  2), IL.RC_Rail_Standard.get( 1));
			RM.RollFormer.addRecipe1(T, 16,  16, OP.railGt.mat(MT.MeteoricIron		,  3), IL.RC_Rail_Standard.get( 2));
			RM.RollFormer.addRecipe1(T, 16,  16, OP.railGt.mat(MT.Bronze			,  4), IL.RC_Rail_Standard.get( 1));
			RM.RollFormer.addRecipe1(T, 16,  32, OP.railGt.mat(MT.HSLA				,  3), IL.RC_Rail_Standard.get( 2));
			RM.RollFormer.addRecipe1(T, 16,  32, OP.railGt.mat(MT.Steel				,  3), IL.RC_Rail_Standard.get( 2));
			RM.RollFormer.addRecipe1(T, 16,  32, OP.railGt.mat(MT.MeteoricSteel		,  1), IL.RC_Rail_Standard.get( 1));
			RM.RollFormer.addRecipe1(T, 16,  16, OP.railGt.mat(MT.StainlessSteel	,  1), IL.RC_Rail_Standard.get( 1));
			RM.RollFormer.addRecipe1(T, 16,  64, OP.railGt.mat(MT.Ti				,  3), IL.RC_Rail_Standard.get( 4));
			RM.RollFormer.addRecipe1(T, 16,  64, OP.railGt.mat(MT.W					,  3), IL.RC_Rail_Standard.get( 4));
			RM.RollFormer.addRecipe1(T, 16,  64, OP.railGt.mat(MT.TungstenSintered	,  3), IL.RC_Rail_Standard.get( 4));
			RM.RollFormer.addRecipe1(T, 64,  32, OP.railGt.mat(MT.Meteorite			,  1), IL.RC_Rail_Reinforced.get( 1));
			RM.RollFormer.addRecipe1(T, 64,  32, OP.railGt.mat(MT.ObsidianSteel		,  1), IL.RC_Rail_Reinforced.get( 1));
			RM.RollFormer.addRecipe1(T, 64,  32, OP.railGt.mat(MT.TungstenSteel		,  1), IL.RC_Rail_Reinforced.get( 2));
			RM.RollFormer.addRecipe1(T, 64,  32, OP.railGt.mat(MT.TungstenCarbide	,  1), IL.RC_Rail_Reinforced.get( 2));
			
			RM.RollFormer.addRecipe1(T, 16, 100, OP.stick.mat(MT.Al					,  3), IL.RC_Rebar.get( 1));
			RM.RollFormer.addRecipe1(T, 16, 200, OP.stick.mat(MT.Fe					,  3), IL.RC_Rebar.get( 2));
			RM.RollFormer.addRecipe1(T, 16, 500, OP.stick.mat(MT.WroughtIron		,  6), IL.RC_Rebar.get( 5));
			RM.RollFormer.addRecipe1(T, 16, 100, OP.stick.mat(MT.Bronze				,  2), IL.RC_Rebar.get( 1));
			RM.RollFormer.addRecipe1(T, 16, 400, OP.stick.mat(MT.Steel				,  3), IL.RC_Rebar.get( 4));
			RM.RollFormer.addRecipe1(T, 16, 400, OP.stick.mat(MT.HSLA				,  3), IL.RC_Rebar.get( 4));
			RM.RollFormer.addRecipe1(T, 16, 200, OP.stick.mat(MT.StainlessSteel		,  1), IL.RC_Rebar.get( 2));
			RM.RollFormer.addRecipe1(T, 16, 800, OP.stick.mat(MT.Ti					,  3), IL.RC_Rebar.get( 8));
			RM.RollFormer.addRecipe1(T, 16, 800, OP.stick.mat(MT.W					,  3), IL.RC_Rebar.get( 8));
			RM.RollFormer.addRecipe1(T, 16, 800, OP.stick.mat(MT.TungstenSintered	,  3), IL.RC_Rebar.get( 8));
			RM.RollFormer.addRecipe1(T, 16, 400, OP.stick.mat(MT.TungstenSteel		,  1), IL.RC_Rebar.get( 4));
			RM.RollFormer.addRecipe1(T, 16, 400, OP.stick.mat(MT.TungstenCarbide	,  1), IL.RC_Rebar.get( 4));
			
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.Al					,  7), IL.RC_Post_Metal.get( 8));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.Fe					,  7), IL.RC_Post_Metal.get(16));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.WroughtIron		,  7), IL.RC_Post_Metal.get(24));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.Bronze				,  7), IL.RC_Post_Metal.get(12));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.Steel				,  7), IL.RC_Post_Metal.get(32));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.HSLA				,  7), IL.RC_Post_Metal.get(32));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.StainlessSteel		,  7), IL.RC_Post_Metal.get(48));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.Ti					,  7), IL.RC_Post_Metal.get(56));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.W					,  7), IL.RC_Post_Metal.get(56));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.TungstenSintered	,  7), IL.RC_Post_Metal.get(56));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.TungstenSteel		,  7), IL.RC_Post_Metal.get(64));
			RM.RollFormer.addRecipe1(T, 16, 224, OP.ingot.mat(MT.TungstenCarbide	,  7), IL.RC_Post_Metal.get(64));
		} else {
			CR.shaped(ST.make(Blocks.rail			,  4, 0), DEF_REV_NCC | DEL_OTHER_SHAPED_RECIPES, "RSR", "RSR", "RSR", 'R', OP.railGt.dat(ANY.Fe), 'S', OP.stick.dat(MT.WoodSealed));
			CR.shaped(ST.make(Blocks.golden_rail	,  4, 0), DEF_REV_NCC | DEL_OTHER_SHAPED_RECIPES, "RSR", "GDG", "RSR", 'R', OP.railGt.dat(ANY.Fe), 'S', OP.stick.dat(MT.WoodSealed), 'D', OD.itemRedstone, 'G', OP.railGt.dat(MT.Au));
			CR.shaped(ST.make(Blocks.detector_rail	,  4, 0), DEF_REV_NCC | DEL_OTHER_SHAPED_RECIPES, "RSR", "RPR", "RDR", 'R', OP.railGt.dat(ANY.Fe), 'S', OP.stick.dat(MT.WoodSealed), 'D', OD.itemRedstone, 'P', ST.make(Blocks.stone_pressure_plate, 1, W));
			
			CR.shaped(ST.make(Blocks.activator_rail	,  1, 0), DEF | DEL_OTHER_SHAPED_RECIPES, "RSR", "RTR", "RSR", 'R', OP.railGt.dat(MT.Al					), 'S', OP.stick.dat(MT.WoodSealed), 'T', OD.craftingRedstoneTorch);
			CR.shaped(ST.make(Blocks.activator_rail	,  1, 0), DEF | DEL_OTHER_SHAPED_RECIPES, "RSR", "RTR", "RSR", 'R', OP.railGt.dat(MT.Bronze				), 'S', OP.stick.dat(MT.WoodSealed), 'T', OD.craftingRedstoneTorch);
			CR.shaped(ST.make(Blocks.activator_rail	,  2, 0), DEF | DEL_OTHER_SHAPED_RECIPES, "RSR", "RTR", "RSR", 'R', OP.railGt.dat(ANY.Fe				), 'S', OP.stick.dat(MT.WoodSealed), 'T', OD.craftingRedstoneTorch);
			CR.shaped(ST.make(Blocks.activator_rail	,  3, 0), DEF | DEL_OTHER_SHAPED_RECIPES, "RSR", "RTR", "RSR", 'R', OP.railGt.dat(ANY.Steel				), 'S', OP.stick.dat(MT.WoodSealed), 'T', OD.craftingRedstoneTorch);
			CR.shaped(ST.make(Blocks.activator_rail	,  4, 0), DEF | DEL_OTHER_SHAPED_RECIPES, "RSR", "RTR", "RSR", 'R', OP.railGt.dat(MT.StainlessSteel		), 'S', OP.stick.dat(MT.WoodSealed), 'T', OD.craftingRedstoneTorch);
			CR.shaped(ST.make(Blocks.activator_rail	,  6, 0), DEF | DEL_OTHER_SHAPED_RECIPES, "RSR", "RTR", "RSR", 'R', OP.railGt.dat(MT.Ti					), 'S', OP.stick.dat(MT.WoodSealed), 'T', OD.craftingRedstoneTorch);
			CR.shaped(ST.make(Blocks.activator_rail	,  6, 0), DEF | DEL_OTHER_SHAPED_RECIPES, "RSR", "RTR", "RSR", 'R', OP.railGt.dat(ANY.W					), 'S', OP.stick.dat(MT.WoodSealed), 'T', OD.craftingRedstoneTorch);
			CR.shaped(ST.make(Blocks.activator_rail	, 12, 0), DEF | DEL_OTHER_SHAPED_RECIPES, "RSR", "RTR", "RSR", 'R', OP.railGt.dat(MT.TungstenSteel		), 'S', OP.stick.dat(MT.WoodSealed), 'T', OD.craftingRedstoneTorch);
			CR.shaped(ST.make(Blocks.activator_rail	, 12, 0), DEF | DEL_OTHER_SHAPED_RECIPES, "RSR", "RTR", "RSR", 'R', OP.railGt.dat(MT.TungstenCarbide	), 'S', OP.stick.dat(MT.WoodSealed), 'T', OD.craftingRedstoneTorch);
		}
	}
}