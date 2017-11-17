import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        A1002();
    }
    private static void A1002() {
        Scanner scan = new Scanner(System.in);
        int numbers=0;
        int roadnumbers=0;
        int statIndex=0;
        int endIndex=0;
        List<Integer> starts=new ArrayList<Integer>();
        if(scan.hasNextInt()){
            numbers=scan.nextInt();
        }
        if (scan.hasNextInt()){
            roadnumbers=scan.nextInt();
        }
        if (scan.hasNextInt()){
            statIndex=scan.nextInt();
        }
        if (scan.hasNextInt()){
            endIndex=scan.nextInt();
        }
        int[][] paths=new int[numbers][numbers];
        while (starts.size()<numbers){
//            paths[statIndex]
        }

    }
    private static void A1001() {
        //1000 -1
        int index = 0;
        String[] strs = new String[2];
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            strs[0] = scan.next();
        }if (scan.hasNext()) {
            strs[1] = scan.next();
        }
        Integer i = Integer.parseInt(strs[0]) + Integer.parseInt(strs[1]);
        String res=i.toString();
        String bef="";
        if(i<0){
            bef="-";
            res=res.substring(1,res.length());
        }
        String end="";
        if(res.length()>3){
            for (int j =0  ; j<res.length() ; j++) {
                end=res.charAt(res.length()-j-1)+end;
                if(j%3==2){
                    end=","+end;
                }
            }
            if (end.charAt(0)==','){
                end=end.substring(1,end.length());
            }
            end=bef+end;
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

}
