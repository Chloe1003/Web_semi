package util;

import java.util.UUID;

public class UUIDEx {
	public static void main(String[] args) {

		// 1. 객체 ?��?��
		UUID uuid = UUID.randomUUID();
		
		// 2. String ???��?���? �??��
		String u = uuid.toString();
		System.out.println(u);
		
		//3. split("-")?�� ?��?��?��?�� ?��?��
		String res = u.split("-")[4]; //12?���? uuid
		
		//4. ?��?��
		System.out.println(res);
		
		//* 16?���? ?��?��
		System.out.println(u.split("-")[4]+u.split("-")[3]);
		
		
	}
}
