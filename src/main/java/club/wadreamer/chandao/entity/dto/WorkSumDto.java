package club.wadreamer.chandao.entity.dto;

import java.io.Serializable;

/**
 * @ClassName WorkSummarySort
 * @Description TODO
 * @Author bear
 * @Date 2021/3/5 21:54
 * @Version 1.0
 **/
public class WorkSumDto implements Serializable {

    private static final long serialVersionUID = 2441454295953925423L;

    private Integer sortNum;

    private String finishedBy;

    private Float taskConsumedSum;

    private Float taskEstimateSum;

    private Float consumedSum;

    private Float estimateSum;

    private String taskType;

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getFinishedBy() {
        return finishedBy;
    }

    public void setFinishedBy(String finishedBy) {
        this.finishedBy = finishedBy;
    }

    public Float getTaskConsumedSum() {
        return taskConsumedSum;
    }

    public void setTaskConsumedSum(Float taskConsumedSum) {
        this.taskConsumedSum = taskConsumedSum;
    }

    public Float getTaskEstimateSum() {
        return taskEstimateSum;
    }

    public void setTaskEstimateSum(Float taskEstimateSum) {
        this.taskEstimateSum = taskEstimateSum;
    }

    public Float getConsumedSum() {
        return consumedSum;
    }

    public void setConsumedSum(Float consumedSum) {
        this.consumedSum = consumedSum;
    }

    public Float getEstimateSum() {
        return estimateSum;
    }

    public void setEstimateSum(Float estimateSum) {
        this.estimateSum = estimateSum;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
