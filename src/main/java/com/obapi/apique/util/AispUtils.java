package com.obapi.apique.util;

import com.obapi.apique.configuration.AispConfig;
import com.obapi.apique.configuration.ClientConfig;

public class AispUtils extends BaseApiUtils {
    private final ClientConfig clientConfig;
    private final AispConfig aispConfig;

    public AispUtils(AispConfig aispConfig, ClientConfig clientConfig) {
        this.aispConfig = aispConfig;
        this.clientConfig = clientConfig;
    }

    @Override
    public String getUri(String path) {
        return String.format("%s%s%s", aispConfig.getAispBaseUri() ,aispConfig.getAispContext(), path);
    }

    @Override
    public String createAuthorizeUrl(String consentId)  {
        return String.format("%s?client_id=%s&response_type=code id_token&scope=openid accounts&redirect_uri=%s&state=%s&request=%s",
                aispConfig.getAispAudience(),
                clientConfig.getClientId(),
                clientConfig.getRedirectUri(),
                clientConfig.getClientState(),
                consentId);
    }

}
