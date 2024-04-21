package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.dao.LoginDao;
import model.entity.Users;

@Component
public class LoginService {
	@Autowired
	LoginDao ldao;
	
	public Users LoginValidate(Users user)
	{
		
		return ldao.loginValidate(user);
	}

}
