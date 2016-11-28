// Copyright (C) 2016 The Android Open Source Project
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
package com.google.gerrit.extensions.api.access;

import com.google.common.base.Objects;

public class PermissionRuleInfo {
  public enum Action {
    ALLOW,
    DENY,
    BLOCK,
    INTERACTIVE,
    BATCH
  }

  public Action action;
  public Boolean force;
  public Integer min;
  public Integer max;

  public PermissionRuleInfo(Action action, Boolean force) {
    this.action = action;
    this.force = force;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof PermissionRuleInfo) {
      PermissionRuleInfo p = (PermissionRuleInfo) obj;
      return Objects.equal(action, p.action)
          && Objects.equal(force, p.force)
          && Objects.equal(min, p.min)
          && Objects.equal(max, p.max);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(action, force, min, max);
  }
}
