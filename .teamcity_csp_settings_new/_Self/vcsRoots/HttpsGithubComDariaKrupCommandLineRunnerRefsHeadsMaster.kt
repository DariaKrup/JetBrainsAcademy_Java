package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGithubComDariaKrupCommandLineRunnerRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/DariaKrup/command_line_runner#refs/heads/master"
    url = "https://github.com/DariaKrup/command_line_runner"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "DariaKrup"
        password = "credentialsJSON:a9f10039-e193-4665-afab-91b5b38ce930"
    }
})
