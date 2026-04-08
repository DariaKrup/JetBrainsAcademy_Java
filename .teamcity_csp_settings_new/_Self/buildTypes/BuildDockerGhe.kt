package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
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
    }
})
