import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdventSolver {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/InputFile");
        //Part 1:
        System.out.println(multiply(mulVals(fileData)));

        //Part 2:
        System.out.println(multiply(mulVals2(fileData)));
    }

    public static int multiply (ArrayList<String> mulVals){
        int[] nums = new int[mulVals.size()];
        for (int i = 0; i<mulVals.size();i++){
            String val = mulVals.get(i);
            int mult1 = Integer.parseInt(val.substring(val.indexOf("(")+1,val.indexOf(",")));
            int mult2 = Integer.parseInt(val.substring(val.indexOf(",")+1,val.indexOf(")")));
            nums[i] = mult1*mult2;
        }
        int total = 0;
        for (int num:nums){
            total+=num;
        }
        return total;
    }

    public static ArrayList<String> mulVals (ArrayList<String> fileData){
        String data = fileData.getFirst();
        ArrayList<String> muls = new ArrayList<String>();
        for (int i = 0; i<data.length();i++){
            if (data.startsWith("mul(", i)&& data.charAt(i + 7) == ')'){
                if(data.substring(i,i+8).contains(",")) {
                    muls.add(data.substring(i, i + 8));
                }
            }
            else if(data.startsWith("mul(", i)&& data.charAt(i + 8) == ')'){
                if(data.substring(i,i+9).contains(",")) {
                    muls.add(data.substring(i, i + 9));
                }
            }
            else if(data.startsWith("mul(", i)&& data.charAt(i + 9) == ')'){
                if(data.substring(i,i+10).contains(",")) {
                    muls.add(data.substring(i, i + 10));
                }
            }else if(data.startsWith("mul(", i)&& data.charAt(i + 10) == ')'){
                if(data.substring(i,i+11).contains(",")) {
                    muls.add(data.substring(i, i + 11));
                }
            }else if(data.startsWith("mul(", i)&& data.charAt(i + 11) == ')'){
                if(data.substring(i,i+12).contains(",")) {
                    muls.add(data.substring(i, i + 12));
                }
            }
        }
        return muls;
    }

    public static ArrayList<String> mulVals2 (ArrayList<String> fileData){
        String data = fileData.getFirst();
        ArrayList<String> muls = new ArrayList<String>();
        boolean add = true;
        for (int i = 0; i<data.length();i++) {
            if (data.startsWith("do()", i)){
                add = true;
            }else if(data.startsWith("don't()", i)){
                add = false;
            }
            if (data.startsWith("mul(", i) && data.charAt(i + 7) == ')' && add) {
                if (data.substring(i, i + 8).contains(",")) {
                    muls.add(data.substring(i, i + 8));
                }
            } else if (data.startsWith("mul(", i) && data.charAt(i + 8) == ')' && add) {
                if (data.substring(i, i + 9).contains(",")) {
                    muls.add(data.substring(i, i + 9));
                }
            } else if (data.startsWith("mul(", i) && data.charAt(i + 9) == ')'&& add) {
                if (data.substring(i, i + 10).contains(",")) {
                    muls.add(data.substring(i, i + 10));
                }
            } else if (data.startsWith("mul(", i) && data.charAt(i + 10) == ')'&& add) {
                if (data.substring(i, i + 11).contains(",")) {
                    muls.add(data.substring(i, i + 11));
                }
            } else if (data.startsWith("mul(", i) && data.charAt(i + 11) == ')'&& add) {
                if (data.substring(i, i + 12).contains(",")) {
                    muls.add(data.substring(i, i + 12));
                }
            }
        }
        return muls;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.isEmpty())
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}