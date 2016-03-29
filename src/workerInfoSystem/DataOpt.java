package workerInfoSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class DataOpt {
	
	//String serialPath="e:\\workerinfotest.txt";
	
	public static void save(List<Info> list){
		try {
			File file = new File("D:\\data.txt");//������һ��TXT�ļ�
			FileOutputStream fos = new FileOutputStream(file, false);//false��ʾ����ļ������ڣ�����ļ����ڣ���ÿִ�г���һ�α����ļ�׷��һ�����ݣ������ÿһ�ε�ִ�ж���������һ�ε�ִ�н��
			BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(fos));//��fos��װΪ���л��湦�ܵ��ļ������
			for (Info l : list){
				try {
					bw.write(l.simple_serial() + "\n");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			bw.close();//�ر�bwʵ�����õ�BufferedWriter����
			fos.close();//�ر�fosʵ�����õ�FileOutputStream����
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static List<Info> read() {
		List<Info> re = new ArrayList<Info>();//�½�һ����Ϊre��List
		String filePath = "D:\\data.txt";//����·��
		/*
		 * �ж��ļ��Ƿ���ڣ���������ڣ�ֱ�ӷ���
		 * */
		if(!isExist(filePath)){
			return re;
		}
		try {
			FileInputStream fis = new FileInputStream(filePath);//�½�һ���ļ�������fis��·��ΪfilePath�������ֵ"D:\\data.txt"
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));//��fis��װΪ���л��湦�ܵ��ļ�������
			String str = null;//����һ���յ��ַ���str
			 while ((str = br.readLine()) != null)//�Ի��������������ж�ȡ��������ȡ�������ݸ�ֵ��str
	         {
				 re.add(Info.simple_deserial(str));//��������ֵ��str��ӵ�re���List��
	         }//�ظ��ò�����ֱ�����һ��֮��strΪnullֹͣ
			 br.close();//�ر�brʵ�����õ�BufferedReader����
			 fis.close();//�ر�fisʵ�����õ�FileInputStream����
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

/*	public void Serial(List<Info> list){
		//String serialPath="e:\\workerinfotest.txt";
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("E:\\workerinfotest.txt"));
			for (Info l : list){
				try {
					oos.writeObject(list);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:\\workerinfotest.txt"));
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
	*/
	public static boolean isExist(String path) {
		  File file = new File(path);
		  return file.exists();
	}
}
