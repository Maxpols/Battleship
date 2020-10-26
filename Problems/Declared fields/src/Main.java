import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 Get number of fields class declares (the ones inherited should be excluded).
 */
class FieldGetter {

    public int getNumberOfFieldsClassDeclares(Class<?> clazz) {
       return  Array.getLength(clazz.getDeclaredFields());
    }
}