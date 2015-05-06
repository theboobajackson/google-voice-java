# Introduction #

The Maven branch provides an example of automating the project build, allowing it to be built outside the Eclipse IDE.

Using Maven removes the need for libraries, Javadocs, and Eclipse files to be in Subversion.<br>
Libraries are managed as dependencies in the project pom.xml, downloaded by Maven to the local repository.<br>
Javadocs can be generated by a Maven plugin goal, see example below.<br>
Eclipse files can be generated by a Maven plugin, see example below, or these are not needed if using m2eclipse.<br>
<br>
The project depends on the modified json library (different package name). These source files were added to Subversion.<br>
<br>
The current branch represents the fewest changes to the codebase with more extensive changes described in the future steps below.<br>
<br>
The Maven pom contains project metadata, including the version. For the branch, the working version is assumed to be 2.0 and since it is under development (non-release) the -SNAPSHOT qualifier is included (2.0-SNAPSHOT).<br>
<br>
The scm urls in the pom point to the trunk location in Subversion, instead of the Maven branch location.<br>
<br>
The end of the pom includes a profile for possibly deploying the released project artifacts to the Sonatype Maven repository and Maven central repository.<br>
<br>
<h1>Command Line Goals</h1>

These goals require <a href='http://www.oracle.com/technetwork/java/javase/downloads/index.html'>Java JDK6</a> and <a href='http://maven.apache.org/download.html'>Maven</a> (2.2.1 used here) to be installed.<br>
As specified by the Maven README, the JAVA_HOME environment variable is expected to be set to the JDK location, <br>
and the PATH environment variable is expected to include the Maven bin directory.<br>
<br>
Run the following commands from the project base directory, containing the pom.xml<br>
<br>
Build the project:<br>
<ul><li>Run: mvn clean install<br>
</li><li>The built jar is located at target/google-voice-java-2.0-SNAPSHOT.jar</li></ul>

Generate Javadocs:<br>
<ul><li>Run: mvn javadoc:javadoc<br>
</li><li>The generated HTML files are located at target/site/apidocs</li></ul>

Generate Eclipse project:<br>
<ul><li>Run: mvn eclipse:configure-workspace -Declipse.workspace=/path/to/workspace<br>
</li><li>Run: mvn eclipse:eclipse<br>
</li><li>The .project and .classpath files are generated<br>
</li><li>Each time the pom dependencies are changed, these can be updated running eclipse:eclipse</li></ul>

<h1>Future Steps</h1>
<ul><li>Remove lib and doc directories<br>
</li><li>Remove .project and .classpath files<br>
</li><li>Use Maven convention for source directory:<br>
<ul><li>The src directory could be changed to src/main/java<br>
</li><li>The source directory build property in the pom.xml can be removed<br>
</li></ul></li><li>The google-voice and json libraries can be separated:<br>
<ul><li>Change to multi-module project<br>
</li><li>Change existing pom to parent pom<br>
</li><li>Move json classes to new module directory with pom.xml<br>
</li><li>Move google-voice classes to new module directory with pom.xml, with dependency on json module<br>
</li><li>Separate jars are built for json and google-voice<br>
</li></ul></li><li>Trim dependencies if needed:<br>
<ul><li>Maven brings in transitive dependencies (icu4j, jdom, xalan, xercesImpl, xml-apis, xmlParserAPIs, xom)<br>
</li><li>Unnecessary dependencies can be excluded<br>
</li></ul></li><li>Cleanup existing test:<br>
<ul><li>The test directory could be moved to src/test/java and src/test/resources<br>
</li><li>The test class name could be changed to ManualVoiceTest, excluded from build testing as necessary<br>
</li><li>The test class package could be changed to com.techventus.server.voice<br>
</li></ul></li><li>Add junit tests to src/test/java and junit test dependency to pom.xml