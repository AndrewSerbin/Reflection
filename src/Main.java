import java.lang.reflect.Method;

import model.util.annotation.Test;
import model.util.test.SquareTest;

public class Main {

    public static void main(String[] args) {
	checkTests();
    }

    private static void checkTests() {
	Class test = SquareTest.class;

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
