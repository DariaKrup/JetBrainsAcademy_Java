package _Self.buildTypes

import _Self.vcsRoots.HttpGitlabvcsQaTeamcityComContextTestDanilaGroup1simplepr1refsHeadsMain
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildSimpleGitLabEe : BuildType({
    name = "Build: simple (GitLab EE)"

    vcs {
        root(_Self.vcsRoots.HttpGitlabvcsQaTeamcityComContextTestDanilaGroup1simplepr1refsHeadsMain)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "less ./main.txt"
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
        commitStatusPublisher {
            vcsRootExtId = "${HttpGitlabvcsQaTeamcityComContextTestDanilaGroup1simplepr1refsHeadsMain.id}"
            publisher = gitlab {
                jobName = "TeamCity status: CSP"
                gitlabApiUrl = "http://gitlabvcs.qa.teamcity.com/context/test/api/v4"
                authType = vcsRoot()
            }
        }
    }
})
