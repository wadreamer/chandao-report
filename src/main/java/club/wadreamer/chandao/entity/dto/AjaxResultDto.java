package club.wadreamer.chandao.entity.dto;

import java.util.HashMap;

/**
 * @author fuce
 * @ClassName: AjaxResult
 * @Description: TODO(ajax操作消息提醒)
 * @date 2018年8月18日
 */
public class AjaxResultDto extends HashMap<String, Object> {

    private static final long serialVersionUID = -4228527911405974961L;

    public AjaxResultDto() {
    }

    public static AjaxResultDto error() {
        return error(1, "操作失败");
    }

    public static AjaxResultDto error(String msg) {
        return error(500, msg);
    }

    public static AjaxResultDto error(int code, String msg) {
        AjaxResultDto json = new AjaxResultDto();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    public static AjaxResultDto success(String msg) {
        AjaxResultDto json = new AjaxResultDto();
        json.put("msg", msg);
        json.put("code", 200);
        return json;
    }

    public static AjaxResultDto success() {
        return AjaxResultDto.success("操作成功");
    }

    public static AjaxResultDto successData(int code, Object value) {
        AjaxResultDto json = new AjaxResultDto();
        json.put("code", code);
        json.put("data", value);
        return json;
    }


    @Override
    public AjaxResultDto put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
