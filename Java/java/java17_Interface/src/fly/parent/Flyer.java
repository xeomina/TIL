package fly.parent;
/*
 * 인터페이스는 구현부가 없는 기능의 템플릿(추상적인 기능)들만으로 구성된다
 * 
 * 인터페이스의 구성 요소
 * 1)public abstract 메소드 - 추상 메소드 (Template 기능)
 * 2)public static final 변수 - 필드가 아닌 상수
 * 
 */
public interface Flyer {
	int SPEED = 100;	//인터페이스 안에서는 무조건 변수 앞에 public static final이 붙는다 - 상수
	
	//구현부가 없는 메소드 선언일때는 abstract 키워드를 붙여야한다 
	public abstract void fly();		//어떻게 구체적으로 fly하는지는 명시되어있지 않음 - 구현부x
	void land();	//인터페이스 안에서는 무조건 메소드 앞에 public abstract이 붙는다 - 추상 메소드
	void take_off();
	

}
