package com.example.androidtest;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity{
	String filestr="你好吗";
	String str = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(fileWrite(filestr)){//写入文件
			Log.i("info","写入成功,正在读取文件");
			str=fileRead();//从文件读取
		}
		
	}
	
	//写入文件
	public boolean fileWrite(String filestr){
		boolean flag=false;
		try {
			FileOutputStream fos = openFileOutput("a.txt",MODE_PRIVATE);
			fos.write(filestr.getBytes());
			fos.close();
			flag=true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	
	//读取文件内容
	public String fileRead(){
		String content = null;
		try {
			FileInputStream fis = openFileInput("a.txt");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len=0;
			while((len=fis.read(buffer))!=-1){
				baos.write(buffer,0,len);	
			}
			content = baos.toString();
			fis.close();
			baos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
	

}
