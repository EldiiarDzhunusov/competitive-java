import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class TDraft {
    public static void main(String[] args) {
        int arr[][] = {{1,2},{3}};
        System.out.println(Arrays.deepToString(arr));
    }
    public int max = 0;
    public int ans = 0;
    public int deepestLeavesSum(TreeNode root) {
        traverseNode(root,1);
        adder(root,1);
        return ans;

    }
    public void adder(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(depth==max-1){
            ans+=root.val;
        }
        traverseNode(root.left,depth+1);
        traverseNode(root.right,depth+1);
    }
    public void traverseNode(TreeNode root, int maxDepth){
        if(root==null){
             if(maxDepth-1>max){
                 max = maxDepth;
             }
             return;
        }
        traverseNode(root.left,maxDepth+1);
        traverseNode(root.right,maxDepth+1);
    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] arr= new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int counter = 0;
            for (int j = 0; j < points.length; j++) {
                if(Math.abs(getDistance(queries[i][0],queries[i][1],points[j][0],points[j][1]))<=queries[i][2]){
                    counter++;
                }
            }
            arr[i]=counter;
        }


        return arr;
    }
    public static double getDistance(int x1,int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
    }


    public static int minPartitions(String n) {
        return n.chars().max().getAsInt()-'0';
    }
    public static int binarySearch(int[] arr,int key, int l,int r){
        int mid = l + (r-l)/2;
        if(arr[mid]==key){
            return mid;
        }else if (l>=r) {
            return -1;
        }else if(arr[mid]>key){
            return binarySearch(arr,key,l,mid);
        }else{
            return binarySearch(arr,key,mid+1,r);
        }

    }
}
// while(ans<n){
//        ans++;
//        n*=2;
//        }