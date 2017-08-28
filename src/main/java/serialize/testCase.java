package serialize;

public class testCase
{

	public static void main(String[] args)
	{
		// test serializable
		SerializableExample serial = new SerializableExample();
		serial.testSerialize();
		serial.testDeserialize();
		
		// test externalizable
		ExternalizableExample external = new ExternalizableExample();
		external.testSerialize();
		external.testDeserialize();
	}

}
