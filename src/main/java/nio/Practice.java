package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Practice
{

	public static void main(String[] args)
	{
		try
		{
			FileInputStream inputStream = new FileInputStream("source.txt");
			FileChannel inputChannel = inputStream.getChannel();
			
			FileOutputStream outputStream = new FileOutputStream("destination.txt");
			FileChannel outputChannel = outputStream.getChannel();
			
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			
			while (true)
			{
				buffer.clear();
				int result = inputChannel.read(buffer);
				
				if (result == -1)
					break;
				
				buffer.flip();
				outputChannel.write(buffer);
			}
			
			inputStream.close();
			outputStream.close();
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
