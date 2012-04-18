package org.apache.maven.plugins.enforcer;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.maven.model.Contributor;
import org.apache.maven.project.MavenProject;

/**
 * This rule checks that certain roles are defined for contributors.
 *
 * @author Mirko Friedenhagen
 */
public class RequireContributorRoles extends AbstractRequireRoles
{

    @Override
    protected final String getRoleName()
    {
        return "contributors";
    }

    @SuppressWarnings( "unchecked" )
    @Override
    protected final Set<String> rolesFromMaven( MavenProject mavenProject )
    {
        final HashSet<String> result = new HashSet<String>();
        for ( final Contributor contributor : (List<Contributor>) mavenProject.getContributors() )
        {
            List<String> roles = contributor.getRoles();
            for ( String role : roles )
            {
                result.add( role );
            }
        }
        return result;
    }
}