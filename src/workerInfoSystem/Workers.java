package workerInfoSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Workers implements Serializable{

	/*
	 * ����������ӿ������ȷ������ List<Info> workerInfoPut
	 */
	public List<Info> workerInfoPut;
	private static Scanner scanner;
	String serialPath="e:\\workerinfotest.txt";

	public int n;
	public String num;
	public String name;
	public String id;
	public String address;
	public String tel;
	public String branch;
	public String income;
	public String starJob;
	public String subject;
	public String post;
	public String reMark;

	public Workers() {
		// this.workerInfoPut=new ArrayList<Info>();
		scanner = new Scanner(System.in);

	}

	public void init() {

		/*
		 * ��ʼ��ʱ����洢����
		 */
		workerInfoPut = DataOpt.read();
	}

	// ��ӿγ̵ķ���
	public void workerAdd() {
		System.out.println("-------------------------------��ӹ���----------------------------------");
		System.out.println("����������Ҫ��ӵ�Ա��������");
		/*
		 * scanner ʹ�������Ҫclose
		 */

		int size = Integer.parseInt(scanner.next());
		for (int i = 0; i < size; i++) {
			int n = i + 1;
			System.out.println("������:" + n);
			System.out.println("�������ְԱ�Ĺ��ţ�");

			String num = scanner.next();
			System.out.println("��¼���ְԱ�Ĺ��ţ�" + num);
			System.out.println("�������ְԱ��������");

			String name = scanner.next();
			System.out.println("��¼���ְԱ��������" + name);
			System.out.println("�������ְԱ�����֤���룺");

			String id = scanner.next();
			System.out.println("��¼���ְԱ�����֤���룺" + id);
			System.out.println("�������ְԱ�ĵ�ַ��");

			String address = scanner.next();
			System.out.println("��¼���ְԱ�ĵ�ַ��" + address);
			System.out.println("�������ְԱ�ĵ绰��");

			String tel = scanner.next();
			System.out.println("��¼���ְԱ�ĵ绰��" + tel);
			System.out.println("�������ְԱ�Ĳ��ţ�");

			String branch = scanner.next();
			System.out.println("��¼���ְԱ�Ĳ��ţ�" + branch);
			System.out.println("�������ְԱ�����룺");

			String income = scanner.next();
			System.out.println("��¼���ְԱ�����룺" + income);
			System.out.println("�������ְԱ������ʱ�䣺");

			String starJob = scanner.next();
			System.out.println("��¼���ְԱ������ʱ�䣺" + starJob);
			System.out.println("�������ְԱ��רҵ��");

			String subject = scanner.next();
			System.out.println("��¼���ְԱ��רҵ��" + subject);
			System.out.println("�������ְԱ��ְλ��");

			String post = scanner.next();
			System.out.println("��¼���ְԱ��ְλ��" + post);
			System.out.println("�����뱸ע��");

			String reMark = scanner.next();
			System.out.println("��ע��Ϣ��" + reMark);

			Info info = new Info(n, num, name, id, address, tel, branch, income, starJob, subject, post, reMark);
			/*
			 * ���ǳ���warning�ĵط����㶼���Կ�����ʲôԭ�� Ȼ��ȥ��������Ż�ǿ׳
			 */
			workerInfoPut.add(info);
			/*
			 * �����Ա���󣬸��´洢����
			 */
			DataOpt.save(workerInfoPut);
		    DataSerial.save(workerInfoPut);
			System.out.println("����˵�" + n + "��Ա����" + name + "�������Ϣ��");
		}
	}

	// Ա����Ϣ���ܴ�ӡ���
	public void searchInfo() {
		System.out.println("����λԱ����Ϣ�������£�");
		int size = workerInfoPut.size();
		for (int i = 0; i < size; i++) {
			Info info = (Info) workerInfoPut.get(i);
			System.out.println("��ţ�" + (i + 1) + ",������" + info.name + "�����ţ�" + info.num + "�����֤���룺" + info.id + "����ַ��"
					+ info.address + "���绰��" + info.tel + "�����ţ�" + info.branch + "�����룺" + info.income + "������ʱ�䣺"
					+ info.starJob + "��רҵ��" + info.subject + "��ְλ��" + info.post + "����ע��Ϣ��" + info.reMark);
		}
	}
	/*
	 * �����л��ķ�ʽ��ȡ�ѱ�����ĵ������
	 */
	public void searchInfo1() {
		System.out.println("����λԱ����Ϣ�������£�");
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("e:\\workerinfotest.txt"));
			List list2;
			try {
				list2=(List) ois.readObject();
				int size=list2.size();
				for (int i = 0; i < size; i++) {
					Info info = (Info) workerInfoPut.get(i);
					
					System.out.println("��ţ�" + (i + 1) + ",������" + info.name + "�����ţ�" + info.num + "�����֤���룺" + info.id + "����ַ��"
							+ info.address + "���绰��" + info.tel + "�����ţ�" + info.branch + "�����룺" + info.income + "������ʱ�䣺"
							+ info.starJob + "��רҵ��" + info.subject + "��ְλ��" + info.post + "����ע��Ϣ��" + info.reMark);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	// Ա����Ϣ�޸�
	public void InfoModify() {
		System.out.println("-------------------------------�޸Ĺ���----------------------------------");
		System.out.println("��ѡ����Ҫ�޸ĵ���Ա��ţ�");
		int size = workerInfoPut.size();
		for (int i = 0; i < size; i++) {
			Info info = (Info) workerInfoPut.get(i);
			System.out.println("��ţ�" + (i + 1) + ",������" + info.name + "�����ţ�" + info.num + "�����֤���룺" + info.id + "����ַ��"
					+ info.address + "���绰��" + info.tel + "�����ţ�" + info.branch + "�����룺" + info.income + "������ʱ�䣺"
					+ info.starJob + "��רҵ��" + info.subject + "��ְλ��" + info.post + "����ע��Ϣ��" + info.reMark);
		}
/*
 * ���������Ϣ���������2-3���ֵ����ġ����ţ�7λ����1��ͷ��ͷ��λ��������16�������ظ������֤���룬18λ�����֣���7-10λΪ1900-1998.��11-12λΪ01-12����13-14λΪ01-31���绰Ϊ1��ͷ��11λ����
 * ����ʱ��Ϊ6λ�����֣����е�3-4λҪ���ڹ��ŵ�ǰ��λ רҵ ְλ ��ע��ϢΪ������
 */
		int m = Integer.parseInt(scanner.next());
		
		  for(int i=0;i<1;){
		System.out.println("�������ְԱ��������");
		String name1 = scanner.next();
		String regex1="[\u4e00-\u9fa5]";
		Pattern p1=Pattern.compile(regex1);
	    Matcher m1=p1.matcher(name1);
	    boolean test1=m1.find();
	    if(test1==false){
	    	System.out.println("�������������Ч������������");
	    }else{
	    	name=name1;
	    	System.out.println("��¼���ְԱ��������" + name);
	    	i=1;
	    }
	    }
		 
		  for(int i=0;i<1;){
		System.out.println("�������ְԱ�����֤���룺");
		String id1 = scanner.next();
		  String regex3="\\d{17}[\\d|x]|\\d{15}";
	        Pattern p3=Pattern.compile(regex3);
	        Matcher m3=p3.matcher(id1);
	        boolean test3=m3.matches();
	        if(test3==false){
	        	System.out.println("����������֤������Ч������������");
	        }else{
	        	id=id1;
	        	System.out.println("��¼���ְԱ�����֤���룺" + id);
	        	i=1;
	        }
	        }
		
		  for(int i=0;i<1;){
	    	Date date=new Date();
	    	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String time=format.format(date);
	    	int year=Integer.parseInt(time.substring(2, 4));
	        System.out.println("���������Ĺ��ţ�");
	        String num1=scanner.next();
	        System.out.println("��������������ʱ�䣺");
	        String starJob1=scanner.next();
	        String regex4="-?[1-9]\\d*";
	        Pattern p4=Pattern.compile(regex4);
	        Matcher m4=p4.matcher(num1);
	        boolean test4=m4.matches();
	        int a=Integer.parseInt(num1.substring(0, 2));
	        String regex5="-?[1-9]\\d*";
	        Pattern p5=Pattern.compile(regex5);
	        Matcher m5=p5.matcher(starJob1);
	        boolean test5=m5.matches();
	        int b=Integer.parseInt(starJob1.substring(2, 4));
	        if(test4==false||test5==false||a!=b||a>=year){
	        	System.out.println("������Ĺ��Ż�����ʱ����Ч������������");
	        }else{
	        	num=num1;
	        	starJob=starJob1;
	        	System.out.println("��¼���ְԱ���ź�����ʱ�䣺"+num+","+starJob);
	        	i=1;
	        }
	        }
		  
			System.out.println("�������ְԱ�ĵ�ַ��");
			String address = scanner.next();
			System.out.println("��¼���ְԱ�ĵ�ַ��" + address);
		
		
		  for(int i=0;i<1;){
			    System.out.println("���������ĵ绰���룺");
			    String tel1=scanner.next();
			    String regex2="0?(13|14|15|18)[0-9]{9}";
			    Pattern p2=Pattern.compile(regex2);
			    Matcher m2=p2.matcher(tel1);
			    boolean test2=m2.matches();
			    if(test2==false){
			    	System.out.println("������ĵ绰������Ч������������");
			    }else{
			    	tel=tel1;
			    	System.out.println("��¼���ְԱ���绰��"+tel);
			    	i=1;
			    }
			    }
		  
		  for(int i=0;i<1;){
				System.out.println("�������ְԱ�Ĳ��ţ�");
				String branch1 = scanner.next();
				String regex1="[\u4e00-\u9fa5]";
				Pattern p1=Pattern.compile(regex1);
			    Matcher m1=p1.matcher(branch1);
			    boolean test2=m1.find();
			    if(test2==false){
			    	System.out.println("������Ĳ�����Ч������������");
			    }else{
			    	branch=branch1;
			    	System.out.println("��¼���ְԱ�Ĳ��ţ�" + branch);
			    	i=1;
			    }
			    }  
		  for(int i=0;i<1;){
			        System.out.println("�������������룺");
			        String income1=scanner.next();
			        String regex6="-?[1-9]\\d*";
			        Pattern p6=Pattern.compile(regex6);
			        Matcher m6=p6.matcher(income1);
			        boolean test6=m6.matches();
			        if(test6==false){
			        	System.out.println("�������������Ч������������");
			        }else{
			        	income=income1;
			        	System.out.println("��¼���ְԱ�����ʣ�"+income);
			        	i=1;
			        }
			        }
		
		  for(int i=0;i<1;){
				System.out.println("�������ְԱ��רҵ��");
				String subject1 = scanner.next();
				String regex1="[\u4e00-\u9fa5]";
				Pattern p1=Pattern.compile(regex1);
			    Matcher m1=p1.matcher(subject1);
			    boolean test2=m1.find();
			    if(test2==false){
			    	System.out.println("�������רҵ��Ч������������");
			    }else{
			    	subject=subject1;
			    	System.out.println("��¼���ְԱ��רҵ��" + subject);
			    	i=1;
			    }
		  }  
		
		  for(int i=0;i<1;){
				System.out.println("�������ְԱ��ְλ��");
				String post1 = scanner.next();
				String regex1="[\u4e00-\u9fa5]";
				Pattern p1=Pattern.compile(regex1);
			    Matcher m1=p1.matcher(post1);
			    boolean test2=m1.find();
			    if(test2==false){
			    	System.out.println("�������ְλ��Ч������������");
			    }else{
			    	post=post1;
			    	System.out.println("��¼���ְԱ��ְλ��" + post);
			    	i=1;
			    }
			    }  
		System.out.println("�����뱸ע��");
		String reMark = scanner.next();
		System.out.println("��ע��Ϣ��" + reMark);
		
		workerInfoPut.set((m-1),new Info(m, num, name, id, address, tel, branch, income, starJob, subject, post, reMark));
		/*
		 * �޸�Ա����Ϣ�󣬸��´洢����
		 */
		DataOpt.save(workerInfoPut);
		System.out.println("�޸ĺ�ĵ�λԱ����ϢΪ��");
		Info info = (Info) workerInfoPut.get(m - 1);
		System.out.println("��ţ�" + (m) + ",������" + info.name + "�����ţ�" + info.num + "�����֤���룺" + info.id + "����ַ��"
				+ info.address + "���绰��" + info.tel + "�����ţ�" + info.branch + "�����룺" + info.income + "������ʱ�䣺"
				+ info.starJob + "��רҵ��" + info.subject + "��ְλ��" + info.post + "����ע��Ϣ��" + info.reMark);
	}

	/**
	 * �����ɾ��һ��Ҫ���ݹ��Ž���ɾ���� ��workerInfoPut�������ƥ��
	 *
	 */
	public void delInfo() {
		// ���ݹ��Ų���
		int size = workerInfoPut.size();
		for (int i = 0; i < size; i++) {
			Info info = (Info) workerInfoPut.get(i);
			System.out.println("��ţ�" + (i + 1) + ",������" + info.name + "�����ţ�" + info.num + "�����֤���룺" + info.id + "����ַ��"
					+ info.address + "���绰��" + info.tel + "�����ţ�" + info.branch + "�����룺" + info.income + "������ʱ�䣺"
					+ info.starJob + "��רҵ��" + info.subject + "��ְλ��" + info.post + "����ע��Ϣ��" + info.reMark);
		}
		System.out.println("������Ҫɾ����Ա�����ţ�");
        //debug�ν⣿
		Info delInfo = null;
		String num = scanner.next();
		System.out.println("Debug: input" + num);

		for (Info info : workerInfoPut) {
			System.out.println("Debug: list" + info.getNum());
			if (info.getNum().trim().equals(num.trim())) {
				delInfo = info;
				System.out.println("Debug: find the stuff��" + info.getNum());
				break;
			}
		}
		if (delInfo != null) {
			// ɾ��
			System.out.println("Debug: delete");
			workerInfoPut.remove(delInfo);
			searchInfo();
		} else {
			System.out.println("û�и�Ա����Ϣ");
		}
		/*
		 * ɾ��Ա����Ϣ�󣬸��´洢
		 */
		DataOpt.save(workerInfoPut);
	}
	
	public void Serial(){
		//String serialPath="e:\\workerinfotest.txt";
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(serialPath));
			oos.writeObject(workerInfoPut);
			System.out.println("���л����");
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void readInformation(){
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(serialPath));
			List<Info> Information;
			try {
				Information=(List<Info>) ois.readObject();
				System.out.println();
				ois.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Workers work1 = new Workers();

		work1.init();
		for (int i = 0; i < 1;) {
			System.out.println("��ѡ����Ҫִ�еĲ�����1.��ӣ�2.�޸ģ�3.ɾ����4.��ʾԱ����Ϣ��5.�˳�");

			int c = Integer.parseInt(scanner.next());
			if (c == 1) {
				work1.workerAdd();
				work1.Serial();
			}
			if (c == 2) {
				work1.InfoModify();
				work1.Serial();
			}
			if (c == 3) {
				work1.delInfo();
				work1.Serial();     
			}
			if (c == 4) {
				work1.searchInfo1();;
			}
			if (c == 5) {
				i = i + 2;
				System.out.println("�������н�����");
			}
			if (c > 5 || c < 1) {
				System.out.println("û�и�ѡ�������ѡ��");
				
			}

		}
		scanner.close();
	}
}