package net.mcreator.mineraisecond.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Enchantments;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureHydroniteArmorHelmetTickEvent extends ElementsClubInfoMod.ModElement {
	public ProcedureHydroniteArmorHelmetTickEvent(ElementsClubInfoMod instance) {
		super(instance, 302);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure HydroniteArmorHelmetTickEvent!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).addEnchantment(Enchantments.RESPIRATION, (int) 9999999);
		((itemstack)).addEnchantment(Enchantments.AQUA_AFFINITY, (int) 10);
	}
}
