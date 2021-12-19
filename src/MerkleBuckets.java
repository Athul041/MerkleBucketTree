import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentSkipListMap;

public class MerkleBuckets {
	public static ConcurrentSkipListMap<Integer, ConcurrentSkipListMap<ByteBuffer, ByteBuffer>> merkleBuckets = new ConcurrentSkipListMap<Integer, ConcurrentSkipListMap<ByteBuffer, ByteBuffer>>();
	
	public void putBucketNodeData(int bucketId, ByteBuffer key, ByteBuffer hashValue) {
		if (!merkleBuckets.containsKey(bucketId)) {
			merkleBuckets.putIfAbsent(bucketId, new ConcurrentSkipListMap<ByteBuffer, ByteBuffer>());
		}
		merkleBuckets.get(bucketId).put(key, hashValue);
	}
	
	public ByteBuffer getBucketNodeData(int bucketId, ByteBuffer key) {
		ConcurrentSkipListMap<ByteBuffer, ByteBuffer> bucketNode = merkleBuckets.get(bucketId);
		if (bucketNode != null) {
			ByteBuffer value = bucketNode.get(key);
			return value;
		}
		return null;
	}
}
