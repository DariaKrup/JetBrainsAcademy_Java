package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsDariaKrupkina0066devAzureComDariaKrupkina0066TeamCity20ProjectGitTeamCity20ProjectRefsHeadsMaster1 : GitVcsRoot({
    name = "https://DariaKrupkina0066@dev.azure.com/DariaKrupkina0066/TeamCity%20Project/_git/TeamCity%20Project#refs/heads/master (1)"
    url = "https://DariaKrupkina0066@dev.azure.com/DariaKrupkina0066/TeamCity%20Project/_git/TeamCity%20Project"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = token {
        userName = "Daria.Krupkina@jetbrains.com"
        tokenId = "tc_token_id:CID_049968f7e913a40f7d00bed4721dabb3:1:ff78ff60-25ea-4048-afb4-cffe425042cd"
    }
    param("tokenType", "refreshable")
})
