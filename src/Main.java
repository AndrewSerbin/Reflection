import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import model.entity.EquilateralTriangle;
import model.util.annotation.Test;
import model.util.test.SquareTest;

public class Main {

    public static void main(String[] args) {
	getInfo(EquilateralTriangle.class);

	checkTests(SquareTest.class);
    }

    private static void getInfo(Class<?> clazz) {
	System.out.println(clazz.getName());

	Field[] fields = clazz.getDeclaredFields();
	System.out.println(fields.length);
	for (int i = 0; i < fields.length; i++) {
	    System.out.println(fields[i]);
	}

	Annotation[] annotations = clazz.getAnnotations();
	for (int i = 0; i < annotations.length; i++) {
	    System.out.println(annotations[i].annotationType().getName());
	}
    }

    private static void checkTests(Class test) {
	Method[] methods = test.getMethods();
	int pass = 0;
	int fail = 0;

	for (Method method : methods) {
	    if (method.isAnnotationPresent(Test.class)) {
		try {
		    method.invoke(test);
		} catch (Throwable e) {
		    if (method.getAnnotation(Test.class).expected().equals(e.getClass())) {
			pass++;
		    } else {
			fail++;
		    }
		}
	    }
	}

	System.out.println("pass:" + pass + " fail:" + fail);
    }
}
