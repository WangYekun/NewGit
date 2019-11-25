package study11.foreach;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/11/14 16:31
 * @description 测试foreach遍历数据
 */
public class ForEachDemo {

    public static void main(String[] args) {
        System.out.println("################### test foreach ###################" + "");
        /*1. 等一种失败*/

        /*
        <select id="findList" resultType="xx.entity.Xxxx">
        SELECT ${sqlMap.column.toSql()}
        FROM ${sqlMap.table.toSql()}
        <where>
            ${sqlMap.where.toSql()}
            <if test="codes != null and codes.length > 0">
                AND u5.office_code in
                <foreach item="code" index="index" collection="codes" open="(" separator="," close=")">
                    ${code}
                </foreach>
            </if>
        </where>
        ORDER BY ${sqlMap.order.toSql()}
    </select>
        等于 select * from data a
        left join user u on u.user_code=a.createBy
        left join employee e on e.emp_code=u.ref_code
        left join office o on o.office_code=e.office_code
        where a.status='0' and o.office_code in (001016,003,004,005,006,008,007)
    */

        /*2. 等二种失败*/
        /*<if test="codes != null and codes.length > 0">
                AND u5.office_code in
                <foreach item="code" index="index" collection="codes" open="(" separator="," close=")">
                    #{code}
                </foreach>
        </if>*/

        /*3. 第三种失败*/
        /*<if test="codes != null and codes.length > 0">
                AND u5.office_code in
                <foreach item="code" index="index" collection="codes" open="(" separator="," close=")">
                    #{codes[${index}]}
                </foreach>
        </if>*/

        /*4. 第四种成功*/
        /*
        * <if test="codes != null and codes.length > 0">
                AND u5.office_code in
                <foreach item="code" index="index" collection="codes" open="(" separator="," close=")">
                    '${code}'
                </foreach>
            </if>
         */

    }
}
