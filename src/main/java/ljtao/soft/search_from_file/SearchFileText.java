package ljtao.soft.search_from_file;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.List;

/*
获取某文件夹中所有的文件，
获取文件中的内容，在文件的内容上进行相关搜索
 */
public class SearchFileText {
    private ByteBuffer buffer;

    public static void main(String[] args) throws Exception{
        //只支持记事本能打开不乱码的文件
        //setCond("D:\\工作日记\\2019年\\OA新通用移动模板\\work",".php","edit.php");
        //setCond("D:\\工作日记\\2019年\\OA新通用移动模板\\work","[all]","edit.php");
        setCond("D:\\test\\ljtao\\test1","[all]","四");


    }
    /*
    filePath 从哪个文件夹开始查，
    sufStr 只查哪些文件，
    searchStr 查询的内容
     */
    public static void setCond(String filePath,String sufStr,String searchStr) throws  Exception{
        File file = new File(filePath);
        File[] files = file.listFiles();
        List<File> fileList=new ArrayList<>();//所有要查询的文件
        getAllFile(files,fileList,sufStr);

        System.out.println("-------开始查询文件--------");
        ByteBuffer byteBuffer= ByteBuffer.allocate(1024000);//这里可以调高
        FileChannel channel=null;
        String fileStr;
        List<String> resultFileNameList=new ArrayList<>();//有该内容的文件
        for(File f:fileList){
            //FileChannel channel = new RandomAccessFile(file1,"rw").getChannel();
            channel= new FileInputStream(f.getAbsolutePath()).getChannel();
            int read = channel.read(byteBuffer);
            fileStr = byteBufferToString2(byteBuffer);
            byteBuffer.clear();//读写完要重置
            if(fileStr.indexOf(searchStr)!=-1){
                System.out.println(f.getAbsolutePath());
                resultFileNameList.add(f.getAbsolutePath());

            }
        }
        if(channel!=null){
            channel.close();
        }
        System.out.println("-------结束查询文件--------");
        //System.out.println(file.getName());
    }
    public static void getAllFile(File[] files, List<File> allFile,String sufStr){
        if(files==null || files.length<1){
            return ;
        }
        for(File f:files){
            if(f.isDirectory()){
                getAllFile(f.listFiles(),allFile,sufStr);
            }
            else{
                if(sufStr.equals("[all]")){
                    allFile.add(f);
                }
                //后缀包含sufstr的文件，才加入数组
                else if(f.getName().endsWith(sufStr)){
                    allFile.add(f);
                }

            }
        }
    }

    public static String byteBufferToString(ByteBuffer buffer)throws  Exception{
        buffer.flip();
        Charset charset = Charset.forName("gbk");
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharBuffer cb = CharBuffer.allocate(1024);
        charsetDecoder.decode(buffer,cb,true);
        cb.flip();
        char[] a = new char[cb.length()];
        while(cb.hasRemaining()){
            cb.get(a);
            System.out.println("1"+new String(a));
        }
        return "";
    }
    //这种转换比较容易看
    public static String byteBufferToString2(ByteBuffer buffer)throws  Exception{
        buffer.flip();
        byte[] bs=new byte[buffer.limit()];
        buffer.get(bs);
        String str=new String(bs,0,bs.length,"gbk");
        //String str=new String(bs,0,bs.length,"utf-8");
        //System.out.println(str);
        return str;
    }
}
