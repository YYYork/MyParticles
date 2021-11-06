package io.github.yyyork;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class SpawnParticles {

	/*
	 * startX 起始点X坐标 startY 起始点Y坐标 startZ 起始点Z坐标
	 * 
	 * endX 终点X坐标 endY 终点Y坐标 endZ 终点Z坐标
	 * 
	 * (X1,Y1,Z1) 和 (X2,Y2,Z2) 两点表示一条线
	 * 
	 * resolution 记录我们要用多少个点画这条线
	 * 
	 */
	
	// generateLine方法：用来生成一条线上所有的点的方法（函数）
	
    public static List<double[]> generateLine(double startX,double startY,double startZ, double endX,double endY,double endZ, int resolution) {
        double XStep = (endX - startX) / (double) resolution;
        // XStep  X 方向的「单元」 （即每个点之间X坐标的间距）
        double ZStep = (endZ - startZ) / (double) resolution;
        // ZStep  Z 方向的「单元」 （即每个点之间Z坐标的间距）
        double YStep = (endY - startY) / (double) resolution;
        // YStep  Y 方向的「单元」 （即每个点之间Y坐标的间距）
        List<double[]> result = new ArrayList<>();
        for (int i = 0; i <= resolution; i++) {
            double[] point = new double[3]; // point表示一个点
            // 用double数组储存一个点的坐标信息 [0]储存X坐标 [1]储存Y坐标 [2]储存Z坐标
            point[0] = startX; //把点坐标赋予数组
            point[1] = startY;
            point[2] = startZ;
            result.add(point); // 把这个点添加到集合里
            // 加入点阵
            startX += XStep;  // 在原来的基础上添加X,Y,Z轴每个点间距长，表示下个点的坐标
            startY += YStep;
            startZ += ZStep;
            // 移动到下一个单元

        }
        return result; // 把储存了点的集合作为返回值返回
    }

    public SpawnParticles(Location base){

        List<double[]> AC = generateLine(2.5981,0, 1.5, -2.5981,0, 1.5, 100);
        List<double[]> CE = generateLine(-2.5981,0, 1.5, 0, 0,-3, 100);
        List<double[]> EA = generateLine(0,0, -3, 2.5981, 0,1.5, 100);
        List<double[]> BD = generateLine(0,0, 3, -2.5981,0,-1.5, 100);
        List<double[]> DF = generateLine(-2.5981,0, -1.5, 2.5981, 0,-1.5, 100);
        List<double[]> FB = generateLine(2.5981, 0,-1.5, 0, 0,3, 100);
        //输入坐标和点的数量 来生成我们想要的线

        World world = base.getWorld();

        //foreach循环 主要作用：循环遍历 集合里面的所有元素
        for (double[] point
        		//定义一个 point 来获取AC线上的点 
        		: AC) {
            world.spawnParticle(Particle.HEART, base.add(point[0], point[1], point[2]), 1);
            base.subtract(point[0], point[1], point[2]);
            //每次在point点生成一个爱心，然后point变为AC中下一个点，一直循环至AC中所有的点都被读取过一遍
        }

        //同上
        for (double[] point : CE) {
            world.spawnParticle(Particle.HEART, base.add(point[0], point[1], point[2]), 1);
            base.subtract(point[0], point[1], point[2]);
        }

        for (double[] point : EA) {
            world.spawnParticle(Particle.HEART, base.add(point[0], point[1], point[2]), 1);
            base.subtract(point[0], point[1], point[2]);
        }

        for (double[] point : BD) {
            world.spawnParticle(Particle.HEART, base.add(point[0], point[1], point[2]), 1);
            base.subtract(point[0], point[1], point[2]);
        }

        for (double[] point : DF) {
            world.spawnParticle(Particle.HEART, base.add(point[0], point[1], point[2]), 1);
            base.subtract(point[0], point[1], point[2]);
        }

        for (double[] point : FB) {
            world.spawnParticle(Particle.HEART, base.add(point[0], point[1], point[2]), 1);
            base.subtract(point[0], point[1], point[2]);
        }

    }
}