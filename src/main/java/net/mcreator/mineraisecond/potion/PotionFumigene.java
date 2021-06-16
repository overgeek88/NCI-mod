
package net.mcreator.mineraisecond.potion;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.Minecraft;

import net.mcreator.mineraisecond.procedure.ProcedureFumigenePotionStartedapplied;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.HashMap;

@ElementsClubInfoMod.ModElement.Tag
public class PotionFumigene extends ElementsClubInfoMod.ModElement {
	@GameRegistry.ObjectHolder("club_info:fumigene")
	public static final Potion potion = null;
	@GameRegistry.ObjectHolder("club_info:fumigene")
	public static final PotionType potionType = null;
	public PotionFumigene(ElementsClubInfoMod instance) {
		super(instance, 351);
	}

	@Override
	public void initElements() {
		elements.potions.add(() -> new PotionCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		ForgeRegistries.POTION_TYPES.register(new PotionTypeCustom());
	}
	public static class PotionTypeCustom extends PotionType {
		public PotionTypeCustom() {
			super(new PotionEffect[]{new PotionEffect(potion, 3600)});
			setRegistryName("fumigene");
		}
	}

	public static class PotionCustom extends Potion {
		private final ResourceLocation potionIcon;
		public PotionCustom() {
			super(true, -13421773);
			setRegistryName("fumigene");
			setPotionName("effect.fumigene");
			potionIcon = new ResourceLocation("club_info:textures/mob_effect/fumigene.png");
		}

		@Override
		public boolean isInstant() {
			return true;
		}

		@Override
		public boolean shouldRenderInvText(PotionEffect effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(PotionEffect effect) {
			return true;
		}

		@Override
		public void affectEntity(Entity source, Entity indirectSource, EntityLivingBase entity, int amplifier, double health) {
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureFumigenePotionStartedapplied.executeProcedure($_dependencies);
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
			if (mc.currentScreen != null) {
				mc.getTextureManager().bindTexture(potionIcon);
				Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
			mc.getTextureManager().bindTexture(potionIcon);
			Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
