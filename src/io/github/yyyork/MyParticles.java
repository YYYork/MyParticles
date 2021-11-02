package io.github.yyyork;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MyParticles extends JavaPlugin{
	public static JavaPlugin instance;
	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getPluginCommand("mp").setExecutor(new CommandHandler());
		this.getLogger().info("§a[MyParticles]§e插件作者 yyyork , QQ 2264117533");
        this.getLogger().info("§a[MyParticles]§eMyParticles v1.0 开启成功！");
	}
}
