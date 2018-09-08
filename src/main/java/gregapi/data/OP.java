package gregapi.data;

import static gregapi.data.CS.*;
import static gregapi.data.TD.ItemGenerator.*;
import static gregapi.data.TD.Prefix.*;
import static gregapi.data.TD.Processing.*;
import static gregapi.data.TD.Properties.*;
import static gregapi.oredict.OreDictMaterialCondition.*;

import gregapi.code.ICondition;
import gregapi.code.ICondition.And;
import gregapi.code.ICondition.Or;
import gregapi.oredict.OreDictListenerItem_Washing;
import gregapi.oredict.OreDictMaterial;
import gregapi.oredict.OreDictMaterialCondition;
import gregapi.oredict.OreDictPrefix;
import gregapi.util.OM;
import gregapi.util.ST;
import net.minecraft.init.Items;

/**
 * @author Gregorius Techneticies
 * 
 * List of all OreDict Prefixes. The Short Name is for ease of overview and stands for "OrePrefix".
 */
public class OP {
	private static OreDictPrefix create(String aName, String aCategory, String aPreMaterial, String aPostMaterial) {return OreDictPrefix.createPrefix(aName).setCategoryName(aCategory).setLocalPrefixName(aCategory).setLocalItemName(aPreMaterial, aPostMaterial);}
	private static OreDictPrefix create(String aName, String aCategory) {return OreDictPrefix.createPrefix(aName).setCategoryName(aCategory).setLocalPrefixName(aCategory);}
	private static OreDictPrefix unused(String aName) {return OreDictPrefix.createPrefix(aName).add(PREFIX_UNUSED);}
	
	public static final OreDictPrefix
	ore							= create("ore"							, "Ores"							, ""								, " Ore"							)									.setCondition(ORES)																							.add(ORE, UNIFICATABLE_RECIPES, BLOCK_BASED, STANDARD_ORE).aspects(TC.TERRA, 1).setTextureSetName("ore").addIdenticalNames("oreGem"), // Regular Ore Prefix. Ore -> Material is a One-Way Operation! Introduced by Eloraam
	
