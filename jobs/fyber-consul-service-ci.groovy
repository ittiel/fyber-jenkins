pipelineJob('fyber-consul-service-ci') {

    def repo = 'https://github.com/ittiel/fyber-consul-service.git'

    triggers {
        scm('* * * * *')
    }
    description("Pipeline for $repo")

    definition {
        cpsScm {
            scm {
                git {
                    remote { url(repo) }
                    branches('main')
                    scriptPath('Jenkinsfile-CI')
                    extensions { }  // required as otherwise it may try to tag the repo, which you may not want
                }

            }
        }
    }
}

