package com.lichking.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lichking.entity.Point;


/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * @author LichKing
 *
 */
public class MaxPointsOn2DPlane {

	public int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		if (points.length == 1)
			return 1;
		if (points.length == 2)
			return 2;
		int max = 0;
		for (int i = 0; i < points.length - 1; i++) {
			Point pa = points[i];
			for (int j = i + 1; j < points.length; j++) {
				Point pb = points[j];
				List<Point> rest = new ArrayList<Point>(Arrays.asList(points));
				rest.remove(pa);
				rest.remove(pb);
				int num = getNum(pa, pb, rest);
				if (num == points.length)
					return num;
				if (num > max)
					max = num;
			}
		}
		return max;
	}

	public int getNum(Point pa, Point pb, List<Point> rest) {
		int count = 0;
		if (isSamePoint(pa, pb)) {
			boolean f = false;
			for (Point p : rest) {
				if (isSamePoint(pa, p))
					count++;
				else
					f = true;
			}
			if (f)
				return count + 3;
			else
				return count + 2;
		}
		if (pb.x - pa.x == 0) {
			for (Point p : rest) {
				if (p.x == pa.x)
					count++;
			}
			return count + 2;
		} else if (pb.y - pa.y == 0) {
			for (Point p : rest) {
				if (p.y == pa.y)
					count++;
			}
			return count + 2;
		}
		for (Point p : rest) {
			if (isInLine(pa, pb, p))
				count++;
		}
		return count + 2;
	}

	public boolean isInLine(Point pa, Point pb, Point pc) {
		if ((pc.x == pb.x && pc.y == pb.y) || (pc.x == pa.x && pc.y == pa.y))
			return true;
		double k = (pb.y - pa.y) / (double) (pb.x - pa.x);
		double k2 = (pc.y - pa.y) / (double) (pc.x - pa.x);
		if (k == k2)
			return true;
		else
			return false;

	}

	public boolean isSamePoint(Point pa, Point pb) {
		if (pa.x == pb.x && pa.y == pb.y)
			return true;
		return false;
	}

	public static void main(String[] args) {

		Point a = new Point(1, 1);
		Point b = new Point(1, 1);
		Point c = new Point(1, 1);
		// Point d = new Point(-6,-1);
		Point[] arr = { a, b, c, };
		//System.out.println(new Solution().maxPoints(arr));

	}
	
}
