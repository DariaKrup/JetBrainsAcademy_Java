package _Self.buildTypes

import _Self.vcsRoots.Http101289311jetbrainsJavaMavenJunitRefsHeadsMaster
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.remoteParameters.hashiCorpVaultParameter
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object BuildJavaGitLabCe : BuildType({
    name = "Build: Java (GitLab CE)"

    params {
        hashiCorpVaultParameter {
            name = "vault_parameter"
            query = "aws_v1/aws_access!/AWS_SECRET_ACCESS_KEY"
            vaultId = "Vault"
            param("buildTypeId", "CSPConfiguration_BuildJavaGitLabCe")
        }
    }

    vcs {
        root(_Self.vcsRoots.Http101289311jetbrainsJavaMavenJunitRefsHeadsMaster)
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
            vcsRootExtId = "${Http101289311jetbrainsJavaMavenJunitRefsHeadsMaster.id}"
            publisher = gitlab {
                jobName = "TeamCity: use CSP"
                gitlabApiUrl = "http://10.128.93.11/api/v4"
                authType = storedToken {
                    tokenId = "tc_token_id:CID_7075199182e3b1a61fd3483ceb273d98:1:621d3883-9fd6-40c3-989f-25f6565cfc28"
                }
            }
        }
    }
})
