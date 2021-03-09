package club.wadreamer.chandao.controller;

import club.wadreamer.chandao.entity.User;
import club.wadreamer.chandao.entity.dto.AjaxResultDto;
import club.wadreamer.chandao.entity.dto.WorkSumDto;
import club.wadreamer.chandao.entity.dto.WorkSummaryDto;
import club.wadreamer.chandao.entity.dto.WorkloadDto;
import club.wadreamer.chandao.service.TaskService;
import club.wadreamer.chandao.service.UserService;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * ClassName: TestControler
 * Description:
 * date: 2021/3/5 15:24
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@RestController
public class ReportController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/work_summary.json")
    public AjaxResultDto getWorkSummaryJson(@RequestBody Map<String, Object> params) {
        List<WorkSummaryDto> workSummaryDtoList = taskService.getReportByCondition(params);
        return AjaxResultDto.success().put("data", workSummaryDtoList);
    }

    @PostMapping("/work_sum.json")
    public AjaxResultDto getWorkSumJson(@RequestBody Map<String, Object> params) {
        List<WorkSumDto> workSumDtoList = taskService.getWorkSumSort(params);
        return AjaxResultDto.success().put("data", workSumDtoList);
    }

    @PostMapping("/workload.json")
    public AjaxResultDto getwWorkload(@RequestBody Map<String, Object> params, ModelMap modelMap) {
        List<WorkloadDto> workloadDtoList = taskService.getWorkload(params);
        return AjaxResultDto.success().put("data", workloadDtoList);
    }

}
