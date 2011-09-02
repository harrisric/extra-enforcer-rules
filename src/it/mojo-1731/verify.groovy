/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
File log = new File(basedir, 'build.log')
assert log.exists()
def ruleLines = log.readLines().findAll { line ->
  line.startsWith( "[DEBUG] Searching for duplicate classes in" )
}
assert ruleLines[0].endsWith( "spring-beans-2.5.6.pom" )
assert ruleLines[1].endsWith( "commons-logging-1.1.1.jar" )
assert ruleLines[2].endsWith( "spring-core-2.5.6.jar" )