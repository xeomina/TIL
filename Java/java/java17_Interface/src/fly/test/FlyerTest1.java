package fly.test;

import fly.child.Airplane;
import fly.child.Bird;
import fly.child.SuperMan;
import fly.parent.Flyer;

/* 
 * �������̽��� ��ü ���� ����� �� �� ����
 */

public class FlyerTest1 {

	public static void main(String[] args) {
//		Flyer f1 = new Flyer();		//����
		
		//�������̽��� ��ü ���� ����� �� ������ Type���μ��� �����Ѵ�
		//Polymorphism	: �θ� Ÿ������ �پ��� �ڽ� ��ü ����
		Flyer bird = new Bird();	
		Flyer airplane = new Airplane();
		Flyer superman = new SuperMan();
		
		Flyer[] flyers = {
				bird, airplane, superman
		};
		
		for(Flyer f : flyers) {
			if(f instanceof Bird) {
				System.out.println(((Bird) f).layEggs());
				f.fly();
				f.land();
				System.out.println("---------------------");
			}
			if(f instanceof SuperMan) {
				System.out.println(((SuperMan) f).stop_bullet());
				f.fly();
				f.land();
				System.out.println("---------------------");
			}
		}
		
		

	}

}
