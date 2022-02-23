import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertTrue

class TestHello extends BasePipelineTest {

    @Override
    @BeforeEach
    void setUp() throws Exception {
        scriptRoots += "vars"
        super.setUp()
        binding.setVariable("USER_ID", "zhang.yidong")
    }

    @DisplayName("Test simplest case")
    @Test
    void test_hello() {
        def hello = loadScript("hello.groovy")
        def res = hello()
        assertEquals("Hello world", res)
    }

    @DisplayName("Test function with arguments")
    @Test
    void test_greeting() {
        def hello = loadScript("hello.groovy")
        def res = hello.greeting("zyd")
        assertTrue("Hello zyd" == res)
    }

    @DisplayName("Test with env variables")
    @Test
    void test_warmGreeting() {
        def hello = loadScript("hello.groovy")
        def res = hello.warmGreeting()
        assertTrue("Hello zhang.yidong" == res)
    }
}
