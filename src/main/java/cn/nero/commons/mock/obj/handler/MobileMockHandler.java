package cn.nero.commons.mock.obj.handler;

import cn.nero.commons.mock.tel.TelMocker;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/7/5
 */
public class MobileMockHandler implements FieldMockHandler<String> {

    @Override
    public String mock() {
        return TelMocker.mockTel();
    }
}
