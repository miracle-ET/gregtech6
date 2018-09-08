package gregapi.enchants;

import gregapi.config.Config;
import gregapi.config.ConfigCategories;
import gregapi.data.LH;
import gregapi.data.MT;
import gregapi.util.UT;
import net.minecraft.enchantment.EnchantmentDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * @author Gregorius Techneticies
 */
public class Enchantment_WerewolfDamage extends EnchantmentDamage {
	public static Enchantment_WerewolfDamage INSTANCE;
	
	public Enchantment_WerewolfDamage() {
		super(Config.addIDConfig(ConfigCategories.IDs.enchantments, "Werebane", 12), 2, -1);
		LH.add(getName(), "Werebane");
		MT.Ir				.addEnchantmentForTools(this, 6);
		MT.Ag				.addEnchantmentForTools(this, 4);
		MT.Electrum			.addEnchantmentForTools(this, 3);
		MT.BlackBronze		.addEnchantmentForTools(this, 2);
		MT.BlackSteel		.addEnchantmentForTools(this, 2);
		MT.RedSteel			.addEnchantmentForTools(this, 3);
		MT.BlueSteel		.addEnchantmentForTools(this, 1);
		MT.SterlingSilver	.addEnchantmentForTools(this, 4);
		MT.AstralSilver		.addEnchantmentForTools(this, 5);
		MT.VibraniumSilver	.addEnchantmentForTools(this,10);
		MT.Craponite		.addEnchantmentForTools(this,10);
		MT.Tc				.addEnchantmentForTools(this,10);
		INSTANCE = this;
	}
	
	@Override
	public int getMinEnchantability(int aLevel) {
		return 5 + (aLevel - 1) * 8;
	}
	
	@Override
	public int getMaxEnchantability(int aLevel) {
		return this.getMinEnchantability(aLevel) + 20;
	}
	
	@Override
	public int getMaxLevel() {
		return 5;
	}
	
	@Override
	public void func_151367_b(EntityLivingBase aHurtEntity, Entity aDamagingEntity, int aLevel) {
		if (UT.Entities.isWereCreature(aHurtEntity)) {
			aHurtEntity.addPotionEffect(new PotionEffect(Potion.wither.id, aLevel * 200, (int)UT.Code.bind(1, 5, (10*aLevel) / 7)));
			aHurtEntity.addPotionEffect(new PotionEffect(Potion.poison.id, aLevel * 200, (int)UT.Code.bind(1, 5, (10*aLevel) / 7)));
		}
	}
	
	@Override
	public String getName() {
		return "enchantment.damage.werewolf";
	}
}