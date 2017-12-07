/**
 * 
 */
package com.sgh;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sgh.mapper.UserMapper;
import com.sgh.pojo.User;

/**
 * @author eguoshi
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Main.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //执行查询返回一个唯一user对象的sql
        int id = 2;
        User user = userMapper.getUser(id);
        System.out.println(id +  ": " + (user==null? null : user.getName()));

        session.close();
	}

}
