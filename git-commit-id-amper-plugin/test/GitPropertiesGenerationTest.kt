import org.amper.gitcommitid.generateGitProperties
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.nio.file.Files
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.copyToRecursively
import kotlin.io.path.div
import kotlin.io.path.exists
import kotlin.io.path.moveTo
import kotlin.io.path.readText
import kotlin.io.path.toPath
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GitPropertiesGenerationTest {

    @OptIn(ExperimentalPathApi::class)
    @Test
    fun test() {
        val url = this.javaClass.classLoader.getResource("testRepo") ?: error("testRepo not found")
        val testRepo = url.toURI().toPath()

        val tempDir = Files.createTempDirectory("git-commit-id-amper-plugin-test-")
        val actualGitProperties = tempDir / "git.properties"

        generateGitProperties(testRepo / "dotgit", actualGitProperties)

        assertTrue(actualGitProperties.exists()) {
            "git.properties file not generated"
        }
        val expectedGitProperties = Path("") / "testResources" / "expected.git.properties"
        assertEquals(expectedGitProperties.readText().sanitizeDate(), actualGitProperties.readText().sanitizeDate())
    }

    private fun String.sanitizeDate() = this
        .replace(Regex("git.build.time=.*"), "git.build.time=<TIME>")
        .replace(Regex("#.*"), "#<TIME>")
}
