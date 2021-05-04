package cn.xbmchina.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by xbm on 2020/6/19.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO{
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;

}