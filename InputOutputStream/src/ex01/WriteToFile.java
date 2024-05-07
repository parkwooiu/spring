package ex01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteToFile {

	public static void main(String[] args) {
		
		OutputStream out;
		
	try {
		
		//문자 단위 저장 vs 바이트 단위
		//출력스트림 생성
		out = new FileOutputStream("c:\\upload\\data.dat");
		out.write(65);
		System.out.println("저장............");
		out.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}

	}
}
