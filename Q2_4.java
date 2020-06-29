import java.util.HashMap;
public class Q2_4 {
    // leetcode 904  https://leetcode-cn.com/problems/fruit-into-baskets/
    public static void main(String[] args) {

    }

    public int totalFruit(int[] tree) {
        int n = tree.length;
        int max = 0;
        int wr = 0;
        int wl = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(;wr<n;wr++){
            map.put(tree[wr],map.getOrDefault(tree[wr],0)+1);
            while(map.size()>2){
                if(map.get(tree[wl])>0){
                    map.put(tree[wl],map.get(tree[wl])-1);
                }
                if(map.get(tree[wl]) == 0)
                        map.remove(tree[wl]);
                wl++;
            }
            int c = 0;
            //System.out.println(c);
            max = Math.max(wr-wl+1,max);
        }
        return max;
    }
}