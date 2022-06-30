package com.Musical;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		int port = 7777;
//		String host = "192.168.16.4";
		String host = "localhost";
		
		Socket sc = null;
		
		ObjectOutputStream oos = null;
		
		Scanner scn = new Scanner(System.in);
		String path;
		
		try {
			System.out.println("전송할 파일 경로 및 파일명?");
			
			path = scn.next();
			
			File f = new File(path);
			
			if(!f.exists()) {
				System.out.println("파일이 없습니다.");
				System.exit(0);
			}
			
			sc = new Socket(host, port);
			
			oos = new ObjectOutputStream(sc.getOutputStream());
			oos.flush();
			
//			FileInfo info;
//			
//			info = new FileInfo();
//			info.setCode(100);
//			info.setData(f.getName().getBytes());
//			info.setSize((int)f.length());
//			
//			oos.writeObject(info);
//			System.out.println(f.getName() + "파일 전송 시작!!!");
//			
//			Thread.sleep(0);
//			FileInputStream fis = new FileInputStream(f);
//			
//			int byteData = 0;
//			
//			byte[] buffer = new byte[1024];
//			
//			while ((byteData = fis.read(buffer, 0, 1024)) != -1) {
//				
//				info = new FileInfo();
//				
//				info.setCode(110);
//				info.setSize(byteData);
//				info.setData(buffer);
//				
//				oos.writeObject(info);
//				
//				System.out.println(byteData + "bytes 전송중!!!");
//				
//				buffer = new byte[1024];
//					
//				Thread.sleep(0);
//				
//			}
//			
//			fis.close();
//			info = new FileInfo();
//			info.setCode(200);
//			info.setData(f.getName().getBytes());
//			info.setSize((int)f.length());
//			
//			oos.writeObject(info);
//			System.out.println(f.getName() + "파일 전송 끝");
//			
//			
//			Thread.sleep(0);
			
			oos.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
