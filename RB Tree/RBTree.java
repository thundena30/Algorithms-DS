class RBTree {
	RBNode root;

	RBTree() {
		root = null;
	}

	void inOrderTreeWalk(RBNode x) {
		// if x has value
		if (x != null) {
			// recusive call inOrderTreeWalk on x.left
			inOrderTreeWalk(x.left);
			// then print the x.key 
			System.out.print(x.key + " ");
			// then do it on the right side.
			inOrderTreeWalk(x.right);
		}
	}

	RBNode treeSearch(RBNode x, long k) {
		// if x or x.key == k return x
		if (x == null || k == x.key)
			return x;
			// if k is less then the key
		if (k < x.key)
			// return the results of treeSearch on x.left and k
			return treeSearch(x.left, k);
		else
			// return the results of treeSearch on x.right and k 
			return treeSearch(x.right, k);
	}
	// leftRotate
	void leftRotate(RBNode x) {
		// create antoher node called y and set x.right to it.
		RBNode y = x.right;
		// set x.right to y.left
		x.right = y.left;
		// if y.left is not null set the y.left.parent to x 
		if (y.left != null)
			y.left.parent = x;
		// y parent sets to x.parent	
		y.parent = x.parent;
		// if x.parent equals null
		if (x.parent == null)
		// set the root to y 
			root = y;
		// else if x equals x parent left	
		else if (x == x.parent.left)
		// x parent left is set to y
			x.parent.left = y;
		else
		// otherwise parent right is set to y 
			x.parent.right = y;
		// set y.left = x	
		y.left = x;
		// x parent = y
		x.parent = y;
	}

	void rightRotate(RBNode x) {
		// set new node y to  x left 
		RBNode y = x.left;
		// x left is now y right.
		x.left = y.right;
		// if y right doesn't equal null set y right parent to x
		if (y.right != null)
			y.right.parent = x;
		// y parent set to x parent	
		y.parent = x.parent;
		// if x parent equals null
		if (x.parent == null)
		//root becomes y 
			root = y;
		// else if x equals x.parent right	
		else if (x == x.parent.right)
		// set the right to y
			x.parent.right = y;
		else
		//else set left to y
			x.parent.left = y;
		// y right is now x	
		y.right = x;
		//x parent is now y
		x.parent = y;
	}

	void RBInsert(RBNode z) {
		// y is null and x is the root
		RBNode y = null;
		RBNode x = root;
		// while x has a value
		while (x != null) {
			// set y to x 
			y = x;
			//if z.key is less than x.key
			if (z.key < x.key)
			// x is now the x.left
				x = x.left;
			else
			// otherwise x is now x.right
				x = x.right;
		}
		// set z.parent to y
		z.parent = y;
		// if y is null
		if (y == null)
		// the root is set to z
			root = z;
		// else if z.key less than y.key	
		else if (z.key < y.key)
		 // y.left is set to z 
			y.left = z;
		else
		//else the y.right is set to z 
			y.right = z;
		// set z left and right to null and z.isRed is set to true. 
		// call insertFixUp		
		z.left = null;
		z.right = null;
		z.isRed = true;
		RBInsertFixup(z);
	}

	void RBInsertFixup(RBNode z) {
		RBNode y = null;
		// while z isnt null and z.parent is red
		while (z.parent != null && z.parent.isRed) {
			 // if z.parent equal the z.parent.parent.left (grandparent) 
			if (z.parent == z.parent.parent.left) {
				//set y to the grandparent 
				y = z.parent.parent.right;
				// if y is red and y is not null
				if (y != null && y.isRed) {
					//set the z parent to false, y to false, and the grandparent of z to red
					z.parent.isRed = false;
					y.isRed = false;
					z.parent.parent.isRed = true;
					// set z to grandparent
					z = z.parent.parent;
				}
				// else if z equals the z parent right 
				else if (z == z.parent.right) {
					// set z to parent
					z = z.parent;
					// leftRotate on z
					leftRotate(z);
				} else {
					// set z parent to false set grandparent to true and rotate on the grandparent
					z.parent.isRed = false;
					z.parent.parent.isRed = true;
					rightRotate(z.parent.parent);
				}
			} else {
				// set y to grandparent right
				y = z.parent.parent.right;
				// if its not null and is red
				if (y != null && y.isRed) {
					//set parent to false, y to false and set the grandparent to true.
					z.parent.isRed = false;
					y.isRed = false;
					z.parent.parent.isRed = true;
					// set z to the grandparent.
					z = z.parent.parent;
					// else if z.key equals the parent right key.
				} else if (z.key == z.parent.right.key) {
					//set z to parent
					z = z.parent;
					// rotate right
					rightRotate(z);
				} else {
					//set parent to false grandparent to true and left rotate on the grandparent.
					z.parent.isRed = false;
					z.parent.parent.isRed = true;
					leftRotate(z.parent.parent);
				}
			}
		}
		root.isRed = false;
	}
}