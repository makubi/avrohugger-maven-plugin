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

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(name = "generate-scala-sources")
public class GeneratorMojo extends AbstractMojo {

    @Parameter(property = "sourceDirectory", defaultValue = "${basedir}/src/main/avro", required = true)
    private File sourceDirectory;

    @Parameter(property = "outputDirectory", defaultValue = "${project.build.directory}/generated-sources/avro", required = true)
    private File outputDirectory;

    @Parameter(property = "recursive", defaultValue = "false", required = true)
    private Boolean recursive;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        String sourceDirectoryPath = sourceDirectory.getAbsolutePath();
        if(!sourceDirectory.isDirectory()) {
            throw new MojoExecutionException(sourceDirectoryPath + " does not exist or is not a directory");
        }

        String outputDirectoryPath = outputDirectory.getAbsolutePath();
        getLog().info("Generating Scala files for schemas in " + sourceDirectoryPath + " to " + outputDirectoryPath);

        AvrohuggerGenerator generator = new AvrohuggerGenerator();
        generator.generateScalaFiles(sourceDirectory, outputDirectoryPath, getLog(), recursive);
    }
}
