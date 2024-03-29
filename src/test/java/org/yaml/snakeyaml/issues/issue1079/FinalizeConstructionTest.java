/**
 * Copyright (c) 2008, SnakeYAML
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.yaml.snakeyaml.issues.issue1079;

import org.junit.Test;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;

import static org.junit.Assert.assertEquals;

/**
 * https://bitbucket.org/snakeyaml/snakeyaml/issues/1079
 */
public class FinalizeConstructionTest {
  @Test
  public void finalizeConstruction() {
    Yaml yaml = new Yaml();
    yaml.addTypeDescription(new TypeDescription(String.class) {
      @Override
      public Object finalizeConstruction(Object obj) {
        return "b";
      }
    });
    assertEquals("b", yaml.loadAs("\"a\"", String.class));
  }
}
