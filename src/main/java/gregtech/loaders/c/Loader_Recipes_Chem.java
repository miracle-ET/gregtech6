package gregtech.loaders.c;

import static gregapi.data.CS.*;

import gregapi.data.ANY;
import gregapi.data.CS.FluidsGT;
import gregapi.data.FL;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.data.RM;
import gregapi.oredict.OreDictMaterial;
import gregapi.util.OM;
import gregapi.util.ST;
import gregapi.util.UT;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class Loader_Recipes_Chem implements Runnable {
	@Override public void run() {OUT.println("GT_Mod: Doing GT Recipes for Chemical Stuff.");
		for (FluidStack tFluid : new FluidStack[] {FL.Water.make(1000), FL.DistW.make(1000)}) {		
		RM.Mixer		.addRecipe1(T, 16,   16, OM.dust(MT.NaCl, U4), UT.Fluids.mul(tFluid, 3, 4, T), MT.SaltWater.liquid(U*1, F), ZL_IS);
		RM.Mixer		.addRecipe1(T, 16,   16, OM.dust(MT.NaCl	), UT.Fluids.mul(tFluid, 3      ), MT.SaltWater.liquid(U*4, F), ZL_IS);
		
		RM.Mixer		.addRecipe1(T, 16,   64, OM.dust(MT.Si), UT.Fluids.mul(tFluid, 6), MT.H.gas(U*4, F), OM.dust(MT.SiO2, U*3));
		RM.Mixer		.addRecipe1(T, 16,  256, OM.dust(MT.Na), UT.Fluids.mul(tFluid, 3), MT.H.gas(U*1, F), OM.dust(MT.NaOH, U*3));
		RM.Mixer		.addRecipe1(T, 16,  256, OM.dust(MT.K ), UT.Fluids.mul(tFluid, 3), MT.H.gas(U*1, F), OM.dust(MT.KOH , U*3));
		RM.Mixer		.addRecipe1(T, 16,  256, OM.dust(MT.Li), UT.Fluids.mul(tFluid, 3), MT.H.gas(U*1, F), OM.dust(MT.LiOH, U*3));
		
		RM.Mixer		.addRecipe1(T, 16,  112, OM.dust(MT.Ca), new FluidStack[] {MT.CO2.gas(U*3, T), UT.Fluids.mul(tFluid, 3)}, MT.H.gas(U * 2, F), OM.dust(MT.CaCO3, U*5));
		RM.Mixer		.addRecipe1(T, 16,  112, OM.dust(MT.Mg), new FluidStack[] {MT.CO2.gas(U*3, T), UT.Fluids.mul(tFluid, 3)}, MT.H.gas(U * 2, F), OM.dust(MT.MgCO3, U*5));
		
		RM.Mixer		.addRecipe0(T, 16,   64, new FluidStack[] {UT.Fluids.mul(tFluid, 3), MT.Cl .gas(U*2, T)}, MT.HCl.fluid(U*4, F), MT.O.gas(U, F));
		RM.Mixer		.addRecipe0(T, 16,   64, new FluidStack[] {UT.Fluids.mul(tFluid, 3), MT.SO3.gas(U*4, T)}, MT.H2SO4.fluid(U*7, F), ZL_IS);
		RM.Mixer		.addRecipe0(T, 16,  192, new FluidStack[] {UT.Fluids.mul(tFluid, 3), MT.NO2.gas(U*9, T)}, MT.HNO3.liquid(U*10, F), MT.NO.gas(U*2, F));
		
		RM.Electrolyzer	.addRecipe1(T, 16, 1280, OP.dustSmall	.mat(MT.NaCl, 1), new FluidStack[] {UT.Fluids.mul(tFluid, 3, 4, T)}, new FluidStack[] {MT.Cl.gas(U8, F), MT.H.gas(3*U8, F), MT.O.gas(U8, F)}, OM.dust(MT.NaOH, 3*U8));
		RM.Electrolyzer	.addRecipe1(T, 16, 5120, OP.dust		.mat(MT.NaCl, 1), new FluidStack[] {UT.Fluids.mul(tFluid, 3      )}, new FluidStack[] {MT.Cl.gas(U2, F), MT.H.gas(3*U2, F), MT.O.gas(U2, F)}, OM.dust(MT.NaOH, 3*U2));
		RM.Electrolyzer	.addRecipe1(T, 16, 1280, OP.dustSmall	.mat(MT.KCl , 1), new FluidStack[] {UT.Fluids.mul(tFluid, 3, 4, T)}, new FluidStack[] {MT.Cl.gas(U8, F), MT.H.gas(3*U8, F), MT.O.gas(U8, F)}, OM.dust(MT.KOH , 3*U8));
		RM.Electrolyzer	.addRecipe1(T, 16, 5120, OP.dust		.mat(MT.KCl , 1), new FluidStack[] {UT.Fluids.mul(tFluid, 3      )}, new FluidStack[] {MT.Cl.gas(U2, F), MT.H.gas(3*U2, F), MT.O.gas(U2, F)}, OM.dust(MT.KOH , 3*U2));
		RM.Electrolyzer	.addRecipe1(T, 16, 1280, OP.dustSmall	.mat(MT.LiCl, 1), new FluidStack[] {UT.Fluids.mul(tFluid, 3, 4, T)}, new FluidStack[] {MT.Cl.gas(U8, F), MT.H.gas(3*U8, F), MT.O.gas(U8, F)}, OM.dust(MT.LiOH, 3*U8));
		RM.Electrolyzer	.addRecipe1(T, 16, 5120, OP.dust		.mat(MT.LiCl, 1), new FluidStack[] {UT.Fluids.mul(tFluid, 3      )}, new FluidStack[] {MT.Cl.gas(U2, F), MT.H.gas(3*U2, F), MT.O.gas(U2, F)}, OM.dust(MT.LiOH, 3*U2));
		
		
		RM.Bath			.addRecipe1(T,  0, 2048, OP.dust.mat(MT.Mn, 1), UT.Fluids.mul(tFluid, 6), NF, OP.dust.mat(MT.MnO2, 1));
		
		
		RM.Bath			.addRecipe1(T,  0, 2048, OP.dust.mat(MT.KAlO2 , 4), UT.Fluids.mul(tFluid, 6), NF, OP.dust.mat(MT.AlO3H3, 7), OP.dust.mat(MT.KOH , 3));
		RM.Bath			.addRecipe1(T,  0, 2048, OP.dust.mat(MT.NaAlO2, 4), UT.Fluids.mul(tFluid, 6), NF, OP.dust.mat(MT.AlO3H3, 7), OP.dust.mat(MT.NaOH, 3));
		}
		
		
		for (OreDictMaterial tMat : ANY.SiO2.mToThis)
		RM.Mixer		.addRecipe1(T, 16,  240, OM.dust(tMat					,U * 3), new FluidStack[] {MT.HF.gas(U *12, T)}														, new FluidStack[] {MT.H2O.liquid(U * 6, F), MT.H2SiF6.liquid(U * 9, F)});
		RM.Mixer		.addRecipe1(T, 16,  224, OM.dust(MT.Al2O3				,U * 5), new FluidStack[] {MT.H2SiF6.liquid(U * 9, T)}												, new FluidStack[] {MT.H2O.liquid(U * 3, F)}, OM.dust(MT.AlF3, U*8));//, OM.dust(MT.SiO2, U*3));
		RM.Mixer		.addRecipe1(T, 16,  224, OM.ingot(MT.Al2O3				,U * 5), new FluidStack[] {MT.H2SiF6.liquid(U * 9, T)}												, new FluidStack[] {MT.H2O.liquid(U * 3, F)}, OM.dust(MT.AlF3, U*8));//, OM.dust(MT.SiO2, U*3));
		RM.Mixer		.addRecipe2(T, 16,  752, OP.dust.mat(MT.NaOH			,   18), OM.dust(MT.Al2O3,U * 5), MT.HF.gas(U *24, T)												, new FluidStack[] {MT.H2O.liquid(U *27, F), MT.Na3AlF6.liquid(U *20, F)});
		RM.Mixer		.addRecipe2(T, 16,  752, OP.dust.mat(MT.NaOH			,   18), OM.ingot(MT.Al2O3,U * 5), MT.HF.gas(U *24, T)												, new FluidStack[] {MT.H2O.liquid(U *27, F), MT.Na3AlF6.liquid(U *20, F)});
		RM.Mixer		.addRecipe2(T, 16,  752, OP.blockDust.mat(MT.NaOH		,    2), OM.dust(MT.Al2O3,U * 5), MT.HF.gas(U *24, T)												, new FluidStack[] {MT.H2O.liquid(U *27, F), MT.Na3AlF6.liquid(U *20, F)});
		RM.Mixer		.addRecipe2(T, 16,  752, OP.blockDust.mat(MT.NaOH		,    2), OM.ingot(MT.Al2O3,U * 5), MT.HF.gas(U *24, T)												, new FluidStack[] {MT.H2O.liquid(U *27, F), MT.Na3AlF6.liquid(U *20, F)});
		RM.Mixer		.addRecipe1(T, 16,  748, OP.dust.mat(MT.Sugar			,   45), new FluidStack[] {MT.H2SO4.fluid(U4*7, T)}													, new FluidStack[] {MT.H2O.liquid(U4*135, F), MT.SO3.gas(U, F)}, OM.dust(MT.C, U*12));
		RM.Mixer		.addRecipe1(T, 16,  748, OP.blockDust.mat(MT.Sugar		,    5), new FluidStack[] {MT.H2SO4.fluid(U4*7, T)}													, new FluidStack[] {MT.H2O.liquid(U4*135, F), MT.SO3.gas(U, F)}, OM.dust(MT.C, U*12));
		RM.Mixer		.addRecipe1(T, 16,  176, OM.dust(MT.MnO2				,U * 1), new FluidStack[] {MT.HCl.fluid(U * 8, T)}													, new FluidStack[] {MT.H2O.liquid(U * 6, F), MT.Cl.gas(U * 2, F)}, OM.dust(MT.MnCl2, U*3));
		RM.Mixer		.addRecipe1(T, 16,  144, OM.dust(MT.CaCO3				,U * 5), new FluidStack[] {MT.HF.gas(U * 4, T)}														, new FluidStack[] {MT.H2O.liquid(U * 3, F), MT.CO2.gas(U * 3, F)}, OM.dust(MT.CaF2, U*3));
//		RM.Mixer		.addRecipe1(T, 16,  144, OM.dust(MT.MgCO3				,U * 5), new FluidStack[] {MT.HF.gas(U * 4, T)}														, new FluidStack[] {MT.H2O.liquid(U * 3, F), MT.CO2.gas(U * 3, F)}, OM.dust(MT.MgF2, U*3));
		RM.Mixer		.addRecipe1(T, 16,  256, OM.dust(MT.K2CO3				,U * 6), new FluidStack[] {MT.HNO3.liquid(U *10, T)}												, new FluidStack[] {MT.H2O.liquid(U * 3, F), MT.CO2.gas(U * 3, F)}, OM.dust(MT.KNO3, U*10));
		RM.Mixer		.addRecipe1(T, 16,  256, OM.dust(MT.Na2CO3				,U * 6), new FluidStack[] {MT.HNO3.liquid(U *10, T)}												, new FluidStack[] {MT.H2O.liquid(U * 3, F), MT.CO2.gas(U * 3, F)}, OM.dust(MT.NaNO3, U*10));
		RM.HeatMixer	.addRecipe1(T, 16,  354, OM.dust(MT.LiOH				,U *18), new FluidStack[] {MT.Cl.gas(U * 6, T)}														, new FluidStack[] {MT.H2O.liquid(U * 9, F), MT.LiClO3.liquid(U*5, F)}, OM.dust(MT.LiCl, U*10));
		RM.Mixer		.addRecipe1(T, 16,  160, OM.dust(MT.CaF2				,U * 3), MT.H2SO4		.fluid(U * 7, T)															, MT.HF				.gas  (U * 4, F), OM.dust(MT.CaSO4, U* 6));
		RM.Mixer		.addRecipe1(T, 16,   64, OM.dust(MT.Al					,U * 1), MT.F			.gas  (U * 3, T)															, NF								, OM.dust(MT.AlF3, U*4));
		RM.Mixer		.addRecipe1(T, 16,   48, OM.dust(MT.Ca					,U * 1), MT.F			.gas  (U * 2, T)															, NF								, OM.dust(MT.CaF2, U*3));
		RM.HeatMixer	.addRecipe1(T, 16,   48, OM.dust(MT.S					,U * 1), MT.H			.gas  (U * 2, T)															, MT.H2S			.gas  (U * 3, F), ZL_IS);
		RM.HeatMixer	.addRecipe1(T, 16,  160, OM.dust(MT.WO3					,U * 4), MT.H			.gas  (U * 6, T)															, MT.H2O			.liquid(U* 9, F), OM.dust(MT.W, U));
//		RM.Mixer		.addRecipe1(T, 16,   96, OM.dust(MT.FeS					,U * 2), MT.HCl			.fluid(U * 4, T)															, MT.H2S			.gas  (U * 3, F), OM.dust(MT.FeCl2, U*3));
		RM.Mixer		.addRecipe1(T, 16,  752, OM.dust(MT.OREMATS.Borax		,U *43), MT.HCl			.fluid(U * 4, T)															, MT.SaltWater		.liquid(U*16, F), OM.dust(MT.H3BO3, U*28)); // + 3 Units of Water
		RM.Mixer		.addRecipe1(T, 16,   80, OM.dust(MT.NaOH				,U * 3), MT.HCl			.fluid(U * 2, T)															, MT.SaltWater		.liquid(U* 4, F), OM.dust(MT.NaCl, U*1));
		RM.Mixer		.addRecipe1(T, 16,  144, OM.dust(MT.NaOH				,U * 6), MT.SO2			.gas  (U * 3, T)															, MT.H2O			.liquid(U* 3, F), OM.dust(MT.Na2SO3, U*6));
		RM.Mixer		.addRecipe1(T, 16,  128, OM.dust(MT.KOH					,U * 3), MT.HNO3		.liquid(U* 5, T)															, MT.H2O			.liquid(U* 3, F), OM.dust(MT.KNO3, U*5));
		RM.Mixer		.addRecipe1(T, 16,  128, OM.dust(MT.NaOH				,U * 3), MT.HNO3		.liquid(U* 5, T)															, MT.H2O			.liquid(U* 3, F), OM.dust(MT.NaNO3, U*5));
		RM.Mixer		.addRecipe1(T, 16,  144, OM.dust(MT.KOH					,U * 6), MT.CO2			.gas  (U * 3, T)															, MT.H2O			.liquid(U* 3, F), OM.dust(MT.K2CO3, U*6));
		RM.Mixer		.addRecipe1(T, 16,  144, OM.dust(MT.NaOH				,U * 6), MT.CO2			.gas  (U * 3, T)															, MT.H2O			.liquid(U* 3, F), OM.dust(MT.Na2CO3, U*6));
		RM.Mixer		.addRecipe1(T, 16,  144, OM.dust(MT.KOH					,U * 6), MT.H2S			.gas  (U * 3, T)															, MT.H2O			.liquid(U* 6, F), OM.dust(MT.K2S, U*3));
		RM.Mixer		.addRecipe1(T, 16,  144, OM.dust(MT.NaOH				,U * 6), MT.H2S			.gas  (U * 3, T)															, MT.H2O			.liquid(U* 6, F), OM.dust(MT.Na2S, U*3));
		RM.Mixer		.addRecipe1(T, 16,  192, OM.dust(MT.KNO3				,U * 5), MT.H2SO4		.fluid(U * 7, T)															, MT.HNO3			.liquid(U* 5, F), OM.dust(MT.KHSO4, U*7));
		RM.Mixer		.addRecipe1(T, 16,  192, OM.dust(MT.NaNO3				,U * 5), MT.H2SO4		.fluid(U * 7, T)															, MT.HNO3			.liquid(U* 5, F), OM.dust(MT.NaHSO4, U*7));
		RM.Mixer		.addRecipe1(T, 16,  144, OM.dust(MT.KCl					,U * 2), MT.H2SO4		.fluid(U * 7, T)															, MT.HCl			.fluid(U * 2, F), OM.dust(MT.KHSO4, U*7));
		RM.Mixer		.addRecipe1(T, 16,  144, OM.dust(MT.NaCl				,U * 2), MT.H2SO4		.fluid(U * 7, T)															, MT.HCl			.fluid(U * 2, F), OM.dust(MT.NaHSO4, U*7));
		RM.Mixer		.addRecipe1(T, 16,   32, OM.dust(MT.K2SO4				,U * 1), MT.H2SO4		.fluid(U * 1, T)															, NF								, OM.dust(MT.KHSO4, U*2));
		RM.Mixer		.addRecipe1(T, 16,   32, OM.dust(MT.Na2SO4				,U * 1), MT.H2SO4		.fluid(U * 1, T)															, NF								, OM.dust(MT.NaHSO4, U*2));
		RM.Mixer		.addRecipe1(T, 16,  304, OM.dust(MT.K2S					,U * 3), MT.H2O2		.fluid(U *16, T)															, MT.H2O			.liquid(U*12, F), OM.dust(MT.K2SO4, U*7));
		RM.Mixer		.addRecipe1(T, 16,  304, OM.dust(MT.Na2S				,U * 3), MT.H2O2		.fluid(U *16, T)															, MT.H2O			.liquid(U*12, F), OM.dust(MT.Na2SO4, U*7));
		RM.Mixer		.addRecipe1(T, 16,  176, OM.dust(MT.NaCl				,U * 3), new FluidStack[] {MT.SO2.gas(U*3, T), MT.O.gas(U*1, T), MT.SaltWater.liquid(U*4, T)}		, MT.HCl			.fluid(U * 4, F), OM.dust(MT.Na2SO4, U*7));
		RM.Mixer		.addRecipe0(T, 16,  800, new FluidStack[] {MT.Glycerol.fluid(U*14, T), MT.HNO3.liquid(U*15, T), MT.H2SO4.fluid(U*21, T)}									, MT.Glyceryl		.fluid(U *20, F), MT.SO2.gas(U*6, F)); // + 18 Units of Water + 1 Unit of Oxygen
		RM.Mixer		.addRecipe0(T, 16,   48, new FluidStack[] {MT.NO.gas(U*2, T), MT.O.gas(U, T)}																				, MT.NO2			.gas  (U * 3, F), ZL_IS);
		RM.Mixer		.addRecipe0(T, 16,   32, new FluidStack[] {MT.H.gas(U, T), MT.F.gas(U, T)}																					, MT.HF				.gas  (U * 2, F), ZL_IS);
		RM.Mixer		.addRecipe0(T, 16,   24, new FluidStack[] {MT.H.gas(U, T), MT.S.liquid(U2, T)}																				, MT.H2S			.gas  (U2* 3, F), ZL_IS);
		RM.Mixer		.addRecipe0(T, 16,  160, new FluidStack[] {MT.NO2.gas(U*6, T), MT.H2O2.fluid(U*4, T)}																		, MT.HNO3			.liquid(U*10, F), ZL_IS);
		RM.HeatMixer	.addRecipe0(T, 16,   48, new FluidStack[] {MT.H2S.gas(U*2, T), MT.SO2.gas(U*1, T)}																			, MT.H2O			.liquid(U* 2, F), OM.dust(MT.S, U));
		RM.Mixer		.addRecipe2(T, 16,   48, OP.dust.mat(MT.Na, 2), OP.dust.mat(MT.S, 1), OP.dust.mat(MT.Na2S, 3));
		RM.Mixer		.addRecipe2(T, 16,   48, OP.dust.mat(MT.K , 2), OP.dust.mat(MT.S, 1), OP.dust.mat(MT.K2S , 3));
		for (OreDictMaterial tMat : ANY.SiO2.mToThis) {ItemStack tSiliconDioxide = OM.dust(tMat, U*3); if (ST.invalid(tSiliconDioxide)) continue;
		RM.HeatMixer	.addRecipe2(T, 16,  144, tSiliconDioxide, OP.dust.mat(MT.CaSO4, 6), NF, MT.SO3.gas(U*4, F), OM.dust(MT.OREMATS.Wollastonite, U*5));
		}
		for (OreDictMaterial tMat : ANY.Fe.mToThis) {ItemStack tIron = OM.dust(tMat); if (ST.invalid(tIron)) continue;
		RM.Mixer		.addRecipe1(T, 16,   64, tIron								, MT.Cl				.gas  (U * 3, T)															, NF								, OM.dust(MT.FeCl3, U*4));
		RM.Mixer		.addRecipe1(T, 16,   80, tIron								, MT.HCl			.fluid(U * 4, T)															, MT.H				.gas  (U * 2, F), OM.dust(MT.FeCl2, U*3));
		}
		
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(MT.NaCl				,U * 4), MT.CaCO3		.liquid(U* 5, T)															, NF								, OM.dust(MT.CaCl2, U*3), OM.dust(MT.Na2CO3, U*6));
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(MT.NaCl				,U * 4), MT.MgCO3		.liquid(U* 5, T)															, NF								, OM.dust(MT.MgCl2, U*3), OM.dust(MT.Na2CO3, U*6));
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(MT.OREMATS.Scheelite	,U * 6), MT.HCl			.fluid(U * 4, T)															, NF								, OM.dust(MT.CaCl2, U*3), OM.dust(MT.H2WO4, U*7));
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(MT.OREMATS.Wolframite	,U * 6), MT.HCl			.fluid(U * 4, T)															, NF								, OM.dust(MT.MgCl2, U*3), OM.dust(MT.H2WO4, U*7));
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(MT.OREMATS.Ferberite	,U * 6), MT.HCl			.fluid(U * 4, T)															, NF								, OM.dust(MT.FeCl2, U*3), OM.dust(MT.H2WO4, U*7));
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(MT.OREMATS.Huebnerite	,U * 6), MT.HCl			.fluid(U * 4, T)															, NF								, OM.dust(MT.MnCl2, U*3), OM.dust(MT.H2WO4, U*7));
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(MT.OREMATS.Tungstate	,U * 7), MT.HCl			.fluid(U * 2, T)															, NF								, OM.dust(MT.LiCl , U*2), OM.dust(MT.H2WO4, U*7));
		
		
		RM.Mixer		.addRecipe1(T, 16,   16, OP.dust.mat(MT.Pt		, 0), new FluidStack[] {MT.SO2.gas(3*U4, T), MT.O.gas(U4, T)}, new FluidStack[] {MT.SO3.gas(U, F)}, ZL_IS);
		RM.Mixer		.addRecipe1(T, 16,   16, OP.dust.mat(MT.V2O5	, 0), new FluidStack[] {MT.SO2.gas(3*U4, T), MT.O.gas(U4, T)}, new FluidStack[] {MT.SO3.gas(U, F)}, ZL_IS);
		for (String tFluid : FluidsGT.AIR) if (UT.Fluids.exists(tFluid)) {
		RM.Mixer		.addRecipe1(T, 16,   16, OP.dust.mat(MT.Pt		, 0), new FluidStack[] {MT.SO2.gas(3*U4, T), UT.Fluids.make(tFluid, 1000)}, new FluidStack[] {MT.SO3.gas(U, F)}, ZL_IS);
		RM.Mixer		.addRecipe1(T, 16,   16, OP.dust.mat(MT.V2O5	, 0), new FluidStack[] {MT.SO2.gas(3*U4, T), UT.Fluids.make(tFluid, 1000)}, new FluidStack[] {MT.SO3.gas(U, F)}, ZL_IS);
		}
		
		for (OreDictMaterial tMat : ANY.Coal.mToThis) {
		RM.BurnMixer	.addRecipe2(T, 16,  144, OM.dust(MT.Na2SO4				,U * 7), OM.dust(tMat,U * 2), NF																	, MT.CO2			.gas  (U * 6, F), OM.dust(MT.Na2S, U*3));
		RM.BurnMixer	.addRecipe2(T, 16,  144, OM.dust(MT.K2SO4				,U * 7), OM.dust(tMat,U * 2), NF																	, MT.CO2			.gas  (U * 6, F), OM.dust(MT.K2S, U*3));
		RM.BurnMixer	.addRecipe1(T, 16,  128, OM.dust(tMat					,U * 2), MT.Na2CO3.liquid(U*6, T)																	, MT.CO				.gas  (U * 6, F), OM.dust(MT.Na, U*2));
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(tMat					,U * 3), MT.HNO3.liquid(20*U, T)																	, MT.CO2			.gas  (U * 9, F), MT.NO.gas(U * 8, T), MT.H2O.fluid(U * 6, F));
		}
		
		RM.BurnMixer	.addRecipe0(T, 16,   24, new FluidStack[] {MT.H.gas(U, T), MT.O.gas(U2, T)}																					, FL.DistW.make(1500)				, ZL_IS);
		
		
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.TiO2			, U   ), OM.dust(MT.C		,   U ), new FluidStack[] {MT.Cl.gas(U* 4, T), MT.CaCO3.liquid(U  , T)}, new FluidStack[] {MT.TiCl4.liquid(U* 5, F), MT.CO2.gas(U* 3, F)}, ZL_IS);
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.TiO2			, U* 2), OM.dust(MT.C		, 2*U ), new FluidStack[] {MT.Cl.gas(U* 8, T), MT.CaCO3.liquid(U*2, T)}, new FluidStack[] {MT.TiCl4.liquid(U*10, F), MT.CO2.gas(U* 6, F)}, ZL_IS);
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.OREMATS.Ilmenite, U* 5), OM.dust(MT.C		, 3*U ), new FluidStack[] {MT.Cl.gas(U* 7, T), MT.CaCO3.liquid(U  , T)}, new FluidStack[] {MT.TiCl4.liquid(U* 5, F), MT.CO .gas(U* 6, F)}, OM.dust(MT.FeCl3, U*4));
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.OREMATS.Ilmenite, U*10), OM.dust(MT.C		, 6*U ), new FluidStack[] {MT.Cl.gas(U*14, T), MT.CaCO3.liquid(U*2, T)}, new FluidStack[] {MT.TiCl4.liquid(U*10, F), MT.CO .gas(U*12, F)}, OM.dust(MT.FeCl3, U*8));
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.TiO2			, U   ), OM.dust(MT.Graphite,   U ), new FluidStack[] {MT.Cl.gas(U* 4, T), MT.CaCO3.liquid(U  , T)}, new FluidStack[] {MT.TiCl4.liquid(U* 5, F), MT.CO2.gas(U* 3, F)}, ZL_IS);
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.TiO2			, U* 2), OM.dust(MT.Graphite, 2*U ), new FluidStack[] {MT.Cl.gas(U* 8, T), MT.CaCO3.liquid(U*2, T)}, new FluidStack[] {MT.TiCl4.liquid(U*10, F), MT.CO2.gas(U* 6, F)}, ZL_IS);
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.OREMATS.Ilmenite, U* 5), OM.dust(MT.Graphite, 3*U ), new FluidStack[] {MT.Cl.gas(U* 7, T), MT.CaCO3.liquid(U  , T)}, new FluidStack[] {MT.TiCl4.liquid(U* 5, F), MT.CO .gas(U* 6, F)}, OM.dust(MT.FeCl3, U*4));
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.OREMATS.Ilmenite, U*10), OM.dust(MT.Graphite, 6*U ), new FluidStack[] {MT.Cl.gas(U*14, T), MT.CaCO3.liquid(U*2, T)}, new FluidStack[] {MT.TiCl4.liquid(U*10, F), MT.CO .gas(U*12, F)}, OM.dust(MT.FeCl3, U*8));
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.TiO2			, U   ), OM.dust(MT.CoalCoke,   U2), new FluidStack[] {MT.Cl.gas(U* 4, T), MT.CaCO3.liquid(U  , T)}, new FluidStack[] {MT.TiCl4.liquid(U* 5, F), MT.CO2.gas(U* 3, F)}, ZL_IS);
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.TiO2			, U* 2), OM.dust(MT.CoalCoke,   U ), new FluidStack[] {MT.Cl.gas(U* 8, T), MT.CaCO3.liquid(U*2, T)}, new FluidStack[] {MT.TiCl4.liquid(U*10, F), MT.CO2.gas(U* 6, F)}, ZL_IS);
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.OREMATS.Ilmenite, U* 5), OM.dust(MT.CoalCoke, 3*U2), new FluidStack[] {MT.Cl.gas(U* 7, T), MT.CaCO3.liquid(U  , T)}, new FluidStack[] {MT.TiCl4.liquid(U* 5, F), MT.CO .gas(U* 6, F)}, OM.dust(MT.FeCl3, U*4));
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.OREMATS.Ilmenite, U*10), OM.dust(MT.CoalCoke, 3*U ), new FluidStack[] {MT.Cl.gas(U*14, T), MT.CaCO3.liquid(U*2, T)}, new FluidStack[] {MT.TiCl4.liquid(U*10, F), MT.CO .gas(U*12, F)}, OM.dust(MT.FeCl3, U*8));
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.TiO2			, U   ), OM.dust(MT.PetCoke ,   U2), new FluidStack[] {MT.Cl.gas(U* 4, T), MT.CaCO3.liquid(U  , T)}, new FluidStack[] {MT.TiCl4.liquid(U* 5, F), MT.CO2.gas(U* 3, F)}, ZL_IS);
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.TiO2			, U* 2), OM.dust(MT.PetCoke ,   U ), new FluidStack[] {MT.Cl.gas(U* 8, T), MT.CaCO3.liquid(U*2, T)}, new FluidStack[] {MT.TiCl4.liquid(U*10, F), MT.CO2.gas(U* 6, F)}, ZL_IS);
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.OREMATS.Ilmenite, U* 5), OM.dust(MT.PetCoke , 3*U2), new FluidStack[] {MT.Cl.gas(U* 7, T), MT.CaCO3.liquid(U  , T)}, new FluidStack[] {MT.TiCl4.liquid(U* 5, F), MT.CO .gas(U* 6, F)}, OM.dust(MT.FeCl3, U*4));
		RM.BurnMixer	.addRecipe2(T, 16,  256, OM.dust(MT.OREMATS.Ilmenite, U*10), OM.dust(MT.PetCoke , 3*U ), new FluidStack[] {MT.Cl.gas(U*14, T), MT.CaCO3.liquid(U*2, T)}, new FluidStack[] {MT.TiCl4.liquid(U*10, F), MT.CO .gas(U*12, F)}, OM.dust(MT.FeCl3, U*8));
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(MT.OREMATS.Ilmenite, U*5), new FluidStack[] {MT.H2SO4.liquid(7*U, T)}, new FluidStack[] {MT.GreenVitriol.liquid(6*U, T), FL.Water.make(3000)}, OM.dust(MT.TiO2));
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(MT.Na, U*4), MT.TiCl4.liquid(5*U, T), NF, OM.dust(MT.Ti), OM.dust(MT.NaCl , U*8));
		RM.Bath			.addRecipe1(T, 0,   512, OM.dust(MT.Mg, U*2), MT.TiCl4.liquid(5*U, T), NF, OM.dust(MT.Ti), OM.dust(MT.MgCl2, U*6));
		
		
		RM.Mixer		.addRecipe0(T, 16,   16, new FluidStack[] {MT.Fuel.liquid(2*U5, T), MT.Glyceryl.fluid(U10, T)}																, MT.NitroFuel		.liquid(U2, F), ZL_IS);
		RM.Mixer		.addRecipe0(T, 16,   16, new FluidStack[] {MT.He.gas(U200, T), MT.Ne.gas(U200, T)}																			, MT.HeNe			.gas(U100, F), ZL_IS);
		RM.Mixer		.addRecipe0(T, 16,   64, new FluidStack[] {MT.HNO3.liquid(U*5, T), MT.HCl.fluid(U*8, T)}																	, MT.AquaRegia		.fluid(U*13, F), ZL_IS);
		
		
		RM.Autoclave	.addRecipe2(T,  0, 1500, new long[] {10000, 5000, 5000}, OP.dust		.mat(MT.OREMATS.Bauxite, 1), OP.dustSmall	.mat(MT.KOH , 6), FL.Steam.make(48000), FL.Water.make(3225), OP.dust.mat(MT.KAlO2 , 2), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 2), OP.crushedCentrifugedTiny.mat(MT.TiO2, 1));
		RM.Autoclave	.addRecipe2(T,  0, 1500, new long[] {10000, 5000, 5000}, OP.dustSmall	.mat(MT.OREMATS.Bauxite, 4), OP.dustSmall	.mat(MT.KOH , 6), FL.Steam.make(48000), FL.Water.make(3225), OP.dust.mat(MT.KAlO2 , 2), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 2), OP.crushedCentrifugedTiny.mat(MT.TiO2, 1));
		RM.Autoclave	.addRecipe2(T,  0, 1500, new long[] {10000, 5000, 5000}, OP.dustTiny	.mat(MT.OREMATS.Bauxite, 9), OP.dustSmall	.mat(MT.KOH , 6), FL.Steam.make(48000), FL.Water.make(3225), OP.dust.mat(MT.KAlO2 , 2), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 2), OP.crushedCentrifugedTiny.mat(MT.TiO2, 1));
		RM.Autoclave	.addRecipe2(T,  0, 3000, new long[] {10000, 5000, 5000}, OP.dust		.mat(MT.OREMATS.Bauxite, 2), OP.dust		.mat(MT.KOH , 3), FL.Steam.make(96000), FL.Water.make(6450), OP.dust.mat(MT.KAlO2 , 4), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 4), OP.crushedCentrifugedTiny.mat(MT.TiO2, 2));
		RM.Autoclave	.addRecipe2(T,  0, 3000, new long[] {10000, 5000, 5000}, OP.dustSmall	.mat(MT.OREMATS.Bauxite, 8), OP.dust		.mat(MT.KOH , 3), FL.Steam.make(96000), FL.Water.make(6450), OP.dust.mat(MT.KAlO2 , 4), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 4), OP.crushedCentrifugedTiny.mat(MT.TiO2, 2));
		RM.Autoclave	.addRecipe2(T,  0, 3000, new long[] {10000, 5000, 5000}, OP.dustTiny	.mat(MT.OREMATS.Bauxite,18), OP.dust		.mat(MT.KOH , 3), FL.Steam.make(96000), FL.Water.make(6450), OP.dust.mat(MT.KAlO2 , 4), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 4), OP.crushedCentrifugedTiny.mat(MT.TiO2, 2));
		RM.Autoclave	.addRecipe2(T,  0, 1500, new long[] {10000, 5000, 5000}, OP.dust		.mat(MT.OREMATS.Bauxite, 1), OP.dustSmall	.mat(MT.NaOH, 6), FL.Steam.make(48000), FL.Water.make(3225), OP.dust.mat(MT.NaAlO2, 2), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 2), OP.crushedCentrifugedTiny.mat(MT.TiO2, 1));
		RM.Autoclave	.addRecipe2(T,  0, 1500, new long[] {10000, 5000, 5000}, OP.dustSmall	.mat(MT.OREMATS.Bauxite, 4), OP.dustSmall	.mat(MT.NaOH, 6), FL.Steam.make(48000), FL.Water.make(3225), OP.dust.mat(MT.NaAlO2, 2), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 2), OP.crushedCentrifugedTiny.mat(MT.TiO2, 1));
		RM.Autoclave	.addRecipe2(T,  0, 1500, new long[] {10000, 5000, 5000}, OP.dustTiny	.mat(MT.OREMATS.Bauxite, 9), OP.dustSmall	.mat(MT.NaOH, 6), FL.Steam.make(48000), FL.Water.make(3225), OP.dust.mat(MT.NaAlO2, 2), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 2), OP.crushedCentrifugedTiny.mat(MT.TiO2, 1));
		RM.Autoclave	.addRecipe2(T,  0, 3000, new long[] {10000, 5000, 5000}, OP.dust		.mat(MT.OREMATS.Bauxite, 2), OP.dust		.mat(MT.NaOH, 3), FL.Steam.make(96000), FL.Water.make(6450), OP.dust.mat(MT.NaAlO2, 4), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 4), OP.crushedCentrifugedTiny.mat(MT.TiO2, 2));
		RM.Autoclave	.addRecipe2(T,  0, 3000, new long[] {10000, 5000, 5000}, OP.dustSmall	.mat(MT.OREMATS.Bauxite, 8), OP.dust		.mat(MT.NaOH, 3), FL.Steam.make(96000), FL.Water.make(6450), OP.dust.mat(MT.NaAlO2, 4), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 4), OP.crushedCentrifugedTiny.mat(MT.TiO2, 2));
		RM.Autoclave	.addRecipe2(T,  0, 3000, new long[] {10000, 5000, 5000}, OP.dustTiny	.mat(MT.OREMATS.Bauxite,18), OP.dust		.mat(MT.NaOH, 3), FL.Steam.make(96000), FL.Water.make(6450), OP.dust.mat(MT.NaAlO2, 4), OP.crushedCentrifugedTiny.mat(MT.OREMATS.Ilmenite, 4), OP.crushedCentrifugedTiny.mat(MT.TiO2, 2));
		
		
		RM.Lightning	.addRecipe0(T,256,   16, new FluidStack[] {MT.N.gas(U100, T), MT.O.gas(U100, T)}, MT.NO.gas(U100 * 2, F), ZL_IS);
		
		
		// C12H22O11 + 6 KNO3 -> 9 CO + 3 N2 + 11 H2O + 3 K2CO3 ; (Rocket Candy)
		
		for (OreDictMaterial tMat : ANY.Coal.mToThis) {
		RM.Electrolyzer	.addRecipe2(T, 16, 6144, OP.blockDust	.mat(tMat, 1), OP.dust		.mat(MT.Al2O3, 30), new FluidStack[] {MT.Na3AlF6.liquid(U24 , T), MT.AlF3.liquid(U12, T)}, new FluidStack[] {MT.CO2.gas(U *27, F), MT.F.gas(7*U80 , F)}, OM.dust(MT.Al, U *12));
		RM.Electrolyzer	.addRecipe2(T, 16, 6144, OP.blockDust	.mat(tMat, 1), OP.ingot		.mat(MT.Al2O3, 30), new FluidStack[] {MT.Na3AlF6.liquid(U24 , T), MT.AlF3.liquid(U12, T)}, new FluidStack[] {MT.CO2.gas(U *27, F), MT.F.gas(7*U80 , F)}, OM.dust(MT.Al, U *12));
		RM.Electrolyzer	.addRecipe2(T, 16, 2048, OP.dust		.mat(tMat, 3), OP.dust		.mat(MT.Al2O3, 10), new FluidStack[] {MT.Na3AlF6.liquid(U72 , T), MT.AlF3.liquid(U36, T)}, new FluidStack[] {MT.CO2.gas(U * 9, F), MT.F.gas(7*U240, F)}, OM.dust(MT.Al, U * 4));
		RM.Electrolyzer	.addRecipe2(T, 16, 2048, OP.dust		.mat(tMat, 3), OP.ingot		.mat(MT.Al2O3, 10), new FluidStack[] {MT.Na3AlF6.liquid(U72 , T), MT.AlF3.liquid(U36, T)}, new FluidStack[] {MT.CO2.gas(U * 9, F), MT.F.gas(7*U240, F)}, OM.dust(MT.Al, U * 4));
		RM.Electrolyzer	.addRecipe2(T, 16, 2048, OP.dustTiny	.mat(tMat,27), OP.dust		.mat(MT.Al2O3, 10), new FluidStack[] {MT.Na3AlF6.liquid(U72 , T), MT.AlF3.liquid(U36, T)}, new FluidStack[] {MT.CO2.gas(U * 9, F), MT.F.gas(7*U240, F)}, OM.dust(MT.Al, U * 4));
		RM.Electrolyzer	.addRecipe2(T, 16, 2048, OP.dustTiny	.mat(tMat,27), OP.ingot		.mat(MT.Al2O3, 10), new FluidStack[] {MT.Na3AlF6.liquid(U72 , T), MT.AlF3.liquid(U36, T)}, new FluidStack[] {MT.CO2.gas(U * 9, F), MT.F.gas(7*U240, F)}, OM.dust(MT.Al, U * 4));
		RM.Electrolyzer	.addRecipe2(T, 16, 1024, OP.dustSmall	.mat(tMat, 6), OP.dust		.mat(MT.Al2O3,  5), new FluidStack[] {MT.Na3AlF6.liquid(U144, T), MT.AlF3.liquid(U72, T)}, new FluidStack[] {MT.CO2.gas(U2* 9, F), MT.F.gas(7*U480, F)}, OM.dust(MT.Al, U * 2));
		RM.Electrolyzer	.addRecipe2(T, 16, 1024, OP.dustSmall	.mat(tMat, 6), OP.ingot		.mat(MT.Al2O3,  5), new FluidStack[] {MT.Na3AlF6.liquid(U144, T), MT.AlF3.liquid(U72, T)}, new FluidStack[] {MT.CO2.gas(U2* 9, F), MT.F.gas(7*U480, F)}, OM.dust(MT.Al, U * 2));
		}
		RM.Electrolyzer	.addRecipe2(T, 16,  512, ST.tag(0), OM.dust(MT.NaHSO4, U*7), NF, MT.H.gas(U, T), OM.dust(MT.NaSO4, U*6));
		RM.Electrolyzer	.addRecipe2(T, 16,  512, ST.tag(0), OM.dust(MT.KHSO4 , U*7), NF, MT.H.gas(U, T), OM.dust(MT.KSO4 , U*6));
		
		RM.Electrolyzer	.addRecipe1(T, 16,  256, ST.tag(1), new FluidStack[] {MT.LiClO3.liquid(U*5, T), MT.O.gas(U, T)}, NF, OM.dust(MT.LiClO4, U*6));
		
		RM.Electrolyzer	.addRecipe1(T, 16, 3840, ST.tag(0), new FluidStack[] {FL.Water.make(3000)		}, new FluidStack[] {MT.H.gas(U*2, F), MT.O.gas(U, F)});
		RM.Electrolyzer	.addRecipe1(T, 16, 3840, ST.tag(0), new FluidStack[] {FL.DistW.make(3000)		}, new FluidStack[] {MT.H.gas(U*2, F), MT.O.gas(U, F)});
		if (FL.OceanGrC.exists())
		RM.Electrolyzer	.addRecipe1(T, 16,20480, ST.tag(0), new FluidStack[] {FL.OceanGrC.make(16000)	}, new FluidStack[] {MT.Cl.gas(U4, F), MT.H.gas(83*U8, F), MT.O.gas(41*U8, F)}, OM.dust(MT.NaOH, 3*U8));
		RM.Electrolyzer	.addRecipe1(T, 16,20480, ST.tag(0), new FluidStack[] {FL.Ocean.make(16000)		}, new FluidStack[] {MT.Cl.gas(U4, F), MT.H.gas(83*U8, F), MT.O.gas(41*U8, F)}, OM.dust(MT.NaOH, 3*U8));
		RM.Electrolyzer	.addRecipe1(T, 16, 1280, ST.tag(0), new FluidStack[] {MT.SaltWater.liquid(U, T)	}, new FluidStack[] {MT.Cl.gas(U8, F), MT.H.gas( 3*U8, F), MT.O.gas(   U8, F)}, OM.dust(MT.NaOH, 3*U8));
		
		
		
		
		
		
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.Pyrite					), MT.O.gas( 4*U3 , T), MT.SO2.gas( 6*U3 , F)	, OM.dust(MT.Fe,   U3 ));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Sphalerite		), MT.O.gas( 2*U2 , T), MT.SO2.gas( 3*U2 , F)	, OM.dust(MT.Zn,   U2 ));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Molybdenite		), MT.O.gas( 4*U3 , T), MT.SO2.gas( 6*U3 , F)	, OM.dust(MT.Mo,   U3 ));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Stibnite		), MT.O.gas( 6*U5 , T), MT.SO2.gas( 9*U5 , F)	, OM.dust(MT.Sb, 2*U5 ));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Pentlandite		), MT.O.gas(16*U17, T), MT.SO2.gas(24*U17, F)	, OM.dust(MT.Ni, 9*U17));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Chalcopyrite	), MT.O.gas( 4*U4 , T), MT.SO2.gas( 6*U4 , F)	, OM.dust(MT.Fe,   U4 ), OM.dust(MT.Cu,   U4));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Arsenopyrite	), MT.O.gas( 2*U3 , T), MT.SO2.gas( 3*U3 , F)	, OM.dust(MT.Fe,   U3 ), OM.dust(MT.As,   U3));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Cobaltite		), MT.O.gas( 2*U3 , T), MT.SO2.gas( 3*U3 , F)	, OM.dust(MT.Co,   U3 ), OM.dust(MT.As,   U3));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Galena			), MT.O.gas( 4*U8 , T), MT.SO2.gas( 6*U8 , F)	, OM.dust(MT.Ag, 3*U8 ), OM.dust(MT.Pb, 3*U8));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Cooperite		), MT.O.gas( 2*U6 , T), MT.SO2.gas( 3*U6 , F)	, OM.dust(MT.Pt, 3*U6 ), OM.dust(MT.Ni, 1*U6), OM.dust(MT.Pd, 1*U6));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Tetrahedrite	), MT.O.gas( 6*U8 , T), MT.SO2.gas( 9*U8 , F)	, OM.dust(MT.Cu, 3*U8 ), OM.dust(MT.Sb, 1*U8), OM.dust(MT.Fe, 1*U8));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Stannite		), MT.O.gas( 8*U8 , T), MT.SO2.gas(12*U8 , F)	, OM.dust(MT.Cu, 2*U8 ), OM.dust(MT.Fe, 1*U8), OM.dust(MT.Sn, 1*U8));
		RM.Roasting		.addRecipe1(T, 16,  512, OM.dust(MT.OREMATS.Kesterite		), MT.O.gas( 8*U8 , T), MT.SO2.gas(12*U8 , F)	, OM.dust(MT.Cu, 2*U8 ), OM.dust(MT.Zn, 1*U8), OM.dust(MT.Sn, 1*U8));
		
		RM.Roasting		.addRecipe1(T, 16,  128, OM.dust(MT.Li						), MT.O.gas(   U2 , T), NF						, OM.dust(MT.Li2O, 3*U2));
		RM.Roasting		.addRecipe1(T, 16,  128, OM.dust(MT.V						), MT.O.gas( 5*U2 , T), NF						, OM.dust(MT.V2O5, 7*U2));
		RM.Roasting		.addRecipe1(T, 16,  128, OM.dust(MT.Cr						), MT.O.gas( 2*U  , T), NF						, OM.dust(MT.CrO2,   U ));
		RM.Roasting		.addRecipe1(T, 16,   16, OM.dust(MT.S						), MT.O.gas( 2*U  , T), MT.SO2.gas( 3*U  , F)	, ZL_IS);
		for (OreDictMaterial tMat : ANY.C.mToThis)
		RM.Roasting		.addRecipe1(T, 16,   16, OM.dust(tMat						), MT.O.gas( 2*U  , T), MT.CO2.gas( 3*U  , F)	, ZL_IS);
		RM.Roasting		.addRecipe1(T, 16,   16, OM.dust(MT.Charcoal				), MT.O.gas( 2*U  , T), MT.CO2.gas( 3*U  , F)	, ZL_IS);
		RM.Roasting		.addRecipe1(T, 16,   16, OM.dust(MT.Coal					), MT.O.gas( 4*U  , T), MT.CO2.gas( 6*U  , F)	, ZL_IS);
		RM.Roasting		.addRecipe1(T, 16,   16, OM.dust(MT.CoalCoke				), MT.O.gas( 4*U  , T), MT.CO2.gas( 6*U  , F)	, ZL_IS);
		RM.Roasting		.addRecipe1(T, 16,   16, OM.dust(MT.Diamond					), MT.O.gas( 8*U  , T), MT.CO2.gas(12*U  , F)	, ZL_IS);
		
		final long[] tChances = new long[] {8000, 8000, 8000};
		
		for (String tFluid : FluidsGT.AIR) if (UT.Fluids.exists(tFluid)) {
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.Pyrite				), UT.Fluids.make(tFluid, 6000), MT.SO2.gas( 6*U3 , F)	, OM.dust(MT.Fe,   U3 ));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Sphalerite	), UT.Fluids.make(tFluid, 4000), MT.SO2.gas( 3*U2 , F)	, OM.dust(MT.Zn,   U2 ));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Molybdenite	), UT.Fluids.make(tFluid, 6000), MT.SO2.gas( 6*U3 , F)	, OM.dust(MT.Mo,   U3 ));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Stibnite		), UT.Fluids.make(tFluid, 5000), MT.SO2.gas( 9*U5 , F)	, OM.dust(MT.Sb, 2*U5 ));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Pentlandite	), UT.Fluids.make(tFluid, 8000), MT.SO2.gas(24*U17, F)	, OM.dust(MT.Ni, 9*U17));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Chalcopyrite	), UT.Fluids.make(tFluid, 4000), MT.SO2.gas( 6*U4 , F)	, OM.dust(MT.Fe,   U4 ), OM.dust(MT.Cu,   U4));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Arsenopyrite	), UT.Fluids.make(tFluid, 3000), MT.SO2.gas( 3*U3 , F)	, OM.dust(MT.Fe,   U3 ), OM.dust(MT.As,   U3));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Cobaltite		), UT.Fluids.make(tFluid, 3000), MT.SO2.gas( 3*U3 , F)	, OM.dust(MT.Co,   U3 ), OM.dust(MT.As,   U3));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Galena		), UT.Fluids.make(tFluid, 2000), MT.SO2.gas( 6*U8 , F)	, OM.dust(MT.Ag, 3*U8 ), OM.dust(MT.Pb, 3*U8));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Cooperite		), UT.Fluids.make(tFluid, 2000), MT.SO2.gas( 3*U6 , F)	, OM.dust(MT.Pt, 3*U6 ), OM.dust(MT.Ni, 1*U6), OM.dust(MT.Pd, 1*U6));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Tetrahedrite	), UT.Fluids.make(tFluid, 3000), MT.SO2.gas( 9*U8 , F)	, OM.dust(MT.Cu, 3*U8 ), OM.dust(MT.Sb, 1*U8), OM.dust(MT.Fe, 1*U8));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Stannite		), UT.Fluids.make(tFluid, 4000), MT.SO2.gas(12*U8 , F)	, OM.dust(MT.Cu, 2*U8 ), OM.dust(MT.Fe, 1*U8), OM.dust(MT.Sn, 1*U8));
		RM.Roasting		.addRecipe1(T, 16,  512, tChances, OM.dust(MT.OREMATS.Kesterite		), UT.Fluids.make(tFluid, 4000), MT.SO2.gas(12*U8 , F)	, OM.dust(MT.Cu, 2*U8 ), OM.dust(MT.Zn, 1*U8), OM.dust(MT.Sn, 1*U8));
		RM.Roasting		.addRecipe1(T, 16,   16, OM.dust(MT.S), UT.Fluids.make(tFluid, 8000), MT.SO2.gas(3*U, F), ZL_IS);
		}
		
		
		
		
		RM.Freezer		.addRecipe1(T, 16,  256, ST.tag(0), MT.O.gas(U, T), MT.O.liquid(U, T), ZL_IS);
		
		RM.Drying		.addRecipe0(T, 16,   16, FL.Water.make(10), FL.DistW.make(8), ZL_IS);
		RM.Distillery	.addRecipe1(T, 16,   16, ST.tag(0), FL.Water.make(10), FL.DistW.make(8), ZL_IS);
		
		if (FL.OceanGrC.exists())
		RM.Drying		.addRecipe0(T, 16,12800, FL.OceanGrC.make(8000)			, FL.DistW.make(7750), OM.dust(MT.NaCl, U4));
		RM.Drying		.addRecipe0(T, 16,12800, FL.Ocean.make(8000)			, FL.DistW.make(7750), OM.dust(MT.NaCl, U4));
		RM.Drying		.addRecipe0(T, 16, 1600, MT.SaltWater.liquid(U, T)		, FL.DistW.make( 750), OM.dust(MT.NaCl, U4));
		RM.Drying		.addRecipe0(T, 16,16000, FL.Dirty_Water.make(8000)		, FL.DistW.make(7000), ST.make(Blocks.dirt, 1, 0));
		if (FL.Swampwater.exists())
		RM.Drying		.addRecipe0(T, 16,   16, FL.Swampwater.make(10)			, FL.DistW.make(5), ZL_IS);
		if (FL.Stagnant_Water.exists())
		RM.Drying		.addRecipe0(T, 16,   16, FL.Stagnant_Water.make(10)		, FL.DistW.make(5), ZL_IS);
		
		RM.Drying		.addRecipe1(T, 16, 6000, OP.dust.mat(MT.H2WO4, 7),NF, FL.DistW.make(3000), OP.dust.mat(MT.WO3, 4));
	}
}