package _Self.buildTypes

import _Self.vcsRoots.HttpsBbdatacenterQaTeamcityComScmDksJavaMavenJunitRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildJavaJUnitBitBucketDataCenter : BuildType({
    name = "Build: Java JUnit (BitBucket Data Center)"

    params {
        param("CSP_name", "Java Build: TeamCity")
    }

    vcs {
        root(_Self.vcsRoots.HttpsBbdatacenterQaTeamcityComScmDksJavaMavenJunitRefsHeadsMaster)
    }

    steps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
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
            vcsRootExtId = "${HttpsBbdatacenterQaTeamcityComScmDksJavaMavenJunitRefsHeadsMaster.id}"
            publisher = bitbucketServer {
                buildName = "%CSP_name%"
                authType = vcsRoot()
            }
        }
    }
})
