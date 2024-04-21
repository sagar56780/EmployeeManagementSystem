package model.dao;

import org.springframework.stereotype.Component;


import model.entity.Users;

@Component
public class LoginDao extends HibernateDao {
	
	
	public Users loginValidate(Users user)
	{ 
		System.err.println(user);
	    Users result=em.find(Users.class, user.getId());
	   
	    if(result!=null)
	    {
	    	System.out.println();
	    	System.out.println(result.getPassword() + " "+(user.getPassword()));
	    	if(result.getPassword().equals(user.getPassword())){
	    		System.err.println(result);
	    		return result;
	    	}
	    }
	    return null;
	    
	}

}
