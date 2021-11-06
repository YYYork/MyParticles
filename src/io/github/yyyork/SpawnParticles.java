package io.github.yyyork;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class SpawnParticles {

	/*
	 * startX ��ʼ��X���� startY ��ʼ��Y���� startZ ��ʼ��Z����
	 * 
	 * endX �յ�X���� endY �յ�Y���� endZ �յ�Z����
	 * 
	 * (X1,Y1,Z1) �� (X2,Y2,Z2) �����ʾһ����
	 * 
	 * resolution ��¼����Ҫ�ö��ٸ��㻭������
	 * 
	 */
	
	// generateLine��������������һ���������еĵ�ķ�����������
	
    public static List<double[]> generateLine(double startX,double startY,double startZ, double endX,double endY,double endZ, int resolution) {
        double XStep = (endX - startX) / (double) resolution;
        // XStep  X ����ġ���Ԫ�� ����ÿ����֮��X����ļ�ࣩ
        double ZStep = (endZ - startZ) / (double) resolution;
        // ZStep  Z ����ġ���Ԫ�� ����ÿ����֮��Z����ļ�ࣩ
        double YStep = (endY - startY) / (double) resolution;
        // YStep  Y ����ġ���Ԫ�� ����ÿ����֮��Y����ļ�ࣩ
        List<double[]> result = new ArrayList<>();
        for (int i = 0; i <= resolution; i++) {
            double[] point = new double[3]; // point��ʾһ����
            // ��double���鴢��һ�����������Ϣ [0]����X���� [1]����Y���� [2]����Z����
            point[0] = startX; //�ѵ����긳������
            point[1] = startY;
            point[2] = startZ;
            result.add(point); // ���������ӵ�������
            // �������
            startX += XStep;  // ��ԭ���Ļ��������X,Y,Z��ÿ�����೤����ʾ�¸��������
            startY += YStep;
            startZ += ZStep;
            // �ƶ�����һ����Ԫ

        }
        return result; // �Ѵ����˵�ļ�����Ϊ����ֵ����
    }

    public SpawnParticles(Location base){

        List<double[]> AC = generateLine(2.5981,0, 1.5, -2.5981,0, 1.5, 100);
        List<double[]> CE = generateLine(-2.5981,0, 1.5, 0, 0,-3, 100);
        List<double[]> EA = generateLine(0,0, -3, 2.5981, 0,1.5, 100);
        List<double[]> BD = generateLine(0,0, 3, -2.5981,0,-1.5, 100);
        List<double[]> DF = generateLine(-2.5981,0, -1.5, 2.5981, 0,-1.5, 100);
        List<double[]> FB = generateLine(2.5981, 0,-1.5, 0, 0,3, 100);
        //��������͵������ ������������Ҫ����

        World world = base.getWorld();

        //foreachѭ�� ��Ҫ���ã�ѭ������ �������������Ԫ��
        for (double[] point
        		//����һ�� point ����ȡAC���ϵĵ� 
        		: AC) {
            world.spawnParticle(Particle.HEART, base.add(point[0], point[1], point[2]), 1);
            base.subtract(point[0], point[1], point[2]);
            //ÿ����point������һ�����ģ�Ȼ��point��ΪAC����һ���㣬һֱѭ����AC�����еĵ㶼����ȡ��һ��
        }

        //ͬ��
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