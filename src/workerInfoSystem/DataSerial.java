package workerInfoSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DataSerial {
	/*public void Serial(List<Info> list){
		//String serialPath="e:\\workerinfotest.txt";
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("E:\\infotest.txt"));
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
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:\\infotest.txt"));
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
	public static void save(List<Info> workerInfoPut) {
		// TODO Auto-generated method stub
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("E:\\infotest.txt"));
			for (Info l : workerInfoPut){
				try {
					oos.writeObject(workerInfoPut);
					
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
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:\\infotest.txt"));
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
	}

