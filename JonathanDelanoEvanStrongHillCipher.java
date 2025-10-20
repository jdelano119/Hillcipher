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

        int temp = d;

        d = (a * xgcd) % 26;
        a = (temp * xgcd) % 26;
        b = (-b * xgcd) % 26;
        c = (-c * xgcd) % 26;

        return encryptionKey;
    }

   int[] encrypt(int[] plaintext, int[][] encryptionKey) {
    
    int length = plaintext.length;
    int[] ret = new int[length];

    for (int i = 0; i < length; i += 2) {
        int p1 = plaintext[i];
        int p2;

        if (i + 1 < length){
            p2 = plaintext[i + 1];
        }
        else{
            p2 = 25;
        }

        ret[i]     = (encryptionKey[0][0] * p1 + encryptionKey[0][1] * p2) % 26;

        if(i + 1 < length){
        ret[i + 1] = (encryptionKey[1][0] * p1 + encryptionKey[1][1] * p2) % 26;
        }
    }

    return ret;
}

    int[] decrypt(int[] cipher, int[][] decryptionKey){
        int length = cipher.length;
        int[] ret = new int[length];

        for(int i = 0; i < length; i+=2){
            int p1 = cipher[i];
            int p2 = cipher[i + 1];
            ret[i]     = (decryptionKey[0][0] * p1 + decryptionKey[0][1] * p2) % 26;
            ret[i + 1] = (decryptionKey[1][0] * p1 + decryptionKey[1][1] * p2) % 26;
        }

        
        return ret;
    }

       public static void main (String[] args){
        JonathanDelanoEvanStrongHillCipher hillCipher = new JonathanDelanoEvanStrongHillCipher();

        int[][] encryptionKey = {
            {16, 9},
            {7, 14}
        };
        String plaintext = "JMUISCOOL";
        int[] plaintextNums = new int[plaintext.length()];
        for (int i = 0; i < plaintext.length(); i++){
            plaintextNums[i] = plaintext.charAt(i);
        }

        int[] cipherNums = hillCipher.encrypt(plaintextNums, encryptionKey);

        int[][] decryptionKey = hillCipher.findDecryptionKey(encryptionKey);

        int[] decryptNums = hillCipher.decrypt(cipherNums, decryptionKey);


        System.out.print("Encryption: ");
        for (int i = 0; i < cipherNums.length; i++) {
        System.out.print(cipherNums[i]);
        }
        System.out.println();

        System.out.print("Decryption: ");
        for (int i = 0; i < decryptNums.length; i++) {
        System.out.println(decryptNums[i]);
        }
        System.out.println();



    }

}