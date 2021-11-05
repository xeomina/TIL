package fly.child;

import fly.parent.Flyer;

/*
 * 인터페이스를 상속받는 클래스는
 * 반드시 인터페이스의 추상 메소드를 구현해야 한다
 * - implements
 */
public class Bird implements Flyer{

	@Override
	public void fly() {
		System.out.println("Bird fly");
		
	}

	@Override
	public void land() {
		System.out.println("Bird land");
		
	}

	@Override
	public void take_off() {
		System.out.println("Bird take off");
		
	}
	
	//Bird만의 기능
	public String layEggs() {
		return "알을 낳다";
	}

	public String buildNest() {
		return "둥지를 짓다";
	}

}
