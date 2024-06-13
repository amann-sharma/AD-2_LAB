public class RabinKarp {

    private static final int PRIME = 101; // Prime number for hashing

    // Function to implement Rabin-Karp algorithm
    public static void rabinKarp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int patternHash = createHash(pattern, m);
        int textHash = createHash(text, m);
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && checkEqual(text, pattern, i, i + m - 1)) {
                System.out.println("Pattern found at index " + i);
            }
            if (i < n - m) {
                textHash = recalculateHash(text, i, i + m, textHash, m);
            }
        }
    }

    // Function to create hash value for a string
    private static int createHash(String str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    // Function to recalculate hash value for next window
    private static int recalculateHash(String str, int oldIndex, int newIndex, int oldHash, int patternLen) {
        int newHash = oldHash - str.charAt(oldIndex);
        newHash = newHash / PRIME;
        newHash += str.charAt(newIndex) * Math.pow(PRIME, patternLen - 1);
        return newHash;
    }

    // Function to check if two strings are equal
    private static boolean checkEqual(String text, String pattern, int start, int end) {
        if (end - start + 1 != pattern.length()) return false;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (text.charAt(i) != pattern.charAt(index++)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "ABCCDDAEFG";
        String pattern = "CDD";
        rabinKarp(text, pattern);
    }
}
