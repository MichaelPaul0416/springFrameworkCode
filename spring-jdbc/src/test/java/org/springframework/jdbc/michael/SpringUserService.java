package org.springframework.jdbc.michael;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: wangqiang20995
 * @Date:2019/9/24
 * @Description:
 * @Resource:
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface SpringUserService {

	void save(SpringUsers springUsers);

	List<SpringUsers> list();
}
