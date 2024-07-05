package cn.nero.commons.mock.obj.entity;

import cn.nero.commons.mock.obj.annotations.MockMobile;
import cn.nero.commons.mock.obj.annotations.MockName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/7/5
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserVO {

    private Long id;

    @MockName
    private String username;

    //private AddressVO address;

    @MockMobile
    private String mobile;

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
