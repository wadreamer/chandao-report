package club.wadreamer.chandao.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: Report
 * Description:
 * date: 2021/3/5 16:04
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@Data
public class WorkloadDto implements Serializable {

    private static final long serialVersionUID = -3170917652342481286L;

    private String finishedBy;

    private Integer projectId;

    private String project;

    private Integer taskId;

    private String task;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date estStarted;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date deadline;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date realStarted;

    private Integer delay;

    private Float consumed;

    private Float left;

    private Float progress;

    private Float estimate;

    private Integer storyId;

    public String getFinishedBy() {
        return finishedBy;
    }

    public void setFinishedBy(String finishedBy) {
        this.finishedBy = finishedBy;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEstStarted() {
        return estStarted;
    }

    public void setEstStarted(Date estStarted) {
        this.estStarted = estStarted;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getRealStarted() {
        return realStarted;
    }

    public void setRealStarted(Date realStarted) {
        this.realStarted = realStarted;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Float getConsumed() {
        return consumed;
    }

    public void setConsumed(Float consumed) {
        this.consumed = consumed;
    }

    public Float getLeft() {
        return left;
    }

    public void setLeft(Float left) {
        this.left = left;
    }

    public Float getProgress() {
        return progress;
    }

    public void setProgress(Float progress) {
        this.progress = progress;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public Float getEstimate() {
        return estimate;
    }

    public void setEstimate(Float estimate) {
        this.estimate = estimate;
    }
}
