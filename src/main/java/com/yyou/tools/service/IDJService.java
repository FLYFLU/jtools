package com.yyou.tools.service;

import com.yyou.data.HttpMessage;
import com.yyou.tools.dao.IDJUserDao;
import com.yyou.tools.entity.IDJUser;
import com.yyou.tools.exception.BizException;
import com.yyou.tools.exception.HttpRequestException;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@ConfigurationProperties(prefix = "spring.idj.login")
@Service
public class IDJService implements IIdjService {

    @Autowired
    private IDJUserDao idjUserDao;

    @Scheduled(cron = "0 15 8 ? * *")
    private void autoLogin(){
        loginSafe(this.username,this.password);
    }
    private void loginSafe(String username,String password){
        try{
            login(username,password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Scheduled(cron = "0 30 8 ? * *")
    private void autoLoginAll(){
        List<IDJUser> userList = idjUserDao.getAll();
        for (IDJUser user : userList){
            loginSafe(user.getIdcard(),user.getPassword());
        }
    }

    private String loginInternal(String username, String password)
            throws HttpRequestException,IOException {
        String homeStr = getLoginInputs();
        String viewState = homeStr.split("__VIEWSTATE")[2].split("\"")[2];
        String viewStateGenerator = "37F84E62";
        String eventValidation = homeStr.split("__EVENTVALIDATION")[2].split("\"")[2];
        String content = buildJson(username,password,viewState,viewStateGenerator,eventValidation);
        String loginResult =  sendLoginRequest(content);
        return  loginResult;
    }

    private String sendLoginRequest(String content)
            throws HttpRequestException,IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(IDJ_BASE_URL);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Mobile Safari/537.36");
        httpPost.setEntity(new StringEntity(content));
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpPost);
            int httpStatusCode = httpResponse.getStatusLine().getStatusCode();
              if (httpStatusCode == HttpStatus.SC_OK) {
                String strResult = EntityUtils.toString(httpResponse.getEntity());
                return strResult;
            } else {
                throw new HttpRequestException(httpStatusCode);
            }

        } catch (Exception ex){
            throw ex;
        } finally {
            if (httpResponse != null) {
                httpResponse.close();
            }
            httpClient.close();
        }
    }

    private String buildJson(String username,String password,String viewState,String viewStateGenerator,String eventValidation){
        StringBuilder sb = new StringBuilder();
        sb.append("sm");
        sb.append("=");
        sb.append("sm|btnLogin");
        sb.append("&");
        sb.append("__EVENTTARGET");
        sb.append("=");
        sb.append("");
        sb.append("&");
        sb.append("__EVENTARGUMENT");
        sb.append("=");
        sb.append("");
        sb.append("&");
        sb.append("__VIEWSTATE");
        sb.append("=");
        sb.append(viewState);
        sb.append("&");
        sb.append("__VIEWSTATEGENERATOR");
        sb.append("=");
        sb.append(viewStateGenerator);
        sb.append("&");
        sb.append("__EVENTVALIDATION");
        sb.append("=");
        sb.append(eventValidation);
        sb.append("&");
        sb.append("textUsername");
        sb.append("=");
        sb.append(username);
        sb.append("&");
        sb.append("textPassword");
        sb.append("=");
        sb.append(password);
        sb.append("&");
        sb.append("rememberState");
        sb.append("=");
        sb.append("on");
        sb.append("&");
        sb.append("state");
        sb.append("=");
        sb.append(-1);
        sb.append("&");
        sb.append("hfdPlatform");
        sb.append("=");
        sb.append("Android");
        sb.append("&");
        sb.append("UserId");
        sb.append("=");
        sb.append("");
        sb.append("&");
        sb.append("Nonce");
        sb.append("=");
        sb.append("");
        sb.append("&");
        sb.append("Nonce");
        sb.append("=");
        sb.append("");
        sb.append("&");
        sb.append("Timestamp");
        sb.append("=");
        sb.append("");
        sb.append("&");
        sb.append("Sign");
        sb.append("=");
        sb.append("");
        sb.append("&");
        sb.append("IsFirst");
        sb.append("=");
        sb.append("1");
        sb.append("&");
        sb.append("__ASYNCPOST");
        sb.append("=");
        sb.append("true");
        sb.append("&");
        sb.append("btnLogin");
        sb.append("=");
        sb.append("");
        return sb.toString();
    }

    private String getLoginInputs()
            throws HttpRequestException,IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(IDJ_BASE_URL);
        CloseableHttpResponse httpResponse = null;
        String message = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            int httpStatusCode = httpResponse.getStatusLine().getStatusCode();
            if (httpStatusCode == HttpStatus.SC_OK) {
                String strResult = EntityUtils.toString(httpResponse.getEntity());
                message = strResult;
            } else {
                throw new HttpRequestException(httpStatusCode);
            }

        } finally {
            if (httpResponse != null) {
                httpResponse.close();
            }
            httpClient.close();
        }
        return message;
    }


    @Override
    public String login(String username, String password)
            throws HttpRequestException,IOException{
        try {
            String result =  loginInternal(username, password);
            logger.info(result);
            return result;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private static Logger logger = LoggerFactory.getLogger(IDJService.class);

    private final String IDJ_BASE_URL = "https://idj.wh.cn/webApp/Index.aspx";

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
