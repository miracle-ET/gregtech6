package gregtech.old;

import java.util.List;

import gregapi.lang.LanguageHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public abstract class GT_Item_Casings_Abstract extends ItemBlock {
    public GT_Item_Casings_Abstract(Block par1) {
        super(par1);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
    
    @Override
	public int getMetadata(int aMeta) {
        return aMeta;
    }
    
    protected final String mNoMobsToolTip = LanguageHandler.get("gt.nomobspawnsonthisblock", "Mobs cannot Spawn on this Block");
    protected final String mNoTileEntityToolTip = LanguageHandler.get("gt.notileentityinthisblock", "This is NOT a TileEntity!");
    protected final String mCoil01Tooltip = LanguageHandler.get("gt.coil01tooltip", "Base Heating Capacity = 1800 Kelvin");
    protected final String mCoil02Tooltip = LanguageHandler.get("gt.coil02tooltip", "Base Heating Capacity = 2700 Kelvin");
    protected final String mCoil03Tooltip = LanguageHandler.get("gt.coil03tooltip", "Base Heating Capacity = 3600 Kelvin");
    protected final String mBlastProofTooltip = LanguageHandler.get("gt.blastprooftooltip", "This Block is Blast Proof");
    
    @Override
    public String getUnlocalizedName(ItemStack aStack) {
    	return field_150939_a.getUnlocalizedName() + "." + getDamage(aStack);
    }
    
    @Override
    public void addInformation(ItemStack aStack, EntityPlayer aPlayer, List aList, boolean aF3_H) {
    	super.addInformation(aStack, aPlayer, aList, aF3_H);
    	aList.add(mNoMobsToolTip);
    	aList.add(mNoTileEntityToolTip);
    }
}