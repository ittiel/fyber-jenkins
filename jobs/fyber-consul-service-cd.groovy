package jobs

pipelineJob('fyber-consul-service-cd') {

    def repo = 'https://github.com/ittiel/fyber-consul-service.git'

    description("Pipeline for $repo")

    definition {
        cpsScm {
            scm {
                git {
                    remote { url(repo) }
                    branches('main')
                    scriptPath('Jenkinsfile-CD')
                    extensions { }  // required as otherwise it may try to tag the repo, which you may not want
                }

            }
        }
    }
}


