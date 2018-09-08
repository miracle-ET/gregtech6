package gregtech.tileentity.misc;

import static gregapi.data.CS.*;

import gregapi.block.multitileentity.IMultiTileEntity.IMTE_GetBlockHardness;
import gregapi.block.multitileentity.IMultiTileEntity.IMTE_GetExplosionResistance;
import gregapi.block.multitileentity.IMultiTileEntity.IMTE_GetLightOpacity;
import gregapi.block.multitileentity.IMultiTileEntity.IMTE_IsSideSolid;
import gregapi.block.multitileentity.IMultiTileEntity.IMTE_OnRegistration;
import gregapi.block.multitileentity.IMultiTileEntity.IMTE_SyncDataShort;
import gregapi.block.multitileentity.MultiTileEntityRegistry;
import gregapi.data.FL;
import gregapi.network.INetworkHandler;
import gregapi.network.IPacket;
import gregapi.old.Textures;
import gregapi.render.BlockTextureDefault;
import gregapi.render.BlockTextureFluid;
import gregapi.render.BlockTextureMulti;
import gregapi.render.ITexture;
import gregapi.tileentity.base.TileEntityBase04MultiTileEntities;
import gregapi.tileentity.data.ITileEntitySurface;
import gregapi.util.UT;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.FluidStack;

/**
 * @author Gregorius Techneticies
 */
public class MultiTileEntityFluidSpring extends TileEntityBase04MultiTileEntities implements IMTE_OnRegistration, ITileEntitySurface, IMTE_IsSideSolid, IMTE_GetExplosionResistance, IMTE_GetBlockHardness, IMTE_GetLightOpacity, IMTE_SyncDataShort {
	public FluidStack mFluid = FL.Water.make(1);
	
	@Override
	public void readFromNBT2(NBTTagCompound aNBT) {
		super.readFromNBT2(aNBT);
		if (aNBT.hasKey("gt.spring")) mFluid = UT.Fluids.load(aNBT, "gt.spring");
	}
	
	@Override
	public void writeToNBT2(NBTTagCompound aNBT) {
		super.writeToNBT2(aNBT);
		UT.Fluids.save(aNBT, "gt.spring", mFluid);
	}
	
	@Override
	public final NBTTagCompound writeItemNBT(NBTTagCompound aNBT) {
		aNBT = super.writeItemNBT(aNBT);
		UT.Fluids.save(aNBT, "gt.spring", mFluid);
		return aNBT;
	}
	
	public static MultiTileEntityRegistry MTE_REGISTRY = null;
	public static MultiTileEntityFluidSpring INSTANCE;
	
	public static boolean setBlock(World aWorld, int aX, int aY, int aZ, FluidStack aSpring) {
		return MTE_REGISTRY.mBlock.placeBlock(aWorld, aX, aY, aZ, SIDE_UP, INSTANCE.getMultiTileEntityID(), UT.NBT.make(null, "gt.spring", aSpring), T, F);
	}
	
	@Override
	public IPacket getClientDataPacket(boolean aSendAll) {
		return getClientDataPacketShort(aSendAll, (short)mFluid.getFluid().getID());
	}
	
	@Override
	public boolean receiveDataShort(short aData, INetworkHandler aNetworkHandler) {
		mFluid = UT.Fluids.make(UT.Fluids.fluid(aData), 1200);
		return T;
	}
	
	@Override
	public void onRegistration(MultiTileEntityRegistry aRegistry, short aID) {
		INSTANCE = this;
		MTE_REGISTRY = aRegistry;
	}
	
	@Override
	public void onTick(long aTimer, boolean aIsServerSide) {
		super.onTick(aTimer, aIsServerSide);
		if (aIsServerSide) {
			if (rng(mFluid.amount) == 0) {
				Block tBlock = mFluid.getFluid().getBlock(), tAbove = getBlockAtSide(SIDE_UP);
				byte tNeededMetaData = (byte)(tBlock instanceof BlockFluidFinite ? 7 : 0);
				if (tAbove == tBlock) {
					if (getMetaDataAtSide(SIDE_UP) == tNeededMetaData) {
						for (byte tSide : ALL_SIDES_HORIZONTAL) {
							tAbove = getBlock(xCoord+OFFSETS_X[tSide], yCoord+1, zCoord+OFFSETS_Z[tSide]);
							if (tAbove == tBlock) {
								if (tNeededMetaData != getMetaData(xCoord+OFFSETS_X[tSide], yCoord+1, zCoord+OFFSETS_Z[tSide])) {
									worldObj.setBlock(xCoord+OFFSETS_X[tSide], yCoord+1, zCoord+OFFSETS_Z[tSide], tBlock, tNeededMetaData, 3);
									break;
								}
							} else if (tAbove.isAir(worldObj, xCoord+OFFSETS_X[tSide], yCoord+1, zCoord+OFFSETS_Z[tSide])) {
								worldObj.setBlock(xCoord+OFFSETS_X[tSide], yCoord+1, zCoord+OFFSETS_Z[tSide], tBlock, tNeededMetaData, 3);
								break;
							}
						}
					} else {
						worldObj.setBlock(xCoord, yCoord+1, zCoord, tBlock, tNeededMetaData, 3);
					}
				} else if (tAbove.isAir(worldObj, xCoord, yCoord+1, zCoord)) {
					worldObj.setBlock(xCoord, yCoord+1, zCoord, tBlock, tNeededMetaData, 3);
				}
			}
		}
	}
	
	@Override public boolean setBlockBounds(Block aBlock, int aRenderPass, boolean[] aShouldSideBeRendered) {return F;}
	@Override public int getRenderPasses(Block aBlock, boolean[] aShouldSideBeRendered) {return 1;}
	@Override public ITexture getTexture(Block aBlock, int aRenderPass, byte aSide, boolean[] aShouldSideBeRendered) {return aShouldSideBeRendered[aSide] ? BlockTextureMulti.get(BlockTextureFluid.get(mFluid), BlockTextureDefault.get(Textures.BlockIcons.FLUID_SPRING)) : null;}
	
	@Override public int getLightOpacity() {return LIGHT_OPACITY_MAX;}
	
	@Override public float getExplosionResistance() {return Blocks.bedrock.getExplosionResistance(null);}
	@Override public float getBlockHardness() {return -1;}
	
	@Override public boolean isSurfaceSolid			(byte aSide) {return T;}
	@Override public boolean isSurfaceOpaque		(byte aSide) {return T;}
	@Override public boolean isSideSolid			(byte aSide) {return T;}
	
	@Override public String getTileEntityName() {return "gt.multitileentity.fluid.spring";}
}