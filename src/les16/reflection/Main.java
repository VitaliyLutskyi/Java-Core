package les16.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
			
		Car car = new Car(2016, "Audi", "Q7", 3.5);
		
		Class<? extends Car> carClass = car.getClass();
		System.out.println(carClass);
		
		String className = carClass.getName();
		System.out.println(className);
		String simpleName = carClass.getSimpleName();
		System.out.println(simpleName);
		
		// Superclass, interfaces
		Class<?> superclass = carClass.getSuperclass();
		System.out.println("Superclass: "+superclass);
		System.out.println("Superclass simple name: "+superclass.getSimpleName());
		Class<?>[] interfacesThatClassImplements = carClass.getInterfaces();
		System.out.println("Interfaces that class implements: "+Arrays.toString(interfacesThatClassImplements));
		
		// Modifiers
		int modifiers = carClass.getModifiers();
		System.out.println(carClass.getModifiers());
		System.out.println(Modifier.toString(carClass.getModifiers()));
		System.out.println("Is public? - "+Modifier.isPublic(modifiers));
		System.out.println("Is static? - "+Modifier.isStatic(modifiers));
		System.out.println("Is abstract? - "+Modifier.isAbstract(modifiers));
		System.out.println("Is interface? - "+Modifier.isInterface(modifiers));
		
		// Package
		Package carPackage = carClass.getPackage();
		System.out.println(carPackage + "\tName: " + carPackage.getName());
		
		// Constructor	
		Constructor<?>[] carConstructors = carClass.getConstructors();
		System.out.println("\nConstructors:");
		for (Constructor<?> constructor : carConstructors) 
			System.out.println(constructor);
		
		System.out.println("\nConstructor parameter count: "+carConstructors[1].getParameterCount());
		System.out.println("Parameters: "+Arrays.toString(carConstructors[1].getParameters()));
		System.out.println("Parameter Types: "+Arrays.toString(carConstructors[1].getParameterTypes()));
		System.out.println("Type Parameters: "+Arrays.toString(carConstructors[1].getTypeParameters()));
		
		System.out.println("Constructor with 4 parameters: "+carClass.getConstructor(int.class, String.class, String.class, double.class));
		Car newInstanceCar = carClass.getConstructor(int.class, String.class, String.class, double.class).newInstance(2014, "BMW", "X5", 4.4);
		System.out.println("New instance of Car: "+newInstanceCar);
		
		// Fields
		System.out.println();
		System.out.println("Public fields: "+Arrays.toString(carClass.getFields()));
		System.out.println("All fields: "+Arrays.toString(carClass.getDeclaredFields()));
		
		//carClass.getField("engine");  Throws Exception java.lang.NoSuchFieldException
		System.out.println(carClass.getDeclaredField("engine").trySetAccessible());
		
		// That should work but it doesn't...
//		carClass.getDeclaredField("engine").setAccessible(true);
//		carClass.getDeclaredField("engine").setDouble(newInstanceCar, 3.0);   
		
		// Changing value of field productionYear
		carClass.getField("productionYear").set(newInstanceCar, 2004);
		System.out.println("New production year of new instance Car is:"+carClass.getField("productionYear").get(newInstanceCar));
		System.out.println(newInstanceCar);
		
		// Methods invoking
		Method[] methods = carClass.getMethods();
		for (Method method : methods) {
			System.out.println("\n"+method.getName());
			System.out.println(method);
		}
		Method method = carClass.getMethod("setYearsOld", int.class, String.class);	
		System.out.println("\nMethod '"+method.getName()+"' has such parameters:");
		System.out.println(Arrays.toString(method.getParameterTypes()));
		
		System.out.println("\nNew instance car before invoke using:\n"+newInstanceCar);
		System.out.println("\nNew instance car after invoke using:");
		method.invoke(newInstanceCar, 2, "Ivan");
		System.out.println(newInstanceCar);
		
		System.out.println();
		method = carClass.getMethod("getInfo", String.class);
		method.invoke(newInstanceCar, "Petro");
	}

}































