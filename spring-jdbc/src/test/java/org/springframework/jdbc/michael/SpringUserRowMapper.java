package org.springframework.jdbc.michael;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: wangqiang20995
 * @Date:2019/9/24
 * @Description:
 * @Resource:
 */
public class SpringUserRowMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		SpringUsers springUsers = new SpringUsers();
		springUsers.setId(rs.getInt("id"));
		springUsers.setAge(rs.getInt("age"));
		springUsers.setName(rs.getString("name"));
		springUsers.setSex(rs.getString("sex"));

		return springUsers;
	}
}
