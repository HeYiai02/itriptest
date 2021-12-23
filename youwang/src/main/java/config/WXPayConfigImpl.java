package config;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class WXPayConfigImpl extends WXPayConfig{
    private byte[] certData;


    public String getAppID() {
        return "wxab8acb865bb1637e";
    }

    public String getMchID() {
        return "11473623";
    }



    public String getKey() {
        return "2ab9071b06b9f739b950ddb41db2690d";
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public IWXPayDomain getWXPayDomain() {
        return null;
    }
}
