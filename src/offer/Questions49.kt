package offer

import java.util.PriorityQueue

/*
 * 求第n个丑数
 */
fun main(args: Array<String>) {
	val number = 1500
	val start1Time = System.currentTimeMillis()
	println("第${number}个丑数是：${getUglyNumber1(number)}")
	val end1Time = System.currentTimeMillis()
	println("方法1的执行时间为：${end1Time - start1Time}ms")
	val start2Time = System.currentTimeMillis()
	println("第${number}个丑数是：${getUglyNumber2(number)}")
	val end2Time = System.currentTimeMillis()
	println("方法2的执行时间为：${end2Time - start2Time}ms")
}

//逐个判断法
fun getUglyNumber1(n: Int): Int {
	if (n <= 0)
		throw IllegalArgumentException("输入的数字必须是正整数")
	var i = 1
	var number = 1
	while (i <= n) {
		if (number.isUgly()) i++
		number++
	}
	return --number
}

//判断是否是丑数
fun Int.isUgly(): Boolean {
	var x = this
	while (x % 2 == 0)
		x = x shr 1
	while (x % 3 == 0)
		x /= 3
	while (x % 5 == 0)
		x /= 5
	return x == 1
}

//累计法
fun getUglyNumber2(n: Int): Int {
	if (n <= 0)
		throw IllegalArgumentException("输入的数字必须是正整数")
	
	//判断三个数中的最小值
	fun min(x: Int, y: Int, z: Int): Int {
		val temp = if (x < y) x else y
		return if (temp < z) temp else z
	}
	
	val uglyNumbers = IntArray(n)
	uglyNumbers[0] = 1
	var uglyIndex = 0
	var multiply2 = 0
	var multiply3 = 0
	var multiply5 = 0
	while (uglyIndex + 1 < n) {
		val value2 = uglyNumbers[multiply2] shl 1
		val value3 = uglyNumbers[multiply3] * 3
		val value5 = uglyNumbers[multiply5] * 5
		uglyNumbers[++uglyIndex] = min(value2, value3, value5)
		if (uglyNumbers[uglyIndex] == value2) multiply2++
		if (uglyNumbers[uglyIndex] == value3) multiply3++
		if (uglyNumbers[uglyIndex] == value5) multiply5++
	}
	return uglyNumbers[n-1]
}