package net.mcreator.mineraisecond.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Enchantments;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureTNTArmorHelmetTickEvent extends ElementsClubInfoMod.ModElement {
	public ProcedureTNTArmorHelmetTickEvent(ElementsClubInfoMod instance) {
		super(instance, 306);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure TNTArmorHelmetTickEvent!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).addEnchantment(Enchantments.BLAST_PROTECTION, (int) 10);
	}
}
