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

    static int mod26(int x) {
         int r = x % 26; 
         return r < 0 ? r + 26 : r; 
        }


    int[][] findDecryptionKey(int[][] encryptionKey){
        int a = encryptionKey[0][0];
        int b = encryptionKey[0][1];
        int c = encryptionKey[1][0];
        int d = encryptionKey[1][1];

        int det = mod26(a * d - b * c);
        int detInv = xgcd(det, 26);

        int[][] inv = new int[2][2];
        inv[0][0] = mod26(detInv * d);
        inv[0][1] = mod26(detInv * (-b));
        inv[1][0] = mod26(detInv * (-c));
        inv[1][1] = mod26(detInv * a);

        for(int i=0; i < inv.length; i++){
            for (int j=0; j < inv.length; j++){
                //System.out.println("J" + inv[i][j]);
            }
        }

        return inv;


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

        ret[i]     = mod26(encryptionKey[0][0] * p1 + encryptionKey[0][1] * p2);
        if (i + 1 < length) {
            ret[i + 1] = mod26(encryptionKey[1][0] * p1 + encryptionKey[1][1] * p2);
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
            ret[i]     = mod26(decryptionKey[0][0] * p1 + decryptionKey[0][1] * p2);
            ret[i + 1] = mod26(decryptionKey[1][0] * p1 + decryptionKey[1][1] * p2);

        }

        
        return ret;
    }

       public static void main (String[] args){
        JonathanDelanoEvanStrongHillCipher hillCipher = new JonathanDelanoEvanStrongHillCipher();


        System.out.println("Decryption Key: 8, 19");
        System.out.println("                9, 24");

        int[][] encryptionKey = {
            {16, 9},
            {7, 14}
        };
        String plaintext = "JMUISCOOL";
        String toDecrypt = "MQGVGQSMJI";
        int[] plaintextNums = new int[plaintext.length() + (plaintext.length() % 2)]; 
        for (int i = 0; i < plaintext.length(); i++){
            plaintextNums[i] = plaintext.charAt(i) - 'A'; 
        }
        if ((plaintext.length() % 2) == 1) {
            plaintextNums[plaintextNums.length - 1] = 25; 
        }

        int[] toDecryptNums = new int[toDecrypt.length() + (toDecrypt.length() % 2)]; 
        for (int i = 0; i < toDecrypt.length(); i++){
            toDecryptNums[i] = toDecrypt.charAt(i) - 'A'; 
        }
        if ((toDecrypt.length() % 2) == 1) {
        toDecryptNums[toDecryptNums.length - 1] = 25; // 'Z'
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
        System.out.print(toDecryptNums[i]);
        }
        System.out.println();


        System.out.print("Encryption: ");
        for (int v : cipherNums) System.out.print((char) ('A' + mod26(v)));
        System.out.println();

        System.out.print("Decryption: ");
        for (int v : toDecryptNums) System.out.print((char) ('A' + mod26(v)));
        System.out.println();



    }

}