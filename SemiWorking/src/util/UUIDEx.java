package util;

import java.util.UUID;

public class UUIDEx {
	public static void main(String[] args) {

		// 1. ê°ì²´ ?ƒ?„±
		UUID uuid = UUID.randomUUID();
		
		// 2. String ???…?œ¼ë¡? ë³??™˜
		String u = uuid.toString();
		System.out.println(u);
		
		//3. split("-")?„ ?´?š©?•˜?—¬ ?‚¬?š©
		String res = u.split("-")[4]; //12?ë¦? uuid
		
		//4. ?‚¬?š©
		System.out.println(res);
		
		//* 16?ë¦? ?ƒ?‚°
		System.out.println(u.split("-")[4]+u.split("-")[3]);
		
		
	}
}
