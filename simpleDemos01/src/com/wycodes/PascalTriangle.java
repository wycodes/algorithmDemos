package com.wycodes;

public class PascalTriangle {
    public static void main(String[] args) {
        playTriangleNum(10);
    }

    /**
     * 杨辉三角
     * 思路:先赋值，再绘图
     * @param lineNum 总行数
     */
    public static void playTriangleNum(int lineNum){
        /**
         * 创建一个二维数组，进行赋值
         */
        int [][] nums=new int[lineNum+1][lineNum+2];
        for (int n=1;n<=lineNum;n++) {
            if (n == 1) {
                nums[1][1] = 1;
            } else {
                for (int x = 1; x <= n; x++) {
                    nums[n][1] = 1;
                    nums[n][n] = 1;
                    nums[n][x] = nums[n - 1][x - 1] + nums[n - 1][x];
                }
            }
        }
        /**
         * 准备绘图数据
         */
        int maxPosition = testMaxPosition(nums);
        for (int n=1;n<=lineNum;n++) {
            /**
             * 绘制空格
             */
            for (int spaceNum=0;spaceNum<lineNum-n;spaceNum++){
                System.out.print(" ");
            }
            /**
             * 绘制数字
             */
            for (int starNum=1;starNum<=n;starNum++){
                /**
                 * 取出二维数组的每一项，输出
                 */
                int singleNum = nums[n][starNum];
                int nextSingleNum = nums[n][starNum+1];
                System.out.print(singleNum);
                /**
                 * 计算这个数后面该放几个空格才能对齐，输出空格
                 */
                int numFollowSp=0;
                if (starNum<n){
                    if (testNumPosition(nextSingleNum) > testNumPosition(singleNum)){
                        numFollowSp=maxPosition - testNumPosition(singleNum);
                    }else {
                        numFollowSp=maxPosition - testNumPosition(singleNum)+1;
                    }
                }
                for (int t=0;t<numFollowSp;t++){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static int testMaxPosition(int [][] nums){
        int len=nums.length-1;
        int max=0;
        if (len%2==0){
            max=nums[len][len/2];
        }else {
            max=nums[len][(len/2)+1];
        }
        String maxStr = String.valueOf(max);
        int pos = maxStr.length();
        return pos;
    }

    public static int testLinePos(int [][] nums,int lineIndex){
        int posSum=0;
        for (int i=1;i<=lineIndex;i++){
            int x = nums[lineIndex][i];
            int singleLen = String.valueOf(x).length();
            posSum=posSum+singleLen;
        }
        return posSum-lineIndex;
    }

    /**
     * 查看这个数字有多少位
     * @param num
     * @return
     */
    public static int testNumPosition(int num){
        return String.valueOf(num).length();
    }
}
