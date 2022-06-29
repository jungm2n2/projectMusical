package com.Musical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CustomerImpl implements Customer{
   
   HashMap<String, CustomerVO> customerMap = null;
   HashMap<String, TitleVO> titleMap = null;
   String id;
   String answer;
   BookticketImpl bt = null;
   
   CustomerVO vo = new CustomerVO(); 

   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
   String changepw;
   int num;
   

   public CustomerImpl(HashMap<String, CustomerVO> customerMap, HashMap<String, TitleVO> titleMap) {
      this.customerMap = customerMap;
      this.titleMap = titleMap;
      
   }

   @Override
   public void userUpdate() {
      
      try {
         
         System.out.print("��й�ȣ�� �Է����ּ���");
         changepw = (br.readLine());
         
         vo = customerMap.get(id);
         
         if(!vo.getPw().equals(changepw)){
            System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�");
            return;
      }else {
         System.out.println("��й�ȣ ���� �Ϸ�");
      }
         
         System.out.println("�����ϰ���� ȸ�������� �����ϼ���");
         System.out.println("1.��й�ȣ \n2.�̸��� \n3.�ڵ�����ȣ");
         int num2 = (Integer.parseInt(br.readLine()));
         
         boolean flag = false;
         
         switch (num2) {
         case 1:
            System.out.println("������ ��й�ȣ?");
            vo.setPw(br.readLine()); flag = true; break;
         case 2:
            System.out.println("������ �̸���?");
            vo.setMail(br.readLine()); flag = true; break;
         case 3:
            System.out.println("������ �ڵ��� ��ȣ?");
            vo.setPhone(br.readLine()); flag = true; break;
         default:
            flag = false; break;
         
         }
         
         if(flag) {
            customerMap.put(id, vo);
            System.out.println("���� �Ϸ�!");
         }else {
            System.out.println("��ȣ�� �ٽ� �Է��ϼ���"); 
         }
         
         
         
         
         
         
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
      
   }
         
   
   @Override
   public void reservation() {
      
      BookticketImpl bk = new BookticketImpl(id, titleMap);
      customerMap.get(id).getPh().add(bk.ViewMenu());
   }
   
   @Override
   public void checkTicket() {
      
      System.out.println(customerMap.get(id).getPh().toString());
      
      
      
      
      
   }

   @Override
   public void logout() {
      
      try {
         System.out.println("�α׾ƿ� �Ͻðڽ��ϱ�?[Y/N]");
         answer = br.readLine();
         
         if(answer.equals("Y") || answer.equals("y")) {
            System.out.println("�α׾ƿ��� �Ϸ�Ǿ����ϴ�");
            
         }else if(answer.equals("N") || answer.equals("n")) {
            return;
         }else {
            System.out.println("�ٽ� �Է����ּ���");
            return;
         }
         
         
         
         
      } catch (Exception e) {
         
      }
      
   }
   
   
   

   @Override
   public void userDelete() {
      
      try {
         
         
         System.out.print("Ż���Ͻðڽ��ϱ�?[Y/N]");
         String yn = br.readLine();
         
         if(yn.equals("Y") || yn.equals("y")) {
        	 customerMap.remove(id);
             System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�");
         }else {
        	 System.out.println("�ٽ� �Է����ּ���");
         }
         

         
         
         
         
      } catch (Exception e) {
         
      }
      
   
      
      
      
   }




   @Override
   public boolean searchId(String id) {
      
      return customerMap.containsKey(id);
      
      
      
   }
   
   public void start(String id1) {
      
      try {
         
         id = id1;
      while(true){   
         do {
         System.out.println("1.���������� \n2.�����ϱ� \n3.���ų��� ��ȸ \n4.�α׾ƿ� \n5.ȸ��Ż��");
         num = Integer.parseInt(br.readLine());
         }while(num<1||num>5);
         
         
         switch (num) {
         
         case(1):userUpdate();break;
         case(2):reservation();break;
         case(3):checkTicket();break;
         case(4):logout();return;
         case(5):userDelete();return;
      
         }
      }
         
      } catch (Exception e) {
         System.out.println(e.toString());
      }
   }

   
}