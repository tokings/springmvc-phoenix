package com.embracesource.phoenix.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	
	private Logger log = LoggerFactory.getLogger("phoenix");

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> phoenixTest() {
		
		List<Map<String, Object>> ret = jdbcTemplate.queryForList("select * from test.tbl_1 limit 100 offset 0");
		
		log.info("phoenixTest ret size:{}", ret.size());
		log.debug("phoenixTest ret size:{}, datas:{}", ret.size(), ret);
		
		return ret;
	}

	public void testTemplate() {
		// 执行update操作创建表，返回int
		String sql = "create if not exists table xxSchema.xxTable "
				+ "(xxColumn_1 date not null, "
				+ "xxColumn_2 integer not null "
				+ "constraint pk primary key(createTime, wara_house))";
		int ret = jdbcTemplate.update(sql);
		
		// 执行查询操作，带参数填充，返回list<map>
		sql = "select * from xxSchema.xxTable where a=1 and b='c' or d = ? ";
		List<Map<String, Object>> retDatas = jdbcTemplate.queryForList(sql, new Object[]{"d_paramVal"});
		
		// 执行upsert操作，插入或者更新一条记录，返回int
		sql = "upsert into xxSchema.xxTable values(?,?,?,?)";
		ret = jdbcTemplate.update(sql, new Object[]{1,2,3,4});
		
		// 执行批量操作，返回int[]数组
		String sql1 = "upsert into xxSchema.xxTable values(1,2,3,4)";
		String sql2 = "upsert into xxSchema.xxTable values(5,6,7,8)";
		String[] sqls = new String[]{sql1, sql2};
		int[] rets = jdbcTemplate.batchUpdate(sqls);
		
		// ...其他操作类似
	}

}
