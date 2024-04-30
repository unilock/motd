package cc.unilock.motd.config;

import folk.sisby.kaleido.api.ReflectiveConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.Comment;
import folk.sisby.kaleido.lib.quiltconfig.api.values.TrackedValue;

public class MotdConfig extends ReflectiveConfig {
    @Comment("Message to send to players when they join the server")
    public final TrackedValue<String> motd = value("Welcome!§0§0§1§2§3§4§5§6§7§e§f");
}
