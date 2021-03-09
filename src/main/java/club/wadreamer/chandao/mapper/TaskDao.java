package club.wadreamer.chandao.mapper;

import club.wadreamer.chandao.entity.Task;
import club.wadreamer.chandao.entity.dto.WorkSumDto;
import club.wadreamer.chandao.entity.dto.WorkSummaryDto;
import club.wadreamer.chandao.entity.dto.WorkloadDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: TaskDao
 * Description:
 * date: 2021/3/5 15:04
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@Mapper
public interface TaskDao extends BaseMapper<Task> {
    List<WorkSummaryDto> getWorkSummary(@Param("finishedBy") String finishedBy,
                                              @Param("startDate") String startDate,
                                              @Param("endDate") String endDate);

    List<WorkSumDto> getWorkSumSort(@Param("startDate") String startDateStr,
                                    @Param("endDate") String endDateStr);

    List<WorkloadDto> getWorkload(@Param("project") String project,
                                  @Param("assignedTo") String assignedTo,
                                  @Param("status") String status,
                                  @Param("dateType") String dateType,
                                  @Param("startDate") String startDate,
                                  @Param("endDate") String endDate);
}
