import java.io.IOException;
import java.nio.ByteBuffer;

public class MerkleTree extends MerkleTreeBuilder {
	public final static int MAX_NO_OF_SEGMENTS = 1 << 30; // Max nodes in hashMap
//	private final static char COMMA_DELIMETER = ',';
//	private final static char NEW_LINE_DELIMETER = '\n';
//	private final static int ROOT_NODE = 0;
	private final static int BINARY_TREE = 2;

	private final int noOfChildren;
	private final int internalNodesCount;
	private final int bucketsCount;
	private final int height;
	
	public MerkleNode[] merkleNodes; 
	
	public MerkleTree(int noOfSegments) {
		this.noOfChildren = BINARY_TREE;
		this.bucketsCount = getValidSegmentsCount(noOfSegments);
		this.height = height(this.bucketsCount, noOfChildren);
		this.internalNodesCount = getNoOfNodes((height - 1), noOfChildren);
	}
	
	public void rebuildCompleteTree() throws IOException {
		//TODO
		
	}
	
	public static int height(int noOfLeaves, int k) {
		int height = -1;
		while (noOfLeaves > 0) {
			noOfLeaves /= k;
			height++;
		}
		return height;
	}
	
	public static int getNoOfNodes(int h, int k) {
		int result = (((int) Math.pow(k, h + 1)) - 1) / (k - 1);
		return result;
	}
	
	private static int getValidSegmentsCount(int noOfSegments) {
		return ((noOfSegments > MAX_NO_OF_SEGMENTS) || (noOfSegments < 0)) ? MAX_NO_OF_SEGMENTS
				: (noOfSegments > 1) ? Integer.highestOneBit((noOfSegments - 1) << 1) : 1;
	}
}
