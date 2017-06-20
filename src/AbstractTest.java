
public abstract class AbstractTest {


	private static IFactory factory;

	static {
		try {
			factory = (IFactory) Class.forName("Factory").newInstance();
		}
		catch (Exception e) {
			System.err.println("cannot load factory class: " + e.getMessage());
		}
	}

	protected static IFactory getFactory() {
		return factory;
	}


}