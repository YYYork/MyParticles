package io.github.yyyork;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class CommandHandler implements CommandExecutor {
	private BukkitTask forspawn;
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage("§8[§6我的粒子§8]§4该指令只能在游戏内使用");
            return true;
        }
        Player player = (Player)commandSender;
        if(args[0].equals("cancel")) {
        	if(forspawn==null) {
        		player.sendMessage("§8[§6我的粒子§8]§4您未曾开始过粒子播放");
        		return true;
        	}else {
        		forspawn.cancel();
        		player.sendMessage("§8[§6我的粒子§8]§a粒子播放已经关闭");
        		return true;
        	}
        }
        if(args[0].equals("spawn")){
        	new SpawnParticles(player.getLocation());
        }else if(args[0].equals("forspawn")) {
        	
        	forspawn = new BukkitRunnable() {
				@Override
				public void run() {//任务代码写在这里面
					new SpawnParticles(player.getLocation());
				}
			}.runTaskTimer(MyParticles.instance, 0, 20);
			// Bukkit提供的方法——runTaskTimer（循环执行一个任务）
			// instance是插件主类实例，0为多久后开始循环，这里表示直接开始，20表示每20刻执行一次代码
			// 20刻=1s
			return true;
        }
        return true;
    }
}
