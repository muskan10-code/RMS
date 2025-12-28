package com.manav.ncu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.manav.ncu.dao.RoleDao;
import com.manav.ncu.models.Role;
import com.manav.ncu.models.User;

public class UserDetail implements UserDetails {
	private RoleDao roleDao=new RoleDao();
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private User user;
private Role role;

   public UserDetail(User user,Role role) {
	   this.user=user;
	   this.role=role;
   }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authList=new ArrayList();
		authList.add(new SimpleGrantedAuthority(role.getRoleName()));
		return authList;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		System.out.println("inside password ........................."+user.getPassword());
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
