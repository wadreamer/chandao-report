package club.wadreamer.chandao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * ClassName: User
 * Description:
 * date: 2021/3/5 15:03
 *
 * @author wadreamer
 * @since JDK 1.8
 */
@TableName("zt_user")
public class User implements Serializable {

    private static final long serialVersionUID = -6583182683789324264L;

    @TableId("id")
    private Integer id;

    @TableField("account")
    private String account;

    @TableField("realname")
    private String realname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
