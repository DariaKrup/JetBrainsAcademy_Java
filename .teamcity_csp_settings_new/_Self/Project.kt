package _Self

import _Self.buildTypes.*
import _Self.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project
import jetbrains.buildServer.configs.kotlin.projectFeatures.azureDevopsConnection

object Project : Project({

    vcsRoot(HttpsDariaKrupkinaBitbucketOrgTeamcityTestSampleMavenAppRefsHeadsMaster)
    vcsRoot(HttpGitlabvcsQaTeamcityComContextTestDanilaGroup1simplepr1refsHeadsMain)
    vcsRoot(Http101289311jetbrainsJavaMavenJunitRefsHeadsMaster)
    vcsRoot(HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitTeamCity20ProjectRefsHeadsMaster1)
    vcsRoot(HttpsGithubComDariaKrupCommandLineRunnerRefsHeadsMaster)
    vcsRoot(HttpsBbdatacenterQaTeamcityComScmDksJavaMavenJunitRefsHeadsMaster)
    vcsRoot(HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitTeamCity20ProjectRefsHeadsMaster)
    vcsRoot(HttpsGitlabComTcqaNUnitTestsRefsHeadsMain)
    vcsRoot(HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitSpringPetclinicRefsHeadsMain)
    vcsRoot(HttpsGheQaTeamcityComDariaKrupkina2sampleDockerfileRefsHeadsMain)

    buildType(BuildAzureDevOpsPat)
    buildType(BuildOldContextPropertyWithoutNew)
    buildType(BuildJavaGitLabCe)
    buildType(BuildDockerGhe)
    buildType(BuildJavaJUnitBitBucketDataCenter)
    buildType(BuildSimpleGitLabEe)
    buildType(BuildAzureDevOpsEntraId)
    buildType(BuildCmdCsp)
    buildType(BuildOldContextProperty)
    buildType(BuildNUnitGitLabCom)
    buildType(BuildMavenAppBitBucketCloud)

    params {
        param("teamcity.internal.pipelines.creation.enabled", "true")
    }

    features {
        azureDevopsConnection {
            id = "PROJECT_EXT_874"
            displayName = "Local: Azure DevOps PAT"
            serverUrl = "https://dev.azure.com/DariaKrupkina0066"
            accessToken = "credentialsJSON:c1b26c56-f1e3-4c53-8a8d-178fc8512542"
        }
    }
})
