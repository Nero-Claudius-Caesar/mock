package cn.nero.commons.mock.obj;

import cn.nero.commons.mock.obj.annotations.MockMobile;
import cn.nero.commons.mock.obj.annotations.MockName;
import cn.nero.commons.mock.obj.entity.UserVO;
import cn.nero.commons.mock.obj.enums.FieldTypeEnums;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/7/5
 */
public class BeanMocker {

    private static final Logger LOG = Logger.getLogger(BeanMocker.class.getSimpleName());

    private static Annotation getFirstAnnotation (Field field) {
        Annotation[] annotations = field.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof MockMobile) {
                return field.getAnnotation(MockMobile.class);
            }
            if (annotation instanceof MockName) {
                return field.getAnnotation(MockName.class);
            }
        }
        return null;
    }

    private static Object handleField (Field field) {
        Annotation annotation = getFirstAnnotation(field);

        Class<?> type = field.getType();
        try {
            Object handle = FieldTypeEnums.fromTypeAndAnnotation(type, annotation).handle();

            LOG.info("generated value : " + handle);

            return handle;

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public static <T> T mock (Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        T t = clazz.getDeclaredConstructor().newInstance();

        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields).forEach(field -> {
            Object value = handleField(field);
            field.setAccessible(true);
            try {
                field.set(t, value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

        return t;
    }

    public static void main(String[] args) throws Exception {
        UserVO mock = BeanMocker.mock(UserVO.class);
        LOG.info("mock: " + mock);
    }
}
