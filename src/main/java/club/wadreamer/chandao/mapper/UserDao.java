package club.wadreamer.chandao.mapper;

import club.wadreamer.chandao.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: UserDao
 * Description:
 * date: 2021/3/5 15:04
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
