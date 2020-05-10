/**
 * @Author : Dylan
 * @Date : 2020/4/7 22:30
 * @Describe :给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class Main51 {
    public int[] multiply(int[] A) {

        if (A == null || A.length == 0){
            return null;
        }
        int n = A.length;
        int[] C = new int[n];
        C[0] = 1;
        for (int i = 1; i < n; i++){
            C[i] = C[i-1]*A[i-1];
        }
        int[] D = new int[n];
        D[n-1] = 1;
        for (int i = n - 2; i >= 0; i--){
            D[i] = D[i+1]*A[i+1];
        }
        int[] B = new int[n];
        for (int i = 0; i < n; i++){
            B[i] = C[i]*D[i];
        }

        return B;
    }
}
