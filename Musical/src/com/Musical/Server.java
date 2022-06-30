package com.Musical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Server {

	HashMap<String, TitleVO> titleDB = null;

	public Server() {
		titleDB = new HashMap<String, TitleVO>();
	}
	
	class WorkThread extends Thread{
		private Socket sc = null;
		public WorkThread(Socket pSc) {
			this.sc = pSc;
		}

		@Override
		public void run() {
			try {

				System.out.println(sc.getInetAddress().getAddress() + "����...");
				System.out.println("�������� ������ ������ ���� �� �ֽ��ϴ�.");
				sendTitle();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public void sendTitle(){
			ObjectOutputStream oos = null;
			
			Scanner scn = new Scanner(System.in);
			String input;
			
			try {
				System.out.println("������ ������ �����Ͻðڽ��ϱ�?[Y/N]");
				
				input = scn.next();
				
				
				if(titleDB == null) {
					System.out.println("������ �����ϴ�.");
					System.exit(0);
				}
				
				oos = new ObjectOutputStream(sc.getOutputStream());
				oos.flush();
				oos.writeObject(titleDB.get("������"));
				
				oos.close();
				System.out.println("������ ������ �����߽��ϴ�.");
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	public void serverStart(){
		try {
			ServerSocket ss = new ServerSocket(7777);

			System.out.println("Ŭ���̾�Ʈ ���� �����...");

			Socket sc = ss.accept();

			WorkThread th = new WorkThread(sc);
			th.start();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void createTitle(){

		//������ ������ �Է�.����
		String[] arrTitle = {"������", "���̴�", "ŷŰ����", "��Ÿ�ϸ�", "���������� �ϴ�", "�����ϰ� �����ϰ�"};
		String [] arrActorPairs = {"�����,�ſ���","�̼���,��ȯ��","�����,�̼���","��ȿ��,���¿�","������,���Ҹ�","���ظ�,����Ǿ�"};
		String [] arrDate = {"8/15(��)","8/16(ȭ)","8/20(��)", "8/21(��)","8/24(��)", "8/27(��)"};	
		String [] arrTime = {"11:30", "13:50", "16:00", "17:50", "20:00", "21:30"};
		int [] arrCost = {200000,220000,300000,220000,180000,250000};

		Random rd = new Random();
		for(int i=0;i<arrTitle.length;i++) {
			ArrayList<DetailsInfo> arrInfo = new ArrayList<>();
			for(int j = 0;  j < 3; j++) {
				DetailsInfo temp = new DetailsInfo();
				temp.setActorPairs(arrActorPairs[rd.nextInt(6)]);
				temp.setDate(arrDate[rd.nextInt(6)]);
				temp.setTime(arrTime[rd.nextInt(6)]);
				temp.setCost(arrCost[rd.nextInt(6)]);

				arrInfo.add(temp);
			}
			titleDB.put(arrTitle[i], new TitleVO(arrTitle[i], arrInfo));
		}
	}

	public static void main(String[] args) {
		Server os = new Server();
		os.createTitle();
		os.serverStart();
	}
}
