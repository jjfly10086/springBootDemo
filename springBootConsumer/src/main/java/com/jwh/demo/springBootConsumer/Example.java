package com.jwh.demo.springBootConsumer;

import com.jwh.demo.annotation.RpcReference;
import com.jwh.demo.core.bean.User;
import com.jwh.demo.core.bean.UserBean;
import com.jwh.demo.core.api.IUserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Example {
	
	private Logger logger = LoggerFactory.getLogger(Example.class);
	
	@RpcReference
	private IUserService userService;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private MongoOperations mongoOperations;

	@RequestMapping("/rest/{id}")
	public List<UserBean> myName(@PathVariable String id){
		UserBean user = new UserBean();
		user.setId(id);
		List<UserBean> list = userService.queryList(user);
		return list;
	}
	@RequestMapping("/list")
	public List<User> list(){
		return mongoTemplate.findAll(User.class);
	}
	@RequestMapping("/save")
	public Boolean save(){
		User user = new User();
		user.setName("ss");
		mongoTemplate.save(user, "user");
		return true;
	}
	@RequestMapping("/findOne")
	public User findOne(){
		Criteria criteria = Criteria.where("name").is("ss");
		Query query = new Query(criteria);
		String[] fields = new String[]{"_id","name"};
		for (String fieldName : fields) {
			query.fields().include(fieldName);
		}
		return mongoOperations.findOne(query,User.class);
	}
}
