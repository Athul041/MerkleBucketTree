
public class MerkleNode {
	private int NodeId;
	public MerkleNode left;
	public MerkleNode right;
	protected String hashValue;
	private int bucketId;
	private boolean isLeaf = false;
	
	public String getHashValue() {
		return this.hashValue;
	}
	
	public void setHashValue() {
		// TODO
	}
	
	public boolean isLeafNode() {
		return this.isLeaf;
	}
	
	public int getBucketId() {
		return this.bucketId;
	}
	
	public void setBucketId(int bucketId) {
		this.bucketId = bucketId;
	}
	
	public MerkleNode(int key, boolean isLeafNode) {
		this.NodeId = key;
		this.left = null;
		this.right = null;
		this.hashValue = null;
		this.isLeaf = isLeafNode;
	}
}
