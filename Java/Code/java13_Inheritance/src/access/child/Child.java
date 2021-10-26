package access.child;
/*
 * Parent의 자식 클래스
 */

import access.parent.Parent;

public class Child extends Parent{
	@Override
	public void access() {
		System.out.println(publicTest);		//접근 허용
		System.out.println(protectedTest);	//접근 허용
//		System.out.println(defaultTest); 	//접근 x (not visible)
//		System.out.println(privateTest); 	//접근 x (not visible)
		
		System.out.println("상속관계시 public, protected 지정자만 접근가능");
		
	}

}
