class RBNode {
	long key;
	RBNode left, right, parent;
	String data;
	boolean isRed;

	public RBNode(long keys, String words) {
		key = keys;
		data = words;
		left = null;
		right = null;
		parent = null;
		isRed = false;
	}
}