package util;

import java.util.UUID;

public class UUIDEx {
	public static void main(String[] args) {

		// 1. 객체 생성
		UUID uuid = UUID.randomUUID();
		
		// 2. String 타입으로 변환
		String u = uuid.toString();
		System.out.println(u);
		
		//3. split("-")을 이용하여 사용
		String res = u.split("-")[4]; //12자리 uuid
		
		//4. 사용
		System.out.println(res);
		
		//* 16자리 생산
		System.out.println(u.split("-")[4]+u.split("-")[3]);
		
		
	}
}
