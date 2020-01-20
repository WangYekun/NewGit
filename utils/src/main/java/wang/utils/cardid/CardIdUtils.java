package wang.utils.cardid;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdcardUtil;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/1/15 23:40
 * @description 身份证工具
 */
public class CardIdUtils {
    public static void main(String[] args) {
        String ID_18 = "460007199405020810";
        String ID_15 = "150102880730303";
        System.out.println("IdcardUtil.isValidCard(ID_18) = " + IdcardUtil.isValidCard(ID_18));
        System.out.println("IdcardUtil.isValidCard(ID_15) = " + IdcardUtil.isValidCard(ID_15));
        System.out.println("IdcardUtil.convert15To18(ID_15) = " + IdcardUtil.convert15To18(ID_15));
        DateTime date = DateUtil.parse("2020-05-10");
        System.out.println("IdcardUtil.getAgeByIdCard(ID_18, date) = " + IdcardUtil.getAgeByIdCard(ID_18, date));
        System.out.println("IdcardUtil.getAgeByIdCard(ID_15, date) = " + IdcardUtil.getAgeByIdCard(ID_15, date));
        System.out.println("IdcardUtil.getBirthByIdCard(ID_18) = " + IdcardUtil.getBirthByIdCard(ID_18));
        System.out.println("IdcardUtil.getBirthByIdCard(ID_15) = " + IdcardUtil.getBirthByIdCard(ID_15));
        System.out.println("IdcardUtil.getProvinceByIdCard(ID_18) = " + IdcardUtil.getProvinceByIdCard(ID_18));
        System.out.println("IdcardUtil.getProvinceByIdCard(ID_15) = " + IdcardUtil.getProvinceByIdCard(ID_15));
        System.out.println("IdcardUtil.getGenderByIdCard(ID_18) = " + IdcardUtil.getGenderByIdCard(ID_18));
    }
}
