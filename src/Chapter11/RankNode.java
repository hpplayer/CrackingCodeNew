package Chapter11;

public class RankNode {
	public int left_size = 0;
	public RankNode left;
	public RankNode right;
	public int data = 0;

	public RankNode(int d) {
		this.data = d;
	}

	public void insert(int d) {
		if (d <= data) {
			if (left != null) {
				left.insert(d);// recursively call, if we already have left node
			} else {
				left = new RankNode(d);// if left is null, but d <= data
			}
			left_size++;
		} else {
			if (right != null) {
				right.insert(d);
			} else {
				right = new RankNode(d);
			}
		}
	}

	public int getRank(int d) {
		if (d == data) {
			return left_size;
		} else if (d < data) {
			if (left == null) {
				return -1;// case we dont have such int
			} else {
				return left.getRank(d);// recursive call
			}
		} else {// d on the right, need update
			int right_rank = (right == null ? -1 : right.getRank(d));
			if (right_rank == -1) {
				return -1; //case we dont have right part
			} else {
				return left_size + 1 + right_rank;// in the book example, d is 24, this is 20, 20 may has right node 23 which we need to count, 1 is 20 itself, left_size is node 20's left node size
			}
		}
	}
}
