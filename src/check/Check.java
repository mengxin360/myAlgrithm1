package check;
import java.io.*;
import java.util.ArrayList;

//注释
//注释
//注释
//注释
//注释
//注释
/**
 * 注释*/
public class Check {
    public static void main (String[] args) throws IOException{
        check("D:/String.java");
    }
    public static void check (String s) throws IOException{
        int all = 0, empty = 0, describe = -1, i = 0,commentLineNumber=0;
        ArrayList<Integer> commentLineNumberList = new ArrayList<Integer>();
        String str = null;
        File f = new File(s);
        BufferedReader br = new BufferedReader (new FileReader(f));
        str = br.readLine();
        while(str != null){
            commentLineNumber++;
            all++;
            if(str.trim().equals("")) empty++;
            if(str.contains("//")) {
                describe++;
                commentLineNumberList.add(commentLineNumber);
            }
            if(str.contains("/*")){
                while(!str.contains("*/")){
                    i++;
                    all++;
                    describe++;
                    str = br.readLine();
                    commentLineNumberList.add(commentLineNumber);
                }
            }
            str = br.readLine();
        }
        System.out.println("文件有效代码行数为：" + (all-describe-empty));
        System.out.println("文件注释行数：" + describe);
        for(Integer j:commentLineNumberList){
            System.out.println("含有注释的所有行号"+j);
        }
        System.out.println("文件注释行覆盖率：" + (float)describe/all);
    }
}