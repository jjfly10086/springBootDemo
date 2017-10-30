package com.jwh.demo.core.api;

import com.jwh.demo.core.bean.UserBean;

import java.util.List;

public interface IUserService {
	/**
	 * 查询用户列表
	 * @param bean
	 * @return
	 */
	List<UserBean> queryList(UserBean bean);
}
