import java.io.IOException;
import java.nio.ByteBuffer;

public class MerkleTreeBuilder {
	
	private int noOfBuckets = 5;
	
	public MerkleBuckets treeDataNodes = new MerkleBuckets();
	
	public void hashPut(ByteBuffer key, ByteBuffer value) throws IOException {
		int bucketId = getBucketId(key.array());
		ByteBuffer digest = ByteBuffer.wrap(sha1(value.array()));
		this.treeDataNodes.putBucketNodeData(bucketId, key, digest);
	}
	
	public int getBucketId(byte[] key) {
	    int hcode = ByteBuffer.wrap(key).hashCode();
	    return hcode & (noOfBuckets - 1);
	}
	
	public byte[] sha1(byte[]  value) {
		// TODO Hashing Function
		return value;
	}
}
