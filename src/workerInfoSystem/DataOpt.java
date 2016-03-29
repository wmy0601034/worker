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
			File file = new File("D:\\data.txt");//创建了一个TXT文件
			FileOutputStream fos = new FileOutputStream(file, false);//false表示如果文件不存在，如果文件存在，则每执行程序一次便往文件追加一次内容，否则会每一次的执行都覆盖了上一次的执行结果
			BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(fos));//将fos封装为具有缓存功能的文件输出流
			for (Info l : list){
				try {
					bw.write(l.simple_serial() + "\n");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			bw.close();//关闭bw实例调用的BufferedWriter操作
			fos.close();//关闭fos实例调用的FileOutputStream操作
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static List<Info> read() {
		List<Info> re = new ArrayList<Info>();//新建一个名为re的List
		String filePath = "D:\\data.txt";//定义路径
		/*
		 * 判断文件是否存在，如果不存在，直接返回
		 * */
		if(!isExist(filePath)){
			return re;
		}
		try {
			FileInputStream fis = new FileInputStream(filePath);//新建一个文件输入流fis，路径为filePath被赋予的值"D:\\data.txt"
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));//将fis封装为具有缓存功能的文件输入流
			String str = null;//定义一个空的字符串str
			 while ((str = br.readLine()) != null)//对缓存区的内容逐行读取。并将读取到的内容赋值给str
	         {
				 re.add(Info.simple_deserial(str));//将被赋了值的str添加到re这个List中
	         }//重复该操作，直至最后一行之后，str为null停止
			 br.close();//关闭br实例调用的BufferedReader操作
			 fis.close();//关闭fis实例调用的FileInputStream操作
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
