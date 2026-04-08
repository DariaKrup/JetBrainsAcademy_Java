package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildOldContextProperty : BuildType({
    name = "Build: old context property"

    params {
        param("teamcity.commitStatusPublisher.githubContext", "Parameter Context: CSP")
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            name = "Java: build and run"
            id = "Java_build_and_run"
            workingDir = "easy"
            scriptContent = """
                javac ./SimpleBot.java
                java ./SimpleBot.java
            """.trimIndent()
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
            vcsRootExtId = "${DslContext.settingsRoot.id}"
            publisher = github {
                statusCheckName = "Build Feature: CSP"
                githubUrl = "https://api.github.com"
                authType = vcsRoot()
            }
        }
    }
})
