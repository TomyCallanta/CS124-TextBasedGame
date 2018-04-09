package maze;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import anno.*;

public class MazeMaker 
{

	private HashMap<Class, Object> roomMap = new HashMap<Class, Object>();
	
	public void load() throws Exception
	{
		// load all names
		FastClasspathScanner scanner = new FastClasspathScanner("room");
		ScanResult result = scanner.scan();
		
		List<String> allClasses = result.getNamesOfAllClasses();		
		System.out.println(allClasses);
		
		// instantiate
		for (String className : allClasses)
		{
			Class clazz = Class.forName(className);
			Object instance = clazz.newInstance();
			
			// associate the clazz to the instance
			roomMap.put(clazz, instance);
		}
		
		// associate fields

		for (Class roomClazz : roomMap.keySet())
		{
			Object currentRoom = roomMap.get(roomClazz);
			
			for (Field f : roomClazz.getDeclaredFields())
			{
				
				if (f.isAnnotationPresent(Direction.class))
				{
					Class fieldClazz = f.getType();
					Object roomInstance = roomMap.get(fieldClazz);
					f.setAccessible(true);
					f.set(currentRoom, roomInstance);
				}
			}
		}
		
		
		// set the first room
		currentRoom = roomMap.get(room.Room1.class);
		printDescription();
	}
	


	private Object currentRoom;
	
	public void printDescription() throws Exception
	{
		Method m = currentRoom.getClass().getDeclaredMethod("getDescription");
		System.out.println(m.invoke(currentRoom));		
	}
	
	public void move(String direction)
	{
		Class clazz = currentRoom.getClass();
		try
		{
			Field[] fields = clazz.getDeclaredFields();
			
			for (Field f : fields)
			{
				if (f.isAnnotationPresent(Direction.class))
				{
					Direction d = f.getAnnotation(Direction.class);
					
					if (d.command().equals(direction))
					{
						Class fieldClass = f.getType();
						currentRoom = roomMap.get(fieldClass);
						printDescription();		
						break;
					}
				}
			}

		}
		catch(NoSuchFieldException e)
		{
			System.out.println("Can't go that way");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void action(String act, String param) {
		Class clazz = currentRoom.getClass();
		try
		{
			Method[] methods = clazz.getDeclaredMethods();
			
			for (Method m : methods)
			{
				if (m.isAnnotationPresent(Command.class))
				{
					Command c = m.getAnnotation(Command.class);
					
					if (c.command().equals(act))
					{
						if(m.getParameterCount() > 0)
							m.invoke(currentRoom, param);
						else
							m.invoke(currentRoom);
						break;
					}
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		MazeMaker maze = new MazeMaker();
		maze.load();
		
		
		// take my input
		Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			System.out.println();
			System.out.println("Where do you want to go?: ");
			String text = scanner.nextLine();
			String[] parsed = text.split(" ");
			if (text.equals("exit"))
			{
				break;
			}
			else if(parsed[0].equals("go"))
			{
				maze.move(text);
			}else{
				if(parsed.length > 0)
					maze.action(parsed[0], parsed[1]);
				else
					maze.action(text, null);
			}
		}
	}
}
