package servlet.controller;

public class ControllerFactory {
	//싱글톤
	private static ControllerFactory factory =new ControllerFactory();
	private ControllerFactory() {
		System.out.println("Only One Factory Creating...");
	}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	//Command 값에 따라서 Component를 생성하는 기능...
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find")) {
			controller = new FindController();
			
		}else if(command.equals("register")) {
			controller = new RegisterController();
			
		}
		return controller;

	}

}
