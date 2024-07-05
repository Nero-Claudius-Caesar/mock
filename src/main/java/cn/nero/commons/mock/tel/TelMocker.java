package cn.nero.commons.mock.tel;

import java.util.List;
import java.util.Random;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/2/2
 */
public class TelMocker {

    private static final List<Integer> PREFIX_CHINA_MOBILE = List.of(134, 135, 136, 137, 138, 139, 147, 150, 151, 152, 157, 158, 159, 165, 172, 178, 182, 183, 184, 187, 188, 195, 197, 198);

    private static final List<Integer> PREFIX_CHINA_UNICOM = List.of(130, 131, 132, 145, 146, 155, 156, 166, 167, 171, 175, 176, 185, 186, 196);

    private static final List<Integer> PREFIX_CHINA_TELECOM = List.of(133, 149, 153, 162, 173, 174, 177, 180, 181, 189, 191, 193, 199);

    private static final List<Integer> MOCK_FACTOR = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static String mockTel() {
        StringBuilder prefix = new StringBuilder(PREFIX_CHINA_MOBILE.get(new Random().nextInt(PREFIX_CHINA_MOBILE.size() - 1)).toString());
        for (int i = 0; i < 8; i++) {
            prefix.append(MOCK_FACTOR.get(new Random().nextInt(MOCK_FACTOR.size() - 1)));
        }
        return prefix.toString();
    }

}
