import java.util.StringTokenizer;
import java.util.NoSuchElementException;
import java.text.DecimalFormat;

public class Q10_2 {
	public static void main(String[] args) {
		final String STR_COMMA = ",";
		
		KeyIn ki = new KeyIn();
		FileIn fi = new FileIn();
		
		boolean ret = false;
		while(ret != true) {
			String fname = ki.readString("入力ファイル名:");
			ret = fi.open(fname);
		}
		
		int ageTotal = 0;
		int salTotal = 0;
		int count = 0;
		while(true) {
			String buf = fi.readLine();
			if(buf == null) break;
			try {
				StringTokenizer tkn = new StringTokenizer(buf, STR_COMMA);
				String dummy = tkn.nextToken();
				ageTotal += Integer.parseInt(tkn.nextToken());
				salTotal += Integer.parseInt(tkn.nextToken());
			} catch(NoSuchElementException e) {
				System.out.println("データに誤りがあります : " + buf);
				System.out.println("プログラムを異常終了します : " + e);
				fi.close();
				System.exit(1);
			} catch(NumberFormatException e) {
				System.out.println("データに誤りがあります : " + buf);
				System.out.println("プログラムを異常終了します : " + e);
				fi.close();
				System.exit(1);
			} catch(Exception e) {
				System.out.println("予期せぬエラーでプログラムを異常終了します : " + e);
				fi.close();
				System.exit(1);
			}
			/*
			StringTokenizerクラスは互換性のために保持されているという記述がリファレンスにあったので
			推奨されていたString.splitメソッドで記述してみる
			try-catchの部分を置き換える
			正しい記述のデータを読み込んで動作することを確認した
			*/
			// try {
			// 	String[] spl = buf.split(STR_COMMA);
			// 	ageTotal += Integer.parseInt(spl[1]);
			// 	salTotal += Integer.parseInt(spl[2]);
			// } catch(NumberFormatException e) {
			// 	System.out.println("データに誤りがあります : " + buf);
			// 	System.out.println("プログラムを異常終了します : " + e);
			// 	fi.close();
			// 	System.exit(1);
			// } catch(ArrayIndexOutOfBoundsException e) {
			// 	System.out.println("データに誤りがあります : " + buf);
			// 	System.out.println("プログラムを異常終了します : " + e);
			// 	fi.close();
			// 	System.exit(1);
			// } catch(Exception e) {
			// 	System.out.println("予期せぬエラーでプログラムを異常終了します : " + e);
			// 	fi.close();
			// 	System.exit(1);
			// }
			count++;
		}
		
		ret = fi.close();
		if(ret == false) {
			System.out.println("プログラムを異常終了します");
			System.exit(1);
		}
		
		System.out.println(count + "件のデータを入力しました");
		if(count != 0) {
			int ageAvg = ageTotal / count;
			int salAvg = salTotal / count;
			System.out.println("平均年齢 : " + ageAvg + "歳");
			DecimalFormat form = new DecimalFormat();
			form.applyPattern("###,###,###円");
			System.out.println("平均給与 : " + form.format(salAvg));
		}
	}
}