package cn.nero.commons.mock;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/2/2
 */
public interface Mocker <T, RU, RE> {

    RU mockRule();

    RE mockResource();

    T mock();

}
