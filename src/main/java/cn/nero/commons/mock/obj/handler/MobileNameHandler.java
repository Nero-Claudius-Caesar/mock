package cn.nero.commons.mock.obj.handler;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/7/5
 */
public class MobileNameHandler implements FieldMockHandler<String> {

    private static final List<String> FIRST_NAME = Arrays.stream("赵钱孙李周吴郑王".split("")).toList();

    private static final List<String> SECOND_NAME = Arrays.stream("旭三四五".split("")).toList();

    @Override
    public String mock() {
        return FIRST_NAME.get(new Random().nextInt(FIRST_NAME.size() - 1)) + SECOND_NAME.get(new Random().nextInt(SECOND_NAME.size() - 1));
    }

    public static void main(String[] args) {
        System.out.println(new MobileNameHandler().mock());
    }
}
