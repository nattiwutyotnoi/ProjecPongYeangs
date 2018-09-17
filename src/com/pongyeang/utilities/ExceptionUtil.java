package com.pongyeang.utilities;

public class ExceptionUtil {
	public static String messageException(Throwable t, Exception ex) {
		String message_exception = "";
		StackTraceElement[] st = t.getStackTrace();
		String methodName = st[0].getMethodName();
		String className = st[0].getClassName();
		
		message_exception += "Error at : " + className + "." + methodName
		+ " -> " + ex.getMessage();
		
		System.out.println(message_exception);
		
		return message_exception;
		
		}
}
