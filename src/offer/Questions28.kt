package offer

fun main(args: Array<String>) {
	val a = BinaryTreeNode<Int>(8)
	val b = BinaryTreeNode<Int>(6)
	val c = BinaryTreeNode<Int>(6)
	val d = BinaryTreeNode<Int>(5)
	val e = BinaryTreeNode<Int>(7)
	val f = BinaryTreeNode<Int>(7)
	val g = BinaryTreeNode<Int>(5)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	println(a.isSymmetrical())
	c.mValue = 9
	println(a.isSymmetrical())
	val h = BinaryTreeNode<Int>(7)
	val i = BinaryTreeNode<Int>(7)
	val j = BinaryTreeNode<Int>(7)
	val k = BinaryTreeNode<Int>(7)
	val l = BinaryTreeNode<Int>(7)
	val m = BinaryTreeNode<Int>(7)
	h.mLeft = i
	h.mRight = j
	i.mLeft = k
	i.mRight = l
	j.mLeft = m
	println(h.isSymmetrical())
}

fun <T> BinaryTreeNode<T>.isSymmetrical(): Boolean {
	if (preorderJudgment()) {
	    if (preorderBack() == _preorderBack()) {
		    return true
	    }
	}
	return false
}

//����������ж�ÿ���ڵ��Ƿ����ҽڵ�ͬʱΪ�ջ�ͬʱ��Ϊ��
fun <T> BinaryTreeNode<T>.preorderJudgment(): Boolean {
	var boo = judgment()
	if (boo) {
	    mLeft?.let { boo = it.preorderJudgment() }
		mRight?.let { boo = it.preorderJudgment() }
	}
	return boo
}

//�ж�һ���������ڵ�����������Ƿ�ͬʱΪ�ջ�ͬʱ��Ϊ��
private fun <T> BinaryTreeNode<T>.judgment(): Boolean = (mLeft == null && mRight == null) || (mLeft != null && mRight != null)

//����������з���ֵ�İ汾
fun <T> BinaryTreeNode<T>.preorderBack(): String {
	var str: String = mValue.toString()
	str = str + mLeft?.preorderBack()
	str = str + mRight?.preorderBack()
	return str
}

//��������ĶԳƱ������������ȱ����������ٱ���������
fun <T> BinaryTreeNode<T>._preorderBack(): String {
	var str: String = mValue.toString()
	str = str + mRight?._preorderBack()
	str = str + mLeft?._preorderBack()
	return str
}