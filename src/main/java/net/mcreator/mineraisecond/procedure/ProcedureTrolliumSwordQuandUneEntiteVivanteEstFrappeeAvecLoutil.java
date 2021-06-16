package net.mcreator.mineraisecond.procedure;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.Iterator;

@ElementsClubInfoMod.ModElement.Tag
public class ProcedureTrolliumSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil extends ElementsClubInfoMod.ModElement {
	public ProcedureTrolliumSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil(ElementsClubInfoMod instance) {
		super(instance, 480);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TrolliumSwordQuandUneEntiteVivanteEstFrappeeAvecLoutil!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double TROLOLOLOLOLOLOLOL = 0;
		TROLOLOLOLOLOLOLOL = (double) Math.random();
		if ((9.8 < (TROLOLOLOLOLOLOLOL))) {
			entity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 999);
			if (entity instanceof EntityPlayerMP) {
				Advancement _adv = ((MinecraftServer) ((EntityPlayerMP) entity).mcServer).getAdvancementManager()
						.getAdvancement(new ResourceLocation("club_info:produtroll"));
				AdvancementProgress _ap = ((EntityPlayerMP) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((EntityPlayerMP) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		} else {
			entity.attackEntityFrom(DamageSource.MAGIC, (float) (-2));
		}
	}
}
