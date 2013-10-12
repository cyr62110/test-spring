package test.spring.web.entities;

import test.spring.helpers.MD5Util;

import java.util.Date;

public class WebMessage {

    public final static String GRAVATAR_API_URL = "http://www.gravatar.com/avatar/";

    private String gravatarUrl;
    private String message;
    private Date date;

    public WebMessage(test.spring.core.entities.Message message)
    {
        setMessage(message.getMessage());
        setDate(message.getDate());
        setEmail(message.getEmail());
    }

    private void setEmail(String email)
    {
        gravatarUrl = GRAVATAR_API_URL + MD5Util.md5Hex(email.toLowerCase());
    }

    public String getGravatarUrl() {
        return gravatarUrl;
    }

    public void setGravatarUrl(String gravatarUrl) {
        this.gravatarUrl = gravatarUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
