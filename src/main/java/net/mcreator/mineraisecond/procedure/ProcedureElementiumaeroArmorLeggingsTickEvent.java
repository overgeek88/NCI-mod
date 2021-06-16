package net.mcreator.mineraisecond.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Enchantments;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureElementiumaeroArmorLeggingsTickEvent extends ElementsClubInfoMod.ModElement {
	public ProcedureElementiumaeroArmorLeggingsTickEvent(ElementsClubInfoMod instance) {
		super(instance, 353);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure ElementiumaeroArmorLeggingsTickEvent!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).addEnchantment(Enchantments.FEATHER_FALLING, (int) 1000);
	}
}
