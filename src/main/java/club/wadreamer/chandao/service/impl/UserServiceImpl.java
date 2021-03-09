package club.wadreamer.chandao.service.impl;

import club.wadreamer.chandao.entity.User;
import club.wadreamer.chandao.mapper.UserDao;
import club.wadreamer.chandao.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: UserServiceImpl
 * Description:
 * date: 2021/3/5 15:06
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Override
    public List<User> getAllUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("deleted", '0');
        List<User> users = this.baseMapper.selectList(wrapper);

        return users;
    }
}
