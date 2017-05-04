package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;

public class TestDataProvider {
	private String filePath;
	private String nextLine[];
	List<String[]> approvalist  = new ArrayList<String[]>();
	CSVReader reader;
	private String value;
	
	public TestDataProvider(String filePath){
		this.filePath = filePath;
	}
	
	public String getTestData(String columnName,String lineName){
		/*
		 * 将csv文件数据按行读取到List approvalist中
		 */
		try {
			//读取csv文件的数据到CSVReader中
			reader = new CSVReader(new FileReader(filePath));
			try {
				//将reader中的每一行添加到approvalist集合中
				while((nextLine = reader.readNext()) != null){
					approvalist.add(nextLine);
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		int count = 0;
		int index = 0;
		/*
		 * 获取指定列
		 */
		// 利用for循环遍历集合的第一行 （一个String字符串）
		for( String i:approvalist.get(0)){
			//找到columnName字符后跳出循环
			if(i.equals(columnName)){
				index = count;
				break;
			}
			count++;
		}
		/*
		 * 获取指定行
		 */
		//利用for循环遍历集合
		for(String[] j:approvalist){
			//如果字符串数组j的第一个元素和lineName相同，即找到了一个唯一的元素
			//则打印出它的第index元素并跳出循，
			if(j[0].equals(lineName)){
				value = j[index].toString();
				break;
			}
		}
		
		return value;
	}

	public static void main(String[] args){
		TestDataProvider a = new TestDataProvider(System.getProperty("user.dir")+"\\src\\test\\resources\\userInfo.csv");
		
		System.out.println(a.getTestData("username", "tc1")+":"+a.getTestData("password", "tc1"));
		
	}
}