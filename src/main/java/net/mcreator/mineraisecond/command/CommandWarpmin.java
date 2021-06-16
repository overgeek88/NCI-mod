
package net.mcreator.mineraisecond.command;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.ICommand;
import net.minecraft.command.CommandHandler;

import net.mcreator.mineraisecond.procedure.ProcedureWarpminQuandUneCommandeEstExecutee;
import net.mcreator.mineraisecond.ElementsClubInfoMod;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

@ElementsClubInfoMod.ModElement.Tag
public class CommandWarpmin extends ElementsClubInfoMod.ModElement {
	public CommandWarpmin(ElementsClubInfoMod instance) {
		super(instance, 481);
	}

	@Override
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandHandler());
	}
	public static class CommandHandler implements ICommand {
		@Override
		public int compareTo(ICommand c) {
			return getName().compareTo(c.getName());
		}

		@Override
		public boolean checkPermission(MinecraftServer server, ICommandSender var1) {
			return true;
		}

		@Override
		public List getAliases() {
			return new ArrayList();
		}

		@Override
		public List getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
			return new ArrayList();
		}

		@Override
		public boolean isUsernameIndex(String[] string, int index) {
			return true;
		}

		@Override
		public String getName() {
			return "NCIWarpmine";
		}

		@Override
		public String getUsage(ICommandSender var1) {
			return "/NCIWarpmine [<arguments>]";
		}

		@Override
		public void execute(MinecraftServer server, ICommandSender sender, String[] cmd) {
			int x = sender.getPosition().getX();
			int y = sender.getPosition().getY();
			int z = sender.getPosition().getZ();
			Entity entity = sender.getCommandSenderEntity();
			if (entity != null) {
				World world = entity.world;
				HashMap<String, String> cmdparams = new HashMap<>();
				int[] index = {0};
				Arrays.stream(cmd).forEach(param -> {
					cmdparams.put(Integer.toString(index[0]), param);
					index[0]++;
				});
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureWarpminQuandUneCommandeEstExecutee.executeProcedure($_dependencies);
				}
			}
		}
	}
}
