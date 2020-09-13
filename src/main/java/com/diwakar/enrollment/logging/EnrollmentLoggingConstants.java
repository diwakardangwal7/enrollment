
package com.diwakar.enrollment.logging;

/**
* Contsants used by Logging Aspect
* 
* @author Diwakar
*/

public class EnrollmentLoggingConstants {

	EnrollmentLoggingConstants() {

	}

	public static final String BASE_PACKAGE = "com.diwakar.enrollment.*";

	public static final String METHOD_ENTRY = "Entering $[methodName]($[arguments])";

	public static final String METHOD_EXIT = "Leaving  $[methodName](), returned $[returnValue]";

	public static final String LOG_ALL_METHODS = "allMethodsPointcut()";

	public static final String METHOD_ENTRY_LOG = "Entering Method - ";

	public static final String METHOD_EXIT_LOG = "Exiting Method - ";

	public static final String METHOD_LOG_SEPARATOR = "::";

	public static final String POINT_CUT_BASE_PACKAGE = "execution(* com.diwakar..*(..))";

	public static final String LOG_MESSAGE_FORMAT = "[PROFILER] %s.%s, Execution time: %dms %s";

	public static final String PROFILER_POINT_CUT = "profilerPointCut()";

}
