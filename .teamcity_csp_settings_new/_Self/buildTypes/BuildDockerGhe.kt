package _Self.buildTypes

import _Self.vcsRoots.HttpsGheQaTeamcityComDariaKrupkina2sampleDockerfileRefsHeadsMain
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildDockerGhe : BuildType({
    name = "Build: Docker (GHE)"

    vcs {
        root(_Self.vcsRoots.HttpsGheQaTeamcityComDariaKrupkina2sampleDockerfileRefsHeadsMain)
    }

    triggers {
        vcs {
            branchFilter = "+:<default>"
        }
    }

    features {
        perfmon {
        }
        commitStatusPublisher {
            vcsRootExtId = "${HttpsGheQaTeamcityComDariaKrupkina2sampleDockerfileRefsHeadsMain.id}"
            publisher = github {
                statusCheckName = "Build: Docker"
                githubUrl = "https://api.github.com"
                authType = vcsRoot()
            }
        }
    }
})
