package fly.parent;
/*
 * �������̽��� �����ΰ� ���� ����� ���ø�(�߻����� ���)�鸸���� �����ȴ�
 * 
 * �������̽��� ���� ���
 * 1)public abstract �޼ҵ� - �߻� �޼ҵ� (Template ���)
 * 2)public static final ���� - �ʵ尡 �ƴ� ���
 * 
 */
public interface Flyer {
	int SPEED = 100;	//�������̽� �ȿ����� ������ ���� �տ� public static final�� �ٴ´� - ���
	
	//�����ΰ� ���� �޼ҵ� �����϶��� abstract Ű���带 �ٿ����Ѵ� 
	public abstract void fly();		//��� ��ü������ fly�ϴ����� ��õǾ����� ���� - ������x
	void land();	//�������̽� �ȿ����� ������ �޼ҵ� �տ� public abstract�� �ٴ´� - �߻� �޼ҵ�
	void take_off();
	

}
