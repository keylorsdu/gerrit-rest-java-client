// Copyright (C) 2015 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.extensions.api.config;

import com.google.gerrit.extensions.restapi.NotImplementedException;
import com.google.gerrit.extensions.restapi.RestApiException;

public interface Config {
    /** @return An API for getting server related configurations. */
    Server server();

    /**
     * flush all cache in server
     * 
     * @throws RestApiException
     **/
    void flushCache() throws RestApiException;

    /**
     * A default implementation which allows source compatibility when adding new methods to the interface.
     */
    class NotImplemented implements Config {
        @Override
        public Server server() {
            throw new NotImplementedException();
        }

        @Override
        public void flushCache() throws RestApiException {
            // TODO Auto-generated method stub

        }
    }
}
