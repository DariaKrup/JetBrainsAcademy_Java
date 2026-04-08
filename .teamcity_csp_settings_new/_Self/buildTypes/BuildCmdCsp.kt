package _Self.buildTypes

import _Self.vcsRoots.HttpsGithubComDariaKrupCommandLineRunnerRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildCmdCsp : BuildType({
    name = "Build: cmd + CSP"

    params {
        param("custom_parameter", "CuStOm")
    }

    vcs {
        root(_Self.vcsRoots.HttpsGithubComDariaKrupCommandLineRunnerRefsHeadsMaster)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "sh echo.sh"
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
            vcsRootExtId = "${HttpsGithubComDariaKrupCommandLineRunnerRefsHeadsMaster.id}"
            publisher = github {
                statusCheckName = "CSP settings: %build.number% + %custom_parameter%"
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:a9f10039-e193-4665-afab-91b5b38ce930"
                }
            }
        }
    }
})
