package cn.nero.commons.mock.obj.handler;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/7/5
 */
public class StringFieldMockHandler implements FieldMockHandler<String> {

    @Override
    public String mock() {
        return "我是mock的数据";
    }
}
