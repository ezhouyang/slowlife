/**
 * slowlife.mobi.
 * Copyright (c) 2013 All Rights Reserved.
 */
package com.slowlife.core.domain.qiniu;

import org.json.JSONException;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;

/**
 * 
 * @author 156768892@qq.com
 * @version $Id: QiniuConfig.java, v 0.1 2013年10月4日 下午7:28:50 eZhouyang Exp $
 */
public class QiniuConfig {

    public static String getUpToken() {
        Config.ACCESS_KEY = "<WkbWL8uXDUjq8olAaFgWVci5o1Y3WMwQ5rzC8DSk>";
        Config.SECRET_KEY = "<DANpG_GSMEIM8-VpNpHLUQuRXJHgexdclBO5KfYn>";
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        // 请确保该bucket已经存在
        String bucketName = "slowlife";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        putPolicy.returnUrl = "";
        String uptoken = null;
        try {
            uptoken = putPolicy.token(mac);
        } catch (AuthException e) {
        } catch (JSONException e) {
        }
        return uptoken;
    }

}
