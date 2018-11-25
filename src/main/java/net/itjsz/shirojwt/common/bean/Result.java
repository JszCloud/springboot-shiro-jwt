package net.itjsz.shirojwt.common.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by fenggang on 18/5/24.
 * 返回实体
 * @author fenggang
 * @date 18/5/24
 */
@ApiModel
@Data
@EqualsAndHashCode(callSuper = false)
public class Result<T> implements Serializable {

    @ApiModelProperty(value="接口返回code(只有200为正常返回)")
    private Integer code;
    @ApiModelProperty(value="接口返回message(只有非200时返回)")
    private String message;
    @ApiModelProperty(value="接口返回数据实体")
    private T data;

    public static Result<?> clone(String message, Integer code, Object object){
        return new Result(message, code, object);
    }

    public Result(String message, Integer code, T object) {
        super();
        this.message = message;
        this.code = code;
        this.data = object;
    }

    public Result(T object) {
        super();
        this.code = 200;
        this.data = object;
    }
    public void jsonFill(int code, String errorMsg, T data) {
        this.code = code;
        this.message = errorMsg;
        this.data = data;
    }

    public Result() {
        this.code = 200;
    }

}
