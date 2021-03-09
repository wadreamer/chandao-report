package club.wadreamer.chandao.service;

import club.wadreamer.chandao.entity.Task;
import club.wadreamer.chandao.entity.dto.WorkSumDto;
import club.wadreamer.chandao.entity.dto.WorkSummaryDto;
import club.wadreamer.chandao.entity.dto.WorkloadDto;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * ClassName: TaskService
 * Description:
 * date: 2021/3/5 15:05
 *
 * @author wadreamer
 * @since JDK 1.8
 */
public interface TaskService extends IService<Task> {
    List<WorkSummaryDto> getReportByCondition(Map<String, Object> params);

    List<WorkSumDto> getWorkSumSort(Map<String, Object> params);

    List<WorkloadDto> getWorkload(Map<String, Object> params);
}
