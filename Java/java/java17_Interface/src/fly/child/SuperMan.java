package fly.child;

import fly.parent.Flyer;

public class SuperMan implements Flyer{

	@Override
	public void fly() {
		System.out.println("SuperMan fly");
		
	}

	@Override
	public void land() {
		System.out.println("SuperMan land");
		
	}

	@Override
	public void take_off() {
		System.out.println("SuperMan take off");
		
	}
	
	//SuperMan만의 기능
	public String stop_bullet() {
		return "총알을 막다";
	}

}
