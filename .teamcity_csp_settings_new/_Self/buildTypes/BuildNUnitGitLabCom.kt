package _Self.buildTypes

import _Self.vcsRoots.HttpsGitlabComTcqaNUnitTestsRefsHeadsMain
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildNUnitGitLabCom : BuildType({
    name = "Build: NUnit (GitLab.com)"

    vcs {
        root(_Self.vcsRoots.HttpsGitlabComTcqaNUnitTestsRefsHeadsMain)
    }

    steps {
        dotnetTest {
            id = "dotnet"
            projects = "NUnitTests/NUnitTests.csproj"
            sdk = "8"
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
            vcsRootExtId = "${HttpsGitlabComTcqaNUnitTestsRefsHeadsMain.id}"
            publisher = gitlab {
                jobName = "TeamCity to GitLab: status"
                authType = storedToken {
                    tokenId = "tc_token_id:CID_7e81d6fa8dde83e40639722fbfc63709:1:a02c0b51-bd3d-43ae-84d8-068552520f9d"
                }
            }
        }
    }
})
