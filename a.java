import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.*;

/*AUTHOR - ELDIIAR DZHUNUSOV */

public class a {
    static int mod= 1000000007 ;
    static final FastReader in = new FastReader();
    static final PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        long t = 1;
        for (long i = 1; i <= t; i++) {
            new Solver();
        }
        out.flush();
        out.close();

    }
    static class Solver{
        Solver(){
            long  a = in.nextLong();
            long b = in.nextLong();
            long c = in.nextLong();
            long ans = lBinSearch(0,a+b+c+1,a,b,c);
            out.println(ans);


        }
    }


//        Collections.sort(arrayList);
//        sort 1d
//        sort(arr, 0, arr.length - 1);
//        Sort 2d by the first index
//        Arrays.sort(arr, Comparator.comparingDouble(o -> o[0]));

    public static long lBinSearch(long l, long r, long... numbers){
        //Assuming that we know that the elements exists there for sure, but we want to find the most optimal one
        //After some point all numbers will be considered as "Good"
        //We need to find most left "Good" number
        while(l<r){
            long m = l + (r-l)/2;
            if(checkerForBinarySearch(numbers[0],numbers[1],numbers[2],m)){
                r = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }
//    public static long rBinSearch(int l, int r, int... numbers){
//        //Assuming that we know that the elements exists there for sure, but we want to find the most optimal one
//        //After some point all numbers will be considered as "Bad"
//        //We need to find most Right "Good" number
//        while(l<r){
//            int m = l + (r-l+1)/2;
//            if(checkerForBinarySearch(numbers)){
//                l = m;
//            }else{
//                r = m-1;
//            }
//        }
//        return l;
//    }

    public static boolean checkerForBinarySearch(long... nums){
//        out.println(Arrays.toString(nums));
        double a = nums[0];
        double b = nums[1];
        double c = nums[2];
        double d = nums[3];
        BigDecimal num1 = BigDecimal.valueOf((a*2 + b*3 + c*4 +d*5));
        BigDecimal num2 = BigDecimal.valueOf(a+ b + c + d);

        num1 = num1.divide(num2, MathContext.DECIMAL128);
//        System.out.println(num1);
        return num1.compareTo(BigDecimal.valueOf(3.5))>=0;
//        out.println(div1 + " " + nums[3]);
//
//        return Double.compare(((a*2 + b*3 + c*4 +d*5)/ (a+ b + c + d)),3.5)>=0;

    }
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    static boolean isPrime(long n) {
        if(n==1)return false  ;
        for(long i = 2L; i*i <= n ;i++){ if(n% i ==0){return false; } }
        return true ;
    }
    static boolean isPrime(int n) {
        if(n==1)return false  ;
        for(int i = 2; i*i <= n ;i++){ if(n% i ==0){return false ; } }
        return true ;
    }

    public static int gcd(int a, int b )
    {
        if(b==0)return a ;else return gcd(b,a%b) ;
    }
    public static long gcd(long a, long b )
    {
        if(b==0)return a ;else return gcd(b,a%b) ;
    }

    static boolean isPower(int n, int p){
        if(p==0) return n==1;
        return (Double.compare(Math.pow(n,1.0/p),(int)Math.pow(n,1.0/p))==0);
    }
    static boolean isPower(long n, long p){
        if(p==0L) return n==1L;
        return (Double.compare(Math.pow(n,1.0/p),(long)Math.pow(n,1.0/p))==0);
    }

    public static long nCr(int n,int k) {
        long ans=1L;
        k=k>n-k?n-k:k;
        int j=1;
        for(;j<=k;j++,n--)
        {
            if(n%j==0)
            {
                ans*=n/j;
            }else if(ans%j==0)
            {
                ans=ans/j*n;
            }else
            {
                ans=(ans*n)/j;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> allFactors(int n) {
        ArrayList<Integer> list = new ArrayList<>() ;

        for(int i = 1; i*i <= n ;i++)
        {
            if( n % i == 0)
            {
                if(i*i == n)list.add(i) ;
                else{ list.add(i) ;list.add(n/i) ; }
            }
        }

        return list ;
    }


    public static ArrayList<Long> allFactors(long n) {
        ArrayList<Long> list = new ArrayList<>() ;

        for(long i = 1L; i*i <= n ;i++)
        {
            if( n % i == 0)
            {
                if(i*i == n) list.add(i) ;
                else{  list.add(i) ; list.add(n/i) ; }

            }
        }

        return list ;
    }
    public static void reverseArray(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
