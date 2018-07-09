import java.util.*;


class Solution{

    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static int m = sc.nextInt();
    static int Graph[][] = new int[n][n];


    private static void display(){
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(Graph[i]));
        }
    }

    private static void initializeGraph(){

        while(m > 0){
            int u = sc.nextInt();
            int v = sc.nextInt();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i+1 == u && j+1 == v){
                        Graph[i][j] = 1;
                    }
                } 
            }
            m--;
        }

    }


    public static void main(String[] args) {

        
        initializeGraph();
        // display();
        int u = sc.nextInt();
        int v = sc.nextInt();

        if(Graph[u-1][v-1] == 1){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }
}