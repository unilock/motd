package cc.unilock.motd;

import cc.unilock.motd.config.MotdConfig;
import cc.unilock.motd.transformer.ClassReaderTransformer;
import cc.unilock.motd.transformer.ServerConfigurationManagerTransformer;
import nilloader.api.ClassTransformer;
import nilloader.api.ModRemapper;
import nilloader.api.NilLogger;

import java.nio.file.Paths;

public class MotdPremain implements Runnable {
	public static final NilLogger LOGGER = NilLogger.get("motd");
	public static final MotdConfig CONFIG = MotdConfig.createToml(Paths.get("config"), "", "motd", MotdConfig.class);

	@Override
	public void run() {
		ModRemapper.setTargetMapping("default");

		// Required for Forge compatibility
		ClassTransformer.register(new ClassReaderTransformer());

		// Player events
		ClassTransformer.register(new ServerConfigurationManagerTransformer());
	}
}
