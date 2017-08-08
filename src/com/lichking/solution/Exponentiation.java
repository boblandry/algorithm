package com.lichking.solution;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 
 * @author LichKing
 *
 */
public class Exponentiation {

	/**
	 *   1.全面考察指数的正负、底数是否为零等情况。  
	 *   2.写出指数的二进制表达，例如13表达为二进制1101。 
	 *   3.举例:10^1101= 10^0001*10^0100*10^1000。  
	 *   4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。  
	 */

	public double Power(double base, int exponent) {
        double result = 1;
        int power = 0;
		if(exponent == 0)
        	return 1;
        else if(exponent < 0)
        	power = -exponent;
        else 
        	power = exponent;
		while(power != 0){
			if((power & 1) == 1)
				result *= base;
			base *= base;
			power = power >> 1;
		}
		return exponent>=0 ? result : 1/result;
	}
	
}
