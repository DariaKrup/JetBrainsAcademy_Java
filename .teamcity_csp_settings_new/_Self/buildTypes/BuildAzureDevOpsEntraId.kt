package _Self.buildTypes

import _Self.vcsRoots.HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitTeamCity20ProjectRefsHeadsMaster1
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildAzureDevOpsEntraId : BuildType({
    name = "Build: Azure DevOps Entra ID"

    vcs {
        root(_Self.vcsRoots.HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitTeamCity20ProjectRefsHeadsMaster1)
    }

    steps {
        gradle {
            id = "gradle_runner"
            tasks = "clean build"
            gradleWrapperPath = ""
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
            vcsRootExtId = "${HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitTeamCity20ProjectRefsHeadsMaster1.id}"
            publisher = azureDevOps {
                buildName = "CSP: build from TeamCity"
                authType = storedToken {
                    tokenId = "tc_token_id:CID_049968f7e913a40f7d00bed4721dabb3:1:6a0b8315-df03-4d60-a4fc-e05bb49d6b75"
                }
            }
        }
    }
})
