package ljtao.javase.javaio.nio.basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
    public static void main(String[] args) throws Exception{
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        FileChannel fi = new FileInputStream("F:\\test2.txt").getChannel();
        FileChannel fo = new FileOutputStream("f:\\test2.txt",true).getChannel();
        byteBuffer.clear();
        int len = fi.read(byteBuffer);
        System.out.println(len);
        System.out.println(new String(byteBuffer.array(),0,len));
        ByteBuffer byteBuffer1=ByteBuffer.wrap(new String("aaab").getBytes());
        fo.write(byteBuffer1);

        fi.close();
        fo.close();
    }
}
