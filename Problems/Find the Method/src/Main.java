import java.lang.reflect.Method;

class MethodFinder {

    public static String findMethod(String methodName, String[] classNames) throws ClassNotFoundException  {
        for (String className: classNames) {
            Class object = Class.forName(String.format("%s", className));
            Method[] declaredMethods = object.getMethods();
            for (Method classMethods: declaredMethods) {
                if (classMethods.getName().equals(methodName)) {
                    return className;
                }
            }
        }
        return "not Found";
    }
}