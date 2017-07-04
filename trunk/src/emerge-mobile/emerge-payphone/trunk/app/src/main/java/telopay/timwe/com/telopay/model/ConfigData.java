package telopay.timwe.com.telopay.model;

import org.json.JSONArray;

public class ConfigData
{
    private int sendErrorsToOCS;

    private String[] creditButtons;

    private String preferredMSISDN;

    private int keepAliveInterval;

    private boolean silenceMode;

    public int getSendErrorsToOCS() {
        return sendErrorsToOCS;
    }

    public void setSendErrorsToOCS(int sendErrorsToOCS) {
        this.sendErrorsToOCS = sendErrorsToOCS;
    }

    public String[] getCreditButtons ()
    {
        return creditButtons;
    }

    public void setCreditButtons (String[] creditButtons)
    {
        this.creditButtons = creditButtons;
    }

    public String getPreferredMSISDN() {
        return preferredMSISDN;
    }

    public void setPreferredMSISDN(String preferredMSISDN) {
        this.preferredMSISDN = preferredMSISDN;
    }

    public boolean isSilenceMode() {
        return silenceMode;
    }

    public int getKeepAliveInterval() {
        return keepAliveInterval;
    }

    public void setKeepAliveInterval(int keepAliveInterval) {
        this.keepAliveInterval = keepAliveInterval;
    }

    public boolean getSilenceMode ()
    {
        return silenceMode;
    }

    public void setSilenceMode (boolean silenceMode)
    {
        this.silenceMode = silenceMode;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sendErrorsToOCS = "+sendErrorsToOCS+", creditButtons = "+creditButtons+", defaultLanguage = "+", keepAliveInterval = "+keepAliveInterval+", silenceMode = "+silenceMode+"]";
    }
}