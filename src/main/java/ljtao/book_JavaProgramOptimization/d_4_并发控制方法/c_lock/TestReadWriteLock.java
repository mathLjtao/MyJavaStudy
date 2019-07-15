package ljtao.book_JavaProgramOptimization.d_4_并发控制方法.c_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class TestReadWriteLock {
	private static Lock lock=new ReentrantLock();
	private static ReentrantReadWriteLock readWriteLock  =new ReentrantReadWriteLock();
	
	public static void main(String[] args) {
		handRead();
		handWrite();
		handRead2();
		handWrite2();
		
		//读锁,可以保证所线程读操作，绝对并行，
		ReadLock readLock = readWriteLock.readLock();
		//写所，多线程情况下是串行
		WriteLock writeLock = readWriteLock.writeLock();
	}

	private static void handRead() {
		// TODO Auto-generated method stub
		try {
			lock.lock();
			Thread.sleep(1);
		} catch (Exception e) {
			lock.unlock();
		}
	}

	private static void handWrite() {
		// TODO Auto-generated method stub
		
	}

	private static void handRead2() {
		// TODO Auto-generated method stub
		
	}

	private static void handWrite2() {
		// TODO Auto-generated method stub
		
	}
	
}
