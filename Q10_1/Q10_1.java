public class Q10_1 {
	public static void main(String[] args) {
		final String STR_COMMA = ",";
		
		FileOut fo = new FileOut();
		KeyIn ki = new KeyIn();
		
		boolean ret = false;
		String fname;
		while(ret != true) {
			fname = ki.readString("出力ファイル名:");
			ret = fo.open(fname);
		}
		
		int count = 0;
		while(true) {
			int age = ki.readInt((count + 1) + "人目の年齢:");
			if(age == 999) break;
			int salary = ki.readInt((count + 1) + "人目の給与:");
			String buf = Integer.toString(count + 1) + STR_COMMA + Integer.toString(age) + STR_COMMA + Integer.toString(salary);
			ret = fo.writeln(buf);
			if(ret == false) {
				fo.close();
				System.out.println("プログラムを異常終了します");
				System.exit(1);
			}
			count++;
		}
		
		ret = fo.close();
		if(ret == false) {
			System.out.println("プログラムを異常終了します");
			System.exit(1);
		}
		System.out.println(count + "件のデータをファイルに出力しました");
	}
}