package org.amper.gitcommitid

import org.jetbrains.amper.plugins.Configurable
import java.nio.file.Path

@Configurable
interface GitCommitIdSettings {

    /**
     * The path to the git worktree.
     * By default, the project root is used.
     *
     * NB: `workTreeDir` must be specified or not specified only together with `gitDirectory`.
     */
    val worktreeDir: Path?

    /**
     * The path to the git repository, i.e. to the `.git` directory itself.
     * By default, `<PROJECT_ROOT>/.git` is used.
     *
     * NB: `workTreeDir` must be specified or not specified only together with `gitDirectory`.
     */
    val gitDirectory: Path?

    /**
     * The name of the generated properties file.
     * By default, equals to "git.properties".
     */
    val propertiesFile: String get() = "git.properties"

    /**
     * The length of the abbreviated commit ID.
     * By default, equals to 7.
     */
    val abbrevLength: Int get() = 7

}
