package com.jida.client;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;



public class Stream {
	/**
	 * 读入流文件
	 * @param str
	 * @return
	 */
	public static String[] handle(String path){
		String [] sa = new String [0];
		List<String> ls = new ArrayList<String>();
		try {
//			URI uri = new String().getClass().getResource(path).toURI();
//		System.out.println("Stream.handle:"+uri);
			FileReader fr = new FileReader(new File(path));
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null)
				ls.add(line);
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls.toArray(sa);
	}

	public static void write(String str,String path){
		try {
			FileWriter fw = new FileWriter(path, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(str);
			bw.newLine();
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


