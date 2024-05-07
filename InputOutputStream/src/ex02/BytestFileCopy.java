package ex02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class BytestFileCopy {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("대상 파일 : ");
		
		String src = sc.nextLine();
		
		try {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(src);
	
			byte[] bs ="korea".getBytes();
			
			out.write(bs);
			
			int data;
			
			while(true) {
				data = in.read();
				if(data == -1) {
					break;
				}
				out.write(data);
			}
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
