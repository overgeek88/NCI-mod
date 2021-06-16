
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemElementium_ardentIngot;
import net.mcreator.mineraisecond.block.BlockElementium_ardentOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeElementium_ardentOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeElementium_ardentOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 103);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockElementium_ardentOre.block, (int) (1)),
				new ItemStack(ItemElementium_ardentIngot.block, (int) (1)), 3.5F);
	}
}
