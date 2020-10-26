import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 Get sorted list of private fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

    public List<String> getPrivateFields(Object object) {
        List<String> privateFields = new ArrayList<>();


        //Iterates through the fields adding the private fields to the list
        for (Field privateField : object.getClass().getDeclaredFields()) {
            if (Modifier.isPrivate(privateField.getModifiers())) {
                privateFields.add(privateField.getName());
            }
        }

        java.util.Collections.sort(privateFields);

        return privateFields;



    }

}