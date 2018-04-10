package maze;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import room.City;
import room.Player;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import anno.*;

public class MazeMaker 
{
	private Player mater;
	private HashMap<Class, Object> roomMap = new HashMap<Class, Object>();
	
	public String load() throws Exception
	{
		// load all names
		FastClasspathScanner scanner = new FastClasspathScanner("room");
		ScanResult result = scanner.scan();
		
		List<String> allClasses = result.getNamesOfAllClasses();		
		System.out.println(allClasses);
		
		// instantiate
		for (String className : allClasses)
		{
			if(className.equals("room.City"))
				continue;
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
					
					((City) roomInstance).setPlayer(mater);
				}
			}
		}
		
		
		// set the first room
		currentRoom = roomMap.get(room.MaterHouse.class);
		return printDescription();
	}
	


	private Object currentRoom;
	
	public String printDescription() throws Exception
	{
		Method m = currentRoom.getClass().getDeclaredMethod("getDescription");
		return (String) m.invoke(currentRoom);		
	}
	
	public String move(String direction)
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
						return printDescription();		
					}
				}
			}

		}
		catch(NoSuchFieldException e)
		{
			return "Can't go that way\n";
		}
		catch(Exception e)
		{
			return e.toString() + "\n" ;
		}

		return "Can't go that way\n";
	}
	
	public String action(String act, String param) {
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
						if(m.getParameterCount() > 0) {
							return (String) m.invoke(currentRoom, param);
						}
						else
							return (String) m.invoke(currentRoom);
					}
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			return e.toString() + "\n";
		}
		
		return "Can't do that\n";
	}
	
	public void setPlayer(Player p) {
		mater = p;
	}
	
//	public static void main(String[] args) throws Exception
//	{
//		MazeMaker maze = new MazeMaker();
//		maze.load();
//		
//		
//		// take my input
//		Scanner scanner = new Scanner(System.in);
//		
//		while (true)
//		{
//			System.out.println();
//			System.out.println("Where do you want to go?: ");
//			String text = scanner.nextLine();
//			String[] parsed = text.split(" ");
//			if (text.equals("exit"))
//			{
//				break;
//			}
//			else if(parsed[0].equals("go"))
//			{
//				maze.move(text);
//			}else{
//				if(parsed.length > 0)
//					maze.action(parsed[0], parsed[1]);
//				else
//					maze.action(text, null);
//			}
//		}
//	}
}
