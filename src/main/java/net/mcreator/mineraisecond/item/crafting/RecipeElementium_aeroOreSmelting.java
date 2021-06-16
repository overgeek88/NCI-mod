
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemElementium_aeroGem;
import net.mcreator.mineraisecond.block.BlockElementium_aeroOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeElementium_aeroOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeElementium_aeroOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 334);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockElementium_aeroOre.block, (int) (1)), new ItemStack(ItemElementium_aeroGem.block, (int) (1)),
				3.15F);
	}
}
