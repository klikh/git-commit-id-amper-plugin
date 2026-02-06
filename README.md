## Amper git-commit-id plugin

_Inspired by the [git-commit-id plugin for Maven](https://github.com/git-commit-id/git-commit-id-maven-plugin)_

Generates a `git.properties` file containing some information about the current HEAD of the project's Git repository, such as the HEAD SHA-1, the output of `git describe`, the list of tags containing the HEAD commit, etc.

### Configuration

The plugin has to be enabled and configured in a `module.yaml`:

```yaml
plugins:
  git-commit-id-amper-plugin:
    enabled: true
    propertiesFile: "git.props" 

```
