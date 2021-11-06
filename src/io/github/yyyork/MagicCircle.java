package io.github.yyyork;

import java.util.ArrayList;
import java.util.List;

public class MagicCircle {
	private double r;
	private double t;
	private int circleResolution;
	private int lineResolution;
	
	public MagicCircle(double r,int circleResolution,int lineResolution) {
		t = 0;
		this.r = r;
		this.circleResolution = circleResolution;
		this.lineResolution = lineResolution;
	}
	
	public void gennerateMagicCircle() {
		
	}
	
	public MagicCircle setT(double t) {
		this.t = t;
		return this;
	}
	
	public MagicCircle setR(double r) {
		this.r = r;
		return this;
	}
	
	public Points getCirclePoints(){
		List<double[]> points = new ArrayList<double[]>();
		double start = 0;
		double step = 360 / circleResolution;
		
		for(int i=0;i<=circleResolution;i++) {
			double[] point = new double[3];
			point[0] = r*Math.cos(start); // X
			point[1] = 0; // Y
			point[2] = r*Math.sin(start); // Z
			points.add(point);
			start += step;
		}
		
		Points p = new Points(points);
		return p;
	}
	
	public List<Points> getLinePoints(){
		List<double[]> line1 = new ArrayList<double[]>();
		List<double[]> line2 = new ArrayList<double[]>();
		List<double[]> line3 = new ArrayList<double[]>();
		List<double[]> line4 = new ArrayList<double[]>();
		List<double[]> line5 = new ArrayList<double[]>();
		
		line1 = SpawnParticles.generateLine(r*Math.cos(t+0.4*Math.PI), 0, r*Math.sin(t+0.4*Math.PI)
				, r*Math.cos(t+1.6*Math.PI), 0, r*Math.sin(t+1.6*Math.PI), lineResolution);
		
		line2 = SpawnParticles.generateLine(r*Math.cos(t), 0, r*Math.sin(t)
				, r*Math.cos(t+0.8*Math.PI), 0, r*Math.sin(t+0.8*Math.PI), lineResolution);
		
		line3 = SpawnParticles.generateLine(r*Math.cos(t+1.6*Math.PI), 0, r*Math.sin(t+1.6*Math.PI)
				, r*Math.cos(t+0.8*Math.PI), 0, r*Math.sin(t+0.8*Math.PI), lineResolution);
		
		line4 = SpawnParticles.generateLine(r*Math.cos(t+1.2*Math.PI), 0, r*Math.sin(t+1.2*Math.PI)
				, r*Math.cos(t), 0, r*Math.sin(t), lineResolution);
		
		line5 = SpawnParticles.generateLine(r*Math.cos(t+1.2*Math.PI), 0, r*Math.sin(t+1.2*Math.PI)
				, r*Math.cos(t+0.4*Math.PI), 0, r*Math.sin(t+0.4*Math.PI), lineResolution);
		
		Points p1 = new Points(line1);
		Points p2 = new Points(line2);
		Points p3 = new Points(line3);
		Points p4 = new Points(line4);
		Points p5 = new Points(line5);
		
		List<Points> points = new ArrayList<Points>();
		
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		points.add(p5);
		
		return points;
	}
	
}
