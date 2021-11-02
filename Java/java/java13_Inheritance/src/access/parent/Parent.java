package access.parent;
/*
 * Access Modifier 지정범위를 알아보는 로직을 작성
 * 각각의 필드에 접근지정자를 서로 다르게 지정
 * 각각의 서로 다른 클래스에서 해당 필드에 어떻게 접근하는지 확인
 */

public class Parent {
	public String publicTest = "publicTest";
	protected String protectedTest = "protectedTest";
	String defaultTest = "defaultTest";
	private String privateTest = "privateTest";
	
	public void access() {
		System.out.println("Access Modifier Test");
	}

}
