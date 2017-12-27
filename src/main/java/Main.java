import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        A1002();
    }

    private static void A1002() {
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
        while (scan.hasNext()) {
            strs[index++] = scan.next();
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
