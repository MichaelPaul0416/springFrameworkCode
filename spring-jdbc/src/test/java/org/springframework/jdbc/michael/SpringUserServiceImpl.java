package org.springframework.jdbc.michael;

import org.springframework.aop.framework.AopContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * @Author: wangqiang20995
 * @Date:2019/9/24
 * @Description:
 * @Resource:
 */
public class SpringUserServiceImpl implements SpringUserService {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(SpringUsers springUsers) {
		/**
		 * 在一个事务内启用了另外一个事务方法
		 */
		//不能像这样直接调用这个list方法，因为此时相当于调用的是实例对象的list方法，而不是代理对象的list方法
		//要想把事务托管给spring，那么当前的方法就应该是调用proxy.list，而不是this,list
//		List<SpringUsers> queryResults = list();

		/**
		 * 这里的话，通过AopContext.currentProxy()方法获取的就是spring的代理对象
		 * 所以执行这里的list方法就会使用spring托管的事务，根据制定的事务传播特性，采取处理的策略
		 */
		List<SpringUsers> queryResults = ((SpringUserService)AopContext.currentProxy()).list();
		System.out.println("query:" + queryResults);

		jdbcTemplate.update("insert into spring_users(name,age,sex) values(?,?,?)", new Object[]{
				springUsers.getName(), springUsers.getAge(), springUsers.getSex()
		}, new int[]{
				Types.VARCHAR, Types.INTEGER, Types.VARCHAR
		});

		throw new RuntimeException("aa");
	}

	@Override
	public List<SpringUsers> list() {
		List<SpringUsers> list = jdbcTemplate.queryForList("select * from spring_users", SpringUsers.class);
		System.out.println("list size:" + list.size());
		if(list == null || list.isEmpty()){
//			throw new NullPointerException("empty records");
		}
		return list;
	}
}
