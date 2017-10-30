package com.jwh.demo.springBoot.service;

import com.jwh.demo.annotation.RpcProvider;
import com.jwh.demo.core.bean.UserBean;
import com.jwh.demo.springBoot.dao.IUserDao;
import com.jwh.demo.core.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RpcProvider
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Override
	public List<UserBean> queryList(UserBean bean) {
//		return userDao.queryList(bean);
		return null;
	}

}
