package com.soft1851.spring.web.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName ResponseObject
 * @Description TODO
 * @date 2020-03-20 12:05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private Integer code;
    private String msg;
    private Object data;

    public ResponseObject(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
