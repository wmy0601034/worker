package workerInfoSystem;

import java.io.Serializable;

public class Info implements Serializable{
	//String serialPath="e:\\workerinfotest.txt";


	public Info(int n,String num,String name,String id,String address,String tel,String branch,String income,String starJob,String subject, String post,String reMark){
		this.n=n;
		this.num=num;
		this.name= name;
		this.id= id;
		this.address=address;
		this.tel= tel;
		this.branch=branch;
		this.income =income;
		this.starJob= starJob;
		this.subject= subject;
		this.post=post;
		this.reMark= reMark;

	}
	/*
	 * 根据员工对象简单序列化为字符串格式
	 * */
	public String simple_serial(){//simple_serial为简单序列化的意思，Public String simple_serial定义了一个返回类型为String的名为simple_serial的方法
		return this.n + "\t" + this.num + "\t" + this.name+"\t"+this.id+"\t" + 
	        this.address+"\t" + this.tel + "\t" +this.branch + "\t" +this.income+
	        "\t" + this.starJob + "\t" + this.subject + "\t" + this.post + "\t" + 
	        this.reMark; 
	}
	/*
	 * 静态函数，根据字符串内容生成员工对象
	 * */
	public static Info simple_deserial(String data) {
		Info re = new Info();//为Info类定义一个re的实例
		String [] items = data.split("\t");//将data的内容以"\t"为分隔符进行分割，并将分割后的值赋给String字符串组items
		re.n = Integer.parseInt(items[0]);//将items字符串组中下标为"0"的字符串赋值给re这个实例中的n
		re.num = items[1];//同上
		re.name= items[2];//同上
		re.id= items[3];//同上
		re.address=items[4];//同上
		re.tel= items[5];//同上
		re.branch=items[6];//同上
		re.income =items[7];//同上
		re.starJob= items[8];//同上
		re.subject= items[9];//同上
		re.post=items[10];//同上
		re.reMark= items[11];//同上
		return re;
	}
	


	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getStarJob() {
		return starJob;
	}
	public void setStarJob(String starJob) {
		this.starJob = starJob;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getReMark() {
		return reMark;
	}
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
	public Info(){		
	}
	
	
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		if(obj==null)
			return false;
		if(!(obj instanceof Info))
			return false;
		Info course=(Info) obj;
		if (this.name==null){
			if(course.name==null)
				return true;
			else
				return false;
		}
		else{
			if(this.name.equals(course.name))
				return true;
			else
				return false;
		}
	}
	/*
	 *一般将类成员变量设置成私有类型，通过
	 *getter和setter访问
	 * getNum(){
		return num; 
	   }
	   setNum(int num) {
		   this.num = num;
	   }
	*/
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
	String serialPath="e:\\workerinfotest.txt";
}
