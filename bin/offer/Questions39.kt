package offer

//Ѱ�������г��ִ��������鳤��һ�����ϵ�����

fun main(args: Array<String>) {
	val arg0 = intArrayOf(1, 2, 3, 2, 2, 2, 5, 4, 2)
	val arg1 = intArrayOf(1, 2, 3, 2, 2, 2, 5, 4)
	val message = "����һ�������Ϊ��"
	println("$message${moreThanHalfNum2(arg0)}")
	println("$message${moreThanHalfNum2(arg1)}")
	//println("$message${moreThanHalfNum1(arg0)}")
	//println("$message${moreThanHalfNum1(arg1)}")
}

//�ⷨһ���ı���������飬ʱ�临�Ӷ�ΪO(n)
//fun moreThanHalfNum1(args: IntArray): Int 

//�ⷨ�������Բ��޸��������飬ʱ�临�Ӷ�O(n)
fun moreThanHalfNum2(args: IntArray): Int {
	var index = 0
	var number = args[index]
	var count = 0
	args.forEach {
		if (it == number) {
			count++
		} else {
			--count
			if (count == 0) {
				number = args[++index]
				count = 1
			}
		}
	}
	if (count > 1) {
		return number
	} else {
		throw RuntimeException("û�з���Ҫ�������")
	}
}