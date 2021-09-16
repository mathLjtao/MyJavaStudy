package ljtao.soft.image_handle;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author ljtao
 * @date 2021/6/25
 */
public class ImageCompression {
    public static void main(String[] args) throws Exception{
        fun3();
    }

    static void fun1() throws Exception{
        File file=new File("C:\\Users\\林锦涛\\Pictures\\Saved Pictures");
        File[] files = file.listFiles();
        int i=0;
        for(File f : files){
            if(f.getName().lastIndexOf(".jpg") != -1 || f.getName().lastIndexOf(".png") != -1 || f.getName().lastIndexOf(".PNG") != -1){
                i++;
                System.out.println(f.getAbsolutePath());
                System.out.println(f.getParent());

                Thumbnails.of(f.getAbsolutePath()).scale(1f).toFile(f.getParent()+"\\"+String.valueOf(i)+".png");
            }
        }
    }
    /*
    把MultipartFile的输入流压缩到一个临时的file里，然后再根据临时file和之前的参数生成一个新的MultipartFile
     */
    static void fun2(MultipartFile file) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        OutputStream os = new FileOutputStream(file.getInputStream());
        Thumbnails.of(file.getInputStream()).scale(1f).toOutputStream(out);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());



        new ByteArrayInputStream(new ByteArrayOutputStream().toByteArray());
    }

    static void fun3() throws Exception {
//        File file=new File("C:\\Users\\林锦涛\\Pictures\\Saved Pictures");
//        File[] files = file.listFiles();
//        int i=0;
//        for(File f : files){
//            String[] split = f.getName().split(".", 1);
//            if(split.length < 2){
//                return;
//            }
//            if(split[1].equalsIgnoreCase("jpg")  || split[1].equalsIgnoreCase("png")){
//                i++;
//                BufferedImage read = ImageIO.read(f);
//                Thumbnails.of(f.getAbsolutePath()).scale(1f).toFile(f.getParent()+"\\"+String.valueOf(i)+"."+split[1]);
//            }
//        }

        BufferedImage read = ImageIO.read(new FileInputStream("C:\\Users\\林锦涛\\Pictures\\Saved Pictures\\test.png"));
        BufferedImage tempImage=new BufferedImage(750, 645, 9);
        Graphics graphics = tempImage.getGraphics();
        graphics.drawImage(read, 0, 0, null);
        ImageIO.write(tempImage, "png", new File("C:\\Users\\林锦涛\\Pictures\\Saved Pictures\\test1.png"));
    }
}
