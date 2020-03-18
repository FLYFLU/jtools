package com.yyou.tools.controller.sample;


import com.yyou.data.CustomResponse;
import com.yyou.tools.exception.BizException;
import com.yyou.tools.exception.HttpRequestException;
import com.yyou.tools.exception.NotFoundException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exception")
@Api(description = "自定义异常返回")
public class CustomerExceptionController {

    @GetMapping("biz")
    @ResponseBody
    public CustomResponse getBizException()
        throws BizException{
        throw new BizException("biz");
    }

    @GetMapping("httpRequest")
    public CustomResponse getHttpRequestException()
            throws HttpRequestException {
        throw new HttpRequestException(400);
    }

    @GetMapping("notFound")
    public CustomResponse getNotFoundException()
            throws NotFoundException {
        throw new NotFoundException("biz");
    }

    @GetMapping("exception")
    public CustomResponse getException()
            throws Exception{
        throw new IllegalArgumentException("inner");
    }

    @GetMapping()
    public CustomResponse<String> normal(){
        return new CustomResponse<>(200,"test");
    }
}
