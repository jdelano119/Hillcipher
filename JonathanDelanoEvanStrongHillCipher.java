public int gcd (int inE, int inZ) {
		// TO BE FINISHED
		// Must implement Euclid's algorithm
		// NO brute-forcing; violation will lead to zero points
		// NO recursion; violation will lead to zero points
		int d = inZ;
		int q;
		int g = inE;

		while (g != 0){
			q = d % g;
			d = g;
			g = q;
		}
		return d;
		
	}

	public void testGcd () {
		int result1 = gcd (29, 288);
		int result2 = gcd (30, 288);
		int result3 = gcd (149, 288);
		int result4 = gcd (2, 4);

		System.out.println ("GCD (29, 288) = 0x" + Integer.toString(result1, 16));
		System.out.println ("GCD (30, 288) = 0x" + Integer.toString(result2, 16));
		System.out.println ("GCD (149, 288) = 0x" + Integer.toString(result3, 16));
		System.out.println ("GCD (2, 4) = 0x" + Integer.toString(result4, 16));
	}
	
	//
	// We assume that inE < inZ
	// This implementation follows our slides
	// Return:
	//	-1: no inverse
	//	inverse of inE mod inZ
	//
	public int xgcd(int inE, int inZ) {
    int T = 0;
    int newT = 1;
    int D = inZ;
    int newD = inE;

    while (newD != 0) {
        int q = D / newD;

        int tempD = D - q * newD;
        D = newD;
        newD = tempD;

        int tempT = T - q * newT;
        T = newT;
        newT = tempT;
    }
    if (D != 1) {
        return -1;
    }
    return (T % inZ + inZ) % inZ;
}
public class JonathanDelanoEvanStrongHillCipher {

    
    int[][] findDecryptionKey(int encryptionKey[2][2]){

    }

    int[] encrypt(int plaintext[], int encryptionKey[2][2]){

    }
    int[] decrypt(int ciphertext[], int decryptionKey[2][2]){

    }


}
