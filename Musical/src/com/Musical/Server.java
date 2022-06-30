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

				System.out.println(sc.getInetAddress().getAddress() + "접속...");
				System.out.println("서버에서 뮤지컬 정보를 보낼 수 있습니다.");
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
				System.out.println("뮤지컬 정보를 전송하시겠습니까?[Y/N]");
				
				input = scn.next();
				
				
				if(titleDB == null) {
					System.out.println("정보가 없습니다.");
					System.exit(0);
				}
				
				oos = new ObjectOutputStream(sc.getOutputStream());
				oos.flush();
				oos.writeObject(titleDB.get("서편제"));
				
				oos.close();
				System.out.println("뮤지컬 정보를 전송했습니다.");
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	public void serverStart(){
		try {
			ServerSocket ss = new ServerSocket(7777);

			System.out.println("클라이언트 접속 대기중...");

			Socket sc = ss.accept();

			WorkThread th = new WorkThread(sc);
			th.start();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void createTitle(){

		//뮤지컬 데이터 입력.정민
		String[] arrTitle = {"서편제", "아이다", "킹키부츠", "마타하리", "번지점프를 하다", "은밀하게 위대하게"};
		String [] arrActorPairs = {"신재범,신영숙","이석훈,김환희","서경수,이수빈","박효신,조승우","박은태,유소리","양준모,김소피아"};
		String [] arrDate = {"8/15(월)","8/16(화)","8/20(토)", "8/21(일)","8/24(수)", "8/27(토)"};	
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
