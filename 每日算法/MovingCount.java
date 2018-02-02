

public class Main {
    public int movingCount(int threshold, int rows, int cols){
        int[][]map = new int[rows][cols];
        int res = getNumOfCheck(map,0,0,threshold);
//        for(int i = 0 ; i < map.length ; i++){
//            for(int j = 0 ; j < map[0].length ; j++){
//            	String str = map[i][j] < 0 ? "     " : map[i][j] <10 ? "       " : map[i][j] < 100 ? "    " : map[i][j] < 1000 ? "   " : "  ";
//                System.out.print(str + map[i][j]);
//            }
//            System.out.println();
//        }
        return res;
    }
    int cnt = 1;
    int direction[][] = {{-1,0},{1,0},{0,-1},{0,1}};    // 四个方向的增量
    //统计有效格子数量
    private int getNumOfCheck(int[][] map ,int x ,int y ,int k){
        if (getEachDigit(x) + getEachDigit(y) > k ) {//数位和不合法
            //先将该格子标记为-1不可达状态再返回上一级递归
            map[x][y] = -1;
            return 0;
        }
        int res = 1;    //该格子本身为一个合法路径
        map[x][y] = cnt++;      //将该格子标记为已走过的路径
        //遍历四个方向
        for(int i = 0; i < 4 ; i++){
            int a = x + direction[i][0];     //加上方向增量后的下一级坐标
            int b = y + direction[i][1];
            if(a < 0 || a >= map.length || b < 0 || b  >= map[0].length){
                continue;
            }
            res += map[a][b] == 0 ? getNumOfCheck(map, a, b, k) : 0;
        }
        //遍历完四个方向返回统计到的有效格子数量
        return res;
    }

    //获取每一位上数字之和
    private int getEachDigit(int x){
       int res = 0;
       while(x>0){
           res += x%10;
           x /= 10;
       }
       return res;
    }
    
    public static void main(String[] args){
        int rows = 40,cols = 40,threshold = 18;
        System.out.println(new Main().movingCount(threshold,rows,cols));
    }
}
