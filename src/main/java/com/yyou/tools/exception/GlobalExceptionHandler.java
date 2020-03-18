package com.yyou.tools.exception;

import com.yyou.data.CustomResponse;
import com.yyou.data.HttpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomResponse handleGlobalException(Exception ex){
        String message = ex.getMessage();
        logger.error(message);
        return CustomResponse.http500(message);
    }

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public CustomResponse handleBizException(BizException ex){
        String message = ex.getMessage();
        logger.error(message);
        return CustomResponse.http400(message);
    }

    @ExceptionHandler(value = HttpRequestException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public CustomResponse handleHttpRequestException(HttpRequestException ex){
        String message = ex.getMessage();
        logger.error(message);
        return CustomResponse.http400(message);
    }

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public CustomResponse handleNotFoundException(NotFoundException ex){
        String message = ex.getMessage();
        logger.error(message);
        return CustomResponse.http404(message);
    }
}
