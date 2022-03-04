package algorithm34;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  省份数量
 *  有n个城市，其中一些彼此相连，另一些没有相连。如果城市a与城市b直接相连，且城市b与
 *  城市c直接相连，那么城市a与城市c直接相连。
 *  省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。给你一个n x n的矩阵
 *  isConnected，其中isConnected[i][j] = 1表示第i个城市与第j个城市直接相连，而
 *  isConnected[i][j] = 0表示二者不直接相连。
 *  返回矩阵中省份的数量。
 *
 *  扩展：朋友圈问题，亲戚问题
 *
 *  入参是一个二维数组，出参是一个数字。
 *
 *
 *   2:   1  -------- 2
 *             3
 *
 *   3:  1          2
 *           3
 * */
public class NumberOfProvinces {

    public static void main(String[] args){
//        System.out.println(getProvince(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
//        System.out.println(getProvince(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
        System.out.println(bfs(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(bfs(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }

    public static int getProvince(int[][] citysConnected){
        int citys = citysConnected.length;
        boolean[] visited = new boolean[citys];
        int provinces = 0;//计数器
        // 时间复杂度考虑的是极限的情况 最最极限的情况是每个城市都是独立的 有多少个城市就有多少个省份
        //所以时间复杂度是O(n)
        //空间复杂度为O(n+n) = O(2n) 也就是O(n) visited是O(n) 还会用到一个递归栈也是O(n) 所以二者加和O(2n)
        for(int i = 0;i<citys;i++){
            if(!visited[i]){
                //深度优先遍历
                dfs(i,citys,visited,citysConnected);
                provinces++;
            }
        }
        return provinces;
    }

    //这里也有一个for循环 时间复杂度为O(n) 整个时间复杂度为O(n^2)
    private static void dfs(int i, int citys, boolean[] visited, int[][] citysConnected) {
        for(int j = 0;j<citys;j++){
            if(citysConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(i,citys,visited,citysConnected);
            }
        }
    }

    //广度优先遍历
    public static int bfs(int[][] citysConnected){
        int citys = citysConnected.length;
        boolean[] visited = new boolean[citys];
        int provinces = 0;//计数器
        Queue<Integer> queue = new LinkedList<Integer>();
        // 时间复杂度考虑的是极限的情况 最最极限的情况是每个城市都是独立的 有多少个城市就有多少个省份
        for(int i = 0;i<citys;i++){
            if(!visited[i]){
                queue.offer(i);
                while (!queue.isEmpty()){
                    int k = queue.poll();
                    visited[k] = true;
                    for(int j = 0;j<citys;j++){
                        if(citysConnected[i][j] == 1 && !visited[j]){
                            queue.offer(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }

}
