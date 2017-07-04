package telopay.timwe.com.telopay.response;

import telopay.timwe.com.telopay.model.ConfigData;

/**
 * Created by timwe.tunji on 10/11/2016.
 */

public class SessionResponse
{
    private String sessionStartTime;

    private String message;

    private String balance;

    private ConfigData configData;

    private String sessionID;

    private String accessToken;

    private String code;

    public String getSessionStartTime ()
    {
        return sessionStartTime;
    }

    public void setSessionStartTime (String sessionStartTime)
    {
        this.sessionStartTime = sessionStartTime;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getBalance ()
    {
        return balance;
    }

    public void setBalance (String balance)
    {
        this.balance = balance;
    }

    public ConfigData getConfigData ()
    {
        return configData;
    }

    public void setConfigData (ConfigData configData)
    {
        this.configData = configData;
    }

    public String getSessionID ()
    {
        return sessionID;
    }

    public void setSessionID (String sessionID)
    {
        this.sessionID = sessionID;
    }

    public String getAccessToken ()
    {
        return accessToken;
    }

    public void setAccessToken (String accessToken)
    {
        this.accessToken = accessToken;
    }

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sessionStartTime = "+sessionStartTime+", message = "+message+", balance = "+balance+", configData = "+configData+", sessionID = "+sessionID+", accessToken = "+accessToken+", code = "+code+"]";
    }
}
