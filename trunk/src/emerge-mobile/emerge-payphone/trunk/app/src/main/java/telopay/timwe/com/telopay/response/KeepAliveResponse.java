package telopay.timwe.com.telopay.response;

import telopay.timwe.com.telopay.model.ConfigData;

/**
 * Created by timwe.tunji on 10/13/2016.
 */
public class KeepAliveResponse {

    private ConfigData configData;

    public ConfigData getConfigData() {
        return configData;
    }

    public void setConfigData(ConfigData configData) {
        this.configData = configData;
    }
}
