package ljtao.book_JavaProgramOptimization.c_4_nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class TestNIO {
	
	public static void main(String[] args) throws Exception {
		//niocopeFile("d:\\student.txt","d:\\student1.txt");
		demo9();
	}
	public static void demo9()throws Exception{
		IntBuffer ib=IntBuffer.allocate(10);
		int[] is=new int[]{5,0,1};
		//将数组转换成相应类型的缓冲区
		ib=IntBuffer.wrap(is);
		ib.put(0,7);
		ib.put(9);
		ib.put(10);
		for (int i = 0; i < ib.limit(); i++) {
			System.out.print(ib.get(i)+" , ");
		}
		System.out.println();
		//缓冲区的改变，实际上是数组里面的数据改变
		for(int i:is){
			System.out.print(i+" , ");
		}
		System.out.println(ib);
	}
	public static void demo8() throws Exception{
		/*
		 * 3、MapperByteBuffer形式，，这个比较特殊
		 */
		RandomAccessFile raf=new RandomAccessFile("d:\\student2.txt", "rw");
		FileChannel channel3 = raf.getChannel();
		MappedByteBuffer map = channel3.map(FileChannel.MapMode.READ_WRITE, 0, 1000);
		for (int i = 0; i < 10; i++) {
			map.put("降低".getBytes());
		}
		if(channel3!=null){
			channel3.close();
		}
		
		FileChannel channel4=new FileInputStream("d:\\student2.txt").getChannel();
		System.out.println(channel4.size());
		MappedByteBuffer map2 = channel4.map(FileChannel.MapMode.READ_ONLY, 0, channel4.size());
		while(map2.hasRemaining()){
			System.out.print(map2.get());
		}
		if(channel4!=null){
			channel4.close();
		}
				
	}
	/*
	 * 三种方式来读写文件进行比较
	 */
	public static void demo7() throws Exception{
		long sysTime=System.currentTimeMillis();
		/*
		 * 1、传统I/O形式
		 */
		FileOutputStream fos=new FileOutputStream("d:\\student.txt");
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(fos));
		for (int i = 0; i < 100; i++) {
			dos.write("啊哈哈".getBytes());
		}
		dos.close();
		
		FileInputStream fis =new FileInputStream("d:\\student.txt");
		DataInputStream dis=new DataInputStream(new BufferedInputStream(fis));
		int len=0;
		System.out.println(dis.readInt());
		while((len=dis.read())!=-1){
			System.out.print(len);
		}
		dis.close();
		System.out.println("\n方法1："+(System.currentTimeMillis()-sysTime));
		sysTime=System.currentTimeMillis();
		/*
		 * 2、Buffer形式
		 */
		FileOutputStream fos1=new FileOutputStream("d:\\student1.txt");
		FileChannel channel = fos1.getChannel();
		ByteBuffer bb=ByteBuffer.allocate(10240); 
		for (int i = 0; i < 100; i++) {
			bb.put("啊哈哈".getBytes());
		}
		bb.flip();
		channel.write(bb);
		fos1.close();
		
		FileInputStream fis1=new FileInputStream("d:\\student1.txt");
		FileChannel channel2 = fis1.getChannel();
		ByteBuffer bb2=ByteBuffer.allocate(10240); 
		channel2.read(bb2);
		fis1.close();
		bb2.flip();
		while(bb2.hasRemaining()){
			System.out.print(bb2.get());
		}
		System.out.println("\n方法2："+(System.currentTimeMillis()-sysTime));
		sysTime=System.currentTimeMillis();
		
		demo8();
	}
	/*
	 * 处理结构化数据
	 * 1、散射：将数据读入一组Buffer中
	 * 2、聚集：将数据写入一组Buffer中
	 * 简单来说就是将将数据处理成Buffer数组
	 */
	public static void demo6() throws Exception{
		/*
		 * 聚集
		*/ 
		ByteBuffer b1=ByteBuffer.wrap("java程序性能优化".getBytes());
		ByteBuffer b2=ByteBuffer.wrap(" 葛一鸣".getBytes());
		int booklen=b1.limit();
		int autlen=b2.limit();
		FileOutputStream fos=new FileOutputStream("d:\\student.txt");
		ByteBuffer[] bs={b1,b2};
		FileChannel channel = fos.getChannel();
		channel.write(bs);
		fos.close();
		
		/*
		 * 散射
		 */
		ByteBuffer b3=ByteBuffer.allocate(booklen);
		ByteBuffer b4=ByteBuffer.allocate(autlen);
		ByteBuffer[] bs2=new ByteBuffer[]{b3,b4};
		FileInputStream fis=new FileInputStream("d:\\student.txt");
		FileChannel channel2 = fis.getChannel();
		channel2.read(bs2);
		String bookname=new String(bs2[0].array(),"utf-8");
		String atuname=new String(bs2[1].array(),"utf-8");
		System.out.println(bookname+atuname);
		fis.close();
	}
	/*
	 * NIO提供一种将文件映射到内存的方法进行I/O操作，他可以比常规的基于流的I/O快很多，FileChannal.map()方法实现
	 */
	public static void demo5() throws Exception{
		RandomAccessFile raf=new RandomAccessFile("d:\\student.txt","rw");
		FileChannel fc=raf.getChannel();
		//MappedByteBuffer 是ByteBuffer的子类
		//通过FileChannel将文件映射到内存中。
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
		while(mbb.hasRemaining()){
			System.out.print(mbb.get()+" ");
		}
		//通过修改Buffer，通过映射，将实际数据写到对应 的磁盘中。
		mbb.put(0,(byte)98);
		raf.close();
		
	}
	public static void demo4(){
		/*
		 * 缓冲区分片：slice()方法，
		 * 1、获取主缓冲去中的一个片段，
		 * 2、设置position、limit为范围，跟复制缓冲区一个概念，存储的数据本质是一样的。
		 * b.position(3);
		 * b.limit(10);
		 * b.slice();
		 * 
		 * 只读缓冲区asReadOnlyBuffer() 方法
		 * 创建只读缓冲区，只能读取数据，写入数据会报错。
		 */
	}
	/*
	 * 复制缓冲区：duplicate()方法
	 * 1、主缓冲区、副本缓冲区，都是拿同一个地方的数据
	 * 2、各自维护自己的position、limit、mark
	 */
	public static void demo3(){
		ByteBuffer b=ByteBuffer.allocate(20);
		for (int i = 0; i < 15; i++) {
			b.put((byte)i);
		}
		ByteBuffer copyB = b.duplicate();
		System.out.println("执行b.duplicate()后，");
		System.out.println(b);
		System.out.println(copyB);
		copyB.flip();
		System.out.println("执行copyB.flip()后，");
		System.out.println(b);
		System.out.println(copyB);
		System.out.println("想副本缓冲区插入一个数据：(byte)100");
		copyB.put((byte)100);
		System.out.println("获取主缓冲区跟副本缓冲区第一个数据");
		System.out.println("b.get(0):"+b.get(0));
		System.out.println("copyB.get(0):"+copyB.get(0));
	}
	/*
	 * mark()方法得使用
	 * 
	 */
	public static void demo2(){
		ByteBuffer b=ByteBuffer.allocate(20);
		for (int i = 0; i < 15; i++) {
			b.put((byte)i);
		}
		b.flip();//准备读
		for (int i = 0; i < 15; i++) {
			//在位置10的地方做mark
			if(i==10){
				b.mark();
				System.out.print(" set mark ");
			}
			System.out.print(b.get()+" ");
		}
		//回到mark的位置，读取后续数据
		b.reset();
		System.out.println("\nreset to mark");
		while(b.hasRemaining()){
			System.out.print(b.get()+" ");
		}
	}
	/*
	 * 理解Buffer中，位置(position) 、容量(capacity)和上限(limit)三者的含义
	 * limit是缓冲区的实际上限
	 * 0<=mark<=position<=limit<=capacity
	 */
	public static void demo1(){
		ByteBuffer b=ByteBuffer.allocate(20);//15个字节大小的缓冲区
		System.out.println("position="+b.position()+" limit="+b.limit()+" capactiy= "+b.capacity());
		for(int i=0;i<10;i++){
			b.put((byte)i);					//存入10个字节数据
		}
		System.out.println("position="+b.position()+" limit="+b.limit()+" capactiy= "+b.capacity());
		//重置position
		b.flip();	
		System.out.println("position="+b.position()+" limit="+b.limit()+" capactiy= "+b.capacity());
		for (int i = 0; i < 5; i++) {
			System.out.print(b.get()+" ");
		}
		System.out.println();
		System.out.println("position="+b.position()+" limit="+b.limit()+" capactiy= "+b.capacity());
		b.flip();	//切到写
		//b.rewind();
		//b.clear();
		System.out.println("position="+b.position()+" limit="+b.limit()+" capactiy= "+b.capacity());
	}
	/*
	 *  測試用NIO，複製一份文件的內容到另一文件
	 */
	public static void niocopeFile(String resource, String destination) throws Exception{
		FileInputStream fis=new FileInputStream(resource);
		FileOutputStream fos=new FileOutputStream(destination);
		FileChannel readChannel = fis.getChannel();
		FileChannel writerChannel = fos.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int len;
		while(true){
			//为读入数据到buffer做准备
			buffer.clear();
			//讀入数据 ,,内容已存入buffer中
			len = readChannel.read(buffer);
			if(len==-1){
				//讀取完畢
				break;
			}
			//从 写状态 转为 读状态，flip()方法主要是在“读写切换时”调用
			buffer.flip();
			writerChannel.write(buffer);
			
		}
		readChannel.close();
		writerChannel.close();
		System.out.println("复制完");
	}
}
