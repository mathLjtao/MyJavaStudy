package ljtao.soft.search_from_file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
    搜索查询文件
    跟windows的查询结果数量可能不一样，主要windows系统的查询有一些特殊的功能
 */
public class SearchFile {
    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        System.out.println("-------开始时间："+l+"------");
        //File file=new File("D:\\test\\ljtao");
        File file=new File("E:\\");
        File[] files = file.listFiles();
        List<String> resultList=new ArrayList<>();

        searchFiles(files,"target",true,resultList);
        System.out.println("查询结果："+resultList.size()+",耗时："+(System.currentTimeMillis()-l));
        System.out.println("-------结束时间："+System.currentTimeMillis()+"------");
    }
    /*
    path 从哪个路径开始
    searchText 文件名包含的字段
    isFile 是否为文件夹，true为只搜索文件，false会搜索文件夹跟文件名
    resultList 结果集
    */
    public static void searchFiles(File[] files, String searchText, boolean isFile, List<String> resultList){
        if(files==null || files.length<1){
            return;
        }
        for(File f:files){
            String name = f.getName();
            if(isFile){
                if(f.isFile() && f.getName().toLowerCase().indexOf(searchText)!=-1){
                    System.out.println(f.getAbsolutePath());
                    resultList.add(f.getAbsolutePath());
                }
            }
            else if(f.getName().toLowerCase().indexOf(searchText)!=-1){
                System.out.println(f.getAbsolutePath());
                resultList.add(f.getAbsolutePath());
            }
            //如果是文件夹进入递归
            if(f.isDirectory()){
                searchFiles(f.listFiles(),searchText,isFile,resultList);
            }
        }
    }


}
