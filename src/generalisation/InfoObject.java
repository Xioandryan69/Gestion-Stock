package generalisation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class InfoObject {

    //  colonnes (attributs)
    public static Map<String, Object> infoColonnes(Object obj) {

        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                map.put(field.getName(), null);
            }
        }

        return map;
    }

    //info table (classe)
    public static Map<String, Object> infoTable(Object obj) {

        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();

        map.put("table", clazz.getSimpleName());
        map.put("package", clazz.getPackageName());

        return map;
    }

    //colonnes + table
    public static Map<String, Object> inspect(Object obj) {

    Map<String, Object> result = new HashMap<>();
    Class<?> clazz = obj.getClass();

    result.put("table", clazz.getSimpleName());
    result.put("package", clazz.getPackageName());

    Map<String, Object> fields = new HashMap<>();

    for (Field field : clazz.getDeclaredFields()) {
        field.setAccessible(true);

        try {
            fields.put(field.getName(), field.get(obj));
        } catch (Exception e) {
            fields.put(field.getName(), null);
        }
    }

    result.put("columns", fields);

    return result;
}
}