package gregapi.network.packets.covervisuals;

import static gregapi.data.CS.*;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import gregapi.block.IBlockSyncData.IBlockSyncDataAndCoversAndIDs;
import gregapi.cover.CoverData;
import gregapi.network.INetworkHandler;
import gregapi.network.packets.PacketCoordinates;
import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.IBlockAccess;

/**
 * @author Gregorius Techneticies
 * 
 * Transmits the extended Data of a Block.
 */
public class PacketSyncDataCoverVisuals extends PacketCoordinates {
	public short mCoverVisuals[];
	public boolean mVisualsToSync[];
	
	public PacketSyncDataCoverVisuals(int aDecoderType) {
		super(aDecoderType);
	}
	
	public PacketSyncDataCoverVisuals(int aX, int aY, int aZ, CoverData aCoverData) {
		super(aX, aY, aZ);
		mVisualsToSync = aCoverData.mVisualsToSync;
		mCoverVisuals = aCoverData.mVisuals;
	}
	public PacketSyncDataCoverVisuals(ChunkCoordinates aCoords, CoverData aCoverData) {
		super(aCoords);
		mVisualsToSync = aCoverData.mVisualsToSync;
		mCoverVisuals = aCoverData.mVisuals;
	}
	
	private PacketSyncDataCoverVisuals(int aX, int aY, int aZ, ByteArrayDataInput aCovers) {
		super(aX, aY, aZ);
		mCoverVisuals	= new short[] {0,0,0,0,0,0};
		mVisualsToSync	= new boolean[] {F,F,F,F,F,F};
		for (byte i = 0, j = aCovers.readByte(); i < 6; i++) if ((j & (1 << i)) != 0) {mVisualsToSync[i] = T; mCoverVisuals[i] = aCovers.readShort();}
	}
	
	@Override
	public byte getPacketIDOffset() {
		return 16;
	}
	
	@Override
	public ByteArrayDataOutput encode2(ByteArrayDataOutput aData) {
		
		byte tCoverBits = 0;
		for (byte i = 0; i < 6; i++) if (mVisualsToSync[i]) tCoverBits |= (1 << i);
		aData.writeByte(tCoverBits);
		for (byte i = 0; i < 6; i++) if (mVisualsToSync[i]) {aData.writeShort(mCoverVisuals[i]);}
		return aData;
	}
	
	@Override
	public PacketCoordinates decode2(int aX, int aY, int aZ, ByteArrayDataInput aData) {
		return new PacketSyncDataCoverVisuals(aX, aY, aZ, aData);
	}
	
	@Override
	public void process(IBlockAccess aWorld, INetworkHandler aNetworkHandler) {
		if (aWorld != null) {
			Block tBlock = aWorld.getBlock(mX, mY, mZ);
			if (tBlock instanceof IBlockSyncDataAndCoversAndIDs) ((IBlockSyncDataAndCoversAndIDs)tBlock).receiveData(aWorld, mX, mY, mZ, aNetworkHandler, mCoverVisuals, mVisualsToSync);
		}
	}
}