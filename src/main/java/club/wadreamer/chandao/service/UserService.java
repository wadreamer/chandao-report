package club.wadreamer.chandao.service;

import club.wadreamer.chandao.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * ClassName: UserService
 * Description:
 * date: 2021/3/5 15:05
 *
 * @author wadreamer
 * @since JDK 1.8
 */
public interface UserService extends IService<User> {
    List<User> getAllUser();
}
