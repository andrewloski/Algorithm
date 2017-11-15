package offer

//����һ�Ŷ������ĸ��ڵ㣬����Ŷ�����ת��Ϊ���ľ���

fun main(args: Array<String>) {
	val a = BinaryTreeNode<Int>(8)
	val b = BinaryTreeNode<Int>(6)
	val c = BinaryTreeNode<Int>(10)
	val d = BinaryTreeNode<Int>(5)
	val e = BinaryTreeNode<Int>(7)
	val f = BinaryTreeNode<Int>(9)
	val g = BinaryTreeNode<Int>(11)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	a.inorder()
	println("/***************�ָ���***************/")
	a.mirrorRecursively()
	a.inorder()
}

fun <T> BinaryTreeNode<T>.mirrorRecursively() {
	val temp = mLeft
	mLeft = mRight
	mRight = temp
	mLeft?.mirrorRecursively()
	mRight?.mirrorRecursively()
}