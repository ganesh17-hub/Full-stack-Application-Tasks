package Lion.Tiger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component

public class Set_DI {
	private Engine engine;
	@Autowired
	public void setEngine(Engine engine) {
		this.engine=engine;
	}
	public void drive() {
		engine.start();
		System.out.println("Car is movig from Setter DI...");
	}

}