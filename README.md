## Amper git-commit-id plugin

_Inspired by the [git-commit-id plugin for Maven](https://github.com/git-commit-id/git-commit-id-maven-plugin)_

Generates a `git.properties` file containing some information about the current project's Git repository, such as the HEAD SHA-1, the output of `git describe`, the list of tags containing the HEAD commit, etc.

### Configuration

The plugin has to be enabled and configured in a `module.yaml`. 

```yaml
plugins:
  git-commit-id-amper-plugin:
    enabled: true
    gitDirectory: ../git-commit-id-amper-plugin/testResources/testRepo/dotgit
    propertiesFile: "git.props"
    abbrevLength: 10
```

The following properties are supported:
* `gitDirectory` - the path to the `.git` folder. By default, equals to the .git directory located right below the the root of the project.
* `propertiesFile` - the name of the generated properties file. By default, it is `git.properties`.
* `abbrevLength` - the length of the abbreviated commit SHA-1. By default, it is 7.

### Generated data
```properties
git.branch= # the current branch name
git.build.host= #the hostname of the machine running the build
git.build.time=2026-02-06T21\:56\:54.67399+01\:00
git.build.user.email= # `user.email` from the git config
git.build.user.name= # `user.name` from the git config
git.closest.tag.commit.count= # the number of commits between the HEAD and the closest tag
git.closest.tag.name= # the name of the closest tag reachable from the HEAD
git.commit.author.time=2026-02-06T21\:40\:39+01\:00
git.commit.committer.time=2026-02-09T19\:19\:13+01\:00
git.commit.id=e27ece8316535149b7aa471503ed3a26c81d0e16
git.commit.id.abbrev=e27ece8316
git.commit.id.describe=t3-0-ge27ece8316 # the output of `git describe`
git.commit.id.describe-short=t3 # the shortened output of `git describe`
git.commit.message.full= # the full commit message of the HEAD commit
git.commit.message.short= # the first line of the full commit message of the HEAD commit
git.commit.time=2026-02-09T19\:19\:13+01\:00
git.commit.user.email= # `user.email` of the HEAD commit committer
git.commit.user.name= # `user.name` of the HEAD commit committer
git.dirty=true # whether the repository has uncommitted changes
git.remote.origin.url=https\://example.com/repo.git
git.tag=t3 # the name of the tag or tags of the HEAD commit, empty if the HEAD commit is not tagged
git.tags=t1,t2,t3 # the list of tags rechable from the HEAD commit
git.total.commit.count=3 # the total number of commits in the repository reachable from HEAD
```
