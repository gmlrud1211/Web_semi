package controller.admin.banners;

import java.util.UUID;

public class UUIDEx {
	public static void main(String[] args) {
		
		//1. UUID ��ü ����
		UUID uuid = UUID.randomUUID();
		
		//2. String Ÿ������ ��ȯ
		String u = uuid.toString();
		System.out.println(u);
		
		//3. split("-") �� �̿��Ͽ� ����Ѵ�
		String res = u.split("-")[4]; //12�ڸ� uuid
		
		//4. ���
		System.out.println(res);
		
		
		//++ 16�ڸ� ����
		System.out.println(u.split("-")[4]+u.split("-")[3]);
	}
}






