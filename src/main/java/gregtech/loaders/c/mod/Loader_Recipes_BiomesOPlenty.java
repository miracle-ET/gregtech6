package gregtech.loaders.c.mod;

import static gregapi.data.CS.*;
import static gregapi.util.CR.*;

import gregapi.data.FL;
import gregapi.data.IL;
import gregapi.data.MD;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.util.CR;
import gregapi.util.OM;
import gregapi.util.ST;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class Loader_Recipes_BiomesOPlenty implements Runnable {
	@Override
	public void run() {if (MD.BoP.mLoaded) {OUT.println("GT_Mod: Doing BoP Recipes.");
		RM.add_smelting(IL.Mud_Ball.get(1), IL.BoP_Mud_Brick.get(1));
		RM.add_smelting(IL.BoP_Mud_Ball.get(1), IL.BoP_Mud_Brick.get(1));
		
		RM.generify(IL.Mud_Ball.get(1), IL.BoP_Mud_Ball.get(1));
		RM.generify(IL.BoP_Mud_Ball.get(1), IL.Mud_Ball.get(1));
		
		RM.compact(IL.BoP_Celestial.get(1), 4, IL.BoP_Celestial_Block.get(1));
		RM.compact(IL.BoP_Flesh.get(1), 4, IL.BoP_Flesh_Block.get(1));
		RM.compact(IL.BoP_Mud_Brick.get(1), 4, IL.BoP_Mud_Bricks.get(1));
		RM.compact(IL.BoP_Mud_Ball.get(1), 4, IL.BoP_Mud.get(1));
		RM.compact(IL.BoP_Ashes.get(1), 4, IL.BoP_Ashes_Block.get(1));
		
		RM.biomass(ST.make(MD.BoP, "flowers", 16, W), 64);
		RM.biomass(ST.make(MD.BoP, "flowers2", 16, W), 64);
		RM.biomass(ST.make(MD.BoP, "plants", 16, W), 64);
		RM.biomass(ST.make(MD.BoP, "foliage", 8, W), 64);
		RM.biomass(ST.make(MD.BoP, "mushrooms", 16, W), 64);
		RM.biomass(ST.make(MD.BoP, "coral1", 16, W), 64);
		RM.biomass(ST.make(MD.BoP, "coral2", 16, W), 64);
		RM.biomass(ST.make(MD.BoP, "lilyBop", 8, W), 64);
		
		CR.remove(IL.BoP_Bone_Small.get(1));
		CR.remove(IL.BoP_Bone_Medium.get(1));
		CR.remove(IL.BoP_Bone_Large.get(1));
		CR.shaped(IL.Dye_Bonemeal.get(1), DEF, "h", "X", 'X', IL.BoP_Bone_Small);
		CR.shaped(IL.Dye_Bonemeal.get(1), DEF, "h", "X", 'X', IL.BoP_Bone_Medium);
		CR.shaped(IL.Dye_Bonemeal.get(1), DEF, "h", "X", 'X', IL.BoP_Bone_Large);
		CR.shapeless(OP.dust.mat(MT.White, 1), DEF_NAC, new Object[] {IL.BoP_Bone_Small});
		CR.shapeless(OP.dust.mat(MT.White, 2), DEF_NAC, new Object[] {IL.BoP_Bone_Medium});
		CR.shapeless(OP.dust.mat(MT.White, 4), DEF_NAC, new Object[] {IL.BoP_Bone_Large});
		RM.Mortar		.addRecipe1(T, 16, 16, IL.BoP_Bone_Small.get(1), IL.Dye_Bonemeal.get(2));
		RM.Mortar		.addRecipe1(T, 16, 32, IL.BoP_Bone_Medium.get(1), IL.Dye_Bonemeal.get(4));
		RM.Mortar		.addRecipe1(T, 16, 64, IL.BoP_Bone_Large.get(1), IL.Dye_Bonemeal.get(8));
		
		RM.Hammer		.addRecipe1(T, 16, 16, IL.BoP_Celestial_Block.get(1), IL.BoP_Celestial.get(4));
		RM.Crusher		.addRecipe1(T, 16, 16, IL.BoP_Celestial_Block.get(1), IL.BoP_Celestial.get(4));
		
		RM.Hammer		.addRecipe1(T, 16,  16, IL.BoP_Hard_Ice.get(1), OM.dust(MT.Ice, 2*U));
		RM.Squeezer		.addRecipe1(T, 16, 128, IL.BoP_Hard_Ice.get(1), NF, FL.Ice.make(2000), NI);
		RM.Juicer		.addRecipe1(T, 16, 128, IL.BoP_Hard_Ice.get(1), NF, FL.Ice.make(2000), NI);
		
		RM.Loom			.addRecipe2(T, 16, 16, ST.tag(0), ST.make(MD.BoP, "plants", 9, 7), ST.make(Blocks.wool, 1, 0));
		
		RM.Centrifuge	.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 0), OM.dust(MT.WaxBee, U*4));
		RM.Centrifuge	.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 2), OM.dust(MT.WaxBee, U*4));
		RM.Centrifuge	.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 3), NF, FL.Honey.make(360), OM.dust(MT.WaxBee, U*4));
		RM.Squeezer		.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 0), OM.dust(MT.WaxBee, U*4));
		RM.Squeezer		.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 2), OM.dust(MT.WaxBee, U*4));
		RM.Squeezer		.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 3), NF, FL.Honey.make(360), OM.dust(MT.WaxBee, U*4));
		RM.Juicer		.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 0), OM.dust(MT.WaxBee, U*4));
		RM.Juicer		.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 2), OM.dust(MT.WaxBee, U*4));
		RM.Juicer		.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 3), NF, FL.Honey.make(360), OM.dust(MT.WaxBee, U*4));
		RM.Mortar		.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 0), OM.dust(MT.WaxBee, U*4));
		RM.Mortar		.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 2), OM.dust(MT.WaxBee, U*4));
		RM.Mortar		.addRecipe1(T, 16, 256, ST.make(MD.BoP, "hive", 1, 3), OM.dust(MT.WaxBee, U*4));
		
		RM.unpack(ST.make(MD.BoP, "hive", 1, 0), IL.BoP_Comb.get(4));
		RM.unpack(ST.make(MD.BoP, "hive", 1, 2), IL.BoP_Comb.get(4));
		RM.unpack(ST.make(MD.BoP, "hive", 1, 3), IL.BoP_HoneyComb.get(4));
		
		RM.Shredder.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms", 1, 0), IL.BoP_ShroomPowder.get(2));
		
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms", 1, 0), IL.BoP_ShroomPowder.get(2));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms", 1, 2), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Blue], IL.BoP_Dye_Blue.get(1));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms", 1, 3), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Lime], ST.make(Items.dye, 1, DYE_INDEX_Lime));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms", 1, 4), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Brown], IL.BoP_Dye_Brown.get(1));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms", 1, 5), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Black], IL.BoP_Dye_Black.get(1));
		
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "plants"	, 1, 7), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Brown], IL.BoP_Dye_Brown.get(1));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "plants"	, 1,12), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Green], IL.Dye_Cactus.get(1));
		
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "moss"		, 1, 0), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Green], IL.BoP_Dye_Green.get(1));
		
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 1), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Cyan], ST.make(Items.dye, 1, DYE_INDEX_Cyan));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 2), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Black], IL.BoP_Dye_Black.get(1));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 4), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_LightBlue], ST.make(Items.dye, 1, DYE_INDEX_LightBlue));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 5), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Orange], ST.make(Items.dye, 1, DYE_INDEX_Orange));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 6), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Pink], ST.make(Items.dye, 1, DYE_INDEX_Pink));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 7), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Magenta], ST.make(Items.dye, 1, DYE_INDEX_Magenta));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 8), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Purple], ST.make(Items.dye, 1, DYE_INDEX_Purple));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 9), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_White], IL.BoP_Dye_White.get(1));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1,15), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_LightGray], ST.make(Items.dye, 1, DYE_INDEX_LightGray));
		
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 0), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Pink], ST.make(Items.dye, 1, DYE_INDEX_Pink));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 1), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_White], IL.BoP_Dye_White.get(1));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 2), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Orange], ST.make(Items.dye, 1, DYE_INDEX_Orange));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 3), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Purple], ST.make(Items.dye, 1, DYE_INDEX_Purple));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 4), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Yellow], ST.make(Items.dye, 1, DYE_INDEX_Yellow));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 5), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Blue], IL.BoP_Dye_Blue.get(1));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 7), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_LightBlue], ST.make(Items.dye, 1, DYE_INDEX_LightBlue));
		RM.Squeezer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 8), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Red], ST.make(Items.dye, 1, DYE_INDEX_Red));
		
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms"	, 1, 0), IL.BoP_ShroomPowder.get(2));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms"	, 1, 2), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Blue], IL.BoP_Dye_Blue.get(1));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms"	, 1, 3), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Lime], ST.make(Items.dye, 1, DYE_INDEX_Lime));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms"	, 1, 4), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Brown], IL.BoP_Dye_Brown.get(1));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "mushrooms"	, 1, 5), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Black], IL.BoP_Dye_Black.get(1));
		
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "plants"		, 1, 7), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Brown], IL.BoP_Dye_Brown.get(1));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "plants"		, 1,12), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Green], IL.Dye_Cactus.get(1));
		
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "moss"		, 1, 0), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Green], IL.BoP_Dye_Green.get(1));
		
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 1), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Cyan], ST.make(Items.dye, 1, DYE_INDEX_Cyan));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 2), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Black], IL.BoP_Dye_Black.get(1));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 4), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_LightBlue], ST.make(Items.dye, 1, DYE_INDEX_LightBlue));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 5), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Orange], ST.make(Items.dye, 1, DYE_INDEX_Orange));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 6), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Pink], ST.make(Items.dye, 1, DYE_INDEX_Pink));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 7), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Magenta], ST.make(Items.dye, 1, DYE_INDEX_Magenta));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 8), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Purple], ST.make(Items.dye, 1, DYE_INDEX_Purple));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1, 9), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_White], IL.BoP_Dye_White.get(1));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers"	, 1,15), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_LightGray], ST.make(Items.dye, 1, DYE_INDEX_LightGray));
		
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 0), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Pink], ST.make(Items.dye, 1, DYE_INDEX_Pink));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 1), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_White], IL.BoP_Dye_White.get(1));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 2), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Orange], ST.make(Items.dye, 1, DYE_INDEX_Orange));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 3), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Purple], ST.make(Items.dye, 1, DYE_INDEX_Purple));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 4), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Yellow], ST.make(Items.dye, 1, DYE_INDEX_Yellow));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 5), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Blue], IL.BoP_Dye_Blue.get(1));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 7), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_LightBlue], ST.make(Items.dye, 1, DYE_INDEX_LightBlue));
		RM.Juicer.addRecipe1(T, 16, 16, ST.make(MD.BoP, "flowers2"	, 1, 8), NF, DYE_FLUIDS_FLOWER[DYE_INDEX_Red], ST.make(Items.dye, 1, DYE_INDEX_Red));
		
		
		
		RM.pulverizing(ST.make(MD.BoP, "mushrooms", 1, 0), IL.BoP_ShroomPowder.get(2));
		
		if (ENABLE_ADDING_IC2_EXTRACTOR_RECIPES) {
		RM.ic2_extractor(ST.make(MD.BoP, "mushrooms"		, 1, 0), IL.BoP_ShroomPowder.get(2));
		RM.ic2_extractor(ST.make(MD.BoP, "mushrooms"		, 1, 2), IL.BoP_Dye_Blue.get(2));
		RM.ic2_extractor(ST.make(MD.BoP, "mushrooms"		, 1, 3), ST.make(Items.dye, 2, DYE_INDEX_Lime));
		RM.ic2_extractor(ST.make(MD.BoP, "mushrooms"		, 1, 4), IL.BoP_Dye_Brown.get(2));
		RM.ic2_extractor(ST.make(MD.BoP, "mushrooms"		, 1, 5), IL.BoP_Dye_Black.get(1));
		
		RM.ic2_extractor(ST.make(MD.BoP, "plants"		, 1, 7), IL.BoP_Dye_Brown.get(2));
		RM.ic2_extractor(ST.make(MD.BoP, "plants"		, 1,12), IL.Dye_Cactus.get(2));
		
		RM.ic2_extractor(ST.make(MD.BoP, "moss"			, 1, 0), IL.BoP_Dye_Green.get(2));
		
		RM.ic2_extractor(ST.make(MD.BoP, "flowers"		, 1, 1), ST.make(Items.dye, 2, DYE_INDEX_Cyan));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers"		, 1, 2), IL.BoP_Dye_Black.get(2));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers"		, 1, 4), ST.make(Items.dye, 2, DYE_INDEX_LightBlue));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers"		, 1, 5), ST.make(Items.dye, 2, DYE_INDEX_Orange));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers"		, 1, 6), ST.make(Items.dye, 2, DYE_INDEX_Pink));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers"		, 1, 7), ST.make(Items.dye, 2, DYE_INDEX_Magenta));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers"		, 1, 8), ST.make(Items.dye, 2, DYE_INDEX_Purple));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers"		, 1, 9), IL.BoP_Dye_White.get(2));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers"		, 1,15), ST.make(Items.dye, 2, DYE_INDEX_LightGray));
		
		RM.ic2_extractor(ST.make(MD.BoP, "flowers2"		, 1, 0), ST.make(Items.dye, 2, DYE_INDEX_Pink));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers2"		, 1, 1), IL.BoP_Dye_White.get(2));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers2"		, 1, 2), ST.make(Items.dye, 2, DYE_INDEX_Orange));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers2"		, 1, 3), ST.make(Items.dye, 2, DYE_INDEX_Purple));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers2"		, 1, 4), ST.make(Items.dye, 2, DYE_INDEX_Yellow));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers2"		, 1, 5), IL.BoP_Dye_Blue.get(2));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers2"		, 1, 7), ST.make(Items.dye, 2, DYE_INDEX_LightBlue));
		RM.ic2_extractor(ST.make(MD.BoP, "flowers2"		, 1, 8), ST.make(Items.dye, 2, DYE_INDEX_Red));
		}
	}}
}