package net.mcreator.mineraisecond.procedure;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.mineraisecond.item.ItemMatiere_noireArmor;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureFlyadminQuandUneCommandeEstExecutee extends ElementsClubInfoMod.ModElement {
	public ProcedureFlyadminQuandUneCommandeEstExecutee(ElementsClubInfoMod instance) {
		super(instance, 469);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FlyadminQuandUneCommandeEstExecutee!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).inventory.armorInventory.set(1, new ItemStack(ItemMatiere_noireArmor.body, (int) (1)));
			if (entity instanceof EntityPlayerMP)
				((EntityPlayerMP) entity).inventory.markDirty();
		}
		/* @ItemStack */
	}
}
