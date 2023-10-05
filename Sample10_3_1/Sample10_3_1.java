import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Sample10_3_1 {
	public static void main(String[] args) {
		String buf;
		int i = 0;
		boolean flag = true;
		
		try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			while(flag) {
				buf = br.readLine();
				if(buf != null) {
					i++;
					System.out.println(i + ": " + buf);
				} else {
					flag = false;
				}
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ファイル名を指定してください");
			System.exit(1);
		} catch(IOException e) {
			System.out.println("ファイルアクセスエラー : " + e);
		}
	}
}