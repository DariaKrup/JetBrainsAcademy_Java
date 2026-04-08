package _Self.buildTypes

import _Self.vcsRoots.HttpsDariaKrupkinaBitbucketOrgTeamcityTestSampleMavenAppRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildMavenAppBitBucketCloud : BuildType({
    name = "Build: maven app (BitBucket Cloud)"

    vcs {
        root(_Self.vcsRoots.HttpsDariaKrupkinaBitbucketOrgTeamcityTestSampleMavenAppRefsHeadsMaster)
    }

    steps {
        maven {
            id = "Maven2"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            mavenVersion = bundled_3_9()
            jdkHome = "%env.JDK_11_0%"
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
            vcsRootExtId = "${HttpsDariaKrupkinaBitbucketOrgTeamcityTestSampleMavenAppRefsHeadsMaster.id}"
            publisher = bitbucketCloud {
                buildName = "CSP: updated name"
                authType = vcsRoot()
            }
        }
    }
})
