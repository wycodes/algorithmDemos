package com.wycodes.fileplay;

import java.io.File;

public class SimpleFileUtils {

    /**
     * 通过递归获得某个文件夹下所有的文件名并输出
     */

    public static String fix="-";

    public static void getFileName(File file,String prefix){
        if (file.isFile()){
            System.out.println(prefix+file.getPath());
        }else {
            File[] files = file.listFiles();
            System.out.println(fix+prefix+file.getPath());
            for (File els : files) {
                getFileName(els,prefix+fix);
            }
        }
    }

    public static void main(String[] args) {
        SimpleFileUtils.getFileName(new File("E:\\san12\\san12game"),"-");
    }
}
