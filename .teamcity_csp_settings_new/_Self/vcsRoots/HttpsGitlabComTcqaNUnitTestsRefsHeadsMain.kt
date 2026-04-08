package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGitlabComTcqaNUnitTestsRefsHeadsMain : GitVcsRoot({
    name = "https://gitlab.com/tcqa_/NUnitTests#refs/heads/main"
    url = "https://gitlab.com/tcqa_/NUnitTests"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = token {
        userName = "oauth2"
        tokenId = "tc_token_id:CID_7e81d6fa8dde83e40639722fbfc63709:1:66e49137-fb1d-4be0-bd08-6431a5ef55c5"
    }
    param("tokenType", "refreshable")
})
