import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Sample10_2_1 {
	public static void main(String[] args) {
		KeyIn ki = new KeyIn();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(args[0]))) {
			String buf;
			int i = 0;
			boolean flag = true;
			
			while(flag) {
				buf = ki.readString((i + 1) + ":");
				if(buf.length() != 0) {
					bw.write(buf);
					bw.newLine();
					i++;
				} else {
					flag = false;
				}
			}
			System.out.println(i + "件のデータを" + args[0] + "に書き込みました");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ファイル名を指定してください");
		} catch(IOException e) {
			System.out.println("ファイルアクセスエラー : " + e);
		}
	}
}