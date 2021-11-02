package io.github.yyyork;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class SpawnParticles {

    public static List<double[]> generateLine(double startX,double startY,double startZ, double endX,double endY,double endZ, int resolution) {
        double XStep = (endX - startX) / (double) resolution;
        // X ����ġ���Ԫ��
        double ZStep = (endZ - startZ) / (double) resolution;
        // Z ����ġ���Ԫ��
        double YStep = (endY - startY) / (double) resolution;
        // Y ����ġ���Ԫ��
        List<double[]> result = new ArrayList<>();
        for (int i = 0; i <= resolution; i++) {
            double[] point = new double[3];
            // {x,y,z} ����������
            point[0] = startX;
            point[1] = startY;
            point[2] = startZ;
            result.add(point);
            // �������
            startX += XStep;
            startY += YStep;
            startZ += ZStep;
            // �ƶ�����һ����Ԫ

        }
        return result;
    }

    public SpawnParticles(Location base){

        List<double[]> AC = generateLine(2.5981,0, 1.5, -2.5981,0, 1.5, 100);
        List<double[]> CE = generateLine(-2.5981,0, 1.5, 0, 0,-3, 100);
        List<double[]> EA = generateLine(0,0, -3, 2.5981, 0,1.5, 100);
        List<double[]> BD = generateLine(0,0, 3, -2.5981,0,-1.5, 100);
        List<double[]> DF = generateLine(-2.5981,0, -1.5, 2.5981, 0,-1.5, 100);
        List<double[]> FB = generateLine(2.5981, 0,-1.5, 0, 0,3, 100);


        World world = base.getWorld();

        for (double[] point : AC) {
            world.spawnParticle(Particle.HEART, base.add(point[0], point[1], point[2]), 1);
            base.subtract(point[0], point[1], point[2]);
        }

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
