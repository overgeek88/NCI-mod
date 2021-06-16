
package net.mcreator.mineraisecond.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.mineraisecond.item.ItemMyrthilIngot;
import net.mcreator.mineraisecond.block.BlockMyrthilOre;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

@ElementsClubInfoMod.ModElement.Tag
public class RecipeMyrthilOreSmelting extends ElementsClubInfoMod.ModElement {
	public RecipeMyrthilOreSmelting(ElementsClubInfoMod instance) {
		super(instance, 154);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockMyrthilOre.block, (int) (1)), new ItemStack(ItemMyrthilIngot.block, (int) (1)),
				3.289999999999999F);
	}
}
