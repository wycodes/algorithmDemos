package com.wycodes.drawplay;

public class PascalTriangleStar {
    public static void main(String[] args) {
        drawStar(3);
    }

    /**
     * 绘制沙漏，这里利用了Math.abs()取绝对值的形式精简代码
     *
     * @param halfHeight 这里的参数为半高
     */
    public static void drawStar(int halfHeight){
        for (int n=halfHeight;n>=(-halfHeight);n--){
            if (n==0){
                n=n-2;
            }
            for (int sp=1;sp<=halfHeight-Math.abs(n);sp++){
                System.out.print(" ");
            }
            for (int st=1;st<=2*Math.abs(n)-1;st++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    /**
     * 绘制菱形，常规写法
     * @param lineNums
     */
    public static void drawTriangleO(int lineNums){
        if (lineNums%2==0){
            drawTriangleA(lineNums/2);
            drawTriangleV(lineNums/2);
        }else {
            int half=(lineNums+1)/2;
            drawTriangleA(half);
            for (int n=2;n<half+1;n++){
                for (int spaceNum=0;spaceNum<n-1;spaceNum++){
                    System.out.print(" ");
                }
                for (int starNum=0;starNum<2*(half-n+1)-1;starNum++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    /**
     * 倒三角
     * @param lineNum
     */
    public static void drawTriangleV(int lineNum){
        for (int n=1;n<=lineNum;n++){
            for (int spaceNum=0;spaceNum<n-1;spaceNum++){
                System.out.print(" ");
            }
            for (int starNum=0;starNum<2*(lineNum-n+1)-1;starNum++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 正三角
     * @param lineNum 总行数
     */
    public static void drawTriangleA(int lineNum){
        //控制总行数
        for (int n=1;n<=lineNum;n++){
            //控制空格个数
            for (int spaceNum=0;spaceNum<lineNum-n;spaceNum++){
                System.out.print(" ");
            }
            //控制星星个数
            for (int starNum=0;starNum<2*n-1;starNum++){
                System.out.print("*");
            }
            //控制换行
            System.out.println();
        }
    }
}
