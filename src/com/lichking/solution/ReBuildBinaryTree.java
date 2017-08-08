package com.lichking.solution;

import java.util.ArrayList;
import java.util.List;

import com.lichking.entity.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * @author LichKing
 * 
 */
public class ReBuildBinaryTree {

	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length < 1 || in.length < 1)
        	return null;
		TreeNode root = new TreeNode(pre[0]);
		List<Integer[]> in_list = getInSep(in, pre[0]);
		List<Integer[]> pre_list = getPreSep(pre, in_list);
		TreeNode left = reConstructBinaryTree(change(pre_list.get(0)), change(in_list.get(0)));
		TreeNode right = reConstructBinaryTree(change(pre_list.get(1)), change(in_list.get(1)));
		root.left = left;
		root.right = right;
		return root;
    }
	
	public List<Integer[]> getInSep(int[] in,int separator){
		int cursor = 0;
		for(int i=0;i<in.length;i++){
			if(in[i] == separator)
				cursor = i;
		}
		Integer[] left = new Integer[cursor];
		Integer[] right = new Integer[in.length-cursor-1];
		for(int i=0;i<cursor;i++)
			left[i] = in[i];
		for(int i=cursor+1;i<in.length;i++)
			right[i-cursor-1] = in[i];
		List<Integer[]> result = new ArrayList<Integer[]>();
		result.add(left);
		result.add(right);
		return result;
	}
	
	public List<Integer[]> getPreSep(int[] pre,List<Integer[]> in_list){
		List<Integer[]> result = new ArrayList<Integer[]>();
		int cursor = findMaxCursor(pre, in_list.get(0));
		Integer[] left = new Integer[cursor];
		Integer[] right = new Integer[pre.length-cursor-1];
		for(int i=1;i<cursor+1;i++)
			left[i-1] = pre[i];
		for(int i=cursor+1;i<pre.length;i++)
			right[i-cursor-1] = pre[i];
		result.add(left);
		result.add(right);
		return result;
	}
	
	public int findMaxCursor(int[] pre,Integer[] sub_left){
		int cursor = 0;
		for(int i=0;i<pre.length;i++){
			for(int j=0;j<sub_left.length;j++){
				if(pre[i] == sub_left[j] && cursor<i)
					cursor = i;
			}
		}
		return cursor;
	}
	
	public int[] change(Integer[] arr){
		int[] result = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			result[i] = arr[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] pre = {1,2,3,4,5,6,7};
		int[] in = {3,2,4,1,6,5,7};
		TreeNode tn = new ReBuildBinaryTree().reConstructBinaryTree(pre, in);
		System.out.println(tn);
	}
	
}
