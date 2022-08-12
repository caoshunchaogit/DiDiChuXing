package com.csc.apipassenger.interceport;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.csc.dto.ResponseResult;
import com.csc.util.JwtUtils;
import com.sun.javafx.geom.transform.SingularMatrixException;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @program: 这是测试类
 * @description:
 * @author: 曹顺超
 * @create: 2022-08-12 09:48
 **/
public class JwtInterceport implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Boolean result = true;
        String resultStr = "";
        //获取token
        String token = request.getHeader("Authorization");
        //验证Token
        try {
            JwtUtils.parseToken(token);
        }catch (SignatureVerificationException e){
            resultStr = "token sign error";
            result = false;
        }catch (TokenExpiredException e){
            resultStr = "token time out";
            result = false;
        }catch (AlgorithmMismatchException e){
            resultStr = "token AlgorithmMismatchException";
            result = false;
        }catch (Exception e){
            resultStr = "token invalid";
            result = false;
        }

        if(!result){
            PrintWriter writer = response.getWriter();
            writer.println(JSONObject.fromObject(ResponseResult.fail(request)).toString());
        }

        return true;
    }
}
