package Chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class p_14_05 {
	
	public static void main(String args[]){


		try {
			Object[] doubleArgs = new Object[]{4.2, 3.9};
			Class rectangleDefintion = Class.forName("Chapter14.Rectangle");// get class
			System.out.println(rectangleDefintion.getName());
			//create a new instance
			Class[] doubleArgsClass = new Class[]{double.class, double.class};
			Constructor doubleArgsConstructor = rectangleDefintion.getConstructor(doubleArgsClass);//pass argu to the contructor
			Rectangle rec = (Rectangle) doubleArgsConstructor.newInstance(doubleArgs);
			
			Method m = rectangleDefintion.getDeclaredMethod("area");
			Double area = (Double) m.invoke(rec);
			
			System.out.println(area);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Rectangle rec2 = new Rectangle(4.2,3.9);
			Double area2 = rec2.area();
			System.out.println(area2);
		}
	}

}
