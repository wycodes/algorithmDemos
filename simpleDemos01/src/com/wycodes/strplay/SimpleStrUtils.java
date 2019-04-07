package com.wycodes.strplay;

/**
 * String有trim方法，可以去除左右两边的空格，现在拓展几个方法
 *
 */
public class SimpleStrUtils {

    /**
     * 输出结果如下：
     * 空格不容易识别，以*代替
     * 去除左空格：ab***cd**
     * 去除右空格：***ab***cd
     * 去除中间空格：***abtxcd**
     * 递归去左写法：ab***cd**
     * 递归去右写法：***ab***cd
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("空格不容易识别，以*代替");
        System.out.println("去除左空格："+SimpleStrUtils.matchLeftScan("***ab***cd**"));
        System.out.println("去除右空格："+SimpleStrUtils.matchRightScan("***ab***cd**"));
        System.out.println("去除中间空格："+SimpleStrUtils.matchCenterScan("***ab*t*x*cd**"));
        System.out.println("递归去左写法："+SimpleStrUtils.simpleMatchLeftScan("***ab***cd**"));
        System.out.println("递归去右写法："+SimpleStrUtils.simpleMatchRightScan("***ab***cd**"));
    }

    /**
     * 匹配左边的所有空格，并消除
     * 普通流程控制，用到了数字型标记变量
     * @param str
     * @return
     */
    public static String matchLeftScan(String str){
        if (str.equals("") || str==null || str.length()==0){
            throw new RuntimeException("参数为空！");
        }else {
            StringBuffer buffer = new StringBuffer(str);
            int markStar=0;
            for (int i=0;i<str.length()-1;i++){
                if (buffer.charAt(i)=='*'){
                    markStar++;
                }else {
                    break;
                }
            }
            for (int k=0;k<markStar;k++){
                buffer.deleteCharAt(0);
            }
            return buffer.toString();
        }
    }

    /**
     * 匹配右边所有空格，并消除
     * @param str
     * @return
     */
    public static String matchRightScan(String str){
        StringBuffer buffer = new StringBuffer(str);
        int markStar=0;
        for (int i=str.length()-1;i>0;i--){
            if (buffer.charAt(i)=='*'){
                markStar++;
            }else {
                break;
            }
        }
        for (int k=0;k<markStar;k++){
            buffer.deleteCharAt(buffer.length()-1);
        }
        return buffer.toString();
    }

    /**
     * 仅仅匹配字符串中间的空格，并进行消除
     * @param str
     * @return
     */
    public static String matchCenterScan(String str){
        if (str.equals("") || str==null || str.length()==0){
            throw new RuntimeException("参数为空！");
        }else {
            StringBuffer buffer = new StringBuffer(str);
            StringBuffer left = new StringBuffer(str);
            StringBuffer right = new StringBuffer(str);
            int markLeft=0;
            int markRight=0;
            for (int i=0;i<str.length()-1;i++){
                if (buffer.charAt(i)!='*'){
                    markLeft=i;
                    break;
                }
            }
            String leftStr = left.substring(0, markLeft);
            for (int i=str.length()-1;i>0;i--){
                if (buffer.charAt(i)!='*'){
                    markRight=i;
                    break;
                }
            }
            String rightStr = right.substring(markRight+1, right.length());
            String s = buffer.substring(markLeft, markRight+1);
            String replace = s.replaceAll("\\*", "");
            replace=leftStr+replace+rightStr;
            return replace;
        }
    }

    /**
     * 加入判空与异常处理，且使用递归
     * @param str
     * @return
     */
    public static String simpleMatchLeftScan(String str){
        if (str==null){
            throw new RuntimeException("输入的字符串不能为null");
        }else {
            StringBuffer buffer=new StringBuffer(str);
            if (buffer.charAt(0)=='*'){
                buffer.deleteCharAt(0);
                return simpleMatchLeftScan(buffer.toString());
            }else {
                return buffer.toString();
            }
        }
    }

    /**
     * 不难看出，递归的写法比标记变量更为简洁，代码更加易懂
     * @param str
     * @return
     */
    public static String simpleMatchRightScan(String str){
        StringBuffer buffer=new StringBuffer(str);
        if (buffer.charAt(buffer.length()-1)=='*'){
            buffer.deleteCharAt(buffer.length()-1);
            return simpleMatchRightScan(buffer.toString());
        }else {
            return buffer.toString();
        }
    }
}
