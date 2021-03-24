package ocp.ch6.ExceptionsAndAssertions.CreatingCustomExceptions;

public class CreatingCustomExceptions {

	public static void main(String[] args) throws CannotSwimException {
		try {
			throw new Exception("exception");
		}catch (Exception e) {
			throw new CannotSwimException("my exception", e);
		}finally {
			throw new CannotSwimException("my exception 2");
		}
	}

}

class CannotSwimException extends Exception {
	public CannotSwimException() {
		super();
	}

	public CannotSwimException(Exception e) {
		super(e);
	}

	public CannotSwimException(String message) {
		super(message);
	}
	public CannotSwimException(String message,Exception ex) {
		super(message,ex);
	}
}

class DangerInTheWater extends RuntimeException {
}

class SharkInTheWaterException extends DangerInTheWater {
}

class Dolphin {
	public void swim() throws CannotSwimException {
// logic here
	}
}