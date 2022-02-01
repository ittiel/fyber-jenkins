import jenkins.model.*
import hudson.security.*

import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.plugin.JenkinsJobManagement

def env = System.getenv()

def jenkins = Jenkins.getInstance()

// Setup number of executors
Jenkins.instance.setNumExecutors(3)


//todo: make it more dynamic
// Create initial jobs
def jobDslScript = new File('/tmp/fyber-consul-service-ci.groovy')
def workspace = new File('/tmp/fyber-consul-service-ci')
def jobManagementci = new JenkinsJobManagement(System.out, [:], workspace)


// Run the jobs to create some test results
new DslScriptLoader(jobManagementci).runScript(jobDslScript.text)

def serviceJobDslScript = new File('/tmp/fyber-consul-service-cd.groovy')
def serviceWorkspace = new File('/tmp/fyber-consul-service-cd')
def serviceJobManagement = new JenkinsJobManagement(System.out, [:], serviceWorkspace)
new DslScriptLoader(serviceJobManagement).runScript(serviceJobDslScript.text)
