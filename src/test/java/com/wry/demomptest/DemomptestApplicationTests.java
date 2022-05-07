package com.wry.demomptest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wry.demomptest.entity.User;
import com.wry.demomptest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class DemomptestApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void findAll() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

	@Test
	public void testadd(){
		User user = new User();
		user.setId(6L);
		user.setName("王五");
		user.setAge(15);
		int insert = userMapper.insert(user);
		System.out.println(insert);
	}

	@Test
	public void testupdate(){
		User user = new User();
		user.setId(1522483715802525697L);
		user.setAge(30);
		int i = userMapper.updateById(user);
		System.out.println(i);
	}

	//测试乐观锁
	@Test
	public void testOptimisticLocker(){
		User user = userMapper.selectById(5L);
		user.setName("Alice");
		userMapper.updateById(user);
	}

	//测试查询多个id
	@Test
	public void testselectBatchId(){
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2.3));
		System.out.println(users);
	}

	//通过多组条件查询
	@Test
	public void testselectmap(){
		 HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("id",1L);
		 map.put("name","jack");
		List<User> users = userMapper.selectByMap(map);
		System.out.println(users);
	}

	//测试分页查询
	@Test
	public void testselectpage(){
		Page<User> page = new Page(1,3);   //获取page对象
		Page<User> userPage = userMapper.selectPage(page, null);
		//通过返回的userpage对象可以得到所有分页数据
		long current = userPage.getCurrent(); //当前页时第几页
		List<User> records = userPage.getRecords(); //获得当前页的所有记录
		long pages = userPage.getPages();   //获得总页数
		long total = userPage.getTotal();   //获得总记录数
		System.out.println(current);
		System.out.println(records);
		System.out.println(pages);
		System.out.println(total);
	}

	//测试逻辑删除
	@Test
	public void testdelete(){
		int i = userMapper.deleteById(6L);
		System.out.println(i);
	}


}
