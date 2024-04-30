package cc.unilock.motd.transformer;

import cc.unilock.motd.MotdPremain;
import net.minecraft.entity.player.EntityServerPlayer;
import nilloader.api.lib.mini.MiniTransformer;
import nilloader.api.lib.mini.PatchContext;
import nilloader.api.lib.mini.annotation.Patch;

@Patch.Class("net.minecraft.server.management.ServerConfigurationManager")
public class ServerConfigurationManagerTransformer extends MiniTransformer {
	@Patch.Method("playerLoggedIn(Lnet/minecraft/entity/player/EntityServerPlayer;)V")
	public void patchPlayerLoggedIn(PatchContext ctx) {
		ctx.jumpToStart();

		ctx.add(
				ALOAD(1),
				INVOKESTATIC("cc/unilock/motd/transformer/ServerConfigurationManagerTransformer$Hooks", "join", "(Lnet/minecraft/entity/player/EntityServerPlayer;)V")
		);
	}

	public static class Hooks {
		public static void join(EntityServerPlayer player) {
			player.sendChatToPlayer(MotdPremain.CONFIG.motd.value());
		}
	}
}
