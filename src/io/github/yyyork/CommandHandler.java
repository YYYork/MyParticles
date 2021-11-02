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
            commandSender.sendMessage("��8[��6�ҵ����ӡ�8]��4��ָ��ֻ������Ϸ��ʹ��");
            return true;
        }
        Player player = (Player)commandSender;
        if(args[0].equals("cancel")) {
        	if(forspawn==null) {
        		player.sendMessage("��8[��6�ҵ����ӡ�8]��4��δ����ʼ�����Ӳ���");
        		return true;
        	}else {
        		forspawn.cancel();
        		player.sendMessage("��8[��6�ҵ����ӡ�8]��a���Ӳ����Ѿ��ر�");
        		return true;
        	}
        }
        if(args[0].equals("spawn")){
        	new SpawnParticles(player.getLocation());
        }else if(args[0].equals("forspawn")) {
        	
        	forspawn = new BukkitRunnable() {
				@Override
				public void run() {//�������д��������
					new SpawnParticles(player.getLocation());
				}
			}.runTaskTimer(MyParticles.instance, 0, 20);
			// Bukkit�ṩ�ķ�������runTaskTimer��ѭ��ִ��һ������
			// instance�ǲ������ʵ����0Ϊ��ú�ʼѭ���������ʾֱ�ӿ�ʼ��20��ʾÿ20��ִ��һ�δ���
			// 20��=1s
			return true;
        }
        return true;
    }
}
