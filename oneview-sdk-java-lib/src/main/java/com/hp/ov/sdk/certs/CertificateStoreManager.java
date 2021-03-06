/*******************************************************************************
 * (C) Copyright 2015 Hewlett Packard Enterprise Development LP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.hp.ov.sdk.certs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.google.common.io.BaseEncoding;
import com.hp.ov.sdk.constants.SdkConstants;
import com.hp.ov.sdk.dto.CaCert;
import com.hp.ov.sdk.dto.RabbitMqClientCert;
import com.hp.ov.sdk.exceptions.SDKCertificateException;
import com.hp.ov.sdk.exceptions.SDKErrorEnum;

public class CertificateStoreManager {

    public static SSLContext getSslContext(final RabbitMqClientCert rabbitMqClientCert, final CaCert caCert) {
        // Now initialize SSLContext with KeyStore and TrustStore.
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance(SdkConstants.SSL_VERSION);
            sslContext.init(getInitiazedKeyManager(rabbitMqClientCert).getKeyManagers(),
                    getInitiazedTrustManager(caCert.getCaCert()).getTrustManagers(), new SecureRandom());

        } catch (final NoSuchAlgorithmException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        } catch (final KeyManagementException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        }
        return sslContext;
    }

    private static KeyManagerFactory getInitiazedKeyManager(final RabbitMqClientCert certDto) {
        KeyManagerFactory kmf = null;
        Security.addProvider(new BouncyCastleProvider());
        try {
            // Read client certificate and private key.
            final byte[] encoded = BaseEncoding.base64().withSeparator("\n", 65).decode(certDto.getBase64SSLKeyData());

            final PKCS8EncodedKeySpec keySpec =
                new PKCS8EncodedKeySpec(encoded);
            final KeyFactory kf = KeyFactory.getInstance("RSA");
            final PrivateKey privateKey = kf.generatePrivate(keySpec);

            final String strClientCert = certDto.getBase64SSLCertData();
            final CertificateFactory certFactory =
                CertificateFactory.getInstance("X.509");
            final Certificate cert =
                certFactory.generateCertificate(new ByteArrayInputStream(strClientCert
                    .getBytes(StandardCharsets.UTF_8)));

            // Add both client cert and private key to the keyStore.
            final KeyStore ks = KeyStore.getInstance("jks");
            ks.load(null, "password".toCharArray());
            ks.setEntry("rabbitmq-client",
                    new KeyStore.PrivateKeyEntry(privateKey,
                                                 new Certificate[] {cert}),
                    new KeyStore.PasswordProtection("password".toCharArray()));

            kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, "password".toCharArray());
        } catch (final CertificateException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        } catch (final KeyStoreException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        } catch (final NoSuchAlgorithmException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        } catch (final IOException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        } catch (final UnrecoverableKeyException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        } catch (final InvalidKeySpecException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        }

        return kmf;
    }

    private static TrustManagerFactory getInitiazedTrustManager(final String caCert) {
        Security.addProvider(new BouncyCastleProvider());
        TrustManagerFactory tmf = null;
        try {
            final CertificateFactory certFactory =
                CertificateFactory.getInstance("X.509");

            // Add CA certificate to TrustStore.
            final KeyStore tks = KeyStore.getInstance("jks");
            tks.load(null, "password".toCharArray());
            final Certificate caCErt =
                certFactory.generateCertificate(new ByteArrayInputStream(caCert
                    .getBytes(StandardCharsets.UTF_8)));

            tks.setEntry("ca-cert",
                         new KeyStore.TrustedCertificateEntry(caCErt), null);
            tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(tks);
        } catch (final CertificateException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        } catch (final KeyStoreException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        } catch (final NoSuchAlgorithmException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        } catch (final IOException e) {
            throw new SDKCertificateException(SDKErrorEnum.certificateError,
                                              null, null, null,
                                              SdkConstants.CERTS, e);
        }

        return tmf;
    }

}
