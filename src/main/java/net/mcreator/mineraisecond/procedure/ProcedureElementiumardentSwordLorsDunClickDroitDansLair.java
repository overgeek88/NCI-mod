package net.mcreator.mineraisecond.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Enchantments;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureElementiumardentSwordLorsDunClickDroitDansLair extends ElementsClubInfoMod.ModElement {
	public ProcedureElementiumardentSwordLorsDunClickDroitDansLair(ElementsClubInfoMod instance) {
		super(instance, 487);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure ElementiumardentSwordLorsDunClickDroitDansLair!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		((itemstack)).addEnchantment(Enchantments.FIRE_ASPECT, (int) 10);
	}
}
