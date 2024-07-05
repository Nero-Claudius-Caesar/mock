package cn.nero.commons.mock.obj.handler;

import java.util.Random;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/7/5
 */
public class LongFieldMockHandler implements FieldMockHandler<Long> {

    @Override
    public Long mock() {
        Random random = new Random();
        return random.nextLong();
    }
}
