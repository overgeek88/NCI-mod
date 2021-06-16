
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemHydroniteGem;
import net.mcreator.mineraisecond.block.BlockHydroniteOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeHydroniteOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeHydroniteOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 282);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockHydroniteOre.block, (int) (1)), new ItemStack(ItemHydroniteGem.block, (int) (1)), 4.5F);
	}
}
