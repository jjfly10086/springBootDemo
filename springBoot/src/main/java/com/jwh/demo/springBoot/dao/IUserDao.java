package com.jwh.demo.springBoot.dao;

import com.jwh.demo.core.bean.UserBean;

import java.util.List;

public interface IUserDao {
	/**
	 * 查询用户列表
	 * @param bean
	 * @return
	 */
	List<UserBean> queryList(UserBean bean);
}
