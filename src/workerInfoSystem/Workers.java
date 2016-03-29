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
	 * 这里的容器接口最好先确定类型 List<Info> workerInfoPut
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
		 * 初始化时读入存储内容
		 */
		workerInfoPut = DataOpt.read();
	}

	// 添加课程的方法
	public void workerAdd() {
		System.out.println("-------------------------------添加功能----------------------------------");
		System.out.println("请输入您需要添加的员工人数：");
		/*
		 * scanner 使用完毕需要close
		 */

		int size = Integer.parseInt(scanner.next());
		for (int i = 0; i < size; i++) {
			int n = i + 1;
			System.out.println("添加序号:" + n);
			System.out.println("请输入该职员的工号：");

			String num = scanner.next();
			System.out.println("已录入该职员的工号：" + num);
			System.out.println("请输入该职员的姓名：");

			String name = scanner.next();
			System.out.println("已录入该职员的姓名：" + name);
			System.out.println("请输入该职员的身份证号码：");

			String id = scanner.next();
			System.out.println("已录入该职员的身份证号码：" + id);
			System.out.println("请输入该职员的地址：");

			String address = scanner.next();
			System.out.println("已录入该职员的地址：" + address);
			System.out.println("请输入该职员的电话：");

			String tel = scanner.next();
			System.out.println("已录入该职员的电话：" + tel);
			System.out.println("请输入该职员的部门：");

			String branch = scanner.next();
			System.out.println("已录入该职员的部门：" + branch);
			System.out.println("请输入该职员的收入：");

			String income = scanner.next();
			System.out.println("已录入该职员的收入：" + income);
			System.out.println("请输入该职员的入行时间：");

			String starJob = scanner.next();
			System.out.println("已录入该职员的入行时间：" + starJob);
			System.out.println("请输入该职员的专业：");

			String subject = scanner.next();
			System.out.println("已录入该职员的专业：" + subject);
			System.out.println("请输入该职员的职位：");

			String post = scanner.next();
			System.out.println("已录入该职员的职位：" + post);
			System.out.println("请输入备注：");

			String reMark = scanner.next();
			System.out.println("备注信息：" + reMark);

			Info info = new Info(n, num, name, id, address, tel, branch, income, starJob, subject, post, reMark);
			/*
			 * 凡是出现warning的地方，你都可以看看是什么原因 然后去除，代码才会强壮
			 */
			workerInfoPut.add(info);
			/*
			 * 添加新员工后，更新存储内容
			 */
			DataOpt.save(workerInfoPut);
		    DataSerial.save(workerInfoPut);
			System.out.println("添加了第" + n + "名员工：" + name + "的相关信息。");
		}
	}

	// 员工信息汇总打印输出
	public void searchInfo() {
		System.out.println("本单位员工信息汇总如下：");
		int size = workerInfoPut.size();
		for (int i = 0; i < size; i++) {
			Info info = (Info) workerInfoPut.get(i);
			System.out.println("序号：" + (i + 1) + ",姓名：" + info.name + "；工号：" + info.num + "；身份证号码：" + info.id + "；地址："
					+ info.address + "；电话：" + info.tel + "；部门：" + info.branch + "；收入：" + info.income + "；入行时间："
					+ info.starJob + "；专业：" + info.subject + "；职位：" + info.post + "；备注信息：" + info.reMark);
		}
	}
	/*
	 * 用序列化的方式读取已保存的文档并输出
	 */
	public void searchInfo1() {
		System.out.println("本单位员工信息汇总如下：");
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("e:\\workerinfotest.txt"));
			List list2;
			try {
				list2=(List) ois.readObject();
				int size=list2.size();
				for (int i = 0; i < size; i++) {
					Info info = (Info) workerInfoPut.get(i);
					
					System.out.println("序号：" + (i + 1) + ",姓名：" + info.name + "；工号：" + info.num + "；身份证号码：" + info.id + "；地址："
							+ info.address + "；电话：" + info.tel + "；部门：" + info.branch + "；收入：" + info.income + "；入行时间："
							+ info.starJob + "；专业：" + info.subject + "；职位：" + info.post + "；备注信息：" + info.reMark);
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

	// 员工信息修改
	public void InfoModify() {
		System.out.println("-------------------------------修改功能----------------------------------");
		System.out.println("请选择需要修改的人员序号：");
		int size = workerInfoPut.size();
		for (int i = 0; i < size; i++) {
			Info info = (Info) workerInfoPut.get(i);
			System.out.println("序号：" + (i + 1) + ",姓名：" + info.name + "；工号：" + info.num + "；身份证号码：" + info.id + "；地址："
					+ info.address + "；电话：" + info.tel + "；部门：" + info.branch + "；收入：" + info.income + "；入行时间："
					+ info.starJob + "；专业：" + info.subject + "；职位：" + info.post + "；备注信息：" + info.reMark);
		}
/*
 * 所输入的信息规格：姓名，2-3个字的中文。工号，7位，，1开头开头两位数不超过16，不能重复。身份证号码，18位纯数字，滴7-10位为1900-1998.第11-12位为01-12，第13-14位为01-31，电话为1开头的11位数字
 * 入行时间为6位纯数字，其中第3-4位要等于工号的前两位 专业 职位 备注信息为纯中文
 */
		int m = Integer.parseInt(scanner.next());
		
		  for(int i=0;i<1;){
		System.out.println("请输入该职员的姓名：");
		String name1 = scanner.next();
		String regex1="[\u4e00-\u9fa5]";
		Pattern p1=Pattern.compile(regex1);
	    Matcher m1=p1.matcher(name1);
	    boolean test1=m1.find();
	    if(test1==false){
	    	System.out.println("您输入的姓名无效，请重新输入");
	    }else{
	    	name=name1;
	    	System.out.println("已录入该职员的姓名：" + name);
	    	i=1;
	    }
	    }
		 
		  for(int i=0;i<1;){
		System.out.println("请输入该职员的身份证号码：");
		String id1 = scanner.next();
		  String regex3="\\d{17}[\\d|x]|\\d{15}";
	        Pattern p3=Pattern.compile(regex3);
	        Matcher m3=p3.matcher(id1);
	        boolean test3=m3.matches();
	        if(test3==false){
	        	System.out.println("您输入的身份证号码无效，请重新输入");
	        }else{
	        	id=id1;
	        	System.out.println("已录入该职员的身份证号码：" + id);
	        	i=1;
	        }
	        }
		
		  for(int i=0;i<1;){
	    	Date date=new Date();
	    	DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	String time=format.format(date);
	    	int year=Integer.parseInt(time.substring(2, 4));
	        System.out.println("请输入您的工号：");
	        String num1=scanner.next();
	        System.out.println("请输入您的入行时间：");
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
	        	System.out.println("您输入的工号或入行时间无效，请重新输入");
	        }else{
	        	num=num1;
	        	starJob=starJob1;
	        	System.out.println("已录入该职员工号和入行时间："+num+","+starJob);
	        	i=1;
	        }
	        }
		  
			System.out.println("请输入该职员的地址：");
			String address = scanner.next();
			System.out.println("已录入该职员的地址：" + address);
		
		
		  for(int i=0;i<1;){
			    System.out.println("请输入您的电话号码：");
			    String tel1=scanner.next();
			    String regex2="0?(13|14|15|18)[0-9]{9}";
			    Pattern p2=Pattern.compile(regex2);
			    Matcher m2=p2.matcher(tel1);
			    boolean test2=m2.matches();
			    if(test2==false){
			    	System.out.println("您输入的电话号码无效，请重新输入");
			    }else{
			    	tel=tel1;
			    	System.out.println("已录入该职员工电话："+tel);
			    	i=1;
			    }
			    }
		  
		  for(int i=0;i<1;){
				System.out.println("请输入该职员的部门：");
				String branch1 = scanner.next();
				String regex1="[\u4e00-\u9fa5]";
				Pattern p1=Pattern.compile(regex1);
			    Matcher m1=p1.matcher(branch1);
			    boolean test2=m1.find();
			    if(test2==false){
			    	System.out.println("您输入的部门无效，请重新输入");
			    }else{
			    	branch=branch1;
			    	System.out.println("已录入该职员的部门：" + branch);
			    	i=1;
			    }
			    }  
		  for(int i=0;i<1;){
			        System.out.println("请输入您的收入：");
			        String income1=scanner.next();
			        String regex6="-?[1-9]\\d*";
			        Pattern p6=Pattern.compile(regex6);
			        Matcher m6=p6.matcher(income1);
			        boolean test6=m6.matches();
			        if(test6==false){
			        	System.out.println("您输入的收入无效，请重新输入");
			        }else{
			        	income=income1;
			        	System.out.println("已录入该职员工工资："+income);
			        	i=1;
			        }
			        }
		
		  for(int i=0;i<1;){
				System.out.println("请输入该职员的专业：");
				String subject1 = scanner.next();
				String regex1="[\u4e00-\u9fa5]";
				Pattern p1=Pattern.compile(regex1);
			    Matcher m1=p1.matcher(subject1);
			    boolean test2=m1.find();
			    if(test2==false){
			    	System.out.println("您输入的专业无效，请重新输入");
			    }else{
			    	subject=subject1;
			    	System.out.println("已录入该职员的专业：" + subject);
			    	i=1;
			    }
		  }  
		
		  for(int i=0;i<1;){
				System.out.println("请输入该职员的职位：");
				String post1 = scanner.next();
				String regex1="[\u4e00-\u9fa5]";
				Pattern p1=Pattern.compile(regex1);
			    Matcher m1=p1.matcher(post1);
			    boolean test2=m1.find();
			    if(test2==false){
			    	System.out.println("您输入的职位无效，请重新输入");
			    }else{
			    	post=post1;
			    	System.out.println("已录入该职员的职位：" + post);
			    	i=1;
			    }
			    }  
		System.out.println("请输入备注：");
		String reMark = scanner.next();
		System.out.println("备注信息：" + reMark);
		
		workerInfoPut.set((m-1),new Info(m, num, name, id, address, tel, branch, income, starJob, subject, post, reMark));
		/*
		 * 修改员工信息后，更新存储内容
		 */
		DataOpt.save(workerInfoPut);
		System.out.println("修改后的单位员工信息为：");
		Info info = (Info) workerInfoPut.get(m - 1);
		System.out.println("序号：" + (m) + ",姓名：" + info.name + "；工号：" + info.num + "；身份证号码：" + info.id + "；地址："
				+ info.address + "；电话：" + info.tel + "；部门：" + info.branch + "；收入：" + info.income + "；入行时间："
				+ info.starJob + "；专业：" + info.subject + "；职位：" + info.post + "；备注信息：" + info.reMark);
	}

	/**
	 * 这里的删除一般要根据工号进行删除： 在workerInfoPut里面查找匹配
	 *
	 */
	public void delInfo() {
		// 根据工号查找
		int size = workerInfoPut.size();
		for (int i = 0; i < size; i++) {
			Info info = (Info) workerInfoPut.get(i);
			System.out.println("序号：" + (i + 1) + ",姓名：" + info.name + "；工号：" + info.num + "；身份证号码：" + info.id + "；地址："
					+ info.address + "；电话：" + info.tel + "；部门：" + info.branch + "；收入：" + info.income + "；入行时间："
					+ info.starJob + "；专业：" + info.subject + "；职位：" + info.post + "；备注信息：" + info.reMark);
		}
		System.out.println("请输入要删除的员工工号：");
        //debug何解？
		Info delInfo = null;
		String num = scanner.next();
		System.out.println("Debug: input" + num);

		for (Info info : workerInfoPut) {
			System.out.println("Debug: list" + info.getNum());
			if (info.getNum().trim().equals(num.trim())) {
				delInfo = info;
				System.out.println("Debug: find the stuff：" + info.getNum());
				break;
			}
		}
		if (delInfo != null) {
			// 删除
			System.out.println("Debug: delete");
			workerInfoPut.remove(delInfo);
			searchInfo();
		} else {
			System.out.println("没有该员工信息");
		}
		/*
		 * 删除员工信息后，更新存储
		 */
		DataOpt.save(workerInfoPut);
	}
	
	public void Serial(){
		//String serialPath="e:\\workerinfotest.txt";
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(serialPath));
			oos.writeObject(workerInfoPut);
			System.out.println("序列化完成");
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
			System.out.println("请选择需要执行的操作：1.添加；2.修改；3.删除；4.显示员工信息；5.退出");

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
				System.out.println("程序运行结束！");
			}
			if (c > 5 || c < 1) {
				System.out.println("没有该选项，请重新选择");
				
			}

		}
		scanner.close();
	}
}