package access.child;
/*
 * Parent�� �ڽ� Ŭ����
 */

import access.parent.Parent;

public class Child extends Parent{
	@Override
	public void access() {
		System.out.println(publicTest);		//���� ���
		System.out.println(protectedTest);	//���� ���
//		System.out.println(defaultTest); 	//���� x (not visible)
//		System.out.println(privateTest); 	//���� x (not visible)
		
		System.out.println("��Ӱ���� public, protected �����ڸ� ���ٰ���");
		
	}

}
