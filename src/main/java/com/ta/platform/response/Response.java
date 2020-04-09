package com.ta.platform.response;

import lombok.Builder;
import lombok.Data;

/**
 * Creator: zhuji
 * Date: 8/6/2019
 * Time: 3:20 PM
 * Description:
 */
@Data
@Builder
public class Response {
    private int code;

    private String message;

    private String data;
}
