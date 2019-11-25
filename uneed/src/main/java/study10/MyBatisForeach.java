package study10;

/**
 * @author WangYeKun
 * @version 1.0
 * @date 2019/10/15 9:44
 */
public class MyBatisForeach {

    /**
     * 1.单参数List的类型：
     *   <select id="dynamicForeachTest" resultType="Blog">
     *           select * from t_blog where id in
     *        <foreach collection="list" index="index" item="item" open="(" separator="," close=")">
     *                #{item}       
     *        </foreach>    
     *    </select>
     *
     * 上述collection的值为list，对应的Mapper是这样的
     * public List dynamicForeachTest(List ids);
     * 测试代码：
     *       @Test
     *     public void dynamicForeachTest() {
     *         SqlSession session = Util.getSqlSessionFactory().openSession();      
     *         BlogMapper blogMapper = session.getMapper(BlogMapper.class);
     *          List ids = new ArrayList();
     *          ids.add(1);
     *          ids.add(3);
     *           ids.add(6);
     *         List blogs = blogMapper.dynamicForeachTest(ids);
     *          for (Blog blog : blogs)
     *              System.out.println(blog);
     *          session.close();
     *      }
     *
     * 2.单参数array数组的类型：
     * <select id="dynamicForeach2Test" resultType="Blog">
     *           select * from t_blog where id in
     *        <foreach collection="array" index="index" item="item" open="(" separator="," close=")">                               #{item}
     *          </foreach>
     *      </select>
     *
     * 上述collection为array，对应的Mapper代码：
     * public List dynamicForeach2Test(int[] ids);
     * 对应的测试代码：
     *       @Test
     *     public void dynamicForeach2Test() {
     *         SqlSession session = Util.getSqlSessionFactory().openSession();
     *         BlogMapper blogMapper = session.getMapper(BlogMapper.class);
     *         int[] ids = new int[] {1,3,6,9};
     *         List blogs = blogMapper.dynamicForeach2Test(ids);
     *         for (Blog blog : blogs)
     *         System.out.println(blog);    
     *         session.close();
     *       }
     *
     * 3.自己把参数封装成Map的类型
     * <select id="dynamicForeach3Test" resultType="Blog">
     *         select * from t_blog where title like "%"#{title}"%" and id in
     *          <foreach collection="ids" index="index" item="item" open="(" separator="," close=")">
     *               #{item}
     *          </foreach>
     *     </select>
     *
     * 上述collection的值为ids，是传入的参数Map的key，对应的Mapper代码：
     * public List dynamicForeach3Test(Map params);
     * 对应测试代码：
     *       @Test
     *     public void dynamicForeach3Test() {
     *         SqlSession session = Util.getSqlSessionFactory().openSession();
     *          BlogMapper blogMapper = session.getMapper(BlogMapper.class);
     *           final List ids = new ArrayList();
     *           ids.add(1);
     *           ids.add(2);
     *           ids.add(3);
     *           ids.add(6);
     *          ids.add(7);
     *          ids.add(9);
     *         Map params = new HashMap();
     *          params.put("ids", ids);
     *          params.put("title", "中国");
     *         List blogs = blogMapper.dynamicForeach3Test(params);
     *          for (Blog blog : blogs)
     *              System.out.println(blog);
     *          session.close();
     *      }
     */

}
