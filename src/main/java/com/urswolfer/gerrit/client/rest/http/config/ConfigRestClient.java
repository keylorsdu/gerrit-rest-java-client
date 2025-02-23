/*
 * Copyright 2013-2015 Urs Wolfer
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.urswolfer.gerrit.client.rest.http.config;

import com.google.gerrit.extensions.api.config.Config;
import com.google.gerrit.extensions.api.config.Server;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.google.gson.JsonObject;
import com.urswolfer.gerrit.client.rest.http.GerritRestClient;

/**
 * @author Urs Wolfer
 */
public class ConfigRestClient extends Config.NotImplemented implements Config {
    private final GerritRestClient gerritRestClient;

    public ConfigRestClient(GerritRestClient gerritRestClient) {
        this.gerritRestClient = gerritRestClient;
    }

    @Override
    public Server server() {
        return new ServerRestClient(gerritRestClient);
    }

    @Override
    public void flushCache() throws RestApiException {
        String url = "/config/server/caches/";
        JsonObject o = new JsonObject();
        o.addProperty("operation", "FLUSH_ALL");
        gerritRestClient.postRequest(url, o.toString());
    }
}
