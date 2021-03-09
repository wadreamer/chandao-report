package club.wadreamer.chandao.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserDetailServiceImpl
 * Description:
 * date: 2020/11/9 14:06
 *
 * @author CFG
 * @since JDK 1.8
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails userDetails = User.withUsername("admin").password("$2a$10$PFudNoCy28Uwv9rGcz5o8uR3W16ZleQedn/S3HCwKYJETbxoOhhOe").roles("admin").build();

        return userDetails;
    }
}
