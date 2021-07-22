package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분문자_16916 {
    private static int d = 257, result;
    private static Long m = Long.MAX_VALUE;
    private static long firstValue, targetHash, sHash;
    private static long[] pow;
    public static int bSize, sSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String base = br.readLine();
        String part = br.readLine();
        pow = new long[base.length() + 1];
        pow[0] = 1;

        // 거듭제곱 구하기
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * d % m;
        }
        // S의 해시값
        bSize = base.length();
        sSize = part.length();
        if(bSize >= sSize) {
            // 내 해시값 구하기
            sHash = createHash(part);
            targetHash = createHash(base.substring(0,sSize));
            firstValue = base.charAt(0) * pow[sSize-1] % m; // 첫번째 해시값의 첫번째 값 ex) ABCDE -> A

            if(sHash == targetHash) result++;
            for (int i = 1; i <= bSize - sSize; i++) {
                getHash(base.charAt(i), base.charAt(i + sSize - 1));    // 부분 문자열의 해시값
                if (sHash == targetHash){
                    result++;
                    break;
                }
            }
        }

        System.out.println(result != 0 ? 1 : 0);

    }

    private static void getHash(char s, char e) {
        int firstC = (int) s;
        int lastC = (int) e;

        // 첫번째 값을 빼고 d를 곱한 후 마지막 값을 더함
        targetHash -= firstValue;
        targetHash *= d;
        targetHash += (lastC * pow[0]) % m;

        // 첫번째 값 갱신
        firstValue = firstC % m * pow[sSize - 1] % m;
        return;
    }

    private static long createHash(String target){
        long hashValue = 0;
        for (int i = 0, j = sSize - 1; i < sSize; i++, j--) {
            long value = (long) target.charAt(i);
            hashValue += (value * pow[j]) % m;
        }
        return hashValue;
    }
}