	oreBlackgranite				= create("oreBlackgranite"				, "Black Granite Ores"				, "Granite "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreRedgranite				= create("oreRedgranite"				, "Red Granite Ores"				, "Granite "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreVanillastone				= create("oreVanillastone"				, "Stone Ores"						, "Stone "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreVanillagranite			= create("oreVanillagranite"			, "Granite Ores"					, "Granite "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreAndesite					= create("oreAndesite"					, "Andesite Ores"					, "Andesite "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreDiorite					= create("oreDiorite"					, "Diorite Ores"					, "Diorite "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreMoon						= create("oreMoon"						, "Moon Ores"						, "Moon "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.ALIENIS	, 1).setTextureSetName("ore"),
	oreMars						= create("oreMars"						, "Mars Ores"						, "Mars "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.ALIENIS	, 1).setTextureSetName("ore"),
	oreSpace					= create("oreSpace"						, "Space Ores"						, "Space "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.ALIENIS	, 1).setTextureSetName("ore"),
	oreHolystone				= create("oreHolystone"					, "Holystone Ores"					, "Holystone "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.LUX		, 1).setTextureSetName("ore"),
	oreUmberstone				= create("oreUmberstone"				, "Umberstone Ores"					, "Umberstone "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.BESTIA		, 1).setTextureSetName("ore"),
	oreBetweenstone				= create("oreBetweenstone"				, "Betweenstone Ores"				, "Betweenstone "					, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.MORTUUS	, 1).setTextureSetName("ore"),
	orePitstone					= create("orePitstone"					, "Pitstone Ores"					, "Pitstone "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.MORTUUS	, 1).setTextureSetName("ore"),
	oreKomatiite				= create("oreKomatiite"					, "Komatiite Ores"					, "Komatiite "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreBasalt					= create("oreBasalt"					, "Basalt Ores"						, "Basalt "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreMarble					= create("oreMarble"					, "Marble Ores"						, "Marble "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreLimestone				= create("oreLimestone"					, "Limestone Ores"					, "Limestone "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreSiltstone				= create("oreSiltstone"					, "Siltstone Ores"					, "Siltstone "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreShale					= create("oreShale"						, "Shale Ores"						, "Shale "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreGreenschist				= create("oreGreenschist"				, "Green Schist Ores"				, "Schist "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreBlueschist				= create("oreBlueschist"				, "Blue Schist Ores"				, "Schist "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreKimberlite				= create("oreKimberlite"				, "Kimberlite Ores"					, "Kimberlite "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreQuartzite				= create("oreQuartzite"					, "Quartzite Ores"					, "Quartzite "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreNetherrack				= create("oreNetherrack"				, "Netherrack Ores"					, "Nether "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.IGNIS		, 1).setTextureSetName("ore"),
	oreEndstone					= create("oreEndstone"					, "Endstone Ores"					, "End "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.ALIENIS	, 1).setTextureSetName("ore"),
	oreSandstone				= create("oreSandstone"					, "Sandstone Ores"					, "Sandstone "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, STANDARD_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("ore"),
	oreGravel					= create("oreGravel"					, "Gravel Ores"						, "Gravel "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, DUST_ORE		).aspects(TC.TERRA		, 1).setTextureSetName("oreDust"),
	oreStrangesand				= create("oreStrangesand"				, "Strange Sand Ores"				, "Strange Sand "					, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, DUST_ORE		).aspects(TC.TERRA		, 1).setTextureSetName("oreDust"),
	oreRedSand					= create("oreRedSand"					, "Red Sand Ores"					, "Sand "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, DUST_ORE		).aspects(TC.TERRA		, 1).setTextureSetName("oreDust"),
	oreSand						= create("oreSand"						, "Sand Ores"						, "Sand "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, DUST_ORE		).aspects(TC.TERRA		, 1).setTextureSetName("oreDust"),
	oreMud						= create("oreMud"						, "Mud Ores"						, "Mud "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, DUST_ORE		).aspects(TC.TERRA		, 1).setTextureSetName("oreDust"),
	
	oreBedrock					= create("oreBedrock"					, "Bedrock Ores"					, "Bedrock "						, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED				).aspects(TC.TERRA		,10).setTextureSetName("oreBedrock"),
	
	oreNether					= create("oreNether"					, "Nether Ores"						, "Nether "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, DENSE_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("oreDense"), // Prefix of the Nether-Ores Mod. Causes Ores to double. Ore -> Material is a Oneway Operation!
	oreDense					= create("oreDense"						, "Dense Ores"						, "Dense "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, DENSE_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("oreDense").addIdenticalNames("denseore"), // Prefix of the Dense-Ores Mod. Causes Ores to double. Ore -> Material is a Oneway Operation!
	oreEnd						= create("oreEnd"						, "End Ores"						, "End "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED, DENSE_ORE	).aspects(TC.TERRA		, 1).setTextureSetName("oreDense"), // In case of an End-Ores Mod. Ore -> Material is a Oneway Operation!
	
	oreHee						= create("oreHee"						, "Hardcore Ender Expansion Ores"	, "End "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED				).aspects(TC.TERRA		, 1),
	
	oreRich						= create("oreRich"						, "Rich Ores"						, "Rich "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED				).aspects(TC.TERRA		, 1), // Prefix of TFC
	oreNormal					= create("oreNormal"					, "Normal Ores"						, "Normal "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED				).aspects(TC.TERRA		, 1), // Prefix of TFC
	oreSmall					= create("oreSmall"						, "Small Ores"						, "Small "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED				).aspects(TC.TERRA		, 1), // Prefix of TFC.
	orePoor						= create("orePoor"						, "Poor Ores"						, "Poor "							, " Ore"							)									.setCondition(ORES)																							.add(UNIFICATABLE, ORE, UNIFICATABLE_RECIPES, MATERIAL_BASED, BLOCK_BASED				).aspects(TC.TERRA		, 1), // Prefix of Railcraft.
	
	crushed						= create("crushed"						, "Crushed Ores"					, "Crushed "						, " Ore"							)	.setMaterialStats( 9*U8)		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_DIRTY).aspects(TC.PERFODIO, 1),
	crushedTiny					= create("crushedTiny"					, "Tiny Crushed Ores"				, "Tiny Crushed "					, " Ore"							)	.setMaterialStats( 9*U72)		.setCondition(crushed)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_DIRTY).aspects(TC.PERFODIO, 1),
	crushedPurified				= create("crushedPurified"				, "Purified Ores"					, "Purified "						, " Ore"							)	.setMaterialStats(10*U8)		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_CLEAN).aspects(TC.PERFODIO, 1),
	crushedPurifiedTiny			= create("crushedPurifiedTiny"			, "Tiny Purified Ores"				, "Tiny Purified "					, " Ore"							)	.setMaterialStats(10*U72)		.setCondition(crushedPurified)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_CLEAN).aspects(TC.PERFODIO, 1),
	crushedCentrifuged			= create("crushedCentrifuged"			, "Refined Ores"					, "Refined "						, " Ore"							)	.setMaterialStats(11*U8)		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_REFINED).aspects(TC.PERFODIO, 1),
	crushedCentrifugedTiny		= create("crushedCentrifugedTiny"		, "Tiny Refined Ores"				, "Tiny Refined "					, " Ore"							)	.setMaterialStats(11*U72)		.setCondition(crushedCentrifuged)																			.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_REFINED).aspects(TC.PERFODIO, 1),
	rockGt						= create("rockGt"						, "Rocks"							, ""								, " bearing Rock"					)	.setMaterialStats(U4   )		.setCondition(new Or(ORES, STONE))																			.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_DIRTY).aspects(TC.TERRA, 1),
	rawOreChunk					= create("rawOreChunk"					, "Raw Ore Chunks"					, "Raw Chunk of "					, " Ore"							)	.setMaterialStats(27*U72)		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_DIRTY).aspects(TC.TERRA, 1), // Prefix of Harder Ores
	clump						= create("clump"						, "Clumps"							, ""								, ""								)	.setMaterialStats(U    )		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_CLEAN).aspects(TC.FABRICO, 1),
	cluster						= create("cluster"						, "Native Clusters"					, "Native "							, " Cluster"						)	.setMaterialStats(U * 2)		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_DIRTY).aspects(TC.ORDO, 1, TC.TERRA, 1), // Introduced by Thaumcraft
	reduced						= create("reduced"						, "Reduced Gravels"					, ""								, ""								)	.setMaterialStats(U    )		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_CLEAN).aspects(TC.FABRICO, 1),
//	RoC?						= create("RoC?"							, "Flakes"							, ""								, ""								)	.setMaterialStats(U    )		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_REFINED).aspects(TC.FABRICO, 1), // Introduced by RotaryCraft
	crystalline					= create("crystalline"					, "Crystallised Metals"				, ""								, ""								)	.setMaterialStats(U    )		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_REFINED).aspects(TC.FABRICO, 1),
	pebbles						= create("pebbles"						, "Pebbles"							, ""								, ""								)	.setMaterialStats(U * 2)		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_DIRTY).aspects(TC.FABRICO, 1),
	rubble						= create("rubble"						, "Rubble"							, ""								, ""								)	.setMaterialStats(U * 2)		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_DIRTY).aspects(TC.FABRICO, 1),
	chunk						= create("chunk"						, "Chunks"							, ""								, ""								)	.setMaterialStats(U * 2)		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_DIRTY).aspects(TC.FABRICO, 1),
	cleanGravel					= create("cleanGravel"					, "Clean Gravels"					, ""								, ""								)	.setMaterialStats(U    )		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_CLEAN).aspects(TC.FABRICO, 1),
	dirtyGravel					= create("dirtyGravel"					, "Dirty Gravels"					, ""								, ""								)	.setMaterialStats(U    )		.setCondition(ORES)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_DIRTY).aspects(TC.FABRICO, 1),
	
	dust						= create("dust"							, "Dusts"							, ""								, " Dust"							)	.setMaterialStats(U    )		.setCondition(new Or(DUSTS, DIRTY_DUSTS))																	.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, DUST_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.PERDITIO, 1).addIdenticalNames("pulp", "itemDust"), // Pure Dust worth of one Ingot or Gem. Introduced by Alblaka.
	dustSmall					= create("dustSmall"					, "Small Dusts"						, "Small Pile of "					, " Dust"							)	.setMaterialStats(U4   )		.setCondition(dust)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, DUST_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize( 4), // 1/4th of a Dust.
	dustTiny					= create("dustTiny"						, "Tiny Dusts"						, "Tiny Pile of "					, " Dust"							)	.setMaterialStats(U9   )		.setCondition(dust)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, DUST_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize( 9), // 1/9th of a Dust.
	dustDiv72					= create("dustDiv72"					, "1/72nd Dusts"					, "1/72nd of a Pile of "			, " Dust"							)	.setMaterialStats(U72  )		.setCondition(dust)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, DUST_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize( 8), // 1/72nd of a Dust.
	dustImpure					= create("dustImpure"					, "Impure Dusts"					, "Impure Pile of "					, " Dust"							)	.setMaterialStats(U    )		.setCondition(new Or(ORES, DIRTY_DUSTS))																	.add(UNIFICATABLE, BURNABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_DIRTY											).setMinStacksize( 1).aspects(TC.TERRA, 1).addIdenticalNames("dustDirty"), // Dust with impurities. 1 Unit of Main Material and 1/9 - 1/4 Unit of secondary Material
	dustPure					= create("dustPure"						, "Purified Dusts"					, "Purified Pile of "				, " Dust"							)	.setMaterialStats(U    )		.setCondition(new Or(ORES, DIRTY_DUSTS))																	.add(UNIFICATABLE, BURNABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_CLEAN											).setMinStacksize( 1).aspects(TC.AQUA, 1),
	dustRefined					= create("dustRefined"					, "Refined Dusts"					, "Refined Pile of "				, " Dust"							)	.setMaterialStats(U    )		.setCondition(new Or(ORES, DIRTY_DUSTS))																	.add(UNIFICATABLE, BURNABLE, ORE_PROCESSING_BASED, ORE_PROCESSING_REFINED										).setMinStacksize( 1).aspects(TC.FABRICO, 1),
	
	ingotQuintuple				= create("ingotQuintuple"				, "5x Ingots"						, "Quintuple "						, " Ingot"							)	.setMaterialStats(U * 5)		.setCondition(MULTIINGOTS)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).setMinStacksize( 2).aspects(TC.METALLUM, 3), // A quintuple Ingot.
	ingotQuadruple				= create("ingotQuadruple"				, "4x Ingots"						, "Quadruple "						, " Ingot"							)	.setMaterialStats(U * 4)		.setCondition(MULTIINGOTS)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).setMinStacksize( 2).aspects(TC.METALLUM, 2).addIdenticalNames("ingotQuad"), // A quadruple Ingot.
	ingotTriple					= create("ingotTriple"					, "3x Ingots"						, "Triple "							, " Ingot"							)	.setMaterialStats(U * 3)		.setCondition(MULTIINGOTS)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).setMinStacksize( 3).aspects(TC.METALLUM, 2), // A triple Ingot.
	ingotDouble					= create("ingotDouble"					, "2x Ingots"						, "Double "							, " Ingot"							)	.setMaterialStats(U * 2)		.setCondition(MULTIINGOTS)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).setMinStacksize( 5).aspects(TC.METALLUM, 1), // A double Ingot. Introduced by TerraFirmaCraft
	ingotHot					= create("ingotHot"						, "Hot Ingots"						, "Hot "							, " Ingot"							)	.setMaterialStats(U    )		.setCondition(new And(INGOTS_HOT, SMITHABLE, OreDictMaterialCondition.meltmin(800)))						.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL).setMinStacksize( 4).aspects(TC.METALLUM, 1), // A hot Ingot.
	ingot						= create("ingot"						, "Ingots"							, ""								, " Ingot"							)	.setMaterialStats(U    )		.setCondition(INGOTS)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, INGOT_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).setMinStacksize(16).aspects(TC.METALLUM, 1), // A regular Ingot. Introduced by Eloraam
	chunkGt						= create("chunkGt"						, "Chunks"							, ""								, " Chunk"							)	.setMaterialStats(U4   )		.setCondition(ingot)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, INGOT_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).setMinStacksize( 4).aspects(TC.METALLUM, 1), // A large Nugget.
	nugget						= create("nugget"						, "Nuggets"							, ""								, " Nugget"							)	.setMaterialStats(U9   )		.setCondition(ingot)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, INGOT_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).setMinStacksize( 9).aspects(TC.METALLUM, 1), // A Nugget. Introduced by Eloraam
	
	gem							= create("gem"							, "Gemstones"						, ""								, ""								)	.setMaterialStats(U    )		.setCondition(GEMS)																							.add(UNIFICATABLE, BURNABLE, SELF_REFERENCING, RECYCLABLE, SIMPLIFIABLE, GEM_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).setMinStacksize(16).aspects(TC.VITREUS, 1), // A regular Gem worth one Dust. Introduced by Eloraam
	gemChipped					= create("gemChipped"					, "Chipped Gemstones"				, "Chipped "						, ""								)	.setMaterialStats(U4   )		.setCondition(new And(gem, TRANSPARENT, CRYSTAL, PEARL.NOT))												.add(UNIFICATABLE, BURNABLE, SELF_REFERENCING, RECYCLABLE, SIMPLIFIABLE, GEM_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).aspects(TC.VITREUS, 1), // A regular Gem worth one small Dust. Introduced by TerraFirmaCraft
	gemFlawed					= create("gemFlawed"					, "Flawed Gemstones"				, "Flawed "							, ""								)	.setMaterialStats(U2   )		.setCondition(new And(gem, TRANSPARENT, CRYSTAL, PEARL.NOT))												.add(UNIFICATABLE, BURNABLE, SELF_REFERENCING, RECYCLABLE, SIMPLIFIABLE, GEM_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).aspects(TC.VITREUS, 1), // A regular Gem worth two small Dusts. Introduced by TerraFirmaCraft
	gemFlawless					= create("gemFlawless"					, "Flawless Gemstones"				, "Flawless "						, ""								)	.setMaterialStats(U * 2)		.setCondition(new And(gem, TRANSPARENT, CRYSTAL, PEARL.NOT))												.add(UNIFICATABLE, BURNABLE, SELF_REFERENCING, RECYCLABLE, SIMPLIFIABLE, GEM_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).aspects(TC.VITREUS, 2), // A regular Gem worth two Dusts. Introduced by TerraFirmaCraft
	gemExquisite				= create("gemExquisite"					, "Exquisite Gemstones"				, "Exquisite "						, ""								)	.setMaterialStats(U * 4)		.setCondition(new And(gem, TRANSPARENT, CRYSTAL, PEARL.NOT))												.add(UNIFICATABLE, BURNABLE, SELF_REFERENCING, RECYCLABLE, SIMPLIFIABLE, GEM_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).aspects(TC.VITREUS, 3), // A regular Gem worth four Dusts. Introduced by TerraFirmaCraft
	gemLegendary				= create("gemLegendary"					, "Legendary Gemstones"				, "Legendary "						, ""								)	.setMaterialStats(U * 8)		.setCondition(new And(gem, TRANSPARENT, CRYSTAL, PEARL.NOT))												.add(UNIFICATABLE, BURNABLE, SELF_REFERENCING, RECYCLABLE, SIMPLIFIABLE, GEM_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).aspects(TC.VITREUS, 4), // A regular Gem worth nine Dusts. Introduced by GregTech
	bouleGt						= create("bouleGt"						, "Boules"							, ""								, " Boule"							)	.setMaterialStats(U * 4)		.setCondition(ICondition.FALSE)																				.add(UNIFICATABLE, BURNABLE, SELF_REFERENCING, RECYCLABLE, SIMPLIFIABLE, GEM_BASED, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).aspects(TC.VITREUS, 1), // A boule which can be used to cut gem stuff out of.
	crystalPure					= create("crystalPure"					, "Pure Crystals"					, "Pure "							, " Crystal"						)	.setMaterialStats(U2   )		.setCondition(GEMS)																							.add(BURNABLE, RECYCLABLE).aspects(TC.VITREUS, 1),
	crystal						= create("crystal"						, "Crystals"						, ""								, " Crystal"						)	.setMaterialStats(U    )		.setCondition(GEMS)																							.add(BURNABLE, RECYCLABLE).aspects(TC.VITREUS, 1),
	lens						= create("lens"							, "Lenses"							, ""								, " Lens"							)	.setMaterialStats(U4* 3)		.setCondition(LENSES)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).aspects(TC.VITREUS, 1, TC.FABRICO, 1), // 3/4 of a Plate or Gem used to shape a Lense. Normally only used on Transparent Materials.
	
	scrapGt						= create("scrapGt"						, "Scrap"							, ""								, " Scrap"							)	.setMaterialStats(U9   )		.setCondition(new Or(dust, ingot, gem))																		.add(TD.Creative.HIDDEN, UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL).aspects(TC.PERDITIO, 1).setStacksize(18), // A piece of random Scrap. Basically just a container for 1/9th of a Material Unit of anything, which still has to be processed. Usually comes when breaking down Machines.
	
	plateSteamcraft				= create("plateSteamcraft"				, "Steamcraft Plates"				, ""								, ""								)									.setCondition(PLATES)																						.add(								  																).setMinStacksize(16).aspects(TC.FABRICO, 1),
	plateDense					= create("plateDense"					, "Dense Plates"					, "Dense "							, " Plate"							)	.setMaterialStats(U * 9)		.setCondition(DENSEPLATES)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 3), // 9 Plates combined in one Item.
	plateQuintuple				= create("plateQuintuple"				, "5x Plates"						, "Quintuple "						, " Plate"							)	.setMaterialStats(U * 5)		.setCondition(MULTIPLATES)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 2),
	plateQuadruple				= create("plateQuadruple"				, "4x Plates"						, "Quadruple "						, " Plate"							)	.setMaterialStats(U * 4)		.setCondition(MULTIPLATES)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 2).addIdenticalNames("plateQuad"),
	plateTriple					= create("plateTriple"					, "3x Plates"						, "Triple "							, " Plate"							)	.setMaterialStats(U * 3)		.setCondition(MULTIPLATES)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1),
	plateDouble					= create("plateDouble"					, "2x Plates"						, "Double "							, " Plate"							)	.setMaterialStats(U * 2)		.setCondition(MULTIPLATES)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1),
	plate						= create("plate"						, "Plates"							, ""								, " Plate"							)	.setMaterialStats(U    )		.setCondition(new And(new Or(ingot, gem.NOT), PLATES))														.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // Regular Plate made of one Ingot/Dust. Introduced by Calclavia
	plateGem					= create("plateGem"						, "Gem Plates"						, "Crystalline "					, " Plate"							)	.setMaterialStats(U    )		.setCondition(new And(new Or(gem, bouleGt), PLATES))														.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // Regular Plate made of one Gem/Dust.
	plateTiny					= create("plateTiny"					, "Tiny Plates"						, "Tiny "							, " Plate"							)	.setMaterialStats(U9   )		.setCondition(plate)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // Tiny Plate made of one ninth Ingot/Dust.
	plateGemTiny				= create("plateGemTiny"					, "Tiny Gem Plates"					, "Tiny Crystalline "				, " Plate"							)	.setMaterialStats(U9   )		.setCondition(plateGem)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // Tiny Plate made of one ninth Gem/Dust.
	plateCurved					= create("plateCurved"					, "Curved Plates"					, "Curved "							, " Plate"							)	.setMaterialStats(U    )		.setCondition(plate)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // Curved regular Plate.
	compressed					= create("compressed"					, "Compressed Materials"			, "Compressed "						, ""								)	.setMaterialStats(U    )		.setCondition(PLATES)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1).addIdenticalNames("Compressed"), // Compressed Material, worth 1 Unit. Introduced by Galacticraft
	sheetGt						= create("sheetGt"						, "Flat Sheets"						, ""								, " Sheet"							)	.setMaterialStats(U    )		.setCondition(PLATES)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // Flat Sheet, worth 1 Unit. Introduced by Advanced Rocketry, Prefix Name redirected by GT
	
	foil						= create("foil"							, "Foils"							, ""								, " Foil"							)	.setMaterialStats(U4   )		.setCondition(FOILS)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // Foil made of 1/4 Ingot/Dust.
	stick						= create("stick"						, "Sticks/Rods"						, ""								, " Rod"							)	.setMaterialStats(U2   )		.setCondition(STICKS)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // Stick made of half an Ingot. Introduced by Eloraam
	stickLong					= create("stickLong"					, "Long Sticks/Rods"				, "Long "							, " Rod"							)	.setMaterialStats(U    )		.setCondition(stick)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // Stick made of an Ingot.
	bolt						= create("bolt"							, "Bolts"							, ""								, " Bolt"							)	.setMaterialStats(U8   )		.setCondition(stick)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // consisting out of 1/8 Ingot or 1/4 Stick.
	screw						= create("screw"						, "Screws"							, ""								, " Screw"							)	.setMaterialStats(U9   )		.setCondition(bolt)																							.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // consisting out of a Bolt.
	round						= create("round"						, "Rounds"							, ""								, " Round"							)	.setMaterialStats(U9   )		.setCondition(PARTS)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // consisting out of one Nugget.
	ring						= create("ring"							, "Rings"							, ""								, " Ring"							)	.setMaterialStats(U4   )		.setCondition(PARTS)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // consisting out of 1/2 Stick.
	spring						= create("spring"						, "Springs"							, ""								, " Spring"							)	.setMaterialStats(U    )		.setCondition(new And(PARTS, new Or(STRETCHY, BOUNCY, BRITTLE.NOT)))										.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.MOTUS, 1), // consisting out of 2 Sticks.
	springSmall					= create("springSmall"					, "Small Springs"					, "Small "							, " Spring"							)	.setMaterialStats(U4   )		.setCondition(spring)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.MOTUS, 1), // consisting out of 1 Fine Wire.
	wireFine					= create("wireFine"						, "Fine Wires"						, "Fine "							, " Wire"							)	.setMaterialStats(U8   )		.setCondition(new Or(WIRES, new And(PARTS, SMITHABLE)))														.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // consisting out of 1/8 Ingot or 1/4 Wire.
	minecartWheels				= create("minecartWheels"				, "Cart Wheels"						, ""								, " Cart Wheels"					)	.setMaterialStats(U    )		.setCondition(new And(PARTS, SMITHABLE))																	.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1, TC.ITER, 1).setStacksize(16), // consisting out of 2 Rings and 1 Rod.
	gearGt						= create("gearGt"						, "Gears"							, ""								, " Gear"							)	.setMaterialStats(U * 4)		.setCondition(PARTS)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.MOTUS, 1, TC.MACHINA, 1), // Introduced by me because BuildCraft has ruined the gear Prefix...
	gearGtSmall					= create("gearGtSmall"					, "Small Gears"						, "Small "							, " Gear"							)	.setMaterialStats(U    )		.setCondition(gearGt)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.MOTUS, 1, TC.MACHINA, 1),
	railGt						= create("railGt"						, "Single Rails"					, ""								, " Rail"							)	.setMaterialStats(U4   )		.setCondition(RAILS)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.ITER, 1),
	casingSmall					= create("casingSmall"					, "Item Casings"					, ""								, " Item Casing"					)	.setMaterialStats(U2   )		.setCondition(PARTS)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize(16).aspects(TC.FABRICO, 1), // consisting out of half a Metal Plate
	casingMachine				= create("casingMachine"				, "Machine Casings"					, ""								, " Machine Casing"					)	.setMaterialStats(U * 8)		.setCondition(new And(PARTS, SMITHABLE))																	.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize( 1).aspects(TC.FABRICO, 2, TC.MACHINA, 2).setStacksize(8),
	casingMachineDouble			= create("casingMachineDouble"			, "Robust Machine Casings"			, "Robust "							, " Machine Casing"					)	.setMaterialStats(U *14)		.setCondition(casingMachine)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize( 1).aspects(TC.FABRICO, 3, TC.MACHINA, 3).setStacksize(4),
	casingMachineQuadruple		= create("casingMachineQuadruple"		, "Reinforced Machine Casings"		, "Reinforced "						, " Machine Casing"					)	.setMaterialStats(U *26)		.setCondition(casingMachine)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize( 1).aspects(TC.FABRICO, 4, TC.MACHINA, 4).setStacksize(2),
	casingMachineDense			= create("casingMachineDense"			, "Dense Machine Casings"			, "Dense "							, " Machine Casing"					)	.setMaterialStats(U *56)		.setCondition(casingMachine)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, TOOLTIP_MATERIAL	).setMinStacksize( 1).aspects(TC.FABRICO, 5, TC.MACHINA, 5).setStacksize(1),
	rotor						= create("rotor"						, "Rotors"							, ""								, " Rotor"							)	.setMaterialStats(U*4+U4)		.setCondition(PARTS)																						.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, TOOLTIP_MATERIAL					).setMinStacksize(16).aspects(TC.MOTUS, 1, TC.MACHINA, 1).setStacksize(16), // consisting out of 4 Plates, 1 Ring.
	
	chemtube					= create("chemtube"						, "Glass Tubes"						, "Glass Tube containing "			, ""								)	.setMaterialStats(U9   )		.setCondition(REACTS_WITH_GLASS.NOT)																		.add(UNIFICATABLE, IS_CONTAINER, SELF_REFERENCING, RECYCLABLE, SCANNABLE, TOOLTIP_MATERIAL).setMinStacksize(64),
	cell						= create("cell"							, "Cells"							, ""								, " Cell"							)									.setCondition(new Or(CONTAINERS, EMPTY, CONTAINERS_FLUID, CONTAINERS_GAS))									.add(UNIFICATABLE, IS_CONTAINER, SELF_REFERENCING, MATERIAL_BASED, RECYCLABLE).setMinStacksize(16), // Regular Gas/Fluid Cell. Introduced by Calclavia
	bucket						= create("bucket"						, "Buckets"							, ""								, " Bucket"							)									.setCondition(new Or(CONTAINERS, EMPTY, CONTAINERS_FLUID))													.add(IS_CONTAINER, SELF_REFERENCING).setStacksize(16), // A Bucket filled with the Material.
	bottle						= create("bottle"						, "Bottles"							, ""								, " Bottle"							)									.setCondition(new Or(CONTAINERS, EMPTY, CONTAINERS_FLUID))													.add(IS_CONTAINER, SELF_REFERENCING, MATERIAL_BASED).setStacksize(16), // Glass Bottle containing a Fluid.
	capsule						= create("capsule"						, "Capsules"						, ""								, " Capsule"						)									.setCondition(new Or(CONTAINERS, EMPTY, CONTAINERS_FLUID, CONTAINERS_GAS))									.add(IS_CONTAINER, SELF_REFERENCING, MATERIAL_BASED).setStacksize(16),
	
	toolHeadSaw					= create("toolHeadSaw"					, "Saw Blades"						, ""								, " Saw Blade"						)	.setMaterialStats(U * 2 -U9)	.setCondition(new And(typemin(2), BOUNCY.NOT, STRETCHY.NOT))												.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.FABRICO, 1),
	toolHeadFile				= create("toolHeadFile"					, "File Heads"						, ""								, " File Head"						)	.setMaterialStats(3 *U2)		.setCondition(new And(typemin(2), BOUNCY.NOT, STRETCHY.NOT))												.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.FABRICO, 1),
	toolHeadChisel				= create("toolHeadChisel"				, "Chisel Heads"					, ""								, " Chisel Head"					)	.setMaterialStats(3 *U2 -U9)	.setCondition(new And(typemin(2), BOUNCY.NOT, STRETCHY.NOT))												.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.FABRICO, 1),
	toolHeadBuzzSaw				= create("toolHeadBuzzSaw"				, "Buzzsaw Blades"					, ""								, " Buzzsaw Blade"					)	.setMaterialStats(U * 4)		.setCondition(new And(typemin(2), BOUNCY.NOT, STRETCHY.NOT))												.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD									).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.MACHINA, 1, TC.FABRICO, 1),
	toolHeadChainsaw			= create("toolHeadChainsaw"				, "Chainsaw Tips"					, ""								, " Chainsaw Tip"					)	.setMaterialStats(U * 2)		.setCondition(new And(typemin(2), BOUNCY.NOT, STRETCHY.NOT))												.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD									).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.MACHINA, 1, TC.TELUM, 1),
	toolHeadWrench				= create("toolHeadWrench"				, "Wrench Tips"						, ""								, " Wrench Tip"						)	.setMaterialStats(U * 4)		.setCondition(new And(typemin(2), BOUNCY.NOT, STRETCHY.NOT))												.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD									).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.MACHINA, 2),
	toolHeadDrill				= create("toolHeadDrill"				, "Drill Tips"						, ""								, " Drill Tip"						)	.setMaterialStats(U * 4)		.setCondition(new And(typemin(2), BOUNCY.NOT, STRETCHY.NOT))												.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD									).setStacksize(16).aspects(TC.INSTRUMENTUM, 1, TC.MACHINA, 1, TC.PERFODIO, 1),
	toolHeadSword				= create("toolHeadSword"				, "Sword Blades"					, ""								, " Sword Blade"					)	.setMaterialStats(U * 2 -U9)	.setCondition(typemin(1))																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 1, TC.TELUM, 2),
	toolHeadPickaxe				= create("toolHeadPickaxe"				, "Pickaxe Heads"					, ""								, " Pickaxe Head"					)	.setMaterialStats(U * 3 -U9)	.setCondition(typemin(1))																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.PERFODIO, 1),
	toolHeadShovel				= create("toolHeadShovel"				, "Shovel Heads"					, ""								, " Shovel Head"					)	.setMaterialStats(U     -U9)	.setCondition(typemin(1))																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 1),
	toolHeadSpade				= create("toolHeadSpade"				, "Spade Heads"						, ""								, " Spade Head"						)	.setMaterialStats(U     -U9)	.setCondition(typemin(1))																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 1),
	toolHeadAxe					= create("toolHeadAxe"					, "Axe Heads"						, ""								, " Axe Head"						)	.setMaterialStats(U * 3 -U9)	.setCondition(typemin(1))																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.TELUM, 1),
	toolHeadHoe					= create("toolHeadHoe"					, "Hoe Heads"						, ""								, " Hoe Head"						)	.setMaterialStats(U * 2 -U9)	.setCondition(typemin(1))																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.MESSIS, 1),
	toolHeadSense				= create("toolHeadSense"				, "Sense Blades"					, ""								, " Sense Blade"					)	.setMaterialStats(U * 3 -U9)	.setCondition(typemin(2))																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.METO, 1),
	toolHeadPlow				= create("toolHeadPlow"					, "Plow Heads"						, ""								, " Plow Head"						)	.setMaterialStats(U * 4 -U9)	.setCondition(typemin(1))																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.GELUM, 1),
	toolHeadHammer				= create("toolHeadHammer"				, "Hammer Heads"					, ""								, " Hammer Head"					)	.setMaterialStats(U * 6)		.setCondition(new And(typemin(1), new Or(BOUNCY, STRETCHY, WOOD, qualmin(1))))								.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.FABRICO, 1),
	toolHeadScrewdriver			= create("toolHeadScrewdriver"			, "Screwdriver Tips"				, ""								, " Screwdriver Tip"				)	.setMaterialStats(U    )		.setCondition(typemin(2))																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 1, TC.MOTUS, 1),
	toolHeadConstructionPickaxe	= create("toolHeadConstructionPickaxe"	, "Construction Pickaxe Heads"		, ""								, " Construction Pickaxe Head"		)	.setMaterialStats(U * 3 -U9)	.setCondition(new And(toolHeadPickaxe, typemin(2)))															.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.PERFODIO, 1),
	toolHeadPickaxeGem			= create("toolHeadPickaxeGem"			, "Gem tipped Pickaxe Heads"		, ""								, " tipped Pickaxe Head"			)	.setMaterialStats(U * 1)		.setCondition(new And(toolHeadPickaxe, gemFlawed, typemin(2)))												.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 2, TC.PERFODIO, 1, TC.VITREUS, 1),
	toolHeadAxeDouble			= create("toolHeadAxeDouble"			, "Double Axe Heads"				, ""								, " Double Axe Head"				)	.setMaterialStats(U*5-2 *U9)	.setCondition(new And(toolHeadAxe, typemin(2)))																.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_HANDLE						).setStacksize(16).aspects(TC.INSTRUMENTUM, 3, TC.TELUM, 1),
	toolHeadUniversalSpade		= create("toolHeadUniversalSpade"		, "Universal Spade Heads"			, ""								, " Universal Spade Head"			)	.setMaterialStats(U  -2 *U9)	.setCondition(new And(toolHeadShovel, toolHeadSaw))															.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD									).setStacksize(16).aspects(TC.INSTRUMENTUM, 1, TC.TELUM, 1),
	toolHeadArrow				= create("toolHeadArrow"				, "Arrow Heads"						, ""								, " Arrow Head"						)	.setMaterialStats(2 *U9)		.setCondition(new And(PROJECTILES, typemin(1)))																.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD									).setStacksize(64).aspects(TC.TELUM, 1),
	
	toolHeadRawSaw				= create("toolHeadRawSaw"				, "Raw Saw Blades"					, "Raw "							, " Saw Blade"						)	.setMaterialStats(U * 2)		.setCondition(toolHeadSaw)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 2, TC.FABRICO, 1),
	toolHeadRawChisel			= create("toolHeadRawChisel"			, "Raw Chisel Heads"				, "Raw "							, " Chisel Head"					)	.setMaterialStats(3 *U2)		.setCondition(toolHeadChisel)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 2, TC.FABRICO, 1),
	toolHeadRawSword			= create("toolHeadRawSword"				, "Raw Sword Blades"				, "Raw "							, " Sword Blade"					)	.setMaterialStats(U * 2)		.setCondition(toolHeadSword)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 1, TC.TELUM, 2),
	toolHeadRawPickaxe			= create("toolHeadRawPickaxe"			, "Raw Pickaxe Heads"				, "Raw "							, " Pickaxe Head"					)	.setMaterialStats(U * 3)		.setCondition(toolHeadPickaxe)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 2, TC.PERFODIO, 1),
	toolHeadRawShovel			= create("toolHeadRawShovel"			, "Raw Shovel Heads"				, "Raw "							, " Shovel Head"					)	.setMaterialStats(U    )		.setCondition(toolHeadShovel)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 1),
	toolHeadRawSpade			= create("toolHeadRawSpade"				, "Raw Spade Heads"					, "Raw "							, " Spade Head"						)	.setMaterialStats(U    )		.setCondition(toolHeadSpade)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 1),
	toolHeadRawUniversalSpade	= create("toolHeadRawUniversalSpade"	, "Raw Universal Spade Heads"		, "Raw "							, " Universal Spade Head"			)	.setMaterialStats(U     -U9)	.setCondition(toolHeadUniversalSpade)																		.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 1, TC.TELUM, 1),
	toolHeadRawAxe				= create("toolHeadRawAxe"				, "Raw Axe Heads"					, "Raw "							, " Axe Head"						)	.setMaterialStats(U * 3)		.setCondition(toolHeadAxe)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 2, TC.TELUM, 1),
	toolHeadRawAxeDouble		= create("toolHeadRawAxeDouble"			, "Raw Double Axe Heads"			, "Raw "							, " Double Axe Head"				)	.setMaterialStats(U * 5)		.setCondition(toolHeadAxeDouble)																			.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 3, TC.TELUM, 1),
	toolHeadRawHoe				= create("toolHeadRawHoe"				, "Raw Hoe Heads"					, "Raw "							, " Hoe Head"						)	.setMaterialStats(U * 2)		.setCondition(toolHeadHoe)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 2, TC.MESSIS, 1),
	toolHeadRawSense			= create("toolHeadRawSense"				, "Raw Sense Blades"				, "Raw "							, " Sense Blade"					)	.setMaterialStats(U * 3)		.setCondition(toolHeadSense)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 2, TC.METO, 1),
	toolHeadRawPlow				= create("toolHeadRawPlow"				, "Raw Plow Heads"					, "Raw "							, " Plow Head"						)	.setMaterialStats(U * 4)		.setCondition(toolHeadPlow)																					.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING, NEEDS_HANDLE	).setStacksize(16, 2).aspects(TC.INSTRUMENTUM, 2, TC.GELUM, 1),
	toolHeadRawArrow			= create("toolHeadRawArrow"				, "Raw Arrow Heads"					, "Raw "							, " Arrow Head"						)	.setMaterialStats(U4   )		.setCondition(toolHeadArrow)																				.add(UNIFICATABLE, BURNABLE, RECYCLABLE, SCANNABLE, TOOL_HEAD, NEEDS_SHARPENING					).setStacksize(64, 2).aspects(TC.TELUM, 1),
	
	toolSword					= create("toolSword"					, "Swords"							, ""								, ""								)	.setMaterialStats(U * 2)		.setCondition(typemin(1))																					.add(TOOL_ALIKE, BURNABLE, RECYCLABLE, WEAPON_ALIKE	).setStacksize( 1).aspects(TC.INSTRUMENTUM, 1, TC.TELUM, 2), // vanilly Sword
	toolPickaxe					= create("toolPickaxe"					, "Pickaxes"						, ""								, ""								)	.setMaterialStats(U * 3)		.setCondition(typemin(1))																					.add(TOOL_ALIKE, BURNABLE, RECYCLABLE				).setStacksize( 1).aspects(TC.INSTRUMENTUM, 2, TC.PERFODIO, 1), // vanilly Pickaxe
	toolShovel					= create("toolShovel"					, "Shovels"							, ""								, ""								)	.setMaterialStats(U    )		.setCondition(typemin(1))																					.add(TOOL_ALIKE, BURNABLE, RECYCLABLE				).setStacksize( 1).aspects(TC.INSTRUMENTUM, 1, TC.TERRA, 1), // vanilly Shovel
	toolAxe						= create("toolAxe"						, "Axes"							, ""								, ""								)	.setMaterialStats(U * 3)		.setCondition(typemin(1))																					.add(TOOL_ALIKE, BURNABLE, RECYCLABLE, WEAPON_ALIKE	).setStacksize( 1).aspects(TC.INSTRUMENTUM, 2, TC.TELUM, 1), // vanilly Axe
	toolHoe						= create("toolHoe"						, "Hoes"							, ""								, ""								)	.setMaterialStats(U * 2)		.setCondition(typemin(1))																					.add(TOOL_ALIKE, BURNABLE, RECYCLABLE				).setStacksize( 1).aspects(TC.INSTRUMENTUM, 2, TC.MESSIS, 1), // vanilly Hoe
	toolShears					= create("toolShears"					, "Shears"							, ""								, ""								)	.setMaterialStats(U * 2)		.setCondition(typemin(1))																					.add(TOOL_ALIKE, BURNABLE, RECYCLABLE				).setStacksize( 1).aspects(TC.INSTRUMENTUM, 2, TC.PANNUS, 1), // vanilly Shears
	tool						= create("tool"							, "Tools"							, ""								, ""								)									.setCondition(typemin(1))																					.add(TOOL_ALIKE										).setStacksize( 1).aspects(TC.INSTRUMENTUM, 2), // toolPot, toolSkillet, toolSaucepan, toolBakeware, toolCuttingboard, toolMortarandpestle, toolMixingbowl, toolJuicer
	
	bulletGtSmall				= create("bulletGtSmall"				, "Small Bullets"					, "Small "							, " Bullet"							)	.setMaterialStats(U9   )		.setCondition(new Or(new And(PROJECTILES, typemin(2)), EMPTY))												.add(UNIFICATABLE, BURNABLE, AMMO_ALIKE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE					).aspects(TC.MOTUS, 1, TC.TELUM, 1),
	bulletGtMedium				= create("bulletGtMedium"				, "Medium Bullets"					, "Medium "							, " Bullet"							)	.setMaterialStats(2 *U9)		.setCondition(new Or(new And(PROJECTILES, typemin(2)), EMPTY))												.add(UNIFICATABLE, BURNABLE, AMMO_ALIKE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE					).aspects(TC.MOTUS, 1, TC.TELUM, 1),
	bulletGtLarge				= create("bulletGtLarge"				, "Large Bullets"					, "Large "							, " Bullet"							)	.setMaterialStats(U3   )		.setCondition(new Or(new And(PROJECTILES, typemin(2)), EMPTY))												.add(UNIFICATABLE, BURNABLE, AMMO_ALIKE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE					).aspects(TC.MOTUS, 1, TC.TELUM, 1),
	arrowGtWood					= create("arrowGtWood"					, "Regular Arrows"					, ""								, " Arrow"							)	.setMaterialStats(2 *U9)		.setCondition(new Or(toolHeadArrow, EMPTY))																	.add(UNIFICATABLE, BURNABLE, AMMO_ALIKE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, WEAPON_ALIKE	).aspects(TC.TELUM, 1), // Arrow made of 1/4 Ingot/Dust + Wooden Stick.
	arrowGtPlastic				= create("arrowGtPlastic"				, "Light Arrows"					, "Light "							, " Arrow"							)	.setMaterialStats(2 *U9)		.setCondition(new Or(toolHeadArrow, EMPTY))																	.add(UNIFICATABLE, BURNABLE, AMMO_ALIKE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, WEAPON_ALIKE	).aspects(TC.TELUM, 1), // Arrow made of 1/4 Ingot/Dust + Plastic Stick.
	arrow						= create("arrow"						, "Arrows"							, ""								, ""								)									.setCondition(toolHeadArrow)																				.add(AMMO_ALIKE, SELF_REFERENCING, WEAPON_ALIKE															).aspects(TC.TELUM, 1),
	
	armorHelmet					= create("armorHelmet"					, "Helmets"							, ""								, ""								)	.setMaterialStats(U * 5)		.setCondition(ARMORS)																						.add(ARMOR_ALIKE, BURNABLE, RECYCLABLE				).setStacksize( 1).aspects(TC.TUTAMEN, 2), // vanilly Helmet
	armorChestplate				= create("armorChestplate"				, "Chestplates"						, ""								, ""								)	.setMaterialStats(U * 8)		.setCondition(ARMORS)																						.add(ARMOR_ALIKE, BURNABLE, RECYCLABLE				).setStacksize( 1).aspects(TC.TUTAMEN, 4), // vanilly Chestplate
	armorLeggings				= create("armorLeggings"				, "Leggings"						, ""								, ""								)	.setMaterialStats(U * 7)		.setCondition(ARMORS)																						.add(ARMOR_ALIKE, BURNABLE, RECYCLABLE				).setStacksize( 1).aspects(TC.TUTAMEN, 3), // vanilly Pants
	armorBoots					= create("armorBoots"					, "Boots"							, ""								, ""								)	.setMaterialStats(U * 4)		.setCondition(ARMORS)																						.add(ARMOR_ALIKE, BURNABLE, RECYCLABLE				).setStacksize( 1).aspects(TC.TUTAMEN, 2), // vanilly Boots
	armor						= create("armor"						, "Armor Parts"						, ""								, ""								)									.setCondition(ARMORS)																						.add(ARMOR_ALIKE									).setStacksize( 1).aspects(TC.TUTAMEN, 2),
	
	frameGt						= create("frameGt"						, "Frame Boxes"						, ""								, ""								)	.setMaterialStats(U * 2)		.setCondition(stick)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).aspects(TC.FABRICO, 1),
	
	capcellcon					= create("capcellcon"					, "Capsule Cell Containers"			, ""								, " Capsule Cell Container"			)	.setMaterialStats(U    )		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).aspects(TC.VACUOS, 1),
	
	pipeTiny					= create("pipeTiny"						, "Tiny Pipes"						, "Tiny "							, " Pipe"							)	.setMaterialStats(U2   )		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).aspects(TC.ITER, 1),
	pipeSmall					= create("pipeSmall"					, "Small Pipes"						, "Small "							, " Pipe"							)	.setMaterialStats(U    )		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).aspects(TC.ITER, 1),
	pipeMedium					= create("pipeMedium"					, "Medium Pipes"					, "Medium "							, " Pipe"							)	.setMaterialStats(U * 3)		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).aspects(TC.ITER, 1),
	pipeLarge					= create("pipeLarge"					, "Large pipes"						, "Large "							, " Pipe"							)	.setMaterialStats(U * 6)		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).aspects(TC.ITER, 1),
	pipeHuge					= create("pipeHuge"						, "Huge Pipes"						, "Huge "							, " Pipe"							)	.setMaterialStats(U *12)		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).aspects(TC.ITER, 2),
	pipeQuadruple				= create("pipeQuadruple"				, "Quadruple Pipes"					, "Quadruple "						, " Pipe"							)	.setMaterialStats(U *12)		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).aspects(TC.ITER, 2),
	pipeNonuple					= create("pipeNonuple"					, "Nonuple Pipes"					, "Nonuple "						, " Pipe"							)	.setMaterialStats(U * 9)		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).aspects(TC.ITER, 2),
	pipeRestrictiveTiny			= create("pipeRestrictiveTiny"			, "Tiny Restrictive Pipes"			, "Tiny Restrictive "				, " Pipe"							)	.setMaterialStats(U2   )		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE).aspects(TC.ITER, 1),
	pipeRestrictiveSmall		= create("pipeRestrictiveSmall"			, "Small Restrictive Pipes"			, "Small Restrictive "				, " Pipe"							)	.setMaterialStats(U    )		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE).aspects(TC.ITER, 1),
	pipeRestrictiveMedium		= create("pipeRestrictiveMedium"		, "Medium Restrictive Pipes"		, "Medium Restrictive "				, " Pipe"							)	.setMaterialStats(U * 3)		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE).aspects(TC.ITER, 1),
	pipeRestrictiveLarge		= create("pipeRestrictiveLarge"			, "Large Restrictive Pipes"			, "Large Restrictive "				, " Pipe"							)	.setMaterialStats(U * 6)		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE).aspects(TC.ITER, 2),
	pipeRestrictiveHuge			= create("pipeRestrictiveHuge"			, "Huge Restrictive Pipes"			, "Huge Restrictive "				, " Pipe"							)	.setMaterialStats(U *12)		.setCondition(PIPES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE).aspects(TC.ITER, 2),
	pipe						= create("pipe"							, "Pipes"							, ""								, " Pipe"							)									.setCondition(PIPES)																						.add().aspects(TC.ITER, 1),
	
	wireGt16					= create("wireGt16"						, "16x Wires"						, "16x "							, " Wire"							)	.setMaterialStats(U * 8)		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).setMinStacksize( 2).aspects(TC.ELECTRUM, 1),
	wireGt12					= create("wireGt12"						, "12x Wires"						, "12x "							, " Wire"							)	.setMaterialStats(U * 6)		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).setMinStacksize( 2).aspects(TC.ELECTRUM, 1),
	wireGt08					= create("wireGt08"						, "8x Wires"						, "8x "								, " Wire"							)	.setMaterialStats(U * 4)		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).setMinStacksize( 2).aspects(TC.ELECTRUM, 1),
	wireGt04					= create("wireGt04"						, "4x Wires"						, "4x "								, " Wire"							)	.setMaterialStats(U * 2)		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).setMinStacksize( 4).aspects(TC.ELECTRUM, 1),
	wireGt02					= create("wireGt02"						, "2x Wires"						, "2x "								, " Wire"							)	.setMaterialStats(U    )		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).setMinStacksize( 8).aspects(TC.ELECTRUM, 1),
	wireGt01					= create("wireGt01"						, "1x Wires"						, "1x "								, " Wire"							)	.setMaterialStats(U2   )		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).setMinStacksize(16).aspects(TC.ELECTRUM, 1),
	
	cableGt12					= create("cableGt12"					, "12x Cables"						, "12x "							, " Cable"							)	.setMaterialStats(U * 6)		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE).setMinStacksize( 2).aspects(TC.ELECTRUM, 1),
	cableGt08					= create("cableGt08"					, "8x Cables"						, "8x "								, " Cable"							)	.setMaterialStats(U * 4)		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE).setMinStacksize( 2).aspects(TC.ELECTRUM, 1),
	cableGt04					= create("cableGt04"					, "4x Cables"						, "4x "								, " Cable"							)	.setMaterialStats(U * 2)		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE).setMinStacksize( 4).aspects(TC.ELECTRUM, 1),
	cableGt02					= create("cableGt02"					, "2x Cables"						, "2x "								, " Cable"							)	.setMaterialStats(U    )		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE).setMinStacksize( 8).aspects(TC.ELECTRUM, 1),
	cableGt01					= create("cableGt01"					, "1x Cables"						, "1x "								, " Cable"							)	.setMaterialStats(U2   )		.setCondition(WIRES)																						.add(UNIFICATABLE, BURNABLE, UNIFICATABLE_RECIPES, RECYCLABLE, SIMPLIFIABLE).setMinStacksize(16).aspects(TC.ELECTRUM, 1),
	
	crateGtGem					= create("crateGtGem"					, "Crates of Gems"					, "Crate of "						, " Gems"							)	.setMaterialStats(U *16)		.setCondition(gem)																							.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, IS_CONTAINER).setStacksize(64).aspects(TC.ITER, 1, TC.VITREUS	, 3), // consisting out of 16 Gems.
	crateGtDust					= create("crateGtDust"					, "Crates of Dust"					, "Crate of "						, " Dusts"							)	.setMaterialStats(U *16)		.setCondition(dust)																							.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, IS_CONTAINER).setStacksize(64).aspects(TC.ITER, 1, TC.PERDITIO	, 3), // consisting out of 16 Dusts.
	crateGtIngot				= create("crateGtIngot"					, "Crates of Ingots"				, "Crate of "						, " Ingots"							)	.setMaterialStats(U *16)		.setCondition(ingot)																						.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, IS_CONTAINER).setStacksize(64).aspects(TC.ITER, 1, TC.METALLUM	, 3), // consisting out of 16 Ingots.
	crateGtPlate				= create("crateGtPlate"					, "Crates of Plates"				, "Crate of "						, " Plates"							)	.setMaterialStats(U *16)		.setCondition(plate)																						.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, IS_CONTAINER).setStacksize(64).aspects(TC.ITER, 1, TC.FABRICO	, 3), // consisting out of 16 Plates.
	crateGtPlateGem				= create("crateGtPlateGem"				, "Crates of Gem Plates"			, "Crate of "						, " Gem Plates"						)	.setMaterialStats(U *16)		.setCondition(plateGem)																						.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, IS_CONTAINER).setStacksize(64).aspects(TC.ITER, 1, TC.FABRICO	, 3), // consisting out of 16 Plates.
	
	blockGem					= create("blockGem"						, "Blocks of Gems"					, "Block of "						, ""								)	.setMaterialStats(U * 9)		.setCondition(gem)																							.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, BLOCK_BASED, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, GEM_BASED).setStacksize(64).aspects(TC.VITREUS	, 3), // To finally get rid of the messy and unreliable Storage Block Code.
	blockDust					= create("blockDust"					, "Blocks of Dusts"					, "Block of "						, " Dust"							)	.setMaterialStats(U * 9)		.setCondition(dust)																							.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, BLOCK_BASED, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, DUST_BASED).setStacksize(64).aspects(TC.PERDITIO	, 3), // To finally get rid of the messy and unreliable Storage Block Code.
	blockIngot					= create("blockIngot"					, "Blocks of Ingots"				, "Block of "						, " Ingots"							)	.setMaterialStats(U * 9)		.setCondition(ingot)																						.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, BLOCK_BASED, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER, INGOT_BASED).setStacksize(64).aspects(TC.METALLUM	, 3), // To finally get rid of the messy and unreliable Storage Block Code.
	blockPlate					= create("blockPlate"					, "Blocks of Plates"				, "Block of "						, " Plates"							)	.setMaterialStats(U * 9)		.setCondition(plate)																						.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, BLOCK_BASED, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).setStacksize(64).aspects(TC.FABRICO				, 3), // To finally get rid of the messy and unreliable Storage Block Code.
	blockPlateGem				= create("blockPlateGem"				, "Blocks of Gem Plates"			, "Block of "						, " Gem Plates"						)	.setMaterialStats(U * 9)		.setCondition(plateGem)																						.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, BLOCK_BASED, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).setStacksize(64).aspects(TC.FABRICO				, 3), // To finally get rid of the messy and unreliable Storage Block Code.
	blockSolid					= create("blockSolid"					, "Blocks of Cast Metal"			, "Block of solid "					, ""								)	.setMaterialStats(U * 9)		.setCondition(blockIngot)																					.add(UNIFICATABLE, BURNABLE, TOOLTIP_MATERIAL, BLOCK_BASED, RECYCLABLE, SIMPLIFIABLE, SCANNABLE, EXTRUDER_FODDER).setStacksize(64).aspects(TC.METALLUM				, 5), // To finally get rid of the messy and unreliable Storage Block Code.
	
	orebush						= create("orebush"						, "Ore Bushes"						, ""								, " Bush"							)									.setCondition(PLANTS)																						.add(TD.Creative.HIDDEN, PLANT_DROP).setMinStacksize(16).aspects(TC.HERBA, 1),
	oreberry					= create("oreberry"						, "Ore Berries"						, ""								, " Berry"							)	.setMaterialStats(U9   )		.setCondition(PLANTS)																						.add(TD.Creative.HIDDEN, UNIFICATABLE, BURNABLE, RECYCLABLE, PLANT_DROP).setMinStacksize(16).aspects(TC.HERBA, 1),
	
	plantGtBerry				= create("plantGtBerry"					, "Berries"							, ""								, " Berry"							)	.setMaterialStats(U9   )		.setCondition(PLANTS)																						.add(TD.Creative.HIDDEN, UNIFICATABLE, BURNABLE, RECYCLABLE, PLANT_DROP).setMinStacksize(16).aspects(TC.MESSIS, 1),
	plantGtTwig					= create("plantGtTwig"					, "Twigs"							, ""								, " Twig"							)	.setMaterialStats(U9   )		.setCondition(PLANTS)																						.add(TD.Creative.HIDDEN, UNIFICATABLE, BURNABLE, RECYCLABLE, PLANT_DROP).setMinStacksize(16).aspects(TC.ARBOR, 1),
	plantGtFiber				= create("plantGtFiber"					, "Fibers"							, "Raw "							, " Fiber"							)	.setMaterialStats(U9   )		.setCondition(PLANTS)																						.add(TD.Creative.HIDDEN, UNIFICATABLE, BURNABLE, RECYCLABLE, PLANT_DROP).setMinStacksize(16).aspects(TC.MESSIS, 1),
	plantGtWart					= create("plantGtWart"					, "Warts"							, ""								, " Wart"							)	.setMaterialStats(U4   )		.setCondition(PLANTS)																						.add(TD.Creative.HIDDEN, UNIFICATABLE, BURNABLE, RECYCLABLE, PLANT_DROP).setMinStacksize(16).aspects(TC.HERBA, 1),
	plantGtBlossom				= create("plantGtBlossom"				, "Blossoms"						, ""								, " Blossom"						)	.setMaterialStats(U9   )		.setCondition(PLANTS)																						.add(TD.Creative.HIDDEN, UNIFICATABLE, BURNABLE, RECYCLABLE, PLANT_DROP).setMinStacksize(16).aspects(TC.HERBA, 1),
	
	compressedCobblestone		= create("compressedCobblestone"		, "9^X Compressed Cobblestones"		, ""								, ""								)									.add(),
	compressedStone				= create("compressedStone"				, "9^X Compressed Stones"			, ""								, ""								)									.add(),
	compressedDirt				= create("compressedDirt"				, "9^X Compressed Dirt"				, ""								, ""								)									.add(),
	compressedGravel			= create("compressedGravel"				, "9^X Compressed Gravel"			, ""								, ""								)									.add(),
	compressedSand				= create("compressedSand"				, "9^X Compressed Sand"				, ""								, ""								)									.add(),
	
	blockBamboo					= create("blockBamboo"					, "Bamboo Blocks"					, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED),
	blockGlass					= create("blockGlass"					, "Glass Blocks"					, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED),
	blockWool					= create("blockWool"					, "Wool Blocks"						, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED),
	block_						= create("block_"						, "Random Blocks"					, ""								, ""								)									.add(BLOCK_BASED, NO_PREFIX_FILTERING), // IGNORE
	block						= create("block"						, "Random Blocks"					, ""								, ""								)									.add(BLOCK_BASED, NO_PREFIX_FILTERING), // Storage Block consisting out of 9 Ingots/Gems/Dusts. Introduced by CovertJaguar, abused by too many people, and then deprecated by me, by adding a bunch of more detailed Prefixes, to finally get rid of the messy an unreliable Storage Block Code.
	
	item_						= create("item_"						, "Items"							, ""								, ""								)									.add(NO_PREFIX_FILTERING), // IGNORE
	item						= create("item"							, "Items"							, ""								, ""								)									.add(NO_PREFIX_FILTERING), // Random Item. Introduced by Alblaka
	
	glass						= create("glass"						, "Glasses"							, ""								, ""								)									.add(SELF_REFERENCING, UNIFICATABLE_RECIPES),
	paneGlass					= create("paneGlass"					, "Glass Panes"						, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED),
	stainedClay					= create("stainedClay"					, "Stained Clays"					, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED), // Used for the 16 colors of Stained Clay. Introduced by Forge
	
	craftingTool				= create("craftingTool"					, "Crafting Tools"					, ""								, ""								)									.add(TOOL_ALIKE), // Special Prefix used mainly for the Crafting Handler.
	crafting					= create("crafting"						, "Crafting Ingredients"			, ""								, ""								)									.add(NO_PREFIX_FILTERING), // Special Prefix used mainly for the Crafting Handler.
	craft						= create("craft"						, "Crafting Stuff?"					, ""								, ""								)									.add(), // Special Prefix used mainly for the Crafting Handler.
	
	slab						= create("slab"							, "Slabs"							, ""								, ""								)									.add(BLOCK_BASED), // Prefix used for Slabs. Usually as "slabWood" or "slabStone". Introduced by SirSengir
	stair						= create("stair"						, "Stairs"							, ""								, ""								)									.add(BLOCK_BASED), // Prefix used for Stairs. Usually as "stairWood" or "stairStone". Introduced by SirSengir
	fence						= create("fence"						, "Fences"							, ""								, ""								)									.add(), // Prefix used for Fences. Usually as "fenceWood". Introduced by Forge
	
	treeSapling					= create("treeSapling"					, "Saplings"						, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED).addIdenticalNames("sapling").setMinStacksize(16), // Prefix for Saplings.
	treeLeaves					= create("treeLeaves"					, "Leaves"							, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED).addIdenticalNames("leaves").setMinStacksize(16), // Prefix for Leaves.
	tree						= create("tree"							, "Tree Parts"						, ""								, ""								)									.add(), // Prefix for Tree Parts.
	log							= create("log"							, "Logs"							, ""								, ""								)									.add(BLOCK_BASED), // Prefix used for Logs. Usually as "logWood". Introduced by Eloraam
	beam						= create("beam"							, "Beams"							, ""								, ""								)									.add(BLOCK_BASED), // Prefix used for Beams.  Usually as "beamWood".
	plank						= create("plank"						, "Planks"							, ""								, ""								)									.add(BLOCK_BASED).setMinStacksize(16), // Prefix for Planks. Usually "plankWood". Introduced by Eloraam
	
	stoneCobble					= create("stoneCobble"					, "Cobblestones"					, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED											).aspects(TC.TERRA, 1), // Cobblestone Prefix for all Cobblestones.
	stoneSmooth					= create("stoneSmooth"					, "Smoothstones"					, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED											).aspects(TC.TERRA, 1), // Smoothstone Prefix.
	stoneMossyBricks			= create("stoneMossyBricks"				, "mossy Stone Bricks"				, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED											).aspects(TC.TERRA, 1).addIdenticalNames("stoneBricksMossy"), // Mossy Stone Bricks.
	stoneMossy					= create("stoneMossy"					, "Mossy Stones"					, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED											).aspects(TC.TERRA, 1), // Mossy Cobble.
	stoneBricks					= create("stoneBricks"					, "Stone Bricks"					, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED											).aspects(TC.TERRA, 1).addIdenticalNames("stoneBrick", "stonebrick"), // Stone Bricks.
	stoneCracked				= create("stoneCracked"					, "Cracked Stones"					, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED											).aspects(TC.TERRA, 1), // Cracked Bricks.
	stoneChiseled				= create("stoneChiseled"				, "Chiseled Stones"					, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED											).aspects(TC.TERRA, 1), // Chiseled Stone.
	stonePolished				= create("stonePolished"				, "Polished Stones"					, ""								, ""								)									.add(SELF_REFERENCING, BLOCK_BASED											).aspects(TC.TERRA, 1), // Polished Stone.
	stone						= create("stone"						, "Stones"							, ""								, ""								)									.add(MATERIAL_BASED, SELF_REFERENCING, BLOCK_BASED, UNIFICATABLE_RECIPES	).aspects(TC.TERRA, 1), // Prefix to determine which kind of Rock this is.
	cobblestone					= create("cobblestone"					, "Cobblestones"					, ""								, ""								)									.add(MATERIAL_BASED, SELF_REFERENCING, BLOCK_BASED							).aspects(TC.TERRA, 1),
	rock						= create("rock"							, "Rocks"							, ""								, ""								)									.add(MATERIAL_BASED, SELF_REFERENCING, BLOCK_BASED, UNIFICATABLE_RECIPES	).aspects(TC.TERRA, 1), // Prefix to determine which kind of Rock this is.
	
	record						= create("record"						, "Records"							, ""								, ""								)									.add(SELF_REFERENCING).setStacksize(64).aspects(TC.SENSUS, 4),
	scraps						= create("scraps"						, "Scraps"							, ""								, ""								)									.add(UNIFICATABLE, MATERIAL_BASED),
	scrap						= create("scrap"						, "Scraps"							, ""								, ""								)									.add(),
	
	book						= create("book"							, "Books"							, ""								, ""								)									.add(), // Used for Books of any kind.
	paper						= create("paper"						, "Papers"							, ""								, ""								)									.add(), // Used for Papers of any kind.
	dye							= create("dye"							, "Dyes"							, ""								, ""								)									.add(SELF_REFERENCING), // Used for the 16 dyes. Introduced by Eloraam
	dyeMixable					= create("dyeMixable"					, "Mixable Dyes"					, ""								, ""								)									.add(SELF_REFERENCING), // Used for the dyes that can be mixed together.
	dyeCeramic					= create("dyeCeramic"					, "Ceramic Dyes"					, ""								, ""								)									.add(SELF_REFERENCING), // Used for the MFR dyes.
	
	/* Electric Components.
	 * 
	 * usual Materials for this are:
	 * Primitive (Tier 1)
	 * Basic (Tier 2) as used by UE as well : IC2 Circuit and RE-Battery
	 * Good (Tier 3)
	 * Advanced (Tier 4) as used by UE as well : Advanced Circuit, Advanced Battery and Lithium Battery
	 * Data (Tier 5) : Data Storage Circuit
	 * Elite (Tier 6) as used by UE as well : Energy Crystal and Data Control Circuit
	 * Master (Tier 7) : Energy Flow Circuit and Lapotron Crystal
	 * Ultimate (Tier 8) : Data Orb and Lapotronic Energy Orb
	 * Infinite (Cheaty)
	 */
	batterySingleuse			= create("batterySingleuse"				, "Single Use Batteries"			).add(MATERIAL_BASED).aspects(TC.ELECTRUM, 2),
	battery						= create("battery"						, "Reusable Batteries"				).add(MATERIAL_BASED).aspects(TC.ELECTRUM, 1), // Introduced by Calclavia
	circuit						= create("circuit"						, "Circuits"						).add(MATERIAL_BASED).aspects(TC.COGNITO, 1), // Introduced by Calclavia
	computer					= create("computer"						, "Computers"						).add(MATERIAL_BASED).aspects(TC.COGNITO, 4), // A whole Computer.
	
	// random known prefixes without special abilities.
	shard						= unused("shard"						).setCategoryName("Crystallised Shards"				), // Introduced by Mekanism, abused too much to be used...
	sand						= unused("sand"							).setCategoryName("Sands"							).add(SELF_REFERENCING, BLOCK_BASED),
	wire						= unused("wire"							).setCategoryName("Wires"							).add(UNIFICATABLE_RECIPES).aspects(TC.ELECTRUM, 1),
	lamp						= unused("lamp"							).setCategoryName("Lamps"),
	cloth						= unused("cloth"						).setCategoryName("Cloth"),
	fabric						= unused("fabric"						).setCategoryName("Fabric"),
	quartz						= unused("quartz"						).setCategoryName("Quartzes"),
	part						= unused("part"							).setCategoryName("Parts"), // partBasicCircuit partAdvancedCircuit partPhotocell partMotor
	torch						= unused("torch"						).setCategoryName("Torches"),
	skull						= unused("skull"						).setCategoryName("Skulls"),
	plating						= unused("plating"						).setCategoryName("Platings"),
	dinosaur					= unused("dinosaur"						).setCategoryName("Dinosaurs"),
	travelgear					= unused("travelgear"					).setCategoryName("Travel Gear"),
	bauble						= unused("bauble"						).setCategoryName("Baubles"),
	grafter						= unused("grafter"						).setCategoryName("Grafters"),
	scoop						= unused("scoop"						).setCategoryName("Scoops"),
	frame						= unused("frame"						).setCategoryName("Frames").aspects(TC.FABRICO, 1),
	tome						= unused("tome"							).setCategoryName("Tomes"),
	junk						= unused("junk"							).setCategoryName("Junk"),
	bee							= unused("bee"							).setCategoryName("Bees"),
	rod							= unused("rod"							).setCategoryName("Rods"),
	dirt						= unused("dirt"							).setCategoryName("Dirts"),
	grass						= unused("grass"						).setCategoryName("Grasses"),
	gravel						= unused("gravel"						).setCategoryName("Gravels"),
	mushroom					= unused("mushroom"						).setCategoryName("Mushrooms"),
	wood						= unused("wood"							).setCategoryName("Woods"),
	drop						= unused("drop"							).setCategoryName("Drops"),
	fuel						= unused("fuel"							).setCategoryName("Fuels"),
	panel						= unused("panel"						).setCategoryName("Panels"),
	brick						= unused("brick"						).setCategoryName("Bricks"),
	seed						= unused("seed"							).setCategoryName("Seeds"),
	reed						= unused("reed"							).setCategoryName("Reeds"),
	sheetDouble					= unused("sheetDouble"					).setCategoryName("2x Sheets"),
	sheet						= unused("sheet"						).setCategoryName("Sheets"),
	crop						= unused("crop"							).setCategoryName("Crops"),
	plant						= unused("plant"						).setCategoryName("Plants"),
	coin						= unused("coin"							).setCategoryName("Coins"),
	lumar						= unused("lumar"						).setCategoryName("Lumars"),
	ground						= unused("ground"						).setCategoryName("Grounded Stuff"),
	cable						= unused("cable"						).setCategoryName("Cables").aspects(TC.ELECTRUM, 1),
	component					= unused("component"					).setCategoryName("Components"),
	pole						= unused("pole"							).setCategoryName("Poles"),
	desert						= unused("desert"						).setCategoryName("Desert Stuff"),
	jungle						= unused("jungle"						).setCategoryName("Jungle Stuff"),
	savanna						= unused("savanna"						).setCategoryName("Savanna Stuff"),
	beach						= unused("beach"						).setCategoryName("Beach Stuff"),
	forest						= unused("forest"						).setCategoryName("Forest Stuff"),
	mountain					= unused("mountain"						).setCategoryName("Mountain Stuff"),
	plains						= unused("plains"						).setCategoryName("Plains Stuff"),
	epiphyte					= unused("epiphyte"						).setCategoryName("Epiphyte Stuff"),
	water						= unused("water"						).setCategoryName("Water Stuff"),
	river						= unused("river"						).setCategoryName("River Stuff"),
	ocean						= unused("ocean"						).setCategoryName("Ocean Stuff"),
	hanging						= unused("hanging"						).setCategoryName("Hanging Stuff"),
	floating					= unused("floating"						).setCategoryName("Floating Stuff"),
	wetlands					= unused("wetlands"						).setCategoryName("Wetland Stuff"),
	fern						= unused("fern"							).setCategoryName("Ferns"),
	vine						= unused("vine"							).setCategoryName("Vines"),
	fungus						= unused("fungus"						).setCategoryName("Fungi"),
	cactus						= unused("cactus"						).setCategoryName("Cacti"),
	bud							= unused("bud"							).setCategoryName("Buds"),
	immersed					= unused("immersed"						).setCategoryName("Immersed Stuff"),
	bamboo						= unused("bamboo"						).setCategoryName("Bamboo Stuff"),
	cones						= unused("cones"						).setCategoryName("Cones"),
	consumable					= unused("consumable"					).setCategoryName("Consumables"),
	leafy						= unused("leafy"						).setCategoryName("Leafy Stuff"),
	leaf						= unused("leaf"							).setCategoryName("Leaf Stuff"),
	shrub						= unused("shrub"						).setCategoryName("Shrubs"),
	berrybush					= unused("berrybush"					).setCategoryName("Berry Bushes"),
	wax							= unused("wax"							).setCategoryName("Waxes"),
	wall						= unused("wall"							).setCategoryName("Walls"),
	tube						= unused("tube"							).setCategoryName("Tubes"),
	list						= unused("list"							).setCategoryName("Lists").add(NO_PREFIX_FILTERING),
	food						= unused("food"							).setCategoryName("Foods").add(NO_PREFIX_FILTERING),
	gear						= unused("gear"							).setCategoryName("Gears"), // Introduced by SirSengir
	coral						= unused("coral"						).setCategoryName("Corals"),
	flower						= unused("flower"						).setCategoryName("Flowers"),
	storage						= unused("storage"						).setCategoryName("Storages"),
	material					= unused("material"						).setCategoryName("Materials").add(NO_PREFIX_FILTERING),
	plasma						= unused("plasma"						).setCategoryName("Plasmas"),
	element						= unused("element"						).setCategoryName("Elements"),
	molecule					= unused("molecule"						).setCategoryName("Molecules"),
	wafer						= unused("wafer"						).setCategoryName("Wafers"),
	orb							= unused("orb"							).setCategoryName("Orbs"),
	handle						= unused("handle"						).setCategoryName("Handles"),
	blade						= unused("blade"						).setCategoryName("Blades"),
	head						= unused("head"							).setCategoryName("Heads"),
	motor						= unused("motor"						).setCategoryName("Motors"),
	bowl						= unused("bowl"							).setCategoryName("Bowls"),
	bit							= unused("bit"							).setCategoryName("Bits"),
	shears						= unused("shears"						).setCategoryName("Shears"),
	turbine						= unused("turbine"						).setCategoryName("Turbines"),
	fertilizer					= unused("fertilizer"					).setCategoryName("Fertilizers"),
	chest						= unused("chest"						).setCategoryName("Chests"),
	raw							= unused("raw"							).setCategoryName("Raw Things"),
	stainedGlass				= unused("stainedGlass"					).setCategoryName("Stained Glasses"),
	mystic						= unused("mystic"						).setCategoryName("Mystic Stuff"),
	mana						= unused("mana"							).setCategoryName("Mana Stuff"),
	rune						= unused("rune"							).setCategoryName("Runes"),
	petal						= unused("petal"						).setCategoryName("Petals"),
	pearl						= unused("pearl"						).setCategoryName("Pearls"),
	powder						= unused("powder"						).setCategoryName("Powders"),
	soulsand					= unused("soulsand"						).setCategoryName("Soulsands"),
	obsidian					= unused("obsidian"						).setCategoryName("Obsidians"),
	glowstone					= unused("glowstone"					).setCategoryName("Glowstones"),
	beans						= unused("beans"						).setCategoryName("Beans"),
	essence						= unused("essence"						).setCategoryName("Essences"),
	alloy						= unused("alloy"						).setCategoryName("Alloys"),
	cooking						= unused("cooking"						).setCategoryName("Cooked Things"),
	gate						= unused("gate"							).setCategoryName("Gates"),
	ladder						= unused("ladder"						).setCategoryName("Ladders"),
	door						= unused("door"							).setCategoryName("Doors"),
	trapdoor					= unused("trapdoor"						).setCategoryName("Trapdoors"),
	elven						= unused("elven"						).setCategoryName("Elven Stuff"),
	reactor						= unused("reactor"						).setCategoryName("Reactors"),
	mffs						= unused("mffs"							).setCategoryName("MFFS"),
	projred						= unused("projred"						).setCategoryName("Project Red"),
	ganys						= unused("ganys"						).setCategoryName("Ganys Stuff"),
	liquid						= unused("liquid"						).setCategoryName("Liquids"),
	chipset						= unused("chipset"						).setCategoryName("Chipsets"),
	boule						= unused("boule"						).setCategoryName("Boules"),
	bars						= unused("bars"							).setCategoryName("Bars"),
	bar							= unused("bar"							).setCategoryName("Bars");
	
	static {
		crushed		.addListener(new OreDictListenerItem_Washing(crushedPurified, 2, nugget, gemChipped, crushedPurifiedTiny, crushedPurifiedTiny, dustTiny, dustTiny));
		dustImpure	.addListener(new OreDictListenerItem_Washing(dust, 3, dustTiny));
		dustPure	.addListener(new OreDictListenerItem_Washing(dust, 4, dustTiny));
		dustRefined	.addListener(new OreDictListenerItem_Washing(dust, 5, dustTiny));
		
		bottle.mContainerItem = ST.make(Items.glass_bottle, 1, 0);
		
		ingotHot.mHeatDamage = 3.0F;
		
		crushed.addFamiliarPrefix(crushedTiny);
		crushedTiny.addFamiliarPrefix(crushed);
		crushedPurified.addFamiliarPrefix(crushedPurifiedTiny);
		crushedPurifiedTiny.addFamiliarPrefix(crushedPurified);
		crushedCentrifuged.addFamiliarPrefix(crushedCentrifugedTiny);
		crushedCentrifugedTiny.addFamiliarPrefix(crushedCentrifuged);
		
		for (OreDictPrefix tPrefix1 : OreDictPrefix.VALUES) for (OreDictPrefix tPrefix2 : OreDictPrefix.VALUES) {
			if (tPrefix1.contains(INGOT_BASED				) && tPrefix2.contains(INGOT_BASED					)) tPrefix1.addFamiliarPrefix(tPrefix2);
			if (tPrefix1.contains(DUST_BASED				) && tPrefix2.contains(DUST_BASED					)) tPrefix1.addFamiliarPrefix(tPrefix2);
			if (tPrefix1.contains(DUST_ORE					) && tPrefix2.contains(DUST_ORE						)) tPrefix1.addFamiliarPrefix(tPrefix2);
			if (tPrefix1.contains(DENSE_ORE					) && tPrefix2.contains(DENSE_ORE					)) tPrefix1.addFamiliarPrefix(tPrefix2);
			if (tPrefix1.contains(STANDARD_ORE				) && tPrefix2.contains(STANDARD_ORE					)) tPrefix1.addFamiliarPrefix(tPrefix2);
			if (tPrefix1.mNameInternal.startsWith("pipe"	) && tPrefix2.mNameInternal.startsWith("pipe"		)) tPrefix1.addFamiliarPrefix(tPrefix2);
			if (tPrefix1.mNameInternal.startsWith("wireGt"	) && tPrefix2.mNameInternal.startsWith("wireGt"		)) tPrefix1.addFamiliarPrefix(tPrefix2);
			if (tPrefix1.mNameInternal.startsWith("cableGt"	) && tPrefix2.mNameInternal.startsWith("cableGt"	)) tPrefix1.addFamiliarPrefix(tPrefix2);
		}
		
		// Items which are already there in vanilla MC and IC2.
		gem					.disableItemGeneration(MT.Coal, MT.Charcoal, MT.NetherStar, MT.Diamond, MT.Emerald, MT.NetherQuartz, MT.EnderPearl, MT.EnderEye, MT.Flint, MT.Lapis);
		dust				.disableItemGeneration(MT.Bone, MT.Redstone, MT.Glowstone, MT.Gunpowder, MT.Sugar, MT.Blaze);
		stick				.disableItemGeneration(MT.Wood, MT.Bone, MT.Blaze);
		ingot				.disableItemGeneration(MT.Fe, MT.Au, MT.NetherBrick);
		nugget				.disableItemGeneration(MT.Au);
		plate				.disableItemGeneration(MT.Paper);
		bucket				.disableItemGeneration(MT.Empty, MT.Water, MT.Lava, MT.Milk);
		bottle				.disableItemGeneration(MT.Empty, MT.Water);
		
		gemChipped			.forceItemGeneration(MT.Ice, MT.NaCl, MT.KCl, MT.KIO3, MT.Sugar);
		gemFlawed			.forceItemGeneration(MT.Ice, MT.NaCl, MT.KCl, MT.KIO3);
		gem					.forceItemGeneration(MT.Ice, MT.NaCl, MT.KCl, MT.KIO3);
		bouleGt				.forceItemGeneration(MT.Si, MT.RedstoneAlloy, MT.NikolineAlloy, MT.TeslatineAlloy);
		plateTiny			.forceItemGeneration(MT.Paper);
		
		for (OreDictMaterial tMat : ANY.Glowstone.mToThis) tMat.setPriorityPrefix(OP.dust);
		MT.Redstone				.setPriorityPrefix(OP.dust);
		MT.Electrotine			.setPriorityPrefix(OP.dust);
		MT.Nikolite				.setPriorityPrefix(OP.dust);
		MT.Teslatite			.setPriorityPrefix(OP.dust);
		MT.KNO3					.setPriorityPrefix(OP.dust);
		MT.NaNO3				.setPriorityPrefix(OP.dust);
		MT.S					.setPriorityPrefix(OP.dust);
		MT.Si					.setPriorityPrefix(OP.plateGem);
		MT.RedstoneAlloy		.setPriorityPrefix(OP.plateGem);
		MT.NikolineAlloy		.setPriorityPrefix(OP.plateGem);
		MT.TeslatineAlloy		.setPriorityPrefix(OP.plateGem);
		
		//-----
		
		pipeRestrictiveTiny.mByProducts		.add(OM.stack(ANY.Steel				, ring.mAmount));
		pipeRestrictiveSmall.mByProducts	.add(OM.stack(ANY.Steel				, ring.mAmount * 2));
		pipeRestrictiveMedium.mByProducts	.add(OM.stack(ANY.Steel				, ring.mAmount * 3));
		pipeRestrictiveLarge.mByProducts	.add(OM.stack(ANY.Steel				, ring.mAmount * 4));
		pipeRestrictiveHuge.mByProducts		.add(OM.stack(ANY.Steel				, ring.mAmount * 5));
		cableGt12.mByProducts				.add(OM.stack(MT.Rubber				, plate.mAmount * 4));
		cableGt08.mByProducts				.add(OM.stack(MT.Rubber				, plate.mAmount * 3));
		cableGt04.mByProducts				.add(OM.stack(MT.Rubber				, plate.mAmount * 2));
		cableGt02.mByProducts				.add(OM.stack(MT.Rubber				, plate.mAmount));
		cableGt01.mByProducts				.add(OM.stack(MT.Rubber				, plate.mAmount));
//		bucket.mByProducts					.add(OM.stack(MT.Fe					, ingot.mAmount * 3));
		cell.mByProducts					.add(OM.stack(MT.Sn					, plateCurved.mAmount));
		bottle.mByProducts					.add(OM.stack(MT.Glass				, U));
		chemtube.mByProducts				.add(OM.stack(MT.Glass				, U3));
		oreBedrock.mByProducts				.add(OM.stack(MT.Bedrock			, dust.mAmount));
		oreAndesite.mByProducts				.add(OM.stack(MT.Andesite			, dust.mAmount));
		oreDiorite.mByProducts				.add(OM.stack(MT.Diorite			, dust.mAmount));
		oreRedgranite.mByProducts			.add(OM.stack(MT.GraniteRed			, dust.mAmount));
		oreBlackgranite.mByProducts			.add(OM.stack(MT.GraniteBlack		, dust.mAmount));
		oreVanillagranite.mByProducts		.add(OM.stack(MT.Granite			, dust.mAmount));
		oreVanillastone.mByProducts			.add(OM.stack(MT.Stone				, dust.mAmount));
		oreMoon.mByProducts					.add(OM.stack(MT.MoonRock			, dust.mAmount));
		oreMars.mByProducts					.add(OM.stack(MT.MarsRock			, dust.mAmount));
		oreHolystone.mByProducts			.add(OM.stack(MT.Holystone			, dust.mAmount));
		oreUmberstone.mByProducts			.add(OM.stack(MT.Umber				, dust.mAmount));
		oreBetweenstone.mByProducts			.add(OM.stack(MT.Betweenstone		, dust.mAmount));
		orePitstone.mByProducts				.add(OM.stack(MT.Pitstone			, dust.mAmount));
		oreKomatiite.mByProducts			.add(OM.stack(MT.Komatiite			, dust.mAmount));
		oreBasalt.mByProducts				.add(OM.stack(MT.Basalt				, dust.mAmount));
		oreMarble.mByProducts				.add(OM.stack(MT.Marble				, dust.mAmount));
		oreLimestone.mByProducts			.add(OM.stack(MT.Limestone			, dust.mAmount));
		oreSiltstone.mByProducts			.add(OM.stack(MT.Siltstone			, dust.mAmount));
		oreShale.mByProducts				.add(OM.stack(MT.Shale				, dust.mAmount));
		oreGreenschist.mByProducts			.add(OM.stack(MT.Greenschist		, dust.mAmount));
		oreBlueschist.mByProducts			.add(OM.stack(MT.Blueschist			, dust.mAmount));
		oreKimberlite.mByProducts			.add(OM.stack(MT.Kimberlite			, dust.mAmount));
		oreQuartzite.mByProducts			.add(OM.stack(MT.Quartzite			, dust.mAmount));
		oreNetherrack.mByProducts			.add(OM.stack(MT.Netherrack			, dust.mAmount));
		oreNether.mByProducts				.add(OM.stack(MT.Netherrack			, dust.mAmount));
		oreHee.mByProducts					.add(OM.stack(MT.Endstone			, dust.mAmount));
		oreEndstone.mByProducts				.add(OM.stack(MT.Endstone			, dust.mAmount));
		oreEnd.mByProducts					.add(OM.stack(MT.Endstone			, dust.mAmount));
		orePoor.mByProducts					.add(OM.stack(MT.Stone				, dust.mAmount * 2));
		oreSmall.mByProducts				.add(OM.stack(MT.Stone				, dust.mAmount * 2));
		oreNormal.mByProducts				.add(OM.stack(MT.Stone				, dust.mAmount * 2));
		oreRich.mByProducts					.add(OM.stack(MT.Stone				, dust.mAmount * 2));
		crushed.mByProducts					.add(OM.stack(MT.Stone				, dust.mAmount));
		toolHeadPickaxeGem.mByProducts		.add(OM.stack(ANY.Steel				, toolHeadPickaxe.mAmount));
		toolHeadDrill.mByProducts			.add(OM.stack(ANY.Steel				, plate.mAmount * 4));
		toolHeadChainsaw.mByProducts		.add(OM.stack(ANY.Steel				, plate.mAmount * 4 + ring.mAmount * 2));
		toolHeadWrench.mByProducts			.add(OM.stack(ANY.Steel				, ring.mAmount + screw.mAmount * 2));
		plantGtTwig.mByProducts				.add(OM.stack(ANY.Wood				, stick.mAmount));
		arrowGtWood.mByProducts				.add(OM.stack(ANY.Wood				, stick.mAmount));
		arrowGtPlastic.mByProducts			.add(OM.stack(MT.Plastic			, stick.mAmount));
		bulletGtSmall.mByProducts			.add(OM.stack(MT.Brass				, U9));
		bulletGtMedium.mByProducts			.add(OM.stack(MT.Brass				, 2*U9));
		bulletGtLarge.mByProducts			.add(OM.stack(MT.Brass				, U3));
		bulletGtSmall.mByProducts			.add(OM.stack(MT.Gunpowder			, U9));
		bulletGtMedium.mByProducts			.add(OM.stack(MT.Gunpowder			, 2*U9));
		bulletGtLarge.mByProducts			.add(OM.stack(MT.Gunpowder			, U3));
	}
}