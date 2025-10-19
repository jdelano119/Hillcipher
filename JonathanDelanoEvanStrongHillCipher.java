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
        int a = encryptionKey[0][0];
        int b = encryptionKey[0][1];
        int c = encryptionKey[1][0];
        int d = encryptionKey[1][1];

        int Zed = (a * d)  - (b * c);
        int Zedmod = Zed % 26;
        int xgcd = xgcd(Zedmod, 26);

        d = (a*xgcd) % 26;
        a = (d * xgcd) % 26;
        b = (-b * xgcd) % 26;
        c = (-c * xgcd) % 26;

        return encryptionKey;
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