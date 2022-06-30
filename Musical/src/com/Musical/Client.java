package com.Musical;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class Client implements Runnable{
	
	String host = "localhost";
	int port = 7777;
	Socket sc = null;
	HashMap<String, TitleVO> titleMap = null;
	
	public Client(HashMap<String, TitleVO> titleDB) {
		titleMap = titleDB;
	}
	public void connect() {
		try {
			sc = new Socket(host, port);
			
			Thread th = new Thread(this);
			th.start();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	@Override
	public void run() {
		try {
			
			ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());
			Object ob = null;
			
			while ((ob = ois.readObject()) != null) {
				if (ob instanceof TitleVO) {
					TitleVO receiveTitle = (TitleVO)ob;
					titleMap.put(receiveTitle.getTitle(), receiveTitle);
					System.out.println("뮤지컬이 추가 되었습니다.");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
