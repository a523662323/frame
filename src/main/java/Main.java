import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        A1002();
    }

    public static int[] getNextInt(int num){
        int index = 0;
        int[] strs = new int[num];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            if (scan.hasNextInt()){
                strs[index++] = scan.nextInt();
            }
        }
        return strs;
    }
    public static int getNextInt() {
        int next = 0;
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            next = scan.nextInt();
        }
        return next;
    }

    public static String[] getNextStrings(int num) {
        int index = 0;
        String[] strs = new String[num];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            if (scan.hasNext()){
                strs[index++] = scan.next();
            }
        }
        return strs;
    }
    public static String getNext() {
        String next = "";
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            next = scan.next();
        }
        return next;
    }

    private static void A1002(){
        int[] firstline=getNextInt(4);
        int N=firstline[0];
        int M=firstline[1];
        int res=firstline[2];
        int des=firstline[3];
        int[] persons=getNextInt(N);
        int[][] pathsMap=new int[N][N];
        for (int i = 0; i < pathsMap.length; i++) {
            for (int j = 0; j < pathsMap[i].length; j++) {
                if (i==j)
                    continue;
                pathsMap[i][j]=-1;
            }
        }
        for (int i = 0; i < M; i++) {
            int[] nextInt = getNextInt(3);
            pathsMap[nextInt[0]][nextInt[1]]=nextInt[2];
            pathsMap[nextInt[1]][nextInt[0]]=nextInt[2];
        }
        boolean[] visited={false,false,false,false,false,false};
        int num=N;
        int[] distances=new int[N];
        //how many shortestpath
        int[] ways=new int[N];
        //max people get
        int[] total=new int[N];
        for (int i = 0; i < N; i++) {
            if (i==res)
                continue;
            distances[i]=-1;
        }
        ways[res]=1;
        total[res]=1;
        while (num>0){
            int index=0;
            int temp=0;
            for (int i = 0; i < visited.length; i++) {
                if(!visited[i]){
                    index=i;
                    temp=distances[i];
                    break;
                }
            }
            //get smallest
            for (int j = 0; j < distances.length; j++) {
                if (!visited[j]&&distances[j]>=0&&distances[j]<temp){
                    index=j;
                    temp=distances[j];
                }
            }

            //update distances
            for (int i = 0; i < pathsMap[index].length; i++) {
                if(pathsMap[index][i]>0&&!visited[i]){
                    if((distances[index]+pathsMap[index][i])<distances[i]||distances[i]<0){
                        distances[i]=distances[index]+pathsMap[index][i];
                        ways[i]=ways[index];
                        total[i]=total[index]+persons[i];
                    }else if((distances[index]+pathsMap[index][i])==distances[i]){
                        ways[i]=ways[i]+1;
                        if(total[i]<(total[index]+persons[i])){
                            total[i]=total[index]+persons[i];
                        }

                    }
                }
            }

            //remove index
            visited[index]=true;
            num--;
        }
        out.println(ways[des]+" "+total[des]);
    }
    private static void A1002shortestpath(){
        int[][] pathsMap = {{0,1,1,-1,-1,7},{1,0,-1,3,-1,-1},{1,-1,0,3,5,-1},{-1,3,3,0,-1,2},{-1,-1,5,-1,0,3},{7,-1,-1,2,3,0}};
        boolean[] visited={false,false,false,false,false,false};
        int num=6;
        int[] distances={0,-1,-1,-1,-1,-1};
        int[] ways={1,0,0,0,0,0};
        int[] persons={1,2,1,2,1,3};
        int[] total={1,0,0,0,0,0};
        while (num>0){
            int index=0;
            int temp=0;
            for (int i = 0; i < visited.length; i++) {
                if(!visited[i]){
                    index=i;
                    temp=distances[i];
                    break;
                }
            }
            //get smallest
            for (int j = 0; j < distances.length; j++) {
                if (!visited[j]&&distances[j]>=0&&distances[j]<temp){
                    index=j;
                    temp=distances[j];
                }
            }

            //update distances
            for (int i = 0; i < pathsMap[index].length; i++) {
                if(pathsMap[index][i]>0&&!visited[i]){
                    if((distances[index]+pathsMap[index][i])<distances[i]||distances[i]<0){
                        distances[i]=distances[index]+pathsMap[index][i];
                        ways[i]=ways[index];
                        total[i]=total[index]+persons[i];
                    }else if((distances[index]+pathsMap[index][i])==distances[i]){
                        ways[i]=ways[i]+1;
                        if(total[i]<(total[index]+persons[i])){
                            total[i]=total[index]+persons[i];
                        }

                    }
                }
            }

            //remove index
            visited[index]=true;
            num--;
        }

    }

    private static void A1002BackUp() {

        //test git
        Scanner scan = new Scanner(System.in);
        int numbers = 5;
        int roadnumbers = 0;
        int statIndex = 0;
        int endIndex = 0;
        int count = 0;
//        if (scan.hasNextInt()) {
//            numbers = scan.nextInt();
//        }
//        if (scan.hasNextInt()) {
//            roadnumbers = scan.nextInt();
//        }
//        if (scan.hasNextInt()) {
//            statIndex = scan.nextInt();
//        }
//        if (scan.hasNextInt()) {
//            endIndex = scan.nextInt();
//        }
//        int[][] pathsMap = new int[numbers][numbers];
        int[][] pathsMap = {{0,10,3,-1,-1},{-1,0,1,2,-1},{-1,4,0,8,2},{-1,-1,-1,0,7},{-1,-1,-1,9,0}};
        int[][] shortestPath = {{0,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1}};


        List<Integer> sortedSeq = new ArrayList<Integer>();
        List<Integer> leftSeq = new ArrayList<Integer>();
        List<Integer> distances = new ArrayList<Integer>();
        List<Integer> distancesTemp = new ArrayList<Integer>();

        for (int i = 0; i < pathsMap[statIndex].length; i++) {
//            distances.add(pathsMap[statIndex][i]);
            distances.add(-1);
        }
        distances.set(0,0);
        for (int i = 0; i < numbers; i++) {
            leftSeq.add(i);
        }

        //get min index;
        while (leftSeq.size() > 0) {
            //get min from distances
            int temp = distances.get(leftSeq.get(0));
            int index = leftSeq.get(0);
            int k =0;
            for (int i = 0; i < leftSeq.size(); i++) {
                if (distances.get(leftSeq.get(i))>=0&&distances.get(leftSeq.get(i)) < temp) {
                    temp = distances.get(leftSeq.get(i));
                    index = leftSeq.get(i);
                    k=i;
                }
            }

            //update distances
            for (int i = 0; i < pathsMap[index].length; i++) {
                if (i == index)
                    continue;
                int i1 = pathsMap[index][i] + distances.get(index);
                Integer integer = distances.get(i);
                //find beside nodes
                if (pathsMap[index][i] > 0 && ((i1 < integer)||integer<0)) {
                    distances.set(i, i1);
                    //i=index+ pathsMap[index][i] add i point to shortest path maps
                    for (int j = 0; j < shortestPath[index].length; j++) {
                        if(shortestPath[index][j]==-1){
                            shortestPath[i][j]=i;
                            break;
                        }
                        shortestPath[i][j]=shortestPath[index][j];
                    }
                }
            }
            sortedSeq.add(index);
            leftSeq.remove(k);
        }
    }

    private static void A1001() {
        //1000 -1
        int index = 0;
        String[] strs = new String[2];
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            strs[0] = scan.next();
        }
        if (scan.hasNext()) {
            strs[1] = scan.next();
        }
        Integer i = Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]);
        String res = i.toString();
        String bef = "";
        if (i < 0) {
            bef = "-";
            res = res.substring(1, res.length());
        }
        String end = "";
        if (res.length() > 3) {
            for (int j = 0; j < res.length(); j++) {
                end = res.charAt(res.length() - j - 1) + end;
                if (j % 3 == 2) {
                    end = "," + end;
                }
            }
            if (end.charAt(0) == ',') {
                end = end.substring(1, end.length());
            }
            end = bef + end;
            out.println(end);
            return;
        }
        out.println(i);
    }


    private static void T1002() {
        String[] nextStrings = getNextStrings(getNextInt());
        int[][][] c = new int[10][100][100];
        int[][][] current = new int[1][1][1];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                for (int k = 0; k < c[i][j].length; k++) {
                }
            }
        }
    }

    private static void B1004() {
        int num = getNextInt();

    }

    private static void B1002() {
        int sum = 0;
        String next = getNext();
        for (char s : next.toCharArray()) {
            sum += s - 48;
        }
        formatOut(sum);
    }

    private static void formatOut(Integer num) {
        String[] nums = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};
        String outputs = "";
        for (char s : num.toString().toCharArray()
                ) {
            outputs += nums[s - 48] + " ";
        }

        outputs = outputs.substring(0, outputs.length() - 1);
        out.println(outputs);
    }

    private static void B1001() {
        int count = 0;
        int next = getNextInt();
        while (next > 1) {
            if (next % 2 == 0) {
                next = next / 2;
                count++;
            } else {
                next = (3 * next + 1) / 2;
                count++;
            }
        }

        out.println(count);
    }



    private static void shortestPath(int num) {
        Scanner scan = new Scanner(System.in);
        int numbers = 5;
        int roadnumbers = 0;
        int statIndex = 0;
        int endIndex = 0;
        int count = 0;
//        if (scan.hasNextInt()) {
//            numbers = scan.nextInt();
//        }
//        if (scan.hasNextInt()) {
//            roadnumbers = scan.nextInt();
//        }
//        if (scan.hasNextInt()) {
//            statIndex = scan.nextInt();
//        }
//        if (scan.hasNextInt()) {
//            endIndex = scan.nextInt();
//        }
//        int[][] pathsMap = new int[numbers][numbers];
        int[][] pathsMap = {{0,10,3,-1,-1},{-1,0,1,2,-1},{-1,4,0,8,2},{-1,-1,-1,0,7},{-1,-1,-1,9,0}};
        int[][] shortestPath = {{0,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1}};


        List<Integer> sortedSeq = new ArrayList<Integer>();
        List<Integer> leftSeq = new ArrayList<Integer>();
        List<Integer> distances = new ArrayList<Integer>();
        List<Integer> distancesTemp = new ArrayList<Integer>();

        for (int i = 0; i < pathsMap[statIndex].length; i++) {
//            distances.add(pathsMap[statIndex][i]);
            distances.add(-1);
        }
        distances.set(0,0);
        for (int i = 0; i < numbers; i++) {
            leftSeq.add(i);
        }

        //get min index;
        if (leftSeq.size() > 0) {
            //get min from distances
            int temp = distances.get(leftSeq.get(0));
            int index = leftSeq.get(0);
            int k =0;
            for (int i = 0; i < leftSeq.size(); i++) {
                if (distances.get(leftSeq.get(i))>=0&&distances.get(leftSeq.get(i)) < temp) {
                    temp = distances.get(leftSeq.get(i));
                    index = leftSeq.get(i);
                    k=i;
                }
            }

            //update distances
            for (int i = 0; i < pathsMap[index].length; i++) {
                if (i == index)
                    continue;
                int i1 = pathsMap[index][i] + distances.get(index);
                Integer integer = distances.get(i);
                //find beside nodes
                if (pathsMap[index][i] > 0 && ((i1 < integer)||integer<0)) {
                    distances.set(i, i1);
                    //i=index+ pathsMap[index][i] add i point to shortest path maps
                    for (int j = 0; j < shortestPath[index].length; j++) {
                        if(shortestPath[index][j]==-1){
                            shortestPath[i][j]=i;
                            break;
                        }
                        shortestPath[i][j]=shortestPath[index][j];
                    }
                }
            }
            sortedSeq.add(index);
            leftSeq.remove(k);


        }
    }
}
