package club.wadreamer.chandao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: Task
 * Description:
 * date: 2021/3/5 15:04
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@TableName("zt_task")
public class Task implements Serializable {

    private static final long serialVersionUID = -1979664098697410947L;

    private Integer id;

    private Integer project;

    private String name;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date estStarted;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date deadline;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date realStarted;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date finishedDate;

    private String finishedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }

    public String getFinishedBy() {
        return finishedBy;
    }

    public void setFinishedBy(String finishedBy) {
        this.finishedBy = finishedBy;
    }
}
