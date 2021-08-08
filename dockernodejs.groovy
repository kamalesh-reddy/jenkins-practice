job('eNodejs-Docker') {
    scm {
        git('https://github.com/kamalesh-reddy/NodeJS-Jenkins.git') { node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('kamalesh reddy')
            node / gitConfigEmail('kamaleshreddy.v@gmail.com')
        }
    }
    triggers {
        githubPush()
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('reddysdocker/nodejs-jenkins')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}