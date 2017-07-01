/*
 * Copyright 2016 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package at.makubi.maven.plugin.avrohugger;

import org.apache.maven.execution.DefaultMavenExecutionRequest;
import org.apache.maven.execution.MavenExecutionRequest;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuilder;
import org.apache.maven.project.ProjectBuildingRequest;
import org.eclipse.aether.DefaultRepositorySystemSession;

import java.io.File;
import java.nio.file.Path;

public abstract class AbstractHarnessMojoTestCase extends AbstractMojoTestCase {

    protected Path createDir(Path path) {
        path.toFile().mkdirs();

        return path;
    }

    protected Mojo lookupMojo(Path pomPath, String goal) throws Exception {
        File pom = getTestFile(pomPath.toString());
        assertTrue(pom.exists());

        MavenExecutionRequest executionRequest = new DefaultMavenExecutionRequest();
        ProjectBuildingRequest buildingRequest = executionRequest.getProjectBuildingRequest();
        buildingRequest.setRepositorySession(new DefaultRepositorySystemSession());

        ProjectBuilder projectBuilder = lookup(ProjectBuilder.class);
        MavenProject project = projectBuilder.build(pom, buildingRequest).getProject();

        return lookupConfiguredMojo(project, goal);
    }
}