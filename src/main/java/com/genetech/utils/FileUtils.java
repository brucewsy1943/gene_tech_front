package com.genetech.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/18.
 */
public class FileUtils {

    public static List<String> getFilesInFolder(String path){
        //查找文件夹下的所有文件路径
            List<String> fileNames = new ArrayList<>();
            File file = new File(path);		//获取其file对象
            File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
            for(File f:fs){
                //遍历File[]数组
                if(!f.isDirectory())	{	//若非目录(即文件)，则打印
                    String fileName = f.getName();
                    fileNames.add(f.getName());
                }
            }

       return fileNames;
    }
}
