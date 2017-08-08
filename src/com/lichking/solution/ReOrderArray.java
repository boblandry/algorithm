package com.lichking.solution;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author LichKing
 *
 */
public class ReOrderArray {

	public void reOrderArray(int[] array) {
		int[] newarray = new int[array.length];
		int cursor = 0;
		for(int i=0;i<array.length;i++){
			if((array[i] & 1) == 1){
				newarray[cursor] = array[i];
				cursor++;
			}
		}
		for(int i=0;i<array.length;i++){
			if((array[i] & 1) == 0){
				newarray[cursor] = array[i];
				cursor++;
			}
		}
		//重新拷贝一遍！！！
		for(int i=0;i<array.length;i++)
			array[i] = newarray[i];
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		new ReOrderArray().reOrderArray(array);
	}

}
