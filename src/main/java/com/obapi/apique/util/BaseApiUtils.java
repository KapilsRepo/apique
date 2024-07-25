package com.obapi.apique.util;

import com.obapi.apique.model.common.Constants;
import com.obapi.apique.model.common.HttpRequestHeader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseApiUtils {
    private HttpHeaders createHeaders(HttpRequestHeader httpRequestHeader) {
        List<MediaType> acceptTypes = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();

        acceptTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(acceptTypes);

        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.add(Constants.AUTHORIZATION_HEADER, httpRequestHeader.getAuthorization());
        headers.add(Constants.FINANCIAL_ID_HEADER, httpRequestHeader.getFinancialId());

        if (!StringUtils.hasLength(httpRequestHeader.getIdempotencyKey()))
            headers.set(Constants.IDEMPOTENCY_KEY_HEADER, httpRequestHeader.getIdempotencyKey());

        if (!StringUtils.hasLength(httpRequestHeader.getJwsSignature()))
            headers.set(Constants.JWS_SIGNATURE_HEADER, httpRequestHeader.getJwsSignature());

        return headers;
    }

    private HttpEntity<Object> createHttpEntity(Object entity,
    HttpHeaders httpHeaders){
        return new HttpEntity<>(entity, httpHeaders);
    }

    public HttpEntity<Object> createRequest(Object entity,
    HttpRequestHeader httpRequestHeader){
        HttpHeaders headers = createHeaders(httpRequestHeader);
        return createHttpEntity(entity, headers);
    }

    public abstract String getUri(String path);

    public abstract String createAuthorizeUrl(String consentId);
}
