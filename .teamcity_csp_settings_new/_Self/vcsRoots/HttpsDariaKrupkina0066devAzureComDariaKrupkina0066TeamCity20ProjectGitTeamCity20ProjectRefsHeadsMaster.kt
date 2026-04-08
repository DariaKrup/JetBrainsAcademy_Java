package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitTeamCity20ProjectRefsHeadsMaster : GitVcsRoot({
    name = "https://DariaKrupkina0066@dev.azure.com/DariaKrupkina0066/TeamCity%20Project/_git/TeamCity%20Project#refs/heads/master"
    url = "https://DariaKrupkina0066@dev.azure.com/DariaKrupkina0066/TeamCity%20Project/_git/TeamCity%20Project"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "dkrupkina"
        password = "credentialsJSON:c1b26c56-f1e3-4c53-8a8d-178fc8512542"
    }
})
