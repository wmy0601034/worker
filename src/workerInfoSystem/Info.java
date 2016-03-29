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
	 * ����Ա����������л�Ϊ�ַ�����ʽ
	 * */
	public String simple_serial(){//simple_serialΪ�����л�����˼��Public String simple_serial������һ����������ΪString����Ϊsimple_serial�ķ���
		return this.n + "\t" + this.num + "\t" + this.name+"\t"+this.id+"\t" + 
	        this.address+"\t" + this.tel + "\t" +this.branch + "\t" +this.income+
	        "\t" + this.starJob + "\t" + this.subject + "\t" + this.post + "\t" + 
	        this.reMark; 
	}
	/*
	 * ��̬�����������ַ�����������Ա������
	 * */
	public static Info simple_deserial(String data) {
		Info re = new Info();//ΪInfo�ඨ��һ��re��ʵ��
		String [] items = data.split("\t");//��data��������"\t"Ϊ�ָ������зָ�����ָ���ֵ����String�ַ�����items
		re.n = Integer.parseInt(items[0]);//��items�ַ��������±�Ϊ"0"���ַ�����ֵ��re���ʵ���е�n
		re.num = items[1];//ͬ��
		re.name= items[2];//ͬ��
		re.id= items[3];//ͬ��
		re.address=items[4];//ͬ��
		re.tel= items[5];//ͬ��
		re.branch=items[6];//ͬ��
		re.income =items[7];//ͬ��
		re.starJob= items[8];//ͬ��
		re.subject= items[9];//ͬ��
		re.post=items[10];//ͬ��
		re.reMark= items[11];//ͬ��
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
	 *һ�㽫���Ա�������ó�˽�����ͣ�ͨ��
	 *getter��setter����
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
