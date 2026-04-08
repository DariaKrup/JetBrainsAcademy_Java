package _Self.buildTypes

import _Self.vcsRoots.HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitTeamCity20ProjectRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildAzureDevOpsPat : BuildType({
    name = "Build: Azure DevOps PAT"

    vcs {
        root(_Self.vcsRoots.HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitTeamCity20ProjectRefsHeadsMaster)
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
            vcsRootExtId = "${HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitTeamCity20ProjectRefsHeadsMaster.id}"
            publisher = azureDevOps {
                buildName = "Azure from TeamCity: build"
                authType = personalToken {
                    accessToken = "credentialsJSON:c1b26c56-f1e3-4c53-8a8d-178fc8512542"
                }
            }
        }
    }
})
