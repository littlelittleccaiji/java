package common;

import java.util.Arrays;

public enum MemberCouponEnum {

    ALL(0, "ALL"),
    SOLD(1, "SOLD"),//出售成功
    SUCCESS(2, "SUCCESS"),//交易成功
    REFUNDED(3, "REFUNDED"),//已退款
    AFTER_SALE(4,  "AFTER_SALE");//售后中

    private Integer value;

    private String name;

    MemberCouponEnum( Integer value,String name) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static String getNameByValue(Integer value){
        for(MemberCouponEnum memberCouponEnum:MemberCouponEnum.values()){
            if(memberCouponEnum.value.equals(value)){
                return memberCouponEnum.name;
            }
        }
        return null;
    }
}
