package access.parent;
/*
 * Access Modifier ���������� �˾ƺ��� ������ �ۼ�
 * ������ �ʵ忡 ���������ڸ� ���� �ٸ��� ����
 * ������ ���� �ٸ� Ŭ�������� �ش� �ʵ忡 ��� �����ϴ��� Ȯ��
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
