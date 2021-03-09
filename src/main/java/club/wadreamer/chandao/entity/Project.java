package club.wadreamer.chandao.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * ClassName: Project
 * Description:
 * date: 2021/3/5 15:04
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@TableName("zt_project")
public class Project implements Serializable {

    private static final long serialVersionUID = -7544205598403267966L;

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
