package club.wadreamer.chandao.service.impl;

import club.wadreamer.chandao.entity.Project;
import club.wadreamer.chandao.mapper.ProjectDao;
import club.wadreamer.chandao.service.ProjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ProjectServiceImpl
 * Description:
 * date: 2021/3/5 15:06
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, Project> implements ProjectService {
    @Override
    public List<Project> getAllProject() {
        QueryWrapper<Project> wrapper = new QueryWrapper<Project>().eq("deleted","0");

        return this.list(wrapper);
    }
}
