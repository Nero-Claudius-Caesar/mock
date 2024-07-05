package cn.nero.commons.mock.obj.enums;

import cn.nero.commons.mock.obj.annotations.MockMobile;
import cn.nero.commons.mock.obj.annotations.MockName;
import cn.nero.commons.mock.obj.handler.*;
import lombok.Getter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/7/5
 */
@Getter
public enum FieldTypeEnums {

    /**
     * 基本字段类型定义
     */
    BYTE("byte", Byte.class, null, null),
    SHORT("short", Short.class, null, null),
    INTEGER("integer", Integer.class, null, null),
    LONG("long", Long.class, null, LongFieldMockHandler.class),
    FLOAT("float", Float.class, null, null),
    DOUBLE("double", Double.class, null, null),
    BOOLEAN("boolean", Boolean.class, null, null),
    CHAR("char", Character.class, null, null),
    STRING("string", String.class, null, StringFieldMockHandler.class),
    MOBILE("mobile", String.class, MockMobile.class, MobileMockHandler.class),
    NAME("name", String.class, MockName.class, MobileNameHandler.class),
    ;

    private final String name;

    private final Class<?> type;

    private final Class<? extends Annotation> annotation;

    private final Class<? extends FieldMockHandler<?>> handler;

    FieldTypeEnums(String name, Class<?> type, Class<? extends Annotation> annotation, Class<? extends FieldMockHandler<?>> handler) {
        this.name = name;
        this.type = type;
        this.annotation = annotation;
        this.handler = handler;
    }

    public Object handle() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<? extends FieldMockHandler<?>> constructor = this.getHandler().getDeclaredConstructor();
        FieldMockHandler<?> fieldMockHandler = constructor.newInstance();
        return fieldMockHandler.mock();
    }

    public static FieldTypeEnums fromTypeAndAnnotation(Class<?> type, Annotation annotation) {

        if (Objects.isNull(type)) {
            return FieldTypeEnums.STRING;
        }

        // todo 通过field.getAnnotation()获取的注解,是被动态代理过的,类名为java.xxx.$proxy1, 因此在这里平铺, 后面想到好办法了进行优化
        if (annotation instanceof MockMobile) {
            return FieldTypeEnums.MOBILE;
        }
        if (annotation instanceof MockName) {
            return FieldTypeEnums.NAME;
        }

        return Arrays.stream(FieldTypeEnums.class.getEnumConstants())
                .filter(fieldType -> fieldType.getType().equals(type))
                .findFirst()
                // 默认类型使用String
                .orElse(FieldTypeEnums.STRING);
    }


}
