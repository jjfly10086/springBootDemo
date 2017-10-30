package com.jwh.demo.springBoot;

import com.jwh.demo.ProviderFactory;
import com.jwh.demo.core.bean.User;
import com.jwh.demo.core.bean.UserBean;
import com.jwh.demo.core.api.IUserService;
import com.jwh.demo.core.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Example {
	
	private Logger logger = LoggerFactory.getLogger(Example.class);
	
	@Autowired
	private IUserService userService;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private MongoOperations mongoOperations;
	
	@RequestMapping("/")
	public String home(ModelMap model){
		logger.info("主页");
		model.put("sb", "sb");
		return "index";
	}
	@RequestMapping("/startService")
	public void startService(){
		BeanUtils.getBean(ProviderFactory.class);
	}

	@RequestMapping("/test")
	public String test(ModelMap model){
		logger.info("主页");
		model.put("sb", "sb杀杀杀");
		return "test";
	}
	@RequestMapping("/rest/{id}")
	@ResponseBody
	public List<UserBean> myName(@PathVariable String id){
		UserBean user = new UserBean();
		user.setId(id);
		List<UserBean> list = userService.queryList(user);
		return list;
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<User> find(){
		return mongoTemplate.findAll(User.class);
	}
	@RequestMapping("/save")
	@ResponseBody
	public String save(){
		User user = new User();
		user.setName("ss");
		user.setMemo("11111111111");
		mongoTemplate.save(user, "user");
		return "over";
	}
	@RequestMapping("/findOne")
	@ResponseBody
	public User findOne(String name){
		Criteria criteria = Criteria.where("name").is(name);
		Query query = new Query(criteria);
		String[] fields = new String[]{"_id","name"};
		for (String fieldName : fields) {
			query.fields().include(fieldName);
		}
		return mongoOperations.findOne(query,User.class);
	}
}
