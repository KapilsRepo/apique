package com.obapi.apique.configuration;


import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class SecurityContext {
//    @Autowired
//    private SecurityConfig securityConfig;
//
//    public RestTemplate securedRestTemplateWithMatls() throws IOException, KeyStoreException,
//            CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {
//
//        KeyStore keyStore = KeyStore.getInstance(securityConfig.getKeyStoreType());
//        keyStore.load(new FileInputStream(ResourceUtils.getFile(securityConfig.getKeyStoreLocation())),
//                securityConfig.getKeyStorePassword().toCharArray());
//
//        SSLContext sslContext = SSLContextBuilder.create()
//                .loadKeyMaterial(keyStore, securityConfig.getKeyStorePassword().toCharArray())
//                .loadTrustMaterial(ResourceUtils.getFile(securityConfig.getTrustStoreLocation()),
//                        securityConfig.getTrustStorePassword().toCharArray())
//                .build();
//
//        HttpClient client = HttpClientBuilder
//                .create()
//                .useSystemProperties()
//                .setSSLContext(sslContext)
//                .build();
//
//        ClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        return new RestTemplate(clientHttpRequestFactory);
//    }
//
//    public RestTemplate securedRestTemplate() throws Exception{
//        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
//
//        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
//                .loadTrustMaterial(null, acceptingTrustStrategy)
//                .build();
//
//        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
//
//        CloseableHttpClient httpClient = HttpClients.custom().useSystemProperties()
//                .setSSLSocketFactory(csf)
//                .build();
//
//        HttpComponentsClientHttpRequestFactory requestFactory =
//                new HttpComponentsClientHttpRequestFactory();
//
//        requestFactory.setHttpClient(httpClient);
//        return new RestTemplate(requestFactory);
//    }


}
