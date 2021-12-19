import java.io.FileReader;
import java.nio.ByteBuffer;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class Main {

	public static void main(String[] args) {

		CSVReader reader = null;
		
		int noOfBuckets = 16;
		MerkleTree merkleTree = new MerkleTree(noOfBuckets);
		
		try  
		{  
			reader = new CSVReader(new FileReader("./sample.csv"));  
			String[] nextLine = reader.readNext(); // To read header column  
			while ((nextLine = reader.readNext()) != null) {
				System.out.printf("key :"+ nextLine[0]);
				System.out.printf(" value :"+ String.join(",", Arrays.copyOfRange(nextLine, 2, nextLine.length)));
				
				byte[] keyBytes = nextLine[0].getBytes();
				byte[] valueBytes = String.join(",", Arrays.copyOfRange(nextLine, 2, nextLine.length)).getBytes();
				
				merkleTree.hashPut(ByteBuffer.wrap(keyBytes), ByteBuffer.wrap(valueBytes));
				
				System.out.print("\n");
			}
		}
		catch (Exception e) {  
			e.printStackTrace();  
		}
		
		System.out.printf("Bucket Nodes :" + MerkleBuckets.merkleBuckets);
		merkleTree.rebuildCompleteTree();
	}

}
