
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemElementium_electroIngot;
import net.mcreator.mineraisecond.block.BlockElementium_electroOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeElementium_electroOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeElementium_electroOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 6);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockElementium_electroOre.block, (int) (1)),
				new ItemStack(ItemElementium_electroIngot.block, (int) (1)), 4.8999999999999995F);
	}
}
