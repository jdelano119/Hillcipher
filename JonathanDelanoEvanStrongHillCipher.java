public class JonathanDelanoEvanStrongHillCipher {
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

    int[][] findDecryptionKey(int[][] encryptionKey){

        return new int[2][2];
    }

    int[] encrypt(int[] plaintext, int[][] encryptionKey){
        int[] ret = new int[1];
        return ret;
    }
    int[] decrypt(int[] ciphertext, int[][] decryptionKey){
        int[] ret = new int[1];
        return ret;
    }

}