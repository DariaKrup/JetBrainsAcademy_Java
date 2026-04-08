package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGheQaTeamcityComDariaKrupkina2sampleDockerfileRefsHeadsMain : GitVcsRoot({
    name = "https://ghe.qa.teamcity.com/daria-krupkina2/sample-dockerfile#refs/heads/main"
    url = "https://ghe.qa.teamcity.com/daria-krupkina2/sample-dockerfile"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "daria-krupkina2"
        password = "credentialsJSON:a6444a8a-3b21-4a51-a17b-a02020c36b46"
    }
})
