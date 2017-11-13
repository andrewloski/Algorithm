package offer

//�������ڵ�����������е���һ���ڵ�

class BinaryTreeNodeWithFather<T>(var mValues: T? = null,
						var mFather: BinaryTreeNodeWithFather<T>? = null,
						var mLeft: BinaryTreeNodeWithFather<T>? = null,
						var mRight: BinaryTreeNodeWithFather<T>? = null)

fun main(args: Array<String>) {
	val a = BinaryTreeNodeWithFather<Char>('a')
	val b = BinaryTreeNodeWithFather<Char>('b', a)
	val c = BinaryTreeNodeWithFather<Char>('c', a)
	val d = BinaryTreeNodeWithFather<Char>('d', b)
	val e = BinaryTreeNodeWithFather<Char>('e', b)
	val f = BinaryTreeNodeWithFather<Char>('f', c)
	val g = BinaryTreeNodeWithFather<Char>('g', c)
	val h = BinaryTreeNodeWithFather<Char>('h', e)
	val i = BinaryTreeNodeWithFather<Char>('i', e)
	a.mLeft = b
	a.mRight = c
	b.mLeft = d
	b.mRight = e
	c.mLeft = f
	c.mRight = g
	e.mLeft = h
	e.mRight = i
	println("a:${getNext(a) ?: "��"}")
	println("b:${getNext(b) ?: "��"}")
	println("c:${getNext(c) ?: "��"}")
	println("d:${getNext(d) ?: "��"}")
	println("e:${getNext(e) ?: "��"}")
	println("f:${getNext(f) ?: "��"}")
	println("g:${getNext(g) ?: "��"}")
	println("h:${getNext(h) ?: "��"}")
	println("i:${getNext(i) ?: "��"}")
}

fun <T> getNext(node: BinaryTreeNodeWithFather<T>): T? {
	if (node.mRight == null) {
		if (node.mFather != null) {
			if (node.mFather!!.mLeft === node) {
				return node.mFather?.mValues
			} else {
				var nNode = node
				while (nNode.mFather!!.mFather != null) {
					if (nNode.mFather!!.mFather!!.mLeft === nNode.mFather) {
						return nNode.mFather!!.mFather!!.mValues
					}
					nNode = nNode.mFather!!
				}
				return null
			}
		} else {
			return null
		}
	} else {
		var right = node.mRight
		while (right!!.mLeft != null) {
			right = right.mLeft
		}
		return right.mValues
	}
}