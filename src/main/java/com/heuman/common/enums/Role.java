package com.heuman.common.enums;

/**
 * Created by heuman on 2017/12/11.
 */
public enum Role {

    ADMIN("系统管理员"), MANAGER("管理员"), VIP("VIP"), USER("会员"), GUEST("游客");

    private String desc;

    Role(String desc) {
        this.desc = desc;
    }

    public static Role parse(String name) {
        if (name != null && !"".equals(name)) {
            for (Role role : Role.values()) {
                if (role.name().equals(name) || role.getDesc().equals(name)) {
                    return role;
                }
            }
        }
        return null;
    }

    public static final String _ADMIN = "ADMIN";
    public static final String _MANAGER = "MANAGER";
    public static final String _VIP = "VIP";
    public static final String _USER = "USER";
    public static final String _GUEST = "GUEST";

    public String getDesc() {
        return desc;
    }
}
