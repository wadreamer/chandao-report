package club.wadreamer.chandao.service.impl;

import club.wadreamer.chandao.entity.Task;
import club.wadreamer.chandao.entity.dto.WorkSumDto;
import club.wadreamer.chandao.entity.dto.WorkSummaryDto;
import club.wadreamer.chandao.entity.dto.WorkloadDto;
import club.wadreamer.chandao.mapper.TaskDao;
import club.wadreamer.chandao.service.TaskService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * ClassName: TaskServiceImpl
 * Description:
 * date: 2021/3/5 15:06
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskDao, Task> implements TaskService {

    @Override
    public List<WorkSummaryDto> getReportByCondition(Map<String, Object> params) {

        String finishedBy = Objects.nonNull(params.get("finishedBy")) ? params.get("finishedBy").toString() : "";

        String startDate = params.get("startDate").toString();
        String endDate = params.get("endDate").toString();

        String startDateStr = DateUtil.format(DateUtil.parseDate(startDate), "yyyy-MM-dd");
        String endDateStr = DateUtil.format(DateUtil.parseDate(endDate), "yyyy-MM-dd");

        List<WorkSummaryDto> reportList = this.baseMapper.getWorkSummary(finishedBy, startDateStr, endDateStr);

        return reportList;
    }

    @Override
    public List<WorkSumDto> getWorkSumSort(Map<String, Object> params) {

        String startDate = params.get("startDate").toString();
        String endDate = params.get("endDate").toString();

        String startDateStr = DateUtil.format(DateUtil.parseDate(startDate), "yyyy-MM-dd");
        String endDateStr = DateUtil.format(DateUtil.parseDate(endDate), "yyyy-MM-dd");

        List<WorkSumDto> workSumDtos = this.baseMapper.getWorkSumSort(startDateStr, endDateStr);
        HashMap<String, Float> name_taskType_consumed = new HashMap<>();
        HashMap<String, Float> name_taskType_estimate = new HashMap<>();

        for (WorkSumDto workSumDto : workSumDtos) {
            String key = workSumDto.getFinishedBy();

            if (Objects.nonNull(name_taskType_consumed.get(key))) {
                Float consumed = name_taskType_consumed.get(key);
                name_taskType_consumed.put(key, consumed + workSumDto.getTaskConsumedSum());
            } else {
                name_taskType_consumed.put(key, workSumDto.getTaskConsumedSum());
            }

            if (Objects.nonNull(name_taskType_estimate.get(key))) {
                Float estimate = name_taskType_estimate.get(key);
                name_taskType_estimate.put(key, estimate + workSumDto.getTaskEstimateSum());
            } else {
                name_taskType_estimate.put(key, workSumDto.getTaskEstimateSum());
            }
        }

        for (WorkSumDto workSumDto : workSumDtos) {
            String key = workSumDto.getFinishedBy();

            if (Objects.nonNull(name_taskType_consumed.get(key))) {
                workSumDto.setConsumedSum(name_taskType_consumed.get(key));
            }

            if (Objects.nonNull(name_taskType_estimate.get(key))) {
                workSumDto.setEstimateSum(name_taskType_estimate.get(key));
            }
        }

        Collections.sort(workSumDtos, new Comparator<WorkSumDto>() {
            @Override
            public int compare(WorkSumDto o1, WorkSumDto o2) {
                return o1.getConsumedSum() > o2.getConsumedSum() ? -1 : o1.getConsumedSum() == o2.getConsumedSum() ? 0 : 1;
            }
        });

        int min = 1;
        workSumDtos.get(0).setSortNum(1);
        for (int i = 0; i < workSumDtos.size() - 1; i++) {
            if (workSumDtos.get(i).getFinishedBy().equals(workSumDtos.get(i + 1).getFinishedBy())) {
                workSumDtos.get(i + 1).setSortNum(min);
            } else {
                min++;
                workSumDtos.get(i + 1).setSortNum(min);
            }
        }

        return workSumDtos;
    }

    @Override
    public List<WorkloadDto> getWorkload(Map<String, Object> params) {

        String project = Objects.nonNull(params.get("project")) ? params.get("project").toString() : "";
        String assignedTo = Objects.nonNull(params.get("assignedTo")) ? params.get("assignedTo").toString() : "";
        String status = Objects.nonNull(params.get("status")) ? params.get("status").toString() : "";
        String dateType = Objects.nonNull(params.get("dateType")) ? params.get("dateType").toString() : "";

        String startDate = params.get("startDate").toString();
        String endDate = params.get("endDate").toString();

        String startDateStr = DateUtil.format(DateUtil.parseDate(startDate), "yyyy-MM-dd");
        String endDateStr = DateUtil.format(DateUtil.parseDate(endDate), "yyyy-MM-dd");

        List<WorkloadDto> workloadDtoList = this.baseMapper.getWorkload(project, assignedTo, status, dateType, startDateStr, endDateStr)
                .stream().map(item -> {
                    if (item.getConsumed() + item.getLeft() == 0) {
                        item.setProgress(0f);
                    } else {
                        DecimalFormat df = new DecimalFormat("#.00");
                        double progress = item.getConsumed() / (item.getConsumed() + item.getLeft());
                        String format = df.format(progress);
                        item.setProgress(Float.parseFloat(format));
                    }
                    return item;
                }).collect(Collectors.toList());

        return workloadDtoList;
    }

    //@Override
    //public List<WorkSummaryDto> getReportByCondition() {
    //
    //    List<WorkSummary> reportList = this.baseMapper.getReportByCondition();
    //
    //    // 完成者 - [所属项目 - report]
    //    HashMap<String, HashMap<String, List<WorkSummary>>> relationMap = new HashMap<>();
    //
    //    for (WorkSummary report : reportList) {
    //
    //        String finishedBy = report.getFinishedBy();
    //        String project = report.getProject();
    //
    //        if (Objects.nonNull(relationMap.get(finishedBy)) && Objects.nonNull(relationMap.get(finishedBy).get(project))) {
    //            relationMap.get(finishedBy).get(project).add(report);
    //        } else {
    //            List<WorkSummary> mapData = new ArrayList<>();
    //            mapData.add(report);
    //
    //            if (Objects.nonNull(relationMap.get(finishedBy))) {
    //                relationMap.get(finishedBy).put(project, mapData);
    //            } else {
    //                HashMap<String, List<WorkSummary>> map = new HashMap<>();
    //                map.put(project, mapData);
    //                relationMap.put(finishedBy, map);
    //            }
    //        }
    //    }
    //
    //    List<WorkSummaryDto> workSummaryDtoList = new ArrayList<>();
    //
    //    for (Map.Entry<String, HashMap<String, List<WorkSummary>>> t1 : relationMap.entrySet()) {
    //        WorkSummaryDto workSummaryDto = new WorkSummaryDto();
    //
    //        String finishedBy = t1.getKey();
    //        workSummaryDto.setFinishedBy(finishedBy);
    //
    //        List<ProjectDto> projectDtoList = new ArrayList<>();
    //        for (Map.Entry<String, List<WorkSummary>> t2 : t1.getValue().entrySet()) {
    //            ProjectDto projectDto = new ProjectDto();
    //            List<TaskDto> taskDtoList = new ArrayList<>();
    //
    //            String projectName = t2.getKey();
    //            projectDto.setProjectName(projectName);
    //
    //            List<WorkSummary> workSummaryList = t2.getValue();
    //
    //            for (WorkSummary workSummary : workSummaryList) {
    //                TaskDto taskDto = new TaskDto();
    //                BeanUtils.copyProperties(workSummary, taskDto);
    //                taskDtoList.add(taskDto);
    //            }
    //            projectDto.setTaskDtoList(taskDtoList);
    //
    //            projectDtoList.add(projectDto);
    //        }
    //
    //        workSummaryDto.setProjectDtoList(projectDtoList);
    //
    //        workSummaryDtoList.add(workSummaryDto);
    //    }
    //    return workSummaryDtoList;
    //}


}
