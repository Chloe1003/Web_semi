package util;

import java.util.UUID;

public class UUIDEx {
	public static void main(String[] args) {

		// 1. κ°μ²΄ ??±
		UUID uuid = UUID.randomUUID();
		
		// 2. String ????Όλ‘? λ³??
		String u = uuid.toString();
		System.out.println(u);
		
		//3. split("-")? ?΄?©??¬ ?¬?©
		String res = u.split("-")[4]; //12?λ¦? uuid
		
		//4. ?¬?©
		System.out.println(res);
		
		//* 16?λ¦? ??°
		System.out.println(u.split("-")[4]+u.split("-")[3]);
		
		
	}
}
