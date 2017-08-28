package nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;


public class MemoryMappedFile
{

	public static void main(String[] args)
	{
		final int count = 1048576;	// 1M
		
		try
		{
			// 测试使用 Memory Mapped File 時的速度
			RandomAccessFile accessFile = new RandomAccessFile("source.txt", "rw");
			MappedByteBuffer buffer = accessFile.getChannel().map(MapMode.READ_WRITE, 0, count);
			byte c = (byte)'a';
		
			long start = System.currentTimeMillis();
			
			for (int i = 0; i < count; i++)
				buffer.put(c);
			
			System.out.println("Mapped Writing complete!: " + (System.currentTimeMillis() - start));
			
			accessFile.close();
			
			
			// 测试没用 Memory Mapped File 時的速度
			FileOutputStream outputStream = new FileOutputStream("source1.txt");
			FileChannel channel = outputStream.getChannel();
			ByteBuffer buffer1 = ByteBuffer.allocate(count);
			
			start = System.currentTimeMillis();
			
			for (int i = 0; i < count; i++)
				buffer1.put(c);
			
			buffer1.flip();
			channel.write(buffer1);
			
			System.out.println("Normal Writing complete!: " + (System.currentTimeMillis() - start));	
			
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
