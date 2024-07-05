package cn.nero.commons.mock.obj.entity;

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
public class AddressVO {

    private Integer provinceId;

    private Integer cityId;

    private Integer distId;

    private String detail;

}
