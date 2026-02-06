import java.util.Properties

class Main {
}

fun main() {
    val props = Properties()
    Main::class.java.classLoader.getResourceAsStream("git.properties").use { input ->
        if (input != null) {
            props.load(input)
            println("Branch: " + props.getProperty("git.branch"))
            println("Commit ID: " + props.getProperty("git.commit.id"))
            println("Build Time: " + props.getProperty("git.build.time"))
        } else {
            System.err.println("No git properties found")
        }
    }
}