
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemMatiere_noireGem;
import net.mcreator.mineraisecond.block.BlockMatiere_noireOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeMatiere_noireOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeMatiere_noireOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 50);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockMatiere_noireOre.block, (int) (1)), new ItemStack(ItemMatiere_noireGem.block, (int) (1)), 5.25F);
	}
}
