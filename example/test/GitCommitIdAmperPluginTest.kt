import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.io.path.*
import kotlin.test.assertEquals

class GitCommitIdAmperPluginTest {
    @OptIn(ExperimentalPathApi::class)
    @Test
    fun test() {
        val fileName = "git.props"
        val actualGitProperties = (Path("..") / "build" / "artifacts" / "CompiledJvmArtifact" / "examplejvm" / "resources-output" / fileName).absolute().normalize()
        assertTrue(actualGitProperties.exists()) {
            "$actualGitProperties file not generated"
        }
        val expectedGitProperties = Path("..") / "git-commit-id-amper-plugin" / "testResources" / "expected.git.properties"
        assertEquals(expectedGitProperties.readText().sanitizeDate(), actualGitProperties.readText().sanitizeDate())
    }

    private fun String.sanitizeDate() = this
        .replace(Regex("git.build.time=.*"), "git.build.time=<TIME>")
        .replace(Regex("#.*"), "#<TIME>")

}