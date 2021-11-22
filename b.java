import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*AUTHOR - ELDIIAR DZHUNUSOV */

public class b {
    static int mod= 1000000007 ;
    static final FastReader in = new FastReader();
    static final PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        long t = in.nextLong();
        for (long i = 1; i <= t; i++) {
            out.print("Case #"+i+": ");
            new Solver();
        }
        out.flush();
        out.close();

    }
    static class Solver{
        Solver(){
            //insert your code here
            int n = in.nextInt();
            char[] arr1 = in.next().toCharArray();
            ArrayList<Set<Character>> arrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                HashSet<Character> set = new HashSet<>();
                if(arr1[i]=='R' || arr1[i]=='B' || arr1[i]=='Y'){
                    set.add(arr1[i]);
                }else if(arr1[i]=='O'){
                    set.add('R');
                    set.add('Y');
                }else if(arr1[i]=='P'){
                    set.add('R');
                    set.add('B');
                }else if(arr1[i]=='G'){
                    set.add('Y');
                    set.add('B');
                }else if(arr1[i]=='A'){
                    set.add('R');
                    set.add('Y');
                    set.add('B');
                }
                arrayList.add(set);
            }
            //sol
            char[] arr2 = new char[]{'U', 'R', 'Y', 'B', 'O', 'P', 'G', 'A'};
//            int[] arr = new int[8];
            long ans = 0;
            for (int i = 0; i < arr2.length; i++) {
                boolean isContinuous = false;
                int counter = 0;
                for (int j = 0; j < arrayList.size(); j++) {
                    if(arrayList.get(j).contains(arr2[i])){
                        if(!isContinuous){
                            counter++;
                        }
                        isContinuous=true;

                    }else{
                        isContinuous=false;
                    }
                }
//                arr[i] = counter;
                ans+=counter;
            }
//            out.println(Arrays.toString(arr));
            out.println(ans);
        }
    }


//        Collections.sort(arrayList);
//        sort 1d
//        sort(arr, 0, arr.length - 1);
//        Sort 2d by the first index
//        Arrays.sort(arr, Comparator.comparingDouble(o -> o[0]));

    public static int lBinSearch(int l, int r, int... numbers){
        //Assuming that we know that the elements exists there for sure, but we want to find the most optimal one
        //After some point all numbers will be considered as "Good"
        //We need to find most left "Good" number
        while(l<r){
            int m = l + (r-l)/2;
            if(checkerForBinarySearch(numbers)){
                r = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }
    public static int rBinSearch(int l, int r, int... numbers){
        //Assuming that we know that the elements exists there for sure, but we want to find the most optimal one
        //After some point all numbers will be considered as "Bad"
        //We need to find most Right "Good" number
        while(l<r){
            int m = l + (r-l+1)/2;
            if(checkerForBinarySearch(numbers)){
                l = m;
            }else{
                r = m-1;
            }
        }
        return l;
    }

    public static boolean checkerForBinarySearch(int... numbers){
        //Not implemented yeat
        return false;
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
