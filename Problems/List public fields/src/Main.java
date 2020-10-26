/**
 Get list of public fields the object declares (inherited fields should be skipped).
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

class FieldGetter {

    public String[] getPublicFields(Object object) {
        List<String> list = new ArrayList<>();

        for (Field field: object.getClass().getDeclaredFields()){
            if ((Modifier.isPublic(field.getModifiers()))){
                list.add(field.getName());
            }
        }

        return list.toArray(new String[0]);

//        try {
//            Class objectClass = Class.forName(String.format("%s", object.getClass()));
//
//            Field[] objectFields = objectClass.getDeclaredFields();
//
//
//            int lengthPublicFieldsArray = 0;
//            boolean arrayInitialized = false;
//            int j = 0;
//            String[] publicFields;
//
//
//
//            for (int i = 0; i < 2; i++) {
//                for (Field publicField : objectFields) {
//                    if (!Modifier.isStatic(publicField.getModifiers())) {
//                        if (!arrayInitialized) {
//                            lengthPublicFieldsArray++;
//                        } else {
//                            publicFields[j++] = publicField.getName();
//                        }
//                    }
//                }
//
//                if (arrayInitialized) {
//                    return publicFields;
//                }
//
//                publicFields = new String[lengthPublicFieldsArray-1];
//                arrayInitialized = true;
//            }
//        } catch (ClassNotFoundException e) {
//            System.out.println("Ik ben Hyperskill en kan helemaal niks");
//            return null;
//        }
//        return null;
    }

}