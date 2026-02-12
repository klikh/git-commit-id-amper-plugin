import org.junit.jupiter.api.Test
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.div
import kotlin.io.path.readText
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class GitCommitIdAmperPluginTest {
    @OptIn(ExperimentalPathApi::class)
    @Test
    fun test() {
        val actualPropertiesStream = GitCommitIdAmperPluginTest::class.java.classLoader.getResourceAsStream("git.props")
        assertNotNull(actualPropertiesStream, "git.props not found in classpath")
        val actualProperties = actualPropertiesStream.reader().readText().sanitizeDate()
        val expectedGitProperties = Path("..") / "git-commit-id-amper-plugin" / "testResources" / "expected.git.properties"
        assertEquals(expectedGitProperties.readText().sanitizeDate(), actualProperties)
    }

    private fun String.sanitizeDate() = this
        .replace(Regex("git.build.time=.*"), "git.build.time=<TIME>")
        .replace(Regex("#.*"), "#<TIME>")

}